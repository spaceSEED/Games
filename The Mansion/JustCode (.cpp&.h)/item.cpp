#include "item.h"
#include <string>
#include <iostream>
#include "item2.h"

using namespace std;


item::item()
{
}
item::item(bool take,string nm, bool con){
	takeable = take;
	name = nm;
	container = con;
	if (name=="shoes"&&!con){
		descr = "These are just normal shoes. They look pretty clean but smell terrible.";
	}
	else if (name == "umbrella"&&!con){
		descr = "This is just a normal umbrella. It's dry, because it hasn't rained for a while.";
	}
	else if (name == "fruit-bowl"&&!con){
		descr = "This is just a bowl of fruit. They look real but I don't want to risk eating them.";
	}
	else if (name == "pot"&&!con){
		descr = "This is just a pot. There's nothing in it. It was either going to be used\nor put out for decoration.";
	}
	else if (name == "food-scraps"&&!con){
		descr = "These food scraps were all over the room and the victim. They were probably scattered\nin the struggle.The culprit could have some of these on him.";
	}
	else if (name == "grass"&&!con){
		descr = "This is just normal grass.";
	}
	else if (name == "rock"&&!con){
		descr = "This is just a normal rock.";
	}
	else if (name == "weed"&&!con){
		descr = "I guess the lawn wasn't as well kept as it looked. This is a pretty big weed.";
	}
	else if (name == "flower"&&!con){
		descr = "This is a nice flower. There are a bunch here; maybe no-one would notice if one went missing.";
	}
	else if (name == "bullet-casing"&&!con){
		descr = "I guess the culprit forgot to clean this up. All we need now is the matching gun.";
	}
	else if (name == "book"&&!con){
		descr = "It looks kinda' interesting. I guess there are people who would read this, not that I would.";
	}
	else if (name == "glass"&&!con){
		descr = "Did the victim drink water before bed?";
	}
	else if (name == "lamp"&&!con){
		descr = "Usually there's something suspicious with the lamp, but this one doesn't hold any evidence.";
	}
	else if (name == "junk"&&!con){
		descr = "Just random items found under the furniture.";
	}
	else if (name == "pen"&&!con){
		descr = "This must be the victim's pen. It's pretty chewed up; I guess that was their habit.";
	}
	else if (name == "ink-well"&&!con){
		descr = "I don't think I could ever use a fountain pen, it's too messy.";
	}
	else if (name == "pencil"&&!con){
		descr = "This is just a normal pencil. It's pretty chewed up though.";
	}
	else if (name == "tp"&&!con){
		descr = "This is just normal toilet paper. There's nothing suspicious about toilet paper.";
	}
	else if (name == "razor"&&!con){
		descr = "This is just a normal razor. It would be hard to kill somebody with this.";
	}
	else if (name == "shaving-cream"&&!con){
		descr = "This is nothing but normal shaving cream.";
	}
	else if (name == "toothpaste"&&!con){
		descr = "This is nothing but normal toothpaste.";
	}
	else if (name == "toothbrush"&&!con){
		descr = "This is just a normal toothbrush. The bristles are pretty worm out.\nI guess the owner wasn't fond of buying new ones that often.";
	}
	else if (name == "toaster"&&!con){
		descr = "The culprit must have forced his way in, plugged this in, and then\nthrew it into the tub. Either the victim was okay with the culprit being in the restroom with them\nor they weren't able to notice.";
	}
	else if (name == "books"&&!con){
		descr = "This is a stack of normal books. Some of these look interesting,\nI wouldn't mind reading them.";
	}
	else if (name == "encyclopedia"&&!con){
		descr = "This is not a normal encyclopedia. It's all about cockroaches.";
	}
	else if (name == "dictionary"&&!con){
		descr = "This is just a conventional dictionary. I wonder if there are\nany other good words for \"normal\" in here.";
	}
	else if (name == "atlas"&&!con){
		descr = "This is just a normal atlas. It's mainly maps of countries and has no local maps.";
	}
	else if (name == "globe"&&!con){
		descr = "This is just a normal globe. It's pretty fancy though.";
	}
	else if (name == "coffee"&&!con){
		descr = "The victim was drinking his when he died. It may be poisoned.";
	}

	else if (name == "photo"&&!con){
		descr = "This is a very 'personal' photograph of the maid. This would be a good motive for murder.";
	}
	else if (name == "glove"&&!con){
		string cerp;
		if (wep == "poison"){
			cerp = "poison";
		}
		else{
			cerp = "victim's blood";
		}
		descr = "This is the butler's glove. It has traces of the "+cerp +" on it.";
	}
	else if (name == "apron"&&!con){
		string cerp;
		if (wep == "poison"){
			cerp = "poison";
		}
		else{
			cerp = "victim's blood";
		}
		descr = "This is the maid's apron. It has traces of the " + cerp + " on it.";
	}
	else if (name == "potting-soil"&&!con){
		descr = "This is strange. The gardener claimed he never entered the house.";
	}
	else if (name == "file"&&!con){
		descr = "This file contains information on the butler and insurance fraud.";
	}
	else if (name == "address-book"&&!con){
		descr = "This is the victim's. It contains the contact info for countless women. He was having affairs.";
	}
	else if (name == "check-book"&&!con){
		descr = "This is the victim's. It's filled with the son's purchases.";
	}
	else if (name == "report-card"&&!con){
		descr = "This is the son's. His grades are terrible. Is it possible to murder someone because of this?";
	}
	else if (name == "necklace"&&!con){
		descr = "This is an expensive necklace, probably the wife's. Why would this be here?";
	}
	else if (name == "knife"&&!con){
		descr = "This bloody knife is probably the murder weapon.";
	}
	else if (name == "pan"&&!con){
		descr = "This pan has blood on it. It must be the murder weapon.";
	}
	else if (name == "gun"&&!con){
		descr = "This gun smells like it's been fired recently. It may have been used in the murder.";
	}
	else if (name == "poison"&&!con){
		descr = "This is likely to be the poison used in the murder.";
	}
	else if (name == "necklace"&&!con){
		descr = "This is an expensive necklace. Why would this be here?";
	}
	else if (name == "brick"&&!con) {
		descr = "This blunt brick is covered with blood. This must be the weapon.";
	}

	else if (name == "chair"&&con){
		descr = "This is a nice chair. There may be something under it.";
	}
	else if (name == "couch"&&con){
		descr = "This is a nice couch. There may be something under it.";
	}
	else if ((name == "side-table"&&con) || (name == "cabinets"&&con) || (name == "drawers"&&con) || (name == "file-cabinets"&&con) || (name == "mirror"&&con)){
		descr = "Maybe I should look inside.";
	}
	else if (name == "fire-place"&&con){
		descr = "This is a big fire-place. You could probably hide something in it.";
	}

	else if (name == "change"&&!con){
		descr = "Look at all of these loose coins. I probably shouldn't take them.";
	}
	else if (name == "old-toy"&&!con){
		descr = "Sad. These old, forgotten toys have probably been here for ages.";
	}
	else if (name == "plates"&&!con){
		descr = "Just normal plates.";
	}
	else if (name == "forks"&&!con){
		descr = "Look at all of these forks.";
	}
	else if (name == "spoons"&&!con){
		descr = "Look at all of these spoons.";
	}
	else if (name == "papers"&&!con){
		descr = "These are just normal papers.";
	}
	else if (name == "contracts"&&!con){
		descr = "These look important.";
	}
}
item::~item()
{
}

string item::getName(){
	return name;
}
string item::getDescrip(){
	return descr;
}
bool item::getTakeable(){
	return takeable;
}
bool item::getCont(){
	return container;
}

void item::fillContainer(){///need to finish///
	if (container){
		if (name=="chair"){
			cntItm[0] = item2(true, "dust-bunny");
			cntItm[1] = item2(true, "junk");
		}
		else if (name == "side-table"){
			cntItm[0] = item2(true, "glasses");
			cntItm[1] = item2(true, "change");
		}
		else if (name == "file-cabinets"){
			cntItm[0] = item2(true, "papers");
			cntItm[1] = item2(true, "contracts");
		}
		else if (name == "couch"){
			cntItm[0] = item2(true, "old-toy");
			cntItm[1] = item2(true, "change");
		}
		else if (name == "mirror"){
			cntItm[0] = item2(true, "toothpaste");
			cntItm[1] = item2(true, "toothbrush");
		}
		else if (name == "couch"){
			cntItm[0] = item2(true, "old-toy");
			cntItm[1] = item2(true, "change");
		}
		else if (name == "cabinets"){
			cntItm[0] = item2(true, "pot");
			cntItm[1] = item2(true, "plates");
		}
		else if (name == "cabinet"){
			cntItm[0] = item2(true, "razor");
			cntItm[1] = item2(true, "shaving-cream");
		}
		else if (name == "drawers"){
			cntItm[0] = item2(true, "forks");
			cntItm[1] = item2(true, "spoons");
		}
		
	}
}
item2 item::getItm(string in){
	for (int r = 0; r < 10; r++){
		if (cntItm[r].getName() == in){
			return cntItm[r];
		}
	}
	return cntItm[0];
}
void item::dispItms(){
	cout << "Items in the "<<name<<":"<< endl;
	for (int i = 0; i < 10; i++){
		if (cntItm[i].getName() == "");
		else{
			cout << cntItm[i].getName() << ", ";
		}
	}
	cout << "\n" << endl;
}

void item::setWep(string in){
	wep = in;
}

void item::addItm(item2 ast){
	for (int er = 0; er < 10; er++){
		if (cntItm[er].getName() == ""){
			cntItm[er] = ast;
			er = 10;
		}
	}
}
void item::remItm(string das){
	for (int qwerty = 0; qwerty < 10; qwerty++){
		if (container){
			if (cntItm[qwerty].getName() == das){
					cntItm[qwerty] = item2(false, "");
			}
		}
	}
}