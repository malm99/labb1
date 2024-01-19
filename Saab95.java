import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(2, Color.red, 125, "Saab95");
	    turboOn = false;
    }


    private void setTurboOn(){
	    turboOn = true;
    }

    private void setTurboOff(){
	    turboOn = false;
    }
    
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount > 1){
            amount = 1;
        };
        if (amount < 0){
            amount = 0;
        };
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount > 1){
            amount = 1;
        };
        if (amount < 0){
            amount = 0;
        };
        decrementSpeed(amount);
    }
}