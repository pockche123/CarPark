package utils;

import org.example.utils.ValidationUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationUtilsTest {


    @Test
    public void test_isNumber_returnTrue_withValidInput(){
        assertTrue(ValidationUtils.isNumber("12"));
        assertTrue(ValidationUtils.isNumber("24"));
    }

    @Test
    public void test_isNumber_returnsFalse_withInvalidInput(){
        assertFalse(ValidationUtils.isNumber(""));
        assertFalse(ValidationUtils.isNumber("1-"));

    }

    @Test
    public void test_isValidOption_returnsTrue_withValidOption(){
        assertTrue(ValidationUtils.checkValidOption("4",1,4));
        assertTrue(ValidationUtils.checkValidOption("3",1,4));
        assertTrue(ValidationUtils.checkValidOption("2",1,4));
        assertTrue(ValidationUtils.checkValidOption("1",1,4));
    }

    @Test
    public void test_isValidOption_returnsFalse_withInValidOption(){
        assertFalse(ValidationUtils.checkValidOption("-4",1,4));
        assertFalse(ValidationUtils.checkValidOption("",1,4));
        assertFalse(ValidationUtils.checkValidOption("______",1,4));
        assertFalse(ValidationUtils.checkValidOption("69696",1,4));
    }


}
