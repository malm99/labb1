package src;

import java.awt.*;

public abstract class Car extends Vehicle {

    public Car(int nrDoors, Color color, int enginePower, String modelName, String image) {
        super(nrDoors, color, enginePower, modelName, image);
    }
}