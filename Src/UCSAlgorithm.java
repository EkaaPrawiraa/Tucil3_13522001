
import java.util.*;
public class UCSAlgorithm  {
    // // Algoritma UCS memprioritaskan rute dengan cost terkecil dimana cost adalah nilai cost dari start ke n

    public static void ucs(String startWord, String endWord, Set<String> dictionary) {
        System.out.println("Loading...");
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        Set<String> visited = new HashSet<>();
        int visitedNodes = 0;
        long startTime = System.nanoTime();
        queue.add(new Node(startWord, 0, null));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visitedNodes++;
            visited.add(current.word);
            if (current.word.equals(endWord)) {
                long endTime = System.nanoTime();
                Algorithm.printPath(current);
                System.out.println("Word checked: " + visitedNodes);
                System.out.println("Time Taken: " + (endTime - startTime) / 1000000 + " ms");
                return;
            }
            for (String word : dictionary) {
                if (!visited.contains(word) && Algorithm.isConnected(current.word, word)) {
                    queue.add(new Node(word, current.cost + 1, current));
                }
            }   
        }       
        
        System.out.println("No path found!");
    }
    
}
