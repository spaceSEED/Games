import java.util.*;

/**
 * Created by Liam on 11/9/2016.
 */
public class Room {
    static final int WALL=0;
    static final int DOOR=1;
    static final int OPEN =2;
    int[] neswEdge=new int[4];//[0]=North,[1]=East,[2]=South,[3]=West
    ArrayList<Item> inside= new ArrayList<>();

    public Room(){
        build();
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
    }public int getNorth(){
        return neswEdge[0];
    }public int getSouth(){
        return neswEdge[2];
    }public int getEast(){
        return neswEdge[1];
    }public int getWest(){
        return neswEdge[3];
    }
}
