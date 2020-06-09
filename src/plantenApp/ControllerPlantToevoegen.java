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
    public ListView <String> lvHabitat;
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
    public static int plantid;
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
    public static ArrayList<Integer>AantalPerElCommMulti = new ArrayList<>();
    public static ArrayList<Integer> AantalPerElAbMulti = new ArrayList<>();
    public static ArrayList<Integer> AantalPerElBehMulti = new ArrayList<>();
    public String scherm  ;
    public  int iGebruikerID;
    //Moet meegekregen worden van login
    private String sEmailadres;
    /**
     * @author: Arne Vandenborre
     *Wout is helemaal NIET veranderd
     * Kasper eeft MEERDERE vriendinnen dit kan dus helemaal NIET
     * Kevin doet zich voor als een 90's kid klopt NIET
     * Mathias valt NIET  op
     * mvg
     * Arne xx    <3 *
     * */
    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();

        Pollenwaarde();
        DefaultRadioButtons();
        //infotabel object aanmaken*/
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        infoTables = infotablesDAO.getInfoTables();
        /*comboboxes vullen*/
        FillComboboxes(infoTables);

        //Opvullen van emailadres om mee te geven met toevoegen plant
        sEmailadres = "kurt.engelbrecht@vives.be";
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
        System.out.println(infotables.getPlantTypes().toString());
        cboTypeTv.getItems().addAll(infotables.getPlantTypes());

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
        createNaam();
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
    public String levensvormCheck(){
        if(rbHydro1Tv.isSelected()){return "1. Hydrofyt";}
        if(rbHydro2Tv.isSelected()){return "2. Hydrofyt";}
        if(rbHeloTv.isSelected()){return "3. Helofyt";}
        if(rbCrypto1Tv.isSelected()){return "4. Cryptophyt";}
        if(rbCrypto2Tv.isSelected()){return "5. Cryptophyt";}
        if(rbHemikryptoTv.isSelected()){return "6. Hemikryptofyt";}
        if(rbChamae1Tv.isSelected()){return "7. Chamaefyt";}
        if(rbChamae2Tv.isSelected()){return "8. Chamaefyt";}
        if(rbFaneroTv.isSelected()){return "9. Fanerophyt";}
        return "geen";
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
        //Aanmaken variabelen
        //volledig toevoegen in databank vanuit scherm, waarschijnlijk nog iets toevoegen voor te kijken of de naam al in de databank zit
        GebruikerDAO gebruikerDAO = new GebruikerDAO(dbConnection);
        PlantDAO plantDAO = new PlantDAO(dbConnection);
        NaamDao naamDAO = new NaamDao(dbConnection);
        Plant plantTest = new Plant(cboTypeTv.getValue(),txtFamilieTv.getText(),txtGeslachtTv.getText(),txtSoortTv.getText(),txtVariantTv.getText());
        int maxidplant = plantDAO.getmaxid();
         iGebruikerID = gebruikerDAO.getIdMetEmail(sEmailadres);
        System.out.println(iGebruikerID);
        String srolGebruiker = gebruikerDAO.getRolMetEmail(sEmailadres);
        this.plantid = maxidplant;
        plantid = maxidplant+1;
        String sFamilie = txtFamilieTv.getText();
        String sGeslacht = txtGeslachtTv.getText();
        String sSoort = txtSoortTv.getText();
        String sVariant = txtVariantTv.getText();
        String sFgsv = sFamilie + " " + sGeslacht+ " " + sSoort+" " + sVariant;
        String sPlanttype = cboTypeTv.getValue();
        int iStatus = 0;
        int x = 0;
        int y = 0;
        if(txtDichtheidXTv.getText().matches("[0-9]+")){
            x = Integer.parseInt(txtDichtheidXTv.getText());
        }
        if(txtDichtheidYTv.getText().matches("[0-9]+")){
            y = Integer.parseInt(txtDichtheidYTv.getText());
        }

        //Controle of plantnaam al bestaat
        int iDubbeleNaam = naamDAO.ControleDubbeleNaam(plantTest);
        //als plant nog niet bestaat, plant toevoegen
        if (iDubbeleNaam == 0) {
            //Toevoegen plant docent/admin
            if (srolGebruiker.equals("admin") || srolGebruiker.equals("docent"))
            {
                iStatus = 2;
                Plant plant = new Plant(plantid, sPlanttype, sFamilie, sGeslacht, sSoort, sVariant, x, y, sFgsv,iStatus,iGebruikerID);
                System.out.println( iGebruikerID+"gebruiker id " + plant.getLaatste_update_door());
                plantss.add(plant);
            }
            //Toevoegen plant als leerling/gast punt voor Wout
            else
            {
                iStatus = 1;
                Plant plant = new Plant(plantid, sPlanttype, sFamilie, sGeslacht, sSoort, sVariant, x, y, sFgsv,iStatus,iGebruikerID);
                System.out.println("gebruiker id " + plant.getGebruikersID());
                plantss.add(plant);
            }
        }
        //Als plant bestaat waarschuwing geven
        else
        {
            DubbelePlantWaarschuwing();
        }


    }
    private void DubbelePlantWaarschuwing() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText("Deze plant bestaat al.");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
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
        Commensalisme commensalisme = new Commensalisme(maxidcommensalisme + 1, plantid, strategieCheck(), comboboxCheckString(cbOntwikkelingssnelheidTv.getSelectionModel()));
        commensalismes.add(commensalisme);
    }
    public String strategieCheck() {
        if(rbStrategieTopTv.isSelected()) {
            return "C";
        }
        else if (rbStrategieMMTv.isSelected()) {
            return "C-S-R";
        }
        else if (rbStrategieLMTv.isSelected()) {
            return "C-R";
        }
        else if (rbStrategieRMTv.isSelected()) {
            return "C-S";
        }
        else if (rbStrategieLOTv.isSelected()) {
            return "R";
        }
        else if (rbStrategieMOTv.isSelected()) {
            return "S-R";
        }
        else if (rbStrategieROTv.isSelected()) {
            return "S";
        }
        else {
            return "null";
        }
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
        Extra extra = new Extra(maxidextra, plantid, valueNectarwaarde, valuePollenwaarde, bijvriendelijkCheck(), eetbaarCheck(), kruidgebruikCheck(), geurendCheck(), vorstgevoeligCheck(),"vlinder");
        //deze fout van createExtra komt uit extraDAO omdat het niet zeker is hoe eetbaar en kruidgebruik uit de databank gehaald moeten worden
        extrass.add(extra);
        //ExtraDAO.createExtra(extra);
    }
    public String vorstgevoeligCheck() {
        if(rbVorstgevoeligJaTv.isSelected()) {
            return "ja";
        }
        else if (rbVorstgevoeligNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "null";
        }
    }
    public String eetbaarCheck() {
        if(rbEetbaarJaTv.isSelected()) {
            return "ja";
        }
        else if (rbEetbaarNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "null";
        }
    }
    public String geurendCheck() {
        if(rbGeurendJaTv.isSelected()) {
            return "ja";
        }
        else if (rbGeurendNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "null";
        }
    }
    public String kruidgebruikCheck() {
        if(rbKruidgebruikJaTv.isSelected()) {
            return "ja";
        }
        else if (rbKruidgebruikNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "null";
        }
    }
    public String bijvriendelijkCheck() {
        if(rbBijvriendelijkJaTv.isSelected()) {
            return "ja";
        }
        else if (rbBijvriendelijkNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "null";
        }
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
    public void createFoto() throws SQLException{
        FotoDAO fotoDAO = new FotoDAO(dbConnection);
        int maxIdFoto = fotoDAO.getmaxid();
        Foto foto = new Foto(maxIdFoto + 1, plantid, "a", "b", null);
        fotoDAO.createFoto(foto);
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
    public void createNaam() throws SQLException {
        NaamDao naamDAO = new NaamDao(dbConnection);

        Plant plant = new Plant(cboTypeTv.getValue(),txtFamilieTv.getText(),txtGeslachtTv.getText(),txtSoortTv.getText(),txtVariantTv.getText());


        //Controle of plantnaam al bestaat
        int iDubbeleNaam = naamDAO.ControleDubbeleNaam(plant);
        if (iDubbeleNaam == 0)
        { naamDAO.createNaam(plant);}
        else{
            DubbelePlantWaarschuwing();
        }
    }
}

