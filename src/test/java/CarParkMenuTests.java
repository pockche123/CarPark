import org.example.CarPark;
import org.example.CarParkManager;
import org.example.menu.CarParkMenu;
import org.example.menu.CarParkView;
import org.example.utils.InputUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class CarParkMenuTests {

    private CarParkMenu carParkMenu;
    @Mock
    private CarParkManager mockParkManager;
    @Mock
    private CarParkView mockParkView;
    @Mock
    private CarPark mockCarPark;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        carParkMenu = new CarParkMenu(mockParkManager);
    }

//    @Test
//    public void test_start() throws IOException, InterruptedException {
//        when(mockParkManager.initCarPark()).thenReturn(mockCarPark);
//
//        try (var mockStatic = mockStatic(InputUtils.class)) {
//            mockStatic.when(() -> InputUtils.getValidInput(1, 4)).thenReturn(4);
//
//            carParkMenu.start();
//
//            verify(mockParkManager, times(1)).initCarPark();
//            verify(mockParkView, times(1)).showStartMenu();
//        }
//
//    }



}
