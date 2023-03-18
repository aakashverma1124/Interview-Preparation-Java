class Solution {
    public void union(int u, int v, int[] parent) {
        int pu = find(u, parent);
        int pv = find(v, parent);
        if(pu != pv) {
            parent[pv] = pu;
        }
    }

    public int find(int node, int[] parent) {
        if(parent[node] == node) {
            return node;
        }
        return find(parent[node], parent);
    }

    public int mst(int n, int[][] edges, int includeEdge[], int excludeEdge[]) {

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int ans = 0;
        int size = 0;
        if(includeEdge != null) {
            int parent1 = find(includeEdge[0], parent);
            int parent2 = find(includeEdge[1], parent);
            union(parent1, parent2, parent);
            ans += includeEdge[2];
            size += 1;
        }
        
        for(int[] edge : edges) {
            if(excludeEdge != null && edge[0] == excludeEdge[0] && edge[1] == excludeEdge[1] && edge[2] ==  excludeEdge[2]) {
                continue;
            }
            if(includeEdge != null && edge[0] == includeEdge[0] && edge[1] == includeEdge[1] && edge[2] ==  includeEdge[2]) {
                continue;
            }
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            int p1 = find(u, parent);
            int p2 = find(v, parent);
            if(p1 != p2) {
                union(p1, p2, parent);
                ans += cost;
                size += 1;
            }
        }

        return (size == n - 1) ? ans : Integer.MAX_VALUE; 
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int originalEdges[][] = new int[edges.length][3];
        for(int i = 0; i < edges.length; i++) {
            originalEdges[i][0] = edges[i][0];
            originalEdges[i][1] = edges[i][1];
            originalEdges[i][2] = edges[i][2];
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int originalCost = mst(n, edges, null, null);
        for(int i = 0; i < originalEdges.length; i++) {
            int excludedCost = mst(n, edges, null, originalEdges[i]);
            int includedCost = mst(n, edges, originalEdges[i], null);
            if(excludedCost > originalCost) {
                criticalEdges.add(i);
            } else if(includedCost == originalCost) {
                pseudoCriticalEdges.add(i);
            }
        }
        result.add(criticalEdges);
        result.add(pseudoCriticalEdges);
        return result;
    }
}