package com.example.ZooManager;
import java.io.Serializable;

// class representing an animal in the zoo
public class Animals implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String animalType;
    private boolean isCarnivore;

    // constructor to initialize an animal
    public Animals(String name, String animalType, boolean isCarnivore) {
        this.name = name;
        this.animalType = animalType;
        this.isCarnivore = isCarnivore;
    }

    // override toString method to print animal details
    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", animalType='" + animalType + '\'' +
                ", isCarnivore=" + isCarnivore +
                '}';
    }
}
