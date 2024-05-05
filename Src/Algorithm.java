import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Algorithm{
    // fungsi untuk mengecheck apakah dua kata memiliki hubungan sesuai dengan ketentuan game yaitu panjang katanya sama dan total perbedaan hurufnya hanya satu
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
    // fungsi untuk mencetak hasil rute 
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
    // fungsi untuk meload kamus
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
    // fungsi untuk memvalidasi input hanya berisi huruf saja
    public static String readAlphabeticInput(Scanner scanner) {
        String input = scanner.nextLine().trim().toLowerCase();
        while (!input.matches("[a-zA-Z]+")) {
            System.out.println("Alphabet only!");
            System.out.print("Reinput: ");
            input = scanner.nextLine().trim().toLowerCase();
        }
        return input;
    }
    // fungsi untuk menghitung berapa banyak perbedaan huruf dari kata target dan kata yang sedang di check
    public static int GBFScost(String target, String currentWord){
        int diffCount = 0;
        for (int i = 0; i < target.length(); i++) {
            if (currentWord.charAt(i) != target.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount;
    }
    public static void printIntro(){
        System.out.println();
        System.out.println("▄█      █▄   ▄██████▄     ▄████████ ████████▄        ▄█          ▄████████ ████████▄  ████████▄     ▄████████    ▄████████         ▄██████▄     ▄████████   ▄▄▄▄███▄▄▄▄      ▄████████ ");
        System.out.println("███     ███ ███    ███   ███    ███ ███   ▀███      ███         ███    ███ ███   ▀███ ███   ▀███   ███    ███   ███    ███        ███    ███   ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███ ");
        System.out.println("███     ███ ███    ███   ███    ███ ███    ███      ███         ███    ███ ███    ███ ███    ███   ███    █▀    ███    ███        ███    █▀    ███    ███ ███   ███   ███   ███    █▀  ");
        System.out.println("███     ███ ███    ███  ▄███▄▄▄▄██▀ ███    ███      ███         ███    ███ ███    ███ ███    ███  ▄███▄▄▄      ▄███▄▄▄▄██▀       ▄███          ███    ███ ███   ███   ███  ▄███▄▄▄     ");
        System.out.println("███     ███ ███    ███ ▀▀███▀▀▀▀▀   ███    ███      ███         ███    ███ ███    ███ ███    ███ ▀▀███▀▀▀     ▀▀███▀▀▀▀▀        ▀▀███ ████▄  ▀███████████ ███   ███   ███ ▀▀███▀▀▀     ");
        System.out.println("███     ███ ███    ███ ▀███████████ ███    ███      ███       ▀███████████ ███    ███ ███    ███   ███    █▄  ▀███████████        ███    ███   ███    ███ ███   ███   ███   ███    █▄  ");
        System.out.println("███ ▄█▄ ███ ███    ███   ███    ███ ███   ▄███      ███▌    ▄   ███    ███ ███   ▄███ ███   ▄███   ███    ███   ███    ███        ███    ███   ███    ███ ███   ███   ███   ███    ███ ");
        System.out.println(" ▀███▀███▀   ▀██████▀    ███    ███ ████████▀       █████▄▄██   ███    █▀  ████████▀  ████████▀    ██████████   ███    ███        ████████▀    ███    █▀   ▀█   ███   █▀    ██████████ ");
        System.out.println("                         ███    ███                 ▀                                                           ███    ███                                                              ");
    }
    public static void printInput(){
        System.out.println();
        System.out.println(
            "██╗███╗   ██╗██████╗ ██╗   ██╗████████╗    ██╗    ██╗ ██████╗ ██████╗ ██████╗ \n" +
            "██║████╗  ██║██╔══██╗██║   ██║╚══██╔══╝    ██║    ██║██╔═══██╗██╔══██╗██╔══██╗\n" +
            "██║██╔██╗ ██║██████╔╝██║   ██║   ██║       ██║ █╗ ██║██║   ██║██████╔╝██║  ██║\n" +
            "██║██║╚██╗██║██╔═══╝ ██║   ██║   ██║       ██║███╗██║██║   ██║██╔══██╗██║  ██║\n" +
            "██║██║ ╚████║██║     ╚██████╔╝   ██║       ╚███╔███╔╝╚██████╔╝██║  ██║██████╔╝\n" +
            "╚═╝╚═╝  ╚═══╝╚═╝      ╚═════╝    ╚═╝        ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝ \n" +
            "                                                                                 "
        );
    }
    public static void printAlgo(String input){
        System.out.println();
        if (input.equals("gbfs") || input.equals("2"))
        {
            System.out.println(".·:'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''':·.");
            System.out.println(": :  ██████╗ ██████╗ ███████╗███████╗     █████╗ ██╗      ██████╗  ██████╗ ██████╗ ██╗████████╗██╗  ██╗███╗   ███╗ : :");
            System.out.println(": : ██╔════╝ ██╔══██╗██╔════╝██╔════╝    ██╔══██╗██║     ██╔════╝ ██╔═══██╗██╔══██╗██║╚══██╔══╝██║  ██║████╗ ████║ : :");
            System.out.println(": : ██║  ███╗██████╔╝█████╗  ███████╗    ███████║██║     ██║  ███╗██║   ██║██████╔╝██║   ██║   ███████║██╔████╔██║ : :");
            System.out.println(": : ██║   ██║██╔══██╗██╔══╝  ╚════██║    ██╔══██║██║     ██║   ██║██║   ██║██╔══██╗██║   ██║   ██╔══██║██║╚██╔╝██║ : :");
            System.out.println(": : ╚██████╔╝██████╔╝██║     ███████║    ██║  ██║███████╗╚██████╔╝╚██████╔╝██║  ██║██║   ██║   ██║  ██║██║ ╚═╝ ██║ : :");
            System.out.println(": :  ╚═════╝ ╚═════╝ ╚═╝     ╚══════╝    ╚═╝  ╚═╝╚══════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝   ╚═╝   ╚═╝  ╚═╝╚═╝     ╚═╝ : :");
            System.out.println("'·:................................................................................................................:·'");

        }
        else if (input.equals("ucs") || input.equals("1")){
            System.out.println(".·:'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''':·.");
            System.out.println(": : ██╗   ██╗ ██████╗███████╗     █████╗ ██╗      ██████╗  ██████╗ ██████╗ ██╗████████╗██╗  ██╗███╗   ███╗ : :");
            System.out.println(": : ██║   ██║██╔════╝██╔════╝    ██╔══██╗██║     ██╔════╝ ██╔═══██╗██╔══██╗██║╚══██╔══╝██║  ██║████╗ ████║ : :");
            System.out.println(": : ██║   ██║██║     ███████╗    ███████║██║     ██║  ███╗██║   ██║██████╔╝██║   ██║   ███████║██╔████╔██║ : :");
            System.out.println(": : ██║   ██║██║     ╚════██║    ██╔══██║██║     ██║   ██║██║   ██║██╔══██╗██║   ██║   ██╔══██║██║╚██╔╝██║ : :");
            System.out.println(": : ╚██████╔╝╚██████╗███████║    ██║  ██║███████╗╚██████╔╝╚██████╔╝██║  ██║██║   ██║   ██║  ██║██║ ╚═╝ ██║ : :");
            System.out.println(": :  ╚═════╝  ╚═════╝╚══════╝    ╚═╝  ╚═╝╚══════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝   ╚═╝   ╚═╝  ╚═╝╚═╝     ╚═╝ : :");
            System.out.println("'·:........................................................................................................:·'");

        }
        else{
            System.out.println(".·:'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''':·.");
            System.out.println(": :  █████╗       ███████╗████████╗ █████╗ ██████╗      █████╗ ██╗      ██████╗  ██████╗ ██████╗ ██╗████████╗██╗  ██╗███╗   ███╗ : :");
            System.out.println(": : ██╔══██╗      ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗    ██╔══██╗██║     ██╔════╝ ██╔═══██╗██╔══██╗██║╚══██╔══╝██║  ██║████╗ ████║ : :");
            System.out.println(": : ███████║█████╗███████╗   ██║   ███████║██████╔╝    ███████║██║     ██║  ███╗██║   ██║██████╔╝██║   ██║   ███████║██╔████╔██║ : :");
            System.out.println(": : ██╔══██║╚════╝╚════██║   ██║   ██╔══██║██╔══██╗    ██╔══██║██║     ██║   ██║██║   ██║██╔══██╗██║   ██║   ██╔══██║██║╚██╔╝██║ : :");
            System.out.println(": : ██║  ██║      ███████║   ██║   ██║  ██║██║  ██║    ██║  ██║███████╗╚██████╔╝╚██████╔╝██║  ██║██║   ██║   ██║  ██║██║ ╚═╝ ██║ : :");
            System.out.println(": : ╚═╝  ╚═╝      ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝    ╚═╝  ╚═╝╚══════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝   ╚═╝   ╚═╝  ╚═╝╚═╝     ╚═╝ : :");
            System.out.println("'·:..............................................................................................................................:·'");
    
        }
        System.out.println();
            
    }


}
