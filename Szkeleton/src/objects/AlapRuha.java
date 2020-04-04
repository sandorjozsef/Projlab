package objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

import indent.Indentor;
/**
 * A Szereplo-h�z tartoz� olyan fajta ruha, amely kezdetben van rajta.
 * Ha ilyen viselete k�zben esik valaki v�zbe, akkor el tud �zni �s id�vel megfagyni, ami a j�t�k veszt�s�t vonja maga ut�n.
 * @author Aviato
 */
public class AlapRuha extends Ruha{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8985600671678347139L;
	private int elazasi_szint = 0;
	
	/**
	 * Ez a f�ggv�ny gondoskodik arr�l, hogy a v�zben l�v� Szereplo "vizesebb" legyen,
	 * azaz el�zzon, illetve megfagyjon.
	 * @param sz megfagyott akkor ezen a Szereplo-n h�vja meg a Meghaltam f�ggv�nyt.
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
	 * Ezzel a met�dussal v�zb�l kij�vet meg tud sz�radni a ruha, ezzel biztos�tva,
	 * hogy �jabb belees�skor is meglegyen mindk�t f�zis (vizes �s megfagyott).
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
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return Alapruha Stringgel fog visszat�rni
	 */
	@Override
	public String Name() {
		return "AlapRuha";
	}
}
