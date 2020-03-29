package indent;
/**
 * Ez a statikus osztály menedzseli az indentálásokat, minden függvény a maga szintje szerint 
 * módositja és végül a neve kiirásánál lekéri a megfelelő számú tabulátorokat
 */
public final class Indentor {
	private static int  level;
	private Indentor() {
		level = 0; 
		/**
		 * Kezdetben a 0-ás szinten vagyunk ez 0 d btabulátort jelent
		 */
	}
	public static void degLevel() {
		level--;
		/**
		 * A metódusok return előtt visszacsökkentik az indentálási szintet, hogy ne csak egy
		 * lépcsőt lássunk
		 */
	}
	public static void incLevel() {
		level++;
		/**
		 * A metódusok közvetlenül a belépésük után növelik az indentálási szintet, igy 
		 * beljebb kezdődik majd a kiirásuk
		 */
	}
	public static String getIndent() {
		String ind = "";
		for(int i = 0; i<level;i++)
			ind +="\t";
		return ind;
		/**
		 * Előállit egy tabulátor sorozatot az aktuális szint alapján és visszaadja
		 */
	}
	
}
