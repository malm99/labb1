package src;
import java.util.Stack;

public class CarTransportLoad<T extends Car> implements Load<T>{
    protected Stack<T> cargoStack;

    @Override
    public void load(T car) {
        cargoStack.push(car);
    }

    @Override
    public T unload() {
        return cargoStack.pop();
    }

    @Override
    public boolean noLoad(){
        return cargoStack.isEmpty();
    }
}
