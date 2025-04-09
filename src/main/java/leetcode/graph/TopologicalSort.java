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
        // This is to capture that pre-requisite node is visited.
        for(int i = 0; i<adj.get(key).size(); i++){
            int neighbour = adj.get(key).get(i);
            if(dependencyCounter.get(neighbour) >=0)
                dependencyCounter.put(neighbour,dependencyCounter.get(neighbour)-1);
        }

        // This is to figure out next node to hop on.
        for(int i = 0; i<adj.get(key).size(); i++) {
            int neighbour = adj.get(key).get(i);
            if (dependencyCounter.get(neighbour) == 0) {
                // This is to prevent revisit as we are visiting nodes only if all pre-requisites are completed.
                dependencyCounter.put(neighbour,-1);
                resultSet.add(neighbour);
                topologicalSort(neighbour);
            }
        }
    }

    private static void createEdge(int src, int dest) {
        adj.get(src).add(dest);
        dependencyCounter.merge(dest, 1, Integer::sum);
    }
}
