import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * Created by huzaifa.aejaz on 6/18/17.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void Insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode Tnode;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (children.containsKey(charArray[i])) {
                Tnode = children.get(charArray[i]);
            } else {
                Tnode = new TrieNode(charArray[i]);
                children.put(charArray[i], Tnode);
            }
            children = Tnode.children;

            if (i == word.length() - 1) {
                Tnode.isLeaf = true;
            }
        }
    }


    public TrieNode searchWord(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            if (children.containsKey(ch)) {
                //here we move over

                t = children.get(ch);
                sb.append(ch);


                children = t.children;

            } else {
                return null;
            }
        }

        return t;
    }

    public ArrayList<String> searchFullWords(String prefix){

        ArrayList<String> returnList = new ArrayList<String>();
        if(prefix.length() > 0){
            HashMap<Character, TrieNode> children = root.children;
            TrieNode t = null;
            boolean holds = startsWith(prefix);
            if(holds){
                //loop through and get all the values
                //get the chars
                char[] holder = prefix.toCharArray();
                StringBuilder sb = new StringBuilder();
                //sb.append(holder[0]);
                // t = children.get(holder[0]);

                //enter the next level which is holder [1]
                for(char c : holder){
                    t = children.get(c);
                    sb.append(t.ch);
                    children = t.children;
                }

                for(Object e : children.keySet()){
                    String secondary = "";
                    ArrayList<String> wordListHold = new ArrayList<>();

                   // wordListHold = wordBuilder(t,e, secondary);

                    secondary = wordBuilder(t,e, secondary);

                    String[] secondaryHolder;

                    secondaryHolder = secondary.split(":");
                    int i = 1;
                    if(secondaryHolder.length >   1){
                        while(i < secondaryHolder.length){
                            secondaryHolder[i] = secondaryHolder[i-1]+ secondaryHolder[i];
                            i++;
                        }
                    }


                    for(String sec : secondaryHolder){
                        String fullword = sb.toString() + sec;
                        returnList.add(fullword);
                        System.out.println(fullword);
                    }

                }



            }

        }
        return returnList;


    }

    private void rankWords(ArrayList<String> rankingList){
        //take the arraylist
        //take the word and then we need to retrieive the value and then we
        //need to complete the work for this.

        //retreive the rank


        // we do not have time, now is the time
        // we need to work on that app
        // that is the procrastination killer

    }


    //private ArrayList<String> wordBuilder2(){

        //pass an int i

        //this int is acceptable only when an absolute children = null is reached

        //when reached increment to 1

        //always keep this less than the value for the other parts

   // }

    // this function uses recursion to build the secondary words and send them back
    private String wordBuilder(TrieNode node,Object obj, String Secondary) {//ArrayList<String> secondaryWordList, int index){

        HashMap<Character,TrieNode> traverseChildren = new HashMap<Character,TrieNode>();

        traverseChildren = node.children;
        node = traverseChildren.get(obj);
        Secondary += node.ch;
        traverseChildren = node.children;
        if(node.children != null && !(node.isLeaf)){
            for(Object objc : traverseChildren.keySet())
              // return wordBuilder(node, objc,Secondary, secondaryWordList);
                return wordBuilder(node, objc,Secondary);
        }
        else if((node.isLeaf)&& node.children.size() != 0){
            Secondary +=":";
           // secondaryWordList.add(Secondary);
            for(Object objc : traverseChildren.keySet())
                //return wordBuilder(node, objc,Secondary,secondaryWordList);
                return wordBuilder(node, objc,Secondary);
        }
        else{


            return Secondary;
        }
        return Secondary;
       // return secondaryWordList;

    }



    public boolean search(String word) {
        TrieNode trienode = searchWord(word);

        if (trienode != null && trienode.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {

        if(searchWord(prefix) == null)
            return false;
        else
            return true;

    }
}




       // System.out.println("read the word and store it at this point in a chianed hashtable, so that all the words the key is associated with may be retreived");
       // another approch could be quues but doesnt look effective

        //astro is the key
        //naut
        //nauts
        /*
        nomy get added to the chained hash table
        and in the end we retreive the chain and just add each one up and and add them to the arraylist of words to be returned

        //thats that.

         is there another approach to this?

         I cannot grasp what he has written need to diceiphet ad run it rhough to understand its inner working
         for now this is our technique
         where we take the word prefix and iterate to the tree and store the words untill the branching point
         and from then on make as many chained values as there are nodes

         suppose thos sub nodes have values
         then we need to add'em all up


could there be a cleverer way of doing it?
we need to go through the root wrd and store it then we need to add

         */
