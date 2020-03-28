package objects;
import java.util.*;
import indent.Indentor;

public abstract class Epulet {
	public void Levon(ArrayList<Szereplo> szereplok) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Epulet.Levon()");
		Indentor.degLevel();
	};
}
