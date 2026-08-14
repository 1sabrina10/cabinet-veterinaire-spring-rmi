package com.example.models;

//import com.example.interfaces.IEspece;
import java.rmi.RemoteException;

public class Oiseau extends Espece {

    public Oiseau()throws RemoteException{
        this.especeName ="Oiseau";
        this.duree = 8;
    }
}
