import org.example.Car;
import org.example.CarRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarRegistryTests {

    private CarRegistry carRegistry;

    @Before
    public void setUp(){
        carRegistry = new CarRegistry();
    }

    @After
    public void tearDown(){
        carRegistry = null;
    }


    @Test
    public void test_addCar_returns_true(){
        assertTrue(carRegistry.addCar("ut55uty", new Car("ut55uty")));
        assertTrue(carRegistry.addCar("ut55uuh", new Car("ut55uuh")));
        assertTrue(carRegistry.addCar("ut21rda", new Car("ut21rda")));

    }


    @Test
    public void test_addCar_returns_false(){
        assertTrue(carRegistry.addCar("ut55uty", new Car()));
        assertTrue(carRegistry.addCar("ut55uuh", new Car()));
        assertTrue(carRegistry.addCar("ut21rda", new Car()));

    }


}
