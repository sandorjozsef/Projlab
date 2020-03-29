package objects;
import indent.Indentor;


/**
 * Implementálja a Targy interfészt, csak egy Szereplo hívhatja meg a Kepesseg()
 * függvényét. - Nyílván csak akkor tudja meghívni, ha nála van, tehát már kiásta
 */
public class Lapat implements Targy{

	/**
	 * paraméter:  Szereplo sz - az a szereplo akinél van a kötél, ez hívhatja csak meg a függvényt
	 * 
	 * Azon a mezon, ahol az 'sz' Szereplo áll levon Mezo hómagassag értékéből 2-t
	 * 
	 * nincs visszatérési érték
	 * 
	 */
	@Override	
	public void Kepesseg(Szereplo felhasznalo) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Lapat.Kepesseg()");
		
		
		felhasznalo.getMezo().HoHozzaad(-2);
		
		Indentor.degLevel();
		
	}
	/**
	 *  visszaadja az osztály nevét, implementálja a Targy függvényét
	 */
	public String Name() {
		return "Lapat";
	}

}
