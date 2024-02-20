package src;

import java.util.concurrent.CopyOnWriteArraySet;

public class Application {

    public static void main(String[] args) {
        // Instance of this class
        VehicleModel vm = new VehicleModel();
        CarView cv = new CarView("CarSim 1.0");
        CarController cc = new CarController(vm, cv);
        // TODO: koppling till vehicle model
        cc.startTimer();
        // Start a new view and send a reference of self

        // TODO: vart ska timer vara?
        // Start the timer

        }
    }

