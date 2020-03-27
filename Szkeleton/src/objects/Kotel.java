package objects;
import indent.Indentor;

public class Kotel implements Targy{
	public void Kepesseg(Szereplo sz) {
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + "Kotel.Kepesseg()");
		
		
		StabilJegtabla akt_mezo = (StabilJegtabla)sz.getMezo();
		Luk luk = (Luk)akt_mezo.ValasztSzomszed();
		luk.Kimenekit(akt_mezo);
		
		
		Indentor.degLevel();
		return;
	}
}
