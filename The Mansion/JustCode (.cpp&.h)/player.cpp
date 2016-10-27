#include <iostream>
#include <string>
#include "player.h"
#include "item.h"

using namespace std;

player::player(){
}
player::~player(){
}


void player::updateXY(int x, int y){
	posX = x;
	posY = y;
}
void player::dispInven(){
	cout << "Inventory: " << endl;
	for (int i = 0; i < 30; i++){
		if (inventory[i].getName() == "");
		else{
			if (i == 29){
				cout << "\nInventory Full" << endl;
			}
			else{
				cout << inventory[i].getName() << ", ";
			}
		}
	}
	cout << "\n" << endl;
}
bool player::addInven(item in){
	int qw = 0;
	for (int f = 0; f < 30;f++){
		if (inventory[f].getName() == ""){
			inventory[f] = in;
			qw++;
			f = 30;
		}
	}
	if (qw <= 0){
		cout << "Inventory Full" << endl;
		return false;
	}
	else{
		cout << in.getName() << " obtained." << endl;
		return true;
	}
}

bool player::isInInven(string in){
	for (int r = 0; r < 30; r++){
		if (inventory[r].getName() == in){
			return true;
		}
	}
	return false;
}
item player::getItm(string in){
	for (int r = 0; r < 30; r++){
		if (inventory[r].getName() == in){
			return inventory[r];
		}
	}
	return inventory[0];
}