public class Node {
    String word;
    int cost;
    Node prev;
    
    Node(String word, int cost, Node prev) {
        this.word = word;
        this.cost = cost;
        this.prev = prev;
    }
}