package technicalassessments.rotatedarray;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class RotatedArrayTest {

    @Test
    @Parameters(method = "findTestParams")
    public void find(int[] array, int numberToFind, int expectedIndex) {
        RotatedArray rotatedArray = new RotatedArray();
        assertEquals(expectedIndex, rotatedArray.find(array, numberToFind));
    }

    public Object[] findTestParams() {
        Object[] scenario1 = { new int[] { 4, 5, 6, 7, 1, 2, 3 }, 1, 4 };
        Object[] scenario2 = { new int[] { 2, 3, 4, 5, 6, 7, 1 }, 8, -1 };
        Object[] scenario3 = { new int[] { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, 4, 8 };
        Object[] scenario4 = { new int[] { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, 9, 4 };

        return new Object[] { scenario1, scenario2, scenario3, scenario4 };
    }

}