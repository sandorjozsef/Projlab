package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import indent.Indentor;

public class Kutato extends Szereplo{
public void SpecKepesseg(Mezo cel) {
		/*boolean rajta=aktmezo.isSzomszed(cel);
		if(rajta || aktmezo==cel) {
			cel.Felderit();
		}*/
	Indentor.incLevel();
	System.out.print(Indentor.getIndent()+"Kutato.SpecKepesseg()-");
		String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.print("Aktualis vagy szomszedos mezot akarsz felderiteni ? (Y/N) ");
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
			if (answer1.equals("N")) {
				System.out.println(Indentor.getIndent()+"Felderites sikertelen");
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
