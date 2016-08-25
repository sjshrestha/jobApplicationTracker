/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.validator;

import mum.waa.jobapplicationtracker.model.User;
import mum.waa.jobapplicationtracker.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Dilip
 */
@Component
public class UserExistsValidator implements Validator {

    @Autowired
    private IuserService userService;

    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        if (userService.getByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "user.username.already.exists");
        }

    }
}
