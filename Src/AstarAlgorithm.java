import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AstarAlgorithm{
    public static void Astar(String startWord, String endWord, Set<String> dictionary){
        System.out.println("Loading...");
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node node) -> node.cost));
        Set<String> visited = new HashSet<>();
        int visitedNodes = 0;
        
        long startTime = System.nanoTime();
        
        queue.add(new Node(startWord, 0, null));
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            // System.out.println("Current Word :"+ current.word + ", Cost :" +current.cost);
            // System.out.println();
            // System.out.println();

            visitedNodes++;
            visited.add(current.word);
            
            if (current.word.equals(endWord)) {
                long endTime = System.nanoTime();
                Algorithm.printPath(current);
                System.out.println("Banyaknya node yang dikunjungi: " + visitedNodes);
                System.out.println("Waktu eksekusi program: " + (endTime - startTime) / 1000000 + " ms");
                return;
            }
            
            for (String word : dictionary) {
                if (!visited.contains(word) && Algorithm.isConnected(current.word, word)) {
                    int resultCost = Algorithm.BFScost(endWord, word);
                    // System.out.println("Current Word :"+ current.word +",Word :"+ word + ", Cost :" +resultCost);
                    queue.add(new Node(word, current.cost + 1 + resultCost, current));
                }
            }
            // queue.stream().forEach(node -> System.out.printf("Cost: %d, Word: %s\n", node.cost, node.word));

            
            
        }       
        
        System.out.println("No path found!");
    }
}
