package main;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import objects.*;
import view.GrafNezet;

/**
 * 
 * main app
 *
 */
public class MyApplication extends Application implements EventHandler<ActionEvent>{	
	private static Stage window;
	private GrafNezet nezet = new GrafNezet();
	
	
	static private BufferedReader input;
	static private BufferedWriter output;
	static public BufferedReader getInput() {
		return input;
	}
	static public BufferedWriter getOutput() {
		return output;
	}
	public static Stage getWindow() {
		return window;
	}
	/**
	 * beolvassuk a konzolrol vagy a megadott input fájlból a parancsokat és végrehajtásra kerülnek
	 * Ez vezérli a pályát és biztosít kommunikációs felületet a felhasználónak
	 * 
	 * Parancsok:
	 * exit
	 *	Leírás: Kilép a programból
	 *	Opciók: -
	 *
	 *startjatek
	 *	Leírás: Hasonló, mint a palyatepit parancs, felépíti a pályát fájlból vagy a konzolon megadott modell alapján, de itt ténylegesen elkezdjük a játékot és akár egy teljes, korábban elmentett játékállást is betölthetünk. Kötelező opciót megadni
	 *	Opciók: 
	 *		“konzol”: A pályát a konzolról akarjuk beolvasni
	 *		<fájlnév>: Megadhatunk egy fájl útvonalat, ahonnan be akarjuk olvasni a pályát leíró fájlt
	 *		“jatekallas” <fájlnév>:  Megadhatunk egy fájl útvonalat, ahonnan be akarjuk olvasni a teljes játékállást, majd onnan folytathatjuk a játékunk
	 *
	 *betolt
	 *	Leírás: Egy fájlból töltünk be parancs sorozatot, amik egymás után végrehajtódnak, így pl. előre megírt futásokat tudunk betölteni. Kötelező opciót megadni.
	 *	Opciók:
	 * 		<fájlnév>: Megadhatunk egy fájl útvonalat, ahonnan be akarjuk olvasni a pályát 
 	 *
	 * "***"
	 *	Leírás: A “betolt” paranccsal hívott fájlok lezáró parancsa, tulajdonképpen visszaadja a vezérlést a konzolnak, kötelező minden ilyen fájl végén vagy legalább egyszeri előfordulás a fájlban kivéve, ha meghívja az “exit” parancsot.
	 *	Opciók: -
 	 *
	 *jatekos
	 *	Leírás: Az éppen soron lévő szereplőt lehet vele vezérelni, különböző opciók segítségével. Kötelező opciót megadni
	 *	Opciók: 
	 *		“lep” <mező_neve>: A megadott id alapján választ egy mezőt a pályáról, amire megpróbál rálépni a játékos
	 **		“kepesseg” <mező_neve>: A megadott id alapján választ egy mezőt a pályáról, amin használja a szereplő képességét
	 *		“takarit”: A szereplő havat takarít el a mezőről, amire lépett
	 *		“lepesvege”: A játékos átadja a körét a következő játékosnak
	 **		“hasznal” <szám>: A megadott szám alapján választ egy tárgyat a gyűjteményéből , amit használni fog 
	 *		“felvesz”: megpróbál felvenni egy tárgyat a pályáról
	 *
	 *elment
	 *	Leírás: Elmentjük a teljes játékállást egy általunk megadott fájlba. Játékon kívülről is menthetünk,  akkor a még inicializálatlan objektumok mentődnek. Kötelező opciót megadni.
	 *	Opciók: 
	 * 		<fájlnév>: Megadhatunk egy fájl útvonalat, ahonnan be akarjuk olvasni a pályát 
	 *
	 *kimenet
	 *	Leírás: Beállítja, hogy melyik fájlba történjen a kimeneti állapotok lementése megtekintéskor. Kötelező opciót megadni.
	 *	Opciók: 
	 * 		<fájlnév>: Megadhatunk egy fájl útvonalat, ahova ki akarjuk írni a jelenlegi állapotokat
	 *
	 *
	 *megtekint
	 *	Leírás: A pálya és szereplők állapotát jeleníti meg, hogy a felhasználó láthassa. Kötelező opciót megadni.
	 *	Opciók:
	 *		“palya”: Megjelenik az összes mező tulajdonsága, ami a felhasználó számára megtekinthető játékszinten
	 *		“allapot”: Megjelennek a szereplő fontosabb tulajdonságai 
	 *		“inventory”: Megjelennek a szereplő tárgyai, a hívásukhoz szükséges azonosítóikkal együtt
	 *		“mezo” <mező_neve>: Megjelennek a kiválasztott mező tulajdonságai
	 *
	 *
	 * 
	 * @throws IOException 
	  */
	public static void main(String[] args) throws IOException{	
		launch(args);
		
		/*boolean exit = false;		
		
		InputStream is = null;
		FileOutputStream fout = null;
		
		
		if(args.length==0) {			
			is = System.in;
		}
		else {			
			is = new FileInputStream(args[0]);			
		}
		
		System.out.println("jatek");
		input = new BufferedReader(new InputStreamReader(is));		
		File outputFile = new File("jatek_kimenet\\jatek_kimenet.dat");
		if(!outputFile.exists())				
			outputFile.createNewFile();
		fout = new FileOutputStream(outputFile);	
		output = new BufferedWriter(new OutputStreamWriter(fout));
		
		
		while(!exit) {
			try {
				
				String sor = input.readLine();
				String params[] = sor.split(" ");		
			
					
				
				if(params[0].equals("exit")) {
					exit = true;
					break;
				}							
				else if(params[0].equals("startjatek")) {
					if(params[1].equals("konzol"))
						Palya.JatekotKezd(System.in);
					else if(params[1].equals("jatekallas")) {
						Palya.Load(params[2]);
					}
					else {
						File f= new File(".\\" + params[1]);
						if(f.exists())
							Palya.JatekotKezd(new FileInputStream(f));
					}				
				}
				else if(params[0].equals("betolt")) {
					File f= new File(params[1]);
					if(f.exists())
						input = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				}
				else if(params[0].equals("elment")) {
					Palya.Save(params[1]);
				}
				else if(params[0].equals("***")) {
					input = new BufferedReader(new InputStreamReader(is));
				}
				else if(params[0].equals("jatekos")) {									
					if(params[1].equals("lep")) {										
						Palya.getAktJatekos().Atlep(Palya.getMezo(params[2]));					
					}
					else if(params[1].equals("kepesseg")) {
						Palya.getAktJatekos().SpecKepesseg(Palya.getMezo(params[2]));
					}
					else if(params[1].equals("takarit")) {
						Palya.getAktJatekos().Takarit();
					}
					else if(params[1].equals("lepesvege")) {
						Palya.getAktJatekos().Vegeztem();
					}
					else if(params[1].equals("hasznal")) {
						int t = Integer.parseInt(params[2]);
						Palya.getAktJatekos().Hasznal(Palya.getAktJatekos().getTargy(t));
					}
					else if(params[1].equals("felvesz")) {						
						Palya.getAktJatekos().Felvesz();
					}
					else {
						System.out.println("Hibas parameter!");
					}
			   }
				else if(params[0].equals("megtekint")) {
					if(params[1].equals("palya")) {							
						Palya.Megtekintes(0,"");				
					}
					else if(params[1].equals("allapot")) {
						Palya.Megtekintes(1,"");	
					}
					else if(params[1].equals("inventory")) {
						Palya.Megtekintes(2, "");	
					}
					else if(params[1].equals("mezo")) {
						Palya.Megtekintes(3, params[2]);	
					}
					else {
						System.out.println("Hibas parameter!");
					}
					
				}
				else {
					System.out.println("Hibas parancs!");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}			
	
		}		
		
		output.close();
		input.close();
		is.close();
		fout.close();*/
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		FileOutputStream fout = null;		
		File outputFile = new File("jatek_kimenet\\jatek_kimenet.dat");
		if(!outputFile.exists())				
			outputFile.createNewFile();
		fout = new FileOutputStream(outputFile);	
		output = new BufferedWriter(new OutputStreamWriter(fout));
		
		
		
		window = primaryStage;
		window.setTitle("Jegmezok");			
		window.setResizable(true);		
		window.setScene(nezet.getMenuNezet());
		
		window.setX(50);
		window.setY(100);
		window.show();		
		window.setOnCloseRequest(e ->{			
			e.consume(); 
			closeProgram();			
		});
		
		
		
		
		nezet.getMenuKilepB().setOnAction(this);
		nezet.getStartB().setOnAction(this);
		nezet.getBetoltB().setOnAction(this);
		nezet.getJatekKilepB().setOnAction(this);
		nezet.getMentesB().setOnAction(this);
		
		nezet.getFelveszB().setOnAction(this);
		nezet.getTakaritB().setOnAction(this);
		nezet.getKepessegB().setOnAction(this);
		nezet.getAtlepB().setOnAction(this);
		nezet.getLepesvegeB().setOnAction(this);
		
		
	}
	@Override
	public void handle(ActionEvent event) {
		try {
			if(event.getSource() == nezet.getMenuKilepB()) {
				event.consume();
				closeProgram();		
			}
			else if(event.getSource() == nezet.getJatekKilepB()) {				
				Palya.Save("Mentes.dat");
				Palya.JatekVege(false);
				window.setScene(nezet.getMenuNezet());	
				Palya.frissit(nezet);
			}
			else if(event.getSource() == nezet.getStartB()) {				
				File f= new File(".\\" + (nezet.getPalyaNev().equals("")?"Gold":nezet.getPalyaNev()));
				if(f.exists()) {					
					Palya.JatekotKezd(new FileInputStream(f));						
					window.setScene(nezet.getJatekNezet());
					nezet.Mezolehelyez(Palya.getMezok());
					Palya.frissit(nezet);
				}
			}
			else if(event.getSource() == nezet.getBetoltB()) {
				File f= new File(".\\" + (nezet.getJatekNev().equals("")?"Mentes.dat":nezet.getJatekNev()));
				if(f.exists()) {						
					Palya.Load(f.getName());
					window.setScene(nezet.getJatekNezet());			
				}
			}
			else if(event.getSource() == nezet.getMentesB()) {									
				Palya.Save(nezet.getMentNev().equals("")?"Mentes.dat":nezet.getMentNev());		
			}
		
		} catch(FileNotFoundException e){e.printStackTrace();}
	}
	public void closeProgram() {
		window.close();
		 Platform.exit();
	     System.exit(0);
	}
	
}
