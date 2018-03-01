package ru.otus.gwt.client.event.websocket;

import com.google.gwt.core.client.JavaScriptObject;

public class MessageEvent extends JavaScriptObject {

    protected MessageEvent() {

    }

    public native final String getData()/*-{
        return this.data;
    }-*/;

    public native final String getOrigin()/*-{
        return this.origin;
    }-*/;



}
