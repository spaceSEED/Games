

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

    public Player() {
        coordinates[0] = 0;
        coordinates[1] = 0;
        coordinates[2] = 0;
    }
    public Player(String name){
        this();
        setName(name);
    }
    public Player(int[] pos,String name,int level,int xp,int agility,int strength,int charisma, int intelligence, int defense, int endurance, int wisdom, int dexterity, double health, double hp, double mana, double remMana){
        super(name,level,xp,agility,strength,charisma,intelligence,defense,endurance,wisdom,dexterity,health,hp, mana,remMana);
        coordinates[0]=pos[0];
        coordinates[1]=pos[1];
        coordinates[2]=pos[2];
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

    public String saveData(){//todo save spells
                String out="name:"+name+"\nposition:"+position[0]+","+position[1]+","+position[2]+"\nlevel:"+level+
                        "\nagility:"+agility+ "\nstrength:"+strength+ "\ncharisma:"+charisma+
                        "\nintelligence:"+intelligence+ "\ndefense:"+defense+ "\nendurance:"+endurance+
                        "\nwisdom:"+wisdom+ "\ndexterity:"+dexterity+ "\nhealth:"+health+ "\nhp:"+hp+
                        "\nmana:"+mana+ "\nremMana:"+remMana+ "\nxp:"+experience+ "\ninventory:";
                for(Item i : inventory){
                    out+=i.toString();
                    if(isEquipped(i)){out+="E";}
                    out+=",";
                }
                out+="\n";
                return out;
    }


}
