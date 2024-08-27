package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CycleUndirectedGraph {
    static HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

    private static void addEdge(int src, int dest) {
        map.get(src).add(dest);
    }

    private static void createAdjacencyList(int[] vertices) {
        for(int i=0; i<vertices.length;i++)
            map.put(vertices[i],new LinkedList<Integer>());
    }

    public static void main(String[] args) {
        int [] vertices = {5,6,1,3,2};
        createAdjacencyList(vertices);
        addEdge(5,6);
        addEdge(6,5);
        addEdge(6,1);
        addEdge(1,2);
        addEdge(1,3);
        addEdge(1,6);
        //addEdge(2,1);
        addEdge(2,3);
        addEdge(3,1);
        addEdge(3,2);
        Set<Integer> visited = new HashSet<>();
        System.out.println(isCyclePresent(5,visited,-1));
    }

    private static boolean isCyclePresent(int index, Set<Integer> visited, int parent) {
        visited.add(index);
        int size = map.get(index).size();
        for(int i=0; i<size; i++){
            int val = map.get(index).get(i);
            if(!visited.contains(val)){
                if(isCyclePresent(val,visited,index))
                    return true;
            }else if(val!=parent)
                return true;
        }
        return false;
    }


}
