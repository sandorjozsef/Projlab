package usecases;
import objects.*;
public class SzereploKoratadas implements UseCase {

	@Override
	public void run() {
		StabilJegtabla mezo = new StabilJegtabla(null);
		Kutato k = new Kutato();
		Kutato k2 = new Kutato();
		
		Palya.setAktJatekos(k);
		
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
