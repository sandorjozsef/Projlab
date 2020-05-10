package view;



import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.MyApplication;

public class GrafNezet {
	private Scene menuNezet ;
	private Scene jatekNezet ;
	private VBox menuRoot ;
	private BorderPane jatekRoot;
	
	private Button startB, betoltB, menuKilepB;
	private TextField betoltPalya, betoltJatek;
	
	private Button jatekKilepB,	mentesB, felveszB, takaritB, kepessegB,	atlepB,	lepesvegeB;
	private TextField mentJatek;
	public GrafNezet(){
		
		startB = new Button("START");
		betoltB = new Button("BETÖLT");
		menuKilepB = new Button("KILÉP");		
		betoltPalya = new TextField();
		betoltJatek = new TextField();
		
		menuRoot = new VBox(startB, betoltPalya, betoltB, betoltJatek, menuKilepB);
		menuNezet = new Scene(menuRoot, 500, 800, Color.BLACK);		
		Menu();
		
		
		jatekKilepB = new Button("KILÉP");
		mentesB = new Button("ELMENT");
		felveszB = new Button("FELVESZ");
		takaritB = new Button("TAKARIT");
		kepessegB = new Button("KÉPESSÉG");
		atlepB = new Button("ÁTLÉP");
		lepesvegeB = new Button("LÉPÉS VÉGE");		
		mentJatek = new TextField();
		
		jatekRoot = new BorderPane();		
		jatekNezet = new Scene(jatekRoot, 1000, 800, Color.BLACK);
		
		 Palya();
	}
	public void Menu() {
		menuRoot.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
		menuRoot.setSpacing(10);			
		menuRoot.setFocusTraversable(false);		
		menuRoot.setAlignment(Pos.CENTER);
		
		betoltPalya.setMaxWidth(200);
		betoltJatek.setMaxWidth(200);				
	}
	public void Palya() {
		jatekRoot.setBackground(new Background(new BackgroundFill(Color.DODGERBLUE,null,null)));
		jatekRoot.setFocusTraversable(false);	
		
		HBox topMenu = new HBox(jatekKilepB,mentesB,mentJatek);
		VBox jobbMenu = new VBox(felveszB, takaritB, kepessegB,	atlepB,	lepesvegeB);
		jatekRoot.setTop(topMenu);
		jatekRoot.setRight(jobbMenu);
		
		jobbMenu.setSpacing(10);
		jobbMenu.setAlignment(Pos.CENTER);
		
		mentJatek.setMaxWidth(300);
	}
	public Scene getMenuNezet() {
		return menuNezet;
	}
	public Scene getJatekNezet() {
		return jatekNezet;
	}
	public Button getStartB() {
		return startB;
	}
	public Button getBetoltB() {
		return betoltB;
	}
	public Button getMenuKilepB() {
		return menuKilepB;
	}
	public Button getJatekKilepB() {
		return jatekKilepB;
	}
	public Button getMentesB() {
		return mentesB;
	}
	public String getPalyaNev() {
		return betoltPalya.getText();
	}
	public String getJatekNev() {
		return betoltJatek.getText();
	}
	public String getMentNev() {
		return mentJatek.getText();
	}
}

