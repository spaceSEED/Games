import java.util.Random;
import java.util.Scanner;



public class Hell {
	
	public static String name;
	
	public static int weapon;
	public static int shoes;
	public static int clothes;
	public static int armor;
	public static int gold;
	
	public static int hp;
	public static int stre;
	public static int chari ;
	public static int agi;
	public static int intel;

	public static String luck;
	
	public static int newGold;
	public static int newArmor;

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random generator = new Random();
		boolean inDungeon = true;
		
		System.out.println("\fWelcome to HELL");
		System.out.println("press 'enter' to begin");
		String startToPlaytheGame = input.nextLine();
		
		/*Ignore this rules portion it was a last minute decision that I failed to implement.
		Feel free to read them though.
		if(startToPlaytheGame == "rules"){
			System.out.println("	<Stats>");
			System.out.println("Health - if drops to 0 in battle the game ends");
			System.out.println("Armor - protects health");
			System.out.println("Strength - determines attack power");
			System.out.println("Agility - determines if player attacks first and dodge chance");
			System.out.println("Charisma - gets discounts with the merchant");
			System.out.println("Intelligence - improves chance of escape from battle.");
			System.out.println("Gold - currency used with the merchant");
			System.out.println("Luck - does nothing");
			System.out.println("	<Items>");
			System.out.println("--items whose effects are discarded when a new type is equipped--");
			System.out.println("Clothes - items that improve Charisma");
			System.out.println("Weapons - items that improve Strength");
			System.out.println("Shoes - items that improve Agility");
			System.out.println("--permanent effect items--");
			System.out.println("Books - items that improve Intelligence");
			System.out.println("Armor - improve Armor up to 200 (can be depleted in battle)");
			System.out.println("Food - improve Health up to 100 (can be depleted in battle)");
			System.out.println("	<Winning>");
			System.out.println("You win if you encounter and defeat the final boss, The Devil");
			System.out.println(" ");
		}
		*/
		
		System.out.println("What is your name?");
		name = input.nextLine();
		System.out.println("Now, " + name + ", which is your best attribute?");
		System.out.println("<1> Strength (more powerful at attacks)");
		System.out.println("<2> Charisma (gets better deals from merchants)");
		System.out.println("<3> Agility (better at dodging attacks)");
		System.out.println("<4> Intelligence (better at running from battle)");
		System.out.println("<5> Luck (does nothing)");
		int charClass;
		charClass = input.nextInt();
		
		switch(charClass){
		case 1:
		System.out.println("In life your strength was very widely recognized.");
		System.out.println("You were a hitman for the mafia and died a death suitable for such an occupation.");
		
	
			
			gold = 500;
			
			hp = 100;
			stre = 10;
			chari = 5;
			agi = 5;
			intel = 5;
			luck = "Average";
		
		
		System.out.println("Health <" +hp + ">	Agility <" + (agi + shoes) + ">");
		System.out.println("Strength <" + (stre + weapon) + ">	Intelligence <" + intel + ">");
		System.out.println("Charisma <" + (chari + clothes) + ">	Luck = " + luck );
		System.out.println("Armor <" + armor + ">	Gold <" + gold + ">");
		
		break;
		
		case 2:
		System.out.println("In life you were a very likable person, due to your fantastic people skills and good-looks.");
		System.out.println("You manipulated people to your liking and discarded them just as easily.");
		
			gold = 500;
			
			hp = 100;
			stre = 5;
			chari = 10;
			agi = 5;
			intel = 5;
			luck = "Average";
	
			System.out.println("Health <" +hp + ">	Agility <" + (agi + shoes) + ">");
			System.out.println("Strength <" + (stre + weapon) + ">	Intelligence <" + intel + ">");
			System.out.println("Charisma <" + (chari + clothes) + ">	Luck = " + luck );
			System.out.println("Armor <" + armor + ">	Gold <" + gold + ">");
			
		break;
		
		case 3:
		System.out.println("In life you were a gymnist.");
		System.out.println("You were proud and incapable of handling defeat or showing compassion.");
		
			gold = 500;
		
			hp = 100;
			stre = 5;
			chari =5;
			agi = 10;
			intel = 5;
			luck = "Average";
	
			System.out.println("Health <" +hp + ">	Agility <" + (agi + shoes) + ">");
			System.out.println("Strength <" + (stre + weapon) + ">	Intelligence <" + intel + ">");
			System.out.println("Charisma <" + (chari + clothes) + ">	Luck = " + luck );
			System.out.println("Armor <" + armor + ">	Gold <" + gold + ">");
			
		
		break;
		
		case 4:
		System.out.println("In life you were a brilliant scientist,");
		System.out.println("but your tactics were highly unethical and you pursued human experimentation.");
		
			gold = 500;
			hp = 100;
			stre = 5;
			chari = 5;
			agi = 5;
			intel = 10;
			luck = "Average";
	
			System.out.println("Health <" +hp + ">	Agility <" + (agi + shoes) + ">");
			System.out.println("Strength <" + (stre + weapon) + ">	Intelligence <" + intel + ">");
			System.out.println("Charisma <" + (chari + clothes) + ">	Luck = " + luck );
			System.out.println("Armor <" + armor + ">	Gold <" + gold + ">");
			
		
		break;
		
		case 5:
		System.out.println("In life you were lazy and unmotivated.");
		System.out.println("You got by on luck alone and when your luck ran out you were sent here.");
		
			gold = 500;
			
			hp = 100;
			stre = 6;
			chari = 6;
			agi = 6;
			intel = 6;
			luck = "Good";
	
			System.out.println("Health <" +hp + ">	Agility <" + (agi + shoes) + ">");
			System.out.println("Strength <" + (stre + weapon) + ">	Intelligence <" + intel + ">");
			System.out.println("Charisma <" + (chari + clothes) + ">	Luck = " + luck );
			System.out.println("Armor <" + armor + ">	Gold <" + gold + ">");
			
		
		break;
		default:
		System.out.println("GAME OVER, that wasn't an option..." + name + ".");
		System.exit(0);
		}
		
		System.out.println(" ");
		System.out.println("You suddenly awake. It's dark so you can barely see my hand.");
		System.out.println("A door opens and just enough light gets in to see.");
		System.out.println("<1>Look around	<2>Exit the room.");
		int choice1;
		choice1 = input.nextInt();
		
		switch(choice1){
			case 1:
				System.out.println("You find that the room is a type of prison, but there is some odd looking food.");
				System.out.println("Would you like to eat the food?");
				System.out.println("<1>Yes	<2>No");
				int choice2;
				choice2 = input.nextInt();
						
				switch(choice2){
						case 1:
							System.out.println("The food was not safe for human consumption.");
							System.out.println(name + " died. GAME OVER");
							System.exit(0);
							break;
						case 2:
							System.out.println(name + " ignored the food.");
							break;
							default:
							System.out.println("GAME OVER, that wasn't an option..." + name + ".");
							System.exit(0);
						}
				
				System.out.println("Would you like to leave the room now?");
				System.out.println("<1>Yes, I have nothing better to do.");
				System.out.println("<2>No, I'd rather to wait for it to be closed again and die alone in here.");
				int choice3;
				choice3 = input.nextInt();
				
				switch(choice3){
				case 1:
					System.out.println(name + " left the room and walked down a long hallway");
					System.out.println(name + " arrived at an intersection.");
					System.out.println("Do you go <1>Left, <2>Right, or <3>Forward?");
					break;
				case 2:
					System.out.println(name + ", Seriously!?!?...GAME OVER");
					System.exit(0);
					break;
					default:
						System.out.println("Your indecisiveness forced you to leave the room.");
						System.out.println(name + " left the room and walked down a long hallway");
						System.out.println(name + " arrived at an intersection.");
						System.out.println("Do you go <1>Left, <2>Right, or <3>Forward?");
				}
				
			break;
			case 2:
				System.out.println(name + " left the room and walked down a long hallway");
				System.out.println(name + " arrived at an intersection.");
				System.out.println("Do you go <1>Left, <2>Right, or <3>Forward?");
			break;
			default:
				System.out.println("GAME OVER, that wasn't an option..." + name + ".");
				System.exit(0);
		}
		int choice4;
		choice4 = input.nextInt();
		
		switch(choice4){
		case 1:
			System.out.println(name + " went left.");
			
			break;
		case 2:
			System.out.println(name + " went right.");
			
			break;
		case 3:
			System.out.println(name + " went forward.");
			
			break;
			default:
				System.out.println(name + " decided to choose at random");
				int choozRandum1 = generator.nextInt(3) + 1;
				
				switch(choozRandum1){
				case 1:
					System.out.println(name + " went left.");
					
					break;
				case 2:
					System.out.println(name + " went right.");
					
					break;
				case 3:
					System.out.println(name + " went forward.");
					break;
					default:
						System.out.println("");
				}
		}
				
				int rGen;
				rGen = generator.nextInt(1000) + 1;
				
			while(inDungeon){
				
				if(rGen <= 100){
					System.out.println(name + " arrived at an intersection.");
					System.out.println("Do you go <1>Left, <2>Right, or <3>Forward?");
					
					int choice5;
					choice5 = input.nextInt();
					
					if(choice5 == 1){
						System.out.println(name + " went left.");
						
					}
					else if(choice5 ==2){
						System.out.println(name + " went right.");

					}
					else if(choice5 == 3){
						System.out.println(name + " went forward.");

					}
					else{
							System.out.println(name + " decided to choose at random");
							int choozRandum2 = generator.nextInt(3) + 1;
							
							if(choozRandum2 == 1){
								System.out.println(name + " went left.");

							}
							else if(choozRandum2 == 2){
								System.out.println(name + " went right.");
								
							}
							else if(choozRandum2 == 3){
								System.out.println(name + " went forward.");

							}
						}
					int heal = generator.nextInt(30) +1;
					if(heal <= 25){
						int heal1 = generator.nextInt(50) +1;
						int newHp;
						
						if((Hell.hp + heal1) <= 100){
						System.out.println(Hell.name + " recovered " + heal1 + " Health.");
						newHp = Hell.hp + heal1;
						Hell.hp = newHp;
						System.out.println("<Stat Update>");
						System.out.println("Health <" +hp + ">");
						}
						else if((Hell.hp + heal1) > 100){
							Hell.hp = 100;
							System.out.println(Hell.name + " recovered " + heal1 + " Health.");
							System.out.println("<Stat Update>");
							System.out.println("Health <" +hp + ">");
						}
					
					}
					else if(heal > 25){
						
					}
					}
				else if(rGen <= 200){
					System.out.println(name + " arrived at an intersection.");
					System.out.println("Do you go <1>Left, or <2>Right?");
					
					int choice5;
					choice5 = input.nextInt();
					
					if(choice5 == 1){
						System.out.println(name + " went left.");

					}
					else if(choice5 == 2){
						System.out.println(name + " went right.");

					}
					else{
							System.out.println(name + " decided to choose at random");
							int choozRandum2 = generator.nextInt(2) + 1;
							
							if(choozRandum2 == 1){
								System.out.println(name + " went left.");
								
							}
							else if(choice5 == 2){
								System.out.println(name + " went right.");
								
							}
			
						}
					int heal = generator.nextInt(30) +1;
					if(heal <= 25){
						int heal1 = generator.nextInt(50) +1;
						int newHp;
						
						if((Hell.hp + heal1) <= 100){
						System.out.println(Hell.name + " recovered " + heal1 + " Health.");
						newHp = Hell.hp + heal1;
						Hell.hp = newHp;
						System.out.println("<Stat Update>");
						System.out.println("Health <" +hp + ">");
						}
						else if((Hell.hp + heal1) > 100){
							Hell.hp = 100;
							System.out.println(Hell.name + " recovered " + heal1 + " Health.");
							System.out.println("<Stat Update>");
							System.out.println("Health <" +hp + ">");
						}
					
					}
					else if(heal > 25){
						
					}
					}
				
				else if(rGen <= 300){
					System.out.println(name + " arrived at an intersection.");
					System.out.println("Do you go <1>Left, or <2>Forward?");
					
					int choice5;
					choice5 = input.nextInt();
					
					if(choice5 == 1){
						System.out.println(name + " went left.");

					}
					else if(choice5 == 2){
						System.out.println(name + " went forward.");

					}
					else{
							System.out.println(name + " decided to choose at random");
							int choozRandum2 = generator.nextInt(2) + 1;
							
							if(choozRandum2 == 1){
								System.out.println(name + " went left.");

							}
							else if(choozRandum2 == 2){
								System.out.println(name + " went forward.");
							
							}
					}
					int heal = generator.nextInt(30) +1;
					if(heal <= 25){
						int heal1 = generator.nextInt(50) +1;
						int newHp;
						
						if((Hell.hp + heal1) <= 100){
							System.out.println(Hell.name + " recovered " + heal1 + " Health.");
						newHp = Hell.hp + heal1;
						Hell.hp = newHp;
						System.out.println("<Stat Update>");
						System.out.println("Health <" +hp + ">");
						}
						else if((Hell.hp + heal1) > 100){
							Hell.hp = 100;
							System.out.println(Hell.name + " recovered " + heal1 + " Health.");
							System.out.println("<Stat Update>");
							System.out.println("Health <" +hp + ">");
						}
					
					}
					else if(heal > 25){
						
					}
				}
				
				else if(rGen <= 350){
					System.out.println(name + " arrived at an intersection.");
					System.out.println("Do you go <1>Right, or <2>Forward?");
					
					int choice5;
					choice5 = input.nextInt();
					
					if(choice5 == 1){
						System.out.println(name + " went right.");
						
					}
					else if (choice5 == 2){
						System.out.println(name + " went forward.");
						
					}
					else{
							System.out.println(name + " decided to choose at random");
							int choozRandum2 = generator.nextInt(2) + 1;
							
							if(choozRandum2 == 1){
								System.out.println(name + " went right.");
								
							}
							else if(choozRandum2 == 2){
								System.out.println(name + " went forward.");
								
							}
					}
					int heal = generator.nextInt(30) +1;
					if(heal <= 25){
						int heal1 = generator.nextInt(50) +1;
						int newHp;
						
						if((Hell.hp + heal1) <= 100){
						System.out.println(Hell.name + " recovered " + heal1 + " Health.");
						newHp = Hell.hp + heal1;
						Hell.hp = newHp;
						System.out.println("<Stat Update>");
						System.out.println("Health <" +hp + ">");
						}
						else if((Hell.hp + heal1) > 100){
							Hell.hp = 100;
							System.out.println(Hell.name + " recovered " + heal1 + " Health.");
							System.out.println("<Stat Update>");
							System.out.println("Health <" +hp + ">");
						}
					
					}
					else if(heal > 25){
						
					}
				}
				
				else if(rGen <= 500){
					Merchant randomMerchant = new Merchant();
					randomMerchant.encounter();

				}
				
				else if(rGen <= 700){
					Enemy normalEnemy = new Enemy();
					normalEnemy.battleLv1();
					
				}
				
				else if(rGen <= 820){
					Enemy normalEnemy = new Enemy();
					normalEnemy.battleLv2();
					
				}
				
				else if(rGen <= 845){
					Enemy normalEnemy = new Enemy();
					normalEnemy.battleLv3();
					
				}
				else if(rGen <= 998){
					Chest chest = new Chest();
					chest.chest();
				}
				else if(rGen >= 999){
					Enemy boss = new Enemy();
					boss.Boss();
				}
				
				rGen = generator.nextInt(1000) + 1;
				
				
			}
			
		}
		
	}


