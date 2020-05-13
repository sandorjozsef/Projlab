package view;




import java.util.ArrayList;

import javafx.*;
import javafx.geometry.Insets;


import java.util.ArrayList;


import javafx.geometry.Pos;
import objects.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
	private ArrayList<MezoInfo> mezoinf;
	private Scene menuNezet ;
	private Scene jatekNezet ;	
	private VBox menuRoot;
	private HBox topMenu;
	private HBox jobbPanel;
	private VBox jobbMenu;
	private VBox allapotBar;
	private VBox targyBar;
	private VBox aktMezoBar;
	private VBox valasztottMezoBar;
	private Pane fixJatekTer;
	private Pane valtozoJatekTer;
	private BorderPane jatekRoot;
	
	private Button startB, betoltB, menuKilepB;
	private TextField betoltPalya, betoltJatek;
	
	private Button jatekKilepB,	mentesB, felveszB, takaritB, kepessegB,	atlepB,	lepesvegeB;
	private TextField mentJatek;
	

	private Text szereploNev;
	private Text testHo;
	private Text lepesSzam;
	
	private Text cimke;
	
	private Text aktMezoAllapot;
	private Text valasztottMezoAllapot;


	private double aktX, aktY;
	private int mezoMeret = 200;
	private int szereploMeret =80;
	private int targyMeret = 50;
	private int epuletMeret= 100;
	private int mezoTav = 60;
	private boolean vizben;

	public GrafNezet(){

		mezoinf = new ArrayList<MezoInfo>();
		
		cimke = new Text("MENÜ");

		vizben = false;

		startB = new Button("START");
		betoltB = new Button("BETÖLT");
		menuKilepB = new Button("KILÉP");		
		betoltPalya = new TextField();
		betoltJatek = new TextField();
		
		menuRoot = new VBox(cimke, startB, betoltPalya, betoltB, betoltJatek, menuKilepB);
		menuNezet = new Scene(menuRoot, 500, 800, Color.BLACK);		
		Menu();
		
		
		jatekKilepB = new Button("KILÉP");
		mentesB = new Button("MENTÉS");
		felveszB = new Button("FELVESZ");
		takaritB = new Button("TAKARIT");
		kepessegB = new Button("KÉPESSÉG");
		atlepB = new Button("ÁTLÉP");
		lepesvegeB = new Button("LÉPÉS VÉGE");		
		mentJatek = new TextField();
		
		testHo = new Text("Testhő:");
		lepesSzam = new Text("Lépésszám:");
		szereploNev = new Text("Szereplo1");
		aktMezoAllapot = new Text("Aktuális mező\nHóvastagság:\nTeherbírás:");
		valasztottMezoAllapot = new Text("Kiválasztott mező\nHóvastagság:\nTeherbírás:");
		
		ScrollPane sc= new ScrollPane();		
		sc.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		sc.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		sc.setPannable(true);

		valtozoJatekTer = new Pane();
		fixJatekTer = new Pane(valtozoJatekTer);		
		sc.setContent(fixJatekTer);
		
		
		topMenu = new HBox(jatekKilepB,mentesB,mentJatek);
		targyBar = new VBox(new TargyInfo(null,"file:texturak/texturetest.png",0,0,this.targyMeret,targyMeret));
		aktMezoBar = new VBox(aktMezoAllapot);
		valasztottMezoBar = new VBox(valasztottMezoAllapot);
		
		allapotBar = new VBox(targyBar,valasztottMezoBar, aktMezoBar);
		
		
		jobbMenu = new VBox(szereploNev,testHo, lepesSzam,felveszB, takaritB, kepessegB,atlepB,lepesvegeB);	
		jobbPanel = new HBox(allapotBar,jobbMenu);		
		jatekRoot = new BorderPane(sc,topMenu,jobbPanel,null,null);		
		jatekNezet = new Scene(jatekRoot, 1400, 800, Color.BLACK);
		
		 Palya();
	}
	public void Menu() {
		menuNezet.getStylesheets().add("file:jatekStyle.css");	
		menuRoot.getStyleClass().add("menuRoot");		
		menuRoot.setSpacing(15);					
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
		
		
		allapotBar.setAlignment(Pos.BOTTOM_RIGHT);
		
		targyBar.setAlignment(Pos.CENTER_RIGHT);
		targyBar.setSpacing(1);
		targyBar.setPadding(new Insets(8));
	
		
		aktMezoBar.getStyleClass().add("mezoBar");
		aktMezoBar.setPadding(new Insets(10));
	
		valasztottMezoBar.getStyleClass().add("mezoBar");
		valasztottMezoBar.setPadding(new Insets(10));
		
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
	
	public void torolMind() {
		this.fixJatekTer.getChildren().clear();
		this.Torol();
		mezoinf.clear();
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
	

	private void TargyakRajzol(Szereplo sz)
	{
		targyBar.getChildren().clear();
		ArrayList<Targy> targyak = new ArrayList<Targy>();
		boolean go = true;
		for(int i = 0; go; i++)
		{
			Targy akt = sz.getTargy(i);
			if (akt == null)
				go = false;
			else
				targyak.add(akt);
		}
		for (int i = 0; i < targyak.size(); i++)
		{	
			aktX=0;aktY=0;
			targyak.get(i).FrissitNezet(this);
		}
	}
	
	public void FrissitKutato (Kutato sz, boolean aktJatekos) {
		// TODO: Kirajzoltatja magat vizben attributum fuggvenyeben
		ImageView kutatoKep;
		if(vizben) { kutatoKep= new ImageView(new Image("file:texturak/Kutato.png",szereploMeret,szereploMeret,false,false));}
		else{kutatoKep = new ImageView(new Image("file:texturak/Kutato.png",szereploMeret,szereploMeret,false,false));}
		kutatoKep.setTranslateX(aktX-szereploMeret/2);
		kutatoKep.setTranslateY(aktY-szereploMeret/2);
		valtozoJatekTer.getChildren().add(kutatoKep);
		
		if (aktJatekos)
		{
			TargyakRajzol(sz);
			// TODO: ruha helyet meghatarozni
			sz.getRuha().FrissitNezet(this);
			
			Mezo akt = sz.getMezo();
            ArrayList<Mezo> mezok = akt.getSzomszed();
            for(int i = 0; i < mezoinf.size(); i++)
            {
                if (mezok.contains(mezoinf.get(i).getMezo()))
                    mezoinf.get(i).setStyle("-fx-border-color:red");
                else if (akt == mezoinf.get(i).getMezo())
                    mezoinf.get(i).setStyle("-fx-border-color:yellow");
                else
                    mezoinf.get(i).setStyle("-fx-border-color:rgb(70, 130, 180)");
            }
		}
	}
	
	public void FrissitEszkimo (Eszkimo sz, boolean aktJatekos) {
		// TODO: Kirajzoltatja magat vizben attributum fuggvenyeben
		ImageView EszkimoKep;
		if(vizben) { EszkimoKep= new ImageView(new Image("file:texturak/Eszkimo.png",szereploMeret,szereploMeret,false,false));}
		else{EszkimoKep = new ImageView(new Image("file:texturak/Eszkimo.png",szereploMeret,szereploMeret,false,false));}
		EszkimoKep.setTranslateX(aktX-szereploMeret/2);
		EszkimoKep.setTranslateY(aktY-szereploMeret/2);
		valtozoJatekTer.getChildren().add(EszkimoKep);
		if (aktJatekos)
		{
			TargyakRajzol(sz);
			// TODO: ruha helyet meghatarozni
			sz.getRuha().FrissitNezet(this);
			
			Mezo akt = sz.getMezo();
            ArrayList<Mezo> mezok = akt.getSzomszed();
            for(int i = 0; i < mezoinf.size(); i++)
            {
                if (mezok.contains(mezoinf.get(i).getMezo()))
                    mezoinf.get(i).setStyle("-fx-border-color:red");
                else if (akt == mezoinf.get(i).getMezo())
                    mezoinf.get(i).setStyle("-fx-border-color:yellow");
                else
                    mezoinf.get(i).setStyle("-fx-border-color:rgb(70, 130, 180)");
            }
		}
	}
	
	public void FrissitMedve (Medve sz) {
		// TODO: Kirajzoltatja magat vizben attributum fuggvenyeben
		ImageView MedveKep;
		if(vizben) { MedveKep= new ImageView(new Image("file:texturak/Eszkimo.png",szereploMeret,szereploMeret,false,false));}
		else{MedveKep = new ImageView(new Image("file:texturak/Eszkimo.png",szereploMeret,szereploMeret,false,false));}
		MedveKep.setTranslateX(aktX-szereploMeret/2);
		MedveKep.setTranslateY(aktY-szereploMeret/2);
		valtozoJatekTer.getChildren().add(MedveKep);
	}
	
	public void FrissitLuk (Luk m) {
		// kikeresei a hozzá tartozo mezoinfot
		//hozzaadja a jatekterhez a mezoinfot
		
		int i;
		for (i = 0; i < mezoinf.size(); i++)
		{
			if (mezoinf.get(i).getMezo().getId()==m.getId())
			{
				aktX = mezoinf.get(i).getCenterX();
				aktY = mezoinf.get(i).getCenterY();
				break;
			}
		}
		
		// TODO: Mezo kirajzoltatasa, felderitettseg vizsgalata
		
		if (m.getfelderitett()) {mezoinf.get(i).setTexture("file:texturak/Luk.png");}
		
		ArrayList<Szereplo> szereplok = m.getSzereplok();
		vizben = true;
		aktX -=this.mezoMeret/2-this.szereploMeret/2;
		int size=szereplok.size();
		for (int j = 0; j < size; j++)
		{ // TODO: szereplok eltolasat javitani kell a pontos mezomeret alapjan (aktX, aktY eltolasa)
			szereplok.get(j).FrissitNezet(this);
			aktX += mezoMeret/size;
		}
		vizben = false;
	}
	
	public void FrissitStabilJegtabla (StabilJegtabla m, boolean targyRajz) {
		int i;
		for (i = 0; i < mezoinf.size(); i++)
		{
			if (mezoinf.get(i).getMezo().getId()==m.getId())
			{
				aktX = mezoinf.get(i).getCenterX();
				aktY = mezoinf.get(i).getCenterY();
				break;
			}
		}
		
		// TODO: Mezo kirajzoltatasa, felderitettseg vizsgalata
		
		if (m.getfelderitett()) {mezoinf.get(i).setTexture("file:texturak/Stabil.png");}
		
		ArrayList<Szereplo> szereplok = m.getSzereplok();
		aktX -=this.mezoMeret/2-this.szereploMeret/2;
		int size=szereplok.size();
		for (int j = 0; j < size; j++)
		{ // TODO: szereplok eltolasat javitani kell a pontos mezomeret alapjan (aktX, aktY eltolasa)
			szereplok.get(j).FrissitNezet(this);
			aktX += mezoMeret/size;
		}
		
		if (targyRajz)
		{ // TODO: targy helyenek beallitasa (Mezo helyzetenek fuggvenyeben mezoinf.get(p).X, .Y)
			// Keretet is kell rajzolni
			
			aktX = mezoinf.get(i).getCenterX();
			aktY = mezoinf.get(i).getCenterY();
			aktY += this.targyMeret;
			m.getTargy().FrissitNezet(this);
		}
		
		// TODO: elozoek erre is...
		aktX = mezoinf.get(i).getCenterX();
		aktY = mezoinf.get(i).getCenterY();
		aktY -= this.epuletMeret;
		m.getEpulet().FrissitNezet(this);
	}
	
	public void FrissitInstabilJegtabla (InstabilJegtabla m, boolean targyRajz) {
		int i;
		for (i = 0; i < mezoinf.size(); i++)
		{
			if (mezoinf.get(i).getMezo().getId()==m.getId())
			{
				aktX = mezoinf.get(i).getCenterX();
				aktY = mezoinf.get(i).getCenterY();
				break;
			}
		}
		
		// TODO: Mezo kirajzoltatasa, felderitettseg vizsgalata
		
		if (m.getfelderitett()) {mezoinf.get(i).setTexture("file:texturak/Instabil.png");}
		
		ArrayList<Szereplo> szereplok = m.getSzereplok();
		ArrayList<Szereplo> alatta = m.getAlatta();
		aktX -=this.mezoMeret/2-this.szereploMeret/2;
		int sizes=szereplok.size();
		int sizea=alatta.size();
		for (int j = 0; j < sizes; j++)
		{ // TODO: szereplok eltolasat javitani kell a pontos mezomeret alapjan (aktX, aktY eltolasa)
			szereplok.get(j).FrissitNezet(this);
			aktX += mezoMeret/(sizes+sizea);
		}
		
		vizben = true;
		for (int j = 0; j < sizea; j++)
		{ // TODO: szereplok eltolasat javitani kell a pontos mezomeret alapjan (aktX, aktY eltolasa)
			alatta.get(j).FrissitNezet(this);
			aktX += mezoMeret/(sizes+sizea);
		}
		vizben = false;
	
		if (targyRajz)
		{ // TODO: targy helyenek beallitasa (Mezo helyzetenek fuggvenyeben mezoinf.get(p).X, .Y)
			// Keretet is kell rajzolni
			
			aktX = mezoinf.get(i).getCenterX();
			aktY = mezoinf.get(i).getCenterY();
			aktY += this.targyMeret;
			m.getTargy().FrissitNezet(this);
		}
	}
	
	
	public void FrissitAso(Aso t) {
		// TODO: Kirajzoltatja magat
		TargyInfo t1 = new TargyInfo(t,"file:texturak/Aso.png",aktX-targyMeret/2,aktY-targyMeret/2,targyMeret,targyMeret);
		if(aktX==0&&aktY==0) {targyBar.getChildren().add(t1);}
		else {valtozoJatekTer.getChildren().add(t1);}
			
	}
	
	public void FrissitLapat(Lapat t) {
		// TODO: Kirajzoltatja magat
		TargyInfo t1 = new TargyInfo(t,"file:texturak/lapat.png",aktX-targyMeret/2,aktY-targyMeret/2,targyMeret,targyMeret);
		if(aktX==0&&aktY==0) {targyBar.getChildren().add(t1);}
		else {valtozoJatekTer.getChildren().add(t1);}
	}
	
	public void FrissitElelem(Elelem t) {
		// TODO: Kirajzoltatja magat
		TargyInfo t1 = new TargyInfo(t,"file:texturak/kaja.png",aktX-targyMeret/2,aktY-targyMeret/2,targyMeret,targyMeret);
		if(aktX==0&&aktY==0) {targyBar.getChildren().add(t1);}
		else {valtozoJatekTer.getChildren().add(t1);}
	}
	
	public void FrissitSator(Sator t) {
		// TODO: Kirajzoltatja magat
		TargyInfo t1 = new TargyInfo(t,"file:texturak/Sator.png",aktX-targyMeret/2,aktY-targyMeret/2,targyMeret,targyMeret);
		if(aktX==0&&aktY==0) {targyBar.getChildren().add(t1);}
		else {valtozoJatekTer.getChildren().add(t1);}
	}
	
	public void FrissitBuvarRuha(Buvarruha t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitAlapRuha(AlapRuha t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitAlkatresz(Alkatresz t) {
		// TODO: Kirajzoltatja magat
		TargyInfo t1 = new TargyInfo(t,"file:texturak/Alkatresz.png",aktX-targyMeret/2,aktY-targyMeret/2,targyMeret,targyMeret);
		if(aktX==0&&aktY==0) {targyBar.getChildren().add(t1);}
		else {valtozoJatekTer.getChildren().add(t1);}
	}
	
	public void FrissitKotel(Kotel t) {
		// TODO: Kirajzoltatja magat
		TargyInfo t1 = new TargyInfo(t,"file:texturak/Kotel.png",aktX-targyMeret/2,aktY-targyMeret/2,targyMeret,targyMeret);
		if(aktX==0&&aktY==0) {targyBar.getChildren().add(t1);}
		else {valtozoJatekTer.getChildren().add(t1);}
	}
	
	public void FrissitIglu(Iglu e) {
		// TODO: Kirajzoltatja magat
		ImageView igluKep = new ImageView(new Image("file:texturak/Iglu.png",epuletMeret,epuletMeret,false,false));
		igluKep.setTranslateX(aktX-epuletMeret/2);
		igluKep.setTranslateY(aktY-epuletMeret/2);
		valtozoJatekTer.getChildren().add(igluKep);
	}
	
	public void FrissitNoglu(Noglu e) {
		// TODO: nem csinál semmit
	}
	
	public void Mezolehelyez(ArrayList<Mezo> mezok) {
		// TODO: Joconak kene egy grafkirajzolast irnia
		
		for(int i = 0, j = 0; i<mezok.size();i++) {
			MezoInfo mezoinfo = new MezoInfo(mezok.get(i),"file:texturak/Felderitetlen.png",(mezoMeret+mezoTav)*(i%4),(i%4==0&&i!=0?j+=(mezoMeret+mezoTav):j),mezoMeret,mezoMeret);
			mezoinf.add(mezoinfo);
		}	
		
		
		mezoinf.forEach(mi->{
			mezoinf.forEach(mj->{
				if(mi.getMezo().isSzomszed(mj.getMezo())){
					Line vonal = new Line(mi.getCenterX(),mi.getCenterY(),mj.getCenterX(),mj.getCenterY());
					vonal.setStrokeWidth(3);
				    vonal.setStroke(Color.CORNFLOWERBLUE);
					fixJatekTer.getChildren().add(vonal);
				}
				
			});
			
		});
		
		fixJatekTer.getChildren().addAll(mezoinf);
		fixJatekTer.setPrefHeight((mezok.size() / 4 + 1) * (mezoTav+mezoMeret));
		
	}
	
	public void Torol() {
		// Letorli a palyat
		valtozoJatekTer.getChildren().clear();
	}

}

