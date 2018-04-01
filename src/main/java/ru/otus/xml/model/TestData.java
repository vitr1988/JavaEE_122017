package ru.otus.xml.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class TestData {
    private String name;
    private int age;

    public TestData() {
    }

    public TestData(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
