import java.util.*;

class TopologicalOrdering {

	public static void buildGraphAndIndegree(Map<Integer, Integer> inDegree, Map<Integer, List<Integer>> graph, int edges[][], int vertices) {
		for(int node = 0; node < vertices; node++) {
			inDegree.put(node, 0);
			graph.put(node, new ArrayList<>());
		}
		for(int edge[] : edges) {
			inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
			graph.get(edge[0]).add(edge[1]);
		}
	}

	public static List<Integer> topologicalOrdering(int edges[][], int vertices) {
		Map<Integer, Integer> inDegree = new HashMap<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		TopologicalOrdering.buildGraphAndIndegree(inDegree, graph, edges, vertices);
		Queue<Integer> queue = new LinkedList<>();
 		List<Integer> ordering = new ArrayList<>();
 		for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
 			if(entry.getValue() == 0) {
 				queue.offer(entry.getKey());
 			}
		}

		while(!queue.isEmpty()) {
			int currNode = queue.poll();
			ordering.add(currNode);
			for(int nbr : graph.get(currNode)) {
				inDegree.put(nbr, inDegree.get(nbr) - 1);
				if(inDegree.get(nbr) == 0) {
					queue.offer(nbr);
				}
			}
		}

		if(ordering.size() == vertices) {
			return ordering;
		}
		return new ArrayList<>();
 

	}
 	public static void main(String[] args) {
		int edges[][] = new int[][] {
			{0, 4},
			{0, 3},
			{0, 2},
			{1, 0},
			{1, 2},
			{2, 6},
			{3, 5},
			{3, 6},
			{4, 5}
		};
		int vertices = 7;
		List<Integer> ordering = TopologicalOrdering.topologicalOrdering(edges, vertices);
		for(int order : ordering) {
			System.out.print(order + " ");
		}
	}
}