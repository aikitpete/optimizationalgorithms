package com.piglin.optimization.graphdirected;

public class DirectedEdge
{
    public final DirectedVertex origin;
    public final DirectedVertex target;
    public final double weight;

    public DirectedEdge(DirectedVertex origin, DirectedVertex target, double weight) {
        this.origin = origin;
        this.target = target;
        this.weight = weight;
    }
}

