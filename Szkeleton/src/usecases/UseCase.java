package usecases;
/**
 * Interf�sz a use-case-eknek 
 *  
 */
public interface UseCase {
	/**
	 * A run() met�dus elinditja a teszteset fut�s�t
	 */
	public void run();
	/**
	 * A getName() pedig visszaadja a use-case-hez tartoz� leir�st a kilist�z�shoz 
	 */
	public String getName();
}
