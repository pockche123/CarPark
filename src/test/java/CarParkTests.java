import org.example.CarPark;
import org.example.ParkingSpot;
import org.example.ParkingSpotType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CarParkTests {
    private CarPark carPark;

    @Before
    public void setUp(){
        carPark = new CarPark(10);

        List<ParkingSpot> spots = Arrays.asList(
                new ParkingSpot(1, ParkingSpotType.ACCESSIBLE, 2.0),
                new ParkingSpot(2, ParkingSpotType.STANDARD, 10.0),
                new ParkingSpot(3, ParkingSpotType.ELECTRIC, 3.0),
                new ParkingSpot(4, ParkingSpotType.STANDARD, 4.0),
                new ParkingSpot(5, ParkingSpotType.ACCESSIBLE, 5.0),
                new ParkingSpot(6, ParkingSpotType.ELECTRIC, 6.0),
                new ParkingSpot(7, ParkingSpotType.STANDARD, 6.0),
                new ParkingSpot(8, ParkingSpotType.ACCESSIBLE, 3.0),
                new ParkingSpot(9, ParkingSpotType.ELECTRIC, 5.0),
                new ParkingSpot(10, ParkingSpotType.ACCESSIBLE, 7.0)
        );

        carPark.setParkingSpots(spots);
        carPark.setSpotCount();
    }

    @After
    public void tearDown(){
        carPark = null;
    }

    @Test
    public void test_GetSpotType_returnsInt(){
        assertEquals(4, carPark.getSpotCount(ParkingSpotType.ACCESSIBLE));
        assertEquals(3, carPark.getSpotCount(ParkingSpotType.STANDARD));
        assertEquals(3, carPark.getSpotCount(ParkingSpotType.ELECTRIC));
    }

    @Test
    public void test_decrementSpotCount()
    {
        carPark.decrementSpotCount(ParkingSpotType.ACCESSIBLE);
        carPark.decrementSpotCount(ParkingSpotType.STANDARD);
        carPark.decrementSpotCount(ParkingSpotType.ELECTRIC);

        assertEquals(3, carPark.getSpotCount(ParkingSpotType.ACCESSIBLE));
        assertEquals(2, carPark.getSpotCount(ParkingSpotType.STANDARD));
        assertEquals(2, carPark.getSpotCount(ParkingSpotType.ELECTRIC));
    }

    @Test
    public void test_incrementSpotCount()
    {
        carPark.incrementSpotCount(ParkingSpotType.ACCESSIBLE);
        carPark.incrementSpotCount(ParkingSpotType.STANDARD);
        carPark.incrementSpotCount(ParkingSpotType.ELECTRIC);

        assertEquals(5, carPark.getSpotCount(ParkingSpotType.ACCESSIBLE));
        assertEquals(4, carPark.getSpotCount(ParkingSpotType.STANDARD));
        assertEquals(4, carPark.getSpotCount(ParkingSpotType.ELECTRIC));
    }


}
