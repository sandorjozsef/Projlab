package usecases;
import objects.*;
public class KutatoFelderit implements UseCase {

	@Override
	public void run() {
		Kutato k = new Kutato();
		InstabilJegtabla akt_mezo = new InstabilJegtabla(null,3);
		InstabilJegtabla mezo = new InstabilJegtabla(null,2);
		
		Palya.setAktJatekos(k);
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
