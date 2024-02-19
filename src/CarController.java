package src;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    private Timer timer = new Timer(delay, new CarController.TimerListener());
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    private VehicleModel vehicleModel;
    //ArrayList<Vehicle> vehicles = new ArrayList<>();

    protected Workshop<Volvo240> volvoWS = new Workshop<>(1);

    //methods:
    // TODO: konstruktor
    void CarController(VehicleModel model, CarView frame){
        this.vehicleModel = model;
        this.frame = frame;
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Iterator<Vehicle> iterator = vehicleModel.vehicles.iterator();
            while (iterator.hasNext()) {
                Vehicle vehicle = iterator.next();
                if ((vehicle.getPosition().getY() > 500 && vehicle.direction == Car.Direction.down) || (vehicle.getPosition().getY() < 0 && vehicle.direction == Car.Direction.up) || (vehicle.getPosition().getX() < 0 && vehicle.direction == Car.Direction.left) || (vehicle.getPosition().getX() > 800 && vehicle.direction == Car.Direction.right)) {
                    vehicle.stopEngine();
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                    vehicle.startEngine();
                    vehicle.move();
                }
                else {
                    if (vehicle instanceof Volvo240 && (Math.round(vehicle.getPosition().getX()) == frame.drawPanel.volvoWorkshopPoint.getX() && Math.round(vehicle.getPosition().getY()) == frame.drawPanel.volvoWorkshopPoint.getY())) {
                        if (!volvoWS.NoCapacity()) {
                            volvoWS.load((Volvo240) vehicle);
                            iterator.remove();
                        }
                    }
                    vehicle.move();
                    int x = (int) Math.round(vehicle.getPosition().getX());
                    int y = (int) Math.round(vehicle.getPosition().getY());
                    frame.drawPanel.moveit(vehicle, x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }

            }
        }

    }
    // TODO: vart ska actionListners vara?
    void actions() {
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gas = ((double) frame.gasAmount) / 100;
                for (Vehicle vehicle : vehicleModel.vehicles) {
                    if (vehicle.currentSpeed > 0) {
                        vehicle.gas(gas);
                    }
                }
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double brake = ((double) frame.gasAmount) / 100;
                for (Vehicle vehicle : vehicleModel.vehicles) {
                    vehicle.brake(brake);
                }
            }
        });
    }
 /*
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOff();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startAll();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopAll();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.closeRamp();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.openRamp();
            }
        });
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            if (car.currentSpeed > 0){
                car.gas(gas);
            }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) /100;
        for (Vehicle car: cars){
            car.brake(brake);
        }
    }

    void turboOn(){
        for (Vehicle car: cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff(){
        for (Vehicle car: cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void openRamp(){
        for (Vehicle truck: cars){
            if (truck instanceof Scania){
                ((Scania) truck).openRamp();
                System.out.println("Open ramp");
            }
        }
    }

    void closeRamp(){
        for (Vehicle truck: cars){
            if (truck instanceof Scania){
                ((Scania) truck).closeRamp();
                System.out.println("Close ramp");
            }
        }
    }

    void startAll(){
        for (Vehicle vehicle: cars){
            vehicle.startEngine();
        }
    }

    void stopAll(){
        for (Vehicle vehicle: cars){
            vehicle.stopEngine();
        }
    }*/

}
