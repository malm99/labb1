package src;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArraySet;

public class Application {

    public static void main(String[] args) {
        // Instance of this class
        Point IPvolvoPoint = new Point(300,250);
        Point IPvolvoWorkshopPoint = new Point(300,300);
        Point IPsaabPoint = new Point(300,100);
        Point IPscaniaPoint = new Point(300, 200);

        VehicleModel vm = new VehicleModel();
        CarView cv = new CarView("CarSim 1.0");
        DrawPanel dv =
        CarController cc = new CarController(vm, cv);
        vm.addListener();
        // TODO: koppling till vehicle model
        vm.startTimer();
        // Start a new view and send a reference of self

        // TODO: vart ska timer vara?
        // Start the timer

        }
    }

