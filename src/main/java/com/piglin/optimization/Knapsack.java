package com.piglin.optimization;

public class Knapsack {

    /**
     * Knapsack Problem
     * <p/>
     * Greedy algorithm
     * <p/>
     * Continuous knapsack problem
     *
     * @param values   values of items
     * @param weights  weights of items
     * @param capacity knapsack capacity
     */
    public static void knapsackProblem(int[] values, int[] weights, int capacity) {

        int distinctItems = values.length;

        /* Initialize knapsack */
        int[] selected = new int[distinctItems];


        for (int i = 0; i < distinctItems; i++) {
            selected[i] = 0;
        }

        int weight=0;
        int index = 0;
        while (weight <= capacity && index < distinctItems) {
                if (weight + weights[index] <= capacity) {
                    /* Maximize value */
                    selected[index] = 1;
                    weight = weight + weights[index];
                }
                index++;

        }

        System.out.println("\nSolution:\n");
        for (int i = 0; i < selected.length; i++) {
            System.out.print(selected[i] + "\t");
        }
        System.out.println();
        /*for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }*/
    }

}