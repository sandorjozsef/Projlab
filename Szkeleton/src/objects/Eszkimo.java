package objects;
import indent.*;
	
public class Eszkimo extends Szereplo{
	

	public void SpecKepesseg(Mezo cel) {

		String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.print("Arra a mezore akarod epíteni, amin allsz ? (Y/N) ");
			answer1 = System.console().readLine();
			if (answer1.equals("Y")) {
				cel.setIglu();
			}
		}

		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Eszkimo.SpecKepesseg()\n");
		Indentor.degLevel();

	}


}
