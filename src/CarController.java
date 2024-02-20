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
    CarController(VehicleModel model, CarView frame){
        this.vehicleModel = model;
        this.frame = frame;
        actions();
    }
    void startTimer(){
        this.timer.start();
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
                vehicleModel.gas(frame.gasAmount);
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.brake(frame.gasAmount);
                }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.turboOn();
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.turboOff();
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.startAll();
            }
        });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.stopAll();
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.closeRamp();
            }
        });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.openRamp();
            }
        });
    }

}
