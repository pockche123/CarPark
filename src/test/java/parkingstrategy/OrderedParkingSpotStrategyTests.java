package parkingstrategy;

import org.example.ParkingSpot;
import org.example.ParkingSpotStatus;
import org.example.ParkingSpotType;
import org.example.parkingstrategy.OrderedParkingSpotStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderedParkingSpotStrategyTests {


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


    OrderedParkingSpotStrategy strategy;

    @Before
    public void setUp(){
        strategy = new OrderedParkingSpotStrategy(spots);
    }

    @After
    public void tearDown(){
        strategy = null;
    }

    @Test
    public void test_findSpot_returnsParkingSpot(){
        ParkingSpot spotAccessible = strategy.findSpot(ParkingSpotType.ACCESSIBLE);
        ParkingSpot spotStandard = strategy.findSpot(ParkingSpotType.STANDARD);
        ParkingSpot spotElectric =  strategy.findSpot(ParkingSpotType.ELECTRIC);


        assertEquals(1,spotAccessible.getSpotId());
        assertEquals(2,spotStandard.getSpotId());
        assertEquals(3,spotElectric.getSpotId());

    }

    @Test
    public void test_parkCar_returnsParkingSpot(){
        ParkingSpot spotAccessible = strategy.parkCar(ParkingSpotType.ACCESSIBLE);
        ParkingSpot spotStandard = strategy.parkCar(ParkingSpotType.STANDARD);
        ParkingSpot spotElectric =  strategy.parkCar(ParkingSpotType.ELECTRIC);


        assertEquals(1, spotAccessible.getSpotId());
        assertEquals(2, spotStandard.getSpotId());
        assertEquals(3, spotElectric.getSpotId());

    }

    @Test
    public void test_leaveSpot(){
        ParkingSpot spot11 = new ParkingSpot(11, ParkingSpotType.STANDARD, 7.0);

        spot11.setStatus(ParkingSpotStatus.OCCUPIED);
        strategy.leaveSpot(spot11);

        assertEquals(ParkingSpotStatus.FREE, spot11.getStatus());
    }


}
