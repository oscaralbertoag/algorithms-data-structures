package codejam.sherlockandwatson;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;

/**
 * Created by oscar on 7/18/16.
 */
public class SherlockAndWatsonTest {


    @Test
    public void executeQueriesTest_1() {
        int[] testArray = {1,2,3};
        int[] queryArray = {0,1,2};
        SherlockAndWatson sherlockAndWatson = new SherlockAndWatson(testArray, 3, 4, queryArray);

        int[] expectedArray = {3,1,2};
        for(int i=0; i<3; i++) {
            assertEquals(expectedArray[i], sherlockAndWatson.getRotatedPosition(i));
        }
    }

//    @Ignore
    @Test
    public void executeQueriesTest_2() {
        int[] testArray = {1,2,3};
        int[] queryArray = {0,1,2};
        SherlockAndWatson sherlockAndWatson = new SherlockAndWatson(testArray, 3, 6, queryArray);

        int[] expectedArray = {1,2,3};
        for(int i=0; i<3; i++) {
            assertEquals(expectedArray[i], sherlockAndWatson.getRotatedPosition(i));
        }
    }

//    @Ignore
    @Test
    public void executeQueriesTest_3() {
        int[] testArray = {1,2,3};
        int[] queryArray = {0,1,2};
        SherlockAndWatson sherlockAndWatson = new SherlockAndWatson(testArray, 3, 7, queryArray);

        int[] expectedArray = {3,1,2};
        for(int i=0; i<3; i++) {
            assertEquals(expectedArray[i], sherlockAndWatson.getRotatedPosition(i));
        }
    }

//    @Ignore
    @Test
    public void executeQueriesTest_4() {
        int[] testArray = {1,2,3};
        int[] queryArray = {2,3,1};
        SherlockAndWatson sherlockAndWatson = new SherlockAndWatson(testArray, 3, 2, queryArray);

        int[] expectedArray = {2,3,1};
        for(int i=0; i<3; i++) {
            assertEquals(expectedArray[i], sherlockAndWatson.getRotatedPosition(i));
        }
    }
}