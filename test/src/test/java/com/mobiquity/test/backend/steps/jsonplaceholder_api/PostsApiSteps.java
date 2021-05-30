package com.mobiquity.test.backend.steps.jsonplaceholder_api;

import com.mobiquity.domain.backend.model.Comment;
import com.mobiquity.domain.backend.model.Post;
import com.mobiquity.domain.backend.model.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.mobiquity.test.backend.configuration.context.BackendContextKey.COMMENTS;
import static com.mobiquity.test.backend.configuration.context.BackendContextKey.POSTS;
import static com.mobiquity.test.backend.configuration.context.BackendContextKey.USER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class PostsApiSteps extends BaseApiSteps {

    @When("user requests a list of posts by {string} user from jsonplaceholder API service")
    public void userRequestsAListOfPostsByUsernameUser(String username) {
        String userId = jsonplaceholderApiActions.getUserIdByUsername(username);
        List<Post> userPosts = jsonplaceholderApiActions.getPostsByUserId(userId);
        scenarioContext.save(POSTS, userPosts);
    }

    @When("user requests a list of posts by the user from jsonplaceholder API service")
    public void userRequestsAListOfPostsByTheUser() {
        User user = scenarioContext.get(USER);
        List<Post> userPosts = jsonplaceholderApiActions.getPostsByUserId(user.getId());
        scenarioContext.save(POSTS, userPosts);
    }

    @Then("a list of posts by the user is returned")
    public void aListOfPostsByTheUserIsReturned() {
        List<Post> posts = scenarioContext.get(POSTS);
        assertThat("posts list is not null", posts, is(not(nullValue())));
    }

    @Then("the list of posts is not empty")
    public void theListOfPostsIsNotEmpty() {
        List<Post> posts = scenarioContext.get(POSTS);
        assertThat("posts list is not empty", posts, is(not(empty())));
    }

    @Then("the list of posts is empty")
    public void theListOfPostsIsEmpty() {
        List<Post> posts = scenarioContext.get(POSTS);
        assertThat("posts list is empty", posts, is(empty()));
    }

    @When("comments for each post from the list of posts are requested from jsonplaceholder API service")
    public void commentsForEachPostFromTheListOfPostsAreRequested() {
        List<String> postIdList = scenarioContext.<List<Post>>get(POSTS)
                .stream()
                .map(Post::getId)
                .toList();
        List<Comment> filteredComments = jsonplaceholderApiActions.getComments()
                .stream()
                .filter(x -> postIdList.contains(x.getPostId()))
                .toList();
        scenarioContext.save(COMMENTS, filteredComments);
    }

    @Then("a list of comments for each post by the user is returned")
    public void aListOfCommentsForEachPostByTheUserIsReturned() {
        List<Comment> comments = scenarioContext.get(COMMENTS);
        assertThat("comments list is not null", comments, is(not(nullValue())));
    }

    @Then("all comments in the list of comments have valid emails")
    public void allCommentsInTheListOfCommentsHaveValidEmails() {
        List<Comment> comments = scenarioContext.get(COMMENTS);
        comments.forEach(x ->
                assertThat("email is valid", validatorActions.validateEmailPattern(x.getEmail()), is(true))
        );
    }
}
