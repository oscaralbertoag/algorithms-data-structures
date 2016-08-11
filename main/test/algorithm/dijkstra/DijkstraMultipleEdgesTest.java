package algorithm.dijkstra;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by oscar on 8/1/16.
 */
public class DijkstraMultipleEdgesTest {

    @Test
    public void findShortestPathsWithParallelEdges() {
        List<Vertex2> vertices = new ArrayList<>();
        vertices.add(new Vertex2(0,0)); // Starting node
        vertices.add(new Vertex2(1));
        vertices.add(new Vertex2(2));
        vertices.add(new Vertex2(3));

        vertices.get(0).addEdge(24,vertices.get(1));
        vertices.get(0).addEdge(3,vertices.get(2));
        vertices.get(0).addEdge(10,vertices.get(2));
        vertices.get(0).addEdge(20,vertices.get(3));
        vertices.get(1).addEdge(24,vertices.get(0));
        vertices.get(2).addEdge(10,vertices.get(0));
        vertices.get(2).addEdge(3,vertices.get(0));
        vertices.get(2).addEdge(12,vertices.get(3));
        vertices.get(3).addEdge(12,vertices.get(2));
        vertices.get(3).addEdge(20,vertices.get(0));

        DijkstraMultipleEdges dijkstraUnderTest = new DijkstraMultipleEdges(vertices);
        dijkstraUnderTest.findShortestPaths();
        dijkstraUnderTest.printShortestPath(vertices.get(0));
        dijkstraUnderTest.printShortestPath(vertices.get(1));
        dijkstraUnderTest.printShortestPath(vertices.get(2));
        dijkstraUnderTest.printShortestPath(vertices.get(3));
    }

    @Test
    public void getCostOfVertexTest() {
        List<Vertex2> vertices = new ArrayList<>();
        vertices.add(new Vertex2(0,0)); // Starting node
        vertices.add(new Vertex2(1));
        vertices.add(new Vertex2(2));
        vertices.add(new Vertex2(3));

        vertices.get(0).addEdge(24,vertices.get(1));
        vertices.get(0).addEdge(3,vertices.get(2));
        vertices.get(0).addEdge(10,vertices.get(2));
        vertices.get(0).addEdge(20,vertices.get(3));
        vertices.get(1).addEdge(24,vertices.get(0));
        vertices.get(2).addEdge(10,vertices.get(0));
        vertices.get(2).addEdge(3,vertices.get(0));
        vertices.get(2).addEdge(12,vertices.get(3));
        vertices.get(3).addEdge(12,vertices.get(2));
        vertices.get(3).addEdge(20,vertices.get(0));

        DijkstraMultipleEdges dijkstraUnderTest = new DijkstraMultipleEdges(vertices);
        dijkstraUnderTest.findShortestPaths();

        int[] expected = {0, 24, 3, 15};
        for(int i=0; i<expected.length; i++) {
            assertEquals(expected[i], dijkstraUnderTest.getCostfromVertexToStart(vertices.get(i)));
        }
    }

    @Test
    public void getCostOfVertexTest_2() {
        List<Vertex2> vertices = new ArrayList<>();
        vertices.add(new Vertex2(0,0)); // Starting node
        vertices.add(new Vertex2(1));
        vertices.add(new Vertex2(2));
        vertices.add(new Vertex2(3));

        vertices.get(0).addEdge(6,vertices.get(1));
        vertices.get(0).addEdge(6,vertices.get(2));
        vertices.get(1).addEdge(6,vertices.get(0));
        vertices.get(2).addEdge(6,vertices.get(0));

        DijkstraMultipleEdges dijkstraUnderTest = new DijkstraMultipleEdges(vertices);
        dijkstraUnderTest.findShortestPaths();

        int[] expected = {0, 6, 6, -1};
        for(int i=0; i<expected.length; i++) {
            assertEquals("i="+ i, expected[i], dijkstraUnderTest.getCostfromVertexToStart(vertices.get(i)));
        }

    }

    @Test
    public void getCostOfVertexTest_3() {
        List<Vertex2> vertices = new ArrayList<>();
        vertices.add(new Vertex2(0));
        vertices.add(new Vertex2(1,0)); // Starting node
        vertices.add(new Vertex2(2));
        vertices.add(new Vertex2(3));

        vertices.get(0).addEdge(6,vertices.get(1));
        vertices.get(0).addEdge(6,vertices.get(2));
        vertices.get(1).addEdge(6,vertices.get(0));
        vertices.get(2).addEdge(6,vertices.get(0));

        DijkstraMultipleEdges dijkstraUnderTest = new DijkstraMultipleEdges(vertices);
        dijkstraUnderTest.findShortestPaths();

        int[] expected = {6, 0, 12, -1};
        for(int i=0; i<expected.length; i++) {
            assertEquals("i="+ i, expected[i], dijkstraUnderTest.getCostfromVertexToStart(vertices.get(i)));
        }

    }

    @Test
    public void getCostOfVertexIterativeTest() {
        List<Vertex2> vertices = new ArrayList<>();
        vertices.add(new Vertex2(0,0)); // Starting node
        vertices.add(new Vertex2(1));
        vertices.add(new Vertex2(2));
        vertices.add(new Vertex2(3));

        vertices.get(0).addEdge(24,vertices.get(1));
        vertices.get(0).addEdge(3,vertices.get(2));
        vertices.get(0).addEdge(10,vertices.get(2));
        vertices.get(0).addEdge(20,vertices.get(3));
        vertices.get(1).addEdge(24,vertices.get(0));
        vertices.get(2).addEdge(10,vertices.get(0));
        vertices.get(2).addEdge(3,vertices.get(0));
        vertices.get(2).addEdge(12,vertices.get(3));
        vertices.get(3).addEdge(12,vertices.get(2));
        vertices.get(3).addEdge(20,vertices.get(0));

        DijkstraMultipleEdges dijkstraUnderTest = new DijkstraMultipleEdges(vertices);
        dijkstraUnderTest.findShortestPaths();

        int[] expected = {0, 24, 3, 15};
        for(int i=0; i<expected.length; i++) {
            assertEquals(expected[i], dijkstraUnderTest.getCostFromVertexToStartIterative(vertices.get(i)));
        }
    }

    @Test
    public void getCostOfVertexIterativeTest_2() {
        List<Vertex2> vertices = new ArrayList<>();
        vertices.add(new Vertex2(0,0)); // Starting node
        vertices.add(new Vertex2(1));
        vertices.add(new Vertex2(2));
        vertices.add(new Vertex2(3));

        vertices.get(0).addEdge(6,vertices.get(1));
        vertices.get(0).addEdge(6,vertices.get(2));
        vertices.get(1).addEdge(6,vertices.get(0));
        vertices.get(2).addEdge(6,vertices.get(0));

        DijkstraMultipleEdges dijkstraUnderTest = new DijkstraMultipleEdges(vertices);
        dijkstraUnderTest.findShortestPaths();

        int[] expected = {0, 6, 6, -1};
        for(int i=0; i<expected.length; i++) {
            assertEquals("i="+ i, expected[i], dijkstraUnderTest.getCostFromVertexToStartIterative(vertices.get(i)));
        }

    }

    @Test
    public void getCostOfVertexIterativeTest_3() {
        List<Vertex2> vertices = new ArrayList<>();
        vertices.add(new Vertex2(0));
        vertices.add(new Vertex2(1,0)); // Starting node
        vertices.add(new Vertex2(2));
        vertices.add(new Vertex2(3));

        vertices.get(0).addEdge(6,vertices.get(1));
        vertices.get(0).addEdge(6,vertices.get(2));
        vertices.get(1).addEdge(6,vertices.get(0));
        vertices.get(2).addEdge(6,vertices.get(0));

        DijkstraMultipleEdges dijkstraUnderTest = new DijkstraMultipleEdges(vertices);
        dijkstraUnderTest.findShortestPaths();

        int[] expected = {6, 0, 12, -1};
        for(int i=0; i<expected.length; i++) {
            assertEquals("i="+ i, expected[i], dijkstraUnderTest.getCostFromVertexToStartIterative(vertices.get(i)));
        }

    }

}