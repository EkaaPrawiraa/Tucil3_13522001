import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
// javac WordLadderSolver.java
// java WordLadderSolver
public class WordLadderSolver {
    
    static class Node {
        String word;
        int cost;
        Node prev;
        
        Node(String word, int cost, Node prev) {
            this.word = word;
            this.cost = cost;
            this.prev = prev;
        }
    }
    
    // Function to check if two words differ by exactly one character
    static boolean isConnected(String word1, String word2) {
        int diffCount = 0;
        if (word1.length() != word2.length())
        {
            return false;
        }
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false;
            }
        }
        return diffCount == 1;
    }
    
    // UCS Algorithm
    static void ucs(String startWord, String endWord, Set<String> dictionary) {
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
                printPath(current);
                System.out.println("Banyaknya node yang dikunjungi: " + visitedNodes);
                System.out.println("Waktu eksekusi program: " + (endTime - startTime) / 1000000 + " ms");
                return;
            }
            
            for (String word : dictionary) {
                if (!visited.contains(word) && isConnected(current.word, word)) {
                    queue.add(new Node(word, current.cost + 1, current));
                }
            }
        }
        
        System.out.println("No path found!");
    }
    
    
    static void printPath(Node node) {
        List<String> path = new ArrayList<>();
        while (node != null) {
            path.add(node.word);
            node = node.prev;
        }
        
        System.out.println("Path: ");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
            if (i > 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    static Set<String> loadDictionary(String filename) throws IOException {
        Set<String> dictionary = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String word;
            while ((word = reader.readLine()) != null) {
                dictionary.add(word.toLowerCase()); 
            }
        }
        return dictionary;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan start word: ");
        String startWord = scanner.nextLine().trim().toLowerCase();
        
        System.out.print("Masukkan end word: ");
        String endWord = scanner.nextLine().trim().toLowerCase();
        
        while (startWord.length() != endWord.length()) {
            System.out.println("Panjang start word dan end word harus sama.");
            System.out.print("Masukkan start word: ");
            startWord = scanner.nextLine().trim().toLowerCase();
            
            System.out.print("Masukkan end word: ");
            endWord = scanner.nextLine().trim().toLowerCase();
        }
        
        String dictionaryFile = "words_alpha.txt";
        
        try {
            Set<String> dictionary = loadDictionary(dictionaryFile);
            
            if (!dictionary.contains(startWord) || !dictionary.contains(endWord)) {
                System.out.println("Start word atau end word tidak ditemukan dalam kamus.");
                return;
            }
            
            ucs(startWord, endWord, dictionary);
        } catch (IOException e) {
            System.err.println("Error loading dictionary: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

}
