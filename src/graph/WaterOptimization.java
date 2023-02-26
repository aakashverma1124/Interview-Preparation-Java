import java.util.*;

class Pair {
	int node, distance;
	public Pair(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}

class WaterOptimization {

	private static List<List<Pair>> buildGraph(int n, int[][] edges, int[] wells) {
		List<List<Pair>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int[] edge : edges) {
			graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
			graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
		}
        for(int i = 1; i <= n; i++) {
            graph.get(0).add(new Pair(i, wells[i - 1]));
            graph.get(i).add(new Pair(0, wells[i - 1]));
        }
		return graph;
	}

	private static int findMinCost(int n, int[][] edges, int[] wells) {
		List<List<Pair>> graph = WaterOptimization.buildGraph(n, edges, wells);
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> (p1.distance - p2.distance));
		
		boolean[] mstSet = new boolean[n + 1];
		int[] distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		int[] parent = new int[n + 1];

		distance[1] = 0;
		parent[1] = -1;
		minHeap.offer(new Pair(1, distance[1]));

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
					parent[nbrNode] = currNode;
					minHeap.offer(nbrPair);
				}
			}
		}
		int minCost = 0;
		for(int i = 0; i <= n; i++) {
			minCost += distance[i];
		}
		return minCost ;
	}

	public static void main(String[] args) {
		int[][] edges = new int[][]{{1, 2, 3}, {1, 4, 6}, {1, 5, 2}, {2, 4, 5}, {3, 5, 7}};
        int[] wells = new int[]{1, 4, 6, 5, 3};
        int nodes = 5;
		int cost = WaterOptimization.findMinCost(nodes, edges, wells);
		System.out.println(cost);
	}
}