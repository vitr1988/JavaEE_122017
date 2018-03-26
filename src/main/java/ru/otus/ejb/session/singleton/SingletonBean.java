package ru.otus.ejb.session.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@Startup
public class SingletonBean implements EmployeeCacheable {

    private Map<Long, String> map;

    @Resource
    TimerService timerService;

    @PostConstruct
    private void init(){
        map = new ConcurrentHashMap<>();
        timerService.createTimer(0,1000, "Every second timer with no delay");
    }

    @Override
    public void put(Long key, String name){
        map.put(key, name);
    }

    @Override
    public String get(Long key) {
        return map.get(key);
    }

    @Schedule(hour = "*", minute = "*", second = "*/5", info = "Every 5 seconds timer")
    public void automaticallyScheduled(Timer timer) {

    }

    @PreDestroy
    public void destroy() {
        map.clear();
    }
}
