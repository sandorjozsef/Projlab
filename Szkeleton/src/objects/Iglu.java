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
		// nem csin�l semmit, hiszen ha iglu van a mez�n akkor nem kell levonni
		
	}
	public String Name() {
		return "Iglu";
		//tudatja a kiirat�sn�l hogy egy Iglun v�gzik az esetlegesen
		//mezobol nem fel�ldefini�lt f�ggv�nyt
	}
}
