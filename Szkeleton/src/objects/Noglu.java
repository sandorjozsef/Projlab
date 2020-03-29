package objects;
import java.util.ArrayList;
import indent.Indentor;


/*
 * Az Epulet absztrakt osztály leszármazottja, a Levon() függvényét csak a Palya osztály hívja meg
 * új játékos körének kezdésénél, amikor egy esetleges hóvihar éri a mezőt
 */
public class Noglu extends Epulet{
	
	/*
	 * paraméter: Azok a szereplok akik azon a mezőn állnak, ahol nincs iglu
	 * 
	 * Ha a Palya meghívja az adott mezőnek a Hoeses() függvényét akkor ez a mező átadja a rajta álló emberek 
	 * listáját paraméterként(szereplok) és ez a függvény levon egyet mindenki testhőjéből
	 * 
	 * nincs visszatérési értéke
	 */
	public void Levon(ArrayList<Szereplo> szereplok)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Noglu.Levon");
		
		
		for (int i = 0; i < szereplok.size(); i++)
		{
			szereplok.get(i).TesthoHozzaad(-1);
		}
		
		Indentor.degLevel();
	}
	// visszaadja az osztály nevét

	public String Name() {
		return "Noglu";
	}
}
