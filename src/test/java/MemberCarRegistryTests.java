import org.example.Car;
import org.example.CarRegistry;
import org.example.MemberCarRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MemberCarRegistryTests {

    private MemberCarRegistry carRegistry;


    @Before
    public void setUp(){
        Map<String, Car> map = new HashMap<>();
        carRegistry = new MemberCarRegistry(map);
    }

    @After
    public void tearDown(){
        carRegistry = new MemberCarRegistry(null);
    }


    @Test
    public void test_addCar_returns_true(){
        assertTrue(carRegistry.addCar("12345678799", new Car("12345678799")));
        assertTrue(carRegistry.addCar("56565656567", new Car("56565656567")));
        assertTrue(carRegistry.addCar("47484848484", new Car("47484848484")));

    }


    @Test
    public void test_addCar_returns_false(){
        assertTrue(carRegistry.addCar("12345678799", new Car()));
        assertTrue(carRegistry.addCar("56565656567", new Car()));
        assertTrue(carRegistry.addCar("47484848484", new Car()));

    }


}
