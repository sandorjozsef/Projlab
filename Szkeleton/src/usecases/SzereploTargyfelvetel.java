package usecases;
import objects.*;
public class SzereploTargyfelvetel implements UseCase {

	@Override
	public void run() {
		// TODO Auto-generated method stub
	Kutato k = new Kutato();
	StabilJegtabla mezo = new StabilJegtabla(new Lapat());	
	Palya.setAktJatekos(k);
	k.setMezo(mezo);
	mezo.setSzereplo(k);
	
	k.Felvesz();
	
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo targyat probal felvenni";
	}

}
