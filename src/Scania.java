package src;

import java.awt.*;

public class Scania extends Truck implements Ramp{
    private final RampClass ramp = new RampClass();

    private int newAngelRamp;

    public Scania() {
        super(2, Color.black, 250, "Scania");
;

    }
    @Override
    public void rampUp(){
        if(canOpen()) {
            newAngelRamp = ramp.getAngleRamp() + ramp.getAngle();
            ramp.setAngleRamp(newAngelRamp);
            ramp.rampUp();
        }
    }

    @Override
    public void rampDown(){
        if (canOpen()){
            newAngelRamp = ramp.getAngleRamp() - ramp.getAngle();
            ramp.setAngleRamp(newAngelRamp);
            ramp.rampDown();
        }
    }


    @Override
    public void move(){
        // Scania can only move when the ramp is up
        if(ramp.canMove()){
            super.move();
        }
    }


}