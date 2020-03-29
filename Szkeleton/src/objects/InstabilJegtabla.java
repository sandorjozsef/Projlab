package objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import indent.Indentor;

public class InstabilJegtabla extends Jegtabla{
	private ArrayList<Szereplo> alatta;
	/**
	 *	konstruktor ami egyel�re a teherbirassal nem foglalkozik,
	 *	mert az irrelev�ns a szkeleton tesztel�s szempontj�b�l
	 */
			
	public InstabilJegtabla(Targy targy, int tb){
		super();
		alatta = new ArrayList<Szereplo>();
		this.targy=targy;
		
	}
	/**
	 *	f�ggv�ny ami befogadja a belepo szereplot a regi mezorol
	 *	ha szomsz�dos mezorol jon, valamint megvizsgalja hogy az adott
	 *	instabil jegtabla elbirja-e m�g �t
	 */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Befogad()");
		if(isSzomszed(regi)) {
			String answer = "";
			while(!answer.equals("Y") && !answer.equals("N")){
				System.out.print(Indentor.getIndent()+" - Felfordul-e az instabil j�gt�bla? (Y/N) ");
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
	/**
	 *	annak f�ggv�ny�ben hogy az sz szereplo a tabla alatt vagy felett van
	 *	megszaritja vagy elaztatja �t a f�ggv�ny
	 */
	public void Hatas(Szereplo sz)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Hatas()");
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N")){
			System.out.print(Indentor.getIndent()+" - A szerepl� az instabil j�gt�bla felett van? (Y/N) ");
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
	/**	
	 *	egyel�re nem csin�l semmit, k�s�bb majd a tabla szereplo t�mbj�nek
	 *	tartalm�t fogja belepakolni az alatta t�mbbe
	 */
	
	public void Felfordul()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Felfordul()");
		Indentor.degLevel();
	}
	/**
	 *	setter, ami a t�bla al� rakja az sz Szereplot, a 
	 *	v�gleges programban nem lesz r� sz�ks�g hiszen csak a
	 * 	Felfordul fuggv�nyen kereszt�l juthat a t�bla al� valaki,
	 * 	viszont a tesztel�s inicializ�l�s�hoz hasznos
	 */
	public void setAlatta(Szereplo sz)
	{alatta.add(sz);}
	/**
	 *	fel�ldefinialt f�ggv�ny ami csak a t�bla alatta t�mbj�b�l
	 *	menek�ti ki az embereket.
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Kimenekit()");
		alatta.forEach(sz->sz.Atlep(cel));	
		Indentor.degLevel();
		
	}
	/**
	 *	fel�ldefini�lt f�ggv�ny, hiszen az InstabilJegtablara nem lehet iglut
	 *	�piteni
	 */
	@Override
	public void setIglu() {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.setIglu()");
		Indentor.degLevel();
		
	}
	/**
	 * 	tudatja a kiirat�sn�l hogy egy InstabilJegtablan v�gzik az esetlegesen
	 *	mezobol nem fel�ldefini�lt f�ggv�nyt 
	 */
	public String Name() {
		return "InstabilJegtabla";
	}
}
