package src;

/**
 * Created by Liam on 11/6/2016.
 */
public class Weapon extends Item implements Equipable{
    String type="";
    int attack=0;
    int range=0;
    int speed=0;

    public Weapon(String nm, String typ, int atk, int ran, int spd ){
        super(nm);
        type=typ;
        attack=atk;
        range=ran;
        speed=spd;
    }

    /*public String getType(){
        return type;
    }*/

    @Override
    public boolean isEquipable() {
        return true;
    }
}
