package src;

public class RampClass implements Ramp{

    private final int angle;

    private int angleRamp;

    public RampClass(){
        angle = 10;
        angleRamp = 0;
    }

    protected int getAngleRamp(){
        return angleRamp;
    }
    protected int getAngle(){
        return angle;
    }
    @Override
    public void rampUp() {
        if (angleRamp >= 70){
            angleRamp = 70;
        }
    }

    @Override
    public void rampDown() {
        if (angleRamp < 0){
            angleRamp = 0;
        }
    }

    public boolean canMove() {
        if (angleRamp == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void setAngleRamp(int newAngleRamp) {
        angleRamp = newAngleRamp;
    }
}
