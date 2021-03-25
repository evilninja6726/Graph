package graphDs;

import java.util.Arrays;

public class BellmanFordAlgo {
    public static void main(String[] args) {
        BellmanGraph graph = new BellmanGraph(4, 5);
        // add edge 0-1 (or A-B)
        graph.edges[0].source = 0;
        graph.edges[0].destination = 1;
        graph.edges[0].weight = 1;

        // add edge 0-2 (or A-C)
        graph.edges[1].source = 0;
        graph.edges[1].destination = 2;
        graph.edges[1].weight = 4;

        // add edge 1-2 (or B-C)
        graph.edges[2].source = 1;
        graph.edges[2].destination = 2;
        graph.edges[2].weight = -3;

        // add edge 1-3 (or B-D)
        graph.edges[3].source = 1;
        graph.edges[3].destination = 3;
        graph.edges[3].weight = 2;

        // add edge 2-3 (or C-D)
        graph.edges[4].source = 2;
        graph.edges[4].destination = 3;
        graph.edges[4].weight = 3;

        graph.bellmanFordAlgo(graph, 0);
    }
}

class BellmanGraph {
    int v, e;

    class Edge {
        int source;
        int destination;
        int weight;

        Edge() {
            source = destination = weight = 0;
        }
    }

    Edge[] edges;

    BellmanGraph(int v, int e) {
        this.v = v;
        this.e = e;
        edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    void bellmanFordAlgo(BellmanGraph graph, int s) {
        int V = graph.v;
        int E = graph.e;
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = graph.edges[j].source;
                int v = graph.edges[j].destination;
                int w = graph.edges[j].weight;
                if (graph.edges[u].source != Integer.MAX_VALUE && distances[v] > distances[u] + w)
                    distances[v] = distances[u] + w;
            }
        }
        for (int j = 0; j < E; j++) {
            int u = graph.edges[j].source;
            int v = graph.edges[j].destination;
            int w = graph.edges[j].weight;
            if (graph.edges[u].source != Integer.MAX_VALUE && distances[v] > distances[u] + w) {
                System.out.println("Negative Weighted Cycle");
                return;
            }
        }
        printGraph(distances, V);
    }

    void printGraph(int[] distances, int V) {
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from Source and " + i + " is " + distances[i]);
        }
    }
}