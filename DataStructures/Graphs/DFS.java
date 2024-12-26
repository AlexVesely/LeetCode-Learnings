package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    // Class for Depth First Search (DFS)
    public static class DFSTraverser {
        private final boolean[] visited;

        public DFSTraverser(int numVertices) {
            this.visited = new boolean[numVertices];
        }

        // Perform DFS starting from a given node
        public void dfs(int node, List<ArrayList<Integer>> adjList) {
            if (visited[node]) return;
            visited[node] = true;

            System.out.print(node + " "); // Example: Printing the node during traversal

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, adjList);
                }
            }
        }
    }

    public static boolean isAcyclic(AdjacencyList graph) {
        int numVertices = graph.getAdjList().size();
        boolean[] visited = new boolean[numVertices];
        boolean[] recStack = new boolean[numVertices]; // Keeps track of the recursion stack

        for (int node = 0; node < numVertices; node++) {
            if (isCyclicUtil(node, graph.getAdjList(), visited, recStack)) {
                return false; // Cycle detected
            }
        }
        return true; // No cycles found
    }

    private static boolean isCyclicUtil(
            int node, List<ArrayList<Integer>> adjList, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true; // Cycle detected
        if (visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (isCyclicUtil(neighbor, adjList, visited, recStack)) {
                return true; // Cycle detected in recursion
            }
        }

        recStack[node] = false; // Backtrack
        return false;
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(6, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        // Uncomment below to introduce a cycle
        // graph.addEdge(5, 1);

        System.out.println("Adjacency List:");
        graph.printList();

        System.out.println("\nDFS Traversal starting from node 0:");
        DFSTraverser dfs = new DFSTraverser(6);
        dfs.dfs(0, graph.getAdjList());

        System.out.println("\nIs the graph acyclic?");
        System.out.println(isAcyclic(graph));
    }
}
