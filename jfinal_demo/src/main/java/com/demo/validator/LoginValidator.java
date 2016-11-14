package com.demo.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * Created by Jasper on 2016/11/4.
 */
public class LoginValidator extends Validator {
    @Override
    protected void validate(Controller c) {
        validateRequiredString("username", "nameError", "username is null");
        validateRequiredString("password", "passError", "password is null");
    }

    @Override
    protected void handleError(Controller c) {

    }
}
