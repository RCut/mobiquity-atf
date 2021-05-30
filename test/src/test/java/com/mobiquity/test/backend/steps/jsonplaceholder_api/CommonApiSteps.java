package com.mobiquity.test.backend.steps.jsonplaceholder_api;

import io.cucumber.java.en.Given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class CommonApiSteps extends BaseApiSteps {

    @Given("jsonplaceholder API service is set up")
    public void jsonplaceholderApiServiceIsSetup() {
        assertThat("users data should be available", jsonplaceholderApiActions.getUsers(), is(not(empty())));
        assertThat("posts data should be available", jsonplaceholderApiActions.getPosts(), is(not(empty())));
        assertThat("comments data should be available", jsonplaceholderApiActions.getComments(), is(not(empty())));
    }
}
