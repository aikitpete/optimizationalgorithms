package com.piglin.optimization;

import com.piglin.optimization.graphundirected.UndirectedEdge;
import com.piglin.optimization.graphundirected.UndirectedVertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petegerhat on 2/15/15.
 * Not a greedy algorithm
 */
public class AStar {
    public static List<UndirectedVertex> aStar(UndirectedVertex start,UndirectedVertex goal) {
        List<UndirectedVertex> closedset =  new ArrayList<UndirectedVertex>();    // The set of nodes already evaluated.
        List<UndirectedVertex> openset = new ArrayList<UndirectedVertex>();    // The set of tentative nodes to be evaluated, initially containing the start node
        openset.add(start);

        UndirectedVertex current = null;

        start.startScore = 0;    // Cost from start along best known path.
        // Estimated total cost from start to goal through y.
        start.goalScore = start.startScore + heuristic_cost_estimate(start, goal);

        int lowestScore;
        int tentativeStartScore;

        while (!openset.isEmpty()) {

            lowestScore = Integer.MAX_VALUE;
            for (UndirectedVertex v: openset) {
                if (v.goalScore < lowestScore) {
                    lowestScore = v.goalScore;
                    current = v;
                }
            }

            if (current.equals(goal)) {
                /* Goal was reached */
                return reconstruct_path(goal);
            }

            openset.remove(current);
            closedset.add(current);

            for (UndirectedEdge e :current.adjacencies) {

                /* Explore neighbors */
                UndirectedVertex v = e.origin;

                if (closedset.contains(v)) {
                    /* Neighbor already closed */
                    continue;
                }

                /* Compute score from start */
                tentativeStartScore = current.startScore + dist_between(current, v);

                if (!openset.contains(v) || tentativeStartScore < v.startScore){

                    /* Set previous node */
                    v.previous = current;

                    /* Update score for neighbor */
                    v.startScore = tentativeStartScore;
                    v.goalScore = v.startScore + heuristic_cost_estimate(v, goal);

                    if (!openset.contains(v)){
                        /* Open neighbor */
                        openset.add(v);
                    }
                }
            }
        }
        return null;
    }

    private static int dist_between(UndirectedVertex current, UndirectedVertex v) {
        return -1;
    }

    private static int heuristic_cost_estimate(UndirectedVertex neighbor, UndirectedVertex goal) {
        return -1;
    }

    public static List<UndirectedVertex> reconstruct_path (UndirectedVertex current) {

        List<UndirectedVertex> totalPath = new ArrayList<UndirectedVertex>();

        while (current != null) {
            totalPath.add(current);
            current = current.previous;
        }
        return totalPath;
    }
}
