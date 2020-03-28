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
		System.out.print(Indentor.getIndent()+"Jegtabla.Atad() - ");
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N")){
			System.out.print("Van-e m�g h� a mez�n (Y/N) ");
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
				Indentor.degLevel();
				return targy;
			}
		}
		Indentor.degLevel();
		return null;
	}
}
