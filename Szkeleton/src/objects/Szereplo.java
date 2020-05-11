package objects;
 
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
 import view.*;
 
/**
 * A Szereplo egy absztrakt osztály. Egy szereplő vagy kutató vagy eszkimó vagy medve. A
 * szereplő tud lépni, eszközöket használni, van testhője. Egy szereplő egy
 * körben maximum négyet léphet.
 * 
 * @author Aviato
 *
 */
public abstract class Szereplo implements Serializable, Nezheto{
 
	 /**referencia az aktuális mezőre*/
    protected Mezo aktmezo; 
   
    /**a szereplő azonosítására szolgáló string azonosító*/
    private String id; 
    
    private static final long serialVersionUID = 4670530703450888105L;
    
    /**referencia a szereplő ruhájára*/
    protected Ruha ruha; 
    
    /**a szereplő megszerzett tárgyait nyílvántartó tömb*/
    protected ArrayList<Targy> targyak; 
    
    /**a szereplő aktuális testhője*/
    protected int testho;
    
    /**a szereplő aktuális maradék lépéseinek száma*/
    protected int lepesszam; 
    
    /**
     * megnézi, hogy van-e még lépése
     * a lépésszáma nem-e nulla
     * ha nincs visszatérési érték hamis, különben igaz
     * @return
     */
    protected boolean Lephet()
    {
        boolean seged = (lepesszam <= 0);
        if (seged)
            lepesszam = 0;
        else
            lepesszam--;
        System.out.print(seged ? "Nincs tobb lepesed!\n" : "");
        return !seged;
    }
    
    /**
     * Szereplő konstruktora
     * beállítja az azonosítóját a kapott paraméterrel
     * létrehozza a tömböt a tárgyainak
     * a ruhájának beálít egy frissen létrehozott alapruha objektumot
     * a lépésszámát 4-re inicializálja
     * @param id
     */
    public Szereplo(String id) {
        this.id=id;
        targyak = new ArrayList<Targy>();
        ruha = new AlapRuha();
        lepesszam = 4;
    }
    /**
     * visszatér a szereplő azonosítójával
     * @return id
     */
    public String getId() {
        return id;
    }  
    /**
     * Visszaadja az aktuális mezőt (aktmezo).
     * 
     * @return Az aktuális mező
     */
    public Mezo getMezo() {
      
        return aktmezo;
    }

    /**
     * Beállitja az aktuális tartózkodási mezőt. Inicializáló függvény nem jelezzük a
     * konzolon, hogy lefutott.
     * @param mezo Az új Mezo, amin tartózkodik.
     */
    public void setMezo(Mezo mezo) {
        aktmezo = mezo;
    }
 
    /**
     * Ezzel a metódussal tudja kezdeményezni a játékos egy másik mezőre való
     * átjutását.
     * 
     * @param cel A célmező
     */
    public void Atlep(Mezo cel) {
        if (!Lephet())
            return;
        
    
 
        boolean siker = cel!=null && cel.Befogad(this, aktmezo);
        if (siker) {
            aktmezo.Kiad(this);
            aktmezo = cel;
        }
      
    }
 
    /**
     * Ez a metódus a jégtáblát fedő hóréteg(ek) eltávolítására szolgál, amely 1
     * egységgel csökkenti a mennyiségét.
     * meghívja az aktuális mező HoHozzaad() függvényét -1 paraméterezéssel
     */
    public void Takarit() {
        if (!Lephet())
            return;
       
        aktmezo.HoHozzaad(-1);
     
    }
 
    /**
     * Növeli vagy csökkenti a szereplő testhőjét az átadott paraméterrel.
     * Ha nullára csökkent a testhő akkor meghívja a Meghaltam() metódust
     * @param novekmeny
     */
    public void TesthoHozzaad(int novekmeny) {
    
        testho += novekmeny;
        if (testho <= 0) {
            this.Meghaltam();
        }
       
    }
 
    /**
     * Ezzel lehet arról a hómentes jégtábláról kivenni a tárgyat, amelyen a
     * szereplő tartózkodik, valamint a tárgy referenciáját eltárolja.
     */
    public void Felvesz() {
        if (!Lephet())
            return;
      
        Targy t = aktmezo.Atad();
        if (t != null)
            targyak.add(t);
       
    }
 
    /**
     * Visszaadja a szereplő egy tárgyát az adott indexen a tárgyak tömbből
     * 
     * @param i
     * @return
     */
    public Targy getTargy(int i) {
    	
        return (targyak.size() <= i ? null : targyak.get(i));
    }
 
    /**
     * A paraméterként kapott Targy Kepesseg() függvényét hívja meg, aminek a
     * paramétereként saját magát adja át.
     * 
     * @param targy
     */
    public void Hasznal(Targy targy) {
        if (!Lephet())
            return;
       
        if (targyak.contains(targy))
            targy.Kepesseg(this);
       
    }
 
    /**
     * Eldobja a paraméterként megadott tárgyat a zsebéből, amennyiben nála van.
     * 
     * @param targy
     */
    public void Eldob(Targy targy) {
       
        if (targyak.contains(targy))
            targyak.remove(targy);
       
    }
 
    /**
     * Absztrakt metódus, melyet a leszármazottaknak kötelező módon meg kell
     * valósítaniuk (különböző módon )
     * 
     * @param cel
     */
    public abstract void SpecKepesseg(Mezo cel);
 
    /**
     * Beállítja a lépésszámot a-val megegyező értékűre.
     * 
     * @param a
     */
    public void setLepesszam(int a) {
      
        lepesszam = a;
      
    }
    
    /**
     * A lepesszamat adja vissza
     * @return lepesszam
     */
    public int getLepesszam() 
    {
        return lepesszam;
    }
 
    /**
     * Jelzi a pályának, hogy nem lép többet, és ekkor a pálya átadja a kört a
     * következő játékosnak.
     */
    public void Vegeztem() {
      
        Palya.Leptet();
        
    }
 
    /**
     * Beállítja a szereplő ruha attribútumának a paraméterként kapott ruhát.
     * 
     * @param ruha
     */
    public void setRuha(Ruha ruha) {
      
        this.ruha = ruha;
       
    }
 
    /**
     * Meghívja a ruhája Elazik() függvényét, aminek a paraméterében saját magát
     * adja át.
     */
    public void Elazik() {
       
        ruha.Elazik(this);
       
    }
 
    /**
     * Meghívja a ruhája Megszarit() függvényét.
     */
    public void Megszarit() {
       
        ruha.Megszarit();
       
    }
 
    /**
     * Meghívja a Palya JatekVege(false) függvényét.
     */
    public void Meghaltam() {
     
        Palya.JatekVege(false);
       
    }
    
    /**
     * kilistázza a szereplőnk adatait
     * @param bw
     */
    public void szereploInfo(BufferedWriter bw) {
        System.out.println("Nev: "+getId());
        System.out.println("Testho: "+testho);
        System.out.println("Lepesszam: "+lepesszam);
        System.out.println("Viselt ruha: "+ruha.Name());
        System.out.println();
        
        
        try {
			bw.write(getId() + " "+testho+" "+lepesszam+" "+ruha.Name());
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
    
    /**
     * kilistázza a targyaink neveit
     * @param bw
     */
    public void targyInfo(BufferedWriter bw) {
        System.out.println("Inventory:");
        try {
	        for(int i = 0; i<targyak.size(); i++)      {
	        	System.out.println("["+i+"] "+targyak.get(i).Name());	       			
	       		bw.write(targyak.get(i).Name()+" ");
	        }
	        bw.newLine();
        } catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        
    }
    public abstract void Autolepes();
    public abstract void Erintkezik();
    public abstract String Name();
    
    @Override
    public abstract void FrissitNezet(GrafNezet n);
    
    public Ruha getRuha()
    {
    	return ruha;
    }
}
 

