package usecases;
/*
 * Interf�sz a use-case-eknek 
 * A run() met�dus elinditja a teszteset fut�s�t
 * A getName() pedig visszaadja a use-case-hez tartoz� leir�st a kilist�z�shoz 
 */
public interface UseCase {
	public void run();
	public String getName();
}
