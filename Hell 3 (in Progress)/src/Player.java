

import java.util.*;
/**
 * Created by Liam on 11/6/2016.
 */
public class Player extends Character {
    static final int FORWARD=0;//North
    static final int LEFT=3;//West
    static final int RIGHT=1;//East
    static final int BACKWARD=2;//South
    int facing=FORWARD;

    ArrayList<Spell> spellList = new ArrayList<>();
    int[] coordinates=new int[3];

            public Player(){
                coordinates[0]=0;
                coordinates[1]=0;
                coordinates[2]=0;
            }
            public Player(String name){
                this();
                setName(name);
            }


    public ArrayList<Spell> getSpellList(){
        return spellList;
    }

    public void move(int dir){
        int x=coordinates[2];
        int y=coordinates[1];
        if(facing==FORWARD){
            if(dir==FORWARD){
                y--;
            }else if(dir==LEFT){
                x--;
            }else if(dir==RIGHT){
                x++;
            }else if(dir==BACKWARD){
                y++;
            }
        }else if(facing==LEFT){
            if(dir==FORWARD){
                x--;
            }else if(dir==LEFT){
                y++;
            }else if(dir==RIGHT){
                y--;
            }else if(dir==BACKWARD){
                x++;
            }
        }else if(facing==RIGHT){
            if(dir==FORWARD){
                x++;
            }else if(dir==LEFT){
                y--;
            }else if(dir==RIGHT){
                y++;
            }else if(dir==BACKWARD){
                x--;
            }
        }else if(facing==BACKWARD){
            if(dir==FORWARD){
                y++;
            }else if(dir==LEFT){
                x++;
            }else if(dir==RIGHT){
                x--;
            }else if(dir==BACKWARD){
                y--;
            }
        }
        coordinates[1]=y;
        coordinates[2]=x;
    }
    public void turnBack(){
        if(facing==FORWARD){
            facing=BACKWARD;
        }else if(facing==LEFT){
            facing=RIGHT;
        }else if(facing==RIGHT){
            facing=LEFT;
        }else{
            facing=FORWARD;
        }
    }
    public void turnLeft(){
        if(facing==FORWARD){
            facing=LEFT;
        }else if(facing==LEFT){
            facing=BACKWARD;
        }else if(facing==RIGHT){
            facing=FORWARD;
        }else{
            facing=RIGHT;
        }
    }
    public void turnRight(){
        if(facing==FORWARD){
            facing=RIGHT;
        }else if(facing==LEFT){
            facing=FORWARD;
        }else if(facing==RIGHT){
            facing=BACKWARD;
        }else{
            facing=LEFT;
        }
    }

    public int[] getCoordinates(){
        return coordinates;
    }

    public int getFacing(){
        return facing;
    }


}
