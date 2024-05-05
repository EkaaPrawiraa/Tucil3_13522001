import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
// javac -d ../bin Main.java UCSAlgorithm.java AstarAlgorithm.java GBFS.java Algorithm.java Node.java
// java Main
public class Main{
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Algorithm.printIntro();
        while (true){
            try {
                
                Set<String> dictionary = Algorithm.loadDictionary("words_alpha.txt");
                System.out.println("______________________________________________________________________________________________________________________________________________________________________________________");
                Algorithm.printInput();
                System.out.print("Start word: ");
                String startWord = Algorithm.readAlphabeticInput(scanner);
                
                System.out.print("End word: ");
                String endWord = Algorithm.readAlphabeticInput(scanner);
                
                while (startWord.length() != endWord.length() || (!dictionary.contains(startWord) || !dictionary.contains(endWord) )) {
                    if (startWord.length() != endWord.length())
                    System.out.println("The start and end word must in the same length!");
                    else
                    System.out.println("The word is not in the dictionary!");
                    System.out.print("Start word: ");
                    startWord = Algorithm.readAlphabeticInput(scanner);
                    
                    System.out.print("End word: ");
                    endWord = Algorithm.readAlphabeticInput(scanner);
                }

                System.out.println("______________________________________________________________________________________________________________________________________________________________________________________");
                System.out.println("Choose Algorithm :");
                System.out.print("1. Uniform Cost Search (UCS).\n2. Greedy Best First Search (GBFS).\n3. A-Star (A*).\n");
                System.out.print("Input: ");
                String input = scanner.nextLine().trim().toLowerCase();
                while (!input.equals("ucs") && !input.equals("gbfs") && !input.equals("a*") && !input.equals("1")  && !input.equals("2") && !input.equals("3")) {
                    System.out.println("Wrong input!");
                    System.out.print("Choose Algorithm (UCS,GBFS,A*) : ");
                    input = scanner.nextLine().trim().toLowerCase();
                }
                System.out.println("______________________________________________________________________________________________________________________________________________________________________________________");
                Algorithm.printAlgo(input);
                if (input.equals("ucs") || input.equals("1")) {
                    UCSAlgorithm.ucs(startWord, endWord, dictionary);
                } else if (input.equals("gbfs") || input.equals("2")) {
               
                    GBFS.greedyBFS(startWord, endWord, dictionary);
                } else {
                  
                    AstarAlgorithm.Astar(startWord, endWord, dictionary);
                }
                System.out.println("______________________________________________________________________________________________________________________________________________________________________________________");
                System.out.print("\nDo you wish to stop?(y/n)\n");
                System.out.print("Input: ");
                String command = scanner.nextLine().trim().toLowerCase();
                if (command.equals("stop") || command.equals("yes") || command.equals("y") ){
                    break;
                }
            } catch (IOException e) {
                System.err.println("Error loading dictionary: " + e.getMessage());
                break;
            }

        }
        
        
       
    }
}

