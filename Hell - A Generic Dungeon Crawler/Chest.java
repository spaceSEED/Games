import java.util.Random;
import java.util.Scanner;


public class Chest {
	Scanner input = new Scanner(System.in);
	Random generator = new Random();
	
	public void chest(){
		System.out.println(Hell.name + " found a chest.");
		System.out.println("Would you like to open it?");
		System.out.println("<1>Yes	<2>No");
		int chestChoice;
		chestChoice = input.nextInt();
		
		if(chestChoice == 1){
			System.out.println(Hell.name + " opened the chest.");
			int chestMimic = generator.nextInt(100) + 1;
			
			if(chestMimic < 93){
				int battleDrop = generator.nextInt(10) +1;
				if(battleDrop == 1){
					int dropNamesel = generator.nextInt(5) + 1;
					String dropName = null;
					int drop = generator.nextInt(35) + 1;
					String dropAt = "+Strength";
					
					if(dropNamesel ==  1){
						dropName = "Sword";
					}
					else if(dropNamesel ==  2){
						dropName = "Axe";
					}
					else if(dropNamesel ==  3){
						dropName = "Bow";
					}
					else if(dropNamesel ==  4){
						dropName = "Spear";
					}
					else if(dropNamesel ==  5){
						dropName = "Dagger";
					}
					System.out.println("The chest had");
					System.out.println(dropName + "  " + drop + dropAt);
					System.out.println("Would you like to take it?");
					System.out.println("<1>Yes <2>No");
					
					int dropChoice = input.nextInt();
					
					if(dropChoice ==1){
						System.out.println(Hell.name + " obtained the " + dropName + ".");
						Hell.weapon = drop;
					}
					else if(dropChoice ==2){
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}
					else{
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}
				}
				else if(battleDrop ==2){
					int dropNamesel = generator.nextInt(4) + 1;
					String dropName = null;
					int drop = generator.nextInt(20) + 1;
					String dropAt = "+Armor";
					
					if(dropNamesel ==  1){
						dropName = "Cuirass";
					}
					else if(dropNamesel ==  2){
						dropName = "Helmet";
					}
					else if(dropNamesel ==  3){
						dropName = "Greaves";
					}
					else if(dropNamesel ==  4){
						dropName = "Gauntlet";
					}
					System.out.println("The chest had");
					System.out.println(dropName + "  " + drop + dropAt);
					System.out.println("Would you like to take it?");
					System.out.println("<1>Yes <2>No");
					int dropChoice = input.nextInt();
					
					if(dropChoice ==1){
						int newArmor;
						System.out.println(Hell.name + " obtained the " + dropName + ".");
						if((Hell.armor + drop) <= 200){
						newArmor = Hell.armor + drop;
						Hell.armor = newArmor;
						}
						else if((Hell.armor + drop) > 200){
							Hell.armor = 200;
						}
					}
					else if(dropChoice ==2){
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}
					else{
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}

				}
				else if(battleDrop ==3){
					int dropNamesel = generator.nextInt(5) + 1;
					String dropName = null;
					int drop = generator.nextInt(20) + 1;
					String dropAt = "+Charisma";
					
					if(dropNamesel ==  1){
						dropName = "Shirt";
					}
					else if(dropNamesel ==  2){
						dropName = "Pants";
					}
					else if(dropNamesel ==  3){
						dropName = "Wig";
					}
					else if(dropNamesel ==  4){
						dropName = "Belt";
					}
					else if(dropNamesel ==  5){
						dropName = "Jewlery";
					}
					System.out.println("The chest had");
					System.out.println(dropName + "  " + drop + dropAt);
					System.out.println("Would you like to take it?");
					System.out.println("<1>Yes <2>No");
					int dropChoice = input.nextInt();
					
					if(dropChoice ==1){
						System.out.println(Hell.name + " obtained the " + dropName + ".");
						Hell.clothes = drop;
					}
					else if(dropChoice ==2){
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}
					else{
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}

				}
				else if(battleDrop ==4){
					int dropNamesel = generator.nextInt(5) + 1;
					String dropName = null;
					int drop = generator.nextInt(20) + 1;
					String dropAt = "+Agility";
					
					if(dropNamesel ==  1){
						dropName = "Shoes";
					}
					else if(dropNamesel ==  2){
						dropName = "Sandals";
					}
					else if(dropNamesel ==  3){
						dropName = "Boots";
					}
					else if(dropNamesel ==  4){
						dropName = "Slippers";
					}
					else if(dropNamesel ==  5){
						dropName = "Moccasins";
					}
					System.out.println("The chest had");
					System.out.println(dropName + "  " + drop + dropAt);
					System.out.println("Would you like to take it?");
					System.out.println("<1>Yes <2>No");
					int dropChoice = input.nextInt();
					
					if(dropChoice ==1){
						System.out.println(Hell.name + " obtained the " + dropName + ".");
						Hell.shoes = drop;
					}
					else if(dropChoice ==2){
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}
					else{
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}

				}
				else if(battleDrop ==5){
					int dropNamesel = generator.nextInt(4) + 1;
					String dropName = null;
					int drop = generator.nextInt(35) + 1;
					String dropAt = "+Inteligence";
					
					if(dropNamesel ==  1){
						dropName = "Book";
					}
					else if(dropNamesel ==  2){
						dropName = "Textbook";
					}
					else if(dropNamesel ==  3){
						dropName = "Map";
					}
					else if(dropNamesel ==  4){
						dropName = "Dictionary";
					}
					System.out.println("The chest had");
					System.out.println(dropName + "  " + drop + dropAt);
					System.out.println("Would you like to take it?");
					System.out.println("<1>Yes <2>No");
					int dropChoice = input.nextInt();
					
					if(dropChoice ==1){
						int newIntel;
						System.out.println(Hell.name + " obtained the " + dropName + ".");
						newIntel = Hell.intel + drop;
						Hell.intel = newIntel;
					}
					else if(dropChoice ==2){
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}
					else{
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}

				}
				else if(battleDrop ==6){
					String dropName = "Food";
					int drop = generator.nextInt(50) + 1;
					String dropAt = "+Health";
					System.out.println("The chest had");
					System.out.println(dropName + "  " + drop + dropAt);
					System.out.println("Would you like to eat it?");
					System.out.println("<1>Yes <2>No");
					int dropChoice = input.nextInt();
					
					if(dropChoice ==1){
						int newHp;
						System.out.println(Hell.name + " obtained the " + dropName + ".");
						if((Hell.hp + drop) <= 100){
						newHp = Hell.hp + drop;
						Hell.hp = newHp;
						}
						else if((Hell.hp + drop) > 100){
							Hell.hp = 100;
						}
					}
					else if(dropChoice ==2){
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}
					else{
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}
					

				}
				else if(battleDrop ==7){
					String dropName = "Gold";
					int drop = generator.nextInt(500) +1;
					System.out.println("The chest had");
					System.out.println(drop + " " + dropName );
					System.out.println("Would you like to take it?");
					System.out.println("<1>Yes <2>No");
					int dropChoice = input.nextInt();
					
					if(dropChoice ==1){
						int newGold;
						System.out.println(Hell.name + " obtained the " + dropName + ".");
						newGold = Hell.gold + drop;
						Hell.gold = newGold;
					}
					else if(dropChoice ==2){
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}
					else{
						System.out.println(Hell.name + " ignored the " + dropName + ".");
					}

					
				}
				else if(battleDrop <=10){
					System.out.println("The chest was empty.");
				}
				
			}
			
			else if(chestMimic >= 93){
				System.out.println("The chest turned out to be a mimic.");
				Enemy mimic = new Enemy();
				mimic.battleMimic();
				
			}
		}
		
		else if(chestChoice == 2){
			System.out.println(Hell.name + " ignored the chest.");
			
		}
		
		else{
			System.out.println(Hell.name + "ignored the chest.");
			
		}
	
	}
}
