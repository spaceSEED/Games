package hell.dungeon;


import java.util.*;

import hell.items.Item;
import hell.utilities.GameValues;
import hell.utilities.graph.*;
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

    /**
     * Get a Room of the Dungeon
     * @param z
     * @param y
     * @param x
     * @return
     */
    public Room getRoom(int z,int y,int x){
        return dungeonMap[z][y][x];
    }

    /**
     * Create a random dungeon configuration
     */
    public void generate(){//Todo populate with items/npcs/chests +stairs
        Random ran=new Random();
        Map<String,Integer> needed=new HashMap<String,Integer>();
        //needed.put("d_stairs",0);
        //needed.put("u_stairs",0);
        needed.put("chest",0);
        needed.put("merchant",0);
        needed.put("npc",0);

        int[] exit=new int[2];
        
        exit[0]=-1;
        exit[1]=-1;
        
        for(int z=0;z<floors;z++){
        	
        	if(exit[0]!=-1)//set stairs back to previous level
        		dungeonMap[z][exit[0]][exit[1]].setStairs(1);
        	//create a valid path through the dungeon floor
            fillPath(z,pathFind(z,0,0,14,14));
            
            //set stairs to next level
            exit[0]=14;
            exit[1]=14;
    		dungeonMap[z][exit[0]][exit[1]].setStairs(-1);
            
            for(int y=0;y<15;y++){

                for(int x=0;x<15;x++){
                    Room[] near = getAdjacent(z,y,x);//[0]North [1]South [2]West [3]East
                    //dungeonMap[z][y][x]=new Room();
                    int n=dungeonMap[z][y][x].getNorth();
                    int s=dungeonMap[z][y][x].getSouth(); 
                    int e=dungeonMap[z][y][x].getEast(); 
                    int w=dungeonMap[z][y][x].getWest();
                    
                    if(y==0){
                        n=GameValues.WALL;
                    }else{
                        if(dungeonMap[z][y][x].getNorth()==-1) {
                            if (near[0] != null) {
                                if (near[0].getSouth() == GameValues.WALL) {
                                    n = GameValues.WALL;
                                } else if (near[0].getSouth() == GameValues.DOOR) {
                                    n = GameValues.DOOR;
                                } else if (near[0].getSouth() == GameValues.OPEN) {
                                    n = GameValues.OPEN;
                                } else {

                                    int r = ran.nextInt(100);
                                    if(r<30){
                                        n = GameValues.DOOR;
                                    }else if(r<80){
                                        n = GameValues.OPEN;
                                    }else{
                                        n = GameValues.WALL;
                                    }

                                }
                            } else {
                                
                            }
                        }

                    }
                    if(x==0){
                        w=GameValues.WALL;
                    }else{
                        if(dungeonMap[z][y][x].getWest()==-1) {
                            if (near[2] != null) {
                                if (near[2].getEast() == GameValues.WALL) {
                                    w = GameValues.WALL;
                                } else if (near[2].getEast() == GameValues.DOOR) {
                                    w = GameValues.DOOR;
                                } else if (near[2].getEast() == GameValues.OPEN) {
                                    w = GameValues.OPEN;
                                } else {

                                    int r = ran.nextInt(100);
                                    if(r<30){
                                        w = GameValues.DOOR;
                                    }else if(r<80){
                                        w = GameValues.OPEN;
                                    }else{
                                        w = GameValues.WALL;
                                    }

                                }
                            } else {

                            }
                        }

                    }
                    if(x==dungeonMap[z][y].length-1){
                        e=GameValues.WALL;
                    }else{
                        if(dungeonMap[z][y][x].getEast()==-1) {
                            if (near[3] != null) {
                                if (near[3].getWest() == GameValues.WALL) {
                                    e = GameValues.WALL;
                                } else if (near[3].getWest() == GameValues.DOOR) {
                                    e = GameValues.DOOR;
                                } else if (near[3].getWest() == GameValues.OPEN) {
                                    e = GameValues.OPEN;
                                } else {

                                    int r = ran.nextInt(100);
                                    if(r<30){
                                        e= GameValues.DOOR;
                                    }else if(r<80){
                                        e = GameValues.OPEN;
                                    }else{
                                        e = GameValues.WALL;
                                    }

                                }
                            } else {

                            }
                        }

                    }
                    if(y==dungeonMap[z].length-1){
                        s=GameValues.WALL;
                    }else{
                        if(dungeonMap[z][y][x].getSouth()==-1) {
                            if (near[1] != null) {
                                if (near[1].getNorth() == GameValues.WALL) {
                                    s = GameValues.WALL;
                                } else if (near[1].getNorth() == GameValues.DOOR) {
                                    s = GameValues.DOOR;
                                } else if (near[1].getNorth() == GameValues.OPEN) {
                                    s = GameValues.OPEN;
                                } else {

                                    int r = ran.nextInt(100);
                                    if(r<30){
                                        s = GameValues.DOOR;
                                    }else if(r<80){
                                        s = GameValues.OPEN;
                                    }else{
                                        s = GameValues.WALL;
                                    }

                                }
                            } else {

                            }


                        }



                        dungeonMap[z][y][x].setEdges(n,e,s,w);//set the wall/open status of the current room


                    }

                }
            }
        }
    }

    /**
     * Get Dungeon coordinates (y,x) given a floor and room
     * @param floor
     * @param r
     * @return
     */
    public int[] get(int floor,Room r){
        for(int i=0;i<dungeonMap[0].length;i++){
            for(int j=0;j<dungeonMap[0][0].length;j++){
                if(r==dungeonMap[floor][i][j]){
                    int[] coor={i,j};
                    return coor;
                }
            }
        }
        return null;
    }

    /**
     * Create a valid path through a floor of the dungeon. (Ensure that the game is beatable.)
     * @param floor
     * @param path
     */
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
                       a=GameValues.OPEN;
                    }else{
                        a=GameValues.DOOR;
                    }
                    dungeonMap[floor][loc[0]][loc[1]].setWest(a);
                    dungeonMap[floor][loc2[0]][loc2[1]].setEast(a);
                }else if(loc[1]<loc2[1]){
                    int a=-1;
                    if(r<30){
                        a=GameValues.OPEN;
                    }else{
                        a=GameValues.DOOR;
                    }
                    dungeonMap[floor][loc[0]][loc[1]].setEast(a);
                    dungeonMap[floor][loc2[0]][loc2[1]].setWest(a);
                }
            }else if(loc[1]==loc[1]){
                if(loc[0]>loc2[0]){
                    int a=-1;
                    if(r<30){
                        a=GameValues.OPEN;
                    }else{
                        a=GameValues.DOOR;
                    }
                    dungeonMap[floor][loc[0]][loc[1]].setNorth(a);
                    dungeonMap[floor][loc2[0]][loc2[1]].setSouth(a);
                }else if(loc[0]<loc2[0]){
                    int a=-1;
                    if(r<30){
                        a=GameValues.OPEN;
                    }else{
                        a=GameValues.DOOR;
                    }
                    dungeonMap[floor][loc[0]][loc[1]].setSouth(a);
                    dungeonMap[floor][loc2[0]][loc2[1]].setNorth(a);
                }
            }else{

            }
        }
    }

    /**
     * Given a room's coordinates get each of the rooms adjacent to it.
     *        [0]North [1]South [2]West [3]East
     * @param z
     * @param y
     * @param x
     * @return
     */
    public Room[] getAdjacent(int z, int y, int x){
        Room[] near = new Room[4];
        if(y-1<0){//north
            near[0]=null;
        }else{
            near[0]=dungeonMap[z][y-1][x];
        }
        if(y+1>=dungeonMap[0].length){//south
            near[1]=null;
        }else{
            near[1] = dungeonMap[z][y + 1][x];
        }
        if(x-1<0) {//west
            near[2]=null;
        }else{
            near[2]=dungeonMap[z][y][x-1];
        }
        if(x+1>=dungeonMap[0][0].length) {//east
            near[3]=null;
        }else{
            near[3] = dungeonMap[z][y][x + 1];
        }


        return near;
    }

    /**
     * Generates the path from stair (a,b) to (y,x)
     * @param floor
     * @param a
     * @param b
     * @param y
     * @param x
     * @return
     */
    public List<Room> pathFind(int floor,int a, int b, int y, int x){
        Graph<Room,String> pf;
        do {
        	pf= new SearchableGraphBFS<>();
        	for(int i=0;i<dungeonMap[0].length;i++){
        		for(int j=0;j<dungeonMap[0][0].length;j++){
        			pf.addVertex(dungeonMap[floor][i][j]);
        		}
        	}
        	for(int i=0;i<dungeonMap[0].length-1;i++){//add interior links
        		for(int j=0;j<dungeonMap[0][0].length-1;j++){//attaches edges: to make more complex paths I could remove edges.
        			pf.addEdge(dungeonMap[floor][i][j],dungeonMap[floor][i][j+1],i+";"+j+","+(j+1));
        			pf.addEdge(dungeonMap[floor][i][j],dungeonMap[floor][i+1][j],i+","+(i+1)+";"+j);
        		}
        	}
        	for(int j=0;j<dungeonMap[0].length-1;j++){//link far edges
        		pf.addEdge(dungeonMap[floor][dungeonMap[0].length-1][j],dungeonMap[floor][dungeonMap[0].length-1][j+1],(dungeonMap[0].length-1)+";"+j+","+(j+1));
        	}
        	for(int j=0;j<dungeonMap[0].length-1;j++){
        		pf.addEdge(dungeonMap[floor][j][dungeonMap[0][0].length-1],dungeonMap[floor][j+1][dungeonMap[0][0].length-1],(dungeonMap[0][0].length-1)+","+(j+1)+";"+j);
        	}
        }while(!pf.reachable(dungeonMap[floor][a][b],dungeonMap[floor][y][x]));

        return pf.shortestPath(dungeonMap[floor][a][b],dungeonMap[floor][y][x]);
        

    }

    /**
     * Randomly creates an Item given a rarity value.
     * @param rarity
     * @return
     */
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
            //toReturn=new Armor(itemNameGen(type,cls,rarity),type,(ran.nextInt(30)+3)*rarity,ran.nextInt(20)+3);
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

    /**
     * Randomly creates an item name.
     * 
     * @param detail1
     * @param detail2
     * @param rarity
     * @return
     */
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
    
    /**
     * Returns a top down, north-facing map of the current dungeon floor.
     * 
     * @param floor
     * @param py - player y
     * @param px - player x
     * @param facing - player orientation
     * @return
     */
    public String getMap(int floor, int py, int px, int facing) {
    	String map="";
    	for(int y=0;y<dungeonMap[0].length;y++){
    		map+="===";
    	}
		map+="\n";
    	for(int y=0;y<dungeonMap[0].length;y++){
            for(int x=0;x<dungeonMap[0][0].length;x++){
            	if(y==py&&x==px) {
            		if(facing==0)
            			map+=" ^ ";
            		else if(facing==1)
            			map+=" > ";
            		else if(facing==2)
            			map+=" v ";
            		else if(facing==3)
            			map+=" < ";
            		else
            			map+=" X ";
            	}else if(dungeonMap[floor][y][x].checkVisited()) {
                	if(dungeonMap[floor][y][x].getSouth()==GameValues.WALL)
                		map+="___";
                	else if(dungeonMap[floor][y][x].getEast()==GameValues.WALL)
                		map+="  |";
                	else if(dungeonMap[floor][y][x].getWest()==GameValues.WALL)
                		map+="|  ";
                	else
                		map+="   ";
                }else {
            		map+="+++";
                }
            }
    		map+="\n";
        }
    	for(int y=0;y<dungeonMap[0].length;y++){
    		map+="===";
    	}
    	return map;
    }

}
