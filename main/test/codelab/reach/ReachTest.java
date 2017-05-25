package codelab.reach;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ReachTest {

    @Test
    @Parameters(method = "coverPointsParams")
    public void coverPoints(List<Integer> X, List<Integer> Y, int expected) {
        Reach reach = new Reach();
        assertEquals(expected, reach.coverPoints(X, Y));
    }

    public Object[] coverPointsParams() {
        Object[] scenario1 = { Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 1), 2 };
        Object[] scenario2 = { Arrays.asList(0, 3, 4, 4), Arrays.asList(1, 3, 2, 0), 6 };
//        Object[] scenario3 = { Arrays.asList(18, -4, 1, -4, 8, -11, -12, -13, -3, -4, -4, -14, 7, -2, -2, -5, 5, -1, 0),
//            Arrays.asList(18, -8, -15, -4, 3, 11, 8, -15, 4, 1, 7, 3, 9, -9, -9, -13, 10, -14, -8), 209 };

        return new Object[] { scenario1, scenario2/*, scenario3 */};
    }
}