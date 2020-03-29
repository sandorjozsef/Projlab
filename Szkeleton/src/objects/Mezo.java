package objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import indent.Indentor;

public abstract class Mezo {
	protected Epulet iglu;
	
	protected ArrayList<Szereplo> szereplok;
	
	private ArrayList<Mezo> szomszedok;
	/**
 	 *	Mezo konstruktor ami alapból az iglu attribútumot noglura állítja,
 	 *	hiszen alapból egyik mezőn sincs iglu. 
	 */
	public Mezo(){
		iglu = new Noglu();
		szereplok = new ArrayList<Szereplo>();
		szomszedok = new ArrayList<Mezo>();
		
		
	}
	
	public abstract boolean Befogad (Szereplo belepo, Mezo regi);
	/**
	 *	beállítja azt hogy az átadott kilepo már nem áll az adott mezon
	 */
	public void Kiad (Szereplo kilepo){
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name()+".Kiad()");
		szereplok.remove(kilepo);
		Indentor.degLevel();
		
	}
	
	public abstract Targy Atad();
	/**
	 * 	alapból a következő programkód futna, ha az egész pálya fel lenne töltve hozzá,
	 *	és példaképp két szomszédja lenne egy mezőnek.
	 */
	public Mezo ValasztSzomszed()
	{ 
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".ValasztSzomszed()");
		
		int answer = -1;
		 /*
			while(answer!=0&&answer!=1)
			{
				System.out.print("Melyik szomsz�d mez�e l�p?(0/1)");
				answer = Integer.parseInt(System.console().readLine());
				if (answer==0) 
				{
					return szomszedok.get(0);
				}
				else if (answer==1)
				{
					return szomszedok.get(1);
				}
			}
			return null;
		*/
		Indentor.degLevel();
		return szomszedok.get(0);
	}
	/**
	 * 	belső állapotváltozás, megvalósítása később
	 */
	public void HoHozzaad(int novekmeny)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".HoHozzaad()");
		
		
		Indentor.degLevel();
	}
	/**
	 * 	belső állapotváltozás, megvalósítása később
	 */
	public void Felderit()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".Felderit()");
		Indentor.degLevel();
		
	}
	/**
 	 *	visszaadja, hogy az adott mezők szomszédosak-e, később a saját attribútumaiból
 	 *	fogja összehasonlítani, hogy a kapott paraméter benne van-e a saját szomszedok tömbjében
 	 */
	public boolean isSzomszed(Mezo szomszed)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".isSzomszed()");	

		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N"))
		{

			System.out.print(Indentor.getIndent()+ " - Szomszédos-e a két mező? (Y/N) ");
	
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (answer.equals("Y")) 
			{
				Indentor.degLevel();
				return true;
			}
			else if (answer.equals("N"))
			{
				Indentor.degLevel();
				return false;}
			}
		Indentor.degLevel();
		return false;
		
	}
	/**
	 * 	visszatér az eltárolt szereplok darabszámával
	 */
	public int getSzereplokSzama()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".getSzereplokSzama()");
		Indentor.degLevel();
		return szereplok.size();
		
	}
	/**
	 * minden, a mezőre beiratott szereplőt átléptet a cel mezőre
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + Name() + ".Kimenekit()");
		szereplok.forEach(sz->sz.Atlep(cel));
		Indentor.degLevel();
		
	}
	/**
	 * absztrakt függvény megvalósítása a leszármazottakban
	 */
	public abstract void setIglu();
	
	/**
	 * absztrakt függvény megvalósítása a leszármazottakban
	 */
	public abstract void Hatas(Szereplo sz);
	
	/**
	 *	ha egy adott mezőt hóesés sújtja akkor ez a függvény szól a saját épületének,
	 *	hogy hajtsa végre a játékszabályok szerinti változásokat
	 */
	public void Hoeses()
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + Name() +".Hoeses()");
		iglu.Levon(szereplok);
		Indentor.degLevel();
		
	}
	/**
	 *	setter ami beállítja az adott mezőre a paraméterként kapott szereplőt,
	 *	kiiratása nincs, hiszen csak az inicializálásnál használjuk
	 */
	public void setSzereplo(Szereplo sz){
		
		szereplok.add(sz);
	}
	/**
 	 *	setter ami beállítja az adott mezőre a paraméterként kapott mezot szomszédnak,
	 *	kiiratása nincs, hiszen csak az inicializálásnál használjuk
	 */
	public void setSzomszed(Mezo mezo){
		
		szomszedok.add(mezo);
	}
	/**
	 * absztrakt függvény megvalósítása a leszármazottakban, felhasználása a kiiratásnál kell
	 */
	public abstract String Name(); 
	
	
}
