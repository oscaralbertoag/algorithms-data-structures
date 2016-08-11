package algorithm.prims;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by oscar on 8/4/16.
 */
public class Prims {

    private Edge[][] adjMatrix;
    private PriorityQueue<Edge> minHeap;
    private PriorityQueue<Edge> mst;
    private HashMap<Integer, Vertex> vertices;

    public Prims(int numOfVertices) {
        adjMatrix = new Edge[numOfVertices][numOfVertices];
        minHeap = new PriorityQueue<Edge>(new Comparator<Edge>() {

            @Override
            public int compare(Edge a, Edge b) {
                return Integer.compare(a.getWeight(), b.getWeight());
            }
        });

        mst = new PriorityQueue<Edge>(new Comparator<Edge>() {
           @Override
            public int compare(Edge a, Edge b) {
               int compare = Integer.compare(a.getFrom().getId(), b.getFrom().getId());
               if(compare == 0) {
                   return Integer.compare(a.getWeight(), b.getWeight());
               } else {
                   return compare;
               }
           }
        });

        vertices = new HashMap<>(numOfVertices, 0.75f);
        for(int i=0; i<numOfVertices; i++) {
            vertices.put(i, new Vertex(i));
        }
    }

    public void addEdge(int to, int from, int weight) {
        adjMatrix[from][to] = new Edge(vertices.get(from), vertices.get(to), weight);
    }

    public void findMinimumSpanningTree() {

        for(int i=0; i<adjMatrix.length; i++) {
            for(int j=0; j<adjMatrix[i].length; j++) {
                if(adjMatrix[i][j] != null && !adjMatrix[i][j].getTo().isVisited()){
                    minHeap.add(adjMatrix[i][j]);
                }
            }
            Edge smallestEdge = minHeap.poll();
            if(smallestEdge != null && mst.size() < adjMatrix.length - 1) {
                mst.add(smallestEdge);
            }
            vertices.get(i).setVisited(true);
        }
    }

    public String minimumSpanningTreeToString() {
        Edge edge;
        StringBuilder sb = new StringBuilder();

        while(!mst.isEmpty()){
            edge = mst.poll();
            // e.g. (0) --4--> (2)
            sb.append("(" ).append(edge.getFrom().getId()).append(") --").append(edge.getWeight()).append("--> ");
            sb.append("(").append(edge.getTo().getId()).append(")");
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

}

