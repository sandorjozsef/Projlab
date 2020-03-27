package objects;
import indent.Indentor;

public class Kotel implements Targy{
	public void Kepesseg(Szereplo sz) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Kotel.Kepesseg()");
		sz.getMezo().ValasztSzomszed().Kimenekit(sz.getMezo());
		Indentor.degLevel();
		return;
	}
}
