#pragma once
#include <iostream>
#include <string>
#include "item.h"

using namespace std;


class player{
public:
	int posX, posY;
	item inventory[30];

	player();
	~player();

	void updateXY(int x, int y);
	void dispInven();
	bool addInven(item in);

	bool isInInven(string in);
	item getItm(string in);
};