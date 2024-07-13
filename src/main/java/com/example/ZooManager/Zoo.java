package com.example.ZooManager;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// main class representing the zoo
public class Zoo {
    private static final String FILENAME = "animals.dat";

    public static void main(String[] args) {
        Animals[] animals;

        // check if the file exists
        if (new File(FILENAME).exists()) {
            // if the file exists, deserialize animals from the file
            animals = deserializeAnimals();
        } else {
            // if the file does not exist, create an array of animals
            animals = createAnimals();
        }

        // print out all animals
        System.out.println("Animals in the Zoo:");
        for (Animals animal : animals) {
            System.out.println(animal);
        }

        // serialize animals to the file
        serializeAnimals(animals);
    }

    // method to create an array of animals
    private static Animals[] createAnimals() {
        return new Animals[] {
                new Animals("Giraffe", "Mammal", false),
                new Animals("Snake", "Reptile", true),
                new Animals("Ostrich", "Bird", false),
                new Animals("Dolphin", "Mammal", true),
                new Animals("Alligator", "Reptile", true),
                new Animals("Zebra", "Mammal", false),
                new Animals("Wolf", "Mammal", true),
                new Animals("Goat", "Mammal", false),
                new Animals("Flamingo", "Bird", false),
                new Animals("Lion", "Mammal", true)
        };
    }

    // method to serialize animals to the file
    private static void serializeAnimals(Animals[] animals) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            // serialize each animal to the file
            for (Animals animal : animals) {
                oos.writeObject(animal);
            }
            System.out.println("Animals serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to deserialize animals from the file
    private static Animals[] deserializeAnimals() {
        List<Animals> animalList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            // deserialize animals from the file
            while (true) {
                try {
                    Animals animal = (Animals) ois.readObject();
                    animalList.add(animal);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // convert List<Animals> to Animals[]
        return animalList.toArray(new Animals[0]);
    }
}

