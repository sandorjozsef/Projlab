package usecases;
import objects.*;
public class EszkimoIglutEpit implements UseCase{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		StabilJegtabla akt_mezo = new StabilJegtabla(new Lapat());
		Eszkimo sz = new Eszkimo();
		sz.setMezo(akt_mezo);
		
		sz.SpecKepesseg(akt_mezo);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Eszkimo megprobal iglut tenni egy mezore";
		
	}

}
