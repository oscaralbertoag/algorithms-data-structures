package codelab.maxset;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class MaxSetTest {

    @Test
    @Parameters(method = "maxsetParams")
    public void maxset(List<Integer> expected, List<Integer> a) {
        MaxSet solution = new MaxSet();

        ArrayList<Integer> maxset = solution.maxset(a);
        compareLists(expected, maxset);
    }

    public Object[] maxsetParams() {
        Object[] scenario1 = { Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3, -4) };
        Object[] scenario2 = { Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1, -1, 3) };
        Object[] scenario3 = { Arrays.asList(1, 2, 1), Arrays.asList(1, 2, 1, -1, 1, 1, 2) };
        Object[] scenario4 = { new ArrayList<>(), Arrays.asList(-1, -2, -3, -4, -5) };
        Object[] scenario5 = { new ArrayList<>(), new ArrayList<>() };
        Object[] scenario6 = { Arrays.asList(15, 10), Arrays.asList(1, 2, 3, 4, 5, -10, 15, 10, -2, 1, 22) };
        Object[] scenario7 = { Collections.singletonList(15), Arrays.asList(2, 3, 4, 5, -1, 15) };
        Object[] scenario8 = { Arrays.asList(1, 1), Arrays.asList(2, -1, 1, 1, -3, 0, 2) };
        Object[] scenario9 = { Arrays.asList(0, 0), Arrays.asList(0, 0, -1, 0) };
        Object[] scenario10 =
            { Arrays.asList(1967513926, 1540383426), Arrays.asList(1967513926, 1540383426, -1303455736, -521595368) };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5, scenario6, scenario7, scenario8, scenario9,
            scenario10 };
    }

    private void compareLists(List<Integer> a, List<Integer> b) {
        if ((a == null && b != null) || a != null && b == null) {
            fail("One list is null while the other one isn't");
        }
        if (a != null) {
            if (((a.isEmpty() && !b.isEmpty()) || (!a.isEmpty() && b.isEmpty()))) {
                fail("One list is empty while the other one isn't");
            } else {
                assertEquals("Size discrepancy!", a.size(), b.size());
                for (int i = 0; i < a.size(); i++) {
                    assertEquals(a.get(i), b.get(i));
                }
            }
        }
    }

}