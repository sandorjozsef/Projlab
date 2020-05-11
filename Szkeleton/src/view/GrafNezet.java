package view;




import java.util.ArrayList;

import javafx.geometry.Pos;
import objects.*;
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
	private ArrayList<Mezoinfo> mezoinf;
	private Scene menuNezet ;
	private Scene jatekNezet ;
	private VBox menuRoot ;
	private BorderPane jatekRoot;
	
	private Button startB, betoltB, menuKilepB;
	private TextField betoltPalya, betoltJatek;
	
	private Button jatekKilepB,	mentesB, felveszB, takaritB, kepessegB,	atlepB,	lepesvegeB;
	private TextField mentJatek;
	
	private int aktX, aktY;
	private boolean vizben;
	public GrafNezet(){
		vizben = false;
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
	
	private void TargyakRajzol(Szereplo sz)
	{
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
		{	// TODO: repository helye, eltolas a targyszam (i) fuggvenyeben
			targyak.get(i).FrissitNezet(this);
		}
	}
	
	public void FrissitKutato (Kutato sz, boolean aktJatekos) {
		// TODO: Kirajzoltatja magat vizben attributum fuggvenyeben
		if (aktJatekos)
		{
			TargyakRajzol(sz);
			// TODO: ruha helyet meghatarozni
			sz.getRuha().FrissitNezet(this);
		}
	}
	
	public void FrissitEszkimo (Eszkimo sz, boolean aktJatekos) {
		// TODO: Kirajzoltatja magat vizben attributum fuggvenyeben
		if (aktJatekos)
		{
			TargyakRajzol(sz);
			// TODO: ruha helyet meghatarozni
			sz.getRuha().FrissitNezet(this);
		}
	}
	
	public void FrissitMedve (Medve sz) {
		// TODO: Kirajzoltatja magat vizben attributum fuggvenyeben
	}
	
	public void FrissitLuk (Luk m) {
		int i;
		String luk_id = m.getId();
		for (i = 0; i < mezoinf.size(); i++)
		{
			if (mezoinf.get(i).id.equals(luk_id))
			{
				aktX = mezoinf.get(i).X;
				aktY = mezoinf.get(i).Y;
			}
		}
		// TODO: Mezo kirajzoltatasa, felderitettseg vizsgalata
		ArrayList<Szereplo> szereplok = m.getSzereplok();
		vizben = true;
		for (i = 0; i < szereplok.size(); i++)
		{ // TODO: szereplok eltolasat javitani kell a pontos mezomeret alapjan (aktX, aktY eltolasa)
			szereplok.get(i).FrissitNezet(this);
		}
		vizben = false;
	}
	
	public void FrissitStabilJegtabla (StabilJegtabla m, boolean targyRajz) {
		int i;
		String mezo_id = m.getId();
		for (i = 0; i < mezoinf.size(); i++)
		{
			if (mezoinf.get(i).id.equals(mezo_id))
			{
				aktX = mezoinf.get(i).X;
				aktY = mezoinf.get(i).Y;
			}
		}
		// TODO: Mezo kirajzoltatasa, felderitettseg vizsgalata
		ArrayList<Szereplo> szereplok = m.getSzereplok();
		for (i = 0; i < szereplok.size(); i++)
		{ // TODO: szereplok eltolasat javitani kell a pontos mezomeret alapjan (aktX, aktY eltolasa)
			szereplok.get(i).FrissitNezet(this);
		}
		if (targyRajz)
		{ // TODO: targy helyenek beallitasa (Mezo helyzetenek fuggvenyeben mezoinf.get(p).X, .Y)
			// Keretet is kell rajzolni
			m.getTargy().FrissitNezet(this);
		}
		// TODO: elozoek erre is...
		m.getEpulet().FrissitNezet(this);
	}
	
	public void FrissitInstabilJegtabla (InstabilJegtabla m, boolean targyRajz) {
		int p;
		String mezo_id = m.getId();
		for (p = 0; p < mezoinf.size(); p++)
		{
			if (mezoinf.get(p).id.equals(mezo_id))
			{
				aktX = mezoinf.get(p).X;
				aktY = mezoinf.get(p).Y;
			}
		}
		// TODO: Mezo kirajzoltatasa, felderitettseg vizsgalata
		ArrayList<Szereplo> szereplok = m.getSzereplok();
		ArrayList<Szereplo> alatta = m.getAlatta();
		for (int i = 0; i < szereplok.size(); i++)
		{ // TODO: szereplok eltolasat javitani kell a pontos mezomeret alapjan (aktX, aktY eltolasa)
			szereplok.get(i).FrissitNezet(this);
		}
		vizben = true;
		for (int i = 0; i < alatta.size(); i++)
		{ // TODO: szereplok eltolasat javitani kell a pontos mezomeret alapjan (aktX, aktY eltolasa)
			alatta.get(i).FrissitNezet(this);
		}
		vizben = false;
		if (targyRajz)
		{ // TODO: targy helyenek beallitasa (Mezo helyzetenek fuggvenyeben mezoinf.get(p).X, .Y)
			// Keretet is kell rajzolni
			m.getTargy().FrissitNezet(this);
		}
	}
	
	public void FrissitAso(Aso t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitLapat(Lapat t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitElelem(Elelem t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitSator(Sator t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitBuvarRuha(Buvarruha t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitAlapRuha(AlapRuha t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitAlkatresz(Alkatresz t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitKotel(Kotel t) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitIglu(Iglu e) {
		// TODO: Kirajzoltatja magat
	}
	
	public void FrissitNoglu(Noglu e) {
		// TODO: Kirajzoltatja magat
	}
	
	public void Mezolehelyez(ArrayList<Mezo> mezok) {
		// TODO: Joconak kene egy grafkirajzolast irnia
	}
	
	public void Torol() {
		// Letorli a palyat
	}
}

