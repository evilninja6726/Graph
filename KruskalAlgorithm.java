package graphDs;

import java.util.Arrays;
import java.util.Collections;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        MyEdge[] edges = new MyEdge[7];
        int v = 5;
        edges[0] = new MyEdge(2, 4, 1);
        edges[1] = new MyEdge(0, 3, 3);
        edges[2] = new MyEdge(0, 1, 4);
        edges[3] = new MyEdge(0, 2, 7);
        edges[4] = new MyEdge(1, 2, 6);
        edges[5] = new MyEdge(1, 4, 2);
        edges[6] = new MyEdge(3, 2, 5);
        int x = kruskalAlgorithm(edges, v);
        System.out.println(x);
    }

    public static int kruskalAlgorithm(MyEdge[] edges, int v) {
        int res = 0;
        Arrays.sort(edges);
        MyEdge[] mST = new MyEdge[v - 1];
        int[] parent = new int[v];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        int k = 0;
        for (int i = 0; i < edges.length; i++) {
            if (k == v - 1)
                break;
            MyEdge edge = edges[i];
            int sourceParent = findParent(edges[i].u, parent);
            int destinationParent = findParent(edges[i].v, parent);
            if (sourceParent != destinationParent) {
                mST[i] = edge;
                parent[sourceParent] = destinationParent;
                k++;
            }
        }
        for (int i = 0; i < k; i++) {
            res += mST[i].w;
            System.out.println(mST[i].u + " --> " + mST[i].v);
        }
        return res;
    }

    public static int findParent(int v, int[] parent) {
        if (parent[v] == v)
            return v;
        return findParent(parent[v], parent);
    }
}

class MyEdge implements Comparable<MyEdge> {
    int u;
    int v;
    int w;

    MyEdge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(MyEdge o) {
        if (this.w < o.w)
            return -1;
        return 1;
    }
}