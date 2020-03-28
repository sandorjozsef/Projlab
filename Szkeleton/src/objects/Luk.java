package objects;

import indent.Indentor;

public class Luk extends Mezo{
	public Luk() {
		super();
	}
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.Befogad()");
		
		if(isSzomszed(regi)) {
			Hatas(belepo);
			Indentor.degLevel();
			return true;
		}else {
			Indentor.degLevel();
			return false;
		}
		
	}
	public void Hatas(Szereplo sz)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.Hatas()");
		sz.Elazik();
		Indentor.degLevel();
	}
	@Override
	public Targy Atad() {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.Atad()");
		Indentor.degLevel();
		return null;
	}
	@Override
	public void setIglu() {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.setIglu()");
		Indentor.degLevel();
		
	}
}
