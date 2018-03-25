package ru.otus.ejb.session.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@Startup
public class SingletonBean implements EmployeeCacheable {

    private Map<Long, String> map;

    @PostConstruct
    private void init(){
        map = new ConcurrentHashMap<>();
    }

    @Override
    public void put(Long key, String name){
        map.put(key, name);
    }

    @Override
    public String get(Long key) {
        return map.get(key);
    }

    @Remove
    public void destroy() {
        map.clear();
    }
}
