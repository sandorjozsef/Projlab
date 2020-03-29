package objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import indent.Indentor;

public class InstabilJegtabla extends Jegtabla{
	private ArrayList<Szereplo> alatta;
	/*
	 *	konstruktor ami egyelõre a teherbirassal nem foglalkozik,
	 *	mert az irreleváns a szkeleton tesztelés szempontjából
	 */
			
	public InstabilJegtabla(Targy targy, int tb){
		super();
		alatta = new ArrayList<Szereplo>();
		this.targy=targy;
		
	}
	/*
	 *	függvény ami befogadja a belepo szereplot a regi mezorol
	 *	ha szomszédos mezorol jon, valamint megvizsgalja hogy az adott
	 *	instabil jegtabla elbirja-e még õt
	 */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Befogad()");
		if(isSzomszed(regi)) {
			String answer = "";
			while(!answer.equals("Y") && !answer.equals("N")){
				System.out.print(Indentor.getIndent()+" - Felfordul-e az instabil jégtábla? (Y/N) ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {
					answer = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (answer.equals("Y")) 
				{
					Felfordul();
				}
			}
			Hatas(belepo);
			Indentor.degLevel();
			return true;
		}else {
			Indentor.degLevel();
			return false;
		}
		
	}
	/*
	 *	annak függvényében hogy az sz szereplo a tabla alatt vagy felett van
	 *	megszaritja vagy elaztatja õt a függvény
	 */
	public void Hatas(Szereplo sz)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Hatas()");
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N")){
			System.out.print(Indentor.getIndent()+" - A szereplõ az instabil jégtábla felett van? (Y/N) ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (answer.equals("Y")) 
			{
				sz.Megszarit();
			}
			else
			{
				sz.Elazik();	
			}
	
		}
		Indentor.degLevel();
	}
	/*	
	 *	egyelõre nem csinál semmit, késõbb majd a tabla szereplo tömbjének
	 *	tartalmát fogja belepakolni az alatta tömbbe
	 */
	
	public void Felfordul()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Felfordul()");
		Indentor.degLevel();
	}
	/*
	 *	setter, ami a tábla alá rakja az sz Szereplot, a 
	 *	végleges programban nem lesz rá szükség hiszen csak a
	 * 	Felfordul fuggvényen keresztül juthat a tábla alá valaki,
	 * 	viszont a tesztelés inicializálásához hasznos
	 */
	public void setAlatta(Szereplo sz)
	{alatta.add(sz);}
	/*
	 *	felüldefinialt függvény ami csak a tábla alatta tömbjébõl
	 *	menekíti ki az embereket.
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Kimenekit()");
		alatta.forEach(sz->sz.Atlep(cel));	
		Indentor.degLevel();
		
	}
	/*
	 *	felüldefiniált függvény, hiszen az InstabilJegtablara nem lehet iglut
	 *	épiteni
	 */
	@Override
	public void setIglu() {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.setIglu()");
		Indentor.degLevel();
		
	}
	/*
	 * 	tudatja a kiiratásnál hogy egy InstabilJegtablan végzik az esetlegesen
	 *	mezobol nem felüldefiniált függvényt 
	 */
	public String Name() {
		return "InstabilJegtabla";
	}
}
