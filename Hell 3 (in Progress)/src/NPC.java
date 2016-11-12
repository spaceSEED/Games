import DialogTree.DialogTree;

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
}
