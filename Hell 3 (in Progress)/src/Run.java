

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
        System.out.print("What is your name?\n>>");
        String name =sc.nextLine();
        player=new Player(name);
        Random ran = new Random();
        int stepsTillBattle=ran.nextInt(10)+1;
        while(true){
            display();
            if(stepsTillBattle<=0){
                stepsTillBattle=ran.nextInt(10)+1;
                if(!battle(player,new Enemy())){
                    System.out.println("=====GAME OVER=====\n"+player.getName()+" died in battle.");
                    break;
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
            input = input.toLowerCase();
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

            }else if (input.equals("help") || input.equals("hlp") || input.contains("he") || input.equals("h")) {
                help();

            } else if (input.equals("inventory") || input.equals("inv") || input.contains("inven") || input.equals("i")) {
                inven();

            } else if (input.equals("quit") || input.equals("qt") || input.contains("qu") || input.equals("q")) {
                quit();

            } else if (input.equals("left") || input.equals("lft") || input.contains("le") || input.equals("l")) {
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
                "inven (i) - displays player inventory\nequip (e) - equips named item from inventory\n"+
                "use (u) - uses named item in room or inventory (ie stairs, chests, potions)\n" +
                "talk (t) - speaks to an NPC of Merchant\nquit (q) - quits the game\nsave (s) - saves game to named file\n" +
                "load -loads an available save file");
    }
    public static void inven(){
        if(player.getInven().size()<=0){
            System.out.println(player.getName()+"'s Inventory is empty.");
        }else {
            System.out.println("name\tweight\tworth");
            int i = 0;
            for (Item itm : player.getInven()) {
                System.out.println(i + ") " + itm.toString());
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

    public static void save(){
        String filePath="";
        try {
            PrintWriter out = new PrintWriter(new File(filePath));


        }catch(FileNotFoundException fnfe){

        }
    }
    public static void load(){

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
                String n="0123456789";
                    boolean isNum=true;
                    for(int g=0;i<in.length();g++){
                        if(n.contains(in.substring(g,g+1))){

                        }else{
                            isNum= false;
                        }
                    }
                    int g=0;
                    if(isNum){
                        g=Integer.parseInt(in);
                    }



                int dam=p.getSpellList().get(g).cast();
                p.loseMana(p.getSpellList().get(g).getCost());
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
