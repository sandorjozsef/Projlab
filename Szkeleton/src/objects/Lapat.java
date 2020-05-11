package objects;
import java.io.Serializable;

import view.GrafNezet;


/**
 * Implementálja a Targy interfészt, csak egy Szereplo hívhatja meg a Kepesseg()
 * függvényét. - Nyílván csak akkor tudja meghívni, ha nála van, tehát már kiásta
 */
public class Lapat implements Targy, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3351037861369883501L;
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
		felhasznalo.getMezo().HoHozzaad(-2);
	}
	/**
	 *  visszaadja az osztály nevét, implementálja a Targy függvényét
	 */
	public String Name() {
		return "Lapat";
	}
	@Override
	public void FrissitNezet(GrafNezet n) {
		// TODO Auto-generated method stub
		
	}

}
