import java.util.*;

public class AdjacencyList {

    public static List<List<Integer>> buildGraph(int v, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // remove if directed
        }
        return graph;
    }

    public static void printGraph(int v, int[][] edges) {
        List<List<Integer>> graph = AdjacencyList.buildGraph(v, edges);
        for(int i = 1; i <= v; i++) {
            System.out.print(i + " : ");
            for(int nbr : graph.get(i)) {
                System.out.print(nbr + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 5;
        int[][] edges = new int[][]{{1, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 5}, {3, 5}};
        AdjacencyList.printGraph(v, edges);
    }
    
}
