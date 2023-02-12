import java.util.*;

public class RoadsAndLibraries {

    public static List<List<Integer>> buildGraph(int n, List<List<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(List<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0)); // remove if directed
        }
        return graph;
    }

    public static int dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        int c = 1;
        for(int nbr : graph.get(node)) {
            if(!visited[nbr]) {
                c += dfs(nbr, visited, graph);
            }
        }
        return c;
    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        List<List<Integer>> graph = buildGraph(n, cities);
        boolean[] visited = new boolean[n + 1];
        List<Integer> connectedCount = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                int c = dfs(i, visited, graph);
                connectedCount.add(c);
            }
            
        }
        System.out.println(connectedCount);
        long cost = 0;
        // connectedComponentsCount;
        for(int cityCount : connectedCount) {
            cost += Math.min((c_lib + (cityCount - 1) * c_road), (cityCount * c_lib));
        }
        return cost;
    }

}
