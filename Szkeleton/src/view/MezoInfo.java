package view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import objects.*;
public class MezoInfo extends Button  {
	private Mezo mezo;
	public MezoInfo(Mezo m, double x, double y, double w, double h) {
		mezo = m;
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		this.setWidth(w);
		this.setHeight(h);
	}
}
