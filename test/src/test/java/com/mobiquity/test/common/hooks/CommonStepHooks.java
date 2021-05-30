package com.mobiquity.test.common.hooks;

import com.mobiquity.test.common.configuration.context.ScenarioContext;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonStepHooks {

    @Autowired
    private ScenarioContext scenarioContext;

    @Before
    public void Setup() {
        scenarioContext.clear();
    }

}
