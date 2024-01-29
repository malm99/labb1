import java.util.LinkedList;
import java.util.Queue;

public class WorkshopLoad<T extends Car> implements Load<T>{

    public Queue<T> queue = new LinkedList<T>();

   @Override
    public void load(T car) {
        queue.add(car);
    }

    @Override
    public T unload() {
        return queue.remove();
    }

    @Override
    public boolean noLoad() {
        return queue.isEmpty();
    }

    public int getSize(){
        if (!queue.isEmpty()) {
            return queue.size();
        }
        else {
            return 0;
        }
    }
}
