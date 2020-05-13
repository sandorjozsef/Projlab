package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import objects.Targy;

public class TargyInfo  extends Button  {
	private Targy targy;
	private ImageView texture;
	public TargyInfo(Targy t, String image, double x, double y, double w, double h) {
		targy = t;	
		texture = new ImageView(new Image(image,w,h,false,false));		
		this.setGraphic(texture);
		
		this.getStyleClass().add("targyButton");
		
		
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		this.setPrefWidth(w);
		this.setPrefHeight(h);
	}
	public ImageView getTexture() {
		return texture;
	}
}
