package com.rm.inventorytracking.domain.validator;

import com.rm.inventorytracking.domain.User;
import com.rm.inventorytracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * girilen kullanıcı sistemde var mı yok mu ona bakıcaz
 */
@Component
public class RegisterValidator implements Validator {
    private final UserService userService;

    @Autowired
    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User form = (User) o;
        validateUsername(errors, form);
    }

    private void validateUsername(Errors errors, User form) {
        if (userService.getUserByUsername(form.getUsername()) != null) {
            errors.reject("username.exists", "User with this username already exists");
        }
    }
}