import java.util.Random;
import java.util.Scanner;


public class Enemy {
	Scanner input = new Scanner(System.in);
	Random generator = new Random();
	
	
	public static int enemyHp;
	public static int enemyStre;
	public static int enemyAgi;
	public static int enemyArmor;
	public static String enemyName;
	public static int damage;
	public static int damage2e;
	public static int damage2p;
	public static int criticalHit;
	public static int miss;
	public static int newHp;
	public static int newArmor;
	
	
	public void battleLv2(){

		int enemyNameSel = generator.nextInt(6) + 1;
		boolean battle = true;
		
		
		
		if(enemyNameSel <= 2){
			Enemy.enemyName = "Demon";
		}
		
		else if(enemyNameSel == 3){
			Enemy.enemyName = "Hell-hound";
		}
		
		else if(enemyNameSel == 4){
			Enemy.enemyName = "Lost-soul";
		}
		
		else if(enemyNameSel == 5){
			Enemy.enemyName = "Banshee";
		}
		
		else if(enemyNameSel == 6){
			Enemy.enemyName = "Wraith";
		}
		
		Enemy.enemyHp = 100;
		Enemy.enemyArmor = 0;
		Enemy.enemyStre = generator.nextInt(15) + 10;
		Enemy.enemyAgi = generator.nextInt(15) + 5;
		
		System.out.println(Hell.name + " encountered a " + Enemy.enemyName);
		
		while(battle){
		
		System.out.println("<" + Enemy.enemyName + "'s Current Stats>	<" + Hell.name + "'s Current Stats>");
		System.out.println("Health <" +Enemy.enemyHp + ">	Agility <" + Enemy.enemyAgi + ">	Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + Enemy.enemyStre + ">	Armor <" + Enemy.enemyArmor + ">	Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("				Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("What will you do?		Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
		System.out.println("<1>Attack	<2>Dodge	<3>Flee");
		int battleChoice = input.nextInt();
		
		if(battleChoice == 1){
			
			
			if(Enemy.enemyAgi < (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
				}
		
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println("The " + Enemy.enemyName +"'s Health hit 0.");
					System.out.println("The " + Enemy.enemyName +" died.");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(150) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(20) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped nothing.");
					}
					
					
					int xp = generator.nextInt(10)+1;
					int xpStat = generator.nextInt(4)+1;
					if(xpStat ==1){
						System.out.println(Hell.name +"'s Strength incresed by " + xp);
						int newStrexp = xp + Hell.stre;
						Hell.stre = newStrexp;
					}
					else if(xpStat ==2){
						System.out.println(Hell.name +"'s Agility incresed by " + xp);
						int newAgixp = xp + Hell.agi;
						Hell.agi = newAgixp;
					}
					else if(xpStat ==3){
						System.out.println(Hell.name +"'s Intelligence incresed by " + xp);
						int newIntxp = xp + Hell.intel;
						Hell.intel = newIntxp;
					}
					else if(xpStat ==4){
						System.out.println(Hell.name +"'s Charisma incresed by " + xp);
						int newCharxp = xp + Hell.chari;
						Hell.chari = newCharxp;
					}
					
					
					battle = false;
				}
				else if(Enemy.enemyHp > 0){
		Enemy.miss = generator.nextInt(5) + 1;
			
			if(miss > 1){
			Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
			Enemy.criticalHit = generator.nextInt(10) + 1;
			
			if(Enemy.criticalHit == 1){
				System.out.println("Critical Hit");
				Enemy.damage2p = Enemy.damage * 2;
			}
			else if(Enemy.criticalHit > 1){
				Enemy.damage2p = Enemy.damage;
			}
			
			System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
			if(Hell.armor == 0){
				Enemy.newHp = Hell.hp - Enemy.damage2p;
				Hell.hp = Enemy.newHp;
			}
			else if((Hell.armor - Enemy.damage2p) >= 0){
				Enemy.newArmor = Hell.armor - Enemy.damage2p;
				Hell.armor = Enemy.newArmor;
			}
			else if((Hell.armor - Enemy.damage2p) < 0){
				Enemy.newArmor = Enemy.damage2p - Hell.armor;
				Enemy.newHp = Hell.hp - Enemy.newArmor;
				Hell.hp = Enemy.newHp;
				Hell.armor = 0;
				
			}
			
			if(Hell.hp <= 0){
				System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
				System.exit(0);
			}
			else if(Hell.hp > 0){
				
			}
			}
			else if(miss == 1){
				System.out.println(Enemy.enemyName + "'s attack missed.");
			}
			}
			}
			else if(Enemy.enemyAgi >= (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2p = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2p = Enemy.damage;
				}
				
				System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
				if(Hell.armor == 0){
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
				}
				else if((Hell.armor - Enemy.damage2p) >= 0){
					Enemy.newArmor = Hell.armor - Enemy.damage2p;
					Hell.armor = Enemy.newArmor;
				}
				else if((Hell.armor - Enemy.damage2p) < 0){
					Enemy.newArmor = Enemy.damage2p - Hell.armor;
					Enemy.newHp = Hell.hp - Enemy.newArmor;
					Hell.hp = Enemy.newHp;
					Hell.armor = 0;
					
				}
				
				}		
				
				else if(miss == 1){
					
					System.out.println(Enemy.enemyName + "'s attack missed.");
						
				}
				if(Hell.hp <= 0){
					System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
					System.exit(0);	
				}
				else if(Hell.hp > 0){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
		
			}
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println("The " + Enemy.enemyName +"'s Health hit 0.");
					System.out.println("The " + Enemy.enemyName +" died.");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(150) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(20) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped nothing.");
					}
					
					
					int xp = generator.nextInt(10)+1;
					int xpStat = generator.nextInt(4)+1;
					if(xpStat ==1){
						System.out.println(Hell.name +"'s Strength incresed by " + xp);
						int newStrexp = xp + Hell.stre;
						Hell.stre = newStrexp;
					}
					else if(xpStat ==2){
						System.out.println(Hell.name +"'s Agility incresed by " + xp);
						int newAgixp = xp + Hell.agi;
						Hell.agi = newAgixp;
					}
					else if(xpStat ==3){
						System.out.println(Hell.name +"'s Intelligence incresed by " + xp);
						int newIntxp = xp + Hell.intel;
						Hell.intel = newIntxp;
					}
					else if(xpStat ==4){
						System.out.println(Hell.name +"'s Charisma incresed by " + xp);
						int newCharxp = xp + Hell.chari;
						Hell.chari = newCharxp;
					}
					
					
					battle = false;
				}
			
		}
			}
	
		}
		else if(battleChoice ==2){
			int random1 =  generator.nextInt(1000) +1;
			int random2 = generator.nextInt(20) +1;
			int dodge = (random1 / random2) - (Hell.agi + Hell.shoes);
			if(dodge <= 20){
				System.out.println(Hell.name + " dodged successfully.");
				int heal = generator.nextInt(30) +1;
				if(heal <= 25){
					int heal1 = generator.nextInt(20) +1;
					int newHp;
					System.out.println(Hell.name + " recovered " + heal1 + " Health after dodging.");
					if((Hell.hp + heal1) <= 100){
					newHp = Hell.hp + heal1;
					Hell.hp = newHp;
					}
					else if((Hell.hp + heal1) > 100){
						Hell.hp = 100;
					}
				
				}
				else if(heal > 25){
					
				}
			}
				else if(dodge > 20){
					System.out.println("Dodging Failed");
					Enemy.miss = generator.nextInt(5) + 1;
					
					if(miss > 1){
					Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
					Enemy.criticalHit = generator.nextInt(10) + 1;
					
					if(Enemy.criticalHit == 1){
						System.out.println("Critical Hit");
						Enemy.damage2p = Enemy.damage * 2;
					}
					else if(Enemy.criticalHit > 1){
						Enemy.damage2p = Enemy.damage;
					}
					
					System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
					if(Hell.hp <= 0){
						System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
						System.exit(0);
					}		
						
					}
					else if(miss == 1){
						System.out.println(Enemy.enemyName + "'s attack missed.");	
					}
					
				}
			
		}
		
		else if(battleChoice ==3){
			int random1 =  generator.nextInt(500) +1;
			int random2 = generator.nextInt(15) +1;
			int flee = (random1 / random2) - Hell.intel;
			if(flee <= 15){
				System.out.println(Hell.name + " escaped the battle.");
				battle = false;
			}
			else if(flee > 15){
				System.out.println(Hell.name + " failed to escape.");
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2p = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2p = Enemy.damage;
				}
				
				System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
				if(Hell.armor == 0){
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
				}
				else if((Hell.armor - Enemy.damage2p) >= 0){
					Enemy.newArmor = Hell.armor - Enemy.damage2p;
					Hell.armor = Enemy.newArmor;
				}
				else if((Hell.armor - Enemy.damage2p) < 0){
					Enemy.newArmor = Enemy.damage2p - Hell.armor;
					Enemy.newHp = Hell.hp - Enemy.newArmor;
					Hell.hp = Enemy.newHp;
					Hell.armor = 0;
					
				}
				
				if(Hell.hp <= 0){
					System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
					System.exit(0);
				}
				else if(Hell.hp > 0){
					
				}
				}
				else if(miss == 1){
					System.out.println(Enemy.enemyName + "'s attack missed.");
				}
			}
			
			
		}
	
		}
		System.out.println(Hell.name + "'s Post-Battle Stats");
		System.out.println("Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
	}
	
	public void battleLv1(){
		int enemyNameSel = generator.nextInt(6) + 1;
		boolean battle = true;
		
		
		
		if(enemyNameSel <= 2){
			Enemy.enemyName = "Minor Demon";
		}
		
		else if(enemyNameSel == 3){
			Enemy.enemyName = "Hell-puppy";
		}
		
		else if(enemyNameSel == 4){
			Enemy.enemyName = "Confused-soul";
		}
		
		else if(enemyNameSel == 5){
			Enemy.enemyName = "Silent Banshee";
		}
		
		else if(enemyNameSel == 6){
			Enemy.enemyName = "Weak Wraith";
		}
		
		Enemy.enemyHp = generator.nextInt(51) +25;
		Enemy.enemyArmor = 0;
		Enemy.enemyStre = generator.nextInt(7) + 5;
		Enemy.enemyAgi = generator.nextInt(5) + 3;
		
		System.out.println(Hell.name + " encountered a " + Enemy.enemyName);
		
		while(battle){
		
		System.out.println("<" + Enemy.enemyName + "'s Current Stats>	<" + Hell.name + "'s Current Stats>");
		System.out.println("Health <" +Enemy.enemyHp + ">	Agility <" + Enemy.enemyAgi + ">	Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + Enemy.enemyStre + ">	Armor <" + Enemy.enemyArmor + ">	Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("				Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("What will you do?		Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
		System.out.println("<1>Attack	<2>Dodge	<3>Flee");
		int battleChoice = input.nextInt();
		
		if(battleChoice == 1){
			
			
			if(Enemy.enemyAgi < (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
				}
		
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println("The " + Enemy.enemyName +"'s Health hit 0.");
					System.out.println("The " + Enemy.enemyName +" died.");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(150) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(20) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped nothing.");
					}
					
					
					int xp = generator.nextInt(10)+1;
					int xpStat = generator.nextInt(4)+1;
					if(xpStat ==1){
						System.out.println(Hell.name +"'s Strength incresed by " + xp);
						int newStrexp = xp + Hell.stre;
						Hell.stre = newStrexp;
					}
					else if(xpStat ==2){
						System.out.println(Hell.name +"'s Agility incresed by " + xp);
						int newAgixp = xp + Hell.agi;
						Hell.agi = newAgixp;
					}
					else if(xpStat ==3){
						System.out.println(Hell.name +"'s Intelligence incresed by " + xp);
						int newIntxp = xp + Hell.intel;
						Hell.intel = newIntxp;
					}
					else if(xpStat ==4){
						System.out.println(Hell.name +"'s Charisma incresed by " + xp);
						int newCharxp = xp + Hell.chari;
						Hell.chari = newCharxp;
					}
					
					
					battle = false;
				}
				else if(Enemy.enemyHp > 0){
			
		Enemy.miss = generator.nextInt(5) + 1;
			
			if(miss > 1){
			Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
			Enemy.criticalHit = generator.nextInt(10) + 1;
			
			if(Enemy.criticalHit == 1){
				System.out.println("Critical Hit");
				Enemy.damage2p = Enemy.damage * 2;
			}
			else if(Enemy.criticalHit > 1){
				Enemy.damage2p = Enemy.damage;
			}
			
			System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
			if(Hell.armor == 0){
				Enemy.newHp = Hell.hp - Enemy.damage2p;
				Hell.hp = Enemy.newHp;
			}
			else if((Hell.armor - Enemy.damage2p) >= 0){
				Enemy.newArmor = Hell.armor - Enemy.damage2p;
				Hell.armor = Enemy.newArmor;
			}
			else if((Hell.armor - Enemy.damage2p) < 0){
				Enemy.newArmor = Enemy.damage2p - Hell.armor;
				Enemy.newHp = Hell.hp - Enemy.newArmor;
				Hell.hp = Enemy.newHp;
				Hell.armor = 0;
				
			}
			
			if(Hell.hp <= 0){
				System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
				System.exit(0);
			}
			else if(Hell.hp > 0){
				
			}
			}
			else if(miss == 1){
				System.out.println(Enemy.enemyName + "'s attack missed.");
			}
			}
			}
			else if(Enemy.enemyAgi >= (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2p = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2p = Enemy.damage;
				}
				
				System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
				if(Hell.armor == 0){
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
				}
				else if((Hell.armor - Enemy.damage2p) >= 0){
					Enemy.newArmor = Hell.armor - Enemy.damage2p;
					Hell.armor = Enemy.newArmor;
				}
				else if((Hell.armor - Enemy.damage2p) < 0){
					Enemy.newArmor = Enemy.damage2p - Hell.armor;
					Enemy.newHp = Hell.hp - Enemy.newArmor;
					Hell.hp = Enemy.newHp;
					Hell.armor = 0;
					
				}
				}		
				
				else if(miss == 1){
					
					System.out.println(Enemy.enemyName + "'s attack missed.");
						
				}
				if(Hell.hp <= 0){
					System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
					System.exit(0);	
				}
				else if(Hell.hp > 0){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
		
			}
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println("The " + Enemy.enemyName +"'s Health hit 0.");
					System.out.println("The " + Enemy.enemyName +" died.");
					int battleDrop = generator.nextInt(10) +1;
					if(battleDrop == 1){
						int dropNamesel = generator.nextInt(5) + 1;
						String dropName = null;
						int drop = generator.nextInt(15) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(100) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(10) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(10) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(20) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(35) + 1;
						String dropAt = "+Health";
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(250) +1;
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped nothing.");
					}
					
					int xp = generator.nextInt(5)+1;
					int xpStat = generator.nextInt(4)+1;
					if(xpStat ==1){
						System.out.println(Hell.name +"'s Strength incresed by " + xp);
						int newStrexp = xp + Hell.stre;
						Hell.stre = newStrexp;
					}
					else if(xpStat ==2){
						System.out.println(Hell.name +"'s Agility incresed by " + xp);
						int newAgixp = xp + Hell.agi;
						Hell.agi = newAgixp;
					}
					else if(xpStat ==3){
						System.out.println(Hell.name +"'s Intelligence incresed by " + xp);
						int newIntxp = xp + Hell.intel;
						Hell.intel = newIntxp;
					}
					else if(xpStat ==4){
						System.out.println(Hell.name +"'s Charisma incresed by " + xp);
						int newCharxp = xp + Hell.chari;
						Hell.chari = newCharxp;
					}
					
					battle = false;
				}
			
		}
			}
	
		}
		else if(battleChoice ==2){
			int random1 =  generator.nextInt(1000) +1;
			int random2 = generator.nextInt(20) +1;
			int dodge = (random1 / random2) - (Hell.agi + Hell.shoes);
			if(dodge <= 20){
				System.out.println(Hell.name + " dodged successfully.");
				int heal = generator.nextInt(30) +1;
				if(heal <= 25){
					int heal1 = generator.nextInt(20) +1;
					int newHp;
					System.out.println(Hell.name + " recovered " + heal1 + " Health after dodging.");
					if((Hell.hp + heal1) <= 100){
					newHp = Hell.hp + heal1;
					Hell.hp = newHp;
					}
					else if((Hell.hp + heal1) > 100){
						Hell.hp = 100;
					}
				
				}
				else if(heal > 25){
					
				}
			}
				else if(dodge > 20){
					System.out.println("Dodging Failed");
					Enemy.miss = generator.nextInt(5) + 1;
					
					if(miss > 1){
					Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
					Enemy.criticalHit = generator.nextInt(10) + 1;
					
					if(Enemy.criticalHit == 1){
						System.out.println("Critical Hit");
						Enemy.damage2p = Enemy.damage * 2;
					}
					else if(Enemy.criticalHit > 1){
						Enemy.damage2p = Enemy.damage;
					}
					
					System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
					if(Hell.hp <= 0){
						System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
						System.exit(0);
					}		
						
					}
					else if(miss == 1){
						System.out.println(Enemy.enemyName + "'s attack missed.");	
					}
					
				}
			
		}
		
		else if(battleChoice ==3){
			int random1 =  generator.nextInt(500) +1;
			int random2 = generator.nextInt(15) +1;
			int flee = (random1 / random2) - Hell.intel;
			if(flee <= 15){
				System.out.println(Hell.name + " escaped the battle.");
				battle = false;
			}
			else if(flee > 15){
				System.out.println(Hell.name + " failed to escape.");
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2p = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2p = Enemy.damage;
				}
				
				System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
				if(Hell.armor == 0){
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
				}
				else if((Hell.armor - Enemy.damage2p) >= 0){
					Enemy.newArmor = Hell.armor - Enemy.damage2p;
					Hell.armor = Enemy.newArmor;
				}
				else if((Hell.armor - Enemy.damage2p) < 0){
					Enemy.newArmor = Enemy.damage2p - Hell.armor;
					Enemy.newHp = Hell.hp - Enemy.newArmor;
					Hell.hp = Enemy.newHp;
					Hell.armor = 0;
					
				}
				
				if(Hell.hp <= 0){
					System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
					System.exit(0);
				}
				else if(Hell.hp > 0){
					
				}
				}
				else if(miss == 1){
					System.out.println(Enemy.enemyName + "'s attack missed.");
				}
			}
			
			
		}
		
		}
		System.out.println(Hell.name + "'s Post-Battle Stats");
		System.out.println("Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
	}
	
	public void battleLv3(){

		int enemyNameSel = generator.nextInt(6) + 1;
		boolean battle = true;
		
		
		
		if(enemyNameSel <= 2){
			Enemy.enemyName = "Demon";
		}
		
		else if(enemyNameSel == 3){
			Enemy.enemyName = "Three-headed Hell-hound";
		}
		
		else if(enemyNameSel == 4){
			Enemy.enemyName = "Tortured-soul";
		}
		
		else if(enemyNameSel == 5){
			Enemy.enemyName = "Wailing Banshee";
		}
		
		else if(enemyNameSel == 6){
			Enemy.enemyName = "Cursed Wraith";
		}
		
		Enemy.enemyHp = generator.nextInt(76) + 100;
		Enemy.enemyArmor = generator.nextInt(150);
		Enemy.enemyStre = generator.nextInt(20) + 15;
		Enemy.enemyAgi = generator.nextInt(17) + 7;
		
		System.out.println(Hell.name + " encountered a " + Enemy.enemyName);
		
		while(battle){
		
		System.out.println("<" + Enemy.enemyName + "'s Current Stats>	<" + Hell.name + "'s Current Stats>");
		System.out.println("Health <" +Enemy.enemyHp + ">	Agility <" + Enemy.enemyAgi + ">	Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + Enemy.enemyStre + ">	Armor <" + Enemy.enemyArmor + ">	Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("				Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("What will you do?		Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
		System.out.println("<1>Attack	<2>Dodge	<3>Flee");
		int battleChoice = input.nextInt();
		
		if(battleChoice == 1){
			
			
			if(Enemy.enemyAgi < (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
				}
		
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println("The " + Enemy.enemyName +"'s Health hit 0.");
					System.out.println("The " + Enemy.enemyName +" died.");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(150) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(20) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped nothing.");
					}
					
					
					int xp = generator.nextInt(10)+1;
					int xpStat = generator.nextInt(4)+1;
					if(xpStat ==1){
						System.out.println(Hell.name +"'s Strength incresed by " + xp);
						int newStrexp = xp + Hell.stre;
						Hell.stre = newStrexp;
					}
					else if(xpStat ==2){
						System.out.println(Hell.name +"'s Agility incresed by " + xp);
						int newAgixp = xp + Hell.agi;
						Hell.agi = newAgixp;
					}
					else if(xpStat ==3){
						System.out.println(Hell.name +"'s Intelligence incresed by " + xp);
						int newIntxp = xp + Hell.intel;
						Hell.intel = newIntxp;
					}
					else if(xpStat ==4){
						System.out.println(Hell.name +"'s Charisma incresed by " + xp);
						int newCharxp = xp + Hell.chari;
						Hell.chari = newCharxp;
					}
					
					
					battle = false;
				}
				else if(Enemy.enemyHp > 0){
		Enemy.miss = generator.nextInt(5) + 1;
			
			if(miss > 1){
			Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
			Enemy.criticalHit = generator.nextInt(10) + 1;
			
			if(Enemy.criticalHit == 1){
				System.out.println("Critical Hit");
				Enemy.damage2p = Enemy.damage * 2;
			}
			else if(Enemy.criticalHit > 1){
				Enemy.damage2p = Enemy.damage;
			}
			
			System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
			if(Hell.armor == 0){
				Enemy.newHp = Hell.hp - Enemy.damage2p;
				Hell.hp = Enemy.newHp;
			}
			else if((Hell.armor - Enemy.damage2p) >= 0){
				Enemy.newArmor = Hell.armor - Enemy.damage2p;
				Hell.armor = Enemy.newArmor;
			}
			else if((Hell.armor - Enemy.damage2p) < 0){
				Enemy.newArmor = Enemy.damage2p - Hell.armor;
				Enemy.newHp = Hell.hp - Enemy.newArmor;
				Hell.hp = Enemy.newHp;
				Hell.armor = 0;
				
			}
			
			if(Hell.hp <= 0){
				System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
				System.exit(0);
			}
			else if(Hell.hp > 0){
				
			}
			}
			else if(miss == 1){
				System.out.println(Enemy.enemyName + "'s attack missed.");
			}
			}
			}
			else if(Enemy.enemyAgi >= (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2p = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2p = Enemy.damage;
				}
				
				System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
				if(Hell.armor == 0){
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
				}
				else if((Hell.armor - Enemy.damage2p) >= 0){
					Enemy.newArmor = Hell.armor - Enemy.damage2p;
					Hell.armor = Enemy.newArmor;
				}
				else if((Hell.armor - Enemy.damage2p) < 0){
					Enemy.newArmor = Enemy.damage2p - Hell.armor;
					Enemy.newHp = Hell.hp - Enemy.newArmor;
					Hell.hp = Enemy.newHp;
					Hell.armor = 0;
					
				}
				
				}		
				
				else if(miss == 1){
					
					System.out.println(Enemy.enemyName + "'s attack missed.");
						
				}
				if(Hell.hp <= 0){
					System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
					System.exit(0);	
				}
				else if(Hell.hp > 0){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
		
			}
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println("The " + Enemy.enemyName +"'s Health hit 0.");
					System.out.println("The " + Enemy.enemyName +" died.");
					int battleDrop = generator.nextInt(10) +1;
					if(battleDrop == 1){
						int dropNamesel = generator.nextInt(5) + 1;
						String dropName = null;
						int drop = generator.nextInt(70) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(200) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(40) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(40) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(30) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(100) + 1;
						String dropAt = "+Health";
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(2000) +1;
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped nothing.");
					}
					
					int xp = generator.nextInt(20)+1;
					int xpStat = generator.nextInt(4)+1;
					if(xpStat ==1){
						System.out.println(Hell.name +"'s Strength incresed by " + xp);
						int newStrexp = xp + Hell.stre;
						Hell.stre = newStrexp;
					}
					else if(xpStat ==2){
						System.out.println(Hell.name +"'s Agility incresed by " + xp);
						int newAgixp = xp + Hell.agi;
						Hell.agi = newAgixp;
					}
					else if(xpStat ==3){
						System.out.println(Hell.name +"'s Intelligence incresed by " + xp);
						int newIntxp = xp + Hell.intel;
						Hell.intel = newIntxp;
					}
					else if(xpStat ==4){
						System.out.println(Hell.name +"'s Charisma incresed by " + xp);
						int newCharxp = xp + Hell.chari;
						Hell.chari = newCharxp;
					}
					
					
					battle = false;
				}
			
		}
			}
					
				}
		else if(battleChoice ==2){
			int random1 =  generator.nextInt(1000) +1;
			int random2 = generator.nextInt(20) +1;
			int dodge = (random1 / random2) - (Hell.agi + Hell.shoes);
			if(dodge <= 20){
				System.out.println(Hell.name + " dodged successfully.");
				int heal = generator.nextInt(30) +1;
				if(heal <= 25){
					int heal1 = generator.nextInt(20) +1;
					int newHp;
					System.out.println(Hell.name + " recovered " + heal1 + " Health after dodging.");
					if((Hell.hp + heal1) <= 100){
					newHp = Hell.hp + heal1;
					Hell.hp = newHp;
					}
					else if((Hell.hp + heal1) > 100){
						Hell.hp = 100;
					}
				
				}
				else if(heal > 25){
					
				}
			}
				else if(dodge > 20){
					System.out.println("Dodging Failed");
					Enemy.miss = generator.nextInt(5) + 1;
					
					if(miss > 1){
					Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
					Enemy.criticalHit = generator.nextInt(10) + 1;
					
					if(Enemy.criticalHit == 1){
						System.out.println("Critical Hit");
						Enemy.damage2p = Enemy.damage * 2;
					}
					else if(Enemy.criticalHit > 1){
						Enemy.damage2p = Enemy.damage;
					}
					
					System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
					if(Hell.hp <= 0){
						System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
						System.exit(0);
					}		
						
					}
					else if(miss == 1){
						System.out.println(Enemy.enemyName + "'s attack missed.");	
					}
					
				}
			
		}
		
		else if(battleChoice ==3){
			int random1 =  generator.nextInt(500) +1;
			int random2 = generator.nextInt(15) +1;
			int flee = (random1 / random2) - Hell.intel;
			if(flee <= 15){
				System.out.println(Hell.name + " escaped the battle.");
				battle = false;
			}
			else if(flee > 15){
				System.out.println(Hell.name + " failed to escape.");
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2p = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2p = Enemy.damage;
				}
				
				System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
				if(Hell.armor == 0){
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
				}
				else if((Hell.armor - Enemy.damage2p) >= 0){
					Enemy.newArmor = Hell.armor - Enemy.damage2p;
					Hell.armor = Enemy.newArmor;
				}
				else if((Hell.armor - Enemy.damage2p) < 0){
					Enemy.newArmor = Enemy.damage2p - Hell.armor;
					Enemy.newHp = Hell.hp - Enemy.newArmor;
					Hell.hp = Enemy.newHp;
					Hell.armor = 0;
					
				}
				
				if(Hell.hp <= 0){
					System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
					System.exit(0);
				}
				else if(Hell.hp > 0){
					
				}
				}
				else if(miss == 1){
					System.out.println(Enemy.enemyName + "'s attack missed.");
				}
			}
			
			
		}
		
		}
		System.out.println(Hell.name + "'s Post-Battle Stats");
		System.out.println("Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
	}

	public void battleMimic(){

		boolean battle = true;
		
		Enemy.enemyName ="Mimic";
		Enemy.enemyHp = 100;
		Enemy.enemyArmor = 0;
		Enemy.enemyStre = generator.nextInt(15) + 10;
		Enemy.enemyAgi = generator.nextInt(15) + 5;
		
		
		while(battle){
		
		System.out.println("<Mimic's Current Stats>	<" + Hell.name + "'s Current Stats>");
		System.out.println("Health <" +Enemy.enemyHp + ">	Agility <" + Enemy.enemyAgi + ">	Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + Enemy.enemyStre + ">	Armor <" + Enemy.enemyArmor + ">	Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("				Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("What will you do?		Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
		System.out.println("<1>Attack	<2>Dodge	<3>Flee");
		int battleChoice = input.nextInt();
		
		if(battleChoice == 1){
			
			
			if(Enemy.enemyAgi < (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
				}
		
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println("The " + Enemy.enemyName +"'s Health hit 0.");
					System.out.println("The " + Enemy.enemyName +" died.");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(150) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						int drop = generator.nextInt(20) + 1;
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped");
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
						System.out.println("The " + Enemy.enemyName + " dropped nothing.");
					}
					
					
					int xp = generator.nextInt(10)+1;
					int xpStat = generator.nextInt(4)+1;
					if(xpStat ==1){
						System.out.println(Hell.name +"'s Strength incresed by " + xp);
						int newStrexp = xp + Hell.stre;
						Hell.stre = newStrexp;
					}
					else if(xpStat ==2){
						System.out.println(Hell.name +"'s Agility incresed by " + xp);
						int newAgixp = xp + Hell.agi;
						Hell.agi = newAgixp;
					}
					else if(xpStat ==3){
						System.out.println(Hell.name +"'s Intelligence incresed by " + xp);
						int newIntxp = xp + Hell.intel;
						Hell.intel = newIntxp;
					}
					else if(xpStat ==4){
						System.out.println(Hell.name +"'s Charisma incresed by " + xp);
						int newCharxp = xp + Hell.chari;
						Hell.chari = newCharxp;
					}
					
					
					battle = false;
				}
				else if(Enemy.enemyHp > 0){
		Enemy.miss = generator.nextInt(5) + 1;
			
			if(miss > 1){
			Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
			Enemy.criticalHit = generator.nextInt(10) + 1;
			
			if(Enemy.criticalHit == 1){
				System.out.println("Critical Hit");
				Enemy.damage2p = Enemy.damage * 2;
			}
			else if(Enemy.criticalHit > 1){
				Enemy.damage2p = Enemy.damage;
			}
			
			System.out.println("Mimic attacked for " + Enemy.damage2p + " Damage.");
			if(Hell.armor == 0){
				Enemy.newHp = Hell.hp - Enemy.damage2p;
				Hell.hp = Enemy.newHp;
			}
			else if((Hell.armor - Enemy.damage2p) >= 0){
				Enemy.newArmor = Hell.armor - Enemy.damage2p;
				Hell.armor = Enemy.newArmor;
			}
			else if((Hell.armor - Enemy.damage2p) < 0){
				Enemy.newArmor = Enemy.damage2p - Hell.armor;
				Enemy.newHp = Hell.hp - Enemy.newArmor;
				Hell.hp = Enemy.newHp;
				Hell.armor = 0;
				
			}
			
			if(Hell.hp <= 0){
				System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
				System.exit(0);
			}
			else if(Hell.hp > 0){
				
			}
			}
			else if(miss == 1){
				System.out.println("Mimic's attack missed.");
			}
			}
			}
			else if(Enemy.enemyAgi >= (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2p = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2p = Enemy.damage;
				}
				
				System.out.println("Mimic attacked for " + Enemy.damage2p + " Damage.");
				if(Hell.armor == 0){
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
				}
				else if((Hell.armor - Enemy.damage2p) >= 0){
					Enemy.newArmor = Hell.armor - Enemy.damage2p;
					Hell.armor = Enemy.newArmor;
				}
				else if((Hell.armor - Enemy.damage2p) < 0){
					Enemy.newArmor = Enemy.damage2p - Hell.armor;
					Enemy.newHp = Hell.hp - Enemy.newArmor;
					Hell.hp = Enemy.newHp;
					Hell.armor = 0;
					
				}
				}		
				
				else if(miss == 1){
					
					System.out.println("Mimic's attack missed.");
						
				}
				if(Hell.hp <= 0){
					System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
					System.exit(0);	
				}
				else if(Hell.hp > 0){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
		
			}
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println("The Mimic's Health hit 0.");
					System.out.println("The Mimic died.");
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
						System.out.println("The Mimic dropped");
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
						int drop = generator.nextInt(150) + 1;
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
						System.out.println("The Mimic dropped");
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
						System.out.println("The Mimic dropped");
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
						System.out.println("The Mimic dropped");
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
						int drop = generator.nextInt(20) + 1;
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
						System.out.println("The Mimic dropped");
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
						System.out.println("The Mimic dropped");
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
						System.out.println("The Mimic dropped");
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
						System.out.println("The Mimic dropped nothing.");
					}
					
					int xp = generator.nextInt(15)+1;
					int xpStat = generator.nextInt(4)+1;
					if(xpStat ==1){
						System.out.println(Hell.name +"'s Strength incresed by " + xp);
						int newStrexp = xp + Hell.stre;
						Hell.stre = newStrexp;
					}
					else if(xpStat ==2){
						System.out.println(Hell.name +"'s Agility incresed by " + xp);
						int newAgixp = xp + Hell.agi;
						Hell.agi = newAgixp;
					}
					else if(xpStat ==3){
						System.out.println(Hell.name +"'s Intelligence incresed by " + xp);
						int newIntxp = xp + Hell.intel;
						Hell.intel = newIntxp;
					}
					else if(xpStat ==4){
						System.out.println(Hell.name +"'s Charisma incresed by " + xp);
						int newCharxp = xp + Hell.chari;
						Hell.chari = newCharxp;
					}
					
					
					battle = false;
				}
			
		}
			}
		}
		else if(battleChoice ==2){
			int random1 =  generator.nextInt(1000) +1;
			int random2 = generator.nextInt(20) +1;
			int dodge = (random1 / random2) - (Hell.agi + Hell.shoes);
			if(dodge <= 20){
				System.out.println(Hell.name + " dodged successfully.");
				int heal = generator.nextInt(30) +1;
				if(heal <= 25){
					int heal1 = generator.nextInt(20) +1;
					int newHp;
					System.out.println(Hell.name + " recovered " + heal1 + " Health after dodging.");
					if((Hell.hp + heal1) <= 100){
					newHp = Hell.hp + heal1;
					Hell.hp = newHp;
					}
					else if((Hell.hp + heal1) > 100){
						Hell.hp = 100;
					}
				
				}
				else if(heal > 25){
					
				}
			}
				else if(dodge > 20){
					System.out.println("Dodging Failed");
					Enemy.miss = generator.nextInt(5) + 1;
					
					if(miss > 1){
					Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
					Enemy.criticalHit = generator.nextInt(10) + 1;
					
					if(Enemy.criticalHit == 1){
						System.out.println("Critical Hit");
						Enemy.damage2p = Enemy.damage * 2;
					}
					else if(Enemy.criticalHit > 1){
						Enemy.damage2p = Enemy.damage;
					}
					
					System.out.println("Mimic attacked for " + Enemy.damage2p + " Damage.");
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
					if(Hell.hp <= 0){
						System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
						System.exit(0);
					}		
						
					}
					else if(miss == 1){
						System.out.println("Mimic's attack missed.");	
					}
					
				}
			
		}
		
		else if(battleChoice ==3){
			int random1 =  generator.nextInt(500) +1;
			int random2 = generator.nextInt(15) +1;
			int flee = (random1 / random2) - Hell.intel;
			if(flee <= 15){
				System.out.println(Hell.name + " escaped the battle.");
				battle = false;
			}
			else if(flee > 15){
				System.out.println(Hell.name + " failed to escape.");
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2p = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2p = Enemy.damage;
				}
				
				System.out.println("Mimic attacked for " + Enemy.damage2p + " Damage.");
				if(Hell.armor == 0){
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
				}
				else if((Hell.armor - Enemy.damage2p) >= 0){
					Enemy.newArmor = Hell.armor - Enemy.damage2p;
					Hell.armor = Enemy.newArmor;
				}
				else if((Hell.armor - Enemy.damage2p) < 0){
					Enemy.newArmor = Enemy.damage2p - Hell.armor;
					Enemy.newHp = Hell.hp - Enemy.newArmor;
					Hell.hp = Enemy.newHp;
					Hell.armor = 0;
					
				}
				
				if(Hell.hp <= 0){
					System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
					System.exit(0);
				}
				else if(Hell.hp > 0){
					
				}
				}
				else if(miss == 1){
					System.out.println("Mimic's attack missed.");
				}
			}
			
			
		}
	
		}
		System.out.println(Hell.name + "'s Post-Battle Stats");
		System.out.println("Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
	}

	public void Boss(){

		
		boolean battle = true;
		
		Enemy.enemyName = "The Devil";
		
		Enemy.enemyHp = 1000;
		Enemy.enemyArmor = 200;
		Enemy.enemyStre = generator.nextInt(31) + 30;
		Enemy.enemyAgi = generator.nextInt(31) + 20;
		
		System.out.println(Hell.name + " entered a large room.");
		System.out.println("The ceiling is high and the room is very well lit by fire-light.");
		System.out.println("There is a large creature in the center of the room.");
		System.out.println("It approaches you.");
		System.out.println(Hell.name + " encountered " + Enemy.enemyName);
		
		while(battle){
		
		System.out.println("<" + Enemy.enemyName + "'s Current Stats>	<" + Hell.name + "'s Current Stats>");
		System.out.println("Health <" +Enemy.enemyHp + ">	Agility <" + Enemy.enemyAgi + ">	Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + Enemy.enemyStre + ">	Armor <" + Enemy.enemyArmor + ">	Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("				Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("What will you do?		Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
		System.out.println("<1>Attack	<2>Dodge	<3>Flee");
		int battleChoice = input.nextInt();
		
		if(battleChoice == 1){
			
			
			if(Enemy.enemyAgi < (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
				}
		
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println(Enemy.enemyName +"'s Health hit 0.");
					System.out.println(Enemy.enemyName +" died.");
					
					System.out.println("Congratulations, You have defeated me.");
					System.out.println("I will alow you to return to the world of the living.");
					break;
				}
				else if(Enemy.enemyHp >0){
		Enemy.miss = generator.nextInt(5) + 1;
			
			if(miss > 1){
			Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
			Enemy.criticalHit = generator.nextInt(10) + 1;
			
			if(Enemy.criticalHit == 1){
				System.out.println("Critical Hit");
				Enemy.damage2p = Enemy.damage * 2;
			}
			else if(Enemy.criticalHit > 1){
				Enemy.damage2p = Enemy.damage;
			}
			
			System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
			if(Hell.armor == 0){
				Enemy.newHp = Hell.hp - Enemy.damage2p;
				Hell.hp = Enemy.newHp;
			}
			else if((Hell.armor - Enemy.damage2p) >= 0){
				Enemy.newArmor = Hell.armor - Enemy.damage2p;
				Hell.armor = Enemy.newArmor;
			}
			else if((Hell.armor - Enemy.damage2p) < 0){
				Enemy.newArmor = Enemy.damage2p - Hell.armor;
				Enemy.newHp = Hell.hp - Enemy.newArmor;
				Hell.hp = Enemy.newHp;
				Hell.armor = 0;
				
			}
			
			if(Hell.hp <= 0){
				System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
				System.exit(0);
			}
			else if(Hell.hp > 0){
				
			}
			}
			else if(miss == 1){
				System.out.println(Enemy.enemyName + "'s attack missed.");
			}
			}
			}
			else if(Enemy.enemyAgi >= (Hell.agi + Hell.shoes)){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2p = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2p = Enemy.damage;
				}
				
				System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
				if(Hell.armor == 0){
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
				}
				else if((Hell.armor - Enemy.damage2p) >= 0){
					Enemy.newArmor = Hell.armor - Enemy.damage2p;
					Hell.armor = Enemy.newArmor;
				}
				else if((Hell.armor - Enemy.damage2p) < 0){
					Enemy.newArmor = Enemy.damage2p - Hell.armor;
					Enemy.newHp = Hell.hp - Enemy.newArmor;
					Hell.hp = Enemy.newHp;
					Hell.armor = 0;
					
				}
				}		
				
				else if(miss == 1){
					
					System.out.println(Enemy.enemyName + "'s attack missed.");
						
				}
				if(Hell.hp <= 0){
					System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
					System.exit(0);	
				}
				else if(Hell.hp > 0){
				Enemy.miss = generator.nextInt(5) + 1;
				
				if(miss > 1){
				Enemy.damage = generator.nextInt(11) + (Hell.stre + Hell.weapon);
				Enemy.criticalHit = generator.nextInt(10) + 1;
				
				if(Enemy.criticalHit == 1){
					System.out.println("Critical Hit");
					Enemy.damage2e = Enemy.damage * 2;
				}
				else if(Enemy.criticalHit > 1){
					Enemy.damage2e = Enemy.damage;
				}
				
				System.out.println(Hell.name + " attacked for " + Enemy.damage2e + " Damage.");
				if(Enemy.enemyArmor == 0){
					Enemy.newHp = Enemy.enemyHp - Enemy.damage2e;
					Enemy.enemyHp = Enemy.newHp;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) >= 0){
					Enemy.newArmor = Enemy.enemyArmor - Enemy.damage2e;
					Enemy.enemyArmor = Enemy.newArmor;
				}
				else if((Enemy.enemyArmor - Enemy.damage2e) < 0){
					Enemy.newArmor = Enemy.damage2e - Enemy.enemyArmor;
					Enemy.newHp = Enemy.enemyHp - Enemy.newArmor;
					Enemy.enemyHp = Enemy.newHp;
					Enemy.enemyArmor = 0;
					
				}
				
		
			}
			else if(miss == 1){
				System.out.println(Hell.name + "'s attack missed.");
			}
				if(Enemy.enemyHp <= 0){
					System.out.println(Enemy.enemyName +"'s Health hit 0.");
					System.out.println(Enemy.enemyName +" died.");
					
					System.out.println("Congratulations, You have defeated me.");
					System.out.println("I will alow you to return to the world of the living.");
					break;
				}
		}
			}
		}
		else if(battleChoice ==2){
			int random1 =  generator.nextInt(1000) +1;
			int random2 = generator.nextInt(20) +1;
			int dodge = (random1 / random2) - (Hell.agi + Hell.shoes);
			if(dodge <= 20){
				System.out.println(Hell.name + " dodged successfully.");
				int heal = generator.nextInt(30) +1;
				if(heal <= 25){
					int heal1 = generator.nextInt(20) +1;
					int newHp;
					System.out.println(Hell.name + " recovered " + heal1 + " Health after dodging.");
					if((Hell.hp + heal1) <= 100){
					newHp = Hell.hp + heal1;
					Hell.hp = newHp;
					}
					else if((Hell.hp + heal1) > 100){
						Hell.hp = 100;
					}
				
				}
				else if(heal > 25){
					
				}
			}
				else if(dodge > 20){
					System.out.println("Dodging Failed");
					Enemy.miss = generator.nextInt(5) + 1;
					
					if(miss > 1){
					Enemy.damage = generator.nextInt(11) + Enemy.enemyStre;
					Enemy.criticalHit = generator.nextInt(10) + 1;
					
					if(Enemy.criticalHit == 1){
						System.out.println("Critical Hit");
						Enemy.damage2p = Enemy.damage * 2;
					}
					else if(Enemy.criticalHit > 1){
						Enemy.damage2p = Enemy.damage;
					}
					
					System.out.println(Enemy.enemyName + " attacked for " + Enemy.damage2p + " Damage.");
					Enemy.newHp = Hell.hp - Enemy.damage2p;
					Hell.hp = Enemy.newHp;
					if(Hell.hp <= 0){
						System.out.println("GAME OVER " + Hell.name +"'s Health hit 0.");
						System.exit(0);
					}		
						
					}
					else if(miss == 1){
						System.out.println(Enemy.enemyName + "'s attack missed.");	
					}
					
				}
			
		}
		
		else if(battleChoice ==3){
			System.out.println("You can't run from a Boss battle.");
		}
		}
		
		System.out.println(Hell.name + "'s Post-Game Stats");
		System.out.println("Health <" +Hell.hp + ">	Agility <" + (Hell.agi + Hell.shoes) + ">");
		System.out.println("Strength <" + (Hell.stre + Hell.weapon) + ">	Intelligence <" + Hell.intel + ">");
		System.out.println("Charisma <" + (Hell.chari + Hell.clothes) + ">	Luck = " + Hell.luck );
		System.out.println("Armor <" + Hell.armor + ">	Gold <" + Hell.gold + ">");
		System.out.println("	WINNER!!!");
		System.exit(0);
	}

}
