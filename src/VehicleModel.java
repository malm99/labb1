package src;

import java.util.ArrayList;

public class VehicleModel {
    protected ArrayList<Vehicle> vehicles;

    public VehicleModel(){
        vehicles.add(VehicleFactory.createVehicle("Volvo240"));
        vehicles.add(VehicleFactory.createVehicle("Saab95"));
        vehicles.add(VehicleFactory.createVehicle("Scania"));
    }
}
