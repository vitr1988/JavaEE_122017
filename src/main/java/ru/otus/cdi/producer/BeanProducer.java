package ru.otus.cdi.producer;

import ru.otus.cdi.qualifier.Time;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Dependent
public class BeanProducer {

    @Time
    @Produces
    public String getCurrentDate(InjectionPoint ip){
        return DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDateTime.now());
    }

    public void close(@Disposes @Time String str) {
        str = null;
    }
}
