package graphDs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkshtraList {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(graph, 0, 1, 4);
        graph.addEdge(graph, 0, 2, 3);
        graph.addEdge(graph, 1, 2, 1);
        graph.addEdge(graph, 1, 3, 2);
        graph.addEdge(graph, 2, 3, 4);
        graph.addEdge(graph, 3, 4, 2);
        graph.addEdge(graph, 4, 5, 6);
        dijkshtraList(graph, 0);
    }

    public static void dijkshtraList(Graph graph, int s) {
        PriorityQueue<Pair> pairs = new PriorityQueue<>();
        boolean[] isVisited = new boolean[graph.adjacencyList.length];
        int[] distances = new int[graph.adjacencyList.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        pairs.offer(new Pair(0, distances[0]));
        while (!pairs.isEmpty()) {
            Pair temp = pairs.poll();
            int extractedVertex = temp.getVertex();
            if (!isVisited[extractedVertex]) {
                isVisited[extractedVertex] = true;
                LinkedList<Edge> list = graph.adjacencyList[extractedVertex];
                for (int i = 0; i < list.size(); i++) {
                    Edge edge = list.get(i);
                    int destination = edge.v;
                    if (!isVisited[destination]) {
                        int currentD = distances[destination];
                        int newD = distances[extractedVertex] + edge.weight;
                        if (currentD > newD) {
                            pairs.offer(new Pair(destination, newD));
                            distances[destination] = newD;
                        }
                    }
                }
            }
        }
        print(distances);
    }

    public static void print(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
    }
}

class Edge {
    int u;
    int v;
    int weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

class Graph {
    LinkedList<Edge>[] adjacencyList;
    int vertices;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adjacencyList[i] = new LinkedList<>();
    }

    void addEdge(Graph graph, int u, int v, int weight) {
        Edge edge = new Edge(u, v, weight);
        graph.adjacencyList[u].add(edge);
        edge = new Edge(v, u, weight);
        graph.adjacencyList[v].add(edge);
    }
}

class Pair implements Comparable<Pair> {
    private Integer vertex;
    private Integer distance;

    Pair(Integer vertex, Integer distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    int getVertex() {
        return this.vertex = vertex;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.getVertex() < o.getVertex())
            return -1;
        return 1;
    }
}