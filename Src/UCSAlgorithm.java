
import java.util.*;
// javac WordLadderSolver.java
// java WordLadderSolver
public class UCSAlgorithm  {
    public static void ucs(String startWord, String endWord, Set<String> dictionary) {
        System.out.println("Loading...");
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
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
                    queue.add(new Node(word, current.cost + 1, current));
                }
            }
            // queue.stream().forEach(node -> System.out.printf("Cost: %d, Word: %s\n", node.cost, node.word));

            
            
        }       
        
        System.out.println("No path found!");
    }


    
    
    
    
    
    
     

}
