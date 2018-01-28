package ru.otus.gwt.shared;

import ru.otus.gwt.shared.model.User;

import java.util.Objects;

public class Validator {

    public static boolean isValid(User user){
        Objects.requireNonNull(user);
        return Objects.nonNull(user.getLogin()) && Objects.nonNull(user.getPassword());
    }
}
