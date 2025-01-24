package hell.utilities.dialog;

import java.io.*;
import java.util.*;

/**
 * Created by Liam on 11/12/2016.
 */
public class DialogTree {
    DialogNode root =null;

    public DialogTree(){

    }
    public DialogTree(String filePath){
        try {
            buildFromFile(filePath);
        }catch(IOException ioe){

        }
    }

    public DialogNode getRoot(){
        return root;
    }

    /**
     * parse a file containing a dialog tree (up to 6 branches)
     * format:
     *      [root phrase]
     *      1-6: [text] ;[effect]
     *      [numbers reset on next node]
     * number: indicates which child this branch leads to
     * [text]: the text to display
     * [effect]: possible effect of choosing a node (can be Null)
     *
     * Builds in a right-leaning depth first fashion (right-most child node of current node is built next)
     *
     * @param filePath
     * @throws IOException
     */
    public void buildFromFile(String filePath)throws IOException{
        Scanner in = new Scanner(new File(filePath));
        DialogNode temp=null;
        String str="";
        int last=0;
        Stack<DialogNode> tr=new Stack<DialogNode>();

        str=in.nextLine();
        if(root==null){//creates root
            root=new DialogNode(str,null);
            tr.push(root);
        }
        temp=root;

        while(in.hasNextLine()){
            str=in.nextLine();
            if(str.indexOf("1:")==0){
                if(1>last){
                    temp=tr.pop();
                }
                if(temp.getNode(0)==null) {
                    temp.setNode(0, str,str.substring(str.lastIndexOf(';')+1));
                }else{
                    tr.push(temp);
                    temp=temp.getNode(0);
                    if(temp.getNode(0)==null) {
                        temp.setNode(0, str,str.substring(str.lastIndexOf(';')+1));
                    }
                }
                last=1;

            }else if(str.indexOf("2:")==0){
                if(2>last){
                    temp=tr.pop();
                }
                if(temp.getNode(1)==null) {
                    temp.setNode(1, str,str.substring(str.lastIndexOf(';')+1));
                }else{
                    while(temp.getNode(1)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(1)==null) {
                        temp.setNode(1, str,str.substring(str.lastIndexOf(';')+1));
                    }
                }
                last=2;

            }else if(str.indexOf("3:")==0){
                if(3>last){
                    temp=tr.pop();
                }
                if(temp.getNode(2)==null) {
                    temp.setNode(2, str,str.substring(str.lastIndexOf(';')+1));
                }else{
                    while(temp.getNode(2)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(2)==null) {
                        temp.setNode(2, str,str.substring(str.lastIndexOf(';')+1));
                    }
                }

            }else if(str.indexOf("4:")==0){
                if(4>last){
                    temp=tr.pop();
                }
                if(temp.getNode(3)==null) {
                    temp.setNode(3, str,str.substring(str.lastIndexOf(';')+1));
                }else{
                    while(temp.getNode(3)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(3)==null) {
                        temp.setNode(3, str,str.substring(str.lastIndexOf(';')+1));
                    }
                }
                last=3;

            }else if(str.indexOf("5:")==0){
                if(5>last){
                    temp=tr.pop();
                }
                if(temp.getNode(4)==null) {
                    temp.setNode(4, str,str.substring(str.lastIndexOf(';')+1));
                }else{
                    while(temp.getNode(4)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(4)==null) {
                        temp.setNode(4, str,str.substring(str.lastIndexOf(';')+1));
                    }
                }
                last=4;

            }else if(str.indexOf("6:")==0){
                if(6>last){
                    temp=tr.pop();
                }
                if(temp.getNode(5)==null) {
                    temp.setNode(5, str,str.substring(str.lastIndexOf(';')+1));
                }else{
                    while(temp.getNode(5)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(5)==null) {
                        temp.setNode(5, str,str.substring(str.lastIndexOf(';')+1));
                    }
                }
                last=5;
            }
            tr.push(temp);
        }
        in.close();



    }



}

