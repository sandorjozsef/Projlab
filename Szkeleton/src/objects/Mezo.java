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

import view.*;
import main.MyApplication;
import view.Nezheto;
/**
 * 	absztrakt osztály amely a játékosok lépéseinek, és egymástól való
 *	távolságuk meghatározásának az alapegysége, továbbá a játék alatt
 *	létrejövő hóviharok hatásának kifejtését segítő objektumokat 
 *	példányosítanak meg a leszármazottjai
 */
public abstract class Mezo implements Serializable, Nezheto{
	
	private String id;
	private static final long serialVersionUID = 8199843988858681838L;
	protected Epulet iglu;
	protected ArrayList<Szereplo> szereplok;
	private ArrayList<Mezo> szomszedok;
	protected int hoVastagsag;
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
		
		szereplok.remove(kilepo);
		
	}
	
	public abstract Targy Atad();
	/**
	 * 	Felkínálja a játékosnak hogy válasszon egyet a szomszédos mezők közül, melynek menete a következő:
	 * 	kilistázza a a szomszéd mezők azonosítóit, majd megnézi hogy a saját mezői közül melyikével egyezik
	 * 	a kapott String id, és visszatér ezzel a mezővel
	 */
	public Mezo ValasztSzomszed()
	{ 
		
		System.out.print("Melyik szomszedos mezon tortenjen a cselekves? (");
		for(int i=0;i<this.szomszedok.size();i++)
			System.out.print(" "+szomszedok.get(i).getId());
		System.out.print(" ) ");
		BufferedReader reader = MyApplication.getInput();
		
		try {
			String mezonev = reader.readLine();
			for(int i = 0; i<szomszedok.size(); i++) {
				if(szomszedok.get(i).getId().equals(mezonev)) {
					
					return szomszedok.get(i);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
		

	}
	/**
	 * 	növeli a hóvastagságot az adott mezőn hóesés miatt, vagy csökkenti azt
	 * 	ha ásnak a mező. az értéke nem mehet 0 alá.
	 */
	public void HoHozzaad(int novekmeny)
	{
	
		this.hoVastagsag+=novekmeny;
		if(this.hoVastagsag<0)
			this.hoVastagsag=0; 
		
	}
	
	public ArrayList<Szereplo> getSzereplok() {
		return szereplok;
	}
	
	public ArrayList<Mezo> getSzomszed() {
		return szomszedok;
	}
	/**
	 * 	a mező felderítésekor hívják, a felderitett értéket állítja igazra
	 */
	public void Felderit()
	{
	
		this.felderitett=true;
		
	}
	/**
 	 *	visszaadja, hogy az adott mezők szomszédosak-e, összehasonlítja hogy a kapott paraméter 
 	 *	benne van-e a saját szomszedok tömbjében
 	 */
	public boolean isSzomszed(Mezo szomszed)
	{
	
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
		int szCount = szereplok.size();
		for(int i = 0; i<szCount;i++) {
			szereplok.get(0).setLepesszam(4);
			szereplok.get(0).Atlep(cel);
		}
		
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
	 *	hogy hajtsa végre a játékszabályok szerinti változásokat (Levon függvénnyel)
	 */
	public void Hoeses()
	{
		
		iglu.Levon(szereplok);
		this.hoVastagsag++;
		
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
	
	/**
	 * meghívja az épülete amortizal függvényét, és ha az true-val tér vissza akkor Noglut állít be helyette
	 */
	public void Amortizal()
	{
		if (iglu.Amortizacio())
			setEpulet(new Noglu()); 
	}
	/**
	 * Ha a medvén kívül van szereplő  a mezőn akkor jelzi az épületének hogy támadás történt a mezőn
	 */
	public void Tamadas()
	{
		if (szereplok.size() > 1)
			iglu.Tamadas();
	}
	public void setfelderitett(boolean b) {
		this.felderitett=b;
	}
	public boolean getfelderitett() {
		return this.felderitett;
	}
	/**
	 * Kiírja a legfontosabb információkat a mezőről, amíg nincs grafikus felület hogy ezeket látni lehessen.
	 * A formátuma a következő soronként lebontva: id, típus , hóvastagság, szereplők, épület
	 * ha a mező nincs felderítve, akkor a típus ismeretlen, az épület értéke pedig nem látszik
	 */
	public void MezoInfo(BufferedWriter bw)
	{
		try {
			System.out.println("Nev: "+ this.id);
			bw.write(id);
			if(felderitett) {
				System.out.println("Tipus: "+Name());	
				bw.write(" "+Name());
				
			}
			else {
				System.out.println("Tipus: Ismeretlen");
				bw.write(" ismeretlen");
			}
			System.out.println("hoVastagsag: "+ this.hoVastagsag);
			bw.write(" "+hoVastagsag);
			System.out.println("Epulet: "+iglu.Name());
			bw.write(" "+iglu.Name());
			System.out.print("Szereplok: ");
			szereplok.forEach(sz->System.out.print(" |"+ sz.getId()));
			for(int i = 0; i<szereplok.size(); i++)  {	        	
	       		bw.write(" "+szereplok.get(i).getId());
	        }
			System.out.println();			
			bw.newLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public abstract void FrissitNezet(GrafNezet n);
	
	public Epulet getEpulet(){
		return iglu;
	}
}
