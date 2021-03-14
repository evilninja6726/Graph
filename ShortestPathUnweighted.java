package graphDs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathUnweighted {
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            arrayLists.add(new ArrayList<Integer>());
        addEdge(arrayLists, 0, 1);
        addEdge(arrayLists, 0, 2);
        addEdge(arrayLists, 0, 4);
        addEdge(arrayLists, 1, 3);
        addEdge(arrayLists, 2, 4);
        addEdge(arrayLists, 2, 3);
        addEdge(arrayLists, 3, 5);
        addEdge(arrayLists, 4, 5);
        System.out.println(Arrays.toString(shortestPathUnweighted(arrayLists, 0)));
    }

    public static int[] shortestPathUnweighted(ArrayList<ArrayList<Integer>> arrayLists, int s) {
        boolean[] isVisited = new boolean[arrayLists.size()];
        int[] distances = new int[arrayLists.size()];
        distances[0] = 0;
        for (int i = 1; i < distances.length; i++)
            distances[i] = Integer.MAX_VALUE;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        isVisited[s] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");
            for (int x : arrayLists.get(temp)) {
                if (!isVisited[x]) {
                    isVisited[x] = true;
                    distances[x] = distances[temp] + 1;
                    queue.offer(x);
                }
            }
        }
        System.out.println();
        return distances;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int i, int j) {
        arrayLists.get(i).add(j);
        arrayLists.get(j).add(i);
    }
}
