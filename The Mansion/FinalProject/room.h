#pragma once
#include <iostream>
#include <string>
#include <stdlib.h>
#include "item.h"
#include "suspect.h"
#include "item2.h"

using namespace std;

class room
{
private:
	string name = "";
	string desc = "";
	bool corpse=false;
	item rmItms[10];
	suspect suspects[5];

public:
	string weapon="weapon";
	

	room(string nm);
	room();
	~room();

	
	string getRName();
	bool isEmpty();
	void addCorpse();
	bool hasCorpse();
	void caseType();

	string getDescription();

	void fillWItems();
	void dispItms();
	bool isItmIn(string in);
	item getItm(string in);
	void addItm(item as);
	
	void remItm(string in);

	void dispSusp();
	void addSuspects(); 
	bool isSusIn(string in);
	suspect getSus(string in);

	void setCulprit();

	bool hasCnt();

	void putInCnt(item a);
	void putInCntRnd(item a);
	item getCntItm(string sre);
	void remCntItm(string sre);

	string getCulpName();
	bool susName(string a);

};

