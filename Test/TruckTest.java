/*
package src;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.CarTransport;
import src.Saab95;
import src.Scania;
import src.Volvo240;

public class TruckTest {

    private Volvo240 volvo;
    private Saab95 saab;

    private Scania scania;

    private CarTransport carTransport;

    @BeforeEach
    void setUp(){
        volvo = new Volvo240();
        saab = new Saab95();
        scania = new Scania();
        carTransport = new CarTransport(5);

    }

    @Test
    void ScaniaRamp(){
        assert(scania.ramp.getAngleRamp() == 0);;
        scania.move();
        scania.openRamp();
        assert(scania.ramp.getAngleRamp() == 10);
        scania.ramp.closeRamp();
        assert(scania.ramp.getAngleRamp() == 0);;
        scania.gas(1);
        scania.move();
        scania.openRamp();
        assert(scania.ramp.getAngleRamp() == 0);
    }

    @Test
    void CarTransportRamp(){
        assert(carTransport.ramp.getAngleRamp() == 0);;
        carTransport.move();
        carTransport.openRamp();
        assert(carTransport.ramp.getAngleRamp() == 70);
        carTransport.closeRamp();
        assert(carTransport.ramp.getAngleRamp() == 0);;
        carTransport.gas(1);
        carTransport.move();
        carTransport.openRamp();
        assert(carTransport.ramp.getAngleRamp() == 0);
    }

    @Test
    void CarTransportLoad(){
        carTransport.load(volvo);
        carTransport.load(saab);
        assert(carTransport.cargoStack.isEmpty());
        carTransport.openRamp();
        carTransport.load(volvo);
        carTransport.load(saab);
        assert(carTransport.cargoStack.size() == 2);
        assert (carTransport.unload().getPosition().y == carTransport.getPosition().y + 1);
    }

}
*/
