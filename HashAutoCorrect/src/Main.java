
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by huzaifa.aejaz on 6/17/17.
 */
public class Main  {










    public static void main(String[] args) throws FileNotFoundException {
       // Manager mgr = new Manager();
        Scanner scanner = new Scanner(new File("//Users/huzaifa.aejaz/Desktop/famous.csv"));
        scanner.useDelimiter(",");
        String meaning;
        Trie tries = new Trie();
        int count = 0;
        boolean found = false;
        while (scanner.hasNext())
        {
            count++;
            String word = scanner.nextLine();
            tries.Insert(word);
        }
       KeyListen KL = new KeyListen(tries);
      //trie.searchFullWords("acce");
       /* if(found){
            System.out.println("The word is present");
        }
        else{
            System.out.println("The word doesn;t exist");
        }*/
    }

}
