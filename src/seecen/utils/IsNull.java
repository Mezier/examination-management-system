package seecen.utils;

public class IsNull {
	public static  boolean isNullS(String s){
    	boolean f=true;
    	if(s!=null&&!"".equals(s)){
    		f=false;
    	}
    	return f;
    }
}
