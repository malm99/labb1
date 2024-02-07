package src;

import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck implements Load<Car>{
    protected Stack<Car> cargoStack = new Stack<>();

    private final int capacity;
    private double loadDistance;
    public CarTransport(int capacity) {
        super(2, Color.green, 500, "TransportTruck", new CarTransportRamp());
        loadDistance = 1;
        this.capacity = capacity;
    }
    @Override
    public void load(Car car) {
        if (getDirection() == car.getDirection() && cargoStack.size() < capacity) {
            if ((getPosition().distance(car.getPosition()) <= loadDistance) && (ramp.getAngleRamp() == 70)) {
                cargoStack.push(car);
            }
        }
    }

    @Override
    public Car unload() {
        // Does not take direction into account
        if (ramp.getAngleRamp() == 70 && !cargoStack.isEmpty()){
            Car car = cargoStack.pop();
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
            for(Car car : cargoStack)
            {
                car.setPosition(getPosition().x, getPosition().y);
            }
        }
    }



}
