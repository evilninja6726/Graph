package graphDs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class KosarajuAlgorithm {
    public static void main(String[] args) {
        DirGraph g = new DirGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        g.printSCC();
    }
}

class DirGraph {
    int v;
    LinkedList<Integer>[] adj;

    DirGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int i, int j) {
        adj[i].add(j);
    }

    DirGraph transpose() {
        DirGraph transpose = new DirGraph(v);
        for (int i = 0; i < v; i++) {
            Iterator<Integer> iterator = adj[i].listIterator();
            while (iterator.hasNext()) {
                transpose.adj[iterator.next()].add(i);
            }
        }
        return transpose;
    }

    void dFSUtil(int s, boolean[] isVisited) {
        isVisited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> iterator = adj[s].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!isVisited[n])
                dFSUtil(n, isVisited);
        }
    }

    void fillStack(int s, boolean[] isVisited, Stack<Integer> stack) {
        isVisited[s] = true;
        Iterator<Integer> iterator = adj[s].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!isVisited[n])
                fillStack(n, isVisited, stack);
        }
        stack.push(s);
    }

    void printSCC() {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!isVisited[i])
                fillStack(i, isVisited, stack);
        }
        DirGraph transpose = transpose();
        Arrays.fill(isVisited, false);
        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                while (!stack.isEmpty()) {
                    int pop = stack.pop();
                    if (!isVisited[pop]) {
                        transpose.dFSUtil(pop, isVisited);
                        System.out.println();
                    }
                }
            }
        }
    }
}