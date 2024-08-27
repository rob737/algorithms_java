package leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;

public class TopologicalSort {
    private static HashMap<Integer, LinkedList<Integer>> adj = new HashMap<>();
    private static HashMap<Integer,Integer> dependencyCounter = new HashMap<>();
    private static LinkedList<Integer> resultSet = new LinkedList<>();

    public static void main(String[] args) {
        int[] vertex = {4,6,8,10,12,14};
        for(int val : vertex)
            adj.put(val, new LinkedList<Integer>());
        createEdge(4,12);
        createEdge(12,14);
        createEdge(6,4);
        createEdge(6,8);
        createEdge(10,8);
        createEdge(10,14);
        demonstrateTopologicalSorting();
        System.out.println("Topological sorted array");
        System.out.println(resultSet);
    }

    private static void demonstrateTopologicalSorting() {
        // need to change this.
        for(int val:adj.keySet()){
            if(dependencyCounter.get(val) == null || dependencyCounter.get(val) == 0){
                resultSet.add(val);
                topologicalSort(val);
            }
        }
    }

    private static void topologicalSort(int key) {
        for(int i = 0; i<adj.get(key).size(); i++){
            int neighbour = adj.get(key).get(i);
            if(dependencyCounter.get(neighbour) >=0)
                dependencyCounter.put(neighbour,dependencyCounter.get(neighbour)-1);
        }

        for(int i = 0; i<adj.get(key).size(); i++) {
            int neighbour = adj.get(key).get(i);
            if (dependencyCounter.get(neighbour) == 0) {
                dependencyCounter.put(neighbour,-1);
                resultSet.add(neighbour);
                topologicalSort(neighbour);
            }
        }
    }

    private static void createEdge(int src, int dest) {
        adj.get(src).add(dest);
        if(dependencyCounter.get(dest) == null)
            dependencyCounter.put(dest,1);
        else
            dependencyCounter.put(dest,dependencyCounter.get(dest)+1);
    }
}
