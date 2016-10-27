#include "item2.h"
#include <string>
#include <iostream>

using namespace std;

item2::item2()
{
}
item2::item2(bool take, string nm){
	takeable = take;
	name = nm;
	if (name == "shoes"){
		descr = "These are just normal shoes. They look pretty clean but smell terrible.";
	}
	else if (name == "umbrella"){
		descr = "This is just a normal umbrella. It's dry, because it hasn't rained for a while.";
	}
	else if (name == "fruit-bowl"){
		descr = "This is just a bowl of fruit. They look real but I don't want to risk eating them.";
	}
	else if (name == "pot"){
		descr = "This is just a pot. There's nothing in it. It was either going to be used\nor put out for decoration.";
	}
	else if (name == "food-scraps"){
		descr = "These food scraps were all over the room and the victim. They were probably scattered\nin the struggle.The culprit could have some of these on him.";
	}
	else if (name == "grass"){
		descr = "This is just normal grass.";
	}
	else if (name == "rock"){
		descr = "This is just a normal rock.";
	}
	else if (name == "weed"){
		descr = "I guess the lawn wasn't as well kept as it looked. This is a pretty big weed.";
	}
	else if (name == "flower"){
		descr = "This is a nice flower. There are a bunch here; maybe no-one would notice if one went missing.";
	}
	else if (name == "bullet-casing"){
		descr = "I guess the culprit forgot to clean this up. All we need now is the matching gun.";
	}
	else if (name == "book"){
		descr = "It looks kinda' interesting. I guess there are people who would read this, not that I would.";
	}
	else if (name == "glass"){
		descr = "Did the victim drink water before bed?";
	}
	else if (name == "lamp"){
		descr = "Usually there's something suspicious with the lamp, but this one doesn't hold any evidence.";
	}
	else if (name == "dust-bunny"){
		descr = "It's adorable. There's so much dust under here it actually formed a bunny.";
	}
	else if (name == "junk"){
		descr = "I guess they don't look under their furniture. There are alot of random items under here.";
	}
	else if (name == "pen"){
		descr = "This must be the victim's pen. It's pretty chewed up; I guess that was their habit.";
	}
	else if (name == "ink-well"){
		descr = "I don't think I could ever use a fountain pen, it's too messy.";
	}
	else if (name == "pencil"){
		descr = "This is just a normal pencil. It's pretty chewed up though.";
	}
	else if (name == "tp"){
		descr = "This is just normal toilet paper. There's nothing suspicious about toilet paper.";
	}
	else if (name == "razor"){
		descr = "This is just a normal razor. It would be hard to kill somebody with this.";
	}
	else if (name == "shaving-cream"){
		descr = "This is nothing but normal shaving cream.";
	}
	else if (name == "toothpaste"){
		descr = "This is nothing but normal toothpaste.";
	}
	else if (name == "toothbrush"){
		descr = "This is just a normal toothbrush. The bristles are pretty worm out.\nI guess the owner wasn't fond of buying new ones that often.";
	}
	else if (name == "toaster"){
		descr = "The culprit must have forced his way in, plugged this in, and then\nthrew it into the tub. Either the victim was okay with the culprit being in the restroom with them\nor they weren't able to notice.";
	}
	else if (name == "books"){
		descr = "This is a stack of normal books. Some of these look interesting,\nI wouldn't mind reading them.";
	}
	else if (name == "encyclopedia"){
		descr = "This is not a normal encyclopedia. It's all about cockroaches.";
	}
	else if (name == "dictionary"){
		descr = "This is just a conventional dictionary. I wonder if there are\nany other good words for \"normal\" in here.";
	}
	else if (name == "atlas"){
		descr = "This is just a normal atlas. It's mainly maps of countries and has no local maps.";
	}
	else if (name == "globe"){
		descr = "This is just a normal globe. It's pretty fancy though.";
	}
	else if (name == "coffee"){
		descr = "The victim was drinking his when he died. It may be poisoned.";
	}
	else if (name == "photo"){
		descr = "This is a very 'personal' photograph of the maid. This would be a good motive for murder.";
	}
	else if (name == "glove"){
		descr = "This is the butler's glove. It has traces of some fluid on it.";
	}
	else if (name == "apron"){
		descr = "This is the maid's apron. It has traces of some fluid on it.";
	}
	else if (name == "potting-soil"){
		descr = "This is strange. The gardener claimed he never entered the house.";
	}
	else if (name == "file"){
		descr = "This file contains information on the butler and insurance fraud.";
	}
	else if (name == "address-book"){
		descr = "This is the victim's. It contains the contact info for countless women. He was having affairs.";
	}
	else if (name == "check-book"){
		descr = "This is the victim's. It's filled with the son's purchases.";
	}
	else if (name == "report-card"){
		descr = "This is the son's. His grades are terrible. Is it possible to murder someone because of this?";
	}
	else if (name == "necklace"){
		descr = "This is an expensive necklace. Why would this be here?";
	}
	else if (name == "knife"){
		descr = "This bloody knife is probably the murder weapon.";
	}
	else if (name == "pan"){
		descr = "This pan has blood on it. It must be the murder weapon.";
	}
	else if (name == "gun"){
		descr = "This gun smells like it's been fired recently. It may have been used in the murder.";
	}
	else if (name == "poison"){
		descr = "This is likely to be the poison used in the murder.";
	}
	else if (name == "necklace"){
		descr = "This is an expensive necklace, probably the wife's. Why would this be here?";
	}
	else if (name == "change"){
		descr = "Look at all of these loose coins. I probably shouldn't take them.";
	}
	else if (name == "old-toy"){
		descr = "Sad. These old, forgotten toys have probably been here for ages.";
	}
	else if (name == "plates"){
		descr = "Just normal plates.";
	}
	else if (name == "forks"){
		descr = "Look at all of these forks.";
	}
	else if (name == "spoons"){
		descr = "Look at all of these spoons.";
	}
	else if (name == "papers"){
		descr = "These are just normal papers.";
	}
	else if (name == "contracts"){
		descr = "These look important.";
	}
	else if (name == "brick") {
		descr = "This blunt brick is covered with blood. This must be the weapon.";
	}
}
item2::~item2()
{
}

string item2::getName(){
	return name;
}
string item2::getDescrip(){
	return descr;
}
bool item2::getTakeable(){
	return takeable;
}