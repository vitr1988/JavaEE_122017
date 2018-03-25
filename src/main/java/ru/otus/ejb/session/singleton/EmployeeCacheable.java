package ru.otus.ejb.session.singleton;

import javax.ejb.Local;

@Local
public interface EmployeeCacheable {

    void put(Long key, String name);
    String get(Long key);
}
