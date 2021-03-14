package graphDs;

import java.util.ArrayList;

public class DetectCycle {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        System.out.println(detectCycle(adj, V));
    }

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> arrayLists, int v) {
        boolean[] isVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                if (dFS(arrayLists, -1, i, isVisited))
                    return true;
            }
        }
        return false;
    }

    public static boolean dFS(ArrayList<ArrayList<Integer>> arrayLists, int parent, int s, boolean[] isVisited) {
        isVisited[s] = true;
        System.out.print(s + " ");
        for (int x : arrayLists.get(s)) {
            if (!isVisited[x]) {
                if (dFS(arrayLists, s, x, isVisited))
                    return true;
            } else if (x != parent)
                return true;
        }
        return false;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int i, int j) {
        arrayLists.get(i).add(j);
        arrayLists.get(j).add(i);
    }
}
