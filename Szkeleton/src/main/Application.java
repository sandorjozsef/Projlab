package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import usecases.*;
/**
 * 
 * main app
 *
 */
public class Application {
	
	/**
	 * Létrehozunk egy listát a UseCase interfészt implementáló osztályokból, amelynek elemieihez
	 * később a listában lévő poziciójuk alapján azonositókat rendelünk
	 * 
	 * Ezen azonositókkal tudjuk majd futtatni a kivánt use-caseket, miután bekértük a felhasználótól
	 * 
	 * Ezzel a módszerrel könnyen bővithető a usecase lista
	 *
	 *
	 * Kiirjuk az egyes use-caseket és azonositójukat az osztályban tárolt nevüket felhasználva
	 *
	 *	
	 * Elkapju kaz esetleges exception-oket pl.:
	 * Ha nem egész szám jön az inputon vagy olyan szám jön, amvel túlindexelnénk a listát
	 * újra bekérjük az azonositót, ameddig végre nem hajtható az indexelés és futtatás
	  */
	public static void main(String[] args) {
		boolean exit = false;
		while(!exit) {
			
			ArrayList<UseCase> useCases = new ArrayList<UseCase>();	
			useCases.add(new EszkimoIglutEpit());
			useCases.add(new KutatoFelderit());
			useCases.add(new SzereploKoratadasStabil());
			useCases.add(new SzereploKoratadasLuk());
			useCases.add(new SzereploEszik());
			useCases.add(new SzereploBuvarruha());
			useCases.add(new SzereploAlkatresz());
			useCases.add(new SzereploTargyfelvetel());
			useCases.add(new ControlerHovihar());
			useCases.add(new SzereploLepStabil());
			useCases.add(new SzereploLepInstabil());
			useCases.add(new SzereploLepLuk());
			useCases.add(new SzereploTakarit());
			useCases.add(new SzereploLapat());
			useCases.add(new SzereploKotelLukrol());	
			useCases.add(new SzereploKotelInstabil());
			
			System.out.println("LEHETSEGES USE-CASE-ek:\n");
			System.out.println("[-1] - Kilepes a programbol");
			for(int i = 0; i< useCases.size();i++) {
				System.out.println("["+i+"] - "+useCases.get(i).getName());
			}
			boolean validID = false;
			System.out.print("\nAdd meg a tetsztelni kivant use-case azonositojat: ");
			
			while(!validID) {
				try {
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					int useCaseID = Integer.parseInt(reader.readLine());
					
					if(useCaseID == -1) {
						exit = true;
						break;
					}
					
					
					validID = true;					
					useCases.get(useCaseID).run();
				}
				catch(Exception e) {
				
					validID = false;	
					//e.printStackTrace();
					System.out.print("Nem megfelelo azonosito, probalkozz ujra!: ");
				}
			}
			System.out.print("\n---Nyomj ENTER-t---\n");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				reader.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}	
	
}
