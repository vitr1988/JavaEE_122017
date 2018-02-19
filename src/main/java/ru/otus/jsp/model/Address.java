package ru.otus.jsp.model;

public class Address {

    private String address;
    private String type = null;
    private int postIndex = 0;

    public Address() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(int postIndex) {
        this.postIndex = postIndex;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", postIndex=" + postIndex +
                '}';
    }
}
