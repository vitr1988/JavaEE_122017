package ru.otus.ejb.session.proxy;

public class StudentRunner {
    public static void main(String[] args) {
        Teachable st = new Student();
        st.teach();

        System.out.println("---------------");

        Teachable student = TransactionFactory.createProxy(st, null, null);
        student.teach();
    }
}
