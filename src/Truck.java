package src;

import java.awt.*;

public class Truck extends Vehicle{
    //public Ramp ramp;

    public Truck(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);

    }

    public boolean canOpen(){
        if (currentSpeed == 0){
            return true;
        }
        else {
            return false;
        }
    }





}
