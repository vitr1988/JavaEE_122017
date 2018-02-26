package ru.otus.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class UserBean implements Serializable {
    private static final long serialVersionUID = 4629817047379532658L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String greet() {
        return null;
    }
}
