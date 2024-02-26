package src;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class CarView extends JPanel implements ModelUpdateListener {

    // Just a single image,

    // To keep track of a single car's position


    //BufferedImage volvoImage2;
    // To keep track of a single car's position
    //Point volvoPoint2 = new Point(300,0);

    BufferedImage volvoWorkshopImage;

    VehicleModel vehicleModel;

    // Initializes the panel and reads the images
    public CarView(int x, int y, VehicleModel vehicleModel) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.black);
        this.vehicleModel = vehicleModel;
        // Print an error message in case file is not found with a try/catch block
        try {
        /*    // You can remove the "pics" part if running outside of IntelliJ and*/
        /*    // everything is in the same main folder.*/
        /*    // volvoImage = ImageIO.read(new File("Volvo240.jpg"));*/
          volvoWorkshopImage = ImageIO.read(CarView.class.getResourceAsStream("pics/VolvoBrand.jpg"));

        } catch (IOException ex)
        {
           ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, (int) vehicleModel.volvoWS.getPosition().x, (int) vehicleModel.volvoWS.getPosition().y, null); 
        for (Vehicle vehicle: vehicleModel.vehicles){
            g.drawImage(vehicle.image, (int) vehicle.getPosition().x, (int )vehicle.getPosition().y, null);
        }
    }

    @Override
    public void actOnModelUpdate() {
        repaint();
    }
}
