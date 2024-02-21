package src;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements ModelUpdateListener{

    // Just a single image,
    BufferedImage volvoImage;
    // To keep track of a single car's position
    Point volvoPoint = new Point(300,250);

    //BufferedImage volvoImage2;
    // To keep track of a single car's position
    //Point volvoPoint2 = new Point(300,0);

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    BufferedImage saabImage;
    Point saabPoint = new Point(300,100);

    BufferedImage scaniaImage;
    Point scaniaPoint = new Point(300, 200);


    //
    void moveit(Vehicle car, int x, int y){
        if (car instanceof Volvo240){
            volvoPoint.x = x;
            volvoPoint.y = y;
        } else if (car instanceof Saab95) {
            saabPoint.x = x;
            saabPoint.y = y;
        } else if (car instanceof Scania) {
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }
    }

    Point getPoint(Vehicle car){
        if (car instanceof Volvo240){
            return volvoPoint;
        } else if (car instanceof Saab95) {
            return saabPoint;
        }
        else {
            return scaniaPoint;
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            //volvoImage2 = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    //
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         // see javadoc for more info on the parameters
        //g.drawImage(volvoImage2, volvoPoint2.x, volvoPoint2.y, null);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(saabImage, saabPoint.x,saabPoint.y,null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y,null);
    }

    @Override
    public void actOnModelUpdate() {
        repaint();
    }
}
