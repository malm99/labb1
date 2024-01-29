import java.awt.*;

public class Scania extends Truck{
    protected Ramp ramp;
    public Scania() {
        super(2, Color.black, 250, "Scania");
        ramp = new ScaniaRamp();
    }

    @Override
    public void move(){
        // Scania can only move when the ramp is up
        if(ramp.canMove()){
            super.move();
        }
    }


}