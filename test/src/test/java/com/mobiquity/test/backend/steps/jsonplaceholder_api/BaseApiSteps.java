package com.mobiquity.test.backend.steps.jsonplaceholder_api;

import com.mobiquity.domain.backend.actions.JsonplaceholderApiActions;
import com.mobiquity.domain.backend.actions.ValidatorActions;
import com.mobiquity.test.common.steps.BaseSteps;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseApiSteps extends BaseSteps {

    @Autowired
    protected JsonplaceholderApiActions jsonplaceholderApiActions;

    @Autowired
    protected ValidatorActions validatorActions;
}
