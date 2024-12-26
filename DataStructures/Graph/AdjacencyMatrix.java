package DataStructures.Graph;

public class AdjacencyMatrix {
    private final int[][] matrix;
    private final int numVertices;
    private final boolean isDirected;
    // We could also add a 'weight' attribute between the vertices if we wanted

    public AdjacencyMatrix(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
        this.isDirected = isDirected;
    }

    // REMEMBER THE FIRST INDEX IS 0 NOT 1
    public void addEdge(int src, int dest) {
        matrix[src][dest] = 1;
        if (!isDirected) { // In undirected graphs show src <-> dest
            matrix[dest][src] = 1;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix matrix = new AdjacencyMatrix(4, true);
        matrix.addEdge(0, 1);
        matrix.addEdge(1, 2);
        matrix.addEdge(1, 3);
        matrix.addEdge(3, 2);
        matrix.printMatrix();
    }
}

