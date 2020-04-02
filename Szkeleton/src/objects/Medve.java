package objects;
import indent.Indentor;

public class Medve extends Lepheto {

	@Override
	public void Atlep(Mezo cel) 
	{
		aktmezo.MedveKiad();
		cel.setMedve(this);
		setMezo(cel);
		Tamadas();
	}

	@Override
	public String Name() 
	{
		return "Medve";
	}

	public void Tamadas()
	{
		aktmezo.Tamadas();
	}
}
