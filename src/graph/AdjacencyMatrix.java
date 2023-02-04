import java.util.*;

public class AdjacencyMatrix {

    public static boolean[][] buildGraph(int v, int[][] edges) {
        boolean[][] graph = new boolean[v + 1][v + 1];

        for(int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true; // remove if directed
        }
        return graph;
    }

    public static void printGraph(int v, int[][] edges) {
        boolean[][] graph = AdjacencyMatrix.buildGraph(v, edges);
        for(int i = 1; i <= v; i++) {
            System.out.print(i + " : ");
            for(int j = 1; j <= v; j++) {
                if(graph[i][j])
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 5;
        int[][] edges = new int[][]{{1, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 5}, {3, 5}};
        AdjacencyMatrix.printGraph(v, edges);
    }
    
}
