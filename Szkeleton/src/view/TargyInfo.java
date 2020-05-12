package view;

import javafx.scene.control.Button;
import objects.Targy;

public class TargyInfo  extends Button  {
	private Targy targy;
	public TargyInfo(Targy t, double x, double y, double w, double h) {
		targy = t;
		this.setTranslateX(x);
		this.setTranslateY(y);
		
		this.setWidth(w);
		this.setHeight(h);
	}
}
