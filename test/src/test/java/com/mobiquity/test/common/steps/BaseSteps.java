package com.mobiquity.test.common.steps;

import com.mobiquity.test.common.configuration.context.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseSteps {

    @Autowired
    protected ScenarioContext scenarioContext;
}
