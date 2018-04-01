package ru.otus.ejb.aop.aspectj;

public class AccountRunner {
    public static void main(String[] args) {
        Account account = new Account();

        System.out.println(account.withdraw(5));
        System.out.println(account.withdraw(100));
    }
}
