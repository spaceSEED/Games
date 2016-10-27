#include <iostream>
#include <string>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "map.h"
#include "room.h"
#include "player.h"
#include "item.h"
#include "suspect.h"
#include "item2.h"

using namespace std;

map::map(){
}
map::~map()
{
}

void map::addRoom(int x, int y, std::string name){
	if (maP[y][x].isEmpty()){
		maP[y][x] = room(name);
	}
}
void map::createMap(int size){
	int x, y;
	int chance;
	if (size == 0){//easy 2x3
		y = 2; x = 3;
	}
	else if (size == 1){//normal 3x3
		y = 3; x = 3;
	}
	else if (size == 2){//normal 4x3
		y = 3; x = 4;
	}
	else if (size == 3){//Hard 4x4
		y = 4; x = 4;
	}
	else if (size == 4){//Hard 4x5
		y = 4; x = 5;
	}
	else if (size == 5){//Insane 5x5
		y = 5; x = 5;
	}
	else{
		y = rand() % 3+2; x = rand() % 3+2;
		size = 7;
	}
	for (int z = 0; z < y; z++){
			for (int q = 0; q < x; q++){
				if (size<=1||size==7||y<4){
					if (q == 1 && z == 0){
						addRoom(q, z, "Entry");
						maP[z][q].addSuspects();
						maP[z][q].setCulprit();
						culprit = maP[z][q].getCulpName();
					}
					else{
						
						chance = rand() % 1000;//fix these they aren't random
						if (chance<200){
							addRoom(q, z, "Bathrm");
						}
						else if (chance < 400){
							addRoom(q, z, "Library");
						}
						else if (chance < 600){
							addRoom(q, z, "Living");
						}
						else if (chance <700){
							addRoom(q, z, "Kitch");
						}
						else if (chance<900){
							addRoom(q, z, "Study");
						}
						else if (chance <= 1000){
							addRoom(q, z, "Bedrm");
						}
					}
				}
				else{
					if (q == 2 && z == 1){
						addRoom(q, z, "Entry");
						maP[z][q].addSuspects();
						maP[z][q].setCulprit();
						culprit = maP[z][q].getCulpName();
					}
					else if (z==0||z==4){
						addRoom(q, z, "Yard");
					}
					else{
						 
						chance = rand() % 1000;
						if (chance<200){
							addRoom(q, z, "Bathrm");
						}
						else if (chance < 400){
							addRoom(q, z, "Library");
						}
						else if (chance < 600){
							addRoom(q, z, "Living");
						}
						else if (chance <700){
							addRoom(q, z, "Kitch");
						}
						else if (chance<900){
							addRoom(q, z, "Study");
						}
						else if (chance <= 1000){
							addRoom(q, z, "Bedrm");
						}
					}
				}
			}
		}
	 
	corpseX = (rand()%(x*10))/10;   corpseY = (rand()%(y*10))/10;
	maP[corpseY][corpseX].addCorpse();
	for (int q = 0; q < 5; q++){
		for (int w = 0; w < 5; w++){
			maP[q][w].caseType();
			maP[q][w].fillWItems();
		}
	}
	placeEvidence();
}

string map::mapDRoom(string str){//displays a string (up to six letters) in a box, representing a room, on the map
	string dis = "";
		dis = "|      ";
	while(str.length() < 6){
		if (str.length() % 2 == 0){
			str = str + " ";
		}
		else{
			str = " "+str;
		}
	}
	str = str.substr(0, 6);
	dis = dis.substr(0, 1) + str;

	return dis;
}
void map::displayMap(){//" ______\n|      |\n|      |\n|______|\n" //no door room
	string disp = "";
	for (int y = 0; y < 5; y++){
		if (y == 0){
			for (int x = 0; x < 5; x++){
				if (maP[y][x].isEmpty());
				else{
					disp = disp + " ______";
				}
			}
			disp = disp + "\n";
		}
		for (int x = 0; x < 5; x++){
			if (maP[y][x].isEmpty());
			else{
				if (pPosX == x&&pPosY == y){
					if (corpseX == x&&corpseY == y){
						disp = disp + "|  *P  ";
					}
					else{
						disp = disp + "|  P   ";
					}
				}
				else if (corpseX==x&&corpseY==y){
					disp = disp + "|  **  ";
				}
				else{
					disp = disp + "|      ";
				}
			}
		}
				disp = disp + "|\n";
		for (int x = 0; x < 5; x++){
			if (maP[y][x].isEmpty());
			else{
				disp = disp + mapDRoom(maP[y][x].getRName());
			}
		}
				disp = disp + "|\n";
		for (int x = 0; x < 5; x++){
			if (maP[y][x].isEmpty());
			else{
				disp = disp + "|______";
			}
		}
		if (y <4){
			if (maP[y + 1][0].isEmpty()){
				disp = disp + "|\n";  y = 4;
			}
			else{
				disp = disp + "|\n";
			}
		}
	}
	cout << disp << endl;
}

void map::playerPos(int x, int y){
	pPosX = x; pPosY = y;
}

void map::placeEvidence(){
	 
	if (culprit.compare("maid")==0){
		if (rand() % 10 > 5){
			evidence = item(true,"photo",false);
		}
		else{
			evidence = item(true, "apron", false);
		}
	}
	else if (culprit.compare("butler")==0){
		if (rand() % 10 > 5){
			evidence = item(true, "file", false);
		}
		else{
			evidence = item(true, "glove", false);
		}
	}
	else if (culprit.compare("gardener")==0){
			evidence = item(true, "potting-soil", false);
	}
	else if (culprit.compare("wife")==0){
		if (rand() % 10 > 5){
			evidence = item(true, "necklace", false);
		}
		else{
			evidence = item(true, "address-book", false);
		}
	}
	else if (culprit.compare("son")==0){
		if (rand() % 10 > 5){
			evidence = item(true, "check-book", false);
		}
		else{
			evidence = item(true, "report-card", false);
		}
	}
	int limitX = 0;
	int limitY=0;
	for (int q = 0; q < 5; q++){
		if (q == 0){
			for (int w = 0; w < 5; w++){
				if (maP[0][w].isEmpty()){
				}
				else{
					limitX++;
				}
			}
		}
		if (maP[q][0].isEmpty()){
		}
		else{
			limitY++;
		}
	}
	 
	int ranX = rand()%limitX;  
		int ranY = rand()%limitY;
			while(evidence.getName().compare("potting-soil")==0&&maP[ranY][ranX].getRName().compare("Yard")==0){
				ranX = rand() % limitX;
				ranY = rand()%limitY;
			}
			
			if (evidence.getName().compare("potting-soil")!=0&&maP[ranY][ranX].hasCnt()){
				maP[ranY][ranX].putInCntRnd(evidence);
			}
			else{
				maP[ranY][ranX].addItm(evidence);
			}
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (maP[i][j].hasCorpse()) {
						wpn = maP[i][j].weapon;
					}
				}
			}
			
			ranX = rand() % limitX;  
			ranY = rand() % limitY;
			if (maP[ranY][ranX].hasCnt()){
				maP[ranY][ranX].putInCntRnd(item(true, wpn, false));
			}
			else{
				maP[ranY][ranX].addItm(item(true, wpn, false));
			}
}