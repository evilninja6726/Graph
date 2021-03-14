package graphDs;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(5);
        for (int i = 0; i < v; i++)
            arrayLists.add(new ArrayList<>());
        addEdge(arrayLists, 0, 1);
        addEdge(arrayLists, 0, 2);
        addEdge(arrayLists, 1, 4);
        addEdge(arrayLists, 1, 3);
        addEdge(arrayLists, 2, 3);
        addEdge(arrayLists, 3, 4);
        dFS(arrayLists, 0, new boolean[v]);
        System.out.println();
        int x = 11;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(x);
        for (int i = 0; i < x; i++)
            graph.add(new ArrayList<Integer>());
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 5, 3);
        addEdge(graph, 5, 4);
        addEdge(graph, 3, 6);
        addEdge(graph, 3, 7);
        addEdge(graph, 4, 9);
        addEdge(graph, 4, 7);
        addEdge(graph, 6, 8);
        addEdge(graph, 7, 10);
        addEdge(graph, 7, 8);
        addEdge(graph, 9, 10);
        dFSDisconnected(graph, x);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int i, int j) {
        arrayLists.get(i).add(j);
        arrayLists.get(j).add(i);
    }

    public static void dFS(ArrayList<ArrayList<Integer>> arrayLists, int s, boolean[] isVisited) {
        System.out.print(s + " ");
        isVisited[s] = true;
        for (int x : arrayLists.get(s)) {
            if (!isVisited[x])
                dFS(arrayLists, x, isVisited);
        }
    }

    public static void dFSDisconnected(ArrayList<ArrayList<Integer>> arrayLists, int v) {
        boolean[] isVisited = new boolean[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                count++;
                dFS(arrayLists, i, isVisited);
            }
        }
        System.out.println();
        System.out.println("Count of connected Graph: " + count);
    }
}
