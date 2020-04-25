package objects;
import java.util.ArrayList;


/**
 * Az Epulet absztrakt osztály leszármazottja, a Levon() függvényét csak a Palya osztály hívja meg
 * új játékos körének kezdésénél, amikor egy esetleges hóvihar éri a mezőt
 */
public class Noglu extends Epulet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3602890566803600689L;

	/**
	 * paraméter: Azok a szereplok akik azon a mezőn állnak, ahol nincs iglu
	 * 
	 * Ha a Palya meghívja az adott mezőnek a Hoeses() függvényét akkor ez a mező átadja a rajta álló emberek 
	 * listáját paraméterként(szereplok) és ez a függvény levon egyet mindenki testhőjéből
	 * 
	 * nincs visszatérési értéke
	 */
	@Override

	public void Levon(ArrayList<Szereplo> szereplok)
	{
	
		for (int i = 0; i < szereplok.size(); i++)
		{
			szereplok.get(i).TesthoHozzaad(-1);
		}
	
	}
	/**
	 *  visszaadja az osztály nevét
	 */
	public String Name() {
		return "Noglu";
	}
	
	/**
	 * 
	 */
	@Override
	public boolean Amortizacio() {
		return false;
	}
	
	/**
	 * 
	 */
	@Override
	public void Tamadas() 
	{
		Palya.JatekVege(false);
	}
}
