package hell.combat;

import hell.character.Enemy;
import hell.character.Player;
import hell.items.Spell;
import hell.utilities.InputReader;
import hell.utilities.Utilities;

public class Combat {
	

    static boolean eguard=false;
    static boolean pguard=false;
    
    public static boolean battle(Player p, Enemy e, InputReader inputReader){
        System.out.println(p.getName()+" has encountered a Lv."+e.getLevel()+" "+e.getName());
        
        try{Thread.currentThread().sleep(1000);}catch(InterruptedException ie){}

        while(e.getHP()>0&&p.getHP()>0){
            System.out.print("\f");
            if(p.getAgility()>=e.getAgility()){
                playerTurn(p, e, inputReader);
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
                playerTurn(p, e, inputReader);
            }

        }
        if(e.getHP()<=0){
            return true;
        }
        return false;
    }

    public static void playerTurn(Player p, Enemy e, InputReader inputReader){
        boolean again = false;
        do{
        System.out.print(e.toString()+"\n==========vs==========\n"+p.toString()+"\nAttack\tCast\tGuard\tFlee\n>> ");
        String in=inputReader.getScanner().nextLine(); in=in.toLowerCase();

        if(in.equals("a")||in.equals("attack")||in.equals("atk")||in.indexOf("at")>=0){
            int dam=0;
            if(eguard==false) {
                dam=p.getAttackStrength()-e.getDefense()/10;
            }else{
                dam=p.getAttackStrength()-(e.getDefense()*2)/10;
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
        if(e.getHP()<=e.getHealth()/3){
            guardChance+=.45;
        }else if(e.getHP()<=e.getHealth()/2){
            guardChance+=.25;
        }
        if(Math.random()+.001<=guardChance){
            System.out.println(e.getName()+" guarded itself.");
            eguard=true;
        }else{
            int dam=0;
            if(pguard==false) {
                dam=e.getStrength()-p.getDefense()/10;
            }else{
                dam=e.getStrength()-(p.getDefense()*2)/10;
            }
            p.loseHP(dam);
            System.out.println(e.getName()+e.getAttackName()+".\n"+p.getName()+" took "+dam+" points of damage.");
        }
    }

}
