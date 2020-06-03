package plantenApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import plantenApp.java.dao.*;
import plantenApp.java.model.*;

import java.sql.Array;
import java.sql.Blob;
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
    public ComboBox cboTypeTv;
    public TextField txtFamilieTv;
    public TextField txtGeslachtTv;
    public TextField txtSoortTv;
    public TextField txtVariantTv;
    public TextField txtDichtheidXTv;
    public TextField txtDichtheidYTv;
    public ComboBox cbBezonningTv;
    public Label BezonningvalueTv;
    public ComboBox cbVoedingsbehoefteTv;
    public Label VoedingbehoefteValueTv;
    public ComboBox cbVochtbehoefteTv;
    public Label VochtbehoefteValueTv;
    public ComboBox cbReactieAntaTv;
    public ComboBox cbGrondsoortTv;
    public ComboBox cbHabitatTv;
    public Button btnHabitatTv;
    public ListView lvHabitatTv;
    public ComboBox cbOntwikkelingssnelheidTv;
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
    public ListView lvLevensduurTv;
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
    public ComboBox cbBladgrootteTotTv;
    public ComboBox cbBladvormTv;
    public ComboBox cbRatioTv;
    public ComboBox cbSpruitfenologieTv;
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
    public ComboBox cbBladkleurJanTv;
    public ComboBox cbBladkleurFebTv;
    public ComboBox cbBladkleurMaaTv;
    public ComboBox cbBladkleurAprTv;
    public ComboBox cbBladkleurMeiTv;
    public ComboBox cbBladkleurJunTv;
    public ComboBox cbBladkleurJulTv;
    public ComboBox cbBladkleurAugTv;
    public ComboBox cbBladkleurSeptTv;
    public ComboBox cbBladkleurOktTv;
    public ComboBox cbBladkleurNovTv;
    public ComboBox cbBladkleurDecTv;
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
    public ComboBox cbBloeikleurJanTv;
    public ComboBox cbBloeikleurFebTv;
    public ComboBox cbBloeikleurMaaTv;
    public ComboBox cbBloeikleurAprTv;
    public ComboBox cbBloeikleurMeiTv;
    public ComboBox cbBloeikleurJunTv;
    public ComboBox cbBloeikleurJulTv;
    public ComboBox cbBloeikleurAugTv;
    public ComboBox cbBloeikleurSeptTv;
    public ComboBox cbBloeikleurNovTv;
    public ComboBox cbBloeikleurOktTv;
    public ComboBox cbBloeikleurDecTv;
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
    private Connection dbConnection;
    private AbiotischeFactorenDAO abiotischeFactorenDAO;
    private int plantid;
    private InfoTables infoTables;


    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();

        /*infotabel object aanmaken*/
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        infoTables = infotablesDAO.getInfoTables();

        /*comboboxes vullen*/
        FillComboboxes(infoTables);
        createplant();
        createBeheer();
        createAbiotischeMulti();
        createfentotypemulti();
        createExtra();
        createAbiotischefactoren();
        createfenotype();
        createCommensalisme();
        createFoto();
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


    public void Clicked_PlantToevoegen(MouseEvent mouseEvent) throws SQLException {
        createplant();
        createAbiotischefactoren();
        createfenotype();
        createCommensalisme();
    }
    public void createfenotype() throws SQLException {
        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        int maxid = fenotypeDAO.getmaxid();
        Fenotype fenotype = new Fenotype(maxid+1,plantid,"bladvorm","levensvorm","habitus","bloeiwijze",2,"ratioBloeiBlad","spruitfenologie");
        fenotypeDAO.createfenotype(fenotype);
    }
    public void createplant() throws SQLException {
        PlantDAO plantDAO = new PlantDAO(dbConnection);
        int maxidplant = plantDAO.getmaxid();
        plantid = maxidplant;
            //public Plant(int id, String type, String familie, String geslacht, String soort, String variatie, int minPlantdichtheid, int maxPlantdichtheid, String fgsv) {
            Plant plant = new Plant(maxidplant+1 ,"test", "familie","geslacht","soort","variatie",5,20,"familie geslacht soort van", 1);
        plantDAO.createplant(plant);
    }
    public void createAbiotischefactoren() throws SQLException {
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        int maxidabio = abiotischeFactorenDAO.getmaxid();
        AbiotischeFactoren abiotischeFactoren = new AbiotischeFactoren(maxidabio+1,plantid, "tt","ee ", "nat","frietjes","hey kasper");
        abiotischeFactorenDAO.CreateAbiostische(abiotischeFactoren);
    }


    public void createCommensalisme() throws SQLException {
        CommensalismeDAO commensalismeDAO = new CommensalismeDAO(dbConnection);
        int maxidcommensalisme = commensalismeDAO.getmaxid();
        Commensalisme commensalisme = new Commensalisme(maxidcommensalisme+1, plantid, "strategie", "test");
        commensalismeDAO.createCommensalisme(commensalisme);
    }
    public void createExtra() throws SQLException{
        ExtraDAO extraDAO = new ExtraDAO(dbConnection);
        int maxidextra = extraDAO.getmaxid();
        Extra extra = new Extra(maxidextra+1,plantid,0,0,"a","b","c","d","e");
        //deze fout van createExtra komt uit extraDAO omdat het niet zeker is hoe eetbaar en kruidgebruik uit de databank gehaald moeten worden
        //ExtraDAO.createExtra(extra);
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
    public void createfentotypemulti() throws SQLException {
            FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
            int maxid = fenotypeDAO.getmaxidmulti();
            FenoMulti_Eigenschap fenoMulti_eigenschap = new FenoMulti_Eigenschap(maxid+1,"test","jan", "feb","maa","apr","mei","jun","jul","aug","sept","okt","nov","dec");
            fenotypeDAO.createfenomulti(fenoMulti_eigenschap , plantid);
    }

    public void createBeheer() throws SQLException{
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        int maxIdBeheer = beheerDAO.getmaxid();
        Beheerdaad_Eigenschap beheerdaad_eigenschap = new Beheerdaad_Eigenschap(maxIdBeheer+1, "Test", "Test", "Test", 5);
        Beheer beheer = new Beheer(maxIdBeheer+1);
        beheerDAO.createBeheer(beheerdaad_eigenschap,beheer);
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);

    }
    public void createAbiotischeMulti() throws SQLException{
        int maxidabio = abiotischeFactorenDAO.getMaxIdMulti();
        System.out.println(maxidabio);
        AbioMulti_Eigenschap abioMulti_eigenschap = new AbioMulti_Eigenschap(maxidabio+1, "Test", "Test");
        abiotischeFactorenDAO.CreateAbiotischeMulti(abioMulti_eigenschap, plantid);
    }
}

