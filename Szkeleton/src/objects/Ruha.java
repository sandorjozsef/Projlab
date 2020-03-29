package objects;


/**
 * Absztrakt osztály egy embert tárol aki viseli, ennek az osztálynak a leszármaottai döntik el,
 * hogy a vízbe esett embereket milyen hatások érik, mennyi testhőt kell levonni
 */
public abstract class Ruha {
	public abstract void Elazik(Szereplo szereplo);
	public abstract void Megszarit();
	public abstract String Name();
}
