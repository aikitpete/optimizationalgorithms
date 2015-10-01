package com.piglin.optimization;

import com.piglin.optimization.graphdirected.DirectedEdge;
import com.piglin.optimization.graphdirected.DirectedVertex;
import com.piglin.optimization.graphundirected.UndirectedVertex;

import java.util.Iterator;
import java.util.List;

public class BellmanFord {

    /*
     * While Dijkstra algorithm assumes all edges have non-negative weights
     * Bellman-Ford algorithm solves the single-source shortest path problem in general case
     * in which edge weights can be negative
     *
     * It can also detect if a negative-weight cycle is reachable from the source
     * If there is such a cycle, the algorithm tells that no solution exists
     * If there is NO such a cycle, the algorithm returns the shortest path
     */
    public static void bellmanFord(List<DirectedVertex> vertices, List<DirectedEdge> edges, DirectedVertex source) {

        // This implementation takes in a graphundirected, represented as
        // lists of vertices and edges, and fills two arrays
        // (distance and predecessor) with shortest-path
        // (less cost/distance/metric) information

        //double[] distances = new double[vertices.size()];
        //double[] predecessors = new double[vertices.size()];

        DirectedVertex u;
        DirectedVertex v;
        DirectedEdge e;

        // Step 1: initialize graph
        for (int i=0;i<vertices.size();i++) {

            u = vertices.get(i);

            if (u.equals(source)) {
                u.minDistance = 0;
            }
            else {
                u.minDistance = Integer.MAX_VALUE;
            }
            u.previous = null;
            Iterator it = new Iterator() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Object next() {
                    return null;
                }
            }
        }

        // Step 2: relax edges repeatedly
        // Bellman-Ford algorithm
        for (int i = 1; i < vertices.size(); i++) {

            for (int j = 0; j < edges.size(); j++) {

                e = edges.get(j);
                v = e.target;
                u = e.origin;

                //if (v.equals(e.target)) {
                    if (u.minDistance + e.weight < v.minDistance) {
                        v.minDistance = u.minDistance + e.weight;
                        v.previous = u;
                    }
                //}
            }
        }

        // Step 3: check for negative-weight cycles
        for (int i = 0; i < edges.size(); i++) {
            e = edges.get(i);
            u = e.origin;
            v = e.target;

            if (u.minDistance + e.weight < v.minDistance) {
                System.err.println("Error: Graph contains a negative-weight cycle");
            }
        }

        // Step 4: print results
        for (int i = 0; i < vertices.size(); i++) {
            v = vertices.get(i);
            System.out.println(v.name+" distance: "+v.minDistance);
        }

        System.out.println();

        for (int i = 0; i < edges.size(); i++) {
            e = edges.get(i);
            u = e.origin;
            v = e.target;
            System.out.println(u.name+" to "+v.name+" weight: "+e.weight);
        }

        return;

    }
}