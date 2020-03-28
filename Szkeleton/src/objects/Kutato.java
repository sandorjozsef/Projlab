package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import indent.Indentor;

public class Kutato extends Szereplo{
public void SpecKepesseg(Mezo cel) {

		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Kutato.SpecKepesseg()");
		
		//
		
		boolean szomszed=aktmezo.isSzomszed(cel);
		if(szomszed) {
			cel.Felderit();
		}
		else {	
			String answer1 = "";
			while (!answer1.equals("Y") && !answer1.equals("N")) {
				System.out.print(Indentor.getIndent()+" - A felderitendo mezo az aktuális mezo? ? (Y/N) ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {
					answer1 = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (answer1.equals("Y")) {
					cel.Felderit();
				}
			}
		}
		
		
		Indentor.degLevel();
	}
	public void Hasznal(Targy t) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Kutato.Hasznal()");
		
		t.Kepesseg(this);
		
		
		Indentor.degLevel();
	}
}
