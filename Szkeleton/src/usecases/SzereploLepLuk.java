package usecases;


import objects.*;

public class SzereploLepLuk implements UseCase{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Eszkimo sz = new Eszkimo();
		StabilJegtabla mezo1 = new StabilJegtabla(null);
		Luk mezo2 = new Luk();
		
		Palya.setAktJatekos(sz);
		sz.setMezo(mezo1);
		mezo1.setSzereplo(sz);
		mezo1.setSzomszed(mezo2);
		mezo2.setSzomszed(mezo1);
		
		sz.Atlep(mezo2);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo lukra lep";
	}

}
