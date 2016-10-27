#include "suspect.h"
#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

suspect::suspect(string nm){
	name = nm;
	if (nm.compare("butler")==0){
		desc = "Very trimed and proper. This man has gerat posture and is stereotypical image of a butler.";
	}
	else if (nm.compare("maid")==0){
		desc = "She seems very calm in this situation. She probably works with a very professional attitude.";
	}
	else if (nm.compare("gardener")==0){
		desc = "Just a regular landscaper. He primarily worked for the victim.";
	}
	else if (nm.compare("wife")==0){
		desc = "She seems doesn't seem upset at her husbands death, more so at the fact that she's a suspect.";
	}
	else if (nm.compare("son")==0){
		desc = "A college student. He doesn't want to be here. I guess he's a bit rebellious.";
	}
}
suspect::suspect()
{
}
suspect::~suspect()
{
}

string suspect::getName(){
	return name;
}
string suspect::getDescrip() {
	return desc;
}


void suspect::setCulp(bool a){
	culp = a;
}
bool suspect::getCulp(){
	return culp;
}