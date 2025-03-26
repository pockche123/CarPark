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

    @Mock
    private CarParkDirector mockDirector;
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
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        carParkManager = new CarParkManager(mockDirector, mockPlateReader, mockMemberCarRegistry, mockBarcodeReader, mockCarRegistry);
    }

    @Test
    public void test_initCarPark_Success() throws IOException {
        when(mockDirector.buildPreMadeCarPark()).thenReturn(mockCarPark);
        mockCarPark = carParkManager.initCarPark();
        verify(mockDirector, times(1)).buildPreMadeCarPark();
    }

    @Test
    public void test_getSpotCount_returnsNumber() throws IOException {
        ParkingSpotType spotType = ParkingSpotType.STANDARD;
        when(mockDirector.buildPreMadeCarPark()).thenReturn(mockCarPark);
        carParkManager.initCarPark();
        when(mockCarPark.getSpotCount(spotType)).thenReturn(4);
        int actual = carParkManager.getSpotCount(spotType);
        assertEquals(4, actual);
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
