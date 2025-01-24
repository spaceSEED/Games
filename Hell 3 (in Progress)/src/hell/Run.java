package hell;


import hell.character.Enemy;
import hell.character.Player;
import hell.combat.Combat;
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
                Enemy e=new Enemy(player.getLevel(),player.getCoordinates()[0]);
                if(!Combat.battle(player, e, inputReader)){
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
        if(dun.getRoom(coor[0],coor[1],coor[2]).getStairs()!=0) {
        	if(dun.getRoom(coor[0],coor[1],coor[2]).getStairs()>0)
        		str+="Up\t";
        	else
        		str+="Down\t";
        }
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

    


}
