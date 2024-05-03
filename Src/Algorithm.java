import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Algorithm{
    public static boolean isConnected(String word1, String word2) {
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
    public static void printPath(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.prev;
        }
        
        System.out.println("Path: ");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i).word);
            if (i > 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    public static Set<String> loadDictionary(String filename) throws IOException {
        Set<String> dictionary = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String word;
            while ((word = reader.readLine()) != null) {
                dictionary.add(word.toLowerCase()); 
            }
        }
        return dictionary;
    }
    public static String readAlphabeticInput(Scanner scanner) {
        String input = scanner.nextLine().trim().toLowerCase();
        while (!input.matches("[a-zA-Z]+")) {
            System.out.println("Input hanya boleh berisi huruf alfabet.");
            System.out.print("Masukkan kembali: ");
            input = scanner.nextLine().trim().toLowerCase();
        }
        return input;
    }
    public static int BFScost(String target, String currentWord){
        int sameCount = 0;
        for (int i = 0; i < target.length(); i++) {
            if (currentWord.charAt(i) != target.charAt(i)) {
                sameCount++;
            }
        }
        return sameCount;
    }
}