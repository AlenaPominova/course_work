package ru.vsu.amm.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import ru.vsu.amm.model.User;
import ru.vsu.amm.services.impl.UserService;

public class Validator implements org.springframework.validation.Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");

        if (user.getEmail().length() < 6 || user.getEmail().length() > 12){
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if (user.getPassword().length() < 4){
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
    }
}
