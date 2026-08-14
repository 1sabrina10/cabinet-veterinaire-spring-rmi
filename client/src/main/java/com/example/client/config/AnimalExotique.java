package com.example.client.config;

import com.example.models.Espece;
import java.io.Serializable;

public class AnimalExotique extends Espece implements Serializable {
    private String especeName;

    public AnimalExotique(String especeName) {
        this.especeName = especeName;
    }

    public String getEspeceName() {
        return especeName;
    }
    public void setEspeceName(String especeName) {
        this.especeName = especeName;
    }

    @Override
    public String toString() {
        return "AnimalExotique{" +
                "especeName='" + especeName + '\'' +
                '}';
    }
}
