

import com.driver.Calculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CalculatorTest {
    Calculator calc;

    @Test
    public void testGivenExample(){
        assertEquals(Arrays.asList("-76396"), calc.BEMDAS("12435 + 34569 - 12345 * 10 + 50"));
    }

    @Test
    public void testInvalidInput(){
        assertFalse(calc.validateInput("asdf"));
        assertFalse(calc.validateInput("234^33"));
    }

}