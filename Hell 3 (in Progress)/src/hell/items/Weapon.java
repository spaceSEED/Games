package hell.items;

public class Weapon extends Item implements Equipable{
    String type="";
    int attack=0;
    int range=0;
    int speed=0;

    public Weapon(String nm, String typ, int atk, int ran, int spd, int wei, int cost ){
        super(nm,wei,cost);
        type=typ;
        attack=atk;
        range=ran;
        speed=spd;
    }

    public String toString(){
        return name+"\t(atk: "+attack+"; range: "+range+"; spd: "+speed+"; "+weight+"lbs; "+worth+" gold)";
    }

    /*public String getType(){
        return type;
    }*/

    @Override
    public boolean isEquipable() {
        return true;
    }
}
