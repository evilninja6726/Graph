package graphDs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CountConnectedComponent {
    public static void main(String[] args) {
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
        addEdge(graph, 9, 10);
        System.out.println(countConnectedComponents(graph, x));
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int i, int j) {
        arrayLists.get(i).add(j);
        arrayLists.get(j).add(i);
    }

    public static void bFSVariation(ArrayList<ArrayList<Integer>> arrayLists, int s, boolean[] isVisited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        isVisited[s] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int x : arrayLists.get(temp)) {
                if (!isVisited[x]) {
                    isVisited[x] = true;
                    queue.offer(x);
                }
            }
        }
    }

    public static int countConnectedComponents(ArrayList<ArrayList<Integer>> arrayLists, int v) {
        boolean[] isVisited = new boolean[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                count++;
                bFSVariation(arrayLists, i, isVisited);
            }
        }
        return count;
    }
}
