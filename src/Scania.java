package src;

import java.awt.*;

public class Scania extends Truck {

    String scaniaImage = "pics/Scania.jpg";
    public Scania() {
        super(2, Color.black, 250, "Scania", new ScaniaRamp(), "pics/Scania.jpg");
        //setPosition(600, 0);
    }


}