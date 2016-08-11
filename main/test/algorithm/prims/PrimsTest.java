package algorithm.prims;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oscar on 8/5/16.
 */
public class PrimsTest {

    @Test
    public void findMinimumSpanningTreeTest() {
        Prims primsAlgorithm = new Prims(5);

        primsAlgorithm.addEdge(0,2,1);
        primsAlgorithm.addEdge(0,1,2);
        primsAlgorithm.addEdge(0,3,5);
        primsAlgorithm.addEdge(1,0,2);
        primsAlgorithm.addEdge(1,2,4);
        primsAlgorithm.addEdge(1,3,7);
        primsAlgorithm.addEdge(2,0,1);
        primsAlgorithm.addEdge(2,1,4);
        primsAlgorithm.addEdge(2,3,3);
        primsAlgorithm.addEdge(3,0,5);
        primsAlgorithm.addEdge(3,1,7);
        primsAlgorithm.addEdge(3,2,3);
        primsAlgorithm.addEdge(3,4,6);
        primsAlgorithm.addEdge(1,4,3);
        primsAlgorithm.addEdge(4,1,3);
        primsAlgorithm.addEdge(4,3,6);

        StringBuilder sb = new StringBuilder();
        sb.append("(0) --1--> (2)").append(System.lineSeparator());
        sb.append("(0) --2--> (1)").append(System.lineSeparator());
        sb.append("(1) --3--> (4)").append(System.lineSeparator());
        sb.append("(2) --3--> (3)").append(System.lineSeparator());
        String expected = sb.toString();

        primsAlgorithm.findMinimumSpanningTree();
        assertEquals(expected, primsAlgorithm.minimumSpanningTreeToString());

    }
}