package objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import indent.Indentor;

public class InstabilJegtabla extends Jegtabla{
	private ArrayList<Szereplo> alatta;
	public InstabilJegtabla(Targy targy, int tb){
		super();
		alatta = new ArrayList<Szereplo>();
		this.targy=targy;
	}
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.print(Indentor.getIndent()+"InstabilJegtabla.Befogad() - ");
		if(isSzomszed(regi)) {
			String answer = "";
			while(!answer.equals("Y") && !answer.equals("N")){
				System.out.print("Felfordul-e az instabil j�gt�bla? (Y/N) ");
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
	public void Hatas(Szereplo sz)
	{
		Indentor.incLevel();
		System.out.print(Indentor.getIndent()+"InstabilJegtabla.Hatas() - ");
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N")){
			System.out.print("A szerepl� az instabil j�gt�bla fett van? (Y/N) ");
			answer = System.console().readLine();
			if (answer.equals("Y")) 
			{
				sz.Megszarit();
			}
			else {
				sz.Elazik();
			}
		}
		Indentor.degLevel();
	}
	public void Felfordul()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Felfordul()");
		Indentor.degLevel();
	}
	public void setAlatta(Szereplo sz)
	{alatta.add(sz);}
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.Kimenekit()");
		alatta.get(0).Atlep(cel);
		Indentor.degLevel();
		
	}
	@Override
	public void setIglu() {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"InstabilJegtabla.setIglu()");
		Indentor.degLevel();
		
	}
}
