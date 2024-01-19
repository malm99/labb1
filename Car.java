import java.awt.*;
import java.awt.geom.Point2D;

public class Car implements Moveable{
    // Attributes
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public Point2D.Double position; // Position of the car

    // Methods:

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public Point2D.Double getPosition(){
        position = new Point2D.Double();
        return position;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void setPosition(double x, double y){
        position.x = x;
        position.y = y;
    }


    @Override
    public void move() {
        position.y = position.y + currentSpeed;
    }

    @Override
    public void turnLeft() {
        position.x = position.x - currentSpeed;
    }

    @Override
    public void turnRight() {
        position.x = position.x + currentSpeed;
    }
}
