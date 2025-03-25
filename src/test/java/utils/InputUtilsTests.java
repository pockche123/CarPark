package utils;

import org.example.utils.InputUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.example.utils.InputUtils.*;
import static org.junit.Assert.assertEquals;

public class InputUtilsTests {

    private InputStream originalIn;

    @Before
    public void setUp() {
        originalIn = System.in;
    }

    @After
    public void restore(){
          System.setIn(originalIn);
          InputUtils.resetScanner();
    }

    @Test
    public void test_getValidInput_returnsValidInput(){
        String input = "1\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        InputUtils.resetScanner();
        assertEquals(1, InputUtils.getValidInput(1,3));

    }

    @Test
    public void test_getValidInput_InvalidInputHandling_returnsOnlyWhenValidInputPassed() {

        String simulatedInput = "abc\n!\n3.5\n5\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testIn);
        InputUtils.resetScanner();
        int result = InputUtils.getValidInput(1, 10);

        assertEquals(5, result);
    }

    @Test
    public void test_getValidString_returnsString(){
        String input = "abc\n!\nhello\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        InputUtils.resetScanner();
        String actual = getValidString(5);
        assertEquals("hello", actual);
    }


    @Test
    public void test_getValidBarcode_returnsString(){
        String input = "abc\n!\nhello\n123\n12345\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        InputUtils.resetScanner();
        String actual = getValidBarcode(5);
        assertEquals("12345",actual);
    }
}
