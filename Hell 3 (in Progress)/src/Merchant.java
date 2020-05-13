

import DialogTree.DialogTree;

import java.util.*;
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
