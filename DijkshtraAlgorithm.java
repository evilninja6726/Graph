package graphDs;

import java.util.Arrays;

public class DijkshtraAlgorithm {
    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 50, 100, 0},
                {50, 0, 30, 200},
                {100, 30, 0, 20},
                {0, 200, 20, 0},};
        System.out.printf(Arrays.toString(dijkshtraAlgorithm(graph, 0)));
    }

    public static int[] dijkshtraAlgorithm(int[][] graph, int s) {
        int[] distances = new int[graph.length];
        boolean[] isVisited = new boolean[graph.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[s] = 0;
        for (int i = 0; i < graph.length - 1; i++) {
            int parent = -1;
            for (int j = 0; j < graph.length; j++)
                if (!isVisited[j] && (parent == -1 || distances[parent] > distances[j]))
                    parent = j;
            isVisited[parent] = true;
            for (int j = 0; j < graph.length; j++)
                if (!isVisited[j] && graph[parent][j] != 0)
                    distances[j] = Math.min(distances[j], distances[parent] + graph[parent][j]);
        }
        return distances;
    }
}
