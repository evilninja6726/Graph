package graphDs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 3);
        addEdge(adj, 5, 3);
        topologicalSortingDFS(adj, V);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int i, int j) {
        arrayLists.get(i).add(j);
    }

    public static void dFS(ArrayList<ArrayList<Integer>> arrayLists, int s, boolean[] isVisited, Stack<Integer> stack) {
        isVisited[s] = true;
        for (int x : arrayLists.get(s)) {
            if (!isVisited[x])
                dFS(arrayLists, x, isVisited, stack);
        }
        stack.push(s);
    }

    public static void topologicalSortingDFS(ArrayList<ArrayList<Integer>> arrayLists, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!isVisited[i])
                dFS(arrayLists, i, isVisited, stack);
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}
