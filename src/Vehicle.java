package src;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Vehicle implements Moveable{
    // Attributes
    private int nrDoors; // Number of doors on the vehicle
    private double enginePower; // Engine power of the vehicle
    protected double currentSpeed; // The current speed of the vehicle. Protected because messy function call in subclass when private
    private Color color; // Color of the vehicle
    private String modelName; // The car model name
    private Point2D.Double position; // The position of the vehicle
    protected enum Direction {up, down, left, right}; // Define what directions the vehicle can have
    protected Direction direction; // The direction of the vehicle

    public Vehicle(int nrDoors, Color color, int enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        position = new Point2D.Double(0, 0);
        stopEngine();
        direction = Direction.down;
    }

    // Methods:


    public int getNrDoors() {
        return nrDoors;
    }
    protected double getEnginePower(){
        return enginePower;
    }


    protected String getModelName(){
        return modelName;
    }


    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }


    protected void setDirection(Direction dir){
        if (dir == Direction.up) {
            direction = Direction.down;
        } else if (dir == Direction.down) {
            direction = Direction.up;

        }
    }

    protected Direction getDirection(){
        return direction;
    }

    protected Point2D.Double getPosition(){
        return position;
    }

    protected void setPosition(double x, double y){
        position.x = x;
        position.y = y;
    }

    abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(currentSpeed + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(currentSpeed - speedFactor() * amount,0);
    }

    public void gas(double amount){
        if (amount > 1){
            amount = 1;
        };
        if (amount < 0){
            amount = 0;
        };
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount > 1){
            amount = 1;
        };
        if (amount < 0){
            amount = 0;
        };
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        if (getDirection() == Direction.up){
            position.y = position.y - currentSpeed;
        }
        else if (getDirection() == Direction.down){
            position.y = position.y + currentSpeed;
        }
        else if (getDirection() == Direction.left){
            position.x = position.x - currentSpeed;
        }

        else if (getDirection() == Direction.right){
            position.x = position.x + currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        if (getDirection() == Direction.up){
            direction = Direction.left;
        }

        else if (getDirection() == Direction.down) {
            direction = Direction.right;

        }

        else if (getDirection() == Direction.left) {
            direction = Direction.down;

        }

        else if (getDirection() == Direction.right) {
            direction = Direction.up;

        }
    }

    @Override
    public void turnRight() {
        if (getDirection() == Direction.up){
            direction = Direction.right;
        }
        else if (getDirection() == Direction.down){
            direction = Direction.left;
        }
        else if (getDirection() == Direction.left){
            direction = Direction.up;
        }

        else if (getDirection() == Direction.right){
            direction = Direction.down;
        }
    }
}