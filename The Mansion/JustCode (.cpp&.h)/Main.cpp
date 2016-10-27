#include <iostream>
#include <string>
#include <stdlib.h>
#include <time.h>
#include "room.h"
#include "player.h"
#include "assets.h"
#include "map.h"
#include "item.h"

using namespace std;//no longer have to type std::

player* p1 = new player();
assets* ass = new assets();
map* chizu = new map(); 


int eX = 0;
int eY = 0;

/*accuse the culprit (enter suspect name, the weapon, and the evidence)
  Ends the game with a win/loss
*/
bool accuse(){
	bool loopit = true;
	string inpt = "";
	string sus = "";
		string ev = "";
		string w = "";
	while (loopit){
		system("cls");
		cout << "Please enter the suspect:" << endl;
		chizu->maP[eY][eX].dispSusp();
		cout << ">>"; getline(cin, inpt);
		if (chizu->maP[p1->posY][p1->posX].susName(inpt)){
			sus = inpt; loopit = false;
		}
		else{
			cout << "Invalid Input" << endl;
		}

		system("pause");

	}
	loopit = true;
	while (loopit){
		system("cls");
		cout << "Please enter the weapon:" << endl;
		p1->dispInven();
		cout << ">>"; getline(cin, inpt);
		if (p1->isInInven(inpt)){
			w = inpt; loopit = false;
		}
		else{
			cout << "Invalid Input" << endl;
		}

		system("pause");

	}
	loopit = true;
	while (loopit){
		system("cls");
		cout << "Please enter the evidence:" << endl;
		p1->dispInven();
		cout << ">>"; getline(cin, inpt);
		if (p1->isInInven(inpt)){
			ev = inpt; loopit = false;
		}
		else{
			cout << "Invalid Input" << endl;
		}
		system("pause");

	}
	if (chizu->culprit == sus&&chizu->evidence.getName()==ev&&chizu->wpn==w){
		return true;
	}
	return false;
}



/*Runs the game
*/
int main(){
	srand(time(NULL));
	bool inGame = true;
	string input="";
	bool loop = true;

	

	cout << "-The Mansion-" << endl;
	system("pause");

	cout << "Which difficulty level would you prefer?" << endl;
	cout << "<1>Easy <2>Normal <3>Hard <4>Insane <5>Random" << endl;
	cout << ">> "; getline(cin, input);

	if (input.find("1")!=-1){
		chizu->createMap(0);
	}
	else if (input.find("2")!=-1){
		if (rand() % 10 > 5){
			chizu->createMap(1);
		}
		else{
			chizu->createMap(2);
		}
	}
	else if (input.find("3")!=-1){
		if (rand() % 10 > 5){
			chizu->createMap(3);
		}
		else{
			chizu->createMap(4);
		}
	}
	else if (input.find("4")!=-1){
		chizu->createMap(5);
	}
	else{
		chizu->createMap(6);
	}

	for (int q = 0; q < 5; q++){
		for (int w = 0; w < 5; w++){
			if (chizu->maP[q][w].getRName() == "Entry"){
				eX = w; eY = q;
				p1->updateXY(w, q);
				chizu->playerPos(w, q);
			}
		}
	}
	int limX = -1; int limY = -1;
	for (int q = 0; q < 5; q++){
		if (q == 0){
		for (int w = 0; w < 5; w++){
				if (chizu->maP[q][w].isEmpty()){
				}
				else{
					limX++;
				}
			}
		}
		if (chizu->maP[q][0].isEmpty()){
		}
		else{
			limY++;
		}
	}
	

	system("cls");
	cout << "Someone has been murdered. Search his mansion\nfor clues to determine the culprit" << endl;
	system("pause");

	while (inGame){
		system("cls");
		chizu->displayMap();

		ass->command();

		if (input == "help"){
			ass->help();
		}
		else if (input == "inventory" || input == "inven"){
			p1->dispInven();
		}
		else if (input == "search" || input == "search room"){
			chizu->maP[p1->posY][p1->posX].dispItms();
		}
		else if (chizu->maP[p1->posY][p1->posX].isItmIn(input) && chizu->maP[p1->posY][p1->posX].getItm(input).getCont()){
				chizu->maP[p1->posY][p1->posX].getItm(input).dispItms();
		}
		else if (p1->isInInven(input) && p1->getItm(input).getCont()){
			p1->getItm(input).dispItms();
		}
		else if (input == "look" || input == "look room"){
			if (chizu->maP[p1->posY][p1->posX].getRName() == "Entry"){
				chizu->maP[p1->posY][p1->posX].dispSusp();
			}
		}
		

		cout << ">> "; getline(cin, input);


		if (input == "help"){
			ass->help();
		}
		else if (input == "inventory" || input == "inven"){
			p1->dispInven();
		}
		else if (input == "look" || input == "look room"){
			cout << chizu->maP[p1->posY][p1->posX].getDescription() << endl;
			if (chizu->maP[p1->posY][p1->posX].getRName()=="Entry"){
				chizu->maP[p1->posY][p1->posX].dispSusp();
			}
		}
		else if (input.find("look") != -1){
			input = ass->rmv("look",input);
			while (input.find(" ") !=-1){
					input = ass->rmv(" ", input);
			}
			if (chizu->maP[p1->posY][p1->posX].isItmIn(input)){
				cout << chizu->maP[p1->posY][p1->posX].getItm(input).getDescrip() << endl;
			}
			else if (p1->isInInven(input)){
				cout << p1->getItm(input).getDescrip() << endl;
			}
			else if (chizu->maP[p1->posY][p1->posX].getCntItm(input).getName() == input){
				cout << chizu->maP[p1->posY][p1->posX].getCntItm(input).getDescrip() << endl;
			}
			if (chizu->maP[p1->posY][p1->posX].isSusIn(input)) {
				cout << chizu->maP[p1->posY][p1->posX].getSus(input).getDescrip() << endl;
			}
		}

		else if (input == "search"||input== "search room"){
			chizu->maP[p1->posY][p1->posX].dispItms();
		}
		else if (input.find("search") != -1){
			input = ass->rmv("search", input);
			while (input.find(" ") != -1){
				input = ass->rmv(" ", input);
			}
			if (chizu->maP[p1->posY][p1->posX].isItmIn(input) && chizu->maP[p1->posY][p1->posX].getItm(input).getCont()){
				chizu->maP[p1->posY][p1->posX].getItm(input).dispItms();
			}
			else if (p1->isInInven(input)&&p1->getItm(input).getCont()){
				p1->getItm(input).dispItms();
			}
			else{
				cout << "There's nothing to search in this." << endl;
			}
		}

		else if (input.find("take")!=-1){
			input = ass->rmv("take", input);
			while (input.find(" ") != -1){
				input = ass->rmv(" ", input);
			}
			if ((chizu->maP[p1->posY][p1->posX].isItmIn(input) && chizu->maP[p1->posY][p1->posX].getItm(input).getTakeable())){
				if (p1->addInven(chizu->maP[p1->posY][p1->posX].getItm(input))){
					chizu->maP[p1->posY][p1->posX].remItm(input);
				}
			}
			else if (chizu->maP[p1->posY][p1->posX].getCntItm(input).getName() == input){
				if (p1->addInven(chizu->maP[p1->posY][p1->posX].getCntItm(input))){
					chizu->maP[p1->posY][p1->posX].remCntItm(input);
				}
			}
			else{
				cout << "This cannot be picked up." << endl;
			}
		}
		else if (input.find("accuse") != -1){
			inGame = false;
		}
		else if (input.find("move")!=-1&&(input.find("left")!=-1 || input.find("west")!=-1)){//moving code begin
			if (p1->posX != 0){ p1->posX--; chizu->playerPos(p1->posX, p1->posY); }
			else{ cout << "You can't go any further that way." << endl; }
		}
		else if (input.find("move")!=-1 && (input.find("right")!=-1 || input.find("east")!=-1)){
			if (p1->posX != limX){ p1->posX++; chizu->playerPos(p1->posX, p1->posY); }
			else{ cout << "You can't go any further that way." << endl; }
		}
		else if (input.find("move")!=-1 && (input.find("forward")!=-1 || input.find("up")!=-1||input.find("north")!=-1||input.find("forwards")!=-1)){
			if (p1->posY != 0){ p1->posY--; chizu->playerPos(p1->posX, p1->posY); }
			else{ cout << "You can't go any further that way." << endl; }
		}
		else if (input.find("move")!=-1 && (input.find("backward")!=-1 || input.find("down")!=-1 || input.find("south")!=-1 || input.find("backwards")!=-1||input.find("back")!=-1)){
			if (p1->posY != limY){ p1->posY++; chizu->playerPos(p1->posX, p1->posY); }
			else{ cout << "You can't go any further that way." << endl; }
		}
		else if (input == "move"||input=="move "){
			while(loop){
				system("cls");
				chizu->displayMap();
				ass->command();
				cout << "Please input a direction..." << endl;
				cout << ">> move "; getline(cin, input);
				if (input == "left"||input=="west"){
					if (p1->posX != 0){ p1->posX--; chizu->playerPos(p1->posX, p1->posY); }
					else{ cout << "You can't go any further that way." << endl; }
					loop = false;
				}
				else if (input == "right" || input == "east"){
					if (p1->posX != limX){ p1->posX++; chizu->playerPos(p1->posX, p1->posY); }
					else{ cout << "You can't go any further that way." << endl; }
					loop = false;
				}
				else if (input == "forward" || input == "forwards" || input == "north" || input == "up"){
					if (p1->posY != 0){ p1->posY--; chizu->playerPos(p1->posX, p1->posY); }
					else{ cout << "You can't go any further that way." << endl; }
					loop = false;
				}
				else if (input == "back" || input == "south" || input == "backward" || input == "backwards" || input == "down"){
					if (p1->posY != limY){ p1->posY++; chizu->playerPos(p1->posX, p1->posY); }
					else{ cout << "You can't go any further that way." << endl; }
					loop = false;
				}
			}
			loop = true;
		}//moving code end



		else{
			cout << "Invalid Input" << endl;
		}
		system("pause");
   }

   if (accuse()){
	   cout << "You Win. Your deduction was correct." << endl;
   }
   else{
	   cout << "You Lose. Your deduction was incorrect." << endl;
   }
   system("pause");
	return 0;
}
