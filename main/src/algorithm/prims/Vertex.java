package algorithm.prims;

/**
 * Created by oscar on 8/5/16.
 */
public class Vertex {

    private int id;
    private boolean visited = false;

    public Vertex(int id) {
        this.id = id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getId() {
        return id;
    }

}
