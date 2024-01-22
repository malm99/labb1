import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tester {

    private Volvo240 volvo;
    private Saab95 saab;
    @BeforeEach
    void setUp(){
        volvo = new Volvo240();
        saab = new Saab95();
    }
    @Test
    void testMove(){

        volvo.startEngine();
        volvo.move();
        assert (volvo.position.y == 0.1);

        saab.startEngine();
        saab.move();
        assert (saab.position.y == 0.1);
    }
    @Test
    void testTurnLeft(){

        volvo.startEngine();
        volvo.turnLeft();
        volvo.move();
        assert (volvo.position.x == -0.1);

        saab.startEngine();
        saab.turnLeft();
        saab.move();
        assert (saab.position.x == -0.1);
    }
    @Test
    void testTurnRight(){

        volvo.currentSpeed = 1;
        volvo.turnRight();
        volvo.move();

        assert (volvo.position.x == 1);


    }

    @Test
    void testGas(){
        // Should be 1.35
        saab.startEngine();
        saab.gas(20);
        assert(saab.currentSpeed == 1.35);
        // Check that call to gas cannot decrease speed
        saab.gas(-20);
        assert(saab.currentSpeed == 1.35);

        volvo.startEngine();
        volvo.gas(20);
        assert(volvo.currentSpeed == 1.35);
        // Check that call to gas cannot decrease speed
        volvo.gas(-20);
        assert(volvo.currentSpeed == 1.35);
    }

    @Test
    void testBrake(){
        saab.startEngine();
        saab.gas(20);
        saab.brake(20);
        saab.brake(20);
        assert(saab.currentSpeed == 0);

        volvo.startEngine();
        volvo.gas(20);
        volvo.brake(20);
        volvo.brake(20);
        assert(volvo.currentSpeed == 0);
    }

    @Test
    void maxSpeed(){
        saab.currentSpeed = 124;
        saab.gas(1);
        assert(saab.currentSpeed == 125);
        volvo.currentSpeed = 99;
        volvo.gas(1);
        assert(volvo.currentSpeed == 100);
    }
}
