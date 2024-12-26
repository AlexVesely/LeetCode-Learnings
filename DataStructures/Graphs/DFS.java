package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    private final boolean[] visited;

    public DFS(int numVertices) {
        this.visited = new boolean[numVertices];
    }

    // Perform DFS starting from a given node
    public void dfs(int node, List<ArrayList<Integer>> adjList) {
        if (visited[node]) return;
        visited[node] = true;

        System.out.print(node + " ");

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList);
            }
        }
    }

    public static boolean isAcyclic(AdjacencyList graph) {
        int numVertices = graph.getAdjList().size();
        boolean[] visited = new boolean[numVertices];
        boolean[] recStack = new boolean[numVertices];

        for (int node = 0; node < numVertices; node++) {
            if (isCyclicUtil(node, graph.getAdjList(), visited, recStack)) {
                return false; // Cycle detected
            }
        }
        return true; // No cycles found
    }

    private static boolean isCyclicUtil(int node, List<ArrayList<Integer>> adjList,
                                        boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true; // Cycle detected
        if (visited[node]) return false; // No cycles found

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

    public static List<Integer> topologicalSort(AdjacencyList graph) {
        int numVertices = graph.getAdjList().size();
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        // Call DFS on every unvisited node
        for (int node = 0; node < numVertices; node++) {
            if (!visited[node]) {
                topologicalSortUtil(node, graph.getAdjList(), visited, stack);
            }
        }

        // Convert stack to list for easier handling and return
        List<Integer> topOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topOrder.add(stack.pop());
        }

        return topOrder;
    }

    // Helper method for DFS in topological sorting
    private static void topologicalSortUtil(
            int node, List<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, adjList, visited, stack);
            }
        }

        // Push the node to the stack after visiting all its descendants
        stack.push(node);
    }

    // Method that checks if a cycle exists, if not performs topological sorting
    public static void Sort(AdjacencyList graph) {
        System.out.println("Adjacency List:");
        graph.printList();

        if (isAcyclic(graph)) {
            List<Integer> topOrder = topologicalSort(graph);
            System.out.println("Topological Sort:");
            System.out.println(topOrder);
        } else {
            System.out.println("The graph contains a cycle, so topological sort is not possible.");
        }
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(6, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println("Adjacency List:");
        graph.printList();

        System.out.println("DFS Traversal starting from node 0:");
        DFS dfs = new DFS(6);
        dfs.dfs(0, graph.getAdjList());

        System.out.println("Is the graph acyclic?");
        System.out.println(isAcyclic(graph));

        Sort(graph);
    }
}
