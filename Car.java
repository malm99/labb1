import java.awt.*;
import java.awt.geom.Point2D;

public class Car implements Moveable{
    // Attributes
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    protected Point2D.Double position; // The position of the car
    private enum Direction {up, down, left, right}; // Define what directions the car can have
    private Direction direction; // The direction of the car

    public Car(int nrDoors, Color color, int enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        position = new Point2D.Double(0, 0);
        stopEngine();
        setDirection(Direction.up);
    }

    // Methods:

    protected int getNrDoors(){
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
        direction = dir;
    }

    protected Direction getDirection(){
        return direction;
    }

    @Override
    public void move() {
        if (getDirection() == Direction.up){
            position.y = position.y + currentSpeed;
        }
        if (getDirection() == Direction.down){
            position.y = position.y - currentSpeed;
        }
        if (getDirection() == Direction.left){
            position.x = position.x - currentSpeed;
        }

        if (getDirection() == Direction.right){
            position.x = position.x + currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        if (getDirection() == Direction.up){
            direction = Direction.left;
        }
        if (getDirection() == Direction.down){
            direction = Direction.right;
        }
        if (getDirection() == Direction.left){
            direction = Direction.down;
        }

        if (getDirection() == Direction.right){
            direction = Direction.up;
        }
    }

    @Override
    public void turnRight() {
        if (getDirection() == Direction.up){
            direction = Direction.right;
        }
        if (getDirection() == Direction.down){
            direction = Direction.left;
        }
        if (getDirection() == Direction.left){
            direction = Direction.up;
        }

        if (getDirection() == Direction.right){
            direction = Direction.down;
        }
    }
}
