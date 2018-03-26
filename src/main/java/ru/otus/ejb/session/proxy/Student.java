package ru.otus.ejb.session.proxy;

public class Student implements Teachable {

    @Override
    public void teach() {
        System.out.println("Teach teach teach!!");
    }
}
