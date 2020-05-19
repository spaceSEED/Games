

/**
 * Created by Liam on 11/6/2016.
 */
public class Enemy extends NPC {
    String atkName=" attacked";
    String name="";
    int level=1;
    double xp=0;

    public Enemy(){
        setName("demon");
    }





    public String getAttackName(){
        return atkName;
    }
    public String getName(){return name;}
    public double getXp(){return xp;}
}
