package objects;
import indent.Indentor;

public class Lapat implements Targy{

	@Override
	public void Kepesseg(Szereplo felhasznalo) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Lapat.Kepesseg()");
		
		
		felhasznalo.getMezo().HoHozzaad(-2);
		
		Indentor.degLevel();
		
	}
	public String Name() {
		return "Lapat";
	}

}
