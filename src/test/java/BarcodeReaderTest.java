import org.example.BarcodeReader;
import org.example.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarcodeReaderTest {
    private BarcodeReader barcodeReader;

    @Before
    public void setUp(){
        barcodeReader  = new BarcodeReader();
    }

    @After
    public void tearDown(){
        barcodeReader = null;
    }

    @Test
    public void test_read_returnString(){
        Car car = new Car(1234567890);
        Car car2 = new Car(56565656554L);

        assertEquals("1234567890", barcodeReader.read(car));
        assertEquals("56565656554", barcodeReader.read(car2));

    }
}
