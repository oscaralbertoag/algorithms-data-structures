package algorithm.bubblesort;

import org.junit.Test;
import util.ArrayUtil;

import static org.junit.Assert.*;

/**
 * Created by oscar on 7/19/16.
 */
public class BubblesortTest {

    @Test
    public void sortTest() {
        Bubblesort bubblesort = new Bubblesort();
        int[] expectedArray = {0,2,4,5,6,7,8,84};

        int[] testArray = {2,4,6,7,5,8,84,0};
        bubblesort.sort(testArray);
        ArrayUtil.print(testArray);
        for(int i=0; i<testArray.length; i++){
            assertEquals(testArray[i], expectedArray[i]);
        }
    }


    @Test
    public void sortTest_duplicates() {
        Bubblesort bubblesort = new Bubblesort();
        int[] expectedArray = {0,0,2,4,4,5,6,7,8,8,8,84,84};

        int[] testArray = {8,2,0,4,4,84,6,7,5,8,84,8,0};
        bubblesort.sort(testArray);
        ArrayUtil.print(testArray);
        for(int i=0; i<testArray.length; i++){
            assertEquals(testArray[i], expectedArray[i]);
        }
    }
}