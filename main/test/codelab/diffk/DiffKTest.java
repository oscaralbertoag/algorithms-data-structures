package codelab.diffk;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DiffKTest {

    @Test
    @Parameters(method = "diffPossibleParams")
    public void diffPossible(int expected, ArrayList<Integer> list, int diff) {
        DiffK diffK = new DiffK();
        assertEquals(expected, diffK.diffPossible(list, diff));
    }

    public Object[] diffPossibleParams() {
        Object[] scenario1 = { 1, getArrayList(1, 3, 7, 10), 4 };
        Object[] scenario2 = { 1, getArrayList(1, 3, 5), 4 };
        Object[] scenario3 = { 0, getArrayList(1, 2, 3, 4), 10 };

        return new Object[] { scenario1, scenario2, scenario3 };
    }

    private ArrayList<Integer> getArrayList(int... array) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int a : array) {
            arrayList.add(a);
        }

        return arrayList;
    }

}