package src;
public interface Load<T extends Car> {
    void load(T car);
    T unload();
    boolean noLoad();
}