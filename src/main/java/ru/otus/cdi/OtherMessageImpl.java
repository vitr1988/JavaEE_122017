package ru.otus.cdi;

import ru.otus.cdi.qualifier.LanguageEnum;
import ru.otus.cdi.qualifier.MessageType;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

//@Alternative
@MessageType(value = LanguageEnum.RUSSIAN, description = "other message impl")
@Named("message")
@RequestScoped
public class OtherMessageImpl implements Message {
    @Override
    public String get() {
        return "Привет мир";
    }
}
