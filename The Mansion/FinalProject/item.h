#pragma once
#include <string>
#include <iostream>
#include "item2.h"

using namespace std;

class item
{
private:
	bool takeable = false;
	string name = "";
	bool container = false;
	string descr = "";
	
	item2 cntItm[10];

public:
	string wep = "";


	item();
	item(bool take, string nm, bool con);
	~item();


	string getName();
	string getDescrip();
	bool getTakeable();
	bool getCont();

	void fillContainer();
	item2 getItm(string in);
	void dispItms();

	void setWep(string in);

	void addItm(item2 ast);
	void remItm(string das);



};

