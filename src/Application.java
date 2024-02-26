package src;

public class Application {

    public static void main(String[] args) {
        // Instance of this class

        VehicleModel vm = new VehicleModel();
        CarView cv = new CarView(800, 560, vm);
        WindowView bv = new WindowView("CarSim 1.0", cv);
        CarController cc = new CarController(vm, bv);
        vm.addListener(cv);

        vm.startTimer();


        }
    }

