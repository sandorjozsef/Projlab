package objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import indent.Indentor;

public abstract class Mezo {
	protected Epulet iglu;
	
	private ArrayList<Szereplo> szereplok;
	
	private ArrayList<Mezo> szomszedok;
	
	public Mezo(){
		iglu = new Noglu();
		szereplok = new ArrayList<Szereplo>();
		szomszedok = new ArrayList<Mezo>();
		
	}
	
	public abstract boolean Befogad (Szereplo belepo, Mezo regi);
	
	public void Kiad (Szereplo kilepo){
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Mezo.Kiad()");
		szereplok.remove(kilepo);
		
		
		Indentor.degLevel();
	}
	
	public abstract Targy Atad();
	
	public Mezo ValasztSzomszed()
	{ 
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Mezo.ValasztSzomszed()");
		/*int answer = -1;
		while(answer!=0&&answer!=1)
		{
			System.out.print("Melyik szomszéd mezõre lép?(0/1)");
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
		return null;*/
		Indentor.degLevel();
		return szomszedok.get(0);
	}
	
	public void HoHozzaad(int novekmeny)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Mezo.HoHozzaad()");
		//belsõ állapotváltozás, megjelenítése késõbb
		
		Indentor.degLevel();
	}
	
	public void Felderit()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Mezo.Felderit()");
		Indentor.degLevel();
		//felderítés beállítása
	}
	
	public boolean isSzomszed(Mezo szomszed)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Mezo.isSzomszed()");
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N"))
		{
			System.out.print(Indentor.getIndent()+"Szomszédos-e a két mezõ? (Y/N) ");
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
	
	public int getSzereplokSzama()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Mezo.getSzereplokSzama()");
		Indentor.degLevel();
		return szereplok.size();
	}
	
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + "Mezo.Kimenekit()");
		szereplok.forEach(sz->sz.Atlep(cel));
		Indentor.degLevel();
	}
	
	public abstract void setIglu();
	
	
	public abstract void Hatas(Szereplo sz);
	
	public void Hoeses()
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + "Mezo.Hoeses()");
		iglu.Levon(szereplok);
		Indentor.degLevel();
	}
	
	public void setSzereplo(Szereplo sz){
		szereplok.add(sz);
	}
	
	public void setSzomszed(Mezo mezo){
		szomszedok.add(mezo);
	}
	
}
