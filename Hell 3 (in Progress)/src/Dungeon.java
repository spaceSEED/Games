import  Graph.*;
import java.util.*;
/**
 * Created by Liam on 11/9/2016.
 */
public class Dungeon {
    final int floors=10;
    public Room[][][] dungeonMap=new Room[floors][15][15];

    public Dungeon(){
        for(int z=0;z<floors;z++){
            for(int y=0;y<dungeonMap[0].length;y++){
                for(int x=0;x<dungeonMap[0][0].length;x++){
                    dungeonMap[z][y][x]=new Room();
                }
            }
        }
        generate();
    }
    public Dungeon(Room[][][] load){
        dungeonMap=load;
    }

    public Room getRoom(int z,int y,int x){
        return dungeonMap[z][y][x];
    }


    public void generate(){
        Random ran=new Random();
        Map<Integer,String> needed=new HashMap<Integer, String>();
        needed.put(0,"d_stairs");
        needed.put(0,"u_stairs");
        needed.put(0,"chest");
        needed.put(0,"merchant");
        needed.put(0,"npc");

        for(int z=0;z<floors;z++){

            fillPath(z,pathFind(z,0,0,14,14));
            for(int y=0;y<15;y++){

                for(int x=0;x<15;x++){
                    Room[] near = getAdjacent(z,y,x);//[0]North [1]South [2]West [3]East
                    //dungeonMap[z][y][x]=new Room();
                    int n=dungeonMap[z][y][x].getNorth(); int s=dungeonMap[z][y][x].getSouth(); int e=dungeonMap[z][y][x].getEast(); int w=dungeonMap[z][y][x].getWest();
                    if(y==0){
                        n=Room.WALL;
                    }else{
                        if(dungeonMap[z][y][x].getNorth()==-1) {
                            if (near[0] != null) {
                                if (near[0].getSouth() == Room.WALL) {
                                    n = Room.WALL;
                                } else if (near[0].getSouth() == Room.DOOR) {
                                    n = Room.DOOR;
                                } else if (near[0].getSouth() == Room.OPEN) {
                                    n = Room.OPEN;
                                } else {

                                    int r = ran.nextInt(100);
                                    if(r<30){
                                        n = Room.DOOR;
                                    }else if(r<80){
                                        n = Room.OPEN;
                                    }else{
                                        n = Room.WALL;
                                    }

                                }
                            } else {
                                
                            }
                        }

                    }
                    if(x==0){
                        w=Room.WALL;
                    }else{
                        if(dungeonMap[z][y][x].getWest()==-1) {
                            if (near[2] != null) {
                                if (near[2].getEast() == Room.WALL) {
                                    w = Room.WALL;
                                } else if (near[2].getEast() == Room.DOOR) {
                                    w = Room.DOOR;
                                } else if (near[2].getEast() == Room.OPEN) {
                                    w = Room.OPEN;
                                } else {

                                    int r = ran.nextInt(100);
                                    if(r<30){
                                        w = Room.DOOR;
                                    }else if(r<80){
                                        w = Room.OPEN;
                                    }else{
                                        w = Room.WALL;
                                    }

                                }
                            } else {

                            }
                        }

                    }
                    if(x==dungeonMap[z][y].length-1){
                        e=Room.WALL;
                    }else{
                        if(dungeonMap[z][y][x].getEast()==-1) {
                            if (near[3] != null) {
                                if (near[3].getWest() == Room.WALL) {
                                    e = Room.WALL;
                                } else if (near[3].getWest() == Room.DOOR) {
                                    e = Room.DOOR;
                                } else if (near[3].getWest() == Room.OPEN) {
                                    e = Room.OPEN;
                                } else {

                                    int r = ran.nextInt(100);
                                    if(r<30){
                                        e= Room.DOOR;
                                    }else if(r<80){
                                        e = Room.OPEN;
                                    }else{
                                        e = Room.WALL;
                                    }

                                }
                            } else {

                            }
                        }

                    }
                    if(y==dungeonMap[z].length-1){
                        s=Room.WALL;
                    }else{
                        if(dungeonMap[z][y][x].getSouth()==-1) {
                            if (near[1] != null) {
                                if (near[1].getNorth() == Room.WALL) {
                                    s = Room.WALL;
                                } else if (near[1].getNorth() == Room.DOOR) {
                                    s = Room.DOOR;
                                } else if (near[1].getNorth() == Room.OPEN) {
                                    s = Room.OPEN;
                                } else {

                                    int r = ran.nextInt(100);
                                    if(r<30){
                                        s = Room.DOOR;
                                    }else if(r<80){
                                        s = Room.OPEN;
                                    }else{
                                        s = Room.WALL;
                                    }

                                }
                            } else {

                            }


                        }



                        dungeonMap[z][y][x].setEdges(n,e,s,w);


                    }

                }
            }
        }
    }

    public int[] get(int floor,Room r){
        for(int i=0;i<dungeonMap[0].length;i++){
            for(int j=0;j<dungeonMap[0][0].length;j++){
                if(r.equals(dungeonMap[floor][i][j])){
                    int[] asdf={i,j};
                    return asdf;
                }
            }
        }
        return null;
    }

    public void fillPath(int floor, List<Room> path){
        Random ran = new Random();
        for(int i=0;i<path.size()-1;i++){
            int r=ran.nextInt(40);
            int[] loc=get(floor,path.get(i));
            int[] loc2=get(floor,path.get(i+1));
            if(loc[0]==loc2[0]){
                if(loc[1]>loc2[1]){
                    int a=-1;
                    if(r<30){
                       a=Room.OPEN;
                    }else{
                        a=Room.DOOR;
                    }
                    dungeonMap[floor][loc[0]][loc[1]].setEast(a);
                    dungeonMap[floor][loc2[0]][loc2[1]].setWest(a);
                }else if(loc[1]<loc2[1]){
                    int a=-1;
                    if(r<30){
                        a=Room.OPEN;
                    }else{
                        a=Room.DOOR;
                    }
                    dungeonMap[floor][loc[0]][loc[1]].setWest(a);
                    dungeonMap[floor][loc2[0]][loc2[1]].setEast(a);
                }
            }else if(loc[1]==loc[1]){
                if(loc[0]>loc2[0]){
                    int a=-1;
                    if(r<30){
                        a=Room.OPEN;
                    }else{
                        a=Room.DOOR;
                    }
                    dungeonMap[floor][loc[0]][loc[1]].setSouth(a);
                    dungeonMap[floor][loc2[0]][loc2[1]].setNorth(a);
                }else if(loc[0]<loc2[0]){
                    int a=-1;
                    if(r<30){
                        a=Room.OPEN;
                    }else{
                        a=Room.DOOR;
                    }
                    dungeonMap[floor][loc[0]][loc[1]].setNorth(a);
                    dungeonMap[floor][loc2[0]][loc2[1]].setSouth(a);
                }
            }else{

            }
        }
    }

    public Room[] getAdjacent(int z, int y, int x){
        Room[] near = new Room[4];
        if(y-1<0){
            near[0]=null;
        }else{
            near[0]=dungeonMap[z][y-1][x];
        }
        if(y+1>=dungeonMap[0].length){
            near[1]=null;
        }else{
            near[1] = dungeonMap[z][y + 1][x];
        }
        if(x-1<0) {
            near[2]=null;
        }else{
            near[2]=dungeonMap[z][y][x-1];
        }
        if(x+1>=dungeonMap[0][0].length) {
            near[3]=null;
        }else{
            near[3] = dungeonMap[z][y][x + 1];
        }


        return near;
    }

    /**
     * Generates the path from stair a to b
     */
    public List<Room> pathFind(int floor,int a, int b, int y, int x){
        Graph<Room,String> pf= new SearchableGraphBFS();
        for(int i=0;i<dungeonMap[0].length;i++){
            for(int j=0;j<dungeonMap[0][0].length;j++){
                pf.addVertex(dungeonMap[floor][i][j]);
            }
        }for(int i=0;i<dungeonMap[0].length-1;i++){
            for(int j=0;j<dungeonMap[0][0].length-1;j++){//attaches edges: to make more complex paths I could remove edges.
                pf.addEdge(dungeonMap[floor][i][j],dungeonMap[floor][i][j+1],i+";"+j+","+(j+1));
                pf.addEdge(dungeonMap[floor][i][j],dungeonMap[floor][i+1][j],i+","+(i+1)+";"+j);
            }
        }for(int j=0;j<dungeonMap[0].length-1;j++){
            pf.addEdge(dungeonMap[floor][dungeonMap[0].length-1][j],dungeonMap[floor][dungeonMap[0].length-1][j+1],(dungeonMap[0].length-1)+";"+j+","+(j+1));
        }

        return pf.shortestPath(dungeonMap[floor][a][b],dungeonMap[floor][y][x]);
        

    }


    public Item genItem(int rarity){
        Item toReturn=null;
        Random ran=new Random();
        int r=ran.nextInt(100);
        String cls="";
        if(r<30){
            cls="armor";
            r=ran.nextInt(100);
            String type="";
            if(r<20){
                type="Helmet";
            }else if(r<40){
                type="Chassis";
            }else if(r<60){
                type="Boots";
            }else if(r<80){
                type="Gloves";
            }else{
                type="Shield";
            }
            toReturn=new Armor(itemNameGen(type,cls,rarity),type,(ran.nextInt(30)+3)*rarity,ran.nextInt(20)+3);
        }else if(r<60){
            cls="weapon";
            r=ran.nextInt(100);
            String type="";
            if(r<20){
                type="Sword";
            }else if(r<40){
                type="Bow_2Hand";
            }else if(r<60){
                type="Axe";
            }else if(r<80){
                type="Sword_2Hand";
            }else{
                type="";
            }
            //toReturn=new Weapon(itemNameGen(type,cls,rarity),type,(ran.nextInt(30)+3)*rarity,ran.nextInt(20)+3);
        }else if(r<70){
            cls="potion";
        }else if(r<80){
            cls="book";
        }else if(r<90){
            cls="food";
        }else{
            cls="misc";
        }

        return toReturn;
    }

    public String itemNameGen(String detail1,String detail2, int rarity){
        if(detail1.contains("_2Hand")){
            if(detail1.contains("Bow")){
                detail1="Bow";
            }else{
            detail1="Two-Handed "+detail1.substring(0,detail1.indexOf("_2Hand"));
        }}
        String str="";
        Random ran=new Random();
        int r=ran.nextInt(100)+rarity;
        if(r<40){
            r=ran.nextInt(100)+rarity;
            if(r<5&&detail2.equals("armor")) {
                str+="Cloth ";
            }else if(r<35&&detail2.equals("armor")){
                str+="Leather ";
            }else if(r<60){
                str+="Iron ";
            }else if(r<80){
                str+="Steel ";
            }else if(r<90){
                str+="Gold ";
            }else{
                str+="Ethereal ";
            }
            str+=detail1;
        }else if(r<60){
            r=ran.nextInt(100)+rarity;
            str+=detail1;
            if(r<5&&detail2.equals("armor")) {
                str+=" of Cloth";
            }else if(r<35&&detail2.equals("armor")){
                str+=" of Leather";
            }else if(r<60){
                str+=" of Iron";
            }else if(r<80){
                str+=" of Steel";
            }else if(r<90){
                str+=" of Gold";
            }else{
                str+=" of Ether";
            }
        }

        return str;
    }

}
