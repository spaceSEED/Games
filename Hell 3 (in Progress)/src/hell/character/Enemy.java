package hell.character;
import java.util.Random;

/**
 * Created by Liam on 11/6/2016.
 */
public class Enemy extends NPC {
    String atkName=" attacked";
    String name="";
    int level=1;
    double xp=0;

    public Enemy(int p_level, int floor){
        Random ran = new Random();
        int t=ran.nextInt(10);
        if(t>8){
            level=p_level+t-floor;
        }else{
            level=p_level-t;
            if(level<1)
            	level=1;
        }
        xp=level*7;
        agility+=level/3;
        strength+=level/3;
        endurance+=level/3;
        if(level>10){defense=level/2;}
        else if(level>25){defense=level;}
        else if(level>45){defense=level+level/2;}
        else if(level>60){defense=2*level;}
        name="demon";
    }





    public String getAttackName(){
        return atkName;
    }
    public String getName(){return name;}
    public double getXp(){return xp;}
}
