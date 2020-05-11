package view;



import java.util.ArrayList;

import javafx.*;
import javafx.geometry.Insets;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import objects.*;
import main.MyApplication;

public class GrafNezet {
	private Scene menuNezet ;
	private Scene jatekNezet ;	
	private VBox menuRoot ;
	private HBox topMenu;
	private VBox jobbMenu;
	private BorderPane jatekRoot;
	
	private Button startB, betoltB, menuKilepB;
	private TextField betoltPalya, betoltJatek;
	
	private Button jatekKilepB,	mentesB, felveszB, takaritB, kepessegB,	atlepB,	lepesvegeB;
	private TextField mentJatek;
	
	private Text szereploNev;
	private Text testHo;
	private Text lepesSzam;
	
	private Text cimke;

	public GrafNezet(){
		
		
		cimke = new Text("MENÜ");
		startB = new Button("START");
		betoltB = new Button("BETÖLT");
		menuKilepB = new Button("KILÉP");		
		betoltPalya = new TextField();
		betoltJatek = new TextField();
		
		menuRoot = new VBox(cimke, startB, betoltPalya, betoltB, betoltJatek, menuKilepB);
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
		
		testHo = new Text("Testhő:");
		lepesSzam = new Text("Lépésszám:");
		szereploNev = new Text("Szereplo1");
		
		topMenu = new HBox(jatekKilepB,mentesB,mentJatek);
		jobbMenu = new VBox(szereploNev,testHo, lepesSzam,felveszB, takaritB, kepessegB,atlepB,lepesvegeB);
		jatekRoot = new BorderPane(null,topMenu,jobbMenu,null,null);		
		jatekNezet = new Scene(jatekRoot, 1400, 800, Color.BLACK);
		
		 Palya();
	}
	public void Menu() {
		menuNezet.getStylesheets().add("file:jatekStyle.css");	
		menuRoot.getStyleClass().add("menuRoot");
		
		
		menuRoot.setSpacing(15);			
		menuRoot.setFocusTraversable(false);		
		menuRoot.setAlignment(Pos.CENTER);
		
		VBox.setMargin(cimke, new Insets(0,0,80,0));
		cimke.getStyleClass().add("cimke");
		
		betoltPalya.setMaxWidth(200);
		betoltJatek.setMaxWidth(200);				
	}
	public void Palya() {
		jatekNezet.getStylesheets().add("file:jatekStyle.css");		
		jatekRoot.getStyleClass().add("jatekRoot");
		jobbMenu.getStyleClass().add("jobbMenu");
		
		
		jatekRoot.setFocusTraversable(false);		
		
		jobbMenu.setSpacing(10);
		jobbMenu.setAlignment(Pos.CENTER);
		jobbMenu.setPadding(new Insets(20));
		
		topMenu.setSpacing(5);
		topMenu.setAlignment(Pos.CENTER_LEFT);
		topMenu.setMinHeight(60);
		
		VBox.setMargin(szereploNev, new Insets(0,0,100,0));
		VBox.setMargin(lepesSzam, new Insets(0,0,100,0));
		
		mentJatek.setMaxWidth(300);
	}
	public void Mezolehelyez(ArrayList<Mezo> mezok) {
		
	}
	public void FrissitKutato(Kutato k){
		
	}
	public void FrissitEszkimo(Eszkimo e) {
		
	}
	public void Frissitmedve(Medve m) {
		
	}
	public void FrissitLuk(Luk l) {
		
	}
	public void FrissitStabilJegtabla(StabilJegtabla s) {
		
	}
	public void FrissitInstabilJegtabla(InstabilJegtabla i) {
		
	}
	public void FrissitAso(Aso a) {
		
	}
	public void FrissitLapat(Lapat l) {
		
	}
	public void FrissitElelem(Elelem e) {
		
	}
	public void FrissitSator(Sator s) {
		
	}
	public void FrissitBuvarruha(Buvarruha b) {
		
	}
	public void FrissitAlkatresz(Alkatresz a) {
		
	}
	public void FrissitKotel(Kotel k) {
		
	}
	public void FrissitIglu(Iglu i) {
		
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
	public Button getFelveszB() {
		return felveszB;
	}
	public Button getTakaritB() {
		return takaritB;
	}
	public Button getKepessegB() {
		return kepessegB;
	}
	public Button getAtlepB() {
		return atlepB;
	}
	public Button getLepesvegeB() {
		return lepesvegeB;
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

