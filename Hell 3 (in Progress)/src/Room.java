

import java.util.*;

/**
 * Created by Liam on 11/9/2016.
 */
public class Room {
    static final int WALL=0;
    static final int DOOR=1;
    static final int OPEN =2;
    private int[] neswEdge=new int[4];//[0]=North,[1]=East,[2]=South,[3]=West
    ArrayList<Item> inside= new ArrayList<>();
    //String description;

    public Room(){
        neswEdge[0]=-1;neswEdge[1]=-1;neswEdge[2]=-1;neswEdge[3]=-1;
        build();
    }


    public String getDescription(){
        String description="===================\n";
        for(int y=0;y<6;y++){
            for(int x=0;x<18;x++){
                if(x==8&&y>1&&y<4){
                    if(y==2){description+="o";}else if(y==3){description+="X";}
                }else if(neswEdge[0]==WALL&&x>4&&x<12&&(y==1)){
                    description+="=";
                }else if(neswEdge[2]==WALL&&x>4&&x<12&&(y==4)){
                    description+="=";
                }else if(neswEdge[2]==WALL&&x>4&&x==12&&(y==4)){
                    description+=" ";
                }else if(neswEdge[0]==WALL&&x>4&&x==12&&(y==1)){
                    description+=" ";
                }else if(neswEdge[3]==WALL&&y>1&&y<4&&(x==5)){
                    description+="|";
                }else if(neswEdge[1]==WALL&&y>1&&y<4&&(x==9)){
                    description+="   | ++++";
                }else if(neswEdge[1]==WALL&&y>1&&y<4&&(x>9)){

                }else if(y>0&&y<5&&x>3&&x<12){
                    description+=" ";
                }else{
                    description+="+";
                }
            }
            description+="\n";
        }

        description+="===================";
        return description;
    }

    public void build(){
        Random ran = new Random();
        for(int r=0;r<neswEdge.length;r++){
            neswEdge[r]=ran.nextInt(3);
        }
    }
    public void setEdges(int a,int b,int c,int d){
        neswEdge[0]=a;
        neswEdge[1]=b;
        neswEdge[2]=c;
        neswEdge[3]=d;
    }
    public int getNorth(){
        return neswEdge[0];
    }
    public int getSouth(){
        return neswEdge[2];
    }
    public int getEast(){
        return neswEdge[1];
    }
    public int getWest(){
        return neswEdge[3];
    }
    public void setNorth(int a){
        neswEdge[0]=a;
    }
    public void setSouth(int a){
        neswEdge[2]=a;
    }
    public void setEast(int a){
        neswEdge[1]=a;
    }
    public void setWest(int a){
        neswEdge[3]=a;
    }
    public boolean isOpening(int a){
        if(neswEdge[a]==OPEN||neswEdge[a]==DOOR){
            return true;
        }
        return false;
    }
}
