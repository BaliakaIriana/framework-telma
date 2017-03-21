package local.baledo.root.s6.operateur.util;

public class Util {
	public String toUpperFirst(String str)
	{
		char cf = str.charAt(0);
		String first = String.valueOf(cf).toUpperCase();
		String after = str.substring(1);
		return (first.concat(after));
	}
}
