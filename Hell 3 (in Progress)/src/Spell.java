
/**
 * Created by Liam on 11/9/2016.
 */
public class Spell {
    int cost=0;
    int dmg=0;
    String name="";

    public Spell(String nm, int cst, int dmg){
        name=nm;
        cost=cst;
        this.dmg=dmg;
    }

    public String getName(){
        return name;
    }
    public int getCost(){
        return cost;
    }

    /**
     *
     * @return the amount of damage, while doing other things
     */
    public int cast(){
        alternateAffect();
        return dmg;
    }

    public void alternateAffect(){

    }
}
