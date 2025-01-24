package hell.utilities;
import java.util.Scanner;

import hell.character.Player;
import hell.dungeon.Dungeon;
import hell.exceptions.CannotEquipException;
import hell.items.Item;

public class InputReader {
	
	static Scanner sc;
	
	public InputReader() {
		sc=new Scanner(System.in);
	}
	
	public Scanner getScanner() {
		return sc;
	}
	
	
	public void readInput(String prompts, Player player, Dungeon dun) {
		do {
		System.out.print(prompts + "\n>> ");
		String input = sc.nextLine();
        input = input.toLowerCase().trim();
        if (input.equals("forward") || input.equals("frwd") || input.contains("for") || input.equals("f")) {
            if(prompts.contains("Forward")){
                player.move(GameValues.FORWARD);
                break;
            }else{
                System.out.println("\fPlease input a valid Command (type help for options).");
            }

        } else if (input.equals("right") || input.equals("rt") || input.contains("ri") || input.equals("r")) {
            if(prompts.contains("Right")){
                player.move(GameValues.RIGHT);
                player.turnRight();
                break;
            }else{
                System.out.println("\fPlease input a valid Command (type help for options).");
            }

        } else if (input.equals("left") || input.equals("lft") || input.contains("le") || input.equals("l")) {
            if(prompts.contains("Left")){
                player.move(GameValues.LEFT);
                player.turnLeft();
                break;
            }else{
                System.out.println("\fPlease input a valid Command (type help for options).");
            }

        } else if (input.equals("back") || input.equals("bk") || input.contains("ba") || input.equals("b")) {
            if(prompts.contains("Back")){
                player.move(GameValues.BACKWARD);
                player.turnBack();
                break;
            }else{
                System.out.println("\fPlease input a valid Command (type help for options).");
            }

        } else if (input.equals("up")) {
            if(prompts.contains("Up")){
                player.moveUp();
                break;
            }else{
                System.out.println("\fPlease input a valid Command (type help for options).");
            }

        } else if (input.equals("down")) {
            if(prompts.contains("Down")){
                player.moveDown();
                break;
            }else{
                System.out.println("\fPlease input a valid Command (type help for options).");
            }

        } else if (input.contains("help") || input.equals("hlp") || input.contains("he") || input.equals("h")) {
        	GameOp.help();

        } else if (input.contains("inventory") || input.equals("inv") || input.contains("inven") || input.equals("i")) {
        	System.out.print(player.invenDisplay());

        } else if (input.contains("quit") || input.equals("qt") || input.contains("qu") || input.equals("q")) {
            GameOp.quit(sc);

        } else if (input.contains("talk") || input.equals("tk") || input.contains("tlk") || input.equals("t")) {
            //todo talking

        } else if (input.contains("use")||input.startsWith("u")) {
            //todo using items

        } else if (input.contains("equip")||input.startsWith("e")) {
            input=input.substring(input.indexOf(" ")+1);
            int g=0;
            if(Utilities.isNum(input)){
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

        }else if(input.equals("top down") || input.equals("td") || input.equals("top") || input.equals("top view")) {
        	int[] coor=player.getCoordinates();
        	System.out.println("\f"+dun.getRoom(coor[0],coor[1],coor[2]).getDescriptionTopDown(player.getFacing()));
        }else if(input.equals("map") || input.equals("mp") || input.equals("m")) {
        	int[] coor=player.getCoordinates();
        	System.out.println(dun.getMap(coor[0],coor[1],coor[2],player.getFacing()));
        }else{
        
            System.out.println("\fPlease input a valid Command (type help for options).");
        }
		}while(true);
	}
	
	

}
