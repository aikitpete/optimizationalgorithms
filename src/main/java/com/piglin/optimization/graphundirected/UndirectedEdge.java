package com.piglin.optimization.graphundirected;

public class UndirectedEdge
{
    public final UndirectedVertex origin;
    public final UndirectedVertex target;
    public final double weight;

    public UndirectedEdge(UndirectedVertex origin, UndirectedVertex target, double weight) {
        this.origin = origin;
        this.target = target;
        this.weight = weight;
    }
}

