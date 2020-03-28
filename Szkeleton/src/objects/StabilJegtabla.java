package objects;

import indent.Indentor;

public class StabilJegtabla extends Jegtabla{
	public StabilJegtabla(Targy targy){
		super();
		this.targy=targy;
	}
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Befogad()");
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
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Hatas()");
		sz.Megszarit();
		Indentor.degLevel();
	}
	@Override
	public void setIglu()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.setIglu()");
		Iglu iglu1 = new Iglu();
		iglu=iglu1;
		Indentor.degLevel();
	}
	public void Kimenekit(Mezo cel)
	{
		//nem csinál semmit
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Kimenekit()");
		Indentor.degLevel();
	}

}
