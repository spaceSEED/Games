package hell.items;


/**
 * Created by Liam on 11/8/2016.
 */
public abstract class Equipable extends Item{

	String type="";
    boolean equipped=false;
    
	public Equipable(String name) {
		super(name);
	}
	
	public Equipable(String name, int weight, int worth){
        super(name,weight,worth);
    }
    
	@Override
    public boolean isEquipable(){
        return true;
    }

    public String getType(){
        return type;
    } 
    
    public boolean getEquipped(){
        return equipped;
    }
    
    public boolean setEquipped(boolean e){
        equipped=e;
        return equipped;
    }
}
