package leetcode.graph;

import java.util.*;

/*
* Need to check if graph is a tree or not.
* */
public class GraphTree {

    private static Map<Integer, List<Integer>> adj = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();
    private static Set<Integer> connected = new HashSet<>();
    private static int VERTICES = 4;

    public static void main(String[] args) {
        int [] vertices = {0,1,2,3,4};
        for(int val:vertices)
            adj.put(val, new ArrayList<>());
        addEdge(0,1);
        addEdge(1,0);
        addEdge(1,2);
        addEdge(2,1);
        addEdge(2,3);
        addEdge(3,2);
       // addEdge(3,1);
        boolean res = isGraphTree(0,-1);
        System.out.println("Is Graph Tree " + res);
    }

    private static boolean isGraphTree(int src, int parent) {
        // cyclic check
        boolean isCyclic = isGraphCyclic(src, parent);
        // Connected graph check
        isGraphConnected(src);
        boolean isConnected = connected.size() == VERTICES ? true:false;
        System.out.println("IsCyclic" + isCyclic);
        System.out.println("isConnected" + isConnected);
        if(!isCyclic && isConnected)
            return true;
        return false;
    }

    private static boolean isGraphCyclic(int src, int parent) {
        visited.add(src);
        boolean res=false;
        for(int val : adj.get(src)){
            if(visited.contains(val) && parent!=val)
                return true;
            if(!visited.contains(val))
            res = isGraphCyclic(val,src);
        }
        return res;
    }

    private static void isGraphConnected(int src) {
        connected.add(src);
        for(int val : adj.get(src)){
            if(!connected.contains(val))
            isGraphConnected(val);
        }
    }


    private static void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }
}
