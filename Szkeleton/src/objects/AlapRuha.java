package objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import indent.Indentor;
/**
 * A Szereplo-höz tartozó olyan fajta ruha, amely kezdetben van rajta.
 * Ha ilyen viselete közben esik valaki vízbe, akkor el tud ázni és idõvel megfagyni, ami a játék vesztését vonja maga után.
 * @author Aviato
 */
public class AlapRuha extends Ruha {
	private int elazasi_szint = 0;
	
	/**
	 * Ez a függvény gondoskodik arról, hogy a vízben lévõ Szereplo "vizesebb" legyen,
	 * azaz elázzon, illetve megfagyjon.
	 * @param sz megfagyott akkor ezen a Szereplo-n hívja meg a Meghaltam függvényt.
	 */
	@Override
	public void Elazik(Szereplo sz)
	{ 
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Elazik()");
		sz.setLepesszam(0);
		if (elazasi_szint == 2)
		{
			sz.Meghaltam();
		}
		elazasi_szint++;
		Indentor.degLevel();
	}
	
	/**
	 * Ezzel a metódussal vízbõl kijövet meg tud száradni a ruha, ezzel biztosítva,
	 * hogy újabb beleeséskor is meglegyen mindkét fázis (vizes és megfagyott).
	 */
	@Override
	public void Megszarit()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Megszarit()");
		elazasi_szint = 0;
		Indentor.degLevel();
	}
	
	/**
	 * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
	 * @return Alapruha Stringgel fog visszatérni
	 */
	@Override
	public String Name() {
		return "AlapRuha";
	}
}
