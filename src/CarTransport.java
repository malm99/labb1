package src;
import java.awt.*;
import java.util.Stack;

public class CarTransport<T extends Car> extends Truck{

    protected CarTransportLoad<T> loadCar;
    private double loadDistance;

    public CarTransport() {
        super(2, Color.green, 500, "TransportTruck", new CarTransportRamp());
        loadDistance = 1;
    }

    @Override
    public void move(){
        // Truck can only move when ramp is up
        if (ramp.canMove()){
            super.move();
            // If the stack is not empty, change the position for each car to the truck's position if it moves
            if (!loadCar.noLoad()){
                for(T car : loadCar.cargoStack)
                {
                    car.setPosition(getPosition().x, getPosition().y);
                }
            }
        }
    }

    protected void loadCar(T car){
        if (getDirection() == car.getDirection()){
            if (getPosition().distance(car.getPosition()) <= loadDistance && ramp.getRampDown()){
                loadCar.load(car);
            }
        }
    }

    protected void unloadCar(){
        // Does not take direction into account
        if (ramp.getRampDown() && !loadCar.noLoad()){
            Car car = loadCar.unload();
            car.setPosition(getPosition().x + loadDistance, getPosition().y + loadDistance);
        }
    }
}
