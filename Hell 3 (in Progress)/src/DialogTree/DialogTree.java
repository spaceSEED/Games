package DialogTree;

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


    public void buildFromFile(String filePath)throws IOException{
        Scanner in = new Scanner(new File(filePath));
        DialogNode temp=null;
        String str="";
        Stack tr=new Stack();
        while(in.hasNextLine()){
            str=in.nextLine();
            if(root==null){//creates root
                root=new DialogNode(str);
                tr.push(root);
                temp=root;
            }else if(str.indexOf("1:")==0){
                if(temp.getNode(0)==null) {
                    temp.setNode(0, str);
                }else{
                    tr.push(temp);
                    temp=temp.getNode(0);
                    if(temp.getNode(0)==null) {
                        temp.setNode(0, str);
                    }
                }

            }else if(str.indexOf("2:")==0){
                if(temp.getNode(1)==null) {
                    temp.setNode(1, str);
                }else{
                    while(temp.getNode(1)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(1)==null) {
                        temp.setNode(1, str);
                    }
                }

            }else if(str.indexOf("3:")==0){
                if(temp.getNode(2)==null) {
                    temp.setNode(2, str);
                }else{
                    while(temp.getNode(2)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(2)==null) {
                        temp.setNode(2, str);
                    }
                }

            }else if(str.indexOf("4:")==0){
                if(temp.getNode(3)==null) {
                    temp.setNode(3, str);
                }else{
                    while(temp.getNode(3)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(3)==null) {
                        temp.setNode(3, str);
                    }
                }

            }else if(str.indexOf("5:")==0){
                if(temp.getNode(4)==null) {
                    temp.setNode(4, str);
                }else{
                    while(temp.getNode(4)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(4)==null) {
                        temp.setNode(4, str);
                    }
                }

            }else if(str.indexOf("6:")==0){
                if(temp.getNode(5)==null) {
                    temp.setNode(5, str);
                }else{
                    while(temp.getNode(5)!=null){
                        temp=(DialogNode)tr.pop();
                    }
                    if(temp.getNode(5)==null) {
                        temp.setNode(5, str);
                    }
                }

            }
        }
        in.close();



    }



}

