package DataStructures.Graph;

public class AdjacencyMatrix {
    private int[][] matrix;
    private int numVertices;

    // Constructor
    public AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
    }

    // Add Edge
    public void addEdge(int src, int dest, int weight) {
        matrix[src][dest] = weight;
        matrix[dest][src] = weight; // For undirected graph
    }

    // Print the matrix
    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}

