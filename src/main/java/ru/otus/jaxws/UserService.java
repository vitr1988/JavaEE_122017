package ru.otus.jaxws;

import ru.otus.jaxrs.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface UserService {
    @WebMethod
    User getUserById(int id);
}
