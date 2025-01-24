package hell.character;


import java.util.*;

import hell.items.Item;
import hell.utilities.dialog.DialogTree;
/**
 * Write a description of class Merchant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merchant extends NPC
{
    ArrayList<Item> wares= new ArrayList<Item>();
    
    public Merchant()
    {
        conversation=new DialogTree("merchant.dt");
    }


}
