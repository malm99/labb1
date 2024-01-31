package src;

import java.awt.*;

public abstract class Truck extends Vehicle{
    public Ramp ramp;

    public Truck(int nrDoors, Color color, int enginePower, String modelName, Ramp ramp) {
        super(nrDoors, color, enginePower, modelName);
        this.ramp = ramp;

    }

    @Override
    double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void gas(double amount) {
        if(ramp.getAngleRamp() == 0) {
            super.gas(amount);
        }
    }

    public void openRamp(){
        if (currentSpeed == 0){
            ramp.openRamp();
        }
    }




}
