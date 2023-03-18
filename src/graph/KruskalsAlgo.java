import java.util.*;

public class KruskalsAlgo {

    public static void union(int u, int v, int[] parent) {
        int pu = find(u, parent);
        int pv = find(v, parent);
        if(pu != pv) {
            parent[pv] = pu;
        }
    }

    public static int find(int node, int[] parent) {
        if(parent[node] == node) {
            return node;
        }
        return find(parent[node], parent);
    }

    public static int mst(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int ans = 0;
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            int p1 = KruskalsAlgo.find(u, parent);
            int p2 = KruskalsAlgo.find(v, parent);
            if(p1 != p2) {
                KruskalsAlgo.union(p1, p2, parent);
                ans += cost;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1, 8}, {0, 2, 2}, {1, 4, 1}, {1, 5, 3}, {2, 3, 6}, {2, 4, 3}, {3, 5, 4}, {4, 5, 2}};
        int n = 6;
        int ans = KruskalsAlgo.mst(n, edges);
        System.out.println(ans);
    }
}
