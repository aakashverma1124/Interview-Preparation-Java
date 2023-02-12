import java.util.*;

public class CountNodesInDisconnectedComponents {

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

    public static int dfs(int node, boolean[] visited, List<List<Integer>> graph, int c) {
        visited[node] = true;
        c += 1;
        for(int nbr : graph.get(node)) {
            if(!visited[nbr]) {
                return dfs(nbr, visited, graph, c);
            }
        }
        return c;
    }

    public static List<Integer> disconnectedComponents(int v, int[][] edges) {
        List<List<Integer>> graph = CountNodesInDisconnectedComponents.buildGraph(v, edges);
        boolean[] visited = new boolean[v + 1];
        List<Integer> connectedCount = new ArrayList<>();
        for(int i = 1; i <= v; i++) {
            if(!visited[i]) {
                int c = CountNodesInDisconnectedComponents.dfs(i, visited, graph, 0);
                connectedCount.add(c);
            }
            
        }
        return connectedCount;
    }
     public static void main(String[] args) {
        int v = 9;
        int[][] edges = new int[][]{{1, 2}, {1, 5}, {2, 3}, {3, 7}, {4, 6}, {4, 7}, {5, 6}, {5, 7}, {8, 9}};
        System.out.println(CountNodesInDisconnectedComponents.disconnectedComponents(v, edges));
     }
}
