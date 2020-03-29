package usecases;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Hóvihar generálást szimuláló use-case
 */

import objects.*;
public class ControlerHovihar implements UseCase {

	@Override
	public void run() {
		
		/**
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		Kutato sz = new Kutato();
		StabilJegtabla mezo = new StabilJegtabla(null);
		
		
		Palya.addMezo(mezo);
		Palya.addSzereplo(sz);
		mezo.setSzereplo(sz);
		sz.setMezo(mezo);
		
		/**
		 * Használat előtt feltesszük a kérdést a felhasználónak, hogy tartalmaz-e iglut 
		 * a tesztelendő mező, ha igen a StabilJegtablahoz még egy iglut is settelünk
		 */
		String answer = "";
		System.out.print("Van iglu a tesztelni kivant mezon?(Y/N) ");
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
			mezo.setIglu();
		/**
		 * Futtatjuk a szekvenciát
		 * reseteljük a Palya tartalmát
		 */
		Palya.Hovihar();
		Palya.clear();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/**
		 * A use-case-hez tartózó leirás
		 */
		return "Hovihar generalas";
	}

}
