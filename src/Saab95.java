package src;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    String saabImage = "pics/Saab95.jpg";

    public Saab95(){
        super(2, Color.red, 125, "Saab95", "pics/Saab95.jpg");
	    turboOn = false;
        //setPosition(500, 0);
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) {
            turbo = 1.3;
        }
        return getEnginePower() * 0.01 * turbo;
    }

}