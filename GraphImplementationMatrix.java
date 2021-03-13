package graphDs;

public class GraphImplementationMatrix {
    public static void main(String[] args) {
        AdjMatrix matrix = new AdjMatrix(4);
        matrix.addEdge(0, 2);
        matrix.addEdge(1, 2);
        matrix.addEdge(0, 1);
        matrix.addEdge(2, 3);
        matrix.printGraph();
        matrix.removeEdge(2, 0);
        System.out.println();
        matrix.printGraph();
    }
}

class AdjMatrix {
    private int vertices;
    private int[][] matrix;

    AdjMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int row, int column) {
        matrix[row][column] = 1;
        matrix[column][row] = 1;
    }

    void removeEdge(int row, int column) {
        matrix[row][column] = 0;
        matrix[column][row] = 0;
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
