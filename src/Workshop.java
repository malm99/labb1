package src;

import java.util.LinkedList;
import java.util.Queue;

public class Workshop<T extends Car> implements Load<T>{
    protected int capacity;
    protected Queue<T> queue = new LinkedList<>();


    public Workshop(int capacity){
        this.capacity = capacity;
    }

    @Override
    public void load(T car) {
        if (queue.size() < capacity){
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
}

