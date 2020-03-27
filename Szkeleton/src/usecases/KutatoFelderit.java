package usecases;
import objects.*;
public class KutatoFelderit implements UseCase {

	@Override
	public void run() {
		Kutato k = new Kutato();
		InstabilJegtabla akt_mezo = new InstabilJegtabla(new Kotel(),3);
		InstabilJegtabla mezo = new InstabilJegtabla(new Kotel(),2);
		
		
		k.setMezo(akt_mezo);
		akt_mezo.setSzereplo(k);
		mezo.setSzomszed(akt_mezo);
		akt_mezo.setSzomszed(mezo);
		
		k.SpecKepesseg(mezo);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Kutato megprobal mezot felderiteni";
	}

}
