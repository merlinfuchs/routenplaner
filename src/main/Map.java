package main;

import javafx.scene.image.Image;

class Point {
    public float x;
    public float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
}


class ReferencePoint {
    public float lat;
    public float lon;
    public Point point;

    public ReferencePoint(float lat, float lon, Point point) {
        this.lat = lat;
        this.lon = lon;
        this.point = point;
    }
}


public class Map {
    private Image image;

    private ReferencePoint referencePoint;
    private float pixelPerLat;
    private float pixelPerLon;

    public Map(Image image, ReferencePoint firstReference, ReferencePoint secondReference) {
        this.image = image;

        // Save one reference point for later calculations
        referencePoint = firstReference;

        // Calculate how many pixels represent one lat and one lon
        pixelPerLat = Math.abs((secondReference.point.y - firstReference.point.y) / (secondReference.lat - firstReference.lat));
        pixelPerLon = Math.abs((secondReference.point.x - firstReference.point.x) / (secondReference.lon - firstReference.lon));
    }

    public Point translate(Node node) {
        float latDifference = referencePoint.lat - node.getLat();
        float lonDifference = referencePoint.lon - node.getLon();

        return new Point(
                referencePoint.point.x + (lonDifference * -pixelPerLon),
                referencePoint.point.y + (latDifference * pixelPerLat)
        );
    }

    public Image getImage() {
        return image;
    }
}
