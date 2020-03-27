package objects;

public class Kotel implements Targy{
	public void Kepesseg(Szereplo sz) {
		sz.getMezo().ValasztSzomszed().Kimenekit(sz.getMezo());
		return;
	}
}
