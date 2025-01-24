package hell.items;
import java.util.Random;

import hell.character.Player;

import java.util.*;
/**
 * Created by Liam on 11/6/2016.
 */
public class Item {
    String name="";
    int weight=0;
    int worth=0;
    static String[] dictionary={"Feldor","Strength","Brutality","Endurance","the Saints","Michael"};

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
    public int getWeight(){return weight;}

    public String toString(){
        return name+"\t("+weight+"lbs; "+worth+" gold)";
    }

    public static Item generate(Player player){
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
            t=ran.nextInt(100);
            if(t<25){
                type="Helmet";
            }else if(t<=50){
                type="Chassis";
            }else if(t<75){
                type="Gloves";
            }else{
                type="Boots";
            }
            String nm=type;//+" of "+dictionary[ran.nextInt(dictionary.length)];
            int def=ran.nextInt(player.getLevel()*4)+1;
            int wei=ran.nextInt(100)+1;
            int c=def+ran.nextInt(100)/wei;
            if(def>70){
                nm=type+" of "+dictionary[ran.nextInt(dictionary.length)];
            }
            item=new Armor(nm,type,def,wei,c);

        }else if(type.equals("weapon")){
            t=ran.nextInt(100);
            if(t<25){
                type="Sword";
            }else if(t<=50){
                type="Bow";
            }else if(t<75){
                type="Spear";
            }else{
                type="Sword";
            }
            String nm=type;//+" of "+dictionary[ran.nextInt(dictionary.length)];
            int atk=ran.nextInt(player.getLevel()*5)+2;
            int wei=ran.nextInt(35)+1;
            int spd=wei-ran.nextInt(wei-1);
            int r=ran.nextInt(100)+1;//Do I even use this stat?
            int c=atk+ran.nextInt(100)/wei;
            if(atk>70){
                nm=type+" of "+dictionary[ran.nextInt(dictionary.length)];
            }
            item=new Weapon(nm,type,atk,r,spd,wei,c);

        }else if(type.equals("")){

        }else{
            item=new Item("dirt");
        }
        return item;
    }
}
