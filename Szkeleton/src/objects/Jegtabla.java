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
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N")){
			System.out.print(Indentor.getIndent()+" - Van-e még hó a mezõn (Y/N) ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (answer.equals("Y")) 
			{
				System.out.print(Indentor.getIndent()+" - Nem történt átadás");
				Indentor.degLevel();
				return null;
			}else {
				Targy t = targy;
				targy = null;
				System.out.print(Indentor.getIndent()+" - Tárgy átadva");
				Indentor.degLevel();
				return t;
			}
		}
		Indentor.degLevel();
		return null;
	}
}
