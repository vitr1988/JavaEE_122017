package ru.otus.jsp.model;

public class Employee {

    private String name;
    private int id;
    private String role;
    private Address address;

    public Employee() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String nm) {
        this.name = nm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", role='" + role + '\'' +
                ", address=" + address +
                '}';
    }
}
