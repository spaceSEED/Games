#pragma once
#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

class suspect
{
private:
	string name = "";
	string desc = "";
	bool culp = false;

public:


	suspect(string nm);
	suspect();
	~suspect();

	string getName();
	string getDescrip();

	void setCulp(bool a);
	bool getCulp();
};

