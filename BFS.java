package graphDs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            arrayLists.add(new ArrayList<Integer>());
        }
        addEdge(arrayLists, 0, 1);
        addEdge(arrayLists, 2, 0);
        addEdge(arrayLists, 3, 2);
        addEdge(arrayLists, 1, 2);
        bFS(arrayLists, 0);
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
        bFSDisconnect(graph, x);
    }

    public static void bFS(ArrayList<ArrayList<Integer>> arrayLists, int s) {
        boolean[] isVisited = new boolean[arrayLists.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        isVisited[s] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");
            for (int x : arrayLists.get(temp)) {
                if (isVisited[x] == false) {
                    isVisited[x] = true;
                    queue.offer(x);
                }
            }
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int i, int j) {
        arrayLists.get(i).add(j);
        arrayLists.get(j).add(i);
    }

    public static void bFSForDisconnected(ArrayList<ArrayList<Integer>> arrayLists, int s, boolean[] isVisited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        isVisited[s] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");
            for (int x : arrayLists.get(temp)) {
                if (!isVisited[x]) {
                    isVisited[x] = true;
                    queue.offer(x);
                }
            }
        }
    }

    public static void bFSDisconnect(ArrayList<ArrayList<Integer>> arrayLists, int v) {
        boolean[] isVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                bFSForDisconnected(arrayLists, i, isVisited);
            }
        }
    }
}
