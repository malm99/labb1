package src;

public class Application {

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        // TODO: koppling till vehicle model

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // TODO: vart ska timer vara?
        // Start the timer
        cc.timer.start();

        for (Vehicle vehicle: cc.vehicles){
            vehicle.setPosition(cc.frame.drawPanel.getPoint(vehicle).x, cc.frame.drawPanel.getPoint(vehicle).y);
        }
    }
}
