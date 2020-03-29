package objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		System.out.println(Indentor.getIndent() + Name() + ".Atlep()");
		
		
		boolean siker=cel.Befogad(this, aktmezo);
		if(siker) {
			aktmezo.Kiad(this);
		}
		Indentor.degLevel();
	}
	public void Takarit() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Takarit()");
		aktmezo.HoHozzaad(-1);
		Indentor.degLevel();
	}
	/**
	 * 
	 * Noveli vagy csokkenti a szereplo testhojet a parameterrel.
	 *
	 */
	
	
	public void TesthoHozzaad(int novekmeny) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".TesthoHozzaad()");
		String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.print(Indentor.getIndent()+" - 0 lett a testho? (Y/N) ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer1 = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (answer1.equals("Y")) {
				this.Meghaltam();
			}
		}
		Indentor.degLevel();
	}
	public void Felvesz() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Felvesz()");
		//TODO : null-t addol?
		Targy t = aktmezo.Atad();
		if(t!=null)
			targyak.add(t);
		Indentor.degLevel();
	}
	public void Hasznal(Targy targy) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Hasznal()");
		targy.Kepesseg(this);
		Indentor.degLevel();
	}
	public Mezo getMezo() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".getMezo()");
		Indentor.degLevel();
		return aktmezo;
	}
	public void setMezo(Mezo mezo) {
		aktmezo=mezo;  
		/* Beállitja a mezőt, amin a szereplő áll
		 * Inicializáló függvény nem jelezzük a konzolon, hogy lefutott
		 */
	}
	public void Eldob(Targy targy) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Eldob()");
		Indentor.degLevel();
	}
	public abstract void SpecKepesseg(Mezo cel) ;
		
	public void setLepesszam(int a) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".setLepesszam()");
		Indentor.degLevel();
	}
	public void Vegeztem() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Vegeztem()");
		Palya.Leptet();
		Indentor.degLevel();
	}
	public void setRuha(Ruha ruha) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".setRuha()");
		this.ruha=ruha;
		Indentor.degLevel();
	}
	public void Elazik() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Elazik()");
		ruha.Elazik(this);
		Indentor.degLevel();
	}
	public void Megszarit() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Megszarit()");
		ruha.Megszarit();
		Indentor.degLevel();
	}
	public void Meghaltam() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Meghaltam()");
		Palya.JatekVege(false);
		Indentor.degLevel();
	}
	public abstract String Name();
	
}
