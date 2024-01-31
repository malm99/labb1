package src;

import java.awt.*;
import java.util.Stack;

public class CarTransport<T extends Car> extends Truck implements Load<T>{
    protected Stack<T> cargoStack = new Stack<T>();

    private final int capacity;
    private double loadDistance;
    public CarTransport(int capacity) {
        super(2, Color.green, 500, "TransportTruck", new CarTransportRamp());
        loadDistance = 1;
        this.capacity = capacity;
    }
    @Override
    public void load(T car) {
        if (getDirection() == car.getDirection() && cargoStack.size() < capacity) {
            if ((getPosition().distance(car.getPosition()) <= loadDistance) && (ramp.getAngleRamp() == 70)) {
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
