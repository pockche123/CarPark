package utils;

import org.example.utils.InputUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.example.utils.InputUtils.getValidInput;
import static org.junit.Assert.assertEquals;

public class InputUtilsTests {
    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream testIn;

    @Before
    public void setUp() {
        System.setIn(originalSystemIn);
    }

    @After
    public void restore(){
        System.setIn(originalSystemIn);
    }

    @Test
    public void test_getValidInput_returnsValidInput(){
        String input = "1\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        assertEquals(1, getValidInput(1,3));

    }

    @Test
    public void test_getValidInput_InvalidInputHandling_returnsOnlyWhenValidInputPassed() {

        String simulatedInput = "abc\n!\n3.5\n5\n";
        InputStream stdinBackup = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        int result = getValidInput(1, 10);
        System.setIn(stdinBackup);

        assertEquals(5, result);
    }
}
