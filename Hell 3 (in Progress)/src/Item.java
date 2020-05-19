import java.util.Random;

/**
 * Created by Liam on 11/6/2016.
 */
public class Item {
    String name="";
    int weight=0;
    int worth=0;

    public Item(String name){
        this.name= name;
    }
    public Item(String name, int weight, int worth){
        this(name);
        this.weight=weight;
        this.worth=worth;
    }


    public boolean isEquipable(){
        return false;
    }
    public String getName(){ return name; }

    public String toString(){
        return name+"\t("+weight+"lbs; "+worth+" gold)";
    }

    public static Item generate(){
        Random ran = new Random();
        String type="";
        int t=ran.nextInt(100);
        if(t<30){
            type="armor";
        }else if(t<50){

        }else if(t<100){
            type="weapon";
        }

        Item item=null;//=new Item();
        if(type.equals("armor")){

        }else if(type.equals("weapon")){
            String nm="";
            int def=0;//Run.player.getHealth();
            int wei=0;
            int c=def+ran.nextInt(100)/wei;
            item=new Armor(nm,type,def,wei,c);

        }else if(type.equals("")){

        }else{
            item=new Item("dirt");
        }
        return item;
    }
}
