package local.baledo.root.s6.operateur.util;

public class Util {
	public static String toUpperFirst(String str)
	{
		char cf = str.charAt(0);
		String first = String.valueOf(cf).toUpperCase();
		String after = str.substring(1);
		return (first.concat(after));
	}
	public static boolean checkIfDefault(Object o) throws InstantiationException, IllegalAccessException{
		if(o == null) return true;
		Object objDef = o.getClass().newInstance();
		return objDef.equals(o);
	}
}
