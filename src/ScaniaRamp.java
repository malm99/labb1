package src;
public class ScaniaRamp implements Ramp{
    private final int angle;
    public int angleRamp;
    public ScaniaRamp(){
        angle = 10;
        angleRamp = 0;
    }
    @Override
    public void rampUp() {
        angleRamp = angleRamp + angle;
        if(angleRamp > 70){
            angleRamp = 70;
        }
    }

    @Override
    public void rampDown(){
        angleRamp = angleRamp - angle;
            if(angleRamp < 0){
                angleRamp = 0;
        }
    }

    public boolean canMove(){
        if (angleRamp == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
