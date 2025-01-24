package hell.utilities;

public class Utilities {
	
	public static boolean isNum(String s){
        String n="0123456789";
        boolean isn=true;
        for(int g=0;g<s.length();g++){
            if(n.contains(s.substring(g,g+1))){

            }else{
                isn= false;
            }
        }
        return isn;
    }

}
