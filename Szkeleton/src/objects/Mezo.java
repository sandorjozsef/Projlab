package objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;

import indent.Indentor;
/**
 * 	absztrakt osztály amely a játékosok lépéseinek, és egymástól való
 *	távolságuk meghatározásának az alapegysége, továbbá a játék alatt
 *	létrejövő hóviharok hatásának kifejtését segítő objektumokat 
 *	példányosítanak meg a leszármazottjai
 */
public abstract class Mezo implements Serializable{
	/**
	 * 
	 */
	private String id;
	private static final long serialVersionUID = 8199843988858681838L;
	protected Epulet iglu;
	protected ArrayList<Szereplo> szereplok;
	protected Medve medve;
	private ArrayList<Mezo> szomszedok;
	private int hoVastagsag;
	private boolean felderitett = false;
	
	/**
 	 *	Mezo konstruktor ami alapból az iglu attribútumot noglura állítja,
 	 *	hiszen alapból egyik mezőn sincs iglu. 
	 */
	public Mezo(String id){
		this.id = id;
		iglu = new Noglu();
		szereplok = new ArrayList<Szereplo>();
		szomszedok = new ArrayList<Mezo>();
	}
	public String getId() {
		return id;
	}
	public abstract boolean Befogad (Szereplo belepo, Mezo regi);
	/**
	 *	beállítja azt hogy az átadott kilepo már nem áll az adott mezon
	 */
	public void Kiad (Szereplo kilepo){
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name()+".Kiad()");
		szereplok.remove(kilepo);
		Indentor.degLevel();
		
	}
	
	public abstract Targy Atad();
	/**
	 * 	Felkínálja a játékosnak hogy válasszon egyet a szomszédos mezők közül
	 */
	public Mezo ValasztSzomszed()
	{ 
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".ValasztSzomszed()");
		System.out.print("Melyik szomszedos mezon tortenjen a cselekves? (");
		for(int i=0;i<this.szomszedok.size();i++)
			System.out.print(" "+szomszedok.get(i).getId());
		System.out.print(" ) ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String mezonev = reader.readLine();
			for(int i = 0; i<szomszedok.size(); i++) {
				if(szomszedok.get(i).getId().equals(mezonev)) {
					Indentor.degLevel();
					return szomszedok.get(i);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Indentor.degLevel();
		return null;
		

	}
	/**
	 * 	növeli a hóvastagságot az adott mezőn hóesés miatt, vagy csökkenti azt
	 * 	ha ásnak a mező. az értéke nem mehet 0 alá.
	 */
	public void HoHozzaad(int novekmeny)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".HoHozzaad()");
		this.hoVastagsag+=novekmeny;
		if(this.hoVastagsag<0)
			this.hoVastagsag=0;
		
		Indentor.degLevel();
	}
	public boolean getMedve() {
		//Indentor.incLevel();
		//System.out.println(Indentor.getIndent()+Name()+".getMedve()");
		//Indentor.degLevel();
		if(medve == null)
			return false;
		else return true;
	}
	public ArrayList<Mezo> getSzomszed() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".getSzomszed()");
		Indentor.degLevel();
		return szomszedok;
	}
	/**
	 * 	a mező felderítésekor hívják, a felderitett értéket állítja igazra
	 */
	public void Felderit()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".Felderit()");
		this.felderitett=true;
		Indentor.degLevel();
		
	}
	/**
 	 *	visszaadja, hogy az adott mezők szomszédosak-e, később a saját attribútumaiból
 	 *	fogja összehasonlítani, hogy a kapott paraméter benne van-e a saját szomszedok tömbjében
 	 */
	public boolean isSzomszed(Mezo szomszed)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".isSzomszed()");	
		Indentor.degLevel();
		return this.szomszedok.contains(szomszed);
		
	}
	/**
	 * 	visszatér az eltárolt szereplok darabszámával
	 */
	public int getSzereplokSzama()
	{
		//Indentor.incLevel();
		//System.out.println(Indentor.getIndent()+Name()+".getSzereplokSzama()");
		//Indentor.degLevel();
		return szereplok.size();
		
	}
	/**
	 *	visszatért a mezőn lévő hóvastagság értékével 
	 */
	public int gethoVastagsag()
	{
		//Indentor.incLevel();
		//System.out.println(Indentor.getIndent()+Name()+".gethoVastagsag()");
		//Indentor.degLevel();
		return this.hoVastagsag;
	}
	public void setHovastagsag(int v) {
		hoVastagsag = v;
	}
	/**
	 * minden, a mezőre beiratott szereplőt átléptet a cel mezőre
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + Name() + ".Kimenekit()");
		int szCount = szereplok.size();
		for(int i = 0; i<szCount;i++) {
			szereplok.get(0).setLepesszam(4);
			szereplok.get(0).Atlep(cel);
		}
		Indentor.degLevel();
		
	}
	/**
	 * absztrakt függvény megvalósítása a leszármazottakban
	 */
	public abstract void setEpulet(Epulet e);
	
	/**
	 * absztrakt függvény megvalósítása a leszármazottakban
	 */
	public abstract void Hatas(Szereplo sz);
	
	/**
	 *	ha egy adott mezőt hóesés sújtja akkor ez a függvény szól a saját épületének, 
	 *	hogy hajtsa végre a játékszabályok szerinti változásokat
	 */
	public void Hoeses()
	{
		Indentor.incLevel();		
		System.out.println(Indentor.getIndent() + Name() +".Hoeses()");
		iglu.Levon(szereplok);
		Indentor.degLevel();
		
	}
	/**
	 *	setter ami beállítja az adott mezőre a paraméterként kapott szereplőt,
	 *	kiiratása nincs, hiszen csak az inicializálásnál használjuk
	 */
	public void setSzereplo(Szereplo sz){
		
		szereplok.add(sz);
	}
	/**
 	 *	setter ami beállítja az adott mezőre a paraméterként kapott mezot szomszédnak,
	 *	kiiratása nincs, hiszen csak az inicializálásnál használjuk
	 */
	public void setSzomszed(Mezo mezo){
		
		szomszedok.add(mezo); 
	}
	
	/**
	 * absztrakt függvény megvalósítása a leszármazottakban, felhasználása a kiiratásnál kell
	 */
	public abstract String Name(); 
	
	public void Amortizal()
	{
		if (iglu.Amortizacio())
			setEpulet(new Noglu()); 
	}
	
	public void Tamadas()
	{
		if (szereplok.size() > 0)
			iglu.Tamadas();
	}
	
	public void setMedve(Medve medve)
	{
		this.medve = medve;
	}
	
	public void MedveKiad() 
	{
		this.medve = null;
	}
	public void setfelderitett(boolean b) {
		this.felderitett=b;
	}
	public boolean getfelderitett() {
		return this.felderitett;
	}
	
	public void MezoInfo()
	{
		/*try {
			if(!fajlnev.equals("")) {
				File f = new File(fajlnev);
				f.createNewFile();
				
					@SuppressWarnings("resource")
					FileOutputStream fout = new FileOutputStream(fajlnev);
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fout));
					writer.write(this.id+" "+(felderitett?Name():"ismertlen")+" "+this.hoVastagsag+" "+(getMedve()?"1":"0")+" ");
					for(int i = 0; i< szereplok.size();i++) {
						writer.write(szereplok.get(i).getId()+" ");
					}					
					writer.close();
					fout.close();
					
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Nev: "+ this.id);
		if(felderitett) 
			System.out.println("Tipus: "+Name());	
		else
			System.out.println("Tipus: Ismeretlen");
		System.out.println("hoVastagsag: "+ this.hoVastagsag);
		System.out.print("Szereplok: ");
		szereplok.forEach(sz->System.out.print(" |"+ sz.getId()));
		System.out.println();
		
		if(this.getMedve())
			System.out.println("Medve: van");
		else
			System.out.println("Medve: nincs");
		System.out.println("Epulet: "+iglu.Name());
	}
}
