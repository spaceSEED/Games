package hell.character;


import java.util.*;

import hell.exceptions.CannotEquipException;
import hell.items.Armor;
import hell.items.Equipable;
import hell.items.Item;
import hell.items.Weapon;
/**
 * Created by Liam on 11/6/2016.
 */
public class Character {
    protected boolean alive=true;
    protected String name;
    int level=1;
    int maxWeight=0;
    int load=0;
    int strength,agility,charisma,intelligence,defense,endurance,wisdom, dexterity;
    double health,hp;
    double mana,remMana;
    double experience=0;
    double levelup=level*100;
    ArrayList<Item> inventory=new ArrayList<Item>();
    Map<String,Equipable> equipped=new HashMap<String,Equipable>();
    int[] position = new int[3];

    public Character(){
        this.name="John Paul Jones";
        this.agility=10;this.strength=10;
        this.charisma=10;this.intelligence=10;
        this.defense=0;this.endurance=10;
        this.wisdom=10;this.dexterity=10;
        health=100;hp=health;
        maxWeight=(strength/2)*(dexterity+agility);
    }

    public Character(String name){
        this.name=name;
        this.agility=10;this.strength=10;
        this.charisma=10;this.intelligence=10;
        this.defense=0;this.endurance=10;
        this.wisdom=10;this.dexterity=10;
        health=100;hp=health;
        maxWeight=(strength/2)*(dexterity+agility);
    }

    public Character(String name,int level,int xp,int agility,int strength,int charisma, int intelligence, int defense, int endurance, int wisdom, int dexterity, double health, double hp, double mana, double remMana){
        this.name=name;this.level=level;
        this.agility=agility;this.strength=strength;
        this.charisma=charisma;this.intelligence=intelligence;
        this.defense=defense;this.endurance=endurance;
        this.wisdom=wisdom;this.dexterity=dexterity;
        this.health=health;this.hp=hp;
        this.mana=mana;this.remMana=remMana;
        maxWeight=(strength/2)*(dexterity+agility);
        experience=xp;
    }

    public void incXP(double xp){
        System.out.println(name+" gained "+xp+" xp.");
        experience+=xp;
        while(experience>=levelup){
            experience=experience-levelup;
            System.out.println(name+" leveled up to level "+level+".");
            levelUp();
        }
    }

    public void boostattributes(){//TODO level up
        System.out.println("Which attribute would you like to improve?");

    }
    
    public int getLevel(){ return level;}
    public void levelUp(){level++; boostattributes(); levelup=100*level;}
    public int getStrength(){return strength;}
    public int getAttackStrength(){return strength+getEquippedStrength();}
    public int getAgility(){return agility;}
    public int getCharisma(){return charisma;}
    public int getIntelligence(){return intelligence;}
    public int getDefense(){return defense;}
    public int getDefense(String part) {
        if (equipped.containsKey(part)) {
            Armor ar = (Armor) equipped.get(part);
            return defense + ar.getDefense();
        }
        return defense;
    }
    public int getEndurance(){return endurance;}
    public int getWisdom(){return wisdom;}
    public int getDexterity(){return dexterity;}

    public int getMaxWeight(){return maxWeight;}
    public int getLoad() { return load; }

    public double getHP(){
        return hp;
    }
    public double getHealth(){
        return health;
    }
    public void loseHP(double n){
    	if(n>0)
    		hp-=n;
    }
    public void gainHP(double n){ hp+=n; if(hp>health){hp=health;}}
    public void incHealth(double h){
        health+=h;
    }
    public double getMana(){
        return mana;
    }
    public double getRemMana(){
        return remMana;
    }
    public void loseRemMana(double n){
        remMana-=n;
    }
    public void incMana(double h){
        mana+=h;
    }
    /**
     * Returns current remaining Mana
     * @param n
     */
    public void gainRemMana(double n){ remMana+=n; if(remMana>mana){remMana=mana;}}

    public String getName(){
        return name;
    }
    public void setName(String nm){
        name=nm;
    }

    public boolean isLiving(){
        return alive;
    }

    /**
     * Get what item is equipped to the given location
     * @param p - "Head","Feet","Hands","Chest","HandL","HandR"
     * @return
     */
    public Item getEquipped(String p){
        if(equipped.containsKey(p)){
            return (Item)equipped.get(p);

        }
        return null;
    }

    /**
     * Returns if the given item is currently equipped
     * @param a 
     * @return
     */
    public boolean isEquipped(Item a){
        return a.isEquipable()?((Equipable)a).getEquipped():false;
    }


    /**
     * Unequip an item.
     * @param a
     */
    public void unequip(Item a){
        if(isEquipped(a)){
            Equipable e = (Equipable) a;
        	String key=e.getType();
        	e = equipped.remove(key);
        	e.setEquipped(false);
        }
    }

    /**
     * Equip and item (and unequip current equipment in the needed slots)
     * @param a
     * @throws CannotEquipException
     */
    public void equip(Item a) throws CannotEquipException{
        if(a.isEquipable()) {
            Equipable e = (Equipable) a;
            if (e.getType().equals("Helmet")) {
                if (equipped.containsKey("Head")) {
                    equipped.get("Head").setEquipped(false);
                }
                equipped.put("Head", e);
            } else if (e.getType().equals("Boots")) {
                if (equipped.containsKey("Feet")) {
                    equipped.get("Feet").setEquipped(false);
                }
                equipped.put("Feet", e);
            } else if (e.getType().equals("Gloves")) {
                if (equipped.containsKey("Hands")) {
                    equipped.get("Hands").setEquipped(false);
                }
                equipped.put("Hands", e);
            } else if (e.getType().equals("Chassis")) {
                if (equipped.containsKey("Chest")) {
                    equipped.get("Chest").setEquipped(false);
                }
                equipped.put("Chest", e);
            } else if (e.getType().equals("Shield")) {
                if (equipped.containsKey("HandL")) {
                    equipped.get("HandL").setEquipped(false);
                    equipped.put("HandL", e);
                } else if (equipped.containsKey("HandR") && equipped.get("HandR").getType().indexOf("_2Hand") >= 0) {
                    throw new CannotEquipException("Two-handed Item already Equipped");
                } else {
                    equipped.put("HandL", e);
                }
            } else if (e.getType().equals("Sword")) {
                if (equipped.containsKey("HandR")) {
                    equipped.get("HandR").setEquipped(false);
                }
                equipped.put("HandR", e);
            }else if (e.getType().equals("Bow")) {
                if (equipped.containsKey("HandR")) {
                    equipped.get("HandR").setEquipped(false);
                    if (equipped.containsKey("HandL")) {
                        equipped.remove("HandL").setEquipped(false);
                    }
                }
                equipped.put("HandR", e);
            }
            e.setEquipped(true);
        }else{
            throw new CannotEquipException("Not an Equipable Item");
        }
    }
    
    /**
     * Get the attack strength of equipped items
     * @return
     */
    public int getEquippedStrength() {
    	int str=0;
    	Equipable itm=equipped.get("HandR");
    	if(itm!=null&&itm.getType().equals("Sword")){
    		str+=((Weapon)itm).getAttack();
    	}else if(itm!=null&&itm.getType().equals("Bow")) {
    		str+=((Weapon)itm).getAttack();
    	}
		return str;
    }



    /**
     * Return a display of the character's Name, Health and Mana
     */
    public String toString(){
        return "\t"+getName()+"\nHealth: "+getHP()+"\tMana: "+getMana();
    }

    /**
     * Add an item to the inventory (including weight)
     * @param it
     */
    public void putInInven(Item it){
        inventory.add(it);
        load+=it.getWeight();

    }

    /**
     * Remove an item from the inventory (including weight)
     * @param i
     * @return
     */
    public Item dropItem(int i){
        Item toDrop=inventory.remove(i);
        if(isEquipped(toDrop)){
            unequip(toDrop);
        }
        load-=toDrop.getWeight();
        return toDrop;
    }

    /**
     * Check if current inventory load exceeds the max carry weight
     * @return
     */
    public boolean checkWeight(){
        if(load<=maxWeight){
            return true;
        }
        return false;
    }
    /**
     * Get the inventory list
     * @return
     */
    public ArrayList<Item> getInven(){
        return inventory;
    }
}
