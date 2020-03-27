package usecases;

import objects.*;

public class SzereploAlkatresz implements UseCase {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		StabilJegtabla mezo = new StabilJegtabla(new Kotel());
		Kutato akt_jatekos = new Kutato();
		Alkatresz alk = new Alkatresz();
		
		Palya.addMezo(mezo);
		Palya.addSzereplo(akt_jatekos);
		mezo.setSzereplo(akt_jatekos);
		akt_jatekos.setMezo(mezo);
		
		
		akt_jatekos.Hasznal(alk);
		Palya.clear();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo alkatreszt hasznal";
	}

}
