import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Main{
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Berhenti? :");
        String command = scanner.nextLine().trim().toLowerCase();
        while (!command.equals("berhenti")){
            System.out.print("Masukkan start word: ");
            String startWord = Algorithm.readAlphabeticInput(scanner);
            
            System.out.print("Masukkan end word: ");
            String endWord = Algorithm.readAlphabeticInput(scanner);
            
            while (startWord.length() != endWord.length()) {
                System.out.println("Panjang start word dan end word harus sama.");
                System.out.print("Masukkan start word: ");
                startWord = Algorithm.readAlphabeticInput(scanner);
                
                System.out.print("Masukkan end word: ");
                endWord = Algorithm.readAlphabeticInput(scanner);
            }
            
            String dictionaryFile = "words_alpha.txt";
            
            try {
                Set<String> dictionary = Algorithm.loadDictionary(dictionaryFile);
                
                if (!dictionary.contains(startWord) || !dictionary.contains(endWord)) {
                    System.out.println("Start word atau end word tidak ditemukan dalam kamus.");
                    return;
                }
                System.out.print("Pilih Algoritma(ucs,gbfs,a*) : ");
                String input = scanner.nextLine().trim().toLowerCase();
                while (!input.equals("ucs") && !input.equals("gbfs") && !input.equals("a*")) {
                    System.out.println("Input salah! ");
                    System.out.print("Pilih Algoritma(ucs,gbfs,a*) : ");
                    input = scanner.nextLine().trim().toLowerCase();
                   
                }
    
                if (input.equals("ucs")) {
                    System.out.println("Algoritma UCS");
                    UCSAlgorithm.ucs(startWord, endWord, dictionary);
                } else if (input.equals("gbfs")) {
                    System.out.println("Algoritma GBFS");
                    GBFS.greedyBFS(startWord, endWord, dictionary);
                } else {
                    System.out.println("Algoritma A*");
                    AstarAlgorithm.Astar(startWord, endWord, dictionary);
                }
                System.out.print("Berhenti? :");
                command = scanner.nextLine().trim().toLowerCase();
            } catch (IOException e) {
                System.err.println("Error loading dictionary: " + e.getMessage());
            }

        }
        
        
       
    }
}
