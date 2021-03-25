package graphDs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TarjanAlgorithm {
    public static void main(String[] args) {
        TarjanGraph g = new TarjanGraph(5);

        addEdge(g, 1, 0);
        addEdge(g, 0, 2);
        addEdge(g, 2, 1);
        addEdge(g, 0, 3);
        addEdge(g, 3, 4);
        tarjanAlgorithm(g, 5);
    }

    public static void addEdge(TarjanGraph graph, int i, int j) {
        graph.adj[i].add(j);
    }

    public static void dFS(TarjanGraph graph, int u, boolean[] isVisited, int[] discoveryTime, int[] lowValues, Stack<Integer> stack) {
        isVisited[u] = true;
        discoveryTime[u] = lowValues[u] = graph.time++;
        stack.push(u);
        Iterator<Integer> iterator = graph.adj[u].listIterator();
        while (iterator.hasNext()) {
            int v = iterator.next();
            if (discoveryTime[v] == -1) {
                dFS(graph, v, isVisited, discoveryTime, lowValues, stack);
                lowValues[u] = Math.min(lowValues[u], lowValues[v]);
            } else if (isVisited[v]) {
                lowValues[u] = Math.min(lowValues[u], discoveryTime[v]);
            }
        }

        int w = -1;
        if (discoveryTime[u] == lowValues[u]) {
            while (w != u) {
                w = stack.pop();
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    public static void tarjanAlgorithm(TarjanGraph graph, int v) {
        boolean[] isVisited = new boolean[v];
        int[] discoveryTime = new int[v];
        int[] lowValues = new int[v];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(discoveryTime, -1);
        Arrays.fill(lowValues, -1);
        for (int i = 0; i < v; i++) {
            if (!isVisited[i])
                dFS(graph, i, isVisited, discoveryTime, lowValues, stack);
        }
    }
}

class TarjanGraph {
    int v;
    LinkedList<Integer> adj[];
    int time;

    TarjanGraph(int v) {
        this.v = v;
        time = 0;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }
}