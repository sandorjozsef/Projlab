package objects;
import indent.Indentor;

public class Elelem implements Targy {
	public void Kepesseg(Szereplo felhasznalo)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Elelem.Kepesseg()");
		felhasznalo.TesthoHozzaad(1);
		felhasznalo.Eldob(this);
		Indentor.degLevel();
	}
}
