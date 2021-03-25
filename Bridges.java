package graphDs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Bridges {
    public static void main(String[] args) {
        GraphForBridges g = new GraphForBridges(5);
        addEdge(g, 1, 0);
        addEdge(g, 0, 2);
        addEdge(g, 2, 1);
        addEdge(g, 0, 3);
        addEdge(g, 3, 4);
        bridges(g, 5);
    }

    public static void addEdge(GraphForBridges graph, int i, int j) {
        graph.adj[i].add(j);
        graph.adj[j].add(i);
    }

    public static void dFS(GraphForBridges graph, int u, boolean[] isVisited, int[] discoveryTime, int[] lowValues, int[] parent) {
        isVisited[u] = true;
        discoveryTime[u] = lowValues[u] = graph.time++;
        Iterator<Integer> iterator = graph.adj[u].listIterator();
        while (iterator.hasNext()) {
            int v = iterator.next();
            if (!isVisited[v]) {
                parent[v] = u;
                dFS(graph, v, isVisited, discoveryTime, lowValues, parent);
                lowValues[u] = Math.min(lowValues[u], lowValues[v]);
                if (lowValues[v] > discoveryTime[u])
                    System.out.println("Bridge is: " + u + " --> " + v);
            } else if (parent[u] != v)
                lowValues[u] = Math.min(lowValues[u], discoveryTime[v]);
        }
    }

    public static void bridges(GraphForBridges graph, int v) {
        boolean[] isVisited = new boolean[v];
        int[] discoveryTime = new int[v];
        int[] lowValues = new int[v];
        int[] parent = new int[v];
        Arrays.fill(parent, -1);
        for (int i = 0; i < v; i++) {
            if (!isVisited[i])
                dFS(graph, i, isVisited, discoveryTime, lowValues, parent);
        }
    }
}

class GraphForBridges {
    int v;
    LinkedList<Integer>[] adj;
    int time = 1;

    GraphForBridges(int v) {
        this.v = v;
        time = 1;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }
}