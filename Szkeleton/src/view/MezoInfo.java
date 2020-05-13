package view;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import objects.*;
public class MezoInfo extends Button  {
	private Mezo mezo;
	private ImageView texture;
	public MezoInfo(Mezo m, String image, double x, double y, double w, double h) {
		mezo = m;
		texture = new ImageView(new Image(image,w,h,false,false));		
		
	
		//this.setGraphic(texture);
		
		this.getStyleClass().add("mezoButton");
		
		
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		this.setPrefWidth(w);
		this.setPrefHeight(h);
		
	}
	public Mezo getMezo() {
		return mezo;
	}
	public void setTexture(String image) {
		texture.setImage(new Image(image,getPrefWidth(),getPrefHeight(),false,false)); 
	}
	public double getCenterX() {
		return getTranslateX()+getPrefWidth()/2;
	}
	public double getCenterY() {
		return getTranslateY()+getPrefHeight()/2;
	}
	public void setCenter(double x, double y) {
		setTranslateX(x-getPrefWidth()/2);
		setTranslateY(y-getPrefHeight()/2);
	}

}
