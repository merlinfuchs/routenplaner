public class DijkstraNode {
    private Node node;
    private float costs;
    private Node predecessor;
    private Boolean visited;
    public DijkstraNode(Node node, float costs){
        this.node = node;
        this.costs = costs;
        this.visited = false;
    }
    public Node getNode() {
        return node;
    }
    public Boolean getVisited() {
        return visited;
    }
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public float getCosts() {
        return costs;
    }
    public void setCosts(float costs) {
        this.costs = costs;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }
}
