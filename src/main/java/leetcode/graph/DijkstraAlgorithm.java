package leetcode.graph;


import java.util.*;

/*
* Why do we need Priority Queue - won't normal queue suffice?
* */
public class DijkstraAlgorithm {
    static class Node implements Comparator<Node> {
        private int node_vertex;
        private int cost;
        public Node(){}
        public Node(int vertex,int cost){
            this.node_vertex=vertex;
            this.cost=cost;
        }

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@code sgn(compare(x, y)) ==
         * -sgn(compare(y, x))} for all {@code x} and {@code y}.  (This
         * implies that {@code compare(x, y)} must throw an exception if and only
         * if {@code compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x, y)==0}
         * implies that {@code sgn(compare(x, z))==sgn(compare(y, z))} for all
         * {@code z}.<p>
         * <p>
         * It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."<p>
         * <p>
         * In the foregoing description, the notation
         * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
         * <i>signum</i> function, which is defined to return one of {@code -1},
         * {@code 0}, or {@code 1} according to whether the value of
         * <i>expression</i> is negative, zero, or positive, respectively.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.cost<o2.cost)
                return -1;
            if(o1.cost>o2.cost)
                return 1;
            return 0;
        }
    }

    private static List<List<Node>> adj = new ArrayList<>();
    private static int vertex=5;
    private static int[] dist = new int[vertex];
    private static Set<Integer> visited = new HashSet<>();
    private static PriorityQueue<Node> priorityQueue = new PriorityQueue<>(vertex,new Node());
    public static void main(String[] args) {
        int  src=0;
        for(int i=0; i<vertex; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(0,1,9);
        addEdge(0,2,6);
        addEdge(0,3,5);
        addEdge(0,4,3);
        addEdge(2,1,2);
        addEdge(2,3,4);

        dijkstraProblem(src);
        System.out.println("Shortest path from source : " + src);
        for (int i =0; i< vertex; i++){
            System.out.println(src + " to " + i + " is " + dist[i]);
        }
    }

    private static void dijkstraProblem(int src) {
        for (int i=0; i< vertex; i++)
            dist[i]=Integer.MAX_VALUE;

        priorityQueue.add(new Node(src,0));
        dist[src]=0;
        while (visited.size()!=vertex){
            int currentNode = priorityQueue.remove().node_vertex;
            visited.add(currentNode);
            findNeighbours(currentNode);
        }
    }

    /*
    * Greedy approach
    * */

    private static void findNeighbours(int currentNode) {
        int edgeDistance=-1, newDistance=-1;
        for(int i =0; i< adj.get(currentNode).size(); i++){
            Node neighbour = adj.get(currentNode).get(i);
            if(!visited.contains(neighbour)){
                edgeDistance=neighbour.cost;
                newDistance=dist[currentNode]+edgeDistance;
                if(newDistance<dist[neighbour.node_vertex])
                  dist[neighbour.node_vertex]=newDistance;
                priorityQueue.add(new Node(neighbour.node_vertex, dist[neighbour.node_vertex]));
            }
        }
    }

    private static void addEdge(int src, int dest, int cost){
        adj.get(src).add(new Node(dest,cost));
    }
}
