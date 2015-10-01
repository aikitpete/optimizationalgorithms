package com.piglin.optimization.graphdirected;


public class DirectedVertex implements Comparable<DirectedVertex>
{
    public final String name;

    public DirectedEdge[] adjacencies;

    public double minDistance = Double.POSITIVE_INFINITY;

    public DirectedVertex previous;

    public DirectedVertex(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public int compareTo(DirectedVertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
