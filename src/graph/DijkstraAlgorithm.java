import java.util.*;

class Pair {
	int node, distance;
	public Pair(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}

class DijkstraAlgorithm {

	public static Map<Integer, List<Pair>> buildGraph(int edges[][], int nodes) {

		Map<Integer, List<Pair>> graph = new HashMap<>();
		for(int i = 0; i < nodes; i++) {
			graph.put(i, new ArrayList<>());
		}
		for(int edge[] : edges) {
			int curr = edge[0];
			int nbr = edge[1];
			int dist = edge[2];
			graph.get(curr).add(new Pair(nbr, dist));
		}
		return graph;
	}

	public static int[] shortestPath(int edges[][], int nodes, int src) {
		Map<Integer, List<Pair>> graph = DijkstraAlgorithm.buildGraph(edges, nodes);
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> p1.distance - p2.distance);
		
		boolean visited[] = new boolean[nodes];
		int distance[] = new int[nodes];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[src] = 0;
		minHeap.offer(new Pair(src, distance[src]));

		while(!minHeap.isEmpty()) {
			Pair pair = minHeap.poll();
			int currNode = pair.node;
			int currDistance = pair.distance;
			
			if(visited[currNode]) continue;
			
			visited[currNode] = true;

			for(Pair nbrPair : graph.get(currNode)) {
				int newDistance = currDistance + nbrPair.distance;
				if(newDistance < distance[nbrPair.node]) {
					distance[nbrPair.node] = newDistance;
					minHeap.offer(new Pair(nbrPair.node, distance[nbrPair.node]));
				}
			}

		}
		return distance;
	}

	public static void main(String[] args) {
		int edges[][] = new int[][] {
			{0, 1, 5}, 
			{0, 4, 3}, 
			{1, 2, 10}, 
			{3, 5, 8}, 
			{3, 2, 2}, 
			{4, 2, 5}, 
			{4, 3, 4}, 
			{4, 5, 17}
		};

		int vertices = 6;
		int distance[] = shortestPath(edges, vertices, 0);
		for(int dist : distance) {
			System.out.print(dist + " ");
		}
	}
}