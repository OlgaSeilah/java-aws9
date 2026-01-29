package test;

import main.VarargUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HW1Test {
    @Test
    void maxThrowsOnNoArguments() {
        assertThrows(IllegalArgumentException.class, () -> {
            VarargUtils.max(); // метод где-то в классе VarargUtils
        });
    }

    @Test
    void maxReturnsSingleValueWhenOneArgument() {
        int result = VarargUtils.max(5);
        assertEquals(5, result, "Max of single element should be that element");
    }

    @Test
    void maxOfSeveralPositiveNumbers() {
        int result = VarargUtils.max(1, 5, 2);
        assertEquals(5, result, "Max of 1,5,2 should be 5");
    }

    @Test
    void maxOfNegativeNumbers() {
        int result = VarargUtils.max(-10, -3, -7);
        assertEquals(-3, result, "Max of -10,-3,-7 should be -3");
    }

    @Test
    void maxWorksWithArrayArgument() {
        int[] values = {3, 7, 2};
        int result = VarargUtils.max(values); // max(new int[]{3,7,2})
        assertEquals(7, result, "Max of {3,7,2} should be 7");
    }

    @Test
    void maxHandlesExtremeIntValues() {
        int result = VarargUtils.max(Integer.MIN_VALUE, -100, -50);
        assertEquals(-50, result, "Max should be the greatest int value");
    }
}
