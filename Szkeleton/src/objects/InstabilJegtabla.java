package objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import view.GrafNezet;


/**
 *	olyan osztály amely a játékban szereplő Instabiljégtáblát
 *	testesíti meg, és a játékszabályok alapján, ha túl sok szereplő
 *	áll rajta akkor képes felfordulni, de ugyanúgy InstabilJegtabla
 *	marad, így a szereplők nem csak felette, hanem alatta is lehetnek
 */
public class InstabilJegtabla extends Jegtabla{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8833147937894197581L;
	private int teherbiras;
	private ArrayList<Szereplo> alatta;
	
	
	/**
	 * konstruktor 
	 */
			
	public InstabilJegtabla(String id, Targy targy, int tb){
		super(id, targy);
		alatta = new ArrayList<Szereplo>();
		teherbiras = tb;
	}
	/**
	 *	függvény ami befogadja a belepo szereplot a regi mezorol
	 *	ha szomszédos mezorol jon (és visszatér logaikai változóként ezzel az információval(sikeres befogadás esetén true)),
	 *	minden mezőn lévő szereplővel érintkezik,
	 *  valamint megvizsgalja hogy az adott instabil jegtabla elbirja-e még őt. Ha nem bírja el
	 *  akkor felborul a jégtábla. Ezek után meghívódik a Hatás függvény
	 */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		if(isSzomszed(regi)) 
		{
			this.szereplok.add(belepo);
			szereplok.forEach((sz)->sz.Erintkezik());
			if(this.teherbiras<szereplok.size()) {
				Felfordul();
			}
			Hatas(belepo);
			return true;
		}else {
			return false;
		}
		
	}
	/**
	 *	annak függvényében hogy az sz szereplo a tabla alatt vagy felett van
	 *	megszaritja vagy elaztatja őt a függvény
	 */
	public void Hatas(Szereplo sz)
	{
		if (szereplok.contains(sz)) 
		{
			sz.Megszarit();
		}
		else
		{
			sz.Elazik();	
		}
	
	}
	/**	
	 *	a tabla szereplo tömbjének tartalmát pakolja bele az alatta tömbbe, és felderíti a jégtáblát,
	 *	valamint a hóvastagságát 0-ra állítja
	 */
	
	public void Felfordul()
	{
		this.setHovastagsag(0);
		this.setfelderitett(true);
		alatta.addAll(szereplok);
		szereplok.clear();
	}
	/**
	 *	felüldefiniált függvény ami csak a tábla alatta tömbjéből
	 *	menekíti ki az embereket úgy, hogy átlépteti őket a célmezőre
	 */
	public void Kimenekit(Mezo cel)
	{
		int szCount = szereplok.size();
		for(int i = 0; i<szCount;i++) {
			alatta.get(0).setLepesszam(4);
			alatta.get(0).Atlep(cel);
		}
		
	}
	/**
	 *	felüldefiniált függvény, hiszen az InstabilJegtablara nem lehet epuletet
	 *	épiteni
	 */
	@Override
	public void setEpulet(Epulet e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 	tudatja a kiiratásnál hogy egy InstabilJegtablan végzik az esetlegesen
	 *	mezobol nem felüldefiniált függvényt 
	 */
	public String Name() {
		return "InstabilJegtabla";
	}
	/**
	 * Kiírja a legfontosabb információkat a mezőről, amíg nincs grafikus felület hogy ezeket látni lehessen.
	 * A formátuma a következő soronként lebontva: id, típus , teherbírás, hóvastagság, szereplők alatta, szereplők
	 * (ha a jégtábla nincs még felderítve akkor a típus ismeretlen, a teherbírás és a szereplők alatta pedig nem 
	 * listázódik ki)
	 */ 
	@Override
	public void MezoInfo(BufferedWriter bw)
	{
		try {
			System.out.println("Nev: "+ getId());
			bw.write(getId());
			if(this.getfelderitett()) {
				System.out.println("Tipus: "+Name());	
				bw.write(" "+Name());					
			}			
			else {
				System.out.println("Tipus: Ismeretlen");
				bw.write(" ismeretlen");
				
			}
			System.out.println("hoVastagsag: "+ this.gethoVastagsag());
			bw.write(" "+this.gethoVastagsag());
			if(this.getfelderitett()) {
				System.out.println("Teherbiras: "+this.teherbiras);
				bw.write(" "+this.teherbiras);	
				System.out.print("Szereplok alatta: ");
				alatta.forEach(sz->System.out.print(" |"+ sz.getId()));
				System.out.println();
				for(int i = 0; i<alatta.size(); i++)  {	        	
		       		bw.write(" "+alatta.get(i).getId());
		        }
			}			
			System.out.println("Epulet: "+iglu.Name());
			bw.write(" "+iglu.Name());
			System.out.print("Szereplok: ");
			szereplok.forEach(sz->System.out.print(" |"+ sz.getId()));
			System.out.println();
			for(int i = 0; i<szereplok.size(); i++)  {	        	
	       		bw.write(" "+szereplok.get(i).getId());
	        }
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void FrissitNezet(GrafNezet n) {
		n.FrissitInstabilJegtabla(this, hoVastagsag == 0 && targy != null);
	}
	
	public ArrayList<Szereplo> getAlatta() {
		return alatta;
	}
	/**	
	 *Visszaadja a jégtabla teherbírását
	 */
	@Override
	public String getTeherBiras() {
		return Integer.toString(teherbiras);
	}
}
