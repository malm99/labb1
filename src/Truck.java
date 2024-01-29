import java.awt.*;

public class Truck extends Vehicle {
    //public Ramp ramp;

    public Truck(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);

    }

    public void rampUp(){
        if(currentSpeed == 0){
            ramp.rampUp();
        }
    }

    public void rampDown(){
        if (currentSpeed == 0){
            ramp.rampDown();
        }
    }


}
