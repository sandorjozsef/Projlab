package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import indent.Indentor;

public abstract class Jegtabla extends Mezo{
	public Jegtabla() {
		super();
	}
	protected Targy targy;
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
				Indentor.degLevel();
				return null;
			}else {
				Targy t = targy;
				targy = null;
				Indentor.degLevel();
				return t;
			}
		}
		Indentor.degLevel();
		return null;
	}
}
