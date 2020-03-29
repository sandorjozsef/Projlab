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
	 *	be�ll�tja azt hogy az �tadott kilepo m�r nem �ll az adott mezon
	 */
	public void Kiad (Szereplo kilepo){
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name()+".Kiad()");
		szereplok.remove(kilepo);
		Indentor.degLevel();
		
	}
	
	public abstract Targy Atad();
	/**
	 * 	alapb�l a k�vetkez� programk�d futna, ha az eg�sz p�lya fel lenne t�ltve hozz�,
	 *	�s p�ldak�pp k�t szomsz�dja lenne egy mez�nek.
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
	 * 	bels� �llapotv�ltoz�s, megval�s�t�sa k�s�bb
	 */
	public void HoHozzaad(int novekmeny)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".HoHozzaad()");
		
		
		Indentor.degLevel();
	}
	/**
	 * 	bels� �llapotv�ltoz�s, megval�s�t�sa k�s�bb
	 */
	public void Felderit()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".Felderit()");
		Indentor.degLevel();
		
	}
	/**
 	 *	visszaadja, hogy az adott mez�k szomsz�dosak-e, k�s�bb a saj�t attrib�tumaib�l
 	 *	fogja �sszehasonl�tani, hogy a kapott param�ter benne van-e a saj�t szomszedok t�mbj�ben
 	 */
	public boolean isSzomszed(Mezo szomszed)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".isSzomszed()");	

		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N"))
		{

			System.out.print(Indentor.getIndent()+ " - Szomsz�dos-e a k�t mez�? (Y/N) ");
	
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
	 * 	visszat�rt az elt�rolt szereplok darabsz�m�val
	 */
	public int getSzereplokSzama()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".getSzereplokSzama()");
		Indentor.degLevel();
		return szereplok.size();
		
	}
	/**
	 * minden a mez�re beiratott szerepl�t �tl�ptet a cel mez�re
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + Name() + ".Kimenekit()");
		szereplok.forEach(sz->sz.Atlep(cel));
		Indentor.degLevel();
		
	}
	/**
	 * absztrakt f�ggv�ny megval�s�t�sa a lesz�rmazottakban
	 */
	public abstract void setIglu();
	
	/**
	 * absztrakt f�ggv�ny megval�s�t�sa a lesz�rmazottakban
	 */
	public abstract void Hatas(Szereplo sz);
	
	/**
	 *	ha egy adott mez�t h�es�s s�jtja akkor ez a f�ggv�ny sz�l a saj�t �p�let�nek,
	 *	hogy hajtsa v�gre a j�t�kszab�lyok szerinti v�ltoz�sokat
	 */
	public void Hoeses()
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + Name() +".Hoeses()");
		iglu.Levon(szereplok);
		Indentor.degLevel();
		
	}
	/**
	 *	setter ami be�ll�tja az adott mez�re a param�terk�nt kapott szerepl�t,
	 *	kiirat�sa nincs, hiszen csak az inicializ�l�sn�l haszn�ljuk
	 */
	public void setSzereplo(Szereplo sz){
		
		szereplok.add(sz);
	}
	/**
 	 *	setter ami be�ll�tja az adott mez�re a param�terk�nt kapott mezot szomsz�dnak,
	 *	kiirat�sa nincs, hiszen csak az inicializ�l�sn�l haszn�ljuk
	 */
	public void setSzomszed(Mezo mezo){
		
		szomszedok.add(mezo);
	}
	/**
	 * absztrakt f�ggv�ny megval�s�t�sa a lesz�rmazottakban, felhaszn�l�sa a kiirat�sn�l kell
	 */
	public abstract String Name(); 
	
	
}
