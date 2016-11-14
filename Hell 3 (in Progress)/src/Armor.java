package src;

/**
 * Created by Liam on 11/8/2016.
 */
public class Armor extends Item implements Equipable{
    String type="";
    int defense=0;

    public Armor(String nm, String typ, int def, int wei){
        super(nm, wei);
        type=typ;
        defense=def;
    }

    public int getDefense(){
        return defense;
    }

    /*public String getType(){
        return type;
    }*/

    @Override
    public boolean isEquipable() {
        return true;
    }
}
