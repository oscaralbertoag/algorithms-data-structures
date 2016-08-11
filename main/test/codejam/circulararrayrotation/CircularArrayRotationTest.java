package codejam.circulararrayrotation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by oscar on 8/3/16.
 */
public class CircularArrayRotationTest {

    @Test
    public void getNewValueAfterRotationTest(){
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        CircularArrayRotation solutionUnderTest = new CircularArrayRotation(values);
        solutionUnderTest.fillShiftedArray(2);

        assertEquals(2, solutionUnderTest.getNewValueAfterRotation(0));
        assertEquals(3, solutionUnderTest.getNewValueAfterRotation(1));
        assertEquals(1, solutionUnderTest.getNewValueAfterRotation(2));
    }
}