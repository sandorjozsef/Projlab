package usecases;
/**
 * Interfész a use-case-eknek 
 *  
 */
public interface UseCase {
	/**
	 * A run() metódus elinditja a teszteset futását
	 */
	public void run();
	/**
	 * A getName() pedig visszaadja a use-case-hez tartozó leirást a kilistázáshoz 
	 */
	public String getName();
}
