
public class StabilJegtabla extends Jegtabla{
	public StabilJegtabla(Targy targy)
	{this.targy=targy;}
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		if(isSzomszed(regi)) {
			Hatas(belepo);
			return true;
		}else {
			return false;
		}
		
	}
	public void Hatas(Szereplo sz)
	{
		sz.Megszarit();
	}
	public void setIglu()
	{
		Iglu iglu1 = new Iglu();
		iglu=iglu1;
	}
	public void Kimenekit(Mezo cel)
	{
		//nem csinál semmit
	}
}
