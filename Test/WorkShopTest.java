package src;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.*;

public class WorkShopTest {

    private Volvo240 volvo;
    private Saab95 saab;

    private Workshop<Volvo240> volvoWS;
    private Workshop<Car> carWS;
    @BeforeEach
    void setUp(){
        volvo = new Volvo240();
        saab = new Saab95();
        volvoWS = new Workshop<>(1);
        carWS = new Workshop<>(2);
    }

    @Test
    void VolvoWorkShop(){
        volvoWS.load(volvo);
        volvoWS.load(volvo);
        assert (volvoWS.queue.size() == 1);
        carWS.load(volvo);
        carWS.load(saab);
        assert(carWS.unload() instanceof Volvo240);
        assert(carWS.unload() instanceof Saab95);
    }
}
