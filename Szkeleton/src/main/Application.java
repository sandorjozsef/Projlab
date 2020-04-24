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

import objects.*;

/**
 * 
 * main app
 *
 */
public class Application {	 
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
	public static void main(String[] args) throws IOException{	
		
		
		boolean exit = false;
		
		BufferedReader input;
		BufferedWriter output;
		InputStream is = null;
		FileOutputStream fout = null;
		
		
		if(args.length==0) {			
			is = System.in;
		}
		else {			
			is = new FileInputStream(args[0]);			
		}
		
		
		input = new BufferedReader(new InputStreamReader(is));		
		File outputFile = new File("kimenet.dat");
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
						File f= new File(params[1]);
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
					input = new BufferedReader(new InputStreamReader(System.in));
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
						Palya.Megtekintes(0,"", output);				
					}
					else if(params[1].equals("allapot")) {
						Palya.Megtekintes(1,"", output);	
					}
					else if(params[1].equals("inventory")) {
						Palya.Megtekintes(2,"", output);	
					}
					else if(params[1].equals("mezo")) {
						Palya.Megtekintes(3, params[2], output);	
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
		fout.close();
		
	}
	
	
}
