import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by huzaifa.aejaz on 6/3/17.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        SpellMap spellMap = new SpellMap(2000);
       // wordMidLevel midLevel = new wordMidLevel();
       // wordManager wm = new wordManager(1000);
        Scanner scanner = new Scanner(new File("//Users/huzaifa.aejaz/Desktop/wordswords.csv"));
        scanner.useDelimiter(",");
        String meaning;
        while (scanner.hasNext()) {
            String word = scanner.nextLine();

            StringBuilder sb = new StringBuilder();
            String[] splitString = word.split("\\,");
            //System.out.println("array length is" + splitString.length);
            for (int i = 1; i < splitString.length; i++) {
                sb.append(splitString[i]);
                if (i < splitString.length - 1) {
                    sb.append(",");
                }

            }
            meaning = sb.toString();

            spellMap.addSPell(splitString[0],meaning);

        }
        System.out.println("Please enter a word? ");
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();

        spellMap.displayDictionary(data);








    }
}
