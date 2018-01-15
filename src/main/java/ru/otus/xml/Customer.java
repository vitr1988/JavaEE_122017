package ru.otus.xml;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement
public class Customer {

    String name;
    int age;
    int id;

    @XmlAttribute
    int salary;

    public String getName() {
        return name;
    }

    @XmlElement(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public long getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
