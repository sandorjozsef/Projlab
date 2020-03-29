package objects;

import java.util.ArrayList;

import indent.Indentor;

public class Iglu extends Epulet{
	/*
	 *  nem csinál semmit, hiszen ha iglu van a mezõn akkor nem kell levonni
	 */
	@Override
	public void Levon(ArrayList<Szereplo> szereplok) {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Iglu.Levon()");
		Indentor.degLevel();
		
		
	}
	/*
	 *	tudatja a kiiratásnál hogy egy Iglun végzik az esetlegesen
	 *	mezobol nem felüldefiniált függvényt	 
	 */
	public String Name() {
		return "Iglu";
	}
}
