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
	
	public Mezo(){
		iglu = new Noglu();
		szereplok = new ArrayList<Szereplo>();
		szomszedok = new ArrayList<Mezo>();
		/*
		 	Mezo konstruktor ami alapból az iglu attribútumot noglura állítja,
		 	hiszen alapból egyik mezõn sincs iglu. 
		 */
		
	}
	
	public abstract boolean Befogad (Szereplo belepo, Mezo regi);
	
	public void Kiad (Szereplo kilepo){
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name()+".Kiad()");
		szereplok.remove(kilepo);
		Indentor.degLevel();
		//beállítja azt hogy az átadott kilepo már nem áll az adott mezon
	}
	
	public abstract Targy Atad();
	
	public Mezo ValasztSzomszed()
	{ 
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".ValasztSzomszed()");
		/* alapból a következõ programkód futna, ha az egész pálya fel lenne töltve hozzá,
		 	és példaképp két szomszédja lenne egy mezõnek.
			int answer = -1;
			while(answer!=0&&answer!=1)
			{
				System.out.print("Melyik szomszéd mezõe lép?(0/1)");
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
	
	public void HoHozzaad(int novekmeny)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".HoHozzaad()");
		//belsõ állapotváltozás, megvalósítása késõbb
		
		Indentor.degLevel();
	}
	
	public void Felderit()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".Felderit()");
		Indentor.degLevel();
		//belsõ állapotváltozás, megvalósítása késõbb
	}
	
	public boolean isSzomszed(Mezo szomszed)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".isSzomszed()");	

		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N"))
		{

			System.out.print(Indentor.getIndent()+ " - Szomszédos-e a két mezõ? (Y/N) ");
	
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
		/*
		 	visszaadja, hogy az adott mezõk szomszédosak-e, késõbb a saját attribútumaiból
		 	fogja összehasonlítani, hogy a kapott paraméter benne van-e a saját szomszedok tömbjében
		 */
	}
	
	public int getSzereplokSzama()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".getSzereplokSzama()");
		Indentor.degLevel();
		return szereplok.size();
		//visszatért az eltárolt szereplok darabszámával
	}
	
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + Name() + ".Kimenekit()");
		szereplok.forEach(sz->sz.Atlep(cel));
		Indentor.degLevel();
		//minden a mezõre beiratott szereplõt átléptet a cel mezõre
	}
	
	public abstract void setIglu();
	//absztrakt függvény megvalósítása a leszármazottakban
	
	public abstract void Hatas(Szereplo sz);
	//absztrakt függvény megvalósítása a leszármazottakban
	
	public void Hoeses()
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + Name() +".Hoeses()");
		iglu.Levon(szereplok);
		Indentor.degLevel();
		//ha egy adott mezõt hóesés sújtja akkor ez a függvény szól a saját épületének,
		//hogy hajtsa végre a játékszabályok szerinti változásokat
	}
	
	public void setSzereplo(Szereplo sz){
		/*
			setter ami beállítja az adott mezõre a paraméterként kapott szereplõt,
			kiiratása nincs, hiszen csak az inicializálásnál használjuk
		 */
		szereplok.add(sz);
	}
	
	public void setSzomszed(Mezo mezo){
		/* 
		 	setter ami beállítja az adott mezõre a paraméterként kapott mezot szomszédnak,
			kiiratása nincs, hiszen csak az inicializálásnál használjuk
		 */
		szomszedok.add(mezo);
	}
	public abstract String Name();
	//absztrakt függvény megvalósítása a leszármazottakban, felhasználása a kiiratásnál kell
	
}
