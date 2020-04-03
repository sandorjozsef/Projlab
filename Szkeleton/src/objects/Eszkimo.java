 package objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import indent.*;
	
/**
 * Az Eszkimo osztály példányai 5 testhővel kezdik a játékot, és tudnak iglut építeni speciális
 * képességként.
 * @author Sándor József
 *
 */
public class Eszkimo extends Szereplo{
	
	public Eszkimo() {
		super();
	}
	
	/**
	 * Amennyiben a cel megegyezik az Eszkimo
	 * aktmezo attribútumával, akkor meghívja ennek a Mezőnek a setIglu() függvényét.
	 * Az egyezést a Skeleton fázisban a felhasználóhoz intézett
	 * kérdés alapján dönti el.
	 */
	public void SpecKepesseg(Mezo cel) {
		
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Eszkimo.SpecKepesseg()");
		

		/*String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.print(Indentor.getIndent()+" - Arra a mezore akarod epíteni, amin allsz ? (Y/N) ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer1 = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (answer1.equals("Y")) {
				Iglu iglu = new Iglu();
				cel.setEpulet(iglu);
			}
			if (answer1.equals("N")){
				System.out.print(Indentor.getIndent()+" - Iglu epitese sikertelen");
			}
		}*/
		if(cel.equals(aktmezo)) {
			Iglu iglu = new Iglu();
			cel.setEpulet(iglu);
		}

		Indentor.degLevel();

	}

	/**
	 * tudatja a kiiratásnál hogy egy Eszkimo végzi az esetlegesen Szereplo-ből nem
	 * felüldefiniált függvényt
	 */
	@Override
	public String Name() {
		// TODO Auto-generated method stub
		return "Eszkimo";
	}


}
