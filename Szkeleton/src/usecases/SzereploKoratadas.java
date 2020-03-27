package usecases;
import objects.*;
public class SzereploKoratadas implements UseCase {

	@Override
	public void run() {
		StabilJegtabla mezo = new StabilJegtabla(new Kotel());
		Kutato k = new Kutato();
		Kutato k2 = new Kutato();
		
		k2.setMezo(mezo);
		mezo.setSzereplo(k2);
		Palya.addMezo(mezo);
		Palya.addSzereplo(k);
		Palya.addSzereplo(k2);
		
		
		k.Vegeztem();
		Palya.clear();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo atadja a koret";
	}

}
