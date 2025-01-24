package hell.character;


import java.util.*;

import hell.exceptions.CannotEquipException;
import hell.items.Item;
import hell.items.Spell;
import hell.items.Weapon;
import hell.utilities.GameValues;
/**
 * Created by Liam on 11/6/2016.
 */
public class Player extends Character {
    int facing=GameValues.FORWARD;

    ArrayList<Spell> spellList = new ArrayList<>();
    int[] coordinates=new int[3];

    public Player() {
        coordinates[0] = 0;
        coordinates[1] = 0;
        coordinates[2] = 0;
        Weapon starter_sword=new Weapon("Dull Sword","Sword",5,1,1,6,1);
        inventory.add(starter_sword);
        try {
			equip(starter_sword);
		} catch (CannotEquipException e) {
			e.printStackTrace();
		}
    }
    public Player(String name){
    	this();
    	if(name!=null&&!"".equals(name))
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
    
    public void moveUp() {
    	coordinates[0]=coordinates[0]-1;
    }
    public void moveDown() {
    	coordinates[0]=coordinates[0]+1;
    }

    public void move(int dir){
        int x=coordinates[2];
        int y=coordinates[1];
        if(facing==GameValues.FORWARD){
            if(dir==GameValues.FORWARD){
                y--;
            }else if(dir==GameValues.LEFT){
                x--;
            }else if(dir==GameValues.RIGHT){
                x++;
            }else if(dir==GameValues.BACKWARD){
                y++;
            }
        }else if(facing==GameValues.LEFT){
            if(dir==GameValues.FORWARD){
                x--;
            }else if(dir==GameValues.LEFT){
                y++;
            }else if(dir==GameValues.RIGHT){
                y--;
            }else if(dir==GameValues.BACKWARD){
                x++;
            }
        }else if(facing==GameValues.RIGHT){
            if(dir==GameValues.FORWARD){
                x++;
            }else if(dir==GameValues.LEFT){
                y--;
            }else if(dir==GameValues.RIGHT){
                y++;
            }else if(dir==GameValues.BACKWARD){
                x--;
            }
        }else if(facing==GameValues.BACKWARD){
            if(dir==GameValues.FORWARD){
                y++;
            }else if(dir==GameValues.LEFT){
                x++;
            }else if(dir==GameValues.RIGHT){
                x--;
            }else if(dir==GameValues.BACKWARD){
                y--;
            }
        }
        coordinates[1]=y;
        coordinates[2]=x;
    }
    public void turnBack(){
        if(facing==GameValues.FORWARD){
            facing=GameValues.BACKWARD;
        }else if(facing==GameValues.LEFT){
            facing=GameValues.RIGHT;
        }else if(facing==GameValues.RIGHT){
            facing=GameValues.LEFT;
        }else{
            facing=GameValues.FORWARD;
        }
    }
    public void turnLeft(){
        if(facing==GameValues.FORWARD){
            facing=GameValues.LEFT;
        }else if(facing==GameValues.LEFT){
            facing=GameValues.BACKWARD;
        }else if(facing==GameValues.RIGHT){
            facing=GameValues.FORWARD;
        }else{
            facing=GameValues.RIGHT;
        }
    }
    public void turnRight(){
        if(facing==GameValues.FORWARD){
            facing=GameValues.RIGHT;
        }else if(facing==GameValues.LEFT){
            facing=GameValues.FORWARD;
        }else if(facing==GameValues.RIGHT){
            facing=GameValues.BACKWARD;
        }else{
            facing=GameValues.LEFT;
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
    
    public String invenDisplay(){
        if(inventory.size()<=0){
            return name+"'s Inventory is empty.";
        }else {
        	String out="========"+name+"\'s Inventory=======\nWeight:\t+"+load+"\\"+maxWeight+"\n";//"name\tweight\tworth");
            int i = 0;
            for (Item itm : inventory) {
                out+=i + ") " + itm.toString();
                if(isEquipped(itm)){
                    out+=" E";
                }
                out+="\n";
                i++;
            }
            return out;
        }
    }


}
