package objects;
import indent.Indentor;

public class Kotel implements Targy{
	public void Kepesseg(Szereplo sz) {
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + "Kotel.Kepesseg()");
		
		
		Mezo akt_mezo = sz.getMezo();
		Mezo honnan = akt_mezo.ValasztSzomszed();
		honnan.Kimenekit(akt_mezo);
		
		
		Indentor.degLevel();
		return;
	}
}
