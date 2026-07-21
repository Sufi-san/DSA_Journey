package _2_Implementation.Graphs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RepresentingGraphs {
    public static void main(String[] args) {
        // Input:
        // First line gives 'n' and 'm' which are number of nodes and edges respectively
        // The first line is then followed by 'm' lines of input providing details about each edge
        // Each line containing 2 node indices between which the edge exists

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        // Adjacency Matrix
        boolean[][] adjMat = new boolean[n + 1][n + 1]; // For unweighted
        int[][] adjMatW = new int[n + 1][n + 1]; // For weighted

        // Adjacency List
        List<List<Integer>> adjList = new ArrayList<>(); // For unweighted
        List<List<Pair<Integer>>> adjListW = new ArrayList<>(); // For weighted

        // Initializing adjacency lists
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            adjListW.add(new ArrayList<>());
        }

        // We will consider the graph to be undirected.
        // In case a directed graph is to be considered, we just add a single edge at a time instead of two (no both ways connection)

        for(int i = 0; i < m; i++) {
            int node1 = in.nextInt(), node2 = in.nextInt();
            int weight = getRandomWeight();

            adjMat[node1][node2] = true;
            adjMat[node2][node1] = true;

            adjMatW[node1][node2] = weight;
            adjMatW[node2][node1] = weight;

            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);

            adjListW.get(node1).add(new Pair<Integer>(node2, weight));
            adjListW.get(node2).add(new Pair<Integer>(node1, weight));
        }

        // Printing Unweighted adjacency matrix and list
        printAdjMatrix(adjMat);
        printAdjList(adjList);

        // Printing weighted adjacency matrix and list
        printAdjMatrix(adjMatW);
        printAdjList(adjListW);
    }

    private static int getRandomWeight() {
        return (int) (Math.random() * 10);
    }

    private static void printAdjMatrix(boolean[][] matrix) {
        for(boolean[] row: matrix) {
            for(boolean cell: row) System.out.print(cell? "1 ": "0 ");
            System.out.println();
        }
    }

    private static void printAdjMatrix(int[][] matrix) {
        for(int[] row: matrix) {
            for(int cell: row) System.out.print(cell+" ");
            System.out.println();
        }
    }

    private static void printAdjList(List<?> adjList) {
        for(int i = 0; i < adjList.size(); i++) {
            System.out.println(i+" "+adjList.get(i));
        }
    }
}
