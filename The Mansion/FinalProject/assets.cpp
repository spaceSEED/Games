#include <iostream>
#include <string>
#include "assets.h"

using namespace std;

assets::assets(){
}
assets::~assets(){
}

	void assets::help(){
		cout << "move: type \"move\" and any direction to move in that direction\nlook: type \"look\" to get a description of the room\n   \"look\" and the name of an item in the room or inventory to get a description\nsearch: type \"search\" for a list of interactive items in the room\n   \"search\" and an item name to get a list of items inside of it\ninventory: type \"inven\" or \"inventory\" to see your inventory items\ntake: type \"take\" and an item name to add it to inventory\naccuse: type \"accuse\" to enter accuse mode and attempt to finish the game\n   you need to have the weapon and evidence in your inventory to succeed" << endl;
	}
	void assets::command(){
		cout << "Commands: help, move, look, search, inventory, take, accuse" << endl;
	}
	string assets::rmv(string rem, string full){
		return full.replace(full.find(rem), rem.length(), "");
	}