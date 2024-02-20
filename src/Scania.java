package src;

import java.awt.*;

public class Scania extends Truck {

    String scaniaImage = "pics/Scania.jpg";
    public Scania() {
        super(2, Color.black, 250, "Scania", new ScaniaRamp());
        //setPosition(600, 0);
    }

    @Override
    public String getImage() {
        return scaniaImage;
    }
}