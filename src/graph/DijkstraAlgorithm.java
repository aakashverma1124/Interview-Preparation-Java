import java.util.*;

class Pair {
	int node, distance;
	public Pair(int node, int distance) {
		this.node = node;
		this.distance = distance;
	} 
}

class DijkstraAlgorithm {

	public static List<List<Pair>> buildGraph(int edges[][], int nodes) {

		List<List<Pair>> graph = new ArrayList<>();
		for(int i = 0; i < nodes; i++) {
			graph.add(new ArrayList<>());
		}
		for(int edge[] : edges) {
			graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
			graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
		}
		for(int i = 0; i < nodes; i++) {
			System.out.println(i + " : " + graph.get(i));
		}
		return graph;
	}

	public static int[] shortestPath(int edges[][], int nodes, int src) {
		List<List<Pair>> graph = DijkstraAlgorithm.buildGraph(edges, nodes);
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
				if(visited[nbrPair.node]) continue;
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
		int edges[][] = new int[][] {{0, 1, 2}, {0, 2, 9}, {0, 3, 8}, {1, 2, 5}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};

		int vertices = 5;
		int distance[] = shortestPath(edges, vertices, 0);
		for(int dist : distance) {
			System.out.print(dist + " ");
		}
	}
}