package objects;

import indent.Indentor;

public class Kutato extends Szereplo{
public void SpecKepesseg(Mezo cel) {
		boolean rajta=aktmezo.isSzomszed(cel);
		if(rajta || aktmezo==cel) {
			cel.Felderit();
		}
	}
	public void Hasznal(Targy t) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Kutato.Hasznal()");
		
		t.Kepesseg(this);
		
		
		Indentor.degLevel();
	}
}
