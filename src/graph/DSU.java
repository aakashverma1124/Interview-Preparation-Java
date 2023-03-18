public class DSU {

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

    public static int[] connectedComponents(int n, int[][] edges) {

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            DSU.union(edge[0], edge[1], parent);
        }

        return parent;
    }
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 4}, {5, 6}, {6, 7}, {7, 8}, {3, 7}};
        int n = 9;
        int ans[] = DSU.connectedComponents(n, edges);
        for(int i = 0; i < n; i++) {
            System.out.println(ans[i] + " is parent if " + i);
        }
        System.out.println(find(8, ans));
    }
}
