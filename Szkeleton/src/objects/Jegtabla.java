package objects;

public abstract class Jegtabla extends Mezo{
	public Jegtabla() {
		super();
	}
	protected Targy targy;
	public Targy Atad()
	{
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N")){
			System.out.print("Van-e m�g h� a mez�n (Y/N) ");
			answer = System.console().readLine();
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
