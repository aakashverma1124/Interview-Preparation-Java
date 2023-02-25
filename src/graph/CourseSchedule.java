import java.util.*;

public class CourseSchedule {
    public static void buildGraph(int v, int[][] edges, List<List<Integer>> graph, Map<Integer, Integer> indegree) {
        for(int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
            indegree.put(i, 0);
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree.put(edge[1], indegree.get(edge[1]) + 1);
        }
    }

    public static boolean canBeDone(int v, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        CourseSchedule.buildGraph(v, edges, graph, indegree);
        
        Queue<Integer> queue = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        List<Integer> sortedOrder = new ArrayList<>();
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            sortedOrder.add(currNode);

            for(int nbr : graph.get(currNode)) {
                indegree.put(nbr, indegree.get(nbr) - 1);
                if(indegree.get(nbr) == 0) {
                    queue.offer(nbr);
                }
            }
        }
        return sortedOrder.size() == v ? true : false;
    }

    public static void main(String[] args) {
        int v = 7;
        int[][] edges = new int[][]{{5, 1}, {5, 2}, {6, 2}, {6, 3}, {1, 4}, {2, 0}, {3, 0}};
        System.out.println(CourseSchedule.canBeDone(v, edges));
    }
}
