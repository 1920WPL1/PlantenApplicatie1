package plantenApp;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import plantenApp.java.dao.*;
import plantenApp.java.model.*;

import java.io.IOException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.SplittableRandom;

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
    public ComboBox CmdBehandeling;
    public TextField behandlingnaamtxt;
    public Button behandelingtoevoegenbutton;
    public Button teovoegenbehandlingbtn;
    public Button Verwijderenbeheerbutn;
    public ListView Beheerlistview;
    public TextArea opmerkingtxt;
    public Spinner frequentieNumericupdown;
    public CheckBox jancheckbox;
    public CheckBox febcheckbox;
    public CheckBox maacheckbox;
    public CheckBox aprilcheckbox;
    public CheckBox maicheckbox;
    public CheckBox junicheckbox;
    public CheckBox julicheckbox;
    public CheckBox augcheckbox;
    public CheckBox septembecheclbox;
    public CheckBox oktcheckbox;
    public CheckBox novcheckbox;
    public CheckBox deccheckbox;
    public Button Opslaanbutton;
    public Label boodschaptxt;
    private Connection dbConnection;
    private AbiotischeFactorenDAO abiotischeFactorenDAO;
    private int plantid;
    private InfoTables infoTables;
    private ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschaps = new ArrayList<>();



    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
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

        /*infotabel object aanmaken*/
       InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        infoTables = infotablesDAO.getInfoTables();

        /*comboboxes vullen*/
        FillComboboxes(infoTables);
        //FillComboBeheer();

    }
    public void FillComboBeheer() throws SQLException {
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        CmdBehandeling.getItems().clear();
        CmdBehandeling.getItems().addAll(beheerDAO.getalbeheerdaden());
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
        createplant();
        createAbiotischefactoren();
        createAbiotischeMulti();
        createfenotype();
        createfentotypemulti();
        createCommensalisme();
        createCommensalismeMulti();
        createExtra();
        createfentotypemulti();

    }

    public void createfenotype() throws SQLException {
        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        int maxid = fenotypeDAO.getmaxid();
        System.out.println(plantid);
        Fenotype fenotype = new Fenotype(maxid + 1, plantid, cbBladvormTv.getValue(), levensvormCheck(), habitusCheck(), bloeiwijzeCheck(), Integer.parseInt(cbBladgrootteTotTv.getValue()), cbRatioTv.getValue(), cbSpruitfenologieTv.getValue());
        fenotypeDAO.createfenotype(fenotype);
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
        plantid = maxidplant;
        Plant plant;
        String familie = txtFamilieTv.getText();
        String geslacht = txtGeslachtTv.getText();
        String soort = txtSoortTv.getText();
        String variant = txtVariantTv.getText();
        String fgsv = familie +" "+ geslacht +" "+ soort +" "+ variant;
        int x = 0;
        int y = 0;
        if(txtDichtheidXTv.getText().matches("[0-9]+")){
            x = Integer.parseInt(txtDichtheidXTv.getText());
        }
        if(txtDichtheidYTv.getText().matches("[0-9]+")){
            x = Integer.parseInt(txtDichtheidYTv.getText());
        }
        plant = new Plant(maxidplant + 1, cboTypeTv.getValue(), familie, geslacht, soort, variant, x, y, fgsv, 1);
        plantDAO.createplant(plant);
    }

    public void createAbiotischefactoren() throws SQLException {
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        int maxidabio = abiotischeFactorenDAO.getmaxid();
        AbiotischeFactoren abiotischeFactoren = new AbiotischeFactoren(maxidabio + 1, plantid, cbBezonningTv.getValue(), cbGrondsoortTv.getValue(), cbVochtbehoefteTv.getValue(), cbVoedingsbehoefteTv.getValue(), cbReactieAntaTv.getValue());
        abiotischeFactorenDAO.CreateAbiostische(abiotischeFactoren);
    }
    public void createCommensalisme() throws SQLException {
        CommensalismeDAO commensalismeDAO = new CommensalismeDAO(dbConnection);
        int maxidcommensalisme = commensalismeDAO.getmaxid();
        Commensalisme commensalisme = new Commensalisme(maxidcommensalisme + 1, plantid, strategieCheck(), cbOntwikkelingssnelheidTv.getValue());
        commensalismeDAO.createCommensalisme(commensalisme);
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
        ExtraDAO extraDAO = new ExtraDAO(dbConnection);
        int maxidextra = extraDAO.getmaxid();
        int valueNectarwaarde = Integer.parseInt(NectarwaardeValueTv.getText());
        int valuePollenwaarde = Integer.parseInt(PollenValueTv.getText());
        Extra extra = new Extra(maxidextra + 1, plantid, valueNectarwaarde, valuePollenwaarde, bijvriendelijkCheck(), eetbaarCheck(), kruidgebruikCheck(), geurendCheck(), vorstgevoeligCheck());
        //deze fout van createExtra komt uit extraDAO omdat het niet zeker is hoe eetbaar en kruidgebruik uit de databank gehaald moeten worden
        extraDAO.createExtra(extra);
        System.out.println("Extra is gefixt");
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
//2 onderstaande functies zijn nieuw
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

        //Toevoegen van levensduur
        CommensalismeDAO commensalismeMulti = new CommensalismeDAO(dbConnection);

        System.out.println(" " + plantid);

        for (int i = 0; i < lvLevensduurTv.getItems().size(); i++) {
            CommMulti_Eigenschap levensduur = new CommMulti_Eigenschap("levensduur", lvLevensduurTv.getItems().get(i));
            System.out.println(levensduur.getNaam());
            commensalismeMulti.createCommensalismeMulti(levensduur, plantid);

        }


        //Toevoegen van sociabiliteit
        if (chkSociabiliteit1Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "1");
            System.out.println(sociabiliteit.getNaam());
            commensalismeMulti.createCommensalismeMulti(sociabiliteit, plantid);
        }
        if (chkSociabiliteit2Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "1");
            System.out.println(sociabiliteit.getNaam());
            commensalismeMulti.createCommensalismeMulti(sociabiliteit, plantid);
        }
        if (chkSociabiliteit3Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "1");
            System.out.println(sociabiliteit.getNaam());
            commensalismeMulti.createCommensalismeMulti(sociabiliteit, plantid);
        }
        if (chkSociabiliteit4Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "1");
            System.out.println(sociabiliteit.getNaam());
            commensalismeMulti.createCommensalismeMulti(sociabiliteit, plantid);
        }
        if (chkSociabiliteit5Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "1");
            System.out.println(sociabiliteit.getNaam());
            commensalismeMulti.createCommensalismeMulti(sociabiliteit, plantid);
        }
    }

/*
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
        CommensalismeDAO commensalismeMulti = new CommensalismeDAO(dbConnection);
        int maxidcommensalismeMulti = commensalismeMulti.getmaxid();
        System.out.println(  " " + plantid);

        for (int i = 0; i < lvLevensduurTv.getItems().size(); i++) {
            CommMulti_Eigenschap commensalisme = new CommMulti_Eigenschap(maxidcommensalismeMulti + 1, "Levensduur", lvLevensduurTv.getItems().get(i) );
            System.out.println(commensalisme.getNaam());
            commensalismeMulti.createCommensalismeMulti(commensalisme, plantid);
            maxidcommensalismeMulti++;
        }
        System.out.println(maxidcommensalismeMulti + " " + plantid);
    }*/
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
    public void createfentotypemulti() throws SQLException {
            FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
            int maxid = fenotypeDAO.getmaxidmulti();
            maxid++;
        System.out.println(maxid);
            String naam ="bladhoogte";
            ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschaps = new ArrayList<>();
            FenoMulti_Eigenschap bladhoogte = new FenoMulti_Eigenschap(maxid,"Bloeikleur", spinMaxBladhJanTv.getValue().toString(),spinMaxBladhFebTv.getValue().toString(),spinMaxBladhMaaTv.getValue().toString(),spinMaxBladhAprTv.getValue().toString(),spinMaxBladhMeiTv.getValue().toString(),spinMaxBladhJunTv.getValue().toString(),spinMaxBladhJulTv.getValue().toString(),spinMaxBladhAugTv.getValue().toString(),spinMaxBladhSeptTv.getValue().toString(),spinMaxBladhOktTv.getValue().toString(),spinMaxBladhNovTv.getValue().toString(),spinMaxBladhDecTv.getValue().toString());
             maxid++;
            FenoMulti_Eigenschap bladkleur = new FenoMulti_Eigenschap(maxid,"Bladkleur",cbBladkleurJanTv.getValue(),cbBladkleurFebTv.getValue(),cbBladkleurMaaTv.getValue(),cbBladkleurAprTv.getValue(), cbBladkleurMeiTv.getValue(), cbBladkleurJunTv.getValue(),cbBladkleurJulTv.getValue(),cbBladkleurAugTv.getValue(),cbBladkleurSeptTv.getValue(),cbBladkleurOktTv.getValue(),cbBladkleurNovTv.getValue(),cbBladkleurDecTv.getValue());
             maxid++;
             FenoMulti_Eigenschap minbloeihoogte = new FenoMulti_Eigenschap(maxid,"Min Bloeihoogte",spinMinBloeihJanTv.getValue().toString() , spinMinBloeihFebTv.getValue().toString(),spinMinBloeihMaaTv.getValue().toString(),spinMinBloeihAprTv.getValue().toString(),spinMinBloeihMeiTv.getValue().toString(),spinMinBloeihJunTv.getValue().toString(),spinMinBloeihJulTv.getValue().toString(),spinMinBloeihAugTv.getValue().toString(),spinMaxBloeihSeptTv.getValue().toString(),spinMinBloeihOktTv.getValue().toString(),spinMinBloeihNovTv.getValue().toString(),spinMinBloeihDecTv.getValue().toString());
             maxid++;
             FenoMulti_Eigenschap maxbloeihoogte = new FenoMulti_Eigenschap(maxid,"Max Bloeihoogte",spinMaxBloeihJanTv.getValue().toString(),spinMaxBloeihFebTv.getValue().toString(),spinMaxBladhMaaTv.getValue().toString(),spinMaxBloeihAprTv.getValue().toString(),spinMaxBloeihMeiTv.getValue().toString(),spinMaxBloeihJunTv.getValue().toString(),spinMaxBloeihJulTv.getValue().toString(),spinMaxBloeihAugTv.getValue().toString(),spinMaxBloeihSeptTv.getValue().toString(),spinMaxBloeihOktTv.getValue().toString(),spinMaxBloeihNovTv.getValue().toString(),spinMaxBloeihDecTv.getValue().toString());
            maxid++;
            FenoMulti_Eigenschap bloeikleur = new FenoMulti_Eigenschap(maxid,"Bloeikleur" ,cbBloeikleurJanTv.getValue(),cbBloeikleurFebTv.getValue(),cbBloeikleurMaaTv.getValue(),cbBloeikleurAprTv.getValue(),cbBloeikleurMeiTv.getValue(),cbBloeikleurJunTv.getValue(),cbBloeikleurJulTv.getValue(),cbBloeikleurAugTv.getValue(),cbBloeikleurSeptTv.getValue(),cbBloeikleurOktTv.getValue(),cbBloeikleurNovTv.getValue(),cbBloeikleurDecTv.getValue());
            fenoMulti_eigenschaps.add(bladhoogte);
            fenoMulti_eigenschaps.add(bladkleur);
            fenoMulti_eigenschaps.add(minbloeihoogte);
            fenoMulti_eigenschaps.add(maxbloeihoogte);
            fenoMulti_eigenschaps.add(bloeikleur);
        for (int i =0 ; i < 5;i++)
        {
            FenoMulti_Eigenschap fenoMulti_eigenschap = new FenoMulti_Eigenschap(fenoMulti_eigenschaps.get(i).getId(),fenoMulti_eigenschaps.get(i).getNaam(),fenoMulti_eigenschaps.get(i).getJan(), fenoMulti_eigenschaps.get(i).getFeb(),fenoMulti_eigenschaps.get(i).getMaa(),fenoMulti_eigenschaps.get(i).getApr(),fenoMulti_eigenschaps.get(i).getMei(),fenoMulti_eigenschaps.get(i).getJun(),fenoMulti_eigenschaps.get(i).getJul(),fenoMulti_eigenschaps.get(i).getAug(),fenoMulti_eigenschaps.get(i).getSep(),fenoMulti_eigenschaps.get(i).getOkt(),fenoMulti_eigenschaps.get(i).getNov(),fenoMulti_eigenschaps.get(i).getDec());

            fenotypeDAO.createfenomulti(fenoMulti_eigenschap , plantid);

        }
    }
    public void createBeheer() throws SQLException{
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        int maxIdBeheer = beheerDAO.getmaxid();
        for(int i = 0; i < Beheerlistview.getItems().size();i++)
        {
            Beheerdaad_Eigenschap beheerdaad_eigenschap = new Beheerdaad_Eigenschap(maxIdBeheer+1, "Test", "Test", "Test", 5);
            Beheer beheer = new Beheer(maxIdBeheer+1);
            beheerDAO.createBeheer(beheerdaad_eigenschap,beheer);
        }
    }

    //nieuwe functie
    private void createAbiotischeMulti() throws SQLException {

        AbiotischeFactorenDAO abiotischeMulti = new AbiotischeFactorenDAO(dbConnection);
        int maxidcommensalismeMulti = abiotischeMulti.getMaxIdMulti();
        System.out.println(" " + plantid);

        for (int i = 0; i < lvHabitatTv.getItems().size(); i++) {
            AbioMulti_Eigenschap abiotisch = new AbioMulti_Eigenschap("Habitat", (String) lvHabitatTv.getItems().get(i));

            abiotischeMulti.CreateAbiotischeMulti(abiotisch, plantid);
            maxidcommensalismeMulti++;
        }
        System.out.println(maxidcommensalismeMulti + " " + plantid);
    }

    /*oude functie
    public void createAbiotischeMulti() throws SQLException{
        int maxidabio = abiotischeFactorenDAO.getMaxIdMulti();
        System.out.println(maxidabio);
        AbioMulti_Eigenschap abioMulti_eigenschap = new AbioMulti_Eigenschap(maxidabio+1, "Test", "Test");
        abiotischeFactorenDAO.CreateAbiotischeMulti(abioMulti_eigenschap, plantid);
    }*/
    public void behandelingtoevoegenbtn_clicked(MouseEvent mouseEvent) throws SQLException {
        try {
            BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
            beheerDAO.createbeheerdaad(behandlingnaamtxt.getText());
            FillComboBeheer();
            behandlingnaamtxt.setText("");
        }
        catch (Exception e)
        {
            boodschaptxt.setText("er bestaat al een behandeling met deze naam");
            behandlingnaamtxt.setText("");
        }

    }
    public void Verwijdernbeheer_clicekd(MouseEvent mouseEvent) {
        beheerdaad_eigenschaps.remove(Beheerlistview.getSelectionModel().getSelectedIndex());
        Beheerlistview.getItems().clear();
        for (int j = 0 ; j < beheerdaad_eigenschaps.size(); j++)
        {
            Beheerlistview.getItems().addAll(beheerdaad_eigenschaps.get(j).getNaam() + " " +beheerdaad_eigenschaps.get(j).getMaand()+ " " + beheerdaad_eigenschaps.get(j).getOpmerking() );
        }
    }
    public void teovoegenbeheer_clicked(MouseEvent mouseEvent) throws SQLException {
        try {
            BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
            ArrayList<String> maanden = new ArrayList<>();
            maanden = getmaanden();
            int id = beheerDAO.getmaxid();
            id++;
            for( int j=0; j < maanden.size();j++)
            {
                Beheerdaad_Eigenschap beheerdaad_eigenschap = new Beheerdaad_Eigenschap(id+j, CmdBehandeling.getValue().toString(), opmerkingtxt.getText(),maanden.get(j), (Integer) frequentieNumericupdown.getValue());
                beheerdaad_eigenschaps.add(beheerdaad_eigenschap);
                Beheerlistview.getItems().addAll(beheerdaad_eigenschaps.get(j).getNaam() + " " +beheerdaad_eigenschaps.get(j).getMaand()+ " " + beheerdaad_eigenschaps.get(j).getOpmerking() );
                System.out.println(beheerDAO.getmaxid()+j);
                System.out.println(beheerdaad_eigenschaps.get(j).getId());
            }
        }
        catch (Exception e)
        {
            boodschaptxt.setText("Vul alles correct in");
        }

    }
    public ArrayList<String> getmaanden()    {
        ArrayList<String> maanden = new ArrayList<>();
        if(jancheckbox.isSelected())
        {
            maanden.add("Januari");
            jancheckbox.selectedProperty().set(false);
        }
        if(febcheckbox.isSelected())
        {
            maanden.add("Februarie");
            febcheckbox.selectedProperty().set(false);
        }
        if(maacheckbox.isSelected())
        {
            maanden.add("Maart");
            maacheckbox.selectedProperty().set(false);

        }
        if(aprilcheckbox.isSelected())
        {
            maanden.add("April");
            aprilcheckbox.selectedProperty().set(false);

        }
        if(maicheckbox.isSelected())
        {
            maanden.add("Mei");
            maicheckbox.selectedProperty().set(false);

        }
        if(junicheckbox.isSelected())
        {
            maanden.add("Juni");
            junicheckbox.selectedProperty().set(false);

        }
        if(julicheckbox.isSelected())
        {
            maanden.add("Juli");
            julicheckbox.selectedProperty().set(false);

        }
        if(augcheckbox.isSelected())
        {
            maanden.add("Augustus");
            augcheckbox.selectedProperty().set(false);

        }
        if(septembecheclbox.isSelected())
        {
            maanden.add("September");
            septembecheclbox.selectedProperty().set(false);

        }
        if(oktcheckbox.isSelected())
        {
            maanden.add("Oktober");
            oktcheckbox.selectedProperty().set(false);
        }
        if(novcheckbox.isSelected())
        {
            maanden.add("November");
            novcheckbox.selectedProperty().set(false);

        }
        if(deccheckbox.isSelected())
        {
            maanden.add("December");
            deccheckbox.selectedProperty().set(false);

        }
        return maanden;
    }
    public void Opslaanbutton_clicked(MouseEvent mouseEvent) throws SQLException {
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        plantid = 250;
        Beheer beheer = new Beheer( plantid,beheerdaad_eigenschaps );
        for (int m = 0; m < beheerdaad_eigenschaps.size();m++)
        {
            beheerDAO.createBeheer(beheerdaad_eigenschaps.get(m) ,beheer);
        }
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
}

