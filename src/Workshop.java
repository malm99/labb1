package src;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Queue;

public class Workshop<T extends Car> implements Load<T>, Image{
    protected int capacity;
    protected Queue<T> queue = new LinkedList<>();

    private Point2D.Double position;
    String volvoWS = "pics/VolvoBrand.jpg";

    public Workshop(int capacity){
        this.capacity = capacity;
    }

    public boolean NoCapacity(){
        return queue.size() >= capacity;
    }

    @Override
    public void load(T car) {
        if (!NoCapacity()) {
            queue.add(car);
            }
        }


    @Override
    public T unload() {
        if(!queue.isEmpty()){
            return queue.remove();
        }
        return null;
    }

    @Override
    public String getImage() {
        return volvoWS;
    }

    @Override
    public Point2D.Double getPosition() {

        return position;
    }
}

