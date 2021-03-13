package graphDs;

import java.util.ArrayList;

public class GraphImplementationList {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<Integer>());
        }
        addEdge(list, 1, 0);
        addEdge(list, 0, 2);
        addEdge(list, 2, 3);
        addEdge(list, 1, 2);
        printGraph(list);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> list, int i, int j) {
        list.get(i).add(j);
        list.get(j).add(i);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> arrayLists) {
        for (int i = 0; i < arrayLists.size(); i++) {
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                System.out.print(arrayLists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
