package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Jegtabla extends Mezo{
	public Jegtabla() {
		super();
	}
	protected Targy targy;
	public Targy Atad()
	{
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N")){
			System.out.print("Van-e még hó a mezõn (Y/N) ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (answer.equals("Y")) 
			{
				return null;
			}else {
				return targy;
			}
		}
		return null;
	}
}
