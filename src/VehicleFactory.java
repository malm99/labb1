package src;

public class VehicleFactory {
    private static Vehicle createSaab95(){
        return new Saab95();
    }

    private static Vehicle createVolvo240(){
        return new Volvo240();
    }
    private static Vehicle createScania(){
        return new Scania();
    }


    public static Vehicle createVehicle(String modelname){
        return switch (modelname) {
            case "Saab95" -> createSaab95();
            case "Volvo240" -> createVolvo240();
            case "Scania" -> createScania();
            default -> throw new IllegalArgumentException(modelname + " does not exist");
        };
    }

}
