package ru.otus.gwt.client.event.websocket;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative=true, namespace= JsPackage.GLOBAL)
public class EventTarget {


    public native void addEventListener(String type, Function listener);

}
