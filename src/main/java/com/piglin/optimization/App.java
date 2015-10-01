package com.piglin.optimization;

import com.piglin.optimization.graphdirected.DirectedEdge;
import com.piglin.optimization.graphdirected.DirectedVertex;
import com.piglin.optimization.graphundirected.UndirectedEdge;
import com.piglin.optimization.graphundirected.UndirectedVertex;

import java.util.*;

/**
 * Hello world!
 */
public class App {

    public static void testFibonacci() {
        //input to print Fibonacci series upto how many numbers
        System.out.print("Enter number upto which Fibonacci series to print: ");
        int number = new Scanner(System.in).nextInt();

        System.out.println("\n\nFibonacci series upto " + number +" numbers : ");
        //printing Fibonacci series upto number
        for(int i=1; i<=number; i++){
            System.out.print(Fibonacci.fibonacciRecusion(i) +" ");
        }
    }

    public static void testKnapsack() {

        int[] values = {20,30,40,50,60};
        int[] weights = {10,20,30,40,50};
        int distinctItems=5;
        int capacity = 100;

        Knapsack.knapsackProblem(values,weights,capacity);
    }

    public static void testBellmanFord() {

        int[][] adjacencyMatrix = {
                { 0, 0,-3, 0, 9},
                { 8, 0, 5, 0,-4},
                { 0,-2, 0, 0, 0},
                { 7, 6, 0, 0, 0},
                { 0, 0, 7, 2, 0}
        };

        DirectedVertex v0 = new DirectedVertex("A");//Source
        DirectedVertex v1 = new DirectedVertex("B");
        DirectedVertex v2 = new DirectedVertex("C");
        DirectedVertex v3 = new DirectedVertex("S");
        DirectedVertex v4 = new DirectedVertex("T");

        v0.adjacencies = new DirectedEdge[]{new DirectedEdge(v0, v2, -3),
            new DirectedEdge(v0, v4, 9)};
        v1.adjacencies = new DirectedEdge[]{new DirectedEdge(v1, v0,  8),
                new DirectedEdge(v1, v2, 5), new DirectedEdge(v1, v4, -4)};
        v2.adjacencies = new DirectedEdge[]{new DirectedEdge(v2, v1, -2)};
        v3.adjacencies = new DirectedEdge[]{new DirectedEdge(v3, v0, 7),
                new DirectedEdge(v3, v1, 6)};
        v4.adjacencies = new DirectedEdge[]{new DirectedEdge(v4, v2, 7),
                new DirectedEdge(v4, v3, 2)};

        List<DirectedVertex> verticies = new ArrayList<DirectedVertex>();
        List<DirectedEdge>   edges     = new ArrayList<DirectedEdge>();

        verticies.add(v0);
        verticies.add(v1);
        verticies.add(v2);
        verticies.add(v3);
        verticies.add(v4);

        for (DirectedVertex v: verticies) {

            DirectedEdge[] adjacencies = v.adjacencies;

            for (int i = 0; i < adjacencies.length; i++) {
                edges.add(adjacencies[i]);
            }
        }

        BellmanFord.bellmanFord(verticies, edges, v3);

        //EXPECTED RESULTS:

    }

    public static void testDijkstra() {
        UndirectedVertex v0 = new UndirectedVertex("Redvile");
        UndirectedVertex v1 = new UndirectedVertex("Blueville");
        UndirectedVertex v2 = new UndirectedVertex("Greenville");
        UndirectedVertex v3 = new UndirectedVertex("Orangeville");
        UndirectedVertex v4 = new UndirectedVertex("Purpleville");

        v0.adjacencies = new UndirectedEdge[]{ new UndirectedEdge(v0, v1, 5),
                new UndirectedEdge(v0, v2, 10),
                new UndirectedEdge(v0, v3, 8) };
        v1.adjacencies = new UndirectedEdge[]{ new UndirectedEdge(v1, v0, 5),
                new UndirectedEdge(v1, v2, 3),
                new UndirectedEdge(v1, v4, 7) };
        v2.adjacencies = new UndirectedEdge[]{ new UndirectedEdge(v2, v0, 10),
                new UndirectedEdge(v2, v1, 3) };
        v3.adjacencies = new UndirectedEdge[]{ new UndirectedEdge(v3, v0, 8),
                new UndirectedEdge(v3, v4, 2) };
        v4.adjacencies = new UndirectedEdge[]{ new UndirectedEdge(v4, v1, 7),
                new UndirectedEdge(v4, v3, 2) };

        UndirectedVertex[] vertices = { v0, v1, v2, v3, v4 };

        Dijkstra.computePaths(v0);

        for (UndirectedVertex v : vertices)
        {
            System.out.println("Distance to " + v + ": " + v.minDistance);
            List<UndirectedVertex> path = Dijkstra.getShortestPathTo(v);
            System.out.println("Path: " + path);
        }

        //EXPECTED RESULTS:
    }

    public static void testTravellingSalesmanProblem() {
        int number_of_nodes;
        Scanner scanner = null;
        try {
            System.out.println("Use predefined settings for TSP? y/n");
            scanner = new Scanner(System.in);

            String response = scanner.nextLine();

            int adjacency_matrix[][];

            if (response.equals("n")) {


                System.out.println("Enter the number of nodes in the graphundirected");
                number_of_nodes = scanner.nextInt();

                adjacency_matrix = new int[number_of_nodes + 1][number_of_nodes + 1];

                System.out.println("Enter the adjacency matrix");
                for (int i = 1; i <= number_of_nodes; i++) {
                    for (int j = 1; j <= number_of_nodes; j++) {
                        adjacency_matrix[i][j] = scanner.nextInt();
                    }
                }
                for (int i = 1; i <= number_of_nodes; i++) {
                    for (int j = 1; j <= number_of_nodes; j++) {
                        if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0) {
                            adjacency_matrix[j][i] = 1;
                        }
                    }
                }
            } else {

                //number_of_nodes = 9;
                //adjacency_matrix = new int[9+1][9+1];

                int predefined_matrix[][] = {
                        {  0, 374, 200, 223, 108, 178, 252, 285, 240},
                        {  0,   0, 255, 166, 433, 199, 135,  95, 136},
                        {  0,   0,   0, 128, 277, 128, 180, 160, 131},
                        {  0,   0,   0,   0, 430,  47,  52,  84,  40},
                        {  0,   0,   0,   0,   0, 453, 478, 344, 389},
                        {  0,   0,   0,   0,   0,   0,  91, 110,  64},
                        {  0,   0,   0,   0,   0,   0,   0, 114,  83},
                        {  0,   0,   0,   0,   0,   0,   0,   0,  47},
                        {  0,   0,   0,   0,   0,   0,   0,   0,   0}
                };

                int predefined_matrix_symmetrical[][] = {
                        {  0, 374, 200, 223, 108, 178, 252, 285, 240},
                        {374,   0, 255, 166, 433, 199, 135,  95, 136},
                        {200, 255,   0, 128, 277, 128, 180, 160, 131},
                        {223, 166, 128,   0, 430,  47,  52,  84,  40},
                        {108, 433, 277, 430,   0, 453, 478, 344, 389},
                        {178, 199, 128,  47, 453,   0,  91, 110,  64},
                        {252, 135, 180,  52, 478,  91,   0, 114,  83},
                        {285,  95, 160,  84, 344, 110, 114,   0,  47},
                        {240, 136, 131,  40, 389,  64,  83,  47,   0}
                };

                adjacency_matrix = predefined_matrix_symmetrical;
            }
            System.out.println("The cities are visited as follows:");

            TravellingSalesmanProblem.compute(adjacency_matrix);

        } catch (Exception inputMismatch) {
            System.out.println("Wrong Input format");
        }
        scanner.close();

        //EXPECTED RESULTS:
    }

    public static void main(String[] args) {

        Map<String,Integer> tester = new HashMap<String,Integer>();
        tester.put("year",2015);
        tester.put("month",2);
        tester.put("day",16);
        tester.remove("day");

        System.out.println(tester.get("year")+" "+tester.get("month")+" "+tester.get("day"));

        System.out.println("\nFIBONACCI\n");

        testFibonacci();

        System.out.println("\nKNAPSACK\n");

        testKnapsack();

        System.out.println("\nBELLMAN FORD\n");

        testBellmanFord();

        System.out.println("\nDIJKSTRA\n");

        testDijkstra();

        System.out.println("\nTRAVELLING SALESMAN\n");

        testTravellingSalesmanProblem();
    }




}
