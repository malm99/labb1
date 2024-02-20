package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    String volvoImage = "pics/Volvo240.jpg";
    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
        //setPosition(0, 0);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public String getImage() {
        return volvoImage;
    }
}
