package com.piglin.optimization;

import com.piglin.optimization.graphundirected.UndirectedEdge;
import com.piglin.optimization.graphundirected.UndirectedVertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by swyna on 2/16/15.
 */
public class Dijkstra
{

    /**
     * Dijkstra algorithm
     * Dijkstra's algorithm greedily selects the minimum-weight node that has not yet been processed
     * @param source
     */
    public static void computePaths(UndirectedVertex source)
    {
        source.minDistance = 0;
        PriorityQueue<UndirectedVertex> vertexQueue = new PriorityQueue<UndirectedVertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            UndirectedVertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (UndirectedEdge e : u.adjacencies)
            {
                UndirectedVertex v = e.target;

                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;

                if (distanceThroughU < v.minDistance) {

                    /* Close previous vertex */
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = u;

                    /* Open new vertex*/
                    vertexQueue.add(v);
                }
            }
        }
    }

    /**
     * Get results
     * @param target
     * @return
     */
    public static List<UndirectedVertex> getShortestPathTo(UndirectedVertex target)
    {
        List<UndirectedVertex> path = new ArrayList<UndirectedVertex>();

        for (UndirectedVertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }

}
