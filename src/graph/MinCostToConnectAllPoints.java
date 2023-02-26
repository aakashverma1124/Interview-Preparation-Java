import java.util.*;

class Pair {
	int node, distance;
	public Pair(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}

class Solution {
    private List<List<Pair>> buildGraph(int n, int[][] edges) {
		List<List<Pair>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int[] edge : edges) {
			graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
			graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
		}
		return graph;
	}

	private int findMinCost(int n, int[][] edges) {
		List<List<Pair>> graph = buildGraph(n, edges);
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> (p1.distance - p2.distance));
		
		boolean[] mstSet = new boolean[n + 1];
		int[] distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[0] = 0;
		minHeap.offer(new Pair(0, distance[0]));

		while(!minHeap.isEmpty()) {
			Pair pair = minHeap.poll();
			int currNode = pair.node;

			if(mstSet[currNode]) continue;

			mstSet[currNode] = true;

			for(Pair nbrPair : graph.get(currNode)) {
				int nbrNode = nbrPair.node;
				int nbrDistance = nbrPair.distance;
				
				if(!mstSet[nbrNode] && nbrDistance < distance[nbrNode]) {
					distance[nbrNode] = nbrDistance;
					minHeap.offer(nbrPair);
				}
			}
		}
		int minCost = 0;
		for(int i = 0; i < n; i++) {
			minCost += distance[i];
		}
		return minCost ;
	}

    public int minCostConnectPoints(int[][] points) {
        int[][] edges = new int[(points.length * (points.length - 1))/ 2][3];
        int k = 0;
        for(int i = 0; i < points.length - 1; i++) {
            for(int j = i + 1; j < points.length; j++) {
                edges[k][0] = i;
                edges[k][1] = j;
                edges[k][2] = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                k += 1;
            }
        }
        return findMinCost(points.length, edges);
        
    }
}