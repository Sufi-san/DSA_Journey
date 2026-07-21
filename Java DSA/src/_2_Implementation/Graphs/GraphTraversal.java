package _2_Implementation.Graphs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {
    public static void main(String[] args) {
        // Adjacency List for an Undirected Graph: (Using arrays as we are hardcoding the list)
        int[][] adjList = {
                {}, // Node Zero
                {2, 3},
                {1, 5, 6},
                {1, 4, 7},
                {3, 8},
                {2},
                {2},
                {3, 8},
                {4, 7}
        };

        int startNodeIndex = 1;

        // BFS Traversal:
        graphBFS(startNodeIndex, adjList);

        System.out.println();
        // DFS Traversal:
        graphDFS(startNodeIndex, adjList);

        System.out.println();
        // DFS with Stack:
        graphDFS_usingStack(startNodeIndex, adjList);
    }

    private static void graphBFS(int startNodeIndex, int[][] adjList) {
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(startNodeIndex);
        visited[startNodeIndex] = true;

        System.out.println("BFS Traversal: ");
        while(!queue.isEmpty()) {
            int currentNodeIndex = queue.poll();
            System.out.print(currentNodeIndex+" ");
            int[] nextLevelNodeIndices = adjList[currentNodeIndex];

            for(int nodeIndex: nextLevelNodeIndices) {
                if(visited[nodeIndex]) continue;

                queue.add(nodeIndex);
                visited[nodeIndex] = true;
            }
        }
    }

    private static void graphDFS(int startNodeIndex, int[][] adjList) {
        boolean[] visited = new boolean[adjList.length];

        System.out.println("DFS Traversal: ");
        dfsHelper(startNodeIndex, adjList, visited);
    }

    private static void dfsHelper(int currNodeIndex, int[][] adjList, boolean[] visited) {
        if(visited[currNodeIndex]) return;

        System.out.print(currNodeIndex+" ");
        visited[currNodeIndex] = true;

        int[] nextLevelNodeIndices = adjList[currNodeIndex];
        for(int nodeIndex: nextLevelNodeIndices) {
            dfsHelper(nodeIndex, adjList, visited);
        }
    }

    private static void graphDFS_usingStack(int startNodeIndex, int[][] adjList) {
        boolean[] visited = new boolean[adjList.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(startNodeIndex);
        visited[startNodeIndex] = true;

        System.out.println("DFS Traversal (Iterative, using Stack): ");
        while(!stack.isEmpty()) {
            int currNodeIndex = stack.pop();
            System.out.print(currNodeIndex+" ");
            int[] nextLevelNodeIndices = adjList[currNodeIndex];

            for(int i = nextLevelNodeIndices.length - 1; i >= 0; i--) {
                int nodeIndex = nextLevelNodeIndices[i];

                if(visited[nodeIndex]) continue;

                stack.push(nodeIndex);
                visited[nodeIndex] = true;
            }
        }
    }
}
