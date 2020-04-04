package usecases;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Hóvihar generálást szimuláló use-case
 */

import objects.*;
public class ControlerHovihar implements UseCase {

	/**
	 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
	 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
	 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
	 * hogy ez ne befolyásolja a többi use-case teszt futását. Az objektumok létrehozása után futtatjuk 
	 * meghivjuk a szekvenciában szereplő első metódust
	 *
	 * Használat előtt feltesszük a kérdést a felhasználónak, hogy tartalmaz-e iglut 
	 * a tesztelendő mező, ha igen a StabilJegtablahoz még egy iglut is settelünk
	 */
	@Override
	public void run() {
		System.out.println(getName().toUpperCase());
		Kutato sz = new Kutato();
		StabilJegtabla mezo = new StabilJegtabla("mezo" ,null);
		
		
		Palya.addMezo(mezo);
		Palya.addSzereplo(sz);
		mezo.setSzereplo(sz);
		sz.setMezo(mezo);
		
		
		String answer = "";
		System.out.print(" - Van iglu a tesztelni kivant mezon?(Y/N) ");
		while(!answer.equals("Y") && !answer.equals("N")) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!answer.equals("Y") && !answer.equals("N")) {
				System.out.print("Hibas bemenet, probald ujra!(Y/N) ");
			}
		}
		
		if(answer.equals("Y")) 
		{
			Iglu iglu = new Iglu();
			mezo.setEpulet(iglu);
		}
		
		Palya.Hovihar();
		Palya.clear();
	}
	/**
	 * A use-case-hez tartózó leirás
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		
		return "Hovihar generalas";
	}

}
