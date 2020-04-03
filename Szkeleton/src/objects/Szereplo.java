package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import indent.Indentor;

/**
 * A Szereplo egy absztrakt osztály. Egy szereplő vagy kutató vagy eszkimó. A
 * szereplő tud lépni, eszközöket használni, van testhője. Egy szereplő egy
 * körben maximum négyet léphet.
 * 
 * @author Sándor József
 *
 */
public abstract class Szereplo extends Lepheto{

	protected Ruha ruha;
	protected ArrayList<Targy> targyak;
	protected int testho;
	protected int lepesszam;

	public Szereplo() {
		targyak = new ArrayList<Targy>();
		ruha = new AlapRuha();
	}

	/**
	 * Ezzel a metódussal tudja kezdeményezni a játékos egy másik mezőre való
	 * átjutását.
	 * 
	 * @param cel A célmező
	 */
	@Override
	public void Atlep(Mezo cel) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Atlep()");

		boolean siker = cel.Befogad(this, aktmezo);
		if (siker) {
			aktmezo.Kiad(this);
		}
		Indentor.degLevel();
	}

	/**
	 * Ez a metódus a jégtáblát fedő hóréteg(ek) eltávolítására szolgál, amely 1
	 * egységgel csökkenti a mennyiségét.
	 */
	public void Takarit() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Takarit()");
		aktmezo.HoHozzaad(-1);
		Indentor.degLevel();
	}

	/**
	 * Növeli vagy csökkenti a szereplő testhőjét az átadott paraméterrel.
	 * Megkérdezi a felhasználótól, hogy nulla lett-e a testhője és ennek
	 * függvényében megy tovább.
	 * 
	 * @param novekmeny
	 */
	public void TesthoHozzaad(int novekmeny) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".TesthoHozzaad()");
		String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.print(Indentor.getIndent() + " - 0 lett a testho? (Y/N) ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer1 = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		if (answer1.equals("Y")) {
			this.Meghaltam();
		}
		Indentor.degLevel();
	}

	/**
	 * Ezzel lehet arról a hómentes jégtábláról kivenni a tárgyat, amelyen a
	 * szereplő tartózkodik, valamint a tárgy referenciáját eltárolja.
	 */
	public void Felvesz() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Felvesz()");
		// TODO : null-t addol?
		Targy t = aktmezo.Atad();
		if (t != null)
			targyak.add(t);
		Indentor.degLevel();
	}
	/**
	 * Visszaadja a szereplő egy tárgyát az adott indexen
	 * @param i
	 * @return
	 */
	public Targy getTargy(int i) {
		return targyak.get(i);
	}
	/**
	 * A paraméterként kapott Targy Kepesseg() függvényét hívja meg, aminek a
	 * paramétereként saját magát adja át.
	 * 
	 * @param targy
	 */
	public void Hasznal(Targy targy) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Hasznal()");
		targy.Kepesseg(this);
		Indentor.degLevel();
	}

	/**
	 * Eldobja a paraméterként megadott tárgyat a zsebéből, amennyiben nála van. Ez
	 * egyelőre még a Skeleton fázisban nincs megvalósítva.
	 * 
	 * @param targy
	 */
	public void Eldob(Targy targy) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Eldob()");
		Indentor.degLevel();
	}

	/**
	 * Absztrakt metódus, melyet a leszármazottaknak kötelező módon meg kell
	 * valósítaniuk (különböző módon )
	 * 
	 * @param cel
	 */
	public abstract void SpecKepesseg(Mezo cel);

	/**
	 * Beállítja a lépésszámot a-val megegyező értékűre. Ez egyelőre még a Skeleton
	 * fázisban nincs megvalósítva.
	 * 
	 * @param a
	 */
	public void setLepesszam(int a) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".setLepesszam()");
		Indentor.degLevel();
	}

	/**
	 * Jelzi a pályának, hogy nem lép többet, és ekkor a pálya átadja a kört a
	 * következő játékosnak.
	 */
	public void Vegeztem() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Vegeztem()");
		Palya.Leptet();
		Indentor.degLevel();
	}

	/**
	 * Beállítja a szereplő ruha attribútumának a paraméterként kapott ruhát.
	 * 
	 * @param ruha
	 */
	public void setRuha(Ruha ruha) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".setRuha()");
		this.ruha = ruha;
		Indentor.degLevel();
	}

	/**
	 * Meghívja a ruhája Elazik() függvényét, aminek a paraméterében saját magát
	 * adja át.
	 */
	public void Elazik() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Elazik()");
		ruha.Elazik(this);
		Indentor.degLevel();
	}

	/**
	 * Meghívja a ruhája Megszarit() függvényét.
	 */
	public void Megszarit() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Megszarit()");
		ruha.Megszarit();
		Indentor.degLevel();
	}

	/**
	 * Meghívja a Palya JatekVege(false) függvényét.
	 */
	public void Meghaltam() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Meghaltam()");
		Palya.JatekVege(false);
		Indentor.degLevel();
	}

	public abstract String Name();

}
