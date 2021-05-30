package com.mobiquity.test.backend.steps;

import com.mobiquity.test.backend.configuration.BackendTestConfiguration;
import com.mobiquity.test.common.configuration.context.BasicContextKey;
import com.mobiquity.test.common.steps.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class BasicSteps extends BaseSteps {

    @Autowired
    private BackendTestConfiguration config;

    @When("context stores value {string}")
    public void contextStoresValue(String value) {
        scenarioContext.save(BasicContextKey.VALUE, value);
    }

    @Then("{string} value is stored in the context")
    public void contextValueIsStored(String value) {
        String ctxValue = scenarioContext.get(BasicContextKey.VALUE);
        assertThat("value is stored in context", ctxValue, is(value));
    }

    @Then("context is empty")
    public void contextIsEmpty() {
        String ctxValue = scenarioContext.get(BasicContextKey.VALUE);
        assertThat("value is not stored in context", ctxValue, is(nullValue()));
    }

    @Given("baseUrl is configured to {string}")
    public void baseUrlIsConfigured(String baseUrl) {
        assertThat("baseUrl is setup", baseUrl, is(config.getBaseUrl()));

    }
}
