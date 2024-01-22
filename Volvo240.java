import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    private double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(currentSpeed + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(currentSpeed - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    protected void gas(double amount){
        if (amount > 1){
            amount = 1;
        };
        if (amount < 0){
            amount = 0;
        };
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    protected void brake(double amount){
        if (amount > 1){
            amount = 1;
        };
        if (amount < 0){
            amount = 0;
        };
        decrementSpeed(amount);
    }
}
