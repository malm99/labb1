public class Workshop<T extends Car>{
    protected int capacity;

    // Example. This workshops only accepts Volvos
//    public  Workshop<Volvo240> volvoworkshop = new Workshop<Volvo240>(4);

    protected T type;
    // Composition:
    protected WorkshopLoad<T> loadCar = new WorkshopLoad<T>();
    public Workshop(int capacity){
        this.capacity = capacity;
    }

    public void loadCar(T car){
        if (loadCar.getSize() < capacity){
            loadCar.load(car);
        }
    }

    public T unloadCar(){
        // Check if empty, kanske
        return loadCar.unload();
    }


}

