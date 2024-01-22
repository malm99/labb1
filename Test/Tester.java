import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

public class Tester {

    private Volvo240 volvo;
    private Saab95 saab;
    private double startSpeed;
    @BeforeEach
    void setUp(){
        volvo = new Volvo240();
        saab = new Saab95();
    }
    @Test
    void testMove(){
        // startEngine gives currentSpeed 0.1, move the car --> the car should have pos.y = 0.1
        volvo.startEngine();
        volvo.move();
        assert (volvo.getPosition().y == 0.1);

        saab.startEngine();
        saab.move();
        assert (saab.getPosition().y == 0.1);
    }
    @Test
    void testTurnLeft(){
        // Initialize the speed to 1, turn left and move twice --> car should have pos (-1, -1)
        volvo.currentSpeed = 1;
        volvo.turnLeft();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        assert(volvo.getPosition().y == -1);
        assert(volvo.getPosition().x == -1);
    }
    @Test
    void testTurnRight(){
        // Initialize the speed to 1, turn right and move twice --> car should have pos (1, -1)
        volvo.currentSpeed = 1;
        volvo.turnRight();
        volvo.move();
        volvo.turnRight();
        volvo.move();
        assert(volvo.getPosition().y == -1);
        assert(volvo.getPosition().x == 1);
    }

    @Test
    void testGas(){
        saab.startEngine(); // currentSpeed = 0.1
        saab.gas(20); // Add 1.25 to currentSpeed
        assert(saab.currentSpeed == 1.35);

        // Check that call to gas cannot decrease speed
        saab.gas(-20);
        assert(saab.currentSpeed == 1.35);

        volvo.startEngine();
        volvo.gas(20);
        assert(volvo.currentSpeed == 1.35);

        volvo.gas(-20);
        assert(volvo.currentSpeed == 1.35);


        // General case. Does a call to gas always result in faster speed?
        volvo.startEngine();
        startSpeed = volvo.currentSpeed;
        volvo.gas(90);
        volvo.gas(0.8);
        volvo.gas(90);
        volvo.gas(0.8);
        volvo.gas(90);
        volvo.gas(0.8);

        assert(volvo.currentSpeed >= startSpeed);
    }

    @Test
    void testBrake(){
        saab.currentSpeed = 1.35;
        saab.brake(1); // Computer approximation error. Should be 0.1. Is 0.10000000000000009
        saab.brake(1);
        assert(saab.currentSpeed == 0);
        saab.brake(1000000);
        assert(saab.currentSpeed == 0); // Check that call to brake cannot result in negative speed

        volvo.startEngine();
        volvo.gas(1);
        volvo.brake(1);
        volvo.brake(1);
        assert(volvo.currentSpeed == 0);

        // General case. Does brake always result in lower speed?
        volvo.gas(90);
        volvo.gas(0.8);
        volvo.gas(90);
        volvo.gas(0.8);
        volvo.gas(90);
        volvo.gas(0.8);
        startSpeed = volvo.currentSpeed;
        volvo.brake(10000);
        volvo.brake(-111);
        volvo.brake(0.1);
        volvo.brake(10000);
        volvo.brake(-111);
        volvo.brake(0.1);

        assert(volvo.currentSpeed <= startSpeed);
    }

    @Test
    void maxSpeed(){
        // Check that there is an upper bound for the speed
        saab.currentSpeed = 124;
        saab.gas(1);
        assert(saab.currentSpeed == 125);
        volvo.currentSpeed = 99;
        volvo.gas(1);
        assert(volvo.currentSpeed == 100);
    }
}

