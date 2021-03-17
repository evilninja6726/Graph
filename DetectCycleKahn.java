package graphDs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DetectCycleKahn {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 4, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);
        System.out.println(detectCycleKahn(adj, V));

        int v = 6;
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<ArrayList<Integer>>(v);

        for (int i = 0; i < v; i++)
            adj2.add(new ArrayList<Integer>());

        addEdge(adj2, 0, 1);
        addEdge(adj2, 2, 1);
        addEdge(adj2, 2, 3);
        addEdge(adj2, 3, 4);
        addEdge(adj2, 4, 5);
        addEdge(adj2, 5, 3);
        System.out.println(detectCycleKahn(adj2, v));
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int i, int j) {
        arrayLists.get(i).add(j);
    }

    public static boolean detectCycleKahn(ArrayList<ArrayList<Integer>> arrayLists, int v) {
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++)
            for (int x : arrayLists.get(i))
                inDegree[x]++;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < v; i++)
            if (inDegree[i] == 0)
                queue.offer(i);
        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            System.out.print(temp + " ");
            for (int x : arrayLists.get(temp)) {
                if (--inDegree[x] == 0)
                    queue.offer(x);
            }
        }
        if (count == v)
            return false;
        else
            return true;
    }
}
