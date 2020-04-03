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
	private int teherbiras;
	private ArrayList<Szereplo> alatta;
	
	/**
	 *	konstruktor 
	 */		
	public InstabilJegtabla(Targy targy, int tb){
		super(targy);
		alatta = new ArrayList<Szereplo>();
		teherbiras = tb;
	}
	/**
	 *	függvény ami befogadja a belepo szereplot a regi mezorol
	 *	ha szomszédos mezorol jon, valamint megvizsgalja hogy az adott
	 *	instabil jegtabla elbirja-e még őt
	 */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Befogad()");
		if(isSzomszed(regi)) 
		{
			this.szereplok.add(belepo);
			if(this.teherbiras<szereplok.size()) {
				Felfordul();
			}
			Hatas(belepo);
			if (medve != null)
				medve.Tamadas();
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
	 *	a tabla szereplo tömbjének tartalmát pakolja bele az alatta tömbbe
	 */
	
	public void Felfordul()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Felfordul()");
		alatta=szereplok;
		szereplok.clear();
		Indentor.degLevel();
	}
	/**
	 *	setter, ami a tábla alá rakja az sz Szereplot, a 
	 *	végleges programban nem lesz rá szükség hiszen csak a
	 * 	Felfordul fuggvünyen keresztül juthat a tábla alá valaki,
	 * 	viszont a tesztelés inicializálásához hasznos
	 */
	public void setAlatta(Szereplo sz)
	{alatta.add(sz);}
	/**
	 *	felüldefiniált függvény ami csak a tábla alatta tömbjéből
	 *	menekíti ki az embereket.
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Kimenekit()");
		alatta.forEach(sz->sz.Atlep(cel));	
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
}
