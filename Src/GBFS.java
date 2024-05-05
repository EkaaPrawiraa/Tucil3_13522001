import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GBFS {
    // Algoritma greedy BFS memprioritaskan rute dengan cost terkecil dimana cost adalah nilai cost dari n ke goal (jumlah huruf yang berbeda dari word n ke word goal)
    public static void greedyBFS(String startWord, String endWord, Set<String> dictionary){
        System.out.println("Loading...");
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node node) -> node.cost));
        Set<String> visited = new HashSet<>();
        int visitedNodes = 0;
        long startTime = System.nanoTime();
        queue.add(new Node(startWord,  Algorithm.GBFScost(endWord, startWord), null));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visitedNodes++;
            visited.add(current.word);
            if (current.word.equals(endWord)) {
                long endTime = System.nanoTime();
                Algorithm.printPath(current);
                System.out.println("Word checked: " + visitedNodes);
                System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
                return;
            }
            for (String word : dictionary) {
                if (!visited.contains(word) && Algorithm.isConnected(current.word, word)) {
                    int resultCost = Algorithm.GBFScost(endWord, word);
                    queue.add(new Node(word, resultCost, current));
                }
            }   
        }       
        System.out.println("No path found!");
    }
}
