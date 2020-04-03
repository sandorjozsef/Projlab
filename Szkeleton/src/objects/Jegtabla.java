package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import indent.Indentor;
/**
 *	olyan absztrakt osztály amely minden olyan mezõ õse ami nem luk,
 * 	így a legfõbb különbsége, hogy van lehetõség tárgyat tárolni rajta,
 *	amit a szereplõk felvehetnek róla, ha nincs rajta hó
 */
public abstract class Jegtabla extends Mezo{
	protected Targy targy;
	
	public Jegtabla(Targy t) {
		super();
		targy = t;
	}
	
	/**
	 *	átadja a jegtablarol a tárgyat, ha nincs rajta már hó,
	 *	majd kitörli a saját attribútumai közül
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
