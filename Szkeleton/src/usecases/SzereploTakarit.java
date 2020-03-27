package usecases;

import objects.*;

public class SzereploTakarit implements UseCase {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Kutato k = new Kutato();
		StabilJegtabla mezo = new StabilJegtabla(new Kotel());
		
		
		k.setMezo(mezo);
		mezo.setSzereplo(k);
		
		k.Takarit();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo havat takarit el";
	}

}
