package builder;

import org.example.CarPark;
import org.example.CarParkManager;
import org.example.builder.CarParkDirector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CarParkDirectorTests {

    CarParkDirector carParkDirector;

    @Before
    public void setUp() {
        carParkDirector = new CarParkDirector();
    }
    @After
    public void tearDown(){
        carParkDirector = null;
    }

    @Test
    public void test_buildAverageCarPark_returnsCarPark(){
        CarPark park = carParkDirector.buildAverageCarPark(100);
        CarPark park2 = carParkDirector.buildAverageCarPark(50);

        assertEquals(100, park.getCapacity());
        assertEquals(50, park2.getCapacity());
    }

    @Test
    public void test_buildPreMadeCarPark_returnsCarPark() throws IOException {
        CarPark park = carParkDirector.buildPreMadeCarPark();

        assertEquals(100, park.getCapacity());

    }

    @Test
    public void test_buildPreMadeCarParkWithManager() throws IOException {
        CarParkManager manager = carParkDirector.buildPreMadeCarParkWithManager();
        assertEquals(100, manager.getCarPark().getCapacity());

    }


}
