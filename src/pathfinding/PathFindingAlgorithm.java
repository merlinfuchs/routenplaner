package pathfinding;

import main.Edge;
import main.Node;

import java.util.ArrayList;

public interface PathFindingAlgorithm {
    ArrayList<Edge> findBestRoute(Node sourceNode, Node targetNode);
}
