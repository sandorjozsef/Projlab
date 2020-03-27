package indent;

public final class Indentor {
	private static int  level;
	private Indentor() {
		level = 0;
	}
	public static void degLevel() {
		level--;
	}
	public static void incLevel() {
		level++;
	}
	public static String getIndent() {
		String ind = "";
		for(int i = 0; i<level;i++)
			ind +="\t";
		return ind;
	}
	
}
