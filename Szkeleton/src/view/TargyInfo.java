package view;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import objects.Targy;
/**
 * 
 * Tárgyak használatához szükséges gombok osztálya
 */
public class TargyInfo  extends Button  {
	private Targy targy;
	private ImageView texture;
	private double X,Y;
	/**
	 * 
	 * konstruktor, beállítja a tárolt tárgyat, annak textúráját és a gomb kinézetét és méretét
	 */
	public TargyInfo(Targy t, String image, double x, double y, double w, double h) {
		targy = t;	
		texture = new ImageView(new Image(image,w,h,false,false));		
		this.setGraphic(texture);
		
		this.getStyleClass().add("targyButton");
		
		X = x;
		Y = y;
			
	
		
		this.setPrefWidth(w);
		this.setPrefHeight(h);
	}
	/**
	 * Visszaadja a gombhoz tartozó textúrát miután beállítja a poziciót ahol meg szeretnénk jeleníteni
	 */
	public ImageView getTexture() {
		texture.setTranslateX(X);
		texture.setTranslateY(Y);	
		return texture;
	}
	/**
	 * Visszaadja a gombhoz tartozó tárgyat
	 */
	public Targy getTargy() {
		return targy;
	}
}
