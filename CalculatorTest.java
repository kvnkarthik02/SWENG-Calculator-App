

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
        assertEquals(Arrays.asList("-15"), calc.BEMDAS("5+5*2"));
        assertEquals(Arrays.asList("77"), calc.BEMDAS("2*4*9+5"));

    }

    @Test
    public void testInvalidInput(){
        assertFalse(calc.validateInput("asdf"));
        assertFalse(calc.validateInput("234^33"));

        assertFalse(calc.validateInput("Hi"));
        assertFalse(calc.validateInput("1(&"));
    }

}
