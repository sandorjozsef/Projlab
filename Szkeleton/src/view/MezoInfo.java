package view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import objects.*;
public class MezoInfo extends Button  {
	private Mezo mezo;
	private ImageView texture;
	public MezoInfo(Mezo m, double x, double y, double w, double h) {
		mezo = m;
		texture = new ImageView(new Image("file:texturak/texturetest.png",w,h,false,false));		
		//this.setGraphic(texture);
		
		this.getStyleClass().add("mezoButton");
		
		
		
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		this.setPrefWidth(w);
		this.setPrefHeight(h);
	}
}
