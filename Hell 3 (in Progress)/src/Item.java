/**
 * Created by Liam on 11/6/2016.
 */
public class Item {
    String name="";
    int weight=0;

    public Item(String name){
        this.name= name;
    }
    public Item(String name, int weight){
        this(name);
        this.weight=weight;
    }


    public boolean isEquipable(){
        return false;
    }
}
