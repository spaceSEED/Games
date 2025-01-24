package hell.items;
import java.util.Random;

/**
 * Created by Liam on 11/8/2016.
 */
public class Armor extends Item implements Equipable{
    String type="";
    int defense=0;

    public Armor(String nm, String typ, int def, int wei, int cost){
        super(nm, wei, cost);
        type=typ;
        defense=def;
    }

    public int getDefense(){
        return defense;
    }

    public String toString(){
        return name+"\t(def: "+defense+"; "+weight+"lbs; "+worth+" gold)";
    }

    /*public String getType(){
        return type;
    }*/

    @Override
    public boolean isEquipable() {
        return true;
    }
}
