#include "room.h"
#include <iostream>
#include <string>
#include <stdlib.h>
#include "item.h"
#include "suspect.h"
#include "item2.h"
#include <time.h>

using namespace std;

room::room(string nm)
{
	name = nm;
	if (name == "Entry"){
		desc = "The suspects are all gathered here, along with them are other officers.";
	}
	else if (name=="Bedrm"){
		desc = "The bed seems well made and the bed side tables are fairly organized.";
	}
	else if (name == "Bathrm"){
		desc = "It seems clean enough, but I wouldn't feel safe using\nthe toilet in a murder victims home.";
	}
	else if (name == "Living"){
		desc = "Looks comfy. The large TV and furniture would make this\na great place for having people over.";
	}
	else if (name == "Yard"){
		desc = "Grass, rocks and stuff. It looks like it's been mowed recently.";
	}
	else if (name == "Library"){
		desc = "This is an impressive collection of books. I wonder if\nthe victim actually read all of these.";
	}
	else if (name=="Kitch"){
		desc = "I'm hungry. I'd better not eat anything that could be evidence though...";
	}
	else if (name == "Study"){
		desc = "This is a spacious workplace. Everything is so well organized and clean.";
	}
}

room::room(){
	name = "";
}
room::~room()
{
}

string room::getRName(){
	return name;
}
bool room::isEmpty(){
	if (name == ""){
		return true;
	}
	return false;
}
void room::addCorpse(){
	corpse = true;
	
}
bool room::hasCorpse() {
	return corpse;
}
void room::caseType(){
	if (corpse&&name == "Bedrm"){
		desc = "The victim lays face-down on the blood-soaked sheets.\nThere are multiple stab wounds in his back.\nThe rest of the room is surprisingly tidy, but there are signs of a struggle.\nThe bedside table close to the victim is in disarray.\nThe lamp has been broken and blood is visble on many of the objects.\n";
		weapon = "knife";
	}
	else if (corpse&&name == "Kitch"){
		desc = "The victim lays face down on the floor.\nThere's blunt-force trauma on the back of the head and bruises on the arms.\nThe food scattered on the floor from the counter also support\nthe idea of a struggle. The object used in the murder is not in this room.\n";
		if (rand() % 10 > 5){
			weapon = "brick";
		}
		else{
			weapon = "pan";
		}
	}
	else if (corpse&&name == "Study"){
		desc = "The victim lays dead at their desk.\nThe cause of death was poison.\nWhat kind and how it was administered is unknown.\nIt feels like something is missing from this room.\n";
		weapon = "poison";
	}
	else if (corpse&&name == "Yard"){
		desc = "The victim's body lays back-down on the grass.\nThere are two gun shot wounds to the front of the victim's torso.\nThe weapon is not here, but one shell has been recovered.\nThe bullet won't recovered until the autopsy.\n";
		weapon= "gun";
	}
	else if (corpse&&name == "Entry"){
		desc = "The victim's body lays face-down beside the front door to the house.\nTher are multiple stab wounds on both sides of the torso.\nThe suspects and other officers are all nearby.\n";
		weapon ="knife";
	}
	else if (corpse&&name == "Bathrm"){
		desc = "The victim lays in the bathtub with a toaster in the water.\nThe door's lock shows signs of a forced entry and \ntoasters are not normally found in bathrooms.\n";
		weapon = "toaster";
	}
	else if (corpse&&name == "Living"){
		desc = "There is a vast amount of blood staining the furniture of this room.\nThe victim lies limp on the couch facing the coffee table.\nHe was killed by an execution-style, shot to the back of the head.\nNo bullet casings were left behind and the murder\n weapon is not here.\n";
		weapon = "gun";
	}
	else if (corpse&&name == "Library"){
		desc = "The victim sits in an armchair, almost as if he's asleep, amongst the walls of books.\nThe cause of death appears to be a poisoning of some kind.\n";
		weapon = "poison";

	}
}

string room::getDescription(){
	return desc;
}

void room::fillWItems(){
	if(name=="Entry"){
		rmItms[0] = item(true,"shoes", false);
		rmItms[1] = item(true,"umbrella", false);
	}
	else if(name=="Kitch"){
		rmItms[0] = item(true,"fruit-bowl", false);
		rmItms[1] = item(false,"cabinets", true);
		rmItms[1].fillContainer();
		rmItms[2] = item(false, "drawers", true);
		rmItms[2].fillContainer();
		rmItms[3] = item(true, "pot", false);
		if (corpse){
			rmItms[4] = item(true, "food-scraps", false);
		}
	}
	else if(name=="Yard"){
		rmItms[0] = item(true, "grass", false);
		rmItms[1] = item(true, "rock", false);
		rmItms[2] = item(true, "weed", false);
		rmItms[3] = item(true, "flower", false);
		if (corpse){
			rmItms[4] = item(true, "bullet-casing", false);
		}
	}
	else if(name=="Study"){
		rmItms[0] = item(true, "book", false);
		rmItms[1] = item(true, "pen", false);
		rmItms[2] = item(true, "ink-well", false);
		rmItms[3] = item(true, "pencil", false);
		rmItms[4] = item(false, "desk", true);
		rmItms[4].fillContainer();
		rmItms[5] = item(false, "file-cabinets", true);
		rmItms[5].fillContainer();
	}
	else if (name == "Bedrm"){
		rmItms[0] = item(true, "book", false);
		rmItms[1] = item(true, "glass", false);
		rmItms[2] = item(true, "lamp", false);
		rmItms[3] = item(false, "side-table", true);
		rmItms[3].fillContainer();
		rmItms[4] = item(false, "bed", true);
		rmItms[4].fillContainer();
	}
	else if (name=="Bathrm"){
		rmItms[0] = item(true, "tp", false);
		rmItms[1] = item(false, "mirror", true);
		rmItms[1].fillContainer();
		rmItms[2] = item(false, "cabinet", true);
		rmItms[2].fillContainer();
		if (corpse){
			rmItms[3] = item(true, "toaster", false);
		}
	}
	else if(name=="Living"){
		rmItms[0] = item(false, "coffee-table", true);
		rmItms[0].fillContainer();
		rmItms[1] = item(false, "couch", true);
		rmItms[1].fillContainer();
		rmItms[2] = item(false, "chair", true);
		rmItms[2].fillContainer();
		if (rand()%50>25){
			rmItms[3] = item(false, "fire-place", true);
			rmItms[3].fillContainer();
		}
	}
	else if (name == "Library"){
		rmItms[0] = item(true, "book", false);
		rmItms[1] = item(true, "books", false);
		rmItms[2] = item(true, "encyclopedia", false);
		rmItms[3] = item(true, "dictionary", false);
		rmItms[4] = item(true, "atlas", false);
		rmItms[5] = item(true, "globe", false);
		rmItms[6] = item(false, "chair", true);
		rmItms[6].fillContainer();
		if (corpse){
			rmItms[7] = item(true, "coffee", false);
		}
	}
}
void room::dispItms(){
	cout << "Items in the room: " << endl;
	for (int i = 0; i < 10; i++){
		if (rmItms[i].getName() == "");
		else{
			cout << rmItms[i].getName() << ", ";
		}
	}
	cout << "\n" << endl;
}
bool room::isItmIn(string in){
	for (int r = 0; r < 10; r++){
		if (rmItms[r].getName() == in){
			return true;
		}
	}
	return false;
}
item room::getItm(string in){
	for (int r = 0; r < 10; r++){
		if (rmItms[r].getName() == in){
			return rmItms[r];
		}
	}
	return item(false,"",false);
}
void room::addItm(item as){
	for (int f = 0; f < 10; f++){
		if (rmItms[f].getName() == ""){
			rmItms[f] = as;
			f = 10;
		}
	}
}

void room::remItm(string in){
	for (int r = 0; r < 10; r++){
		if (rmItms[r].getName() == in){
			rmItms[r]=item(false,"",false);
			/*for (int g = r; g < 9;g++){
				rmItms[g] = rmItms[g+1];
			}*/
		}
	}

}

void room::dispSusp(){
	cout << "Suspects:" << endl;
	for (int i = 0; i < 5; i++){
		if (suspects[i].getName() == "");
		else{
			cout << suspects[i].getName() << ", ";
		}
	}
	cout << "\n" << endl;
}
suspect room::getSus(string in) {
	for (int r = 0; r < 5; r++) {
		if (suspects[r].getName() == in) {
			return suspects[r];
		}
	}
	return suspect();
}

void room::addSuspects(){
	suspects[0] = suspect("butler"); 
	suspects[1] = suspect("maid");
	suspects[2] = suspect("gardener");
	suspects[3] = suspect("wife");
	suspects[4] = suspect("son");
}
bool room::isSusIn(string in) {
	for (int r = 0; r < 5; r++) {
		if (suspects[r].getName() == in) {
			return true;
		}
	}
	return false;
}

void room::setCulprit(){
	 
	int randoom = rand() % 100;
	if (randoom<20){
		suspects[0].setCulp(true);
	}
	else if (randoom < 40){
		suspects[1].setCulp(true);
	}
	else if (randoom < 60){
		suspects[2].setCulp(true);
	}
	else if (randoom < 80){
		suspects[3].setCulp(true);
	}
	else if (randoom < 100){
		suspects[4].setCulp(true);
	}
}

bool room::hasCnt(){
	for (int r = 0; r < 10; r++){
		if (rmItms[r].getCont()){
			return true;
		}
	}
	return false;
}

void room::putInCnt(item a){
	for (int qwe = 0; qwe < 10; qwe++){
		if (rmItms[qwe].getCont()){
			rmItms[qwe].addItm(item2(a.getTakeable(),a.getName()));
		}
	}
}
void room::putInCntRnd(item a){
	 
	int randu = rand() % 10;
	while (!rmItms[randu].getCont()){
		randu = rand() % 10;
	}
		if (rmItms[randu].getCont()){
			rmItms[randu].addItm(item2(a.getTakeable(), a.getName()));
		}
	
}
item room::getCntItm(string sre){
	for (int qwer = 0; qwer < 10; qwer++){
		if (rmItms[qwer].getCont()){
			if (rmItms[qwer].getItm(sre).getName()==sre){
				return item(true, rmItms[qwer].getItm(sre).getName(), false);
			}
		}
	}
	return item(true, "", false);
}
void room::remCntItm(string sre){
	for (int qwer = 0; qwer < 10; qwer++){
		if (rmItms[qwer].getCont()){
			if (rmItms[qwer].getItm(sre).getName() == sre){
				if (rmItms[qwer].getItm(sre).getName() == sre){
					rmItms[qwer].remItm(sre);
				}
			}
		}
	}
}

string room::getCulpName(){
	for (int e = 0; e < 5; e++){
		if (suspects[e].getCulp()){
			return suspects[e].getName();
		}

	}
	return "";
}
bool room::susName(string a){
	for (int e = 0; e < 5; e++){
		if (a==suspects[e].getName()){
			return true;
		}
	}
	return false;
}
