package main;

import java.util.HashSet;

public class Router {
    private HashSet<Node> nodes = new HashSet<>();
    private HashSet<Edge> edges = new HashSet<>();

    public Node getNodeByName(String name) {
        for (Node node : nodes) {
            if (node.getName().equalsIgnoreCase(name)) {
                return node;
            }
        }

        return null;
    }

    public Edge getEdgeByName(String name) {
        for (Edge edge : edges) {
            if (edge.getName().equalsIgnoreCase(name)) {
                return edge;
            }
        }

        return null;
    }

    public HashSet<Node> getNodes() {
        return nodes;
    }

    public HashSet<Edge> getEdges() {
        return edges;
    }
}
