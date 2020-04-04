package objects;

import java.io.Serializable;

/**
 * Absztrakt osztály egy embert tárol aki viseli, ennek az osztálynak a leszármaottai döntik el,
 * hogy a vízbe esett embereket milyen hatások érik, mennyi testhőt kell levonni
 */
public abstract class Ruha implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3597392294261297182L;
	public abstract void Elazik(Szereplo szereplo);
	public abstract void Megszarit();
	public abstract String Name();
}
