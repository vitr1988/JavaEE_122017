package ru.otus.cdi.event;

public class MessageEvent {
    private String text;

    public MessageEvent() {
    }

    public MessageEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
