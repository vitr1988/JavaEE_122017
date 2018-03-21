package ru.otus.jaxws;

import ru.otus.jaxrs.model.User;

import javax.jws.WebService;

@WebService(endpointInterface="ru.otus.jaxws.UserService")
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(int id) {
        return new User();
    }
}
