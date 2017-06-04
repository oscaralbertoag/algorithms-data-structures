package codelab.pascalsnth;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class PascalsNthTest {
    @Test
    @Parameters(method = "getRowParams")
    public void getRow(int k, ArrayList<Integer> expectedRow) {
        PascalsNth pascalsNth = new PascalsNth();
        ArrayList<Integer> result = pascalsNth.getRow(k);

        assertEquals(expectedRow.size(), result.size());
        for (int i = 0; i < expectedRow.size(); i++) {
            assertEquals(expectedRow.get(i), result.get(i));
        }
    }

    public Object[] getRowParams() {
        Object[] scenario1 = { 2, toArrayList(1, 2, 1) };
        Object[] scenario2 = { 3, toArrayList(1, 3, 3, 1) };
        Object[] scenario3 = { 4, toArrayList(1, 4, 6, 4, 1) };
        Object[] scenario4 = { 5, toArrayList(1, 5, 10, 10, 5, 1) };
        Object[] scenario5 = { 6, toArrayList(1, 6, 15, 20, 15, 6, 1) };
        Object[] scenario6 = { 7, toArrayList(1, 7, 21, 35, 35, 21, 7, 1) };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5, scenario6 };
    }

    private ArrayList<Integer> toArrayList(int... numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : numbers) {
            arrayList.add(i);
        }
        return arrayList;
    }
}