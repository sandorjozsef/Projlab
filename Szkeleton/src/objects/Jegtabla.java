package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import indent.Indentor;
/**
 *    olyan absztrakt osztály amely minden olyan mező őse ami nem luk,
 *     így a legfőbb különbsége, hogy van lehetőség tárgyat tárolni rajta,
 *    amit a szereplők felvehetnek róla, ha nincs rajta hó
 */
public abstract class Jegtabla extends Mezo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7327036173303629364L;
	private Targy targy;
	
	public Jegtabla(Targy t) {
		super();
		targy = t;
	}
	
	/**
     *    átadja a jegtablarol a tárgyat, ha nincs rajta már hó,
     *    majd kitörli a saját attribútumai közül
     */
	public Targy Atad()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".Atad()");
		if (this.gethoVastagsag()!=0) 
		{
			Indentor.degLevel();
			return null;
		}
		else
		{
			Targy t = targy;
			targy = null;
			Indentor.degLevel();
			return t;
		}
		
	}
}
