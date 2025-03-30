import org.example.*;
import org.example.builder.CarParkDirector;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarParkManagerTests {

    private CarParkManager carParkManager;


    private CarParkDirector director;
    @Mock
    private CarPark mockCarPark;
    @Mock
    private List<ParkingSpot> mockParkingSpots;
    @Mock
    private PlateNumberReader mockPlateReader;
    @Mock
    private MemberCarRegistry mockMemberCarRegistry;
    @Mock
    private CarRegistry mockCarRegistry;
    @Mock
    private BarcodeReader mockBarcodeReader;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        director = new CarParkDirector();
        carParkManager = director.buildPreMadeCarParkWithManager();


    }


    @Test
    public void test_getSpotCount_returnsNumber() throws IOException {
        ParkingSpotType spotType = ParkingSpotType.STANDARD;
        ParkingSpotType spotTypeAccessible = ParkingSpotType.ACCESSIBLE;
        int actual = carParkManager.getSpotCount(spotType);
        int actualAccesible = carParkManager.getSpotCount(spotTypeAccessible);
        assertEquals(34, actual);
        assertEquals(33, actualAccesible);
    }

    @Test
    public void test_addNonMemberRegistry() {
        boolean carIsNull = carParkManager.addNonmemberRegistry("1234567", null);
        boolean carPlateIsNull = carParkManager.addNonmemberRegistry("1234567", new Car());
        assertFalse(carIsNull);
        assertFalse(carPlateIsNull);

        String plate = "iu789xy";
        Car car = new Car(plate);
        when(mockPlateReader.read(car)).thenReturn(plate);
        when(mockCarRegistry.addCar(plate, car)).thenReturn(true);
        boolean validCar = carParkManager.addNonmemberRegistry(plate, car);
        assertTrue(validCar);
    }

    @Test
    public void test_addMemberRegistry() {
        boolean carIsNull = carParkManager.addMemberRegistry(12345679890L, null);
        boolean carPlateIsNull = carParkManager.addMemberRegistry(12345679890L, new Car());
        assertFalse(carIsNull);
        assertFalse(carPlateIsNull);

        String barcode = "12345679890";
        Car car = new Car(12345679890L);
        when(mockBarcodeReader.read(car)).thenReturn(barcode);
        when(mockMemberCarRegistry.addCar(barcode, car)).thenReturn(true);
        boolean validCar = carParkManager.addMemberRegistry(12345679890L, car);
        assertTrue(validCar);
    }
}
