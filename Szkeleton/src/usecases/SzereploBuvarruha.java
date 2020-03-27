package usecases;

import objects.*;

public class SzereploBuvarruha implements UseCase {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Kutato k = new Kutato();
		Buvarruha br = new Buvarruha();
		
		k.Hasznal(br);
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo buvarruhat hasznal";
	}

}
