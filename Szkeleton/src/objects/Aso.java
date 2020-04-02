package objects;

import indent.Indentor;

public class Aso implements Targy{
	private int elettartam = 3;
	
	@Override
	public void Kepesseg(Szereplo felhasznalo) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Kepesseg()");	
		felhasznalo.getMezo().HoHozzaad(-2);
		--elettartam;
		if (elettartam <= 0)
			felhasznalo.Eldob(this);
		Indentor.degLevel();
	}

	@Override
	public String Name() 
	{
		return "Aso";
	}
	
}
