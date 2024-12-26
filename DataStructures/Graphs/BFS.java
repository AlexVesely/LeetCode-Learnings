package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    // Output the traversal of the graph, the order that vertices are encountered
    public static void bfsTraversal(int start, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll(); // Retrieve and remove the head of the queue
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }

    // Output each vertex's distance to root and parent
    public static void bfsDistanceAndParent(int start, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        int[] distance = new int[adjList.size()];
        int[] parent = new int[adjList.size()];

        // Initialize the distance to "infinity" and parent to -1 (nil)
        for (int i = 0; i < adjList.size(); i++) {
            distance[i] = -1; // -1 represents infinity
            parent[i] = -1;   // -1 represents no parent
        }

        // Start BFS from the root node
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;  // Distance to the root is 0
        parent[start] = -1;   // The root has no parent

        // BFS traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("Vertex: " + node + ", Distance: " + distance[node] + ", Parent: " + parent[node]);

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    distance[neighbor] = distance[node] + 1; // Distance is one more than the current node
                    parent[neighbor] = node; // Set the parent of the neighbor
                }
            }
        }

        // After BFS traversal, print the unvisited vertices
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                System.out.println("Vertex: " + i + ", Distance: -1, Parent: -1");
            }
        }
    }


    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(4, true);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        System.out.println("Adjacency List of the Graph:");
        graph.printList();

        System.out.println("BFS Traversal starting from node 0:");
        BFS.bfsTraversal(0, graph.getAdjList());

        System.out.println("Each vertex, its distance to the root and its parent:");
        BFS.bfsDistanceAndParent(0,graph.getAdjList());
    }
}