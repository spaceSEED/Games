package hell;


import hell.character.Enemy;
import hell.character.Player;
import hell.dungeon.Dungeon;
import hell.exceptions.CannotEquipException;
import hell.items.Item;
import hell.items.Spell;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

import hell.utilities.GameOp;
import hell.utilities.InputReader;
import hell.utilities.Utilities;

import java.io.*;
/**
 * Created by Liam on 11/6/2016.
 */
public class Run {
    static Player player;
    static Dungeon dun=new Dungeon();
    static InputReader inputReader=new InputReader();
    
    public static void  main(String[] args){
        System.out.println("Hell 3\n-Press Any Key to Continue-");
        inputReader.getScanner().nextLine();
        System.out.print("Would you like to load a game? (Y/N)\n>>");
        String input=inputReader.getScanner().nextLine();
        if(input.contains("y")) {
            System.out.print("Please provide the filepath you would like to load:\n>>");
            input=inputReader.getScanner().nextLine();
            GameOp.load(input, player);
        }else {
            System.out.print("What is your name?\n>>");
            String name = inputReader.getScanner().nextLine();
            player = new Player(name);
        }

        Random ran = new Random();
        int stepsTillBattle=ran.nextInt(30)+1;//TODO make a function of current floor #
        while(true){
            display();
            if(stepsTillBattle<=0){
                stepsTillBattle=ran.nextInt(10)+1;
                Enemy e=new Enemy(player.getLevel());
                if(!battle(player,e)){
                    System.out.println("=====GAME OVER=====\n"+player.getName()+" died in battle.");
                    break;
                }else{//drop item/gainxp
                    player.incXP(e.getXp());
                    Item drop=Item.generate(player);
                    System.out.println(e.getName()+" dropped "+drop.toString()+".\nDo you want to pick it up? (Y/N)");
                    input = inputReader.getScanner().nextLine();
                    input = input.toLowerCase();
                    if(input.contains("y")){//yes
                        player.putInInven(drop);
                        while(!player.checkWeight()){
                            System.out.println("You are carrying too much. You will have to drop items.");
                            player.invenDisplay();
                            input = inputReader.getScanner().nextLine();
                            input = input.toLowerCase().trim();
                            if (input.contains("drop")||input.startsWith("d")) {
                                input=input.substring(input.indexOf(" ")+1);
                                int g=0;
                                if(Utilities.isNum(input)){
                                    g=Integer.parseInt(input);
                                    Item dropped=player.dropItem(g);
                                    if(dropped==null){
                                        System.out.println("There was nothing to drop.");
                                    }else {
                                        System.out.println(player.getName() + " dropped the " + dropped.getName() + ".");
                                    }
                                }else{
                                    System.out.println("Please input an item number.");
                                }

                            }else{
                                System.out.println("Nothing can be done till you are unencumbered.");
                            }
                        }
                    }else{//no

                    }
                }
            }else{





            }
            stepsTillBattle--;
        }

    }

    public static void display(){
        String str="";
        int[] coor=player.getCoordinates();
        int dir=player.getFacing();
        dun.getRoom(coor[0],coor[1],coor[2]).setVisited();
        if(dun.getRoom(coor[0],coor[1],coor[2]).isOpening(dir)){
            str+="Forward\t";
        }
        dir++;
        if(dir>Player.LEFT){
            dir=0;
        }
        if(dun.getRoom(coor[0],coor[1],coor[2]).isOpening(dir)){
            str+="Right\t";
        }dir++;
        if(dir>Player.LEFT){
            dir=0;
        }
        if(dun.getRoom(coor[0],coor[1],coor[2]).isOpening(dir)){
            str+="Back\t";
        }dir++;
        if(dir>Player.LEFT){
            dir=0;
        }
        if(dun.getRoom(coor[0],coor[1],coor[2]).isOpening(dir)){
            str+="Left";
        }
        System.out.print("\f");
        System.out.print(player.toString() + "\n" +dun.getRoom(coor[0],coor[1],coor[2]).getDescription(player.getFacing())+"\n");
        inputReader.readInput(str, player, dun);

    }

    


    static boolean eguard=false;
    static boolean pguard=false;
    public static boolean battle(Player p, Enemy e){
        System.out.println(p.getName()+" has encountered a " +e.getName());
        try{Thread.currentThread().sleep(3000);}catch(InterruptedException ie){}

        while(e.getHP()>0&&p.getHP()>0){
            System.out.print("\f");
            if(p.getAgility()>e.getAgility()){
                playerTurn(p,e);
                if(e.getHP()<=0){
                    return true;
                }else if(p.getHP()<=0){
                    return false;
                }
                enemyTurn(p,e);
            }else{
                enemyTurn(p,e);
                if(e.getHP()<=0){
                    return true;
                }else if(p.getHP()<=0){
                    return false;
                }
                playerTurn(p,e);
            }

        }
        if(e.getHP()<=0){
            return true;
        }
        return false;
    }

    public static void playerTurn(Player p, Enemy e){
        boolean again =false;
        do{
        System.out.print(e.toString()+"\n==========vs==========\n"+p.toString()+"\nAttack\tCast\tGuard\tFlee\n>> ");
        String in=inputReader.getScanner().nextLine(); in=in.toLowerCase();

        if(in.equals("a")||in.equals("attack")||in.equals("atk")||in.indexOf("at")>=0){
            int dam=0;
            if(eguard==false) {
                dam=p.getStrength()-e.getDefense()/10;
            }else{

            }
            e.loseHP(dam);
            System.out.println(e.getName()+" took "+dam+" points of damage.");
            again=false;
        }else if(in.equals("c")||in.equals("cast")||in.equals("cst")||in.indexOf("ca")>=0){
            int i=0;
            System.out.println(e.toString()+"\n==========vs==========\n"+p.toString()+"\n\tSpells\tCost\n-1) Back\t--");
            for (Spell spell :p.getSpellList() ) {

                System.out.println(i+") "+spell.getName()+"\t"+spell.getCost());
                i++;
            }
            System.out.print(">> ");
            in=inputReader.getScanner().nextLine(); in=in.toLowerCase();
            if(in.equals("back")||in.equals("b")||in.equals("bk")||in.indexOf("-1")>=0){
                again=true;
            }else{
                int g=0;
                if(Utilities.isNum(in)){
                    g=Integer.parseInt(in);
                }

                int dam=p.getSpellList().get(g).cast();
                p.loseRemMana(p.getSpellList().get(g).getCost());
                if(eguard==false) {
                   dam-=e.getDefense()/10;
                }else{

                }
                e.loseHP(dam);
                System.out.println(p.getName()+" cast "+p.getSpellList().get(0).getName()+".\n"+e.getName()+" took "+dam+" points of damage.");
                again=false;
            }
        }else if(in.equals("g")||in.equals("guard")||in.equals("grd")||in.indexOf("gu")>=0){

            System.out.println(p.getName()+" guarded himself.");
            pguard=true;
            again=false;
        }else if(in.equals("f")||in.equals("flee")||in.equals("fle")||in.indexOf("fl")>=0){
            System.out.println("Got away successfully!");
           again=false;
        }else{
            System.out.println("Please inter a valid command.");
            again=true;
        }
        }while(again);


    }

    public static void enemyTurn(Player p, Enemy e){
        double guardChance=0.0;
        if(e.getHP()<=e.getHealth()/2){
            guardChance+=.25;
        }
        if(e.getHP()<=e.getHealth()/3){
            guardChance+=.25;
        }
        if(Math.random()+.000000001<=guardChance){
            System.out.println(e.getName()+" guarded itself.");
            eguard=true;
        }else{
            int dam=0;
            if(pguard==false) {
                dam=e.getStrength()-p.getDefense()/10;
            }else{

            }
            p.loseHP(dam);
            System.out.println(e.getName()+e.getAttackName()+".\n"+p.getName()+" took "+dam+" points of damage.");
        }
    }
}
