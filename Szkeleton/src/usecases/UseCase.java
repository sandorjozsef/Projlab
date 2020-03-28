package usecases;
/*
 * Interfész a use-case-eknek 
 * A run() metódus elinditja a teszteset futását
 * A getName() pedig visszaadja a use-case-hez tartozó leirást a kilistázáshoz 
 */
public interface UseCase {
	public void run();
	public String getName();
}
