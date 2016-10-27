#pragma once
#include <iostream>
#include <string>

using namespace std;

class assets{
public:

	assets();
	~assets();

	void help();
	void command();
	string rmv(string rem, string full);
};