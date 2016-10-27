#include <string>
#include "room.h"
#include "item.h"
#include "suspect.h"
#include "item2.h"
#pragma once

class map{
public:

	const int length=5;
	const int width=5;
	room maP[5][5];
	int pPosX, pPosY;
	int corpseX, corpseY;
	string culprit = "";
	item evidence;
	string wpn = "";

	map();
	~map();

	void addRoom(int x, int y, std::string name);
	void createMap(int size);
	std::string mapDRoom(std::string str);
	void displayMap();


	void playerPos(int x, int y);

	void placeEvidence();//spawns evidence and weapon in in random rooms (doesn't always work on smaller maps)
};

