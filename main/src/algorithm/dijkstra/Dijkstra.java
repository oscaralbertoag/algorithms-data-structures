package algorithm.dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by oscar on 7/13/16.
 */
public class Dijkstra {

    private PriorityQueue<Vertex> verticesMinHeap = new PriorityQueue<>();

    public Dijkstra(List<Vertex> verticesList) {
        for (Vertex vertex : verticesList) {
            verticesMinHeap.add(vertex);
        }
    }

    public void findShortestPaths() {
        while (!verticesMinHeap.isEmpty()) {
            Vertex minVertex = verticesMinHeap.poll();
            int cost;
            for (Edge edge : minVertex.getEdges()) {
                cost = minVertex.getMin() + edge.getWeight();
                if(cost < edge.getVertex().getMin()) {
                    verticesMinHeap.remove(edge.getVertex()); // Remove vertex with 'infinite cost' or greater cost
                    edge.getVertex().setMin(cost);
                    verticesMinHeap.add(edge.getVertex()); // Insert vertex with new 'cost'
                    edge.getVertex().setPrevious(minVertex);
                }
            }
        }
    }


    public void printShortestPath(Vertex vertex){
        if(vertex!=null) {
            System.out.println("Shortest path for " + vertex.getId() + ":");
            Vertex current = vertex;
            do{
                System.out.print("|" + current.getId() + "|");
                current = current.getPrevious();
            }
            while(current != null);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/main/src/algorithm/dijkstra/input.txt"));

        int numOfVertices = in.nextInt();
        int startVertex = in.nextInt();

        // Build vertices
        List<Vertex> vertexList = new ArrayList<>();
        for(int i=0; i<numOfVertices; i++) {
            if(i == startVertex) {
                // Mark the starting vertex with min = 0;
                vertexList.add(new Vertex(i, 0));
            } else {
                vertexList.add(new Vertex(i));
            }
        }

        // Build edges
        int fromVertex, toVertex, weight;
        while(in.hasNextInt()) {
            fromVertex = in.nextInt();
            toVertex = in.nextInt();
            weight = in.nextInt();
            vertexList.get(fromVertex).addEdge(weight, vertexList.get(toVertex));
        }

        // Initialize Dijkstra's algorithm
        Dijkstra dijkstra = new Dijkstra(vertexList);
        dijkstra.findShortestPaths();
        dijkstra.printShortestPath(vertexList.get(3));
    }

}

class Vertex implements Comparable<Vertex> {

    private int id;
    private List<Edge> edges = new ArrayList<>();
    private Vertex previous;
    private int min = Integer.MAX_VALUE; // Initialize to "infinity"

    public Vertex(int id) {
        this.id = id;
    }

    public Vertex(int id, int min) {
        this.id = id;
        this.min = min;
    }

    public int getId(){
        return id;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex vertex) {
        previous = vertex;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int newMin) {
        min = newMin;
    }

    public void addEdge(int weight, Vertex vertex) {
        edges.add(new Edge(weight, vertex));
    }

    @Override
    public int compareTo(Vertex vertex) {
        return Integer.compare(min, vertex.getMin());
    }
}

class Edge {
    private int weight;
    private Vertex vertex;

    public Edge(int weight, Vertex vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }

    public int getWeight(){
        return weight;
    }

    public Vertex getVertex() {
        return vertex;
    }
}
