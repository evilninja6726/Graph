package graphDs;

import java.util.Arrays;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 5, 8, 0},
                {5, 0, 10, 15},
                {8, 10, 0, 20},
                {0, 15, 20, 0},};
        System.out.println(primsAlgorithm(graph));
    }

    public static int primsAlgorithm(int[][] graph) {
        int[] distances = new int[graph.length];
        int res = 0;
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] isVisited = new boolean[graph.length];
        distances[0] = 0;
        for (int i = 0; i < graph.length; i++) {
            int parent = -1;
            for (int j = 0; j < graph.length; j++)
                if (!isVisited[j] && (parent == -1 || distances[parent] > distances[j]))
                    parent = j;
            isVisited[parent] = true;
            res += distances[parent];
            for (int j = 0; j < graph.length; j++)
                if (graph[parent][j] != 0 && !isVisited[j])
                    distances[j] = Math.min(distances[j], graph[parent][j]);

        }
        return res;
    }
}
