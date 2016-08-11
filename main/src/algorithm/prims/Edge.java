package algorithm.prims;

public class Edge {

    private Vertex from;
    private Vertex to;
    private int weight;

    public Edge(Vertex from, Vertex to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex getFrom() {
        return from;
    }

    public void setFrom(Vertex from) {
        this.from = from;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getTo() {
        return to;
    }

    public void setTo(Vertex to) {
        this.to = to;
    }
}
