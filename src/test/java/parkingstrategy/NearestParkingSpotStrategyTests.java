package parkingstrategy;

import org.example.ParkingSpot;
import org.example.ParkingSpotStatus;
import org.example.ParkingSpotType;
import org.example.parkingstrategy.NearestParkingSpotStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NearestParkingSpotStrategyTests {
    List<ParkingSpot> spots = Arrays.asList(
            new ParkingSpot(1, ParkingSpotType.ACCESSIBLE, 10.0),
            new ParkingSpot(2, ParkingSpotType.STANDARD, 10.0),
            new ParkingSpot(3, ParkingSpotType.ELECTRIC, 9.0),
            new ParkingSpot(4, ParkingSpotType.STANDARD, 9.0),
            new ParkingSpot(5, ParkingSpotType.ACCESSIBLE, 8.0),
            new ParkingSpot(6, ParkingSpotType.ELECTRIC, 8.0),
            new ParkingSpot(7, ParkingSpotType.STANDARD, 6.0),
            new ParkingSpot(8, ParkingSpotType.ACCESSIBLE, 6.0),
            new ParkingSpot(9, ParkingSpotType.ELECTRIC, 4.0),
            new ParkingSpot(10, ParkingSpotType.ACCESSIBLE, 4.0)
    );

    NearestParkingSpotStrategy strategy;

    @Before
    public void setUp(){
        strategy = new NearestParkingSpotStrategy(spots);
    }

    @After
    public void tearDown(){
        strategy = null;
    }

    @Test
    public void test_findSpot_returnsParkingSpot(){
        ParkingSpot spotAccessible = strategy.parkCar(ParkingSpotType.ACCESSIBLE);
        ParkingSpot spotAccessible2 = strategy.parkCar(ParkingSpotType.ACCESSIBLE);
        ParkingSpot spotElectric =  strategy.parkCar(ParkingSpotType.ELECTRIC);
        ParkingSpot spotElectric2 = strategy.parkCar(ParkingSpotType.ELECTRIC);
        ParkingSpot spotStandard = strategy.parkCar(ParkingSpotType.STANDARD);

        assertEquals(10,spotAccessible.getSpotId());
        assertEquals(8, spotAccessible2.getSpotId());

        assertEquals(9,spotElectric.getSpotId());
        assertEquals(7, spotStandard.getSpotId());
        assertEquals(6, spotElectric2.getSpotId());

    }

    @Test
    public void test_parkCar_returnsParkingSpot(){
        ParkingSpot spotAccessible = strategy.parkCar(ParkingSpotType.ACCESSIBLE);
        ParkingSpot spotAccessible2 = strategy.parkCar(ParkingSpotType.ACCESSIBLE);
        ParkingSpot spotElectric =  strategy.parkCar(ParkingSpotType.ELECTRIC);
        ParkingSpot spotElectric2 = strategy.parkCar(ParkingSpotType.ELECTRIC);
        ParkingSpot spotStandard = strategy.parkCar(ParkingSpotType.STANDARD);
        spots.forEach(System.out::println);

        assertEquals(10,spotAccessible.getSpotId());
        assertEquals(8, spotAccessible2.getSpotId());

        assertEquals(9,spotElectric.getSpotId());
        assertEquals(7, spotStandard.getSpotId());
        assertEquals(6, spotElectric2.getSpotId());

    }

    @Test
    public void test_leaveSpot(){
        ParkingSpot spot11 = new ParkingSpot(11, ParkingSpotType.STANDARD, 7.0);

        spot11.setStatus(ParkingSpotStatus.OCCUPIED);
        strategy.leaveSpot(spot11);

        assertEquals(ParkingSpotStatus.FREE, spot11.getStatus());
    }



}
