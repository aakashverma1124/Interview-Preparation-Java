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

    public static List<Integer> breadthFirstSearch(int v, int[][] edges, int src) {
        List<List<Integer>> graph = AdjacencyList.buildGraph(v, edges);

        boolean[] visited = new boolean[v + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(src);
        visited[src] = true;

        List<Integer> bfs = new ArrayList<>();

        while(!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);
            for(int nbr : graph.get(node)) {
                if(!visited[nbr]) {
                    queue.offer(nbr);
                    visited[nbr] = true;
                }
            }
        }
        return bfs;

    }

    public static void main(String[] args) {
        int v = 6;
        int[][] edges = new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {3, 4}, {3, 6}, {4, 6}, {5, 6}};
        AdjacencyList.printGraph(v, edges);
        System.out.println(AdjacencyList.breadthFirstSearch(v, edges, 1));
    }
    
}
