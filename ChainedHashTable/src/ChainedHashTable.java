/**
 * Created by huzaifa.aejaz on 6/3/17.
 */
public class ChainedHashTable {

    String spell;
    String key;
    ChainedHashTable next;

    public ChainedHashTable(){
        key = "empty";
        spell = "empty";
        next = null;
    }

    public void setSpell(String spelling){
        spell = spelling;
    }
    public String getSpell(){
        return spell;
    }
    public void setNext(ChainedHashTable newNode){
        this.next = newNode;
    }

    public ChainedHashTable getNext(){
        return next;
    }



}
