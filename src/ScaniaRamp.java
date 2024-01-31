package src;
public class ScaniaRamp implements Ramp{
    private final int angle;
    private int angleRamp;
    public ScaniaRamp(){
        angle = 10;
        angleRamp = 0;
    }
    @Override
    public void openRamp() {
        angleRamp = angleRamp + angle;
        if(angleRamp > 70){
            angleRamp = 70;
        }
    }

    @Override
    public void closeRamp(){
        angleRamp = angleRamp - angle;
        if(angleRamp < 0){
            angleRamp = 0;
        }
    }

    @Override
    public int getAngleRamp() {
        return angleRamp;
    }

}