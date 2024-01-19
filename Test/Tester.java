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
    }
    @Test
    void testTurnLeft(){
        volvo.startEngine();
        volvo.turnLeft();
        assert (volvo.position.x == -0.1);
    }
    @Test
    void testTurnRight(){
        volvo.startEngine();
        volvo.turnRight();
        assert (volvo.position.x == 0.1);
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
    }

    @Test
    void testBrake(){
        System.out.println(saab.currentSpeed);
        saab.startEngine();
        System.out.println(saab.currentSpeed);
        saab.gas(20);
        System.out.println(saab.currentSpeed);
        saab.brake(20);
        saab.brake(20);
        System.out.println(saab.currentSpeed);
        assert(saab.currentSpeed == 0);
    }

    @Test
    void maxSpeed(){
        saab.currentSpeed = 124;
        saab.gas(1);
        assert(saab.currentSpeed == 125);
    }
}
