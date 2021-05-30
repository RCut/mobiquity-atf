package com.mobiquity.domain.backend.actions.impl;

import com.mobiquity.domain.backend.actions.ValidatorActions;
import org.springframework.stereotype.Service;

import static com.mobiquity.domain.backend.helpers.ValidationHelper.isEmailPattern;

@Service
public class ValidatorActionsImpl implements ValidatorActions {

    @Override
    public boolean validateEmailPattern(String input) {
        return isEmailPattern(input);
    }
}
