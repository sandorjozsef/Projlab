package main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import usecases.*;

public class Application {
	
	public static void main(String[] args) {
		boolean exit = false;
		while(!exit) {
			
			
			ArrayList<UseCase> useCases = new ArrayList<UseCase>();	
			useCases.add(new EszkimoIglutEpit());
			useCases.add(new KutatoFelderit());
			useCases.add(new SzereploKoratadas());
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
			useCases.add(new SzereploKotel());	
			
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
			
		}
		
		
		
		
	}	
	
}
