package objects;



/**
 *    olyan absztrakt osztály amely minden olyan mező őse ami nem luk,
 *     így a legfőbb különbsége, hogy van lehetőség tárgyat tárolni rajta,
 *    amit a szereplők felvehetnek róla, ha nincs rajta hó
 */
public abstract class Jegtabla extends Mezo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7327036173303629364L;
	protected Targy targy;
	
	/**
	 * konstruktor a Jegtablakhoz
	 */
	
	public Jegtabla(String id, Targy t) {
		super(id);
		targy = t;
	}
	
	/**
     *    átadja a jegtablarol a tárgyat, ha nincs rajta már hó,
     *    majd kitörli a saját attribútumai közül. Ha van rajta hó akkor null-al tér vissza
     */
	public Targy Atad()
	{
		
		if (this.gethoVastagsag()!=0) 
		{
			
			return null;
		}
		else
		{
			Targy t = targy;
			targy = null;
			
			return t;
		}
		
	}
	
	public Targy getTargy()
	{
		return targy;
	}
}
