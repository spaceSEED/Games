

/**
 * Created by Liam on 11/8/2016.
 */
public interface Equipable {
    String type="";

    default String getType(){
        return type;
    }
}
