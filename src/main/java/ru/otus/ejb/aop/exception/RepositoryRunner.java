package ru.otus.ejb.aop.exception;

public class RepositoryRunner {

    public static void main(String[] args) {
        Repository rep = new Repository();
        System.out.println(rep.getSomeData());
    }
}
