package src;

public class VehicleFactory {
    public static Vehicle createSaab95(){
        return new Saab95();
    }

    public static Vehicle createVolvo240(){
        return new Volvo240();
    }
    public static Vehicle createScania(){
        return new Scania();
    }
    //TODO: använd createVehicle
    public static Vehicle createVehicle(String modelname){
        return switch (modelname) {
            case "Saab95" -> createSaab95();
            case "Volvo240" -> createVolvo240();
            case "Scania" -> createScania();
            default -> null;
        };
    }

}
