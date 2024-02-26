package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class VehicleModel {
    private final int delay = 50;
    protected ArrayList<Vehicle> vehicles = new ArrayList<>();
    protected List<ModelUpdateListener> listener = new ArrayList<>();
    protected Workshop<Volvo240> volvoWS = new Workshop<>(1);
    private Timer timer = new Timer(delay, new VehicleModel.TimerListener());
    private int carDist = 0;

    public VehicleModel() {
        initVehicle(VehicleFactory.createVehicle("Volvo240"), carDist, 0);
        initVehicle(VehicleFactory.createVehicle("Saab95"), carDist, 0);
        initVehicle(VehicleFactory.createVehicle("Scania"), carDist,0);
    }


    protected void initVehicle(Vehicle vehicle, double x, double y){
        vehicle.setPosition(x,y);
        vehicles.add(vehicle);
        carDist = carDist + 100;
    }

    void startTimer(){
        this.timer.start();
    }
    public void addListener(ModelUpdateListener l){
        listener.add(l);
    }
    protected void notifyListeners(){
        for (ModelUpdateListener l: listener){
            l.actOnModelUpdate();
        }
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Iterator<Vehicle> iterator = vehicles.iterator();
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
                    if (vehicle instanceof Volvo240 && (Math.round(vehicle.getPosition().getX()) == volvoWS.getPosition().x && Math.round(vehicle.getPosition().getY()) == volvoWS.getPosition().y)) {
                        if (!volvoWS.NoCapacity()) {
                            volvoWS.load((Volvo240) vehicle);
                            iterator.remove();
                        }
                    }
                    vehicle.move();

                    /*int x = (int) Math.round(vehicle.getPosition().getX());
                    int y = (int) Math.round(vehicle.getPosition().getY());*/

                }


            }
            notifyListeners();
        }
    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.currentSpeed > 0){
                vehicle.gas(gas);
            }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) /100;
        for (Vehicle vehicle: vehicles){
            vehicle.brake(brake);
        }
    }

    void turboOn(){
        for (Vehicle vehicle: vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOff(){
        for (Vehicle vehicle: vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void openRamp(){
        for (Vehicle truck: vehicles){
            if (truck instanceof Scania){
                ((Scania) truck).openRamp();
                System.out.println("Open ramp");
            }
        }
    }

    void closeRamp(){
        for (Vehicle truck: vehicles){
            if (truck instanceof Scania){
                ((Scania) truck).closeRamp();
                System.out.println("Close ramp");
            }
        }
    }

    void startAll(){
        for (Vehicle vehicle: vehicles){
            vehicle.startEngine();
        }
    }

    void stopAll(){
        for (Vehicle vehicle: vehicles){
            vehicle.stopEngine();
        }
    }

    void addCar(){
        if(vehicles.size() < 8){
            Random rand = new Random();
            int randCar = rand.nextInt(2);
            if (randCar == 1){
                initVehicle(VehicleFactory.createVehicle("Volvo240"), carDist, 0);
            }
            else{
                initVehicle(VehicleFactory.createVehicle("Saab95"), carDist, 0);
            }
        }
    }

    void removeCar(){
        if(!vehicles.isEmpty()){
            vehicles.removeLast();
            carDist = carDist - 100;

        }


    }


}
