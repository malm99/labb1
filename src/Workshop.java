package src;

import java.util.LinkedList;
import java.util.Queue;

public class Workshop<T extends Car> implements Load<T>{
    protected int capacity;
    protected Queue<T> queue = new LinkedList<>();


    public Workshop(int capacity){
        this.capacity = capacity;
    }

    public boolean NoCapacity(){
        return queue.size() >= capacity;
    }

    @Override
    public void load(T car) {
        if (!NoCapacity()) {
            //boolean add = true;
            /*for (T item : queue) {
                if (item == car) {
                    add = false;
                    break;
                }
            }
            if (add){*/
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

