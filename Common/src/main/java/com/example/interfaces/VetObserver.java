package com.example.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VetObserver extends Remote {

    void notifyClient(String message) throws RemoteException;
}
