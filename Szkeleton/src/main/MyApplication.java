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
	private static GrafNezet nezet = new GrafNezet();	
	static private BufferedWriter output;
	
	
	/**
	 * 
	 * Visszaadja a kimeneti fájlba író osztályt
	 *
	 */
	static public BufferedWriter getOutput() {
		return output;
	}
	/**
	 * 
	 * Visszaadja az ablakot
	 *
	 */
	public static Stage getWindow() {
		return window;
	}
	/**
	 * 
	 * elindítja az alkalmazás ablakának betöltését
	 *
	 */
	public static void main(String[] args) throws IOException{	
		launch(args);	
	}
	/**
	 * 
	 * Felépíti az alkalmazást, beállítja annak paramétereit és betölti a menüablakot, majd megjeleníti.
	 * Továbbá összerendeli az egyes nézetbeli gombokat az eseménykezelőkkel
	 *
	 */
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
	/**
	 * 
	 * Megvalósítja az ActionEvent kezelő interfész metódusát
	 * A nézet egyes gombjainak lenyomásához rendel különböző végrehajtásokat, ez a metódus vezérli a játékot
	 *
	 */
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
				
			}
			else if(event.getSource() == nezet.getStartB()) {				
				File f= new File(".\\" + (nezet.getPalyaNev().equals("")?"Gold":nezet.getPalyaNev()));
				if(f.exists()) {					
					Palya.JatekotKezd(new FileInputStream(f));						
					window.setScene(nezet.getJatekNezet());
					nezet.Mezolehelyez(Palya.getMezok());
					
				}
			}
			else if(event.getSource() == nezet.getBetoltB()) {
				File f= new File(".\\" + (nezet.getJatekNev().equals("")?"Mentes.dat":nezet.getJatekNev()));
				if(f.exists()) {						
					Palya.Load(f.getName());
					window.setScene(nezet.getJatekNezet());		
					nezet.Mezolehelyez(Palya.getMezok());
					
				}
			}
			else if(event.getSource() == nezet.getMentesB()) {									
				Palya.Save(nezet.getMentNev().equals("")?"Mentes.dat":nezet.getMentNev());		
			}
			else if(event.getSource() == nezet.getAtlepB()) {
				Palya.getAktJatekos().Atlep(nezet.getKijeloltMezo());	
			}
			else if(event.getSource() == nezet.getLepesvegeB()) {
				Palya.getAktJatekos().Vegeztem();
			}
			else if(event.getSource() == nezet.getFelveszB()) {
				Palya.getAktJatekos().Felvesz();
			}
			else if(event.getSource() == nezet.getTakaritB()) {
				Palya.getAktJatekos().Takarit();
			}
			else if(event.getSource() == nezet.getKepessegB()) {
				Palya.getAktJatekos().SpecKepesseg(nezet.getKijeloltMezo());
			}
			frissit();
			
		
		} catch(FileNotFoundException e){e.printStackTrace();}
	}
	/**
	 * 
	 * A program szabályos leállításáért felelős
	 */
	public void closeProgram() {
		window.close();
		 Platform.exit();
	     System.exit(0);
	}
	public static void frissit() {
		
		nezet.Torol();
		if (Palya.getAktJatekos() == null)
		{ // Menu megjelenitese
			nezet.torolMind();
			MyApplication.getWindow().setScene(nezet.getMenuNezet());
		}
		else
		{ // lefrissiti a palyat			
			Palya.getMezok().forEach(m -> m.FrissitNezet(nezet));
			MyApplication.getWindow().setScene(nezet.getJatekNezet());
		}
	}
	
	
}
