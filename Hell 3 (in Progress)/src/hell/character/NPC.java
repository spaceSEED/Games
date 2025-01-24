package hell.character;


import java.util.*;

import hell.utilities.dialog.*;

/**
 * Created by Liam on 11/6/2016.
 */
public class NPC extends Character {
	
    DialogTree conversation=null;
    String graphic="";

    public NPC(){

    }

    public NPC(boolean talkative){
        if(talkative){
            conversation=new DialogTree();
        }
    }
    
    public String getGraphic() {
    	return graphic;
    }
    
    public String toString(){
        return graphic+"\n\t"+getName()+"\nHealth: "+getHP()+"\tMana: "+getMana();
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
            temp.activate();
        }
    }
}
