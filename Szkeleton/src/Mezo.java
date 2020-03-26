import java.util.ArrayList;

public abstract class Mezo {
	private Epulet iglu;
	private ArrayList<Szereplo> szereplok;
	public abstract boolean Befogad (Szereplo belepo, Mezo regi);
	public void Kiad (Szereplo kilepo) 
	{}
	public abstract Targy Atad();
	public Mezo ValasztSzomszed()
	{}
	public void HoHozzaad(int novekmeny)
	{}
	public void Felderit()
	{}
	public boolean isSzomszed(Mezo szomszed)
	{}
	public int getSzereplokSzama()
	{}
	public void Kimenekit(Mezo cecl)
	{}
	public void setIglu()
	{}
	public abstract void Hatas(Szereplo sz);
	public void Hoeses()
	{}
	public void setSzereplo(Szereplo sz)
	{}
	
	
}
