import java.util.*;

public class AlienDictionary {
    public static void buildGraph(int n, int k,  String[] words, Map<Character, List<Character>> graph, Map<Character, Integer> indegree) {
        for(char i = 'a'; i < 'a' + k; i++) {
            graph.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }

        for(int i = 0; i < words.length - 1; i++) {
            String currWord = words[i];
            String nextWord = words[i + 1];
            for(int j = 0; j < Math.min(currWord.length(), nextWord.length()); j++) {
                if(currWord.charAt(j) != nextWord.charAt(j)) {
                    graph.get(currWord.charAt(j)).add(nextWord.charAt(j));
                    indegree.put(nextWord.charAt(j), indegree.get(nextWord.charAt(j)) + 1);
                    break;
                }
            }
        }
    }

    public static String findOrder(int n, int k, String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        AlienDictionary.buildGraph(n, k, words, graph, indegree);

        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        StringBuilder sortedOrder = new StringBuilder();
        while(!queue.isEmpty()) {
            char currNode = queue.poll();
            sortedOrder.append(currNode);

            for(char nbr : graph.get(currNode)) {
                indegree.put(nbr, indegree.get(nbr) - 1);
                if(indegree.get(nbr) == 0) {
                    queue.offer(nbr);
                }
            }
        }
        return sortedOrder.length() == k ? sortedOrder.toString() : "";
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 4;
        String words[] = { "baa", "abcd", "abca", "cab", "cad"};
        System.out.println(AlienDictionary.findOrder(n, k, words));
    }
}
