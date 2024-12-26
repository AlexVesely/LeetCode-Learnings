package DataStructures.Graphs;

import java.util.ArrayList;

public class AdjacencyList {
    private final ArrayList<ArrayList<Integer>> adjList;
    private final boolean isDirected;

    public AdjacencyList(int numVertices, boolean isDirected) {
        this.isDirected = isDirected;
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        if (!isDirected) {
            adjList.get(dest).add(src); // Undirected graph has src <-> dest
        }
    }

    public void printList() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor);
                if (neighbor < adjList.get(i).size()) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> getAdjList() {
        return adjList;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public static void main(String[] args) {
        AdjacencyList list = new AdjacencyList(4, true);
        list.addEdge(2, 3);
        list.addEdge(0, 1);
        list.addEdge(0, 3);
        list.addEdge(1, 2);
        list.printList();
    }
}
