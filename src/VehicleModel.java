package src;

import java.util.ArrayList;

public class VehicleModel {
    protected ArrayList<Vehicle> vehicles = new ArrayList<>();

    public VehicleModel() {
        vehicles.add(VehicleFactory.createVehicle("Volvo240"));
        vehicles.add(VehicleFactory.createVehicle("Saab95"));
        vehicles.add(VehicleFactory.createVehicle("Scania"));
        /*
        for (Vehicle vehicle : vehicles) {
            vehicle.setPosition(frame.drawPanel.getPoint(vehicle).x, frame.drawPanel.getPoint(vehicle).y);
        }*/
    }

    //TODO: kolla över instanceof
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            if (car.currentSpeed > 0){
                car.gas(gas);
            }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) /100;
        for (Vehicle car: vehicles){
            car.brake(brake);
        }
    }

    void turboOn(){
        for (Vehicle car: vehicles){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff(){
        for (Vehicle car: vehicles){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
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
}
