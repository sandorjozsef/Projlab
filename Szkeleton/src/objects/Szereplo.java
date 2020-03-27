package objects;
import java.util.ArrayList;

import indent.Indentor;

public abstract class Szereplo {
	
	protected Ruha ruha;
	protected ArrayList<Targy> targyak;
	protected Mezo aktmezo;
	
	public void Atlep(Mezo cel) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.Atlep()");
		
		
		boolean siker=cel.Befogad(this, aktmezo);
		if(siker) {
			aktmezo.Kiad(this);
		}
		Indentor.degLevel();
	}
	public void Takarit() {
		aktmezo.HoHozzaad(-1);
	}
	public void TesthoHozzaad(int novekmeny) {
		
	}
	public void Felvesz() {
		//TODO : null-t addol?
		targyak.add(aktmezo.Atad());
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
	public abstract void SpecKepesseg(Mezo cel) ;
		
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
	
}
