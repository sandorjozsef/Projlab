package usecases;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import objects.*;
public class ControlerHovihar implements UseCase {

	@Override
	public void run() {
		Kutato sz = new Kutato();
		StabilJegtabla mezo = new StabilJegtabla(null);
		
		
		Palya.addMezo(mezo);
		Palya.addSzereplo(sz);
		mezo.setSzereplo(sz);
		sz.setMezo(mezo);
		
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
		
		Palya.Hovihar();
		Palya.clear();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Hovihar generalas";
	}

}
