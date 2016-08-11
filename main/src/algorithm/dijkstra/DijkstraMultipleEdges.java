package algorithm.dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by oscar on 8/1/16.
 */
public class DijkstraMultipleEdges {
    private PriorityQueue<Vertex2> verticesMinHeap = new PriorityQueue<>();

    public DijkstraMultipleEdges(List<Vertex2> verticesList) {
        for (Vertex2 vertex : verticesList) {
            verticesMinHeap.add(vertex);
        }
    }

    public void findShortestPaths() {
        while (!verticesMinHeap.isEmpty()) {
            Vertex2 minVertex = verticesMinHeap.poll();
            int cost;
            for (Edge2 edge : minVertex.getEdges()) {
                cost = minVertex.getMin() + edge.getWeight();
                if(cost < edge.getVertex().getMin()) {
                    verticesMinHeap.remove(edge.getVertex()); // Remove vertex with 'infinite cost' or greater cost
                    edge.getVertex().setMin(cost);
                    verticesMinHeap.add(edge.getVertex()); // Insert vertex with new 'cost'
                    edge.getVertex().setPrevious(minVertex);
                    edge.getVertex().setMinCostToPrevious(edge.getWeight());
                }
            }
        }
    }


    public void printShortestPath(Vertex2 vertex){
        if(vertex!=null) {
            System.out.println("Shortest path for " + vertex.getId() + ":");
            Vertex2 current = vertex;
            do{
                System.out.print("|" + current.getId() + " (cost:" + current.getMinCostToPrevious() + ")| ");
                current = current.getPrevious();
            }
            while(current != null);
            System.out.println();
        }
    }

    public int getCostfromVertexToStart(Vertex2 vertex) {
        // Vertex is null OR we have no previous and we haven't reached the start node yet (unreachable)
        if(vertex == null || (vertex.getPrevious() == null && !vertex.isStartVertex())) {
            return -1;
        } else if(vertex.getPrevious() != null) {
            return vertex.getMinCostToPrevious() + getCostfromVertexToStart(vertex.getPrevious());
        } else {
            return 0;
        }
    }

    public int getCostFromVertexToStartIterative(Vertex2 vertex) {
        Vertex2 current = vertex;
        Vertex2 visitedFirst = vertex;
        int cost = 0;
        while(!current.isStartVertex()) {
            cost += current.getMinCostToPrevious();
            if(current.getPrevious() != null) {
                current = current.getPrevious();
            } else {
                return -1;
            }
        }
        return cost;
    }

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/main/src/algorithm/dijkstra/input2.txt"));

        int testCases = in.nextInt();

        for(int k=0; k<testCases; k++) {
            int nodes = in.nextInt();
            int edges = in.nextInt();
            // Build Vertices
            HashMap<Integer, Vertex2> vertices = new HashMap<>();
            for(int i=1; i<=nodes; i++) {
                vertices.put(i, new Vertex2(i));
            }
            // Add Edges
            int from, to;
            for(int i=0; i<edges; i++) {
                from = in.nextInt();
                to = in.nextInt();
                vertices.get(from).addEdge(6, vertices.get(to));
                vertices.get(to).addEdge(6, vertices.get(from));
            }
            // Mark start vertex
            int start = in.nextInt();
            vertices.get(start).setStartVertex(true);
            // Solve
            DijkstraMultipleEdges dijkstras = new DijkstraMultipleEdges(new ArrayList<>(vertices.values()));
            dijkstras.findShortestPaths();
            for(int i=1; i<=vertices.size(); i++) {
                if(i!=start){
                    System.out.print(dijkstras.getCostFromVertexToStartIterative(vertices.get(i)) + " ");
                }
            }
            System.out.println();
        }
    }
}

class Vertex2 implements Comparable<Vertex2> {

    private boolean startVertex;
    private int id;
    private List<Edge2> edges = new ArrayList<>();
    private Vertex2 previous;
    private int minCostToPrevious;
    private int min = Integer.MAX_VALUE; // Initialize to "infinity"

    public Vertex2(int id) {
        this.id = id;
    }

    public Vertex2(int id, int min) {
        this.id = id;
        this.min = min;
        startVertex = true;
    }

    public boolean isStartVertex() {
        return startVertex;
    }

    public void setStartVertex(boolean startVertex) {
        this.startVertex = startVertex;
    }

    public int getId(){
        return id;
    }

    public List<Edge2> getEdges() {
        return edges;
    }

    public Vertex2 getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex2 vertex) {
        previous = vertex;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int newMin) {
        min = newMin;
    }

    public void addEdge(int weight, Vertex2 vertex) {
        edges.add(new Edge2(weight, vertex));
    }

    public int getMinCostToPrevious() {
        return minCostToPrevious;
    }

    public void setMinCostToPrevious(int minCostToPrevious) {
        this.minCostToPrevious = minCostToPrevious;
    }

    @Override
    public int compareTo(Vertex2 vertex) {
        return Integer.compare(min, vertex.getMin());
    }
}

class Edge2 {
    private int weight;
    private Vertex2 vertex;

    public Edge2(int weight, Vertex2 vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }

    public int getWeight(){
        return weight;
    }

    public Vertex2 getVertex() {
        return vertex;
    }
}
