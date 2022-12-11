import java.util.*;

class Pair {
	int node, distance;
	public Pair(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}

class PrimsAlgorithm {

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
			graph.get(nbr).add(new Pair(curr, dist));
		}
		return graph;
	}

	public static int minimumSpanningTree(int edges[][], int nodes) {
		Map<Integer, List<Pair>> graph = PrimsAlgorithm.buildGraph(edges, nodes);
		PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> p1.distance - p2.distance);
		
		boolean mstSet[] = new boolean[nodes];
		int distance[] = new int[nodes];
		int parent[] = new int[nodes];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[0] = 0;
		parent[0] = -1;
		minHeap.offer(new Pair(0, distance[0]));

		while(!minHeap.isEmpty()) {
			Pair pair = minHeap.poll();
			int currNode = pair.node;
			int currDistance = pair.distance;
			
			if(mstSet[currNode]) continue;
			
			mstSet[currNode] = true;

			for(Pair nbrPair : graph.get(currNode)) {
				if(mstSet[nbrPair.node] != true && nbrPair.distance < distance[nbrPair.node]) {
					distance[nbrPair.node] = nbrPair.distance;
					minHeap.offer(new Pair(nbrPair.node, distance[nbrPair.node]));
					parent[nbrPair.node] = currNode;
				}
			}

		}
		int totalCost = 0;
		for(int d : distance) {
			totalCost += d;
			System.out.print(d + " ");
		}
		System.out.println();
		return totalCost;
	}

	public static void main(String[] args) {
		int edges[][] = new int[][] {
			{0, 1, 7}, 
			{0, 2, 6}, 
			{0, 3, 4}, 
			{1, 2, 4}, 
			{1, 3, 3}, 
			{2, 3, 9}
		};

		int vertices = 4;
		int totalCost = PrimsAlgorithm.minimumSpanningTree(edges, vertices);
		System.out.println(totalCost);
	}
}