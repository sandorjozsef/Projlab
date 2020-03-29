package objects;
import indent.Indentor;

public class Buvarruha extends Ruha implements Targy {
	public void Kepesseg(Szereplo felhasznalo)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Buvarruha.Kepesseg()");
		felhasznalo.setRuha(this);
		Indentor.degLevel();
	}

	@Override
	public void Elazik(Szereplo szereplo) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Buvarruha.Elazik()");
		Indentor.degLevel();
	}

	@Override
	public void Megszarit() 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Buvarruha.Megszarit()");
		Indentor.degLevel();
	}
	public String Name() {
		return "Buvarruha";
	}
}
