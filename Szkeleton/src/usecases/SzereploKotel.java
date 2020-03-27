package usecases;
import objects.*;
public class SzereploKotel implements UseCase{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Kutato k = new Kutato();
		Kotel kotel = new Kotel();		
		StabilJegtabla stabilJ = new StabilJegtabla(new Kotel());
		Luk luk = new Luk();
		Eszkimo e = new Eszkimo();
		luk.setSzereplo(e);
		e.setMezo(luk);
		stabilJ.setSzereplo(k);
		k.setMezo(stabilJ);
		stabilJ.setSzomszed(luk);
		luk.setSzomszed(stabilJ);
		
		k.Hasznal(kotel);
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo kotelet hasznal";
	}

}
