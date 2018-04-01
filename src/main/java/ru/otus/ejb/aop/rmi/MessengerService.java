package ru.otus.ejb.aop.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessengerService extends Remote {
    String sendMessage(String clientMessage) throws RemoteException;
}
