import java.util.*;

public class DepthFirstSearch {

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

    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph, List<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);
        for(int nbr : graph.get(node)) {
            if(!visited[nbr]) {
                dfs(nbr, visited, graph, dfs);
            }
        }
    }

    public static int[] depthFirstSearch(int v, int[][] edges, int src) {
        List<List<Integer>> graph = DepthFirstSearch.buildGraph(v, edges);
        boolean[] visited = new boolean[v + 1];
        List<Integer> dfs = new ArrayList<>();
        for(int i = 1; i <= v; i++) {
            if(!visited[i])
                DepthFirstSearch.dfs(i, visited, graph, dfs);
        }
        int ans[] = new int[v];
        for(int i = 0; i < v; i++) {
            ans[i] = dfs.get(i);
        }
        return ans;
    }
     public static void main(String[] args) {
        int v = 9;
        int[][] edges = new int[][]{{1, 2}, {1, 5}, {2, 3}, {3, 7}, {4, 6}, {4, 7}, {5, 6}, {5, 7}, {8, 9}};
        int src = 1;
        for(int a : DepthFirstSearch.depthFirstSearch(v, edges, src)) {
            System.out.print(a + " ");
        }
     }
}
