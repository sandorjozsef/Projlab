package objects;

import java.util.ArrayList;

import indent.Indentor;

public class Iglu extends Epulet{

	@Override
	public void Levon(ArrayList<Szereplo> szereplok) {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Iglu.Levon()");
		Indentor.degLevel();
		
	}
	
}
