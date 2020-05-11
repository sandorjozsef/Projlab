package objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

import view.GrafNezet;


/**
 * Targy interfészt megvalósító osztály, aminek 3 példányával történő felvevés
 * és Kepesseg használatot követően meg lehet nyerni a játékot.
 * @author Aviato
 */
public class Alkatresz implements Targy ,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7878735886482320510L;
	
	/**
	 * Azt jelzi, hogy a Palya tud-e erről az Alkatresz-ről
	 * (true: még nem tud, be lehet neki jelenteni; false: tud már róla, nem lehet többet bejelenteni).
	 */
	private boolean bejelentheto = true;
	
	/**
     * A paraméterként kapott Szereplo hívta meg a függvényt, amely megpróbálja bejelenteni az alkatrészét a Palya számára.
     * Ezt úgy teszi, hogy ezt a változót továbbítja a Palya számára az AlkatresztKezel függvényen keresztül
     * (meghívja a Palya AlkatresztKezel függvényét bejelentheto attribútumával).
     * @param felhasznalo Jelen esetben lényegtelen, de általában az a Szereplo, aki tárolja az adott Alkatresz-t
     */
	@Override
	public void Kepesseg(Szereplo felhasznalo)
	{
		Palya.AlkatresztKezel(bejelentheto);
	}
	
	/**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Alkatresz Stringgel fog visszatérni
     */
	@Override
	public String Name() {
		return "Alkatresz";
	}

	@Override
	public void FrissitNezet(GrafNezet n) 
	{
		n.FrissitAlkatresz(this);
	}
}
