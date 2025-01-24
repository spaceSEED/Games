package hell.character;


import java.util.*;

import hell.exceptions.CannotEquipException;
import hell.items.Armor;
import hell.items.Equipable;
import hell.items.Item;
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

    public Item getEquipped(String p){
        if(equipped.containsKey(p)){
            return (Item)equipped.get(p);

        }
        return null;
    }

    public boolean isEquipped(Item a){
        return equipped.containsValue((Equipable)a);
    }


    public void unequip(Item a){
        if(equipped.containsValue((Equipable)a)){
            Set s= equipped.keySet();
            Iterator it = s.iterator();
            String key;
            while(it.hasNext()){
                key=(String)it.next();
                if(equipped.get(key).equals((Equipable)a)){
                    inventory.add((Item) equipped.remove(key));
                    break;
                }
            }
        }
    }

    public void equip(Item a) throws CannotEquipException{
        if(a.isEquipable()) {
            Equipable e = (Equipable) a;
            if (e.getType().equals("Helmet")) {
                if (equipped.containsKey("Head")) {
                    inventory.add((Item) equipped.get("Head"));
                }
                equipped.put("Head", e);
            } else if (e.getType().equals("Boots")) {
                if (equipped.containsKey("Feet")) {
                    inventory.add((Item) equipped.get("Feet"));
                }
                equipped.put("Feet", e);
            } else if (e.getType().equals("Gloves")) {
                if (equipped.containsKey("Hands")) {
                    inventory.add((Item) equipped.get("Hands"));
                }
                equipped.put("Hands", e);
            } else if (e.getType().equals("Chassis")) {
                if (equipped.containsKey("Chest")) {
                    inventory.add((Item) equipped.get("Chest"));
                }
                equipped.put("Chest", e);
            } else if (e.getType().equals("Shield")) {
                if (equipped.containsKey("HandL")) {
                    inventory.add((Item) equipped.get("HandL"));
                    equipped.put("HandL", e);
                } else if (equipped.containsKey("HandR") && equipped.get("HandR").getType().indexOf("_2Hand") >= 0) {
                    throw new CannotEquipException("Two-handed Item already Equipped");
                } else {
                    equipped.put("HandL", e);
                }
            } else if (e.getType().equals("Sword")) {
                if (equipped.containsKey("HandR")) {
                    inventory.add((Item) equipped.get("HandR"));
                }
                equipped.put("HandR", e);
            }else if (e.getType().equals("Bow")) {
                if (equipped.containsKey("HandR")) {
                    inventory.add((Item) equipped.get("HandR"));
                    if (equipped.containsKey("HandL")) {
                        inventory.add((Item) equipped.remove("HandL"));
                    }
                }
                equipped.put("HandR", e);
            }
        }else{
            throw new CannotEquipException("Not an Equipable Item");
        }
    }



    public String toString(){
        return "\t"+getName()+"\nHealth: "+getHP()+"\tMana: "+getMana();
    }

    public void putInInven(Item it){
        inventory.add(it);
        load+=it.getWeight();

    }

    public Item dropItem(int i){
        Item toDrop=inventory.remove(i);
        if(isEquipped(toDrop)){
            unequip(toDrop);
        }
        return toDrop;
    }

    public boolean checkWeight(){
        if(load<=maxWeight){
            return true;
        }
        return false;
    }
    public ArrayList<Item> getInven(){
        return inventory;
    }
}
