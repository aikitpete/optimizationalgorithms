package com.piglin.optimization.graphundirected;



public class UndirectedVertex implements Comparable<UndirectedVertex>
{
    public final String name;

    public UndirectedEdge[] adjacencies;

    public double minDistance = Double.POSITIVE_INFINITY;

    public UndirectedVertex previous;

    public UndirectedVertex(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public int compareTo(UndirectedVertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

    public int startScore;
    public int goalScore;
}
