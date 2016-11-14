package src.DialogTree;

/**
 * Created by Liam on 11/12/2016.
 */
public class DialogNode {
    private DialogNode[] nodes=new DialogNode[6];
    private String value="";

    public DialogNode(){

    }
    public DialogNode(String speach){
        value=speach;
    }

    public String getValue(){
        return value;
    }

    public DialogNode getNode(int i){
        if(i>=6||i<0){
            return null;
        }
        return nodes[i];
    }
    public void setNode(int i, String val){
        if(i>=6||i<0){
        }else{
            nodes[i]=new DialogNode(val);
        }
    }
}
