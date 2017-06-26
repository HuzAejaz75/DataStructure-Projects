import java.util.HashMap;

/**
 * Created by huzaifa.aejaz on 6/18/17.
 */
public class TrieNode {

    char ch;
    HashMap<Character,TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode(){

    }
    public TrieNode(char ch){
        this.ch = ch;
        isLeaf = false;

    }

}
