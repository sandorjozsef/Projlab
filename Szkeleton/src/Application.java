import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import usecases.*;

public class Application {
	
	public static void main(String[] args) {
		
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
		
		for(int i = 0; i< useCases.size();i++) {
			System.out.println("["+i+"] - "+useCases.get(i).getName()+"\n");
		}
		boolean validID = false;
		System.out.println("\nAdd meg a tetsztelni kivant use-case azonositojat: ");
		
		while(!validID) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				int useCaseID = Integer.parseInt(reader.readLine());
				validID = true;
				useCases.get(useCaseID).run();
			}
			catch(Exception e) {
				validID = false;
				System.out.println("\nNem megfelelo azonosito, probalkozz ujra!: ");
			}
		}
		
		
		
		
		
	}	
	
}
