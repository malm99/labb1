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

    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    protected Workshop<Volvo240> volvoWS = new Workshop<>(1);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());
        //cc.cars.add(new Volvo240());



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();

        for (Vehicle vehicle: cc.cars){
            vehicle.setPosition(cc.frame.drawPanel.getPoint(vehicle).x, cc.frame.drawPanel.getPoint(vehicle).y);
        }

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Iterator<Vehicle> iterator = cars.iterator();
            while (iterator.hasNext()) {
                Vehicle car = iterator.next();
            //for (Vehicle car : cars) {
                if ((car.getPosition().getY() > 500 && car.direction == Car.Direction.down) || (car.getPosition().getY() < 0 && car.direction == Car.Direction.up) || (car.getPosition().getX() < 0 && car.direction == Car.Direction.left) || (car.getPosition().getX() > 800 && car.direction == Car.Direction.right)) {
                    car.stopEngine();
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();
                    car.move();
                }
                else {
                    if (car instanceof Volvo240 && (Math.round(car.getPosition().getX()) == frame.drawPanel.volvoWorkshopPoint.getX() && Math.round(car.getPosition().getY()) == frame.drawPanel.volvoWorkshopPoint.getY())) {
                        if (!volvoWS.NoCapacity()) {
                            volvoWS.load((Volvo240) car);
                            iterator.remove();
                        }
                    }
                    car.move();
                    int x = (int) Math.round(car.getPosition().getX());
                    int y = (int) Math.round(car.getPosition().getY());
                    frame.drawPanel.moveit(car, x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }

            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
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
    }

}
