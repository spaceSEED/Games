

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;
/**
 * Created by Liam on 11/6/2016.
 */
public class Run {
    static Player player;
    static Scanner sc=new Scanner(System.in);
    static  Dungeon dun=new Dungeon();
    public static void  main(String[] args){
        System.out.println("Hell 3\n-Press Any Key to Continue-");
        sc.nextLine();
        System.out.print("Would you like to load a game? (Y/N)\n>>");
        String input=sc.nextLine();
        if(input.contains("y")) {
            System.out.print("Please provide the filepath you would like to load:\n>>");
            input=sc.nextLine();
            load(input);
        }else {
            System.out.print("What is your name?\n>>");
            String name = sc.nextLine();
            player = new Player(name);
        }

        Random ran = new Random();
        int stepsTillBattle=ran.nextInt(10)+1;
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
                    Item drop=Item.generate();
                    System.out.println(e.getName()+" dropped "+drop.toString()+".\nDo you want to pick it up? (Y/N)");
                    input = sc.nextLine();
                    input = input.toLowerCase();
                    if(input.contains("y")){//yes
                        player.putInInven(drop);
                        while(!player.checkWeight()){
                            System.out.println("You are carrying too much. You will have to drop items.");
                            inven();
                            input = sc.nextLine();
                            input = input.toLowerCase().trim();
                            if (input.contains("drop")||input.startsWith("d")) {
                                input=input.substring(input.indexOf(" ")+1);
                                int g=0;
                                if(isNum(input)){
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
        do {
            System.out.print(player.toString() + "\n" +dun.getRoom(coor[0],coor[1],coor[2]).getDescription()+"\n"+ str + "\n>> ");
            String input = sc.nextLine();
            input = input.toLowerCase().trim();
            if (input.equals("forward") || input.equals("frwd") || input.contains("for") || input.equals("f")) {
                if(str.contains("Forward")){
                    player.move(Player.FORWARD);
                    break;
                }else{
                    System.out.println("\fPlease input a valid Command (type help for options).");
                }

            } else if (input.equals("right") || input.equals("rt") || input.contains("ri") || input.equals("r")) {
                if(str.contains("Right")){
                    player.move(Player.RIGHT);
                    player.turnRight();
                    break;
                }else{
                    System.out.println("\fPlease input a valid Command (type help for options).");
                }

            }else if (input.contains("help") || input.equals("hlp") || input.contains("he") || input.equals("h")) {
                help();

            } else if (input.contains("inventory") || input.equals("inv") || input.contains("inven") || input.equals("i")) {
                inven();

            } else if (input.contains("quit") || input.equals("qt") || input.contains("qu") || input.equals("q")) {
                quit();

            } else if (input.contains("talk") || input.equals("tk") || input.contains("tlk") || input.equals("t")) {
                //todo talking

            }else if (input.contains("use")||input.startsWith("u")) {
                //todo using items

            }else if (input.contains("equip")||input.startsWith("e")) {
                input=input.substring(input.indexOf(" ")+1);
                int g=0;
                if(isNum(input)){
                    g=Integer.parseInt(input);
                    try{
                        player.equip(player.getInven().get(g));
                        System.out.println(player.getName()+" equipped the "+player.getInven().get(g).getName()+".");
                    }catch(CannotEquipException cee){
                        System.out.println(cee.getMessage());
                    }
                }else{
                    System.out.println("Please input an item number.");
                }

            }else if (input.contains("drop")||input.startsWith("d")) {
                input=input.substring(input.indexOf(" ")+1);
                int g=0;
                if(isNum(input)){
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

            }else if (input.equals("left") || input.equals("lft") || input.contains("le") || input.equals("l")) {
                if(str.contains("Left")){
                    player.move(Player.LEFT);
                    player.turnLeft();
                    break;
                }else{
                    System.out.println("\fPlease input a valid Command (type help for options).");
                }

            } else if (input.equals("back") || input.equals("bk") || input.contains("ba") || input.equals("b")) {
                if(str.contains("Back")){
                    player.move(Player.BACKWARD);
                    player.turnBack();
                    break;
                }else{
                    System.out.println("\fPlease input a valid Command (type help for options).");
                }

            }else{
                System.out.println("\fPlease input a valid Command (type help for options).");
            }
        }while(true);

    }

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
    public static void inven(){
        if(player.getInven().size()<=0){
            System.out.println(player.getName()+"'s Inventory is empty.");
        }else {
            System.out.println("========"+player.getName()+"\'s Inventory=======\nWeight:\t+"+player.getLoad()+"\\"+player.getMaxWeight());//"name\tweight\tworth");
            int i = 0;
            for (Item itm : player.getInven()) {
                System.out.print(i + ") " + itm.toString());
                if(player.isEquipped(itm)){
                    System.out.print(" E");
                }
                System.out.print("\n");
                i++;
            }
        }
    }

    public static void quit(){
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

    public static void save(String path){
        try {
            PrintWriter out = new PrintWriter(new File(path));
            out.print(player.saveData());//TODO save dungeon config
        }catch(FileNotFoundException fnfe){
            System.out.println("Save Failed. File Not Found.");
        }
    }
    public static void load(String path){//TODO
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
        String in=sc.nextLine(); in=in.toLowerCase();

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
            in=sc.nextLine(); in=in.toLowerCase();
            if(in.equals("back")||in.equals("b")||in.equals("bk")||in.indexOf("-1")>=0){
                again=true;
            }else{
                int g=0;
                if(isNum(in)){
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

    public static boolean isNum(String s){
        String n="0123456789";
        boolean isn=true;
        for(int g=0;g<s.length();g++){
            if(n.contains(s.substring(g,g+1))){

            }else{
                isn= false;
            }
        }
        return isn;
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
