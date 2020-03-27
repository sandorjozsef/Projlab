package objects;
import java.util.ArrayList;

public class InstabilJegtabla extends Jegtabla{
	private ArrayList<Szereplo> alatta;
	public InstabilJegtabla(Targy targy, int tb)
	{this.targy=targy;}
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		if(isSzomszed(regi)) {
			String answer = "";
			while(!answer.equals("Y") && !answer.equals("N")){
				System.out.print("Felfordul-e az instabil jégtábla? (Y/N) ");
				answer = System.console().readLine();
				if (answer.equals("Y")) 
				{
					Felfordul();
				}
			}
			Hatas(belepo);
			return true;
		}else {
			return false;
		}
		
	}
	public void Hatas(Szereplo sz)
	{
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N")){
			System.out.print("A szereplõ az instabil jégtábla fett van? (Y/N) ");
			answer = System.console().readLine();
			if (answer.equals("Y")) 
			{
				sz.Megszarit();
			}
			else {
				sz.Elazik();
			}
		}
	}
	public void Felfordul()
	{}
	public void setAlatta(Szereplo sz)
	{alatta.add(sz);}
	public void Kimenekit(Mezo cel)
	{
		alatta.get(0).Atlep(cel);
		
	}
}
