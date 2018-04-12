package ru.otus.cdi.event;

import javax.enterprise.event.Observes;
import javax.inject.Named;

@Named
public class EventObserver {

    public void log(@Observes MessageEvent message){
        System.out.println(message.getText());
    }
}
