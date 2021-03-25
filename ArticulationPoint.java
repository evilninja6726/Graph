package graphDs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ArticulationPoint {
    public static void main(String[] args) {
        GraphForAP g = new GraphForAP(5);
        addEdge(g, 1, 0);
        addEdge(g, 0, 2);
        addEdge(g, 1, 2);
        addEdge(g, 2, 3);
        addEdge(g, 3, 4);
        articulationPoint(g, 5);
    }

    public static void articulationPoint(GraphForAP graph, int v) {
        boolean[] articulationPoints = new boolean[v];
        boolean[] isVisited = new boolean[v];
        int[] discoveryTime = new int[v];
        int[] lowValues = new int[v];
        int[] parent = new int[v];
        Arrays.fill(parent, -1);
        for (int i = 0; i < v; i++) {
            if (!isVisited[i])
                dFS(graph, i, isVisited, discoveryTime, lowValues, articulationPoints, parent);
        }

        for (int i = 0; i < v; i++) {
            if (articulationPoints[i])
                System.out.print(i + " ");
        }
    }

    public static void addEdge(GraphForAP graph, int i, int j) {
        graph.adj[i].add(j);
        graph.adj[j].add(i);
    }

    public static void dFS(GraphForAP graph, int u, boolean[] isVisited, int[] discoveryTime, int[] lowValues, boolean[] articulationPoints, int[] parent) {
        isVisited[u] = true;
        discoveryTime[u] = lowValues[u] = graph.time++;
        int children = 0;
        Iterator<Integer> iterator = graph.adj[u].listIterator();
        while (iterator.hasNext()) {
            int v = iterator.next();
            if (!isVisited[v]) {
                children++;
                parent[v] = u;
                dFS(graph, v, isVisited, discoveryTime, lowValues, articulationPoints, parent);
                lowValues[u] = Math.min(lowValues[u], lowValues[v]);
                if (parent[u] == -1 && children > 1)
                    articulationPoints[u] = true;
                if (parent[u] != -1 && lowValues[v] >= discoveryTime[u])
                    articulationPoints[u] = true;
            } else if (parent[u] != v)
                lowValues[u] = Math.min(lowValues[u], discoveryTime[v]);
        }
    }
}

class GraphForAP {
    int vertices;
    int time;
    LinkedList<Integer>[] adj;

    GraphForAP(int vertices) {
        time = 1;
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new LinkedList<>();
    }
}