package objects;
import java.util.ArrayList;

public abstract class Szereplo {
	
	protected Ruha ruha;
	protected ArrayList<Targy> targy;
	protected Mezo aktmezo;
	
	public void Atlep(Mezo cel) {
		boolean siker=cel.Befogad(this, aktmezo);
		if(siker) {
			aktmezo.Kiad(this);
		}
	}
	public void Takarit() {
		aktmezo.HoHozzaad(-1);
	}
	public void TesthoHozzaad(int novekmeny) {
		
	}
	public void Felvesz() {
		//TODO : null-t addol?
		targy.add(aktmezo.Atad());
	}
	public void Hasznal(Targy targy) {
		targy.Kepesseg(this);
	}
	public Mezo getMezo() {
		return aktmezo;
	}
	public void setMezo(Mezo mezo) {
		aktmezo=mezo;  
	}
	public void Eldob(Targy targy) {
		
	}
<<<<<<< HEAD
	public abstract void SpecKepesseg(Mezo cel) ;
		
		
=======
>>>>>>> branch 'master' of https://github.com/sandorjozsef/Projlab.git
	public void setLepesszam(int a) {
		
	}
	public void Vegeztem() {
		Palya.Leptet();
	}
	public void setRuha(Ruha ruha) {
		this.ruha=ruha;
	}
	public void Elazik() {
		
	}
	public void Megszarit() {
		
	}
	public void Meghaltam() {
	
	}
	public void SpecKepesseg(Mezo cel) {
		// TODO Auto-generated method stub
		
	}
}
