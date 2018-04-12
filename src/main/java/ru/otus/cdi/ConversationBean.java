package ru.otus.cdi;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ConversationScoped
public class ConversationBean implements Serializable {

    @Inject
    Conversation conversation;

    public void start(){
        conversation.begin();
    }

    public void stop(){
        conversation.end();
    }
}
