package ru.otus.websocket.model;

public class Data {

    private String data;
    private boolean fresh;

    public Data() {
    }

    public Data(String data, boolean fresh) {
        this.data = data;
        this.fresh = fresh;

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }
}
