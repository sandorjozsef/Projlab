package objects;

public class Buvarruha extends Ruha implements Targy {
	public void Kepesseg(Szereplo felhasznalo)
	{
		felhasznalo.setRuha(this);
	}
}
