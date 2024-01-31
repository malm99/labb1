package src;

import java.awt.*;
import java.util.Stack;

public class CarTransport<T extends Car> extends Truck implements Ramp, Load<T>{

    private final RampClass ramp = new RampClass();
    protected Stack<T> cargoStack = new Stack<T>();
    private int newAngleRamp;
    private double loadDistance;
    public CarTransport() {
        super(2, Color.green, 500, "TransportTruck");
        loadDistance = 1;
    }
    @Override
    public void load(T car) {
        if (getDirection() == car.getDirection()) {
            if (getPosition().distance(car.getPosition()) <= loadDistance && (ramp.getAngleRamp() == 70)) {
                cargoStack.push(car);
            }
        }
    }

    @Override
    public T unload() {
        // Does not take direction into account
        if (ramp.getAngleRamp() == 70 && !cargoStack.isEmpty()){
            T car = cargoStack.pop();
            car.setPosition(getPosition().x + loadDistance, getPosition().y + loadDistance);
            return car;
        }
        return null; // Antagligen fel
    }

    @Override
    public void move(){
        // Truck can only move when ramp is up
        if (ramp.canMove()){
            super.move();
            // If the stack is not empty, change the position for each car to the truck's position if it moves
            if (!cargoStack.isEmpty()){
                for(T car : cargoStack)
                {
                    car.setPosition(getPosition().x, getPosition().y);
                }
            }
        }
    }


    @Override
    public void rampUp() {
        newAngleRamp = 70;
        ramp.setAngleRamp(newAngleRamp);

    }

    @Override
    public void rampDown() {
        newAngleRamp = 0;
        ramp.setAngleRamp(newAngleRamp);

    }

}
