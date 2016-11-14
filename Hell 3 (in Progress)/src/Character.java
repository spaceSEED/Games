package src;

import java.util.*;
/**
 * Created by Liam on 11/6/2016.
 */
public class Character {
    protected boolean alive=true;
    protected String name;
    int strength,agility,charisma,intelligence,defense,endurance,wisdom, dexterity;
    double health,hp;
    double mana,remMana;
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

    }

    public Character(String name){
        this.name=name;
        this.agility=10;this.strength=10;
        this.charisma=10;this.intelligence=10;
        this.defense=0;this.endurance=10;
        this.wisdom=10;this.dexterity=10;
        health=100;hp=health;

    }
    

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

    public double getHP(){
        return hp;
    }
    public double getHealth(){
        return health;
    }
    public void loseHP(double n){
        hp-=n;
    }
    public void incHealth(double h){
        health+=h;
    }
    public double getMana(){
        return remMana;
    }
    public void loseMana(double n){
        remMana-=n;
    }
    public void incMana(double h){
        mana+=h;
    }

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
            }else if (e.getType().equals("Bow_2Hand")) {
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
}
