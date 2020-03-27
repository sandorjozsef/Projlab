import java.util.ArrayList;

public abstract class Mezo {
	protected Epulet iglu;
	
	private ArrayList<Szereplo> szereplok;
	
	private ArrayList<Mezo> szomszedok;
	
	public abstract boolean Befogad (Szereplo belepo, Mezo regi);
	
	public void Kiad (Szereplo kilepo) 
		{szereplok.remove(kilepo);}
	
	public abstract Targy Atad();
	
	public Mezo ValasztSzomszed()
	{ 
		int answer = -1;
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
		return null;
	}
	
	public void HoHozzaad(int novekmeny)
	{
		//belsõ állapotváltozás, megjelenítése késõbb
	}
	
	public void Felderit()
	{
		//felderítés beállítása
	}
	
	public boolean isSzomszed(Mezo szomszed)
	{
		{ 
			String answer = "";
			while(!answer.equals("Y") && !answer.equals("N"))
			{
				System.out.print("Szomszédos-e a két mezõ? (Y/N) ");
				answer = System.console().readLine();
				if (answer.equals("Y")) 
				{
					return true;
				}
				else if (answer.equals("N"))
				{return false;}
			}
		}
	}
	
	public int getSzereplokSzama()
	{return szereplok.size();}
	
	public void Kimenekit(Mezo cel)
	{
		szereplok.get(0).Atlep(cel);
		
	}
	
	public void setIglu()
	{
		//hibaüzenetet dob majd alapból 
		
	}
	
	public abstract void Hatas(Szereplo sz);
	
	public void Hoeses()
	{
		iglu.Levon(szereplok);
	}
	
	public void setSzereplo(Szereplo sz)
	{szereplok.add(sz);}
	
	public void setSzomszed(Mezo mezo)
	{szomszedok.add(mezo);}
	
}
