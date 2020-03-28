package objects;
import java.util.ArrayList;

import indent.Indentor;

public abstract class Szereplo {
	
	protected Ruha ruha; 
	protected ArrayList<Targy> targyak;
	protected Mezo aktmezo;
	Szereplo(){
		targyak = new ArrayList<Targy>();
		ruha=new AlapRuha();
	}
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
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.Takarit()");
		aktmezo.HoHozzaad(-1);
		Indentor.degLevel();
	}
	public void TesthoHozzaad(int novekmeny) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.TesthoHozzaad()");
		Indentor.degLevel();
	}
	public void Felvesz() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.Felvesz()");
		//TODO : null-t addol?
		Targy t = aktmezo.Atad();
		if(t!=null)
			targyak.add(t);
		Indentor.degLevel();
	}
	public void Hasznal(Targy targy) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.Hasznal()");
		targy.Kepesseg(this);
		Indentor.degLevel();
	}
	public Mezo getMezo() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.getMezo()");
		Indentor.degLevel();
		return aktmezo;
	}
	public void setMezo(Mezo mezo) {
		aktmezo=mezo;  
	}
	public void Eldob(Targy targy) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.Eldob()");
		Indentor.degLevel();
	}
	public abstract void SpecKepesseg(Mezo cel) ;
		
	public void setLepesszam(int a) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.setLepesszam()");
		Indentor.degLevel();
	}
	public void Vegeztem() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.Vegeztem()");
		Palya.Leptet();
		Indentor.degLevel();
	}
	public void setRuha(Ruha ruha) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.setRuha()");
		this.ruha=ruha;
		Indentor.degLevel();
	}
	public void Elazik() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.Elazik()");
		ruha.Elazik(this);
		Indentor.degLevel();
	}
	public void Megszarit() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.Megszarit()");
		ruha.Megszarit();
		Indentor.degLevel();
	}
	public void Meghaltam() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Szereplo.Meghaltam()");
		Indentor.degLevel();
	}
	
}
