package codelab.plusone;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class PlusOneTest {

    @Test
    @Parameters(method = "plusOneParams")
    public void plusOne(List<Integer> expected, ArrayList<Integer> number) {
        PlusOne plusOne = new PlusOne();
        ArrayList<Integer> result = plusOne.plusOne(number);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    public Object[] plusOneParams() {
        Object[] scenario1 = { Arrays.asList(1, 0, 0), arrayList( 9, 9) };
        Object[] scenario2 = { Arrays.asList(8, 9), arrayList(8, 8) };
        Object[] scenario3 = { Arrays.asList(2, 0, 0, 0, 0), arrayList(1, 9, 9, 9, 9) };
        Object[] scenario4 = { Arrays.asList(3, 7, 6, 4, 0, 5, 5, 6), arrayList(0, 3, 7, 6, 4, 0, 5, 5, 5) };
        Object[] scenario5 = { Arrays.asList(1), arrayList(0) };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5 };
    }

    @Test
    public void addOneLeftmostDigit() {
    }

    private ArrayList<Integer> arrayList(int... numbers) {
        ArrayList<Integer> num = new ArrayList<>();
        for (int i : numbers) {
            num.add(i);
        }
        return num;
    }

}