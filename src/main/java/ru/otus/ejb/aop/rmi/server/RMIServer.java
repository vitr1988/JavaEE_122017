package ru.otus.ejb.aop.rmi.server;

import ru.otus.ejb.aop.rmi.MessengerService;
import ru.otus.ejb.aop.rmi.MessengerServiceImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
    public static void main(String[] args) throws Exception {
        MessengerService server = new MessengerServiceImpl();
        MessengerService stub = (MessengerService)
                UnicastRemoteObject.exportObject(server, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("MessengerService", stub);
    }
}
