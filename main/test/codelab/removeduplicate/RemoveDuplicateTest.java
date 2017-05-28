package codelab.removeduplicate;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class RemoveDuplicateTest {

    @Test
    @Parameters(method = "removeDuplicatesParams")
    public void removeDuplicates(ArrayList<Integer> a, int expectedSize) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        assertEquals(expectedSize, removeDuplicate.removeDuplicates(a));
    }

    public Object[] removeDuplicatesParams() {
        Object[] scenario1 = { getArrayList(1, 1, 1, 2, 2, 3), 3 };

        return new Object[] { scenario1 };
    }

    private ArrayList<Integer> getArrayList(int... array) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int a : array) {
            arrayList.add(a);
        }

        return arrayList;
    }

}