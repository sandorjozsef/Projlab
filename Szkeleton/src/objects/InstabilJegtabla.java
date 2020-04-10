package objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import indent.Indentor;
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
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Befogad()");
		if(isSzomszed(regi)) 
		{
			this.szereplok.add(belepo);
			szereplok.forEach((sz)->sz.Erintkezik());
			if(this.teherbiras<szereplok.size()) {
				Felfordul();
			}
			Hatas(belepo);
			Indentor.degLevel();
			return true;
		}else {
			Indentor.degLevel();
			return false;
		}
		
	}
	/**
	 *	annak függvényében hogy az sz szereplo a tabla alatt vagy felett van
	 *	megszaritja vagy elaztatja őt a függvény
	 */
	public void Hatas(Szereplo sz)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Hatas()");
		if (szereplok.contains(sz)) 
		{
			sz.Megszarit();
		}
		else
		{
			sz.Elazik();	
		}
	
		
		Indentor.degLevel();
	}
	/**	
	 *	a tabla szereplo tömbjének tartalmát pakolja bele az alatta tömbbe, és felderíti a jégtáblát,
	 *	valamint a hóvastagságát 0-ra állítja
	 */
	
	public void Felfordul()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Felfordul()");
		this.setHovastagsag(0);
		this.setfelderitett(true);
		alatta=szereplok;
		szereplok.clear();
		Indentor.degLevel();
	}
	/**
	 *	felüldefiniált függvény ami csak a tábla alatta tömbjéből
	 *	menekíti ki az embereket úgy, hogy átlépteti őket a célmezőre
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Kimenekit()");
		int szCount = szereplok.size();
		for(int i = 0; i<szCount;i++) {
			alatta.get(0).setLepesszam(4);
			alatta.get(0).Atlep(cel);
		}
		Indentor.degLevel();
		
	}
	/**
	 *	felüldefiniált függvény, hiszen az InstabilJegtablara nem lehet epuletet
	 *	épiteni
	 */
	@Override
	public void setEpulet(Epulet e) {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.setIglu()");
		Indentor.degLevel();
		
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
	public void MezoInfo()
	{
		System.out.println("Nev: "+ getId());
		if(this.getfelderitett()) {
			System.out.println("Tipus: "+Name());	
			System.out.println("Teherbiras: "+this.teherbiras);	
		}			
		else
			System.out.println("Tipus: Ismeretlen");
		System.out.println("hoVastagsag: "+ this.gethoVastagsag());
		if(this.getfelderitett()) {
			System.out.print("Szereplok alatta: ");
			alatta.forEach(sz->System.out.print(" |"+ sz.getId()));
			System.out.println();
		}			
		
		System.out.print("Szereplok: ");
		szereplok.forEach(sz->System.out.print(" |"+ sz.getId()));
		System.out.println();
	}
}
