package com.example.client;

import com.example.interfaces.VetObserver;
import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VetObserverImpl extends UnicastRemoteObject implements VetObserver {

    private final JFrame frame;
    private final JButton addButton;
    public VetObserverImpl(JFrame frame, JButton addButton) throws RemoteException {
        super();
        this.frame = frame;
        this.addButton = addButton;
    }

    @Override
    public void notifyClient(String message) throws RemoteException {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(frame, message, "ALERTE CABINET", JOptionPane.WARNING_MESSAGE);
        });
    }
}





