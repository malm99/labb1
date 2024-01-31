package src;
public class CarTransportRamp implements Ramp{

    private int angleRamp; // The position of the ramp. Ramp down means truck can't move and cars can board.
    public CarTransportRamp(){
        angleRamp = 0;
    }
    @Override
    public void openRamp() {
        angleRamp = 70;
    }

    @Override
    public void closeRamp() {
        angleRamp = 0;

    }

    @Override
    public int getAngleRamp() {
        return angleRamp;
    }



}