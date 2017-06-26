import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by huzaifa.aejaz on 6/22/17.
 */
public class KeyListen extends Frame implements KeyListener {


    Label l1;
    Label l2;
    Label l3;
    TextArea area;
    StringBuilder sb = new StringBuilder();
    StringBuilder secondSb = new StringBuilder();
    Trie tries2 = new Trie();
    KeyListen(Trie sentTrie){

        l1=new Label();
        l2 = new Label();
        l3 = new Label();
        l1.setBounds(20,50,100,20);
        l2.setBounds(20,70,100,20);
        l3.setBounds(20,100,100,20);
        area=new TextArea();
        area.setBounds(20,200,300, 300);
        area.addKeyListener(this);
        tries2 = sentTrie;

        add(l1);
        add(l2);
        add(l3);
        add(area);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void keyPressed(KeyEvent e) {


        sb.append(e.getKeyChar());
        if(e.getKeyChar() == ' '){
            sb.setLength(0);
        }

        ArrayList<String> holds = new ArrayList<String>();
        holds = tries2.searchFullWords(sb.toString());
        if(holds != null && holds.size() >1){

            l1.setText(holds.get(0));
            l2.setText(holds.get(1));
            l3.setText(holds.get(2));



        }
        /*sb.append(e.getKeyChar()) ;
        if(e.getKeyChar() == ' '){
            sb.setLength(0);
        }

        ArrayList<String> holds = new ArrayList<String>();
        holds = trie.searchFullWords(sb.toString());
        if(holds != null){

            for(String str : holds){
                l.setText(str);
            }
        }*/
    }
    @Override
    public void keyReleased(KeyEvent e) {



    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
