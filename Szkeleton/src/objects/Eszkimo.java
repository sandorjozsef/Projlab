package objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import indent.*;
	
public class Eszkimo extends Szereplo{
	

	public void SpecKepesseg(Mezo cel) {
		
		Indentor.incLevel();
		System.out.print(Indentor.getIndent()+"Eszkimo.SpecKepesseg()-\n");
		

		String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.println("Arra a mezore akarod epíteni, amin allsz ? (Y/N) ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer1 = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (answer1.equals("Y")) {
				cel.setIglu();
			}
		}

		Indentor.degLevel();

	}


}
