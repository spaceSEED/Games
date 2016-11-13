import DialogTree.*;
import java.util.*;

/**
 * Created by Liam on 11/6/2016.
 */
public class NPC extends Character {
    DialogTree conversation=null;

    public  NPC(){

    }

    public NPC(boolean talkative){
        if(talkative){
            conversation=new DialogTree();
        }
    }

    public void speak(){
        DialogNode temp = conversation.getRoot();
        Stack<DialogNode> prev = new Stack<DialogNode>();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print(temp.getValue()+"\n>>");
            String input=in.nextLine();
            if(input.indexOf("1")>=0){
                prev.push(temp);
                temp=temp.getNode(0);
            }else if(input.indexOf("2")>=0){
                prev.push(temp);
                temp=temp.getNode(1);
            }else if(input.indexOf("3")>=0){
                prev.push(temp);
                temp=temp.getNode(2);
            }else if(input.indexOf("4")>=0){
                prev.push(temp);
                temp=temp.getNode(3);
            }else if(input.indexOf("5")>=0){
                prev.push(temp);
                temp=temp.getNode(4);
            }else if(input.indexOf("6")>=0){
                prev.push(temp);
                temp=temp.getNode(5);
            }
        }
    }
}
