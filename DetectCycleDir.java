package graphDs;

import java.util.ArrayList;

public class DetectCycleDir {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);
        System.out.println(detectCycle(adj, V));

        int v = 2;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            arrayLists.add(new ArrayList<>());
        }
        addEdge(arrayLists, 0, 1);
        System.out.println(detectCycle(arrayLists, v));
    }

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> arrayLists, int v) {
        boolean[] isVisited = new boolean[v];
        boolean[] recursionStack = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                if (dFS(arrayLists, i, isVisited, recursionStack))
                    return true;
            }
        }
        return false;
    }

    public static boolean dFS(ArrayList<ArrayList<Integer>> arrayLists, int s, boolean[] isVisited, boolean[] recursionStack) {
        isVisited[s] = true;
        recursionStack[s] = true;
        System.out.print(s + " ");
        for (int x : arrayLists.get(s)) {
            if (!isVisited[x] && dFS(arrayLists, x, isVisited, recursionStack)) {
                return true;
            } else if (recursionStack[x])
                return true;
        }
        recursionStack[s] = false;
        return false;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int i, int j) {
        arrayLists.get(i).add(j);
    }
}
