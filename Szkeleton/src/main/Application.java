package main;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import objects.*;

import usecases.*;
/**
 * 
 * main app
 *
 */
public class Application {
	private String history = "";
	private boolean record = false; 
	/**
	 * Létrehozunk egy listát a UseCase interfészt implementáló osztályokból, amelynek elemieihez
	 * később a listában lévő poziciójuk alapján azonositókat rendelünk
	 * 
	 * Ezen azonositókkal tudjuk majd futtatni a kivánt use-caseket, miután bekértük a felhasználótól
	 * 
	 * Ezzel a módszerrel könnyen bővithető a usecase lista
	 *
	 *
	 * Kiirjuk az egyes use-caseket és azonositójukat az osztályban tárolt nevüket felhasználva
	 *
	 *	
	 * Elkapju kaz esetleges exception-oket pl.:
	 * Ha nem egész szám jön az inputon vagy olyan szám jön, amvel túlindexelnénk a listát
	 * újra bekérjük az azonositót, ameddig végre nem hajtható az indexelés és futtatás
	 * @throws IOException 
	  */
	public static void main(String[] args){	
		
		
		boolean exit = false;
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(!exit) {
			try {
				
				String sor = reader.readLine();
				String params[] = sor.split(" ");
				if(params[0].equals("exit")) {
					exit = true;
					break;
				}
				else if(params[0].equals("test")) {
					
				}
				else if(params[0].equals("palyatepit")) {
					if(params[1].equals("konzol"))
						Palya.BuildMap(System.in);
					else {
						File f= new File(params[1]);
						if(f.exists())
							Palya.BuildMap(new FileInputStream(f));
					}				
				}
				else if(params[0].equals("startjatek")) {
					if(params[1].equals("konzol"))
						Palya.JatekotKezd(System.in);
					else if(params[1].equals("mentett")) {
						
					}
					else {
						File f= new File(params[1]);
						if(f.exists())
							Palya.JatekotKezd(new FileInputStream(f));
					}				
				}
				else if(params[0].equals("betolt")) {
					File f= new File(params[1]);
					if(f.exists())
						reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				}
				else if(params[0].equals("***")) {
					reader = new BufferedReader(new InputStreamReader(System.in));
				}
				else if(params[0].equals("jatekos")) {									
					if(params[1].equals("lep")) {										
						Palya.getAktJatekos().Atlep(Palya.getMezok().get(Integer.parseInt(params[2])));					
					}
					else if(params[1].equals("kepesseg")) {
						Palya.getAktJatekos().SpecKepesseg(Palya.getMezok().get(Integer.parseInt(params[2])));
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
			   }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
			
			
			
			
			/*
			ArrayList<UseCase> useCases = new ArrayList<UseCase>();	
			useCases.add(new EszkimoIglutEpit());
			useCases.add(new KutatoFelderit());
			useCases.add(new SzereploKoratadasStabil());
			useCases.add(new SzereploKoratadasLuk());
			useCases.add(new SzereploEszik());
			useCases.add(new SzereploBuvarruha());
			useCases.add(new SzereploAlkatresz());
			useCases.add(new SzereploTargyfelvetel());
			useCases.add(new ControlerHovihar());
			useCases.add(new SzereploLepStabil());
			useCases.add(new SzereploLepInstabil());
			useCases.add(new SzereploLepLuk());
			useCases.add(new SzereploTakarit());
			useCases.add(new SzereploLapat());
			useCases.add(new SzereploKotelLukrol());	
			useCases.add(new SzereploKotelInstabil());
			
			System.out.println("LEHETSEGES USE-CASE-ek:\n");
			System.out.println("[-1] - Kilepes a programbol");
			for(int i = 0; i< useCases.size();i++) {
				System.out.println("["+i+"] - "+useCases.get(i).getName());
			}
			boolean validID = false;
			System.out.print("\nAdd meg a tetsztelni kivant use-case azonositojat: ");
			
			while(!validID) {
				try {					
					int useCaseID = Integer.parseInt(reader.readLine());
					
					if(useCaseID == -1) {
						exit = true;
						break;
					}
					
					
					validID = true;					
					useCases.get(useCaseID).run();
				}
				catch(Exception e) {
				
					validID = false;	
					//e.printStackTrace();
					System.out.print("Nem megfelelo azonosito, probalkozz ujra!: ");
				}
			}
			System.out.print("\n---Nyomj ENTER-t---\n");			
			try {
				reader.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
		
		
		
	}
	
	
}
