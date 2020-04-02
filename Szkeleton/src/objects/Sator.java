package objects;

import java.util.ArrayList;
import indent.Indentor;

public class Sator extends Epulet implements Targy {

	private int elettartam = Palya.getSzereplokSzama();
	
	@Override
	public void Kepesseg(Szereplo felhasznalo) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Kepesseg()");
		felhasznalo.getMezo().setEpulet(this);
		Indentor.degLevel();
	}

	@Override
	public void Levon(ArrayList<Szereplo> szereplok) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Levon()");
		Indentor.degLevel();
	}

	@Override
	public String Name() 
	{
		return "Sator";
	}

	@Override
	public boolean Amortizacio() 
	{
		return (--elettartam <= 0);
	}

	@Override
	public void Tamadas() 
	{
		Palya.JatekVege(false);
	}

}
