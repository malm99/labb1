package src;
public class CarTransportRamp implements Ramp{

    private boolean rampDown; // The position of the ramp. Ramp down means truck can't move and cars can board.
    public CarTransportRamp(){
        rampDown = false;
    }
    @Override
    public void rampUp() {
        rampDown = false;
    }

    @Override
    public void rampDown() {
        rampDown = true;
    }

    @Override
    public boolean canMove() {
        if (!rampDown){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean getRampDown(){
        return rampDown;
    }
}
