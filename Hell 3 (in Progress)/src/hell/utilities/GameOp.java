package hell.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import hell.character.Player;
import hell.exceptions.CannotEquipException;
import hell.items.Armor;
import hell.items.Item;
import hell.items.Weapon;

public class GameOp {
	
	public static void help(){
        System.out.println("\fCommand List:\nhelp (h) - displays command list\n" +
                "forward (f) - moves forward if available\nback (b) - moves back if available\n" +
                "left (l) - moves left if available\nright (r) - moves right if available\n" +
                "inven (i) - displays player inventory\nequip (e) - equips named item (by number) from inventory\n"+
                "use (u) - uses named item in room or inventory (ie stairs, chests, potions)\n" +
                "drop (d) - drops named item (by number) in inventory\n" +
                "talk (t) - speaks to an NPC or Merchant\nquit (q) - quits the game\nsave (s) - saves game to named file\n" +
                "load -loads an available save file");
    }

    public static void quit(Scanner sc){
        System.out.print("\fAre you sure you want to quit? (Y/N)\n>>");
        String input = sc.nextLine();
        input = input.toLowerCase();
        if(input.contains("y")){
            System.out.println("Goodbye.");
            System.exit(0);
        }else{
            System.out.print("\f");
        }
    }

    public static void save(String path, Player player){
        try {
            PrintWriter out = new PrintWriter(new File(path));
            out.print(player.saveData());//TODO save dungeon config
        }catch(FileNotFoundException fnfe){
            System.out.println("Save Failed. File Not Found.");
        }
    }
    public static void load(String path, Player player){//TODO
        try {
            Scanner load = new Scanner(new FileInputStream(path));
            int para[]=new int[9];
            double hm[]=new double[4];
            int coor[]=new int[3];
            int xp=0;
            String nm="";
            int i=0;
            while(load.hasNext()){
                String cur=load.nextLine();
                cur=cur.substring(cur.indexOf(":")+1);
                if(i==0){
                    nm=cur;
                }else if(i==1){
                    coor[0]=Integer.parseInt(cur.substring(0,cur.indexOf(",")));
                    coor[1]=Integer.parseInt(cur.substring(cur.indexOf(",")+1,cur.lastIndexOf(",")));
                    coor[2]=Integer.parseInt(cur.substring(cur.lastIndexOf(",")+1));
                }else if(i>1&&i<11){
                    para[i-2]=Integer.parseInt(cur);
                }else if(i>10&&i<15){
                    hm[i-11]=Double.parseDouble(cur);
                }else if(i==15){
                    xp=Integer.parseInt(cur);
                    player=new Player(coor,nm,xp,para[0],para[1],para[2],para[3],para[4],para[5],para[6],para[7],para[8],hm[0],hm[1],hm[2],hm[3]);
                }else{
                    while(0<=cur.indexOf(",")){
                        Item nu=null;
                        String name=cur.substring(0,cur.indexOf("\t"))+" ";
                        cur=cur.substring(cur.indexOf("(")+1);
                        if(cur.startsWith("def:")){
                            int p[]=new int[3];
                            p[0]=Integer.parseInt(cur.substring(cur.indexOf(" ")+1,cur.indexOf(";")));
                            cur=cur.substring(cur.indexOf(" ",cur.indexOf(";"))+1);
                            p[1]=Integer.parseInt(cur.substring(0,cur.indexOf("lbs")));
                            cur=cur.substring(cur.indexOf(" ",cur.indexOf(";"))+1);
                            p[2]=Integer.parseInt(cur.substring(0,cur.indexOf(" ")));

                            nu=new Armor(name.trim(),name.substring(name.indexOf(" ")),p[0],p[1],p[2]);
                        }else if(cur.startsWith("atk")){
                            int p[]=new int[5];
                            p[0]=Integer.parseInt(cur.substring(cur.indexOf(" ")+1,cur.indexOf(";")));
                            cur=cur.substring(cur.indexOf(":",cur.indexOf(";"))+1);
                            p[1]=Integer.parseInt(cur.substring(cur.indexOf(" ")+1,cur.indexOf(";")));
                            cur=cur.substring(cur.indexOf(":",cur.indexOf(";"))+1);
                            p[2]=Integer.parseInt(cur.substring(cur.indexOf(" ")+1,cur.indexOf(";")));
                            cur=cur.substring(cur.indexOf(":",cur.indexOf(";"))+1);
                            p[3]=Integer.parseInt(cur.substring(0,cur.indexOf("lbs")));
                            cur=cur.substring(cur.indexOf(" ",cur.indexOf(";"))+1);
                            p[4]=Integer.parseInt(cur.substring(0,cur.indexOf(" ")));

                            nu=new Weapon(name.trim(),name.substring(name.indexOf(" ")),p[0],p[1],p[2],p[3],p[4]);
                        }else{
                            nu=new Item(name);
                        }
                        player.putInInven(nu);
                        if(cur.substring(0,cur.indexOf(",")).endsWith("E")){
                            try {
                                player.equip(nu);
                            }catch(CannotEquipException cee){
                                System.out.println("Loading Error. Corrupt Save-Data.");
                            }
                        }
                        cur=cur.substring(cur.indexOf(",")+1);
                    }
                }//todo load dungeon once that is added to save

                i++;
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("Load Failed. File Not Found.");
        }
    }

}
