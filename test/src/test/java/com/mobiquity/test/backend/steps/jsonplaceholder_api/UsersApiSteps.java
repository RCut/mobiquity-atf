package com.mobiquity.test.backend.steps.jsonplaceholder_api;

import com.mobiquity.domain.backend.model.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.mobiquity.test.backend.configuration.context.BackendContextKey.USER;
import static com.mobiquity.test.backend.configuration.context.BackendContextKey.USERS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class UsersApiSteps extends BaseApiSteps {

    @When("user requests a user with username {string} from jsonplaceholder API service")
    public void userRequestsAUserWithUsername(String username) {
        List<User> users = jsonplaceholderApiActions.getUsersByUsername(username);
        scenarioContext.save(USERS, users);
    }

    @Then("a list of users is returned")
    public void aListOfUsersIsReturned() {
        List<User> users = scenarioContext.get(USERS);
        assertThat("users list is not null", users, is(not(nullValue())));
    }

    @Then("the list of users is empty")
    public void theListOfUsersIsEmpty() {
        List<User> users = scenarioContext.get(USERS);
        assertThat("users list is empty", users, is(empty()));
    }

    @Then("the list of users contains details of {string} user")
    public void theListOfUsersContainsDetailsOfUser(String username) {
        List<User> users = scenarioContext.get(USERS);
        var actualUser = users.stream().filter(x -> x.getUsername().equals(username)).findFirst();
        assertThat("users list contains details of " + username + " user", actualUser.isPresent(), is(true));
        scenarioContext.save(USER, actualUser);
    }
}
