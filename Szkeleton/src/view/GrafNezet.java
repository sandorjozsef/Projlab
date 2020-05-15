package view;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import objects.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
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
	private FlowPane targyBar;
	private HBox alkatreszBar;
	private VBox aktMezoBar;
	private VBox valasztottMezoBar;
	private Pane jatekTer;
	private ArrayList<ImageView> valtozoJatekTer;	
	private BorderPane jatekRoot;
	private ScrollPane sc;
	private Button startB, betoltB, menuKilepB;
	
	private ComboBox<String> betoltPalya;
	private TextField betoltJatek;
	
	private Button jatekKilepB,	mentesB, felveszB, takaritB, kepessegB,	atlepB,	lepesvegeB;
	private TextField mentJatek;
	

	private Text szereploNev;
	private Text testHo;
	private Text lepesSzam;
	
	private Text cimke;
	
	private Text aktMezoAllapot;
	private Text valasztottMezoAllapot;
	private ImageView jatekosKep;
	private ImageView ruhaKep;
	MyActionListener kattintasKezelo = new MyActionListener(this);

	private double aktX, aktY;
	private int mezoMeret = 200;
	private int szereploMeret =80;
	private int targyMeret = 80;
	private int epuletMeret= 100;
	private int mezoTav = 100;
	private boolean vizben = false;
	private boolean hasznalhato= false;
	private boolean hordja = false;
	
	private Mezo kijeloltMezo=null;

	public GrafNezet(){

		
		mezoinf = new ArrayList<MezoInfo>();
		
		cimke = new Text("MENÜ");

		
		startB = new Button("START");
		betoltB = new Button("BETÖLT");
		menuKilepB = new Button("KILÉP");		
		betoltPalya = new ComboBox<String>();
		betoltJatek = new TextField();
		
		menuRoot = new VBox(cimke, startB, betoltPalya, betoltB, betoltJatek, menuKilepB);
		menuNezet = new Scene(menuRoot, 500, 800, Color.BLACK);		
		Menu();
		
		
		jatekKilepB = new Button("KILÉP");
		mentesB = new Button("MENTÉS");
		felveszB = new Button("FELVESZ");
		felveszB.setTooltip(new Tooltip("Egy tárgy felvétele\nnem havas mezőről"));
		takaritB = new Button("TAKARIT");
		takaritB.setTooltip(new Tooltip("1 egység hó eltakarítása\naz aktuális mezőről"));
		kepessegB = new Button("KÉPESSÉG");
		kepessegB.setTooltip(new Tooltip("Szereplő speciális képessége"));
		atlepB = new Button("ÁTLÉP");
		atlepB.setTooltip(new Tooltip("Átlépés egy előre kijelölt mezőre"));
		lepesvegeB = new Button("LÉPÉS VÉGE");
		lepesvegeB.setTooltip(new Tooltip("Játékos körének befejezése"));
		mentJatek = new TextField();
		mentJatek.setTooltip(new Tooltip("Elérési út"));
		jatekosKep = new ImageView();
		ruhaKep = new ImageView();
		testHo = new Text("Testhő:");
		lepesSzam = new Text("Lépésszám:");
		szereploNev = new Text("");
		aktMezoAllapot = new Text("Aktuális mező\nHóvastagság:\nTeherbírás:");
		valasztottMezoAllapot = new Text("Kiválasztott mező\nHóvastagság:\nTeherbírás:");
		
		sc= new ScrollPane();		
		

		valtozoJatekTer = new ArrayList<ImageView>();		
		jatekTer = new Pane();		
		sc.setContent(jatekTer);
		
		alkatreszBar = new HBox();
		
		topMenu = new HBox(jatekKilepB,mentesB,mentJatek,alkatreszBar);
		targyBar = new FlowPane();
		aktMezoBar = new VBox(aktMezoAllapot);
		valasztottMezoBar = new VBox(valasztottMezoAllapot);
		
		allapotBar = new VBox(targyBar,valasztottMezoBar, aktMezoBar);
		
		
		jobbMenu = new VBox(szereploNev,jatekosKep,ruhaKep,testHo, lepesSzam,felveszB, takaritB, kepessegB,atlepB,lepesvegeB);	
		jobbPanel = new HBox(allapotBar,jobbMenu);		
		jatekRoot = new BorderPane(sc,topMenu,jobbPanel,null,null);		
		jatekNezet = new Scene(jatekRoot, 1400, 800, Color.BLACK);
		
		 Palya();
	}
	public void Menu() {
		menuNezet.getStylesheets().add("file:stilusok/jatekStyle.css");	
		menuRoot.getStyleClass().add("menuRoot");		
		menuRoot.setSpacing(15);					
		menuRoot.setAlignment(Pos.CENTER);
		
		
		VBox.setMargin(cimke, new Insets(0,0,80,0));
		cimke.getStyleClass().add("cimke");
		
		betoltPalya.getItems().addAll("Gold", "alap", "jatekvege", "chess1", "chess2", "diamond", "4x4");
		betoltPalya.setValue("");
		betoltPalya.setEditable(true);
		betoltPalya.setMaxWidth(200);
	    betoltPalya.getEditor().textProperty().addListener((obs, oldText, newText) -> {
	    	betoltPalya.setValue(newText);
        });
		betoltJatek.setMaxWidth(200);	
		
	}
	public void Palya() {
		jatekNezet.getStylesheets().add("file:stilusok/jatekStyle.css");		
		jatekRoot.getStyleClass().add("jatekRoot");
		jobbMenu.getStyleClass().add("jobbMenu");
		
		sc.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		sc.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		sc.setPannable(true);
	
		
		allapotBar.setAlignment(Pos.BOTTOM_RIGHT);
		
		targyBar.setAlignment(Pos.CENTER_RIGHT);
		targyBar.setVgap(1);
		targyBar.setHgap(1);
		targyBar.setPrefWrapLength(170);
		targyBar.setPadding(new Insets(8));
	
		
		aktMezoBar.getStyleClass().add("mezoBar");
		aktMezoBar.setPadding(new Insets(10));
	
		valasztottMezoBar.getStyleClass().add("mezoBar");
		valasztottMezoBar.setPadding(new Insets(10));
		
		jobbMenu.setSpacing(10);
		jobbMenu.setAlignment(Pos.CENTER);
		jobbMenu.setPadding(new Insets(20));
		
		topMenu.setPadding(new Insets(0,0,0,5));
		topMenu.setSpacing(5);
		topMenu.setAlignment(Pos.CENTER_LEFT);
		topMenu.setMinHeight(60);
	
		VBox.setMargin(szereploNev, new Insets(0,0,30,0));
		VBox.setMargin(lepesSzam, new Insets(0,0,50,0));
		
		mentJatek.setMaxWidth(300);
	}
	
	public void torolMind() {
		this.jatekTer.getChildren().clear();
		mezoinf.clear();		
		this.Torol();
	}
	public Mezo getKijeloltMezo() {
		return kijeloltMezo;
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
		 return betoltPalya.getValue();
	}
	public String getJatekNev() {
		return betoltJatek.getText();
	}
	public String getMentNev() {
		return mentJatek.getText();
	}
	

	private void TargyBarRajzol(Szereplo sz){
		
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
			hasznalhato = true;
			targyak.get(i).FrissitNezet(this);			 
		}
		hasznalhato = false;
	}
	
	private TargyInfo TargyRajzol(String path, Targy t) {
		TargyInfo t1 = new TargyInfo(t,path,aktX-targyMeret/2,aktY-targyMeret/2,targyMeret,targyMeret);
		t1.setFocusTraversable(false);
		if(hasznalhato){
			targyBar.getChildren().add(t1);
			t1.setOnAction(kattintasKezelo);	
		}
		else {
			valtozoJatekTer.add(t1.getTexture());
			jatekTer.getChildren().add(t1.getTexture());
		}	
		return t1;
	}
	private void ruhaRajzol(Szereplo sz) {
		hordja = true;
		sz.getRuha().FrissitNezet(this);
		hordja = false;
	}
	private void SzereploRajzol(String path) {
		ImageView szereploKep;
		if(vizben) 
		{ 
			szereploKep= new ImageView(new Image(path,szereploMeret,szereploMeret,false,false));
			szereploKep.setOpacity(0.4);
		}
		else
		{
			szereploKep = new ImageView(new Image(path,szereploMeret,szereploMeret,false,false));
		}
		szereploKep.setTranslateX(aktX-szereploMeret/2);
		szereploKep.setTranslateY(aktY-szereploMeret/2);		
		valtozoJatekTer.add(szereploKep);		
		jatekTer.getChildren().add(szereploKep);
	}
	
	
	private void aktSzereploRajzol(Szereplo sz, String path) {
		testHo.setText("Testhő: "+sz.getTestho());
		lepesSzam.setText("Lépésszám: "+sz.getLepesszam());
		szereploNev.setText(sz.getId());
		jatekosKep.setImage(new Image(path,szereploMeret,szereploMeret,false,false));
		
		TargyBarRajzol(sz);
		// TODO: ruha helyet meghatarozni
		ruhaRajzol(sz);
		
		Mezo akt = sz.getMezo();		
		
		aktMezoAllapot.setText("Aktuális mező\nHóvastagság: "+akt.gethoVastagsag()+"\nTeherbírás: "+(akt.getfelderitett()?akt.getTeherBiras():"ismeretlen"));
		 ArrayList<Mezo> szomszedmezok = akt.getSzomszed();
        for(int i = 0; i < mezoinf.size(); i++)
        {
        	mezoinf.get(i).getStyleClass().remove("szomszedMezo");
        	mezoinf.get(i).getStyleClass().remove("aktMezo");
        	mezoinf.get(i).getStyleClass().remove("tavoliMezo");
            if (szomszedmezok.contains(mezoinf.get(i).getMezo()))
            	mezoinf.get(i).getStyleClass().add("szomszedMezo");
            else if (akt == mezoinf.get(i).getMezo())
            	mezoinf.get(i).getStyleClass().add("aktMezo");
            else
            	mezoinf.get(i).getStyleClass().add("tavoliMezo");  
        }
	}
	
	
	private MezoInfo MezoRajzol(String path, Mezo m) {
		MezoInfo mezoinfo = null;
		
		for (int i = 0; i < mezoinf.size(); i++)
		{
			if (mezoinf.get(i).getMezo()==m)
			{
				mezoinfo = mezoinf.get(i);
				aktX = mezoinfo.getCenterX();
				aktY = mezoinfo.getCenterY();
				break;
			}
		}
		
		if (m.getfelderitett()) {
			mezoinfo.setStyle(path);			
		}
		else {
			mezoinfo.setStyle("-fx-background-color: rgb(82,82,82)");			
		}
		
		return mezoinfo;
	}
	
	public void FrissitKutato (Kutato sz, boolean aktJatekos) {
		SzereploRajzol("file:texturak/Kutato.png");
		
		if (aktJatekos)
		{
			aktSzereploRajzol(sz,"file:texturak/Kutato.png");
		}
	}
	
	public void FrissitEszkimo (Eszkimo sz, boolean aktJatekos) {
		SzereploRajzol("file:texturak/Eszkimo.png");
		
		if (aktJatekos)
		{
			aktSzereploRajzol(sz,"file:texturak/Eszkimo.png");
		}
	}
	
	public void FrissitMedve (Medve sz, boolean aktJatekos) {
		SzereploRajzol("file:texturak/Medve.png");
		
		if (aktJatekos)
		{
			aktSzereploRajzol(sz,"file:texturak/Medve.png");
			felveszB.setDisable(true);
			takaritB.setDisable(true);
			kepessegB.setDisable(true);		
		}
		else {
			felveszB.setDisable(false);
			takaritB.setDisable(false);
			kepessegB.setDisable(false);		
		}
	}
	
	public void FrissitLuk (Luk m) {
		MezoRajzol("-fx-background-color: rgb(218,227,243)",m);
	
		ArrayList<Szereplo> szereplok = m.getSzereplok();
		vizben = true;
		aktX -=this.mezoMeret/2-this.szereploMeret/2;
		int size=szereplok.size();
		for (int j = 0; j < size; j++){
			szereplok.get(j).FrissitNezet(this);
			aktX += mezoMeret/size;
		}
		vizben = false;
	}
	
	public void FrissitStabilJegtabla (StabilJegtabla m, boolean targyRajz) {
		
		MezoInfo mezoinfo = MezoRajzol("-fx-background-color: rgb(31,78,121)",m);
		
		ArrayList<Szereplo> szereplok = m.getSzereplok();
		aktX -=this.mezoMeret/2-this.szereploMeret/2;
		int size=szereplok.size();
		for (int j = 0; j < size; j++)
		{ 
			szereplok.get(j).FrissitNezet(this);
			aktX += mezoMeret/size;
		}
		
		if (targyRajz)
		{ 
			// Keretet is kell rajzolni
			
			aktX = mezoinfo.getCenterX();
			aktY = mezoinfo.getCenterY();
			aktY += mezoMeret/2-targyMeret/2;
			m.getTargy().FrissitNezet(this);
		}
		
		
		aktX = mezoinfo.getCenterX();
		aktY = mezoinfo.getCenterY();
		aktY = aktY - mezoMeret/2 + epuletMeret/2;
		m.getEpulet().FrissitNezet(this);
	}
	
	public void FrissitInstabilJegtabla (InstabilJegtabla m, boolean targyRajz) {
		
		MezoInfo mezoinfo = MezoRajzol("-fx-background-color: rgb(68,114,196)",m);
		
		ArrayList<Szereplo> szereplok = m.getSzereplok();
		ArrayList<Szereplo> alatta = m.getAlatta();
		aktX -=this.mezoMeret/2-this.szereploMeret/2;
		int sizes=szereplok.size();
		int sizea=alatta.size();
		for (int j = 0; j < sizes; j++)
		{ 
			szereplok.get(j).FrissitNezet(this);
			aktX += mezoMeret/(sizes+sizea);
		}
		
		vizben = true;
		for (int j = 0; j < sizea; j++)
		{ 
			alatta.get(j).FrissitNezet(this);
			aktX += mezoMeret/(sizes+sizea);
		}
		vizben = false;
	
		if (targyRajz)
		{ 
			// Keretet is kell rajzolni
			
			aktX = mezoinfo.getCenterX();
			aktY = mezoinfo.getCenterY();
			aktY += mezoMeret/2-targyMeret/2;
			m.getTargy().FrissitNezet(this);
		}
	}
	
	
	public void FrissitAso(Aso t) {
		TargyInfo tInfo= TargyRajzol("file:texturak/Aso.png",t);
		tInfo.setTooltip(new Tooltip("2 egység hó eltakarítása\naz aktuális mezőről"));
	}
	
	public void FrissitLapat(Lapat t) {
		TargyInfo tInfo= TargyRajzol("file:texturak/lapat.png",t);
		tInfo.setTooltip(new Tooltip("2 egység hó eltakarítása\naz aktuális mezőről"));
	}
	
	public void FrissitElelem(Elelem t) {
		TargyInfo tInfo= TargyRajzol("file:texturak/kaja.png",t);
		tInfo.setTooltip(new Tooltip("Élelem elfogyasztása"));
	}
	
	public void FrissitSator(Sator t) {
		TargyInfo tInfo= TargyRajzol("file:texturak/Sator.png",t);
		tInfo.setTooltip(new Tooltip("Sátor lehelyezése\naz aktuális mezőre"));
	}
	
	public void FrissitBuvarRuha(Buvarruha t) {
		// TODO: Kirajzoltatja magat
		if(hordja) {
			ruhaKep.setImage(new Image("file:texturak/Buvarruha.png",targyMeret,targyMeret,false,false));			
		}
		else {			
			TargyInfo tInfo= TargyRajzol("file:texturak/Buvarruha.png",t);
			tInfo.setTooltip(new Tooltip("Buvárruha felvétele"));
		}
		
	}	
	
	public void FrissitAlapRuha(AlapRuha t) {
		// TODO: Kirajzoltatja magat
		ruhaKep.setImage(null);
	}
	
	public void FrissitAlkatresz(Alkatresz t) {
		TargyInfo tInfo= TargyRajzol("file:texturak/Alkatresz.png",t);
		alkatreszBar.getChildren().clear();
		for(int i = 0; i< Palya.getAlkatreszek() ;i++) {
			alkatreszBar.getChildren().add(new ImageView(new Image("file:texturak/Alkatresz.png",targyMeret-10,targyMeret-10,false,false)));
		}
		tInfo.setTooltip(new Tooltip("Alkatrész bejelentése"));
	}
	
	public void FrissitKotel(Kotel t) {
		TargyInfo tInfo= TargyRajzol("file:texturak/Kotel.png",t);
		tInfo.setTooltip(new Tooltip("Játékos kimenekítése egy\nelőre kiválasztott mezőről"));
	}
	
	public void FrissitIglu(Iglu e) {
		ImageView igluKep = new ImageView(new Image("file:texturak/Iglu.png",epuletMeret,epuletMeret,false,false));
		igluKep.setTranslateX(aktX-epuletMeret/2);
		igluKep.setTranslateY(aktY-epuletMeret/2);
		valtozoJatekTer.add(igluKep);
		jatekTer.getChildren().add(igluKep);	
	}
	
	public void FrissitNoglu(Noglu e) {
	}	

	public void Mezolehelyez(ArrayList<Mezo> mezok) {
		// TODO: Joconak kene egy grafkirajzolast irnia	
		
		
		int oldal = (int)Math.sqrt(mezok.size());
		
		
		for(int i = 0, j = 0; i<mezok.size();i++) {
			MezoInfo mezoinfo = new MezoInfo(mezok.get(i),mezoTav+(mezoMeret+mezoTav)*(i%oldal),mezoTav+(i%oldal==0&&i!=0?j+=(mezoMeret+mezoTav):j),mezoMeret,mezoMeret);
			mezoinf.add(mezoinfo);
			mezoinfo.setOnAction(kattintasKezelo);
			
		}
		
		
		mezoinf.forEach(mi->{
			mezoinf.forEach(mj->{
				if(mi.getMezo().isSzomszed(mj.getMezo())){
					Line vonal = new Line(mi.getCenterX(),mi.getCenterY(),mj.getCenterX(),mj.getCenterY());
					vonal.setStrokeWidth(3);
				    vonal.setStroke(Color.CORNFLOWERBLUE);
					jatekTer.getChildren().add(vonal);
				}
				
			});
			
		});
		
		jatekTer.getChildren().addAll(mezoinf);
		jatekTer.setPrefHeight(mezoTav+(mezok.size() / oldal)*(mezoMeret+mezoTav));
		jatekTer.setPrefWidth(mezoTav+(mezok.size() / oldal)*(mezoMeret+mezoTav));
		
	}
	
	public void Torol() {
		jatekTer.getChildren().removeAll(valtozoJatekTer);
		valtozoJatekTer.clear();
	}	
	public class MyActionListener implements EventHandler<ActionEvent>{
	    	GrafNezet nezet;
	    	public  MyActionListener(GrafNezet n) {
	    		nezet = n;
	    	}
			@Override
			public void handle(ActionEvent event) {					
				mezoinf.forEach(m->{					
					if(event.getSource() == m) {
						kijeloltMezo = m.getMezo();						
						valasztottMezoAllapot.setText("Kiválasztott mező\nHóvastagság: "+kijeloltMezo.gethoVastagsag()
						+"\nTeherbírás: "+(kijeloltMezo.getfelderitett()?kijeloltMezo.getTeherBiras():"ismeretlen"));						
					}					
				});
				for(int i = 0; i<targyBar.getChildren().size(); i++) {
					
					TargyInfo t = (TargyInfo)targyBar.getChildren().get(i);
					if(event.getSource() == t) {
						Palya.getAktJatekos().Hasznal(t.getTargy(),kijeloltMezo);
						targyBar.getChildren().remove(i);							
						MyApplication.frissit();
					}
				}				
			}	
	}

}

