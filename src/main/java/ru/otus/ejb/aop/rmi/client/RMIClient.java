package ru.otus.ejb.aop.rmi.client;

import ru.otus.ejb.aop.rmi.MessengerService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry();
        MessengerService server = (MessengerService) registry
                .lookup("MessengerService");
        String responseMessage = server.sendMessage("Client Message");
        System.out.println(responseMessage);
    }
}
