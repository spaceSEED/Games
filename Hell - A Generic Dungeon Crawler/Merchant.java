import java.util.Random;
import java.util.Scanner;


public class Merchant {
	
	Scanner input = new Scanner(System.in);
	Random generator = new Random();

		
	

	public void encounter(){
		
		
		
		int item1 = 0;
		int item2 = 0;
		int item3 = 0;
		String itemAt1 = null;
		String itemName1 = null;
		int cost1 = 0;
		String itemAt2 = null;
		String itemName2 = null;
		int cost2 = 0;
		String itemAt3 = null;
		String itemName3 = null;
		int cost3 = 0;
		
	System.out.println(Hell.name + " encountered a random merchant.");
	System.out.println("Would you like to see the merchant's inventory?");
	System.out.println("<1>Yes	<2>No");
	int merchantIn = input.nextInt();
	
	if(merchantIn == 1){
		System.out.println("<Buying an item (excluding armor) will replace the bonus"); 
		System.out.println("of your current similar stat affecting item> ");
		System.out.println("Which would you like to buy?		 (" + Hell.name + "'s Stats)");
		
		int item1sel = generator.nextInt(4) + 1;
		
		if(item1sel == 1){
			int weaponBuy1 = generator.nextInt(30) + 1;
			item1 = weaponBuy1;
			itemAt1 = "+Strength";
			int itemName1sel = generator.nextInt(5) + 1;
			
			if(itemName1sel ==  1){
				itemName1 = "Sword     ";
			}
			else if(itemName1sel ==  2){
				itemName1 = "Axe       ";
			}
			else if(itemName1sel ==  3){
				itemName1 = "Bow       ";
			}
			else if(itemName1sel ==  4){
				itemName1 = "Spear     ";
			}
			else if(itemName1sel ==  5){
				itemName1 = "Dagger    ";
			}
		}
		else if(item1sel == 2){
			int armorBuy1 = generator.nextInt(200) + 1;
			item1 = armorBuy1;
			itemAt1 = "+Armor";
			int itemName1sel = generator.nextInt(4) + 1;
			
			if(itemName1sel ==  1){
				itemName1 = "Cuirass   ";
			}
			else if(itemName1sel ==  2){
				itemName1 = "Greaves   ";
			}
			else if(itemName1sel ==  3){
				itemName1 = "Helmet    ";
			}
			else if(itemName1sel ==  4){
				itemName1 = "Gauntlet  ";
			}
			
			
			
		}
		else if(item1sel == 3){
			int aparelBuy1 = generator.nextInt(20) + 1;
			item1 = aparelBuy1;
			itemAt1 = "+Charisma";
			int itemName1sel = generator.nextInt(5) + 1;
			
			if(itemName1sel ==  1){
				itemName1 = "Shirt     ";
			}
			else if(itemName1sel ==  2){
				itemName1 = "Pants     ";
			}
			else if(itemName1sel ==  3){
				itemName1 = "Wig       ";
			}
			else if(itemName1sel ==  4){
				itemName1 = "Belt      ";
			}
			else if(itemName1sel ==  5){
				itemName1 = "Jewlery   ";
			}
			
		}
		else if(item1sel == 4){
			int shoeBuy1 = generator.nextInt(20) + 1;
			item1 = shoeBuy1;
			itemAt1 = "+Agility";
			int itemName1sel = generator.nextInt(5) + 1;
			
			if(itemName1sel ==  1){
				itemName1 = "Shoes     ";
			}
			else if(itemName1sel ==  2){
				itemName1 = "Boots     ";
			}
			else if(itemName1sel ==  3){
				itemName1 = "Sandals   ";
			}
			else if(itemName1sel ==  4){
				itemName1 = "Moccasins ";
			}
			else if(itemName1sel ==  5){
				itemName1 = "Slippers  ";
			}
			
		}
		
		int cost12 = generator.nextInt(1000) + 1;
		if(cost12 <= (Hell.chari + Hell.clothes)){
		cost1 = cost12;
		}
		else if(cost12 > (Hell.chari + Hell.clothes)){
			cost1 = cost12 - (Hell.chari + Hell.clothes);
		}
		int item2sel = generator.nextInt(4) + 1;
		
		if(item2sel == 1){
			int weaponBuy2 = generator.nextInt(30) + 1;
			item2 = weaponBuy2;
			itemAt2 = "+Strength";
			int itemName2sel = generator.nextInt(5) + 1;
			
			if(itemName2sel ==  1){
				itemName2 = "Sword     ";
			}
			else if(itemName2sel ==  2){
				itemName2 = "Axe       ";
			}
			else if(itemName2sel ==  3){
				itemName2 = "Bow       ";
			}
			else if(itemName2sel ==  4){
				itemName2 = "Spear     ";
			}
			else if(itemName2sel ==  5){
				itemName2 = "Dagger    ";
			}
		}
		else if(item2sel == 2){
			int armorBuy2 = generator.nextInt(200) + 1;
			item2 = armorBuy2;
			itemAt2 = "+Armor";
			int itemName2sel = generator.nextInt(4) + 1;
			
			if(itemName2sel ==  1){
				itemName2 = "Cuirass   ";
			}
			else if(itemName2sel ==  2){
				itemName2 = "Greaves   ";
			}
			else if(itemName2sel ==  3){
				itemName2 = "Helmet    ";
			}
			else if(itemName2sel ==  4){
				itemName2 = "Gauntlet  ";
			}
			
			
			
		}
		else if(item2sel == 3){
			int aparelBuy2 = generator.nextInt(20) + 1;
			item2 = aparelBuy2;
			itemAt2 = "+Charisma";
			int itemName2sel = generator.nextInt(5) + 1;
			
			if(itemName2sel ==  1){
				itemName2 = "Shirt     ";
			}
			else if(itemName2sel ==  2){
				itemName2 = "Pants     ";
			}
			else if(itemName2sel ==  3){
				itemName2 = "Wig       ";
			}
			else if(itemName2sel ==  4){
				itemName2 = "Belt      ";
			}
			else if(itemName2sel ==  5){
				itemName2 = "Jewlery   ";
			}
			
		}
		else if(item2sel == 4){
			int shoeBuy2 = generator.nextInt(20) + 1;
			item2 = shoeBuy2;
			itemAt2 = "+Agility";
			int itemName2sel = generator.nextInt(5) + 1;
			
			if(itemName2sel ==  1){
				itemName2 = "Shoes     ";
			}
			else if(itemName2sel ==  2){
				itemName2 = "Boots     ";
			}
			else if(itemName2sel ==  3){
				itemName2 = "Sandals   ";
			}
			else if(itemName2sel ==  4){
				itemName2 = "Moccasins ";
			}
			else if(itemName2sel ==  5){
				itemName2 = "Slippers  ";
			}
			
		}
		
		int cost22 = generator.nextInt(1000) + 1;
		if(cost22 <= (Hell.chari + Hell.clothes)){
		cost2 = cost22;
		}
		else if(cost22 > (Hell.chari + Hell.clothes)){
			cost2 = cost22 - (Hell.chari + Hell.clothes);
		}
		
		int item3sel = generator.nextInt(4) + 1;
		if(item3sel == 1){
			int weaponBuy3 = generator.nextInt(30) + 1;
			item3 = weaponBuy3;
			itemAt3 = "+Strength";
			int itemName3sel = generator.nextInt(5) + 1;
			
			if(itemName3sel ==  1){
				itemName3 = "Sword     ";
			}
			else if(itemName3sel ==  2){
				itemName3 = "Axe       ";
			}
			else if(itemName3sel ==  3){
				itemName3 = "Bow       ";
			}
			else if(itemName3sel ==  4){
				itemName3 = "Spear     ";
			}
			else if(itemName3sel ==  5){
				itemName3 = "Dagger    ";
			}
		}
		else if(item3sel == 2){
			int armorBuy3 = generator.nextInt(200) + 1;
			item3 = armorBuy3;
			itemAt3 = "+Armor";
			int itemName3sel = generator.nextInt(4) + 1;
			
			if(itemName3sel ==  1){
				itemName3 = "Cuirass   ";
			}
			else if(itemName3sel ==  2){
				itemName3 = "Greaves   ";
			}
			else if(itemName3sel ==  3){
				itemName3 = "Helmet    ";
			}
			else if(itemName3sel ==  4){
				itemName3 = "Gauntlet  ";
			}
			
			
			
		}
		else if(item3sel == 3){
			int aparelBuy3 = generator.nextInt(20) + 1;
			item3 = aparelBuy3;
			itemAt3 = "+Charisma";
			int itemName3sel = generator.nextInt(5) + 1;
			
			if(itemName3sel ==  1){
				itemName3 = "Shirt     ";
			}
			else if(itemName3sel ==  2){
				itemName3 = "Pants     ";
			}
			else if(itemName3sel ==  3){
				itemName3 = "Wig       ";
			}
			else if(itemName3sel ==  4){
				itemName3 = "Belt      ";
			}
			else if(itemName3sel ==  5){
				itemName3 = "Jewlery   ";
			}
			
		}
		else if(item3sel == 4){
			int shoeBuy3 = generator.nextInt(20) + 1;
			item3 = shoeBuy3;
			itemAt3 = "+Agility";
			int itemName3sel = generator.nextInt(5) + 1;
			
			if(itemName3sel ==  1){
				itemName3 = "Shoes     ";
			}
			else if(itemName3sel ==  2){
				itemName3 = "Boots     ";
			}
			else if(itemName3sel ==  3){
				itemName3 = "Sandals   ";
			}
			else if(itemName3sel ==  4){
				itemName3 = "Moccasins ";
			}
			else if(itemName3sel ==  5){
				itemName3 = "Slippers  ";
			}
			
		}
		
		int cost32 = generator.nextInt(1000) + 1;
		if(cost32 <= (Hell.chari + Hell.clothes)){
		cost3 = cost32;
		}
		else if(cost32 > (Hell.chari + Hell.clothes)){
			cost3 = cost32 - (Hell.chari + Hell.clothes);
		}
		
		System.out.println("<1>" + itemName1 + item1 + itemAt1 + " Gold: " + cost1 + "	Health <" + Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("<2>" + itemName2 + item2 + itemAt2 + " Gold: " + cost2 + "	Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("<3>" + itemName3 + item3 + itemAt3 + " Gold: " + cost3 + "	Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("<4> 'I'm not interested, sorry.'	Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
		int merchantBuy = input.nextInt();
		
		if(merchantBuy == 1){
			
			if(cost1 <= Hell.gold){
				Hell.newGold = Hell.gold -cost1;
				Hell.gold = Hell.newGold;
				if(itemAt1 == "+Strength"){
					Hell.weapon = item1;
				}
				else if(itemAt1 == "+Agility"){
					Hell.shoes = item1;
				}
				else if(itemAt1 == "+Charisma"){
					Hell.clothes = item1;
				}
				else if(itemAt1 == "+Armor"){
					if((Hell.armor + item1) <= 200){
						Hell.newArmor = Hell.armor + item1;
						Hell.armor = Hell.newArmor;
						}
						else if((Hell.armor + item1) > 200){
							Hell.armor = 200;
						}
					
				}
				System.out.println(Hell.name + "'s New Stats");
				System.out.println("Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
				System.out.println("Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
				System.out.println("Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
				System.out.println("Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
				
			}
			
			else if(cost1 > Hell.gold){
				System.out.println("Sorry, you didn't have enough to buy this.");
				System.out.println("The merchant stormed off upset.");
			}
			
			
		}
		
		else if(merchantBuy == 2){
			if(cost2 <= Hell.gold){
				Hell.newGold = Hell.gold -cost2;
				Hell.gold = Hell.newGold;
				if(itemAt2 == "+Strength"){
					Hell.weapon = item2;
				}
				else if(itemAt2 == "+Agility"){
					Hell.shoes = item2;
				}
				else if(itemAt2 == "+Charisma"){
					Hell.clothes = item2;
					
				}
				else if(itemAt2 == "+Armor"){
					if((Hell.armor + item2) <= 200){
						Hell.newArmor = Hell.armor + item2;
						Hell.armor = Hell.newArmor;
						}
						else if((Hell.armor + item2) > 200){
							Hell.armor = 200;
						}
					
				}
				System.out.println(Hell.name + "'s New Stats");
				System.out.println("Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
				System.out.println("Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
				System.out.println("Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
				System.out.println("Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
				
				
			}
			
			else if(cost1 > Hell.gold){
				System.out.println("Sorry, you didn't have enough to buy this.");
				System.out.println("The merchant stormed off upset.");
			}
		}
		
		else if(merchantBuy == 3){
			if(cost3 <= Hell.gold){
				Hell.newGold = Hell.gold -cost3;
				Hell.gold = Hell.newGold;
				if(itemAt3 == "+Strength"){
					Hell.weapon = item3;
				}
				else if(itemAt3 == "+Agility"){
					Hell.shoes = item3;
				}
				else if(itemAt3 == "+Charisma"){
					Hell.clothes = item3;
				}
				else if(itemAt3 == "+Armor"){
					if((Hell.armor + item3) <= 200){
						Hell.newArmor = Hell.armor + item3;
						Hell.armor = Hell.newArmor;
						}
						else if((Hell.armor + item3) > 200){
							Hell.armor = 200;
						}
					
				}
				System.out.println(Hell.name + "'s New Stats");
				System.out.println("Health <" + Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
				System.out.println("Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
				System.out.println("Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
				System.out.println("Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
				
				
			}
			
			else if(cost1 > Hell.gold){
				System.out.println("Sorry, you didn't have enough to buy this.");
				System.out.println("The merchant stormed off upset.");
			}
		}
		
		else if(merchantBuy == 4){
			System.out.println(Hell.name + " left. The merchant seemed very dissappointed");
		}
		
		else{
			System.out.println(Hell.name + " left. The merchant seemed very dissappointed");
		}
		
	}
	
	else if(merchantIn == 2){
		System.out.println(Hell.name + " left. The merchant seemed very dissappointed");
	}
	
	else{
		System.out.println(Hell.name + " left. The merchant seemed very dissappointed");
	}
		
	}





}
