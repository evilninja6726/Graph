package graphDs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TopologicalSorting {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);
        topologicalSorting(adj, V);
    }

    public static void topologicalSorting(ArrayList<ArrayList<Integer>> arrayLists, int v) {
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int x : arrayLists.get(i)) {
                inDegree[x]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < v; i++)
            if (inDegree[i] == 0)
                queue.offer(i);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");
            for (int x : arrayLists.get(temp)) {
                inDegree[x]--;
                if (inDegree[x] == 0)
                    queue.offer(x);
            }
        }
    }

    public static void bFS(ArrayList<ArrayList<Integer>> arrayLists, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] inDegree = new int[arrayLists.size()];

    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int i, int j) {
        arrayLists.get(i).add(j);
    }
}
