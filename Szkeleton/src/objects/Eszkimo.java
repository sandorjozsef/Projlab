package objects;
<<<<<<< HEAD

public class Eszkimo extends Szereplo {
	
=======
import indent.*;
public class Eszkimo extends Szereplo{
	@Override
>>>>>>> branch 'master' of https://github.com/sandorjozsef/Projlab.git
	public void SpecKepesseg(Mezo cel) {
<<<<<<< HEAD
		String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.print("Arra a mezőre akarod építeni, amin állsz ? (Y/N) ");
			answer1 = System.console().readLine();
			if (answer1.equals("Y")) {
				cel.setIglu();
			}
		}
=======
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Eszkimo.SpecKepesseg()\n");
		
		
		
		
		
		
		Indentor.degLevel();
>>>>>>> branch 'master' of https://github.com/sandorjozsef/Projlab.git
	}
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/sandorjozsef/Projlab.git
	
}
