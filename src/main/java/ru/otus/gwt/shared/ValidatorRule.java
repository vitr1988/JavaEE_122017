package ru.otus.gwt.shared;

import ru.otus.gwt.shared.model.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Objects;
import java.util.Set;

public class ValidatorRule {

    public static boolean isValid(User user){
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        return violations.isEmpty();
//        Objects.requireNonNull(user);
//        return Objects.nonNull(user.getLogin()) && Objects.nonNull(user.getPassword());
    }
}
