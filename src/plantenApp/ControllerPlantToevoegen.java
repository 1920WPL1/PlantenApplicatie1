package plantenApp;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import plantenApp.java.dao.*;
import plantenApp.java.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerPlantToevoegen {
    public Slider slBezonning;
    public Slider slVoedingsbehoefte;
    public Slider slVochtbehoefte;
    public ComboBox cbReactieAnta;
    public ComboBox cbGrondsoort;
    public ComboBox cbHabitat;
    public Button btnHabitat;
    public ListView lvHabitat;
    public Label VoedingbehoefteValue;
    public Label VochtbehoefteValue;
    public Label Bezonningvalue;
    public ComboBox<String> cboTypeTv;
    public TextField txtFamilieTv;
    public TextField txtGeslachtTv;
    public TextField txtSoortTv;
    public TextField txtVariantTv;
    public TextField txtDichtheidXTv;
    public TextField txtDichtheidYTv;
    public ComboBox<String> cbBezonningTv;
    public Label BezonningvalueTv;
    public ComboBox<String> cbVoedingsbehoefteTv;
    public Label VoedingbehoefteValueTv;
    public ComboBox<String> cbVochtbehoefteTv;
    public Label VochtbehoefteValueTv;
    public ComboBox<String> cbReactieAntaTv;
    public ComboBox<String> cbGrondsoortTv;
    public ComboBox<String> cbHabitatTv;
    public Button btnHabitatTv;
    public ListView lvHabitatTv;
    public ComboBox<String> cbOntwikkelingssnelheidTv;
    public CheckBox chkSociabiliteit1Tv;
    public CheckBox chkSociabiliteit2Tv;
    public CheckBox chkSociabiliteit3Tv;
    public CheckBox chkSociabiliteit4Tv;
    public CheckBox chkSociabiliteit5Tv;
    public RadioButton rbStrategieUnknownTv;
    public RadioButton rbStrategieTopTv;
    public RadioButton rbStrategieLMTv;
    public RadioButton rbStrategieMMTv;
    public RadioButton rbStrategieRMTv;
    public RadioButton rbStrategieLOTv;
    public RadioButton rbStrategieMOTv;
    public RadioButton rbStrategieROTv;
    public ComboBox cbLevensduurTv;
    public Button btnLevensduurTv;
    public ListView<String> lvLevensduurTv;
    public Slider slNectarwaardeTv;
    public Label NectarwaardeValueTv;
    public Slider slPollenwaardeTv;
    public Label PollenValueTv;
    public RadioButton rbBijvriendelijkNullTv;
    public RadioButton rbBijvriendelijkJaTv;
    public RadioButton rbBijvriendelijkNeeTv;
    public RadioButton rbVlindervriendelijkNullTv;
    public RadioButton rbVlindervriendelijkJaTv;
    public RadioButton rbVlindervriendelijkNeeTv;
    public RadioButton rbEetbaarNullTv;
    public RadioButton rbEetbaarJaTv;
    public RadioButton rbEetbaarNeeTv;
    public RadioButton rbKruidgebruikNullTv;
    public RadioButton rbKruidgebruikJaTv;
    public RadioButton rbKruidgebruikNeeTv;
    public RadioButton rbGeurendNullTv;
    public RadioButton rbGeurendJaTv;
    public RadioButton rbGeurendNeeTv;
    public RadioButton rbVorstgevoeligNullTv;
    public RadioButton rbVorstgevoeligJaTv;
    public RadioButton rbVorstgevoeligNeeTv;
    public ComboBox<String> cbBladgrootteTotTv;
    public ComboBox<String> cbBladvormTv;
    public ComboBox<String> cbRatioTv;
    public ComboBox<String> cbSpruitfenologieTv;
    public RadioButton rbHydro1Tv;
    public RadioButton rbHydro2Tv;
    public RadioButton rbHeloTv;
    public RadioButton rbCrypto1Tv;
    public RadioButton rbCrypto2Tv;
    public RadioButton rbHemikryptoTv;
    public RadioButton rbChamae1Tv;
    public RadioButton rbChamae2Tv;
    public RadioButton rbFaneroTv;
    public Spinner spinMaxBladhJanTv;
    public Spinner spinMaxBladhFebTv;
    public Spinner spinMaxBladhMaaTv;
    public Spinner spinMaxBladhAprTv;
    public Spinner spinMaxBladhMeiTv;
    public Spinner spinMaxBladhJunTv;
    public Spinner spinMaxBladhJulTv;
    public Spinner spinMaxBladhAugTv;
    public Spinner spinMaxBladhSeptTv;
    public Spinner spinMaxBladhOktTv;
    public Spinner spinMaxBladhNovTv;
    public Spinner spinMaxBladhDecTv;
    public ComboBox<String> cbBladkleurJanTv;
    public ComboBox<String> cbBladkleurFebTv;
    public ComboBox<String> cbBladkleurMaaTv;
    public ComboBox<String> cbBladkleurAprTv;
    public ComboBox<String> cbBladkleurMeiTv;
    public ComboBox<String> cbBladkleurJunTv;
    public ComboBox<String> cbBladkleurJulTv;
    public ComboBox<String> cbBladkleurAugTv;
    public ComboBox<String> cbBladkleurSeptTv;
    public ComboBox<String> cbBladkleurOktTv;
    public ComboBox<String> cbBladkleurNovTv;
    public ComboBox<String> cbBladkleurDecTv;
    public Spinner spinMinBloeihJanTv;
    public Spinner spinMinBloeihFebTv;
    public Spinner spinMinBloeihMaaTv;
    public Spinner spinMinBloeihAprTv;
    public Spinner spinMinBloeihMeiTv;
    public Spinner spinMinBloeihJunTv;
    public Spinner spinMinBloeihJulTv;
    public Spinner spinMinBloeihAugTv;
    public Spinner spinMinBloeihSeptTv;
    public Spinner spinMinBloeihOktTv;
    public Spinner spinMinBloeihNovTv;
    public Spinner spinMinBloeihDecTv;
    public Spinner spinMaxBloeihJanTv;
    public Spinner spinMaxBloeihFebTv;
    public Spinner spinMaxBloeihMaaTv;
    public Spinner spinMaxBloeihAprTv;
    public Spinner spinMaxBloeihMeiTv;
    public Spinner spinMaxBloeihJunTv;
    public Spinner spinMaxBloeihJulTv;
    public Spinner spinMaxBloeihAugTv;
    public Spinner spinMaxBloeihSeptTv;
    public Spinner spinMaxBloeihOktTv;
    public Spinner spinMaxBloeihNovTv;
    public Spinner spinMaxBloeihDecTv;
    public ComboBox<String> cbBloeikleurJanTv;
    public ComboBox<String> cbBloeikleurFebTv;
    public ComboBox<String> cbBloeikleurMaaTv;
    public ComboBox<String> cbBloeikleurAprTv;
    public ComboBox<String> cbBloeikleurMeiTv;
    public ComboBox<String> cbBloeikleurJunTv;
    public ComboBox<String> cbBloeikleurJulTv;
    public ComboBox<String> cbBloeikleurAugTv;
    public ComboBox<String> cbBloeikleurSeptTv;
    public ComboBox<String> cbBloeikleurNovTv;
    public ComboBox<String> cbBloeikleurOktTv;
    public ComboBox<String> cbBloeikleurDecTv;
    public RadioButton rbTuftedTv;
    public RadioButton rbUprightarchingTv;
    public RadioButton rbArchingTv;
    public RadioButton rbUprightDivergentTv;
    public RadioButton rbUprightErectTv;
    public RadioButton rbMountedTv;
    public RadioButton rbKOfHGOfMTv;
    public RadioButton rbRondOfWaaiervormigTv;
    public RadioButton rbKussenvormendTv;
    public RadioButton rbZuilvormigTv;
    public RadioButton rbUitbuigendTv;
    public RadioButton rbWortelrozetplantTv;
    public RadioButton rbSucculentenTv;
    public RadioButton rbPollenvormersTv;
    public RadioButton rbParasolvormigTv;
    public RadioButton rbAarTv;
    public RadioButton rbBredePluimTv;
    public RadioButton rbEtageTv;
    public RadioButton rbBolOfKnopTv;
    public RadioButton rbMargrietachtigTv;
    public RadioButton rbSchotelTv;
    public RadioButton rbSchermTv;
    public RadioButton rbSmallePluimTv;
    public Button PLantToevoegenButtonTv;
    public Button TerugButtonTv;
    public VBox levensvormKeuzeTv;
    public ToggleGroup bloeiwijzegroepTv;
    public ToggleGroup habitusgroepTv;
    public ToggleGroup lvTv;
    private Connection dbConnection;
    private AbiotischeFactorenDAO abiotischeFactorenDAO;
    private int plantid;
    private InfoTables infoTables;
    private ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschaps = new ArrayList<>();
    public static ArrayList<Plant> plantss = new ArrayList<>();
    public static ArrayList<AbiotischeFactoren> abiotischeFactorenn = new ArrayList<>();
    public static ArrayList<AbioMulti_Eigenschap> abiotischmulti = new ArrayList<>();
    public static ArrayList<Commensalisme> commensalismes = new ArrayList<>();
    public static ArrayList<CommMulti_Eigenschap> commMulti_eigenschapss = new ArrayList<>();
    public static ArrayList<Extra> extrass = new ArrayList<>();
    public static ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschapss = new ArrayList<>();
    public static ArrayList<Fenotype> fenotypess = new ArrayList<>();
    public static ArrayList<Foto> fotoss = new ArrayList<>();
    public static ArrayList<Beheer> beheerss = new ArrayList<>();
    public static ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschapss = new ArrayList<>();
    public String scherm  ;

    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();

        Pollenwaarde();
        DefaultRadioButtons();
        //infotabel object aanmaken*/
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        infoTables = infotablesDAO.getInfoTables();
        /*comboboxes vullen*/
        FillComboboxes(infoTables);


    }
    public void createNaam() throws SQLException {
        NaamDao naamDAO = new NaamDao(dbConnection);
        Plant plant = new Plant(cboTypeTv.getValue(),txtFamilieTv.getText(),txtGeslachtTv.getText(),txtSoortTv.getText(),txtVariantTv.getText());
        naamDAO.createNaam(plant);
    }
    public void Pollenwaarde()    {
        slNectarwaardeTv.setMax(5);
        slPollenwaardeTv.setMax(5);
        //Change value
        PollenValueTv.textProperty().bind(
                Bindings.format(
                        "%.0f",
                        slPollenwaardeTv.valueProperty()
                )
        );
        NectarwaardeValueTv.textProperty().bind(
                Bindings.format(
                        "%.0f",
                        slNectarwaardeTv.valueProperty()
                )
        );
    }
    public void DefaultRadioButtons () {
        rbStrategieUnknownTv.setSelected(true);
        rbBijvriendelijkNullTv.setSelected(true);
        rbVlindervriendelijkNullTv.setSelected(true);
        rbEetbaarNullTv.setSelected(true);
        rbKruidgebruikNullTv.setSelected(true);
        rbGeurendNullTv.setSelected(true);
        rbVorstgevoeligNullTv.setSelected(true);
    }
    public void FillComboboxes(InfoTables infotables) {
        //type
        System.out.println(infotables.getTypes().toString());
        cboTypeTv.getItems().addAll(infotables.getTypes());

        //Bezonning
        cbBezonningTv.getItems().addAll(infotables.getBezonningsMogelijkheden());

        //Voedingsbehoefte
        cbVoedingsbehoefteTv.getItems().addAll(infotables.getVoedingsbehoeftes());

        //Vochtbehoefte
        cbVochtbehoefteTv.getItems().addAll(infotables.getVochtbehoeftes());

        //bladgrootte
        cbBladgrootteTotTv.getItems().addAll(infotables.getBladgroottes());
        //bladvorm
        cbBladvormTv.getItems().addAll(infotables.getBladvormen());
        //Grondsoort
        cbGrondsoortTv.getItems().addAll(infotables.getGrondsoorten());

        //BehandelingMaand
        //cboMaand.getItems().addAll("Januari", "februari", "maart", "april", "mei", "juni", "juli","augustus","september", "oktober", "november", "december");
        //ratio
        cbRatioTv.getItems().addAll(infotables.getBloeiBladRatios());
        //spruitfenologie
        cbSpruitfenologieTv.getItems().addAll(infotables.getSpruitfenologieen());
        //reactie antagonistische omgeving
        cbReactieAntaTv.getItems().addAll(infotables.getAntagonistischeOmgevingsReacties());
        //behandeling

        //Kleuren
        //Jan
        cbBladkleurJanTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurJanTv.getItems().addAll(infotables.getKleuren());
        //Feb
        cbBladkleurFebTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurFebTv.getItems().addAll(infotables.getKleuren());
        //Maart
        cbBladkleurMaaTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurMaaTv.getItems().addAll(infotables.getKleuren());
        //April
        cbBladkleurAprTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurAprTv.getItems().addAll(infotables.getKleuren());
        //Mei
        cbBladkleurMeiTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurMeiTv.getItems().addAll(infotables.getKleuren());
        //Juni
        cbBladkleurJunTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurJunTv.getItems().addAll(infotables.getKleuren());
        //Juli
        cbBladkleurJulTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurJulTv.getItems().addAll(infotables.getKleuren());
        //Augustus
        cbBladkleurAugTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurAugTv.getItems().addAll(infotables.getKleuren());
        //September
        cbBladkleurSeptTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurSeptTv.getItems().addAll(infotables.getKleuren());
        //Oktober
        cbBladkleurOktTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurOktTv.getItems().addAll(infotables.getKleuren());
        //November
        cbBladkleurNovTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurNovTv.getItems().addAll(infotables.getKleuren());
        //November
        cbBladkleurDecTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurDecTv.getItems().addAll(infotables.getKleuren());

        //Habitat
        cbHabitatTv.getItems().addAll(infotables.getHabitats());

        //Ontwikkelingssnelheid
        cbOntwikkelingssnelheidTv.getItems().addAll(infotables.getOnstwikkelingssnelheden());

        //Levensduur
        cbLevensduurTv.getItems().addAll(infotables.getConcurentiekrachten());
    }
    public void Clicked_PlantToevoegen(MouseEvent mouseEvent) throws SQLException, IOException {
        createplant();//ik //done
        createAbiotischefactoren();//afgewerkt //done
        createAbiotischeMulti();//Mathias //done
        createfenotype();//afgewerkt // done*/
        createfenotypemulti();//Wout // done
        createCommensalisme();//Kasper //done
        createCommensalismeMulti();//Mathias //done
        //createBeheer();//Wout dit moet nog verplaatst worden naar een button op beheer scherm //done
        createExtra();//Kasper
        //createFoto(); nog geen plaats of scherm voor een foto in toe te voegen
        openNieuwScherm(mouseEvent);
    }
    //indexArrays zegt van welke plaats in de arrays dat de functie een plant moet ophalen, nu is het hardcoded voor de eerste plaats in de arrayLists
    public void tonenPlantOpFiche(int indexArrays){
        Plant p = plantss.get(indexArrays);
        lblTypeO.setText(p.getType());
        lblFamilieO.setText(p.getFamilie());
        lblGeslachtO.setText(p.getGeslacht());
        lblSoortO.setText(p.getSoort());
        lblVariantO.setText(p.getVariatie());
        lblXO.setText(String.valueOf(p.getMinPlantdichtheid()));
        lblYO.setText(String.valueOf(p.getMaxPlantdichtheid()));

        Fenotype f = fenotypess.get(indexArrays);
        lblBladgrootteO.setText(String.valueOf(f.getBladgrootte()));
        lblBladvormO.setText(f.getBladvorm());
        lblRatioO.setText(f.getRatio_bloei_blad());
        lblSpruitfenologieO.setText(f.getSpruitfenologie());
        lblLevensvormO.setText(String.valueOf(f.getLevensvorm()));
        lblHabitusO.setText(f.getHabitus());
        lblBloeiwijzeO.setText(f.getBloeiwijze());
        int a = 5*indexArrays;//beginplaats in de arraylist
        int b = a + 5;//eindplaats in de arraylist
        //Bladhoogte Bladkleur Min Bloeihoogte Max Bloeihoogte Bloeikleur
        for(int i = a; i<b;i++){
            FenoMulti_Eigenschap fme = fenoMulti_eigenschapss.get(i);
            if(fme.getNaam().matches("Bladhoogte")){
                bladhoogteMaxJanO.setText(fme.getJan());
                bladhoogteMaxFebO.setText(fme.getFeb());
                bladhoogteMaxMaaO.setText(fme.getMaa());
                bladhoogteMaxAprO.setText(fme.getApr());
                bladhoogteMaxMeiO.setText(fme.getMei());
                bladhoogteMaxJunO.setText(fme.getJun());
                bladhoogteMaxJulO.setText(fme.getJul());
                bladhoogteMaxAugO.setText(fme.getAug());
                bladhoogteMaxSeptO.setText(fme.getSep());
                bladhoogteMaxOktO.setText(fme.getOkt());
                bladhoogteMaxNovO.setText(fme.getNov());
                bladhoogteMaxDecO.setText(fme.getDec());
            }
            if(fme.getNaam().matches("Bladkleur")){
                bladkleurJanO.setText(fme.getJan());
                bladkleurFebO.setText(fme.getFeb());
                bladkleurMaaO.setText(fme.getMaa());
                bladkleurAprO.setText(fme.getApr());
                bladkleurMeiO.setText(fme.getMei());
                bladkleurJunO.setText(fme.getJun());
                bladkleurJulO.setText(fme.getJul());
                bladkleurAugO.setText(fme.getAug());
                bladkleurSeptO.setText(fme.getSep());
                bladkleurOktO.setText(fme.getOkt());
                bladkleurNovO.setText(fme.getNov());
                bladkleurDecO.setText(fme.getDec());
            }
            if(fme.getNaam().matches("Bloeikleur")){
                bloeikleurJanO.setText(fme.getJan());
                bloeikleurFebO.setText(fme.getFeb());
                bloeikleurMaartO.setText(fme.getMaa());
                bloeikleurAprilO.setText(fme.getApr());
                bloeikleurMeiO.setText(fme.getMei());
                bloeikleurJunO.setText(fme.getJun());
                bloeikleurJuliO.setText(fme.getJul());
                bloeikleurAugO.setText(fme.getAug());
                bloeikleurSeptO.setText(fme.getSep());
                bloeikleurOktO.setText(fme.getOkt());
                bloeikleurNovO.setText(fme.getNov());
                bloeikleurDecO.setText(fme.getDec());
            }
            if(fme.getNaam().matches("Min Bloeihoogte")){
                bloeihoogteMinJanO.setText(fme.getJan());
                bloeihoogteMinFebO.setText(fme.getFeb());
                bloeihoogteMinMaartO.setText(fme.getMaa());
                bloeihoogteMinAprilO.setText(fme.getApr());
                bloeihoogteMinMeiO.setText(fme.getMei());
                bloeihoogteMinJunO.setText(fme.getJun());
                bloeihoogteMinJulO.setText(fme.getJul());
                bloeihoogteMinAugO.setText(fme.getAug());
                bloeihoogteMinSeptO.setText(fme.getSep());
                bloeihoogteMinOktO.setText(fme.getOkt());
                bloeihoogteMinNovO.setText(fme.getNov());
                bloeihoogteMinDecO.setText(fme.getDec());
            }
            if(fme.getNaam().matches("Max Bloeihoogte")){
                bloeihoogteMaxJanO.setText(fme.getJan());
                bloeihoogteMaxFebO.setText(fme.getFeb());
                bloeihoogteMaxMaartO.setText(fme.getMaa());
                bloeihoogteMaxAprO.setText(fme.getApr());
                bloeihoogteMaxMeiO.setText(fme.getMei());
                bloeihoogteMaxJunO.setText(fme.getJun());
                bloeihoogteMaxJulO.setText(fme.getJul());
                bloeihoogteMaxAugO.setText(fme.getAug());
                bloeihoogteMaxSeptO.setText(fme.getSep());
                bloeihoogteMaxOktO.setText(fme.getOkt());
                bloeihoogteMaxNovO.setText(fme.getNov());
                bloeihoogteMaxDecO.setText(fme.getDec());
            }
        }


        Extra e = extrass.get(indexArrays);
        lblNectarwaardeO.setText(String.valueOf(e.getNectarwaarde()));
        lblPollenwaardeO.setText(String.valueOf(e.getPollenwaarde()));
        lblBijvriendelijkO.setText(e.getBijvriendelijk());
        lblVlindervriendelijkO.setText("Nergens in de databank of in de klasse Extra zitten er waarden voor vlindervriendelijk dus geeft ik dit label een belachelijk lange zin mee.");
        lblEetbaarO.setText(e.getEetbaar());
        lblKruidgebruikO.setText(e.getKruidgebruik());
        lblGeurendO.setText(e.getGeurend());
        lblVorstgevoeligO.setText(e.getVorstgevoelig());

        AbiotischeFactoren af = abiotischeFactorenn.get(indexArrays);
        lblBezonningO.setText(af.getBezonning());
        lblVochtbehoefteO.setText(af.getVochtbehoefte());
        lblVoedingsbehoefteO.setText(af.getVoedingsbehoefte());
        lblReactieO.setText(af.getReactieAntagonistischeOmgeving());
        lblGrondsoortO.setText(af.getGrondsoort());
        int teller = 0;
        for(int i = 0; i<indexArrays;i++){
            teller +=AantalPerElAbMulti.get(i);
        }
        int eindplaats = teller + AantalPerElAbMulti.get(indexArrays);
        for(int j = teller; j<eindplaats;j++){
            lvHabitatO.getItems().add(abiotischmulti.get(j).getValue());
        }

        Commensalisme c = commensalismes.get(indexArrays);
        lblOntwikkelingssnelheidO.setText(c.getOntwikkelingssnelheid());
        lblStrategieO.setText(c.getStrategie());
        int tellerc = 0;
        for(int i = 0; i<indexArrays;i++){
            tellerc +=AantalPerElCommMulti.get(i);
        }
        int eindplaatsc = tellerc + AantalPerElCommMulti.get(indexArrays);
        for(int j = tellerc; j<eindplaatsc;j++){
            //lvLevensduurO
            if(commMulti_eigenschapss.get(j).getNaam().matches("sociabiliteit")){
                if(commMulti_eigenschapss.get(j).getValue().matches("1")){rbSociabiliteit1O.setSelected(true);}
                if(commMulti_eigenschapss.get(j).getValue().matches("2")){rbSociabiliteit2O.setSelected(true);}
                if(commMulti_eigenschapss.get(j).getValue().matches("3")){rbSociabiliteit3O.setSelected(true);}
                if(commMulti_eigenschapss.get(j).getValue().matches("4")){rbSociabiliteit4O.setSelected(true);}
                if(commMulti_eigenschapss.get(j).getValue().matches("5")){rbSociabiliteit5O.setSelected(true);}
            }
            if(commMulti_eigenschapss.get(j).getNaam().matches("levensduur")){
                lvLevensduurO.getItems().add(commMulti_eigenschapss.get(j).getValue());
            }
            lvHabitatO.getItems().add(commMulti_eigenschapss.get(j));
        }

        //dit wordt waarschijnlijk gebruikt voor die details bovenaan het scherm van gedetailleerdefiche
        Foto fo = fotoss.get(indexArrays);

        //
        int tellerb = 0;
        for(int i = 0; i<indexArrays;i++){
            tellerb +=AantalPerElBehMulti.get(i);
        }
        int eindplaatsb = tellerb + AantalPerElBehMulti.get(indexArrays);
        for(int j = tellerb; j<eindplaatsb;j++){
            Beheerdaad_Eigenschap beheerdaad_e = beheerdaad_eigenschapss.get(j);
            switch((String)cbMaandBeheerO.getValue()){
                case "januari":
                    if(beheerdaad_e.getMaand().matches("januari")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "februari":
                    if(beheerdaad_e.getMaand().matches("febuari")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "maart":
                    if(beheerdaad_e.getMaand().matches("maart")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "april":
                    if(beheerdaad_e.getMaand().matches("april")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "mei":
                    if(beheerdaad_e.getMaand().matches("mei")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "juni":
                    if(beheerdaad_e.getMaand().matches("juni")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "juli":
                    if(beheerdaad_e.getMaand().matches("juli")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "augustus":
                    if(beheerdaad_e.getMaand().matches("augustus")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "september":
                    if(beheerdaad_e.getMaand().matches("september")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "oktober":
                    if(beheerdaad_e.getMaand().matches("oktober")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "november":
                    if(beheerdaad_e.getMaand().matches("november")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "december":
                    if(beheerdaad_e.getMaand().matches("december")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
            }
            //lvHabitatO.getItems().add(abiotischmulti.get(j).getValue());
        }
    }
    


    public void openNieuwScherm(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/BeheeBehandelingPlant.fxml"));
        Scene scen = new Scene(root);
        Stage window =(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scen);
        window.show();
        scherm="beheer";
        window.setMaximized(true);
    }

    public void createfenotype() throws SQLException {
        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        int maxid = fenotypeDAO.getmaxid();
        System.out.println(plantid);
        Fenotype fenotype = new Fenotype(maxid + 1, plantid, comboboxCheckString(cbBladvormTv.getSelectionModel()), levensvormCheck(), habitusCheck(), bloeiwijzeCheck(), comboboxCheckInteger(cbBladgrootteTotTv.getSelectionModel()), comboboxCheckString(cbRatioTv.getSelectionModel()), comboboxCheckString(cbSpruitfenologieTv.getSelectionModel()));
        fenotypess.add(fenotype);
    }

    public String comboboxCheckString(SingleSelectionModel <String> combobox) {
        if(combobox.isEmpty()) {
            return "leeg";
        }
        else {
            return combobox.getSelectedItem().toString();
        }
    }

    public Integer comboboxCheckInteger(SingleSelectionModel<String> combobox) {
        if(combobox.isEmpty()) {
            return 0;
        }
        else {
            return Integer.parseInt(combobox.getSelectedItem());
        }
    }

    public String habitusCheck(){
        if(rbTuftedTv.isSelected()){ return "tufted";}
        if(rbUprightarchingTv.isSelected()){ return "Upright arching";}
        if(rbArchingTv.isSelected()){ return "Arching";}
        if(rbUprightDivergentTv.isSelected()){ return "Upright Divergent";}
        if(rbUprightErectTv.isSelected()){ return "Upright erect";}
        if(rbMountedTv.isSelected()){ return "Mounted";}
        if(rbKOfHGOfMTv.isSelected()){ return "Kruipend of horizontaal groeiend of mattenvormend";}
        if(rbRondOfWaaiervormigTv.isSelected()){ return "Rond- of waaiervormig";}
        if(rbKussenvormendTv.isSelected()){ return "Kussenvormend";}
        if(rbZuilvormigTv.isSelected()){ return "Zuilvormig";}
        if(rbUitbuigendTv.isSelected()){ return "Uitbuigend";}
        if(rbWortelrozetplantTv.isSelected()){ return "(Wortel)rozetplant";}
        if(rbSucculentenTv.isSelected()){ return "Succulenten";}
        if(rbPollenvormersTv.isSelected()){ return "Pollenvormers";}
        if(rbParasolvormigTv.isSelected()){ return "Parasolvormig";}
        return null;
    }
    public int levensvormCheck(){
        if(rbHydro1Tv.isSelected()){return 1;}
        if(rbHydro2Tv.isSelected()){return 2;}
        if(rbHeloTv.isSelected()){return 3;}
        if(rbCrypto1Tv.isSelected()){return 4;}
        if(rbCrypto2Tv.isSelected()){return 5;}
        if(rbHemikryptoTv.isSelected()){return 6;}
        if(rbChamae1Tv.isSelected()){return 7;}
        if(rbChamae2Tv.isSelected()){return 8;}
        if(rbFaneroTv.isSelected()){return 9;}
        return 0;
    }
    public String bloeiwijzeCheck(){
        if(rbAarTv.isSelected()){return "Aar";}
        if(rbBredePluimTv.isSelected()){return "Brede pluim";}
        if(rbEtageTv.isSelected()){return "Etage";}
        if(rbBolOfKnopTv.isSelected()){return "Bol of knop";}
        if(rbMargrietachtigTv.isSelected()){return "Margrietachtig";}
        if(rbSchotelTv.isSelected()){return "Schotel";}
        if(rbSchermTv.isSelected()){return "Scherm";}
        if(rbSmallePluimTv.isSelected()){return "Smalle pluim";}
        return null;
    }
    public void createplant() throws SQLException {
        //volledig toevoegen in databank vanuit scherm, waarschijnlijk nog iets toevoegen voor te kijken of de naam al in de databank zit
        PlantDAO plantDAO = new PlantDAO(dbConnection);
        int maxidplant = plantDAO.getmaxid();
        plantid = maxidplant+1;
        String familie = txtFamilieTv.getText();
        String geslacht = txtGeslachtTv.getText();
        String soort = txtSoortTv.getText();
        String variant = txtVariantTv.getText();
        String fgsv = familie + " " +geslacht+ " " + soort+" " + variant;
        String type = cboTypeTv.getValue();
        int x = 0;
        int y = 0;
        if(txtDichtheidXTv.getText().matches("[0-9]+")){
            x = Integer.parseInt(txtDichtheidXTv.getText());
        }
        if(txtDichtheidYTv.getText().matches("[0-9]+")){
            y = Integer.parseInt(txtDichtheidYTv.getText());
        }
        Plant plant = new Plant(plantid, type, familie, geslacht, soort, variant, x, y, fgsv, 1);
        System.out.println(type + " " +plant.getId() + " " + cboTypeTv.getValue() +" " + plant.getFamilie()+ " " + plant.getGeslacht()+ " " + plant.getSoort()+ " " + plant.getVariatie()+" " + plant.getMaxPlantdichtheid() + plant.getMinPlantdichtheid() );
        plantss.add(plant);
    }
    public void createAbiotischefactoren() throws SQLException {
        //alles van scherm direct naar databank aangezien hier de input enkel kan gekozen worden uit gegeven lijsten
        //deze functie is afgewerkt
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        int maxidabio = abiotischeFactorenDAO.getmaxid();
        AbiotischeFactoren abiotischeFactoren = new AbiotischeFactoren(maxidabio + 1, plantid, cbBezonningTv.getValue(), cbGrondsoortTv.getValue(), cbVochtbehoefteTv.getValue(), cbVoedingsbehoefteTv.getValue(), cbReactieAntaTv.getValue());
        abiotischeFactorenn.add(abiotischeFactoren);
    }
    public void createCommensalisme() throws SQLException {
        CommensalismeDAO commensalismeDAO = new CommensalismeDAO(dbConnection);
        int maxidcommensalisme = commensalismeDAO.getmaxid();
        Commensalisme commensalisme = new Commensalisme(maxidcommensalisme + 1, plantid, "strat", comboboxCheckString(cbOntwikkelingssnelheidTv.getSelectionModel()));
        commensalismes.add(commensalisme);
    }
    public void createExtra() throws SQLException {
        //kan pas volledig gedaan worden wanneer er de kwestie van de eetbaar/kruidgebruik splitsing opgelost is
        int valueNectarwaarde = Integer.parseInt(NectarwaardeValueTv.getText());
        int valuePollenwaarde = Integer.parseInt(PollenValueTv.getText());
        ExtraDAO extraDAO = new ExtraDAO(dbConnection);
        int maxidextra = extraDAO.getmaxid();
        maxidextra ++;
        System.out.println(maxidextra);
        System.out.println(valuePollenwaarde + " " + valueNectarwaarde);
        Extra extra = new Extra(maxidextra, plantid, valueNectarwaarde, valuePollenwaarde, "a", "b", "c", "d", "e");
        //deze fout van createExtra komt uit extraDAO omdat het niet zeker is hoe eetbaar en kruidgebruik uit de databank gehaald moeten worden
        extrass.add(extra);
        //ExtraDAO.createExtra(extra);
    }
    public void ToevoegenCommensalismeMulti(MouseEvent mouseEvent) {
        if (!lvLevensduurTv.getItems().contains(cbLevensduurTv.getValue())) {
            lvLevensduurTv.getItems().add((String) cbLevensduurTv.getValue());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Je kan niet 2 keer hetzelfde item toevoegen");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
    }
    public void createCommensalismeMulti() throws SQLException {
        //aantal elementen in bovenstaande lijst bijhouden
        int aantalCommMulti = 0;

        //Toevoegen van levensduur
        CommensalismeDAO commensalismeMulti = new CommensalismeDAO(dbConnection);

        System.out.println(" " + plantid);

        for (int i = 0; i < lvLevensduurTv.getItems().size(); i++) {
            CommMulti_Eigenschap commensalisme = new CommMulti_Eigenschap("levensduur", lvLevensduurTv.getItems().get(i),plantid);
            commMulti_eigenschapss.add(commensalisme);
            aantalCommMulti++;
        }


        //Toevoegen van sociabiliteit
        if (chkSociabiliteit1Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "1",plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        if (chkSociabiliteit2Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "2",plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        if (chkSociabiliteit3Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "3",plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        if (chkSociabiliteit4Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "4",plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        if (chkSociabiliteit5Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "5",plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        AantalPerElCommMulti.add(aantalCommMulti);
    }
    public void TestZooi(MouseEvent mouseEvent) throws SQLException {
        createCommensalismeMulti();
    }
    public void createFoto() throws SQLException{
        FotoDAO fotoDAO = new FotoDAO(dbConnection);
        int maxIdFoto = fotoDAO.getmaxid();

        ArrayList<Foto_Eigenschap> verz = new ArrayList<>();
        //hier maak je alle foto-eigenschappen aan die je in foto1 wil steken en zorg ervoor dat ze telkens een andere id krijgen dus achter die id moet iedere keer +1, +2,...
        //komen te staan telkens als er een nieuwe Foto_eigenschap aangemaakt wordt
        Foto_Eigenschap foto_eigenschap = new Foto_Eigenschap(maxIdFoto+1,"a","b", null);

        //hier steek je dan elke Foto_eigenschap die hierboven gemaakt is in deze verzameling zoals in onderstaande lijn staat
        verz.add(foto_eigenschap);

        //hier wordt een volledig foto-object gemaakt
        Foto foto1 = new Foto(plantid,verz);

        //deze onderstaande lijn wordt niet gebruikt
        //Foto foto2 = new Foto(maxIdFoto + 1, plantid, "a", "b", null);
        fotoDAO.createFoto(foto1);
    }

    public void createfenotypemulti() throws SQLException {
        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        int maxid = fenotypeDAO.getmaxidmulti();
        maxid++;
        System.out.println(maxid);
        String naam ="bladhoogte";
        System.out.println();
        ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschaps = new ArrayList<>();
        FenoMulti_Eigenschap bladhoogte = new FenoMulti_Eigenschap(maxid,"Bladhoogte", spinMaxBladhJanTv.getValue().toString(),spinMaxBladhFebTv.getValue().toString(),spinMaxBladhMaaTv.getValue().toString(),spinMaxBladhAprTv.getValue().toString(),spinMaxBladhMeiTv.getValue().toString(),spinMaxBladhJunTv.getValue().toString(),spinMaxBladhJulTv.getValue().toString(),spinMaxBladhAugTv.getValue().toString(),spinMaxBladhSeptTv.getValue().toString(),spinMaxBladhOktTv.getValue().toString(),spinMaxBladhNovTv.getValue().toString(),spinMaxBladhDecTv.getValue().toString());
        maxid++;
        FenoMulti_Eigenschap bladkleur = new FenoMulti_Eigenschap(maxid,"Bladkleur",comboboxCheckString(cbBladkleurJanTv.getSelectionModel()),comboboxCheckString(cbBladkleurFebTv.getSelectionModel()),comboboxCheckString(cbBladkleurMaaTv.getSelectionModel()),comboboxCheckString(cbBladkleurAprTv.getSelectionModel()), comboboxCheckString(cbBladkleurMeiTv.getSelectionModel()), comboboxCheckString(cbBladkleurJunTv.getSelectionModel()),comboboxCheckString(cbBladkleurJulTv.getSelectionModel()),comboboxCheckString(cbBladkleurAugTv.getSelectionModel()),comboboxCheckString(cbBladkleurSeptTv.getSelectionModel()),comboboxCheckString(cbBladkleurOktTv.getSelectionModel()),comboboxCheckString(cbBladkleurNovTv.getSelectionModel()),comboboxCheckString(cbBladkleurDecTv.getSelectionModel()));
        maxid++;
        FenoMulti_Eigenschap minbloeihoogte = new FenoMulti_Eigenschap(maxid,"Min Bloeihoogte",spinMinBloeihJanTv.getValue().toString() , spinMinBloeihFebTv.getValue().toString(),spinMinBloeihMaaTv.getValue().toString(),spinMinBloeihAprTv.getValue().toString(),spinMinBloeihMeiTv.getValue().toString(),spinMinBloeihJunTv.getValue().toString(),spinMinBloeihJulTv.getValue().toString(),spinMinBloeihAugTv.getValue().toString(),spinMaxBloeihSeptTv.getValue().toString(),spinMinBloeihOktTv.getValue().toString(),spinMinBloeihNovTv.getValue().toString(),spinMinBloeihDecTv.getValue().toString());
        maxid++;
        FenoMulti_Eigenschap maxbloeihoogte = new FenoMulti_Eigenschap(maxid,"Max Bloeihoogte",spinMaxBloeihJanTv.getValue().toString(),spinMaxBloeihFebTv.getValue().toString(),spinMaxBladhMaaTv.getValue().toString(),spinMaxBloeihAprTv.getValue().toString(),spinMaxBloeihMeiTv.getValue().toString(),spinMaxBloeihJunTv.getValue().toString(),spinMaxBloeihJulTv.getValue().toString(),spinMaxBloeihAugTv.getValue().toString(),spinMaxBloeihSeptTv.getValue().toString(),spinMaxBloeihOktTv.getValue().toString(),spinMaxBloeihNovTv.getValue().toString(),spinMaxBloeihDecTv.getValue().toString());
        maxid++;
        FenoMulti_Eigenschap bloeikleur = new FenoMulti_Eigenschap(maxid,"Bloeikleur" ,comboboxCheckString(cbBloeikleurJanTv.getSelectionModel()),comboboxCheckString(cbBloeikleurFebTv.getSelectionModel()),comboboxCheckString(cbBloeikleurMaaTv.getSelectionModel()),comboboxCheckString(cbBloeikleurAprTv.getSelectionModel()),comboboxCheckString(cbBloeikleurMeiTv.getSelectionModel()),comboboxCheckString(cbBloeikleurJunTv.getSelectionModel()),comboboxCheckString(cbBloeikleurJulTv.getSelectionModel()),comboboxCheckString(cbBloeikleurAugTv.getSelectionModel()),comboboxCheckString(cbBloeikleurSeptTv.getSelectionModel()),comboboxCheckString(cbBloeikleurOktTv.getSelectionModel()),comboboxCheckString(cbBloeikleurNovTv.getSelectionModel()),comboboxCheckString(cbBloeikleurDecTv.getSelectionModel()));
        fenoMulti_eigenschaps.add(bladhoogte);
        fenoMulti_eigenschaps.add(bladkleur);
        fenoMulti_eigenschaps.add(minbloeihoogte);
        fenoMulti_eigenschaps.add(maxbloeihoogte);
        fenoMulti_eigenschaps.add(bloeikleur);
        for (int i =0 ; i < 5;i++)
        {
            FenoMulti_Eigenschap fenoMulti_eigenschap = new FenoMulti_Eigenschap(fenoMulti_eigenschaps.get(i).getId(),fenoMulti_eigenschaps.get(i).getNaam(),fenoMulti_eigenschaps.get(i).getJan(), fenoMulti_eigenschaps.get(i).getFeb(),fenoMulti_eigenschaps.get(i).getMaa(),fenoMulti_eigenschaps.get(i).getApr(),fenoMulti_eigenschaps.get(i).getMei(),fenoMulti_eigenschaps.get(i).getJun(),fenoMulti_eigenschaps.get(i).getJul(),fenoMulti_eigenschaps.get(i).getAug(),fenoMulti_eigenschaps.get(i).getSep(),fenoMulti_eigenschaps.get(i).getOkt(),fenoMulti_eigenschaps.get(i).getNov(),fenoMulti_eigenschaps.get(i).getDec());
            fenoMulti_eigenschapss.add(fenoMulti_eigenschap);
        }



    }
    private void createAbiotischeMulti() throws SQLException {
        //aantal el toegevoegd in abmulti lijst bijhouden
        int aantalAbMultiEl = 0;
        AbiotischeFactorenDAO abiotischeMultidao = new AbiotischeFactorenDAO(dbConnection);
        int maxidcommensalismeMulti = abiotischeMultidao.getMaxIdMulti();
        System.out.println(" " + plantid);

        for (int i = 0; i < lvHabitatTv.getItems().size(); i++) {
            AbioMulti_Eigenschap abiotisch = new AbioMulti_Eigenschap("Habitat", (String) lvHabitatTv.getItems().get(i));
            maxidcommensalismeMulti++;
            abiotischmulti.add(abiotisch);
            aantalAbMultiEl++;
        }
        AantalPerElAbMulti.add(aantalAbMultiEl);
    }
    public void ToevoegenAbiotischeMulti(MouseEvent mouseEvent) {
        System.out.println(cbHabitatTv.getValue());
        if (!lvHabitatTv.getItems().contains(cbHabitatTv.getValue())) {
            lvHabitatTv.getItems().add((String) cbHabitatTv.getValue());
            System.out.println(cbHabitatTv.getValue());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Je kan niet 2 keer hetzelfde item toevoegen");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
    }
    // de arraylist zijn de waarden van de multies die bij de specifieke plant horen;
    public void createdatabase(Plant plant , AbiotischeFactoren abiotischeFactoren , Fenotype fenotype , ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschaps , ArrayList<AbioMulti_Eigenschap> abiottisschemulti_eigenschaps,Commensalisme commensalisme, ArrayList<CommMulti_Eigenschap> commMulti_eigenschaps,ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschaps, Extra extra) throws SQLException {
        PlantDAO plantDAO = new PlantDAO(dbConnection);
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        AbiotischeFactorenDAO abiotischeMultidao = new AbiotischeFactorenDAO(dbConnection);
        CommensalismeDAO commensalismeDAO = new CommensalismeDAO(dbConnection);
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        ExtraDAO extraDAO = new ExtraDAO(dbConnection);

        plantDAO.createplant(plant);
        abiotischeFactorenDAO.CreateAbiostische(abiotischeFactoren);
        plantDAO.createplant(plant);
        fenotypeDAO.createfenotype(fenotype);
        for (int j =0; j < fenoMulti_eigenschaps.size();j++) {
            fenotypeDAO.createfenomulti(fenoMulti_eigenschaps.get(j),plant.getId());
        }
        for (int f = 0; f < abiottisschemulti_eigenschaps.size(); f++)  {
            abiotischeMultidao.CreateAbiotischeMulti(abiottisschemulti_eigenschaps.get(f), plantid);
        }
        commensalismeDAO.createCommensalisme(commensalisme);
        for(int m =0; m < commMulti_eigenschaps.size(); m++) {
            commensalismeDAO.createCommensalismeMulti(commMulti_eigenschaps.get(m));
        }
        for (int a = 0 ; a< beheerdaad_eigenschaps.size();a++) {
            beheerDAO.createBeheer(beheerdaad_eigenschaps.get(a),plant.getId());
        }
        extraDAO.createExtra(extra);

    }
}

