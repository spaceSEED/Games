#pragma once
#include <string>
#include <iostream>

using namespace std;

class item2
{
private:
	bool takeable = false;
	string name = "";
	string descr = "";

public:
	item2();
	item2(bool take, string nm);
	~item2();


	string getName();
	string getDescrip();
	bool getTakeable();

};

