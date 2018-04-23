package ru.otus.security.authorization.glassfish;

import com.sun.appserv.security.AppservPasswordLoginModule;
import ru.otus.security.authorization.JepPrincipal;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("rawtypes")
public class LoginModule extends AppservPasswordLoginModule {


    @Override
    protected void authenticateUser() throws LoginException {
        System.out.println("Going to Log In ............................");
        String userString = _username;

        //HERE YOU CAN GET A HANDLE TO A JDBC CONNECTION POOL IN GLASSFISH
        //FROM THE JNDI NAME, AND EXECUTE A SQL TO RETRIEVE ALL THE GROUPS
        //THE USER BELONGS TO

        String[] groups = {"ADMIN"};
        commitUserAuthentication(groups);
    }

}
