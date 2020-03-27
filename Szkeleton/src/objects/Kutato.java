package objects;

public class Kutato extends Szereplo{
public void SpecKepesseg(Mezo cel) {
		boolean rajta=aktmezo.isSzomszed(cel);
		if(rajta || aktmezo==cel) {
			cel.Felderit();
		}
	}
}
