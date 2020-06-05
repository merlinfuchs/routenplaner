import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Dijkstra {
    private List<DijkstraNode> dijkstraNodes;
    public Dijkstra(){
        this.dijkstraNodes = new ArrayList<>();
    }
    public HashSet<Edge> routingEdges(Node sourceNode, Node targetNode) {
        calculateAllCostsFromSourceNode(sourceNode);
        return getBestRouteEdges(sourceNode, targetNode);
    }
    //Calculate all Costs from start Point with Dijkstra
    private void calculateAllCostsFromSourceNode(Node sourceNode){
        dijkstraNodes.add(new DijkstraNode(sourceNode, 0)); //Add start Node
        while (true) {
            DijkstraNode nextNode = getNotVisitedLowestCostNode();
            if(nextNode == null){
                break; //All Nodes visited
            }
            addNewNodes(nextNode);
        }
    }
    private HashSet<Edge> getBestRouteEdges(Node sourceNode, Node targetNode){
        HashSet<Edge> edges = new HashSet<>();
        DijkstraNode curredNode = findDijkstraNode(targetNode);
        while (true){
            if (sourceNode.getName().equalsIgnoreCase(curredNode.getNode().getName())){ //Found source Node
                break;
            }
            edges.add(findEdge(curredNode.getPredecessor(), curredNode.getNode()));
            curredNode = findDijkstraNode(curredNode.getPredecessor());
        }
        return edges;
    }
    private Edge findEdge(Node sourceNode, Node targetNode){
        for(Edge e : sourceNode.getEdges()){
            if(e.getSource().getName().equalsIgnoreCase(sourceNode.getName()) && e.getTarget().getName().equalsIgnoreCase(targetNode.getName())){
                return e;
            }
        }
        return null;
    }
    private DijkstraNode getNotVisitedLowestCostNode(){
        DijkstraNode nextNode = null;
        for(DijkstraNode dNode : dijkstraNodes){
            if(nextNode == null && !dNode.getVisited()){
                nextNode = dNode;
            }
            if(nextNode != null && !dNode.getVisited() && dNode.getCosts() < nextNode.getCosts()){ // Check if visited and if Costs lower than curred lowest Node
                nextNode = dNode;
            }
        }
        return nextNode;
    }
    private void addNewNodes(DijkstraNode dNode){
        for(Edge e : dNode.getNode().getEdges()){
            DijkstraNode existingNode = findDijkstraNode(e.getTarget());
            if(existingNode == null) {
                DijkstraNode node = new DijkstraNode(e.getTarget(), dNode.getCosts() + e.getLength());
                node.setPredecessor(dNode.getNode());
                dijkstraNodes.add(node);

            }
            else {
                if(existingNode.getCosts() > (dNode.getCosts() +e.getLength())){
                    existingNode.setCosts(dNode.getCosts() + e.getLength());
                    existingNode.setPredecessor(dNode.getNode());
                }
            }
        }
        dNode.setVisited(true);
    }
    private DijkstraNode findDijkstraNode(Node node){
        for(DijkstraNode dNode : dijkstraNodes){
            if(dNode.getNode().getName().equalsIgnoreCase(node.getName())){
                return dNode;
            }
        }
        return null;
    }
}