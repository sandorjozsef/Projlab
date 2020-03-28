package usecases;

import objects.*;

public class SzereploLapat implements UseCase {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Kutato sz = new Kutato();
		StabilJegtabla mezo = new StabilJegtabla(null);
		Lapat lapat = new Lapat();
		
		
		Palya.setAktJatekos(sz);
		sz.setMezo(mezo);
		mezo.setSzereplo(sz);
		
		sz.Hasznal(lapat);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo lapatot hasznal";
	}

}
