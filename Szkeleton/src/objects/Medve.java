package objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import indent.Indentor;

/**
 * A Medve egy olyan osztály, ami tud Mezo-t váltani, tehát a Lepheto-ből származik.
 * @author Aviato
 */
public class Medve extends Szereplo {
	private boolean autoLepes;
	public Medve(boolean b,String id) {
		super(id);
		testho = 1;
		autoLepes=b;
		this.ruha=new Buvarruha();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -8455595600003604288L;
 

    /**
     * Automatikus léptetés a következő Mezo-re.
     * @param cel Az új Mezo, ami biztos, hogy szomszédos az előzővel, mert a kontroller fogja kiválasztani
     */
    @Override
    public void Atlep(Mezo cel) 
    {
    	Indentor.incLevel();
        System.out.println(Indentor.getIndent() + Name() + ".Atlep()");
 
        boolean siker = cel!=null && cel.Befogad(this, aktmezo);
        if (siker) {
            aktmezo.Kiad(this);
            aktmezo = cel;
        }
    }

 

    /**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Medve Stringgel tér vissza
     */
    @Override
    public String Name() 
    {
        return "Medve";
    }

	@Override
	public void SpecKepesseg(Mezo cel) {
	}
	@Override 
	public void TesthoHozzaad(int novekmeny) {testho = 1; }


	@Override
	public void Autolepes() {
		
		if(autoLepes)
		{
			ArrayList<Mezo> seged =new ArrayList<Mezo>();
			seged = aktmezo.getSzomszed();
			Random rand=new Random();
			int s=rand.nextInt(seged.size());
			Atlep(seged.get(s));
		}
		else
		{
			Mezo seged=aktmezo.ValasztSzomszed();
			Atlep(seged);
		}
		this.Vegeztem();
	}



	@Override
	public void Erintkezik() {
		aktmezo.Tamadas();
		
	}
}