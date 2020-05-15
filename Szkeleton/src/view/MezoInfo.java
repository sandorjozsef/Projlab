package view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import objects.*;

/**
 * 
 * Mezők használatához és megjelenítéséhez szükséges gombok osztálya
 */
public class MezoInfo extends Button  {
	private Mezo mezo;
	/**
	 * 
	 * konstruktor, beállítja a gomb által tárolt mezőt, valamint méretét pozícióját és kinézetét
	 */
	public MezoInfo(Mezo m, double x, double y, double w, double h) {
		mezo = m;			
		this.getStyleClass().add("mezoButton");
		
		
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		this.setPrefWidth(w);
		this.setPrefHeight(h);
		
	}
	/**
	 * 
	 * Visszaadja a gomb által tárolt mezőt
	 */
	public Mezo getMezo() {
		return mezo;
	}
	/**
	 * 
	 * Visszaadja a gomb középpontjának x koordinátáját
	 */	
	public double getCenterX() {
		return getTranslateX()+getPrefWidth()/2;
	}
	/**
	 * 
	 * Visszaadja a gomb középpontjának y koordinátáját
	 */	
	public double getCenterY() {
		return getTranslateY()+getPrefHeight()/2;
	}	

}
