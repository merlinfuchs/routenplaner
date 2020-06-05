package main;

import java.util.HashSet;

public class Node {
    private String name;
    private HashSet<Edge> edges = new HashSet<>();

    private float lat;
    private float lon;

    public Node(String name, float lat, float lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public HashSet<Edge> getEdges() {
        return edges;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }
}
