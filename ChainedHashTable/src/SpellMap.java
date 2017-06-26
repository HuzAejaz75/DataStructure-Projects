/**
 * Created by huzaifa.aejaz on 6/3/17.
 */
public class SpellMap {

    ChainedHashTable spellBucket;
    ChainedHashTable[] Dictionary;
    int size;

    public SpellMap(int size){
        //initilize a array which connects to the spell checker
        // array[i] = spellchecker
        this.size = size;
       Dictionary = new ChainedHashTable[size];

       for(int i = 0; i < size; i++){
           Dictionary[i] = null;
       }
    }

    public int hashFunc(String word)
    {
        int num = 0;
        for(int i = 0; i < word.length();i++){
            num  += (int) word.charAt(i);
        }

        num *= num;
        // System.out.println("The square is " + num);
        String numWord = Integer.toString(num);
        int numLen = numWord.length();
        int middleNumber=0;
        if(numLen%2==1)
        {
            if(numLen> 3)
            {
                while(numLen >3){
                    numWord = numWord.substring(1,numLen -1);
                    numLen = numWord.length();

                }
                middleNumber = Integer.parseInt(numWord);
                return middleNumber % size;
            }
            else
            {
                middleNumber =  num;
                return middleNumber % size;
            }
        }
        else{

            if(numLen > 2)
            {
                while(numLen > 2)
                {
                    numWord = numWord.substring(1,numLen-1);
                    numLen = numWord.length();
                }
                middleNumber = Integer.parseInt(numWord);
                return middleNumber % size;
            }
            else
            {
                middleNumber = num;
                return middleNumber % size;
            }
        }

    }
    //now we need to associate each of these array indexes with the bucket

    public void addSPell(String word, String meaning){
        // in this function we need to check if the thing is having a slt, what thign?
        //the array which houses the linkedlist.
        ChainedHashTable Node = new ChainedHashTable();
        Node.key = word;
        Node.setSpell(meaning);

        //now hash the word and find a slot
        int index = hashFunc(word);
        if(Dictionary[index] == null){
            //if the slot is not occupied then just add the node to this

            Dictionary[index] = Node;
           // System.out.println(word + " : " + index);
        }
        else{
            // if the slot is occupied

            //check if the key is the same ?

            if(Dictionary[index].key.equalsIgnoreCase(word)){
                //then just iterate and add it
                 ChainedHashTable traverseNode = Dictionary[index];
                 while(traverseNode.next != null){
                     traverseNode = traverseNode.next;
                 }
                 traverseNode.next = Node;
               // System.out.println(word + " : " + index);

            }
            else{
                // hunt for another slot
                index = findWordIndex(index, word);
                if(index != -1){

                    ChainedHashTable traverseNode = Dictionary[index];
                    while(traverseNode.next != null){
                        traverseNode = traverseNode.next;
                    }
                    traverseNode.next = Node;
                   // System.out.println(word + " : " + index);
                }
                else{
                    index = index = hashFunc(word);
                    index = nextIndex(index);
                    Dictionary[index] = Node;
                //    System.out.println("hehe " + word + " : " + index);
                   // System.out.println("There are no free slots left in the table.");
                }

            }
        }

    }


    public int nextIndex(int curIndex) {

        int inc = 1;
        int probeCount = 0;
        boolean found = false;
        while (Dictionary[curIndex]!= null && probeCount < Dictionary.length / 2) {

            probeCount++;
            curIndex = (curIndex + inc) % size;
            inc = inc + 2;
        }
        if(Dictionary[curIndex] == null){
            return curIndex;
        }
        else{
            return -1;
        }


    }
    public int findWordIndex(int curIndex, String word) {

        int inc = 1;
        int probeCount = 0;
        boolean found = false;
        while ( !found && probeCount < size) {

            probeCount++;
            curIndex = (curIndex + inc) % size;
            if(Dictionary[curIndex]!= null){
                if(Dictionary[curIndex].key.equalsIgnoreCase(word))
                            found = true;
            }
            inc = inc + 2;
        }

        if(found) {
            return curIndex;
        }
        else{
            return -1;
        }
    }
/*
    public void addSpell(  String word, String meaning){//, String CorrectSpelling){
        //takes a string and hashes it and then adds all of the correct spelling assocaued with it there

        ChainedHashTable Node = new ChainedHashTable();
        Node.setSpell(meaning);
        int hashCode = hashFunc (word);
        boolean exist = false;
        //here check if the word actaully exists in the dictioanary
        //the call should be amde to a mehtod in midlevel which will then rereive the index and return the vlaue this obtained
        //this value is comapred to the word and if true we priceed w=fruther/



        if(exist){
            if(Dictionary[hashCode]==null){
                Dictionary[hashCode] = Node;
            }
            else{
                ChainedHashTable curNode = Dictionary[hashCode];

                while(curNode.next != null){
                    curNode = curNode.getNext();
                }
                curNode.next = Node;


            }

        }
        else{
            System.out.println(" The word doesn;t exist");
        }



    }
*/
    public void displayDictionary(String word){

        //check in the specified slot and see if you can find the key match,

        //if yes then display all of its contents

        //if no then find the next slot where we could find such a word and see if there we can find such a slot if
        //it returns a -1 then such a word doesn't exist in our table ...

        int index = hashFunc(word);
        if(Dictionary[index] != null){
            if(Dictionary[index].key.equalsIgnoreCase(word)){

                ChainedHashTable displayNode = new ChainedHashTable();
                displayNode = Dictionary[index];

                while(displayNode.next != null){
                    System.out.println(displayNode.key + " : "+ displayNode.spell);
                    displayNode = displayNode.next;
                }
                System.out.println(displayNode.spell);
            }
            else{
                int probeCount = 0;
                int curIndex = index;
                ChainedHashTable node = new ChainedHashTable();
                   curIndex = findWordIndex(curIndex, word);
                if(curIndex != -1){
                    node = Dictionary[curIndex];

                    while(node.next != null){
                        System.out.println(node.key +" : "+ node.spell);
                        node = node.next;
                    }
                    System.out.println(node.spell);
                }
            }

        }
        else{
            System.out.println("The word doesn't exist in our dictionary");
        }


    }

}
