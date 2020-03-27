package usecases;
import objects.*;
public class SzereploEszik implements UseCase {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Kutato k = new Kutato();
		Elelem etel = new Elelem();
		
		
		k.Hasznal(etel);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo etelt eszik";
	}

}
