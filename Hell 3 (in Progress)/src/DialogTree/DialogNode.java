package DialogTree;

/**
 * Created by Liam on 11/12/2016.
 */
public class DialogNode {
    private DialogNode[] nodes=new DialogNode[6];
    private String value="";
    private String effect;

    public DialogNode(){

    }
    public DialogNode(String speech, String eff){
        value=speech;
        effect=eff;
    }

    public String getValue(){
        return value;
    }

    public void activate(){
        if(effect.equals("shop")){
            //run shop script
        }else if(effect.equals("insult")){
            //
        }else if(effect.equals("flatter")){
            //
        }else if (effect.equals("exit")){
            //exit dialog tree
        }else{//if null or something
            //do nothing
        }
    }

    public DialogNode getNode(int i){
        if(i>=6||i<0){
            return null;
        }
        return nodes[i];
    }
    public void setNode(int i, String val, String eff){
        if(i>=6||i<0){
        }else{
            nodes[i]=new DialogNode(val,eff);
        }
    }
}
