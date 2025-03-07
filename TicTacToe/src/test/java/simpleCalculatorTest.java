import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class simpleCalculatorTest {

    @Test
    void testAddition() {
        assertEquals(10, simpleCalculator.calculate(6, 4, '+'));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, simpleCalculator.calculate(6, 4, '-'));
    }

    @Test
    void testMultiplication() {
        assertEquals(24, simpleCalculator.calculate(6, 4, '*'));
    }

    @Test
    void testDivision() {
        assertEquals(1.5, simpleCalculator.calculate(6, 4, '/'));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            simpleCalculator.calculate(6, 0, '/')
        );
        assertEquals("Error! Division by zero.", exception.getMessage());
    }

    @Test
    void testInvalidOperator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            simpleCalculator.calculate(6, 4, '%')
        );
        assertEquals("Invalid operator!", exception.getMessage());
    }
}
