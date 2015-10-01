package com.piglin.optimization;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;



public class TravellingSalesmanProblem
{

    /*
     * Nearest neighbor algorithm
     */
    public static void compute(int adjacencyMatrix[][])
    {
        int numberOfNodes;
        Stack<Integer> stack = new Stack<Integer>();

        numberOfNodes = adjacencyMatrix[1].length - 1;

        int[] visited = new int[numberOfNodes + 1];
        visited[0] = 1;

        stack.push(0);

        int x;
        int y;

        int destination = 0;
        int minimum = Integer.MAX_VALUE;

        boolean minimumFlag = false;

        System.out.print(1 + "\t");

        while (!stack.isEmpty())
        {
            x = stack.peek();
            y = 0;

            minimum = Integer.MAX_VALUE;

            while (y <= numberOfNodes)
            {
                if (adjacencyMatrix[x][y] > 1 && visited[y] == 0)
                {
                    if (minimum > adjacencyMatrix[x][y])
                    {
                        //System.out.println(y+" matrix: "+adjacencyMatrix[x][y]+" minimum: "+minimum);
                        minimum = adjacencyMatrix[x][y];
                        destination = y;//Update destination
                        minimumFlag = true;//Minimum was found
                    }
                }
                y++;
            }
            if (minimumFlag)
            {
                /* Set next destination */

                visited[destination] = 1;
                stack.push(destination);

                System.out.print((destination + 1) + "\t");

                minimumFlag = false;

                continue;
            }
            stack.pop();
        }
    }

    /*
     * Minimum spanning tree
     */
}