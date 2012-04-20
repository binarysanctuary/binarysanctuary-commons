package com.binarysanctuary.commons.coreext;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.binarysanctuary.commons.coreext.Array.$;

public class ArrayTest {
    @DataProvider
    public Object[][] itShouldShiftTheArray() {
        return new Object[][] {
                {$(0, 1, 2, 3, 4, 5), 0, $(0, 0, 1, 2, 3, 4)},
                {$(0, 1, 2, 3, 4, 5), 1, $(0, 1, 1, 2, 3, 4)},
                {$(0, 1, 2, 3, 4, 5), 2, $(0, 1, 2, 2, 3, 4)},
                {$(0, 1, 2, 3, 4, 5), 3, $(0, 1, 2, 3, 3, 4)},
                {$(0, 1, 2, 3, 4, 5), 4, $(0, 1, 2, 3, 4, 4)},
                {$(0, 1, 2, 3, 4, 5), 5, $(0, 1, 2, 3, 4, 5)},
        };
    }

    @Test(dataProvider = "itShouldShiftTheArray")
    public void itShouldShiftRightAnArrayStartingFromGivenIndex(Object[] array, int idx, Object[] expected) {
        Array.rshift(array, idx);
        Assert.assertEquals(array, expected);
    }

    @DataProvider
    public Object[][] itShouldThrowIAEWhenRightShiftingAnArray() {
        return new Object[][] {
                {$(0, 1, 2, 3, 4, 5), 6},
                {$(0, 1, 2, 3, 4, 5), -1},
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "itShouldThrowIAEWhenRightShiftingAnArray")
    public void itShouldThrowIAEWhenRightShiftingAnArray(Object[] array, int idx) {
        Array.rshift(array, idx);
    }
}
