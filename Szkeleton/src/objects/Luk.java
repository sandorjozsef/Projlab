package objects;

public class Luk extends Mezo{
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		if(isSzomszed(regi)) {
			Hatas(belepo);
			return true;
		}else {
			return false;
		}
		
	}
	public void Hatas(Szereplo sz)
	{
		sz.Elazik();
	}
	@Override
	public Targy Atad() {
		// TODO Auto-generated method stub
		return null;
	}
}