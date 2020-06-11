package plantenApp;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import plantenApp.java.dao.*;
import plantenApp.java.model.*;

import java.awt.*;
import java.lang.Object;


import javax.swing.*;
import java.io.Console;
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
    public ListView<String> lvHabitat;
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
    public ToggleGroup StrategieGroepTv;
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
    public static ArrayList<Integer> AantalPerElCommMulti = new ArrayList<>();
    public static ArrayList<Integer> AantalPerElAbMulti = new ArrayList<>();
    public static ArrayList<Integer> AantalPerElBehMulti = new ArrayList<>();
    public String scherm;
    public String sPlanttype = "", sFamilie = "", sGeslacht = "", sSoort = "", sVariant = "", sFgsv = "";
    public int iGebruikerID;
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
        //connectie met database maken
        dbConnection = Database.getInstance().getConnection();

        // enkele defaults klaarzetten
        Pollenwaarde();
        DefaultRadioButtons();
        //infotabel object aanmaken*/
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        infoTables = infotablesDAO.getInfoTables();
        /*comboboxes vullen*/
        FillComboboxes(infoTables);

        //Opvullen van emailadres om mee te geven met toevoegen plant
        sEmailadres = "kurt.engelbrecht@vives.be";

        if (plantss.size()>0) {
            try {
                OpnieuwInladen(0);
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public void OpnieuwInladen(int indexArrays) {
        System.out.println("Bezonning: " + ControllerBeheer.abiotischeFactorenn2.get(0).getBezonning());
        //Plant
        Plant p = ControllerPlantToevoegen.plantss.get(indexArrays);
        cboTypeTv.getSelectionModel().select(p.getPlantType());
        txtFamilieTv.setText(p.getFamilie());
        txtGeslachtTv.setText(p.getGeslacht());
        txtSoortTv.setText(p.getSoort());
        txtVariantTv.setText(p.getVariatie());
        txtDichtheidXTv.setText(String.valueOf(p.getMinPlantdichtheid()));
        txtDichtheidYTv.setText(String.valueOf(p.getMaxPlantdichtheid()));

        //Abiotische factoren
        AbiotischeFactoren af = ControllerBeheer.abiotischeFactorenn2.get(indexArrays);
        cbBezonningTv.getSelectionModel().select(af.getBezonning());
        cbVochtbehoefteTv.getSelectionModel().select(af.getVochtbehoefte());
        cbVoedingsbehoefteTv.getSelectionModel().select(af.getVoedingsbehoefte());
        cbReactieAntaTv.getSelectionModel().select(af.getReactieAntagonistischeOmgeving());
        cbGrondsoortTv.getSelectionModel().select(af.getGrondsoort());

        for(int i =0;i<ControllerBeheer.abiotischmulti2.size();i++)
        {
            lvHabitatTv.getItems().add(ControllerBeheer.abiotischmulti2.get(i).getValue());
        }
        //Commensalisme
        Commensalisme c = ControllerBeheer.commensalismes2.get(indexArrays);
        cbOntwikkelingssnelheidTv.getSelectionModel().select(c.getOntwikkelingssnelheid());
        int tellerc = 0;
        for(int i = 0; i<indexArrays;i++){
            tellerc +=ControllerBeheer.AantalPerElCommMulti2.get(i);
        }
        int eindplaatsc = tellerc + ControllerBeheer.AantalPerElCommMulti2.get(indexArrays);
        for(int j = tellerc; j<ControllerBeheer.commMulti_eigenschapss2.size();j++){
            if(ControllerBeheer.commMulti_eigenschapss2.get(j).getNaam().matches("sociabiliteit")){
                if(ControllerBeheer.commMulti_eigenschapss2.get(j).getValue().matches("1")){chkSociabiliteit1Tv.setSelected(true);}
                if(ControllerBeheer.commMulti_eigenschapss2.get(j).getValue().matches("2")){chkSociabiliteit2Tv.setSelected(true);}
                if(ControllerBeheer.commMulti_eigenschapss2.get(j).getValue().matches("3")){chkSociabiliteit3Tv.setSelected(true);}
                if(ControllerBeheer.commMulti_eigenschapss2.get(j).getValue().matches("4")){chkSociabiliteit4Tv.setSelected(true);}
                if(ControllerBeheer.commMulti_eigenschapss2.get(j).getValue().matches("5")){chkSociabiliteit5Tv.setSelected(true);}
            }
            if(ControllerBeheer.commMulti_eigenschapss2.get(j).getNaam().matches("levensduur")){
                lvLevensduurTv.getItems().add(ControllerBeheer.commMulti_eigenschapss2.get(j).getValue());
            }
        }
        Commensalisme hulpc = ControllerBeheer.commensalismes2.get(0);
        switch(hulpc.getStrategie()){
            case "": StrategieGroepTv.selectToggle(rbStrategieUnknownTv); break;
            case "C": StrategieGroepTv.selectToggle(rbStrategieTopTv); break;
            case "C-S-R": StrategieGroepTv.selectToggle(rbStrategieMMTv); break;
            case "C-R": StrategieGroepTv.selectToggle(rbStrategieLMTv); break;
            case "C-S": StrategieGroepTv.selectToggle(rbStrategieRMTv); break;
            case "R": StrategieGroepTv.selectToggle(rbStrategieLOTv); break;
            case "S-R": StrategieGroepTv.selectToggle(rbStrategieMOTv); break;
            case "S": StrategieGroepTv.selectToggle(rbStrategieROTv); break;
        }

        //Extra
        Extra e = ControllerBeheer.extrass2.get(indexArrays);
        slNectarwaardeTv.setValue(Double.parseDouble(String.valueOf(e.getNectarwaarde())));
        slPollenwaardeTv.setValue(Double.parseDouble(String.valueOf(e.getPollenwaarde())));
        Selecteerjuisteradiobutton(rbBijvriendelijkJaTv,rbBijvriendelijkNeeTv,rbBijvriendelijkNullTv, e.getBijvriendelijk());
        Selecteerjuisteradiobutton(rbVlindervriendelijkJaTv,rbVorstgevoeligNeeTv,rbVlindervriendelijkNullTv, e.getVlindervriendelijk());
        Selecteerjuisteradiobutton(rbEetbaarJaTv,rbEetbaarNeeTv,rbEetbaarNullTv,e.getEetbaar());
        Selecteerjuisteradiobutton(rbKruidgebruikJaTv,rbKruidgebruikNeeTv,rbKruidgebruikNullTv,e.getKruidgebruik());
        Selecteerjuisteradiobutton(rbGeurendJaTv,rbGeurendNeeTv,rbGeurendNullTv,e.getGeurend());
        Selecteerjuisteradiobutton(rbVorstgevoeligJaTv,rbVorstgevoeligNeeTv,rbVorstgevoeligNullTv,e.getVorstgevoelig());

        //Fenotype
        Fenotype f = ControllerBeheer.fenotypess2.get(indexArrays);
        cbBladgrootteTotTv.getSelectionModel().select(f.getBladgrootte());
        System.out.println("Bladgrootte: " + f.getBladgrootte());
        cbBladvormTv.getSelectionModel().select(f.getBladvorm());
        cbRatioTv.getSelectionModel().select(f.getRatio_bloei_blad());
        cbSpruitfenologieTv.getSelectionModel().select(f.getSpruitfenologie());

        if (f.getLevensvorm() == "1. Hydrofyt") {
            rbHydro1Tv.setSelected(true);
        }
        else if (f.getLevensvorm() == "2. Hydrofyt") {
            rbHydro2Tv.setSelected(true);
        }
        else if (f.getLevensvorm() == "3. Helofyt") {
            rbHeloTv.setSelected(true);
        }
        else if (f.getLevensvorm() == "4. Cryptophyt") {
            rbCrypto1Tv.setSelected(true);
        }
        else if (f.getLevensvorm() == "5. Cryptophyt") {
            rbCrypto2Tv.setSelected(true);
        }
        else if (f.getLevensvorm() == "6. Hemikryptofyt") {
            rbHemikryptoTv.setSelected(true);
        }
        else if (f.getLevensvorm() == "7. Chamaefyt") {
            rbChamae1Tv.setSelected(true);
        }
        else if (f.getLevensvorm() == "8. Chamaefyt") {
            rbChamae2Tv.setSelected(true);
        }
        else if (f.getLevensvorm() == "9. Fanerophyt") {
            rbFaneroTv.setSelected(true);
        }
        else {
            System.out.println("Geen waarde voor levensvorm meegegeven");
        }

        //selectie van max bladhoogte
        for(int i=0;i<5;i++){
            if(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNaam().matches("Bladhoogte")){
                spinMaxBladhJanTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJan()));
                spinMaxBladhFebTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getFeb()));
                spinMaxBladhMaaTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMaa()));
                spinMaxBladhAprTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getApr()));
                spinMaxBladhMeiTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMei()));
                spinMaxBladhJunTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJun()));
                spinMaxBladhJulTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJul()));
                spinMaxBladhAugTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getAug()));
                spinMaxBladhSeptTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getSep()));
                spinMaxBladhOktTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getOkt()));
                spinMaxBladhNovTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNov()));
                spinMaxBladhDecTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getDec()));
            }
        }

        //selectie van max bloeihoogte
        for(int i=0;i<5;i++){
            if(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNaam().matches("Max Bloeihoogte")){
                spinMaxBloeihJanTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJan()));
                spinMaxBloeihFebTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getFeb()));
                spinMaxBloeihMaaTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMaa()));
                spinMaxBloeihAprTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getApr()));
                spinMaxBloeihMeiTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMei()));
                spinMaxBloeihJunTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJun()));
                spinMaxBloeihJulTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJul()));
                spinMaxBloeihAugTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getAug()));
                spinMaxBloeihSeptTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getSep()));
                spinMaxBloeihOktTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getOkt()));
                spinMaxBloeihNovTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNov()));
                spinMaxBloeihDecTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getDec()));
            }
        }

        //selectie van min bloeihoogte
        for(int i=0;i<5;i++){
            if(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNaam().matches("Min Bloeihoogte")){
                spinMinBloeihJanTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJan()));
                spinMinBloeihFebTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getFeb()));
                spinMinBloeihMaaTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMaa()));
                spinMinBloeihAprTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getApr()));
                spinMinBloeihMeiTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMei()));
                spinMinBloeihJunTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJun()));
                spinMinBloeihJulTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJul()));
                spinMinBloeihAugTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getAug()));
                spinMinBloeihSeptTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getSep()));
                spinMinBloeihOktTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getOkt()));
                spinMinBloeihNovTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNov()));
                spinMinBloeihDecTv.getValueFactory().setValue(Integer.parseInt(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getDec()));
            }
        }

        //selectie van bloeikleur en bladkleur insteken
        //selectie insteken van bladkleur, overlopen van lijst voor eigenschap met bladkleur te vinden, dan de waarden daarvan in deze comboboxen steken
        for(int i=0;i<5;i++){
            if(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNaam().matches("Bladkleur")){
                cbBladkleurJanTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJan());
                cbBladkleurFebTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getFeb());
                cbBladkleurMaaTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMaa());
                cbBladkleurAprTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getApr());
                cbBladkleurMeiTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMei());
                cbBladkleurJunTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJun());
                cbBladkleurJulTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJul());
                cbBladkleurAugTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getAug());
                cbBladkleurSeptTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getSep());
                cbBladkleurOktTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getOkt());
                cbBladkleurNovTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNov());
                cbBladkleurDecTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getDec());
            }
        }

        //selectie insteken van bladkleur, overlopen van lijst voor eigenschap met bloeikleur te vinden, dan de waarden daarvan in deze comboboxen steken
        for(int i=0;i<5;i++){
            if(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNaam().matches("Bloeikleur")){
                cbBloeikleurJanTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJan());
                cbBloeikleurFebTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getFeb());
                cbBloeikleurMaaTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMaa());
                cbBloeikleurAprTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getApr());
                cbBloeikleurMeiTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getMei());
                cbBloeikleurJunTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJun());
                cbBloeikleurJulTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getJul());
                cbBloeikleurAugTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getAug());
                cbBloeikleurSeptTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getSep());
                cbBloeikleurOktTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getOkt());
                cbBloeikleurNovTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getNov());
                cbBloeikleurDecTv.getSelectionModel().select(ControllerBeheer.fenoMulti_eigenschapss2.get(i).getDec());
            }
        }

        //Habitus
        if(f.getHabitus() == "tufted")
        {
            rbTuftedTv.setSelected(true);
        }
        if(f.getHabitus() == "Upright arching")
        {
            rbUprightarchingTv.setSelected(true);
        }
        if(f.getHabitus() == "Arching")
        {
            rbArchingTv.setSelected(true);
        }
        if(f.getHabitus() == "Upright Divergent")
        {
            rbUprightDivergentTv.setSelected(true);
        }
        if(f.getHabitus() == "Upright erect")
        {
            rbUprightErectTv.setSelected(true);
        }
        if(f.getHabitus() == "Mounted")
        {
            rbMountedTv.setSelected(true);
        }
        if(f.getHabitus() == "Kruipend of horizontaal groeiend of mattenvormend")
        {
            rbKOfHGOfMTv.setSelected(true);
        }
        if(f.getHabitus() == "Rond- of waaiervormig")
        {
            rbRondOfWaaiervormigTv.setSelected(true);
        }
        if(f.getHabitus() == "Kussenvormend")
        {
            rbKussenvormendTv.setSelected(true);
        }
        if(f.getHabitus() == "Zuilvormig")
        {
            rbZuilvormigTv.setSelected(true);
        }
        if(f.getHabitus() == "Uitbuigend")
        {
            rbUitbuigendTv.setSelected(true);
        }
        if(f.getHabitus() == "(Wortel)rozetplant")
        {
            rbWortelrozetplantTv.setSelected(true);
        }
        if(f.getHabitus() == "Succulenten")
        {
            rbSucculentenTv.setSelected(true);
        }
        if(f.getHabitus() == "Pollenvormers")
        {
            rbPollenvormersTv.setSelected(true);
        }
        if(f.getHabitus() == "Parasolvormig")
        {
            rbParasolvormigTv.setSelected(true);
        }

        //Bloeiwijze
        if(f.getBloeiwijze() == "Aar")
        {
            rbAarTv.setSelected(true);
        }
        if(f.getBloeiwijze() == "Brede pluim")
        {
            rbBredePluimTv.setSelected(true);
        }
        if(f.getBloeiwijze() == "Etage")
        {
            rbEtageTv.setSelected(true);
        }
        if(f.getBloeiwijze() == "Bol of knop")
        {
            rbBolOfKnopTv.setSelected(true);
        }
        if(f.getBloeiwijze() == "Margrietachtig")
        {
            rbMargrietachtigTv.setSelected(true);
        }
        if(f.getBloeiwijze() == "Schotel")
        {
            rbSchotelTv.setSelected(true);
        }
        if(f.getBloeiwijze() == "Scherm")
        {
            rbSchermTv.setSelected(true);
        }
        if(f.getBloeiwijze() == "Smalle pluim")
        {
            rbSmallePluimTv.setSelected(true);
        }
    }

    public void Selecteerjuisteradiobutton(RadioButton buttonja , RadioButton buttonnee , RadioButton buttonnull, String waarde)    {
        if(waarde =="ja")
        {
            buttonja.setSelected(true);
        }
        if(waarde == "nee")
        {
            buttonnee.setSelected(true);
        }
        if(waarde == "null")
        {
            buttonnull.setSelected(true);
        }
    }

    //initialiseren van de sliders
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
    //default radio buttons selecteren
    public void DefaultRadioButtons () {
        rbStrategieUnknownTv.setSelected(true);
        rbBijvriendelijkNullTv.setSelected(true);
        rbVlindervriendelijkNullTv.setSelected(true);
        rbEetbaarNullTv.setSelected(true);
        rbKruidgebruikNullTv.setSelected(true);
        rbGeurendNullTv.setSelected(true);
        rbVorstgevoeligNullTv.setSelected(true);
    }
    //dit is een functie zodat alle comboboxes ingevuld worden
    public void FillComboboxes(InfoTables infotables) {
        try {
            //type
            System.out.println(infotables.getPlantTypes().toString());
            cboTypeTv.getItems().addAll(infotables.getPlantTypes());
            cboTypeTv.getSelectionModel().select(0);

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
        } catch (Exception ex) {
            ShowError("Opvullen comboboxen", "Het opvullen van de comboboxen is niet voltooid.");
        }

    }
    //als er op planttoevoegen geclicked wordt dan worden alle gegevens in verschillende arrays gestoken
    // op het einde wordt het beheer scherm geopend
    public void Clicked_PlantToevoegen(MouseEvent mouseEvent) throws Exception {
        plantss.clear();
        abiotischeFactorenn.clear();
        abiotischmulti.clear();
        System.out.println("Size abio multi: " + abiotischmulti.size());
        System.out.println("Size abio multi 2" + ControllerBeheer.abiotischmulti2.size() );
        fenotypess.clear();
        fenoMulti_eigenschapss.clear();
        commensalismes.clear();
        commMulti_eigenschapss.clear();
        extrass.clear();
        beheerss.clear();
        fotoss.clear();

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
        AllesInNieuweArrays();
        openNieuwScherm(mouseEvent);
    }

    public void AllesInNieuweArrays() {
        //In nieuwe arrays steken
        ControllerBeheer.plantss2 = ControllerPlantToevoegen.plantss;
        System.out.println("Variatie: " + ControllerBeheer.plantss2.get(0).getVariatie());
        System.out.println("Variatie: " + plantss.get(0).getVariatie());

        ControllerBeheer.abiotischeFactorenn2 = ControllerPlantToevoegen.abiotischeFactorenn;
        ControllerBeheer.abiotischmulti2 = ControllerPlantToevoegen.abiotischmulti;
        ControllerBeheer.commensalismes2 = ControllerPlantToevoegen.commensalismes;
        ControllerBeheer.commMulti_eigenschapss2 = ControllerPlantToevoegen.commMulti_eigenschapss;
        ControllerBeheer.extrass2 = ControllerPlantToevoegen.extrass;
        ControllerBeheer.fenotypess2 = ControllerPlantToevoegen.fenotypess;
        ControllerBeheer.fenoMulti_eigenschapss2 = ControllerPlantToevoegen.fenoMulti_eigenschapss;
        ControllerBeheer.fotoss2 = ControllerPlantToevoegen.fotoss;
        ControllerBeheer.beheerdaad_eigenschapss2 = ControllerPlantToevoegen.beheerdaad_eigenschapss;
        ControllerBeheer.beheerss2 = ControllerPlantToevoegen.beheerss;

        ControllerBeheer.AantalPerElAbMulti2 = ControllerPlantToevoegen.AantalPerElAbMulti;
        ControllerBeheer.AantalPerElBehMulti2 = ControllerPlantToevoegen.AantalPerElBehMulti;
        ControllerBeheer.AantalPerElCommMulti2 = ControllerPlantToevoegen.AantalPerElCommMulti;
        System.out.println(abiotischmulti.size()+"abiotmulti");
        System.out.println(ControllerBeheer.abiotischmulti2.size()+"abiotmutli2");
    }

    public void openNieuwScherm(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/BeheeBehandelingPlant.fxml"));
        Scene scen = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scen);
        window.show();
        scherm="beheer";
        window.setMaximized(true);
    }
    //fenotype wordt in de array gestoken
    public void createfenotype() throws SQLException {
        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        int maxid = fenotypeDAO.getmaxid();
        maxid++;
        System.out.println(plantid);
        Fenotype fenotype = new Fenotype(maxid, plantid, comboboxCheckString(cbBladvormTv.getSelectionModel()), levensvormCheck(), habitusCheck(), bloeiwijzeCheck(), comboboxCheckInteger(cbBladgrootteTotTv.getSelectionModel()), comboboxCheckString(cbRatioTv.getSelectionModel()), comboboxCheckString(cbSpruitfenologieTv.getSelectionModel()));
        fenotypess.add(fenotype);
    }
    //een functie om te controleren of een combobox is ingevuld of niet. als deze leeg is dan wordt de waarde "" ingevuld bij de arrays
    public String comboboxCheckString(SingleSelectionModel <String> combobox) {
        if(combobox.isEmpty()) {
            return "";
        }
        else {
            return combobox.getSelectedItem().toString();
        }
    }
    //hetzelfde als de functie erboven maar dan met 0 als return waarde
    public Integer comboboxCheckInteger(SingleSelectionModel<String> combobox) {
        if (combobox.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(combobox.getSelectedItem());
        }
    }
    //kijkt welke radiobutton er is aangeduid en return da waarde daarvan
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
        return "";
    }
    //hetzelfde als hierboven kijkjt welke levensvorm er gekozen is en returnt de waarde
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
        return "";
    }
    //hetzelfde als hierboven maar dan voor bloeiwijze
    public String bloeiwijzeCheck(){
        if(rbAarTv.isSelected()){return "Aar";}
        if(rbBredePluimTv.isSelected()){return "Brede pluim";}
        if(rbEtageTv.isSelected()){return "Etage";}
        if(rbBolOfKnopTv.isSelected()){return "Bol of knop";}
        if(rbMargrietachtigTv.isSelected()){return "Margrietachtig";}
        if(rbSchotelTv.isSelected()){return "Schotel";}
        if(rbSchermTv.isSelected()){return "Scherm";}
        if(rbSmallePluimTv.isSelected()){return "Smalle pluim";}
        return "";
    }
    //creat een plant en vangt alles op en geeft een specifieke boodschap per niet ingevuld veld die wel verplicht is
    public void createplant() throws SQLException, Exception {
        //Aanmaken variabelen
        //volledig toevoegen in databank vanuit scherm, waarschijnlijk nog iets toevoegen voor te kijken of de naam al in de databank zit
        GebruikerDAO gebruikerDAO = new GebruikerDAO(dbConnection);
        PlantDAO plantDAO = new PlantDAO(dbConnection);
        NaamDao naamDAO = new NaamDao(dbConnection);
        Plant plantTest = new Plant(cboTypeTv.getValue(), txtFamilieTv.getText(), txtGeslachtTv.getText(), txtSoortTv.getText(), txtVariantTv.getText());
        //Ophalen plantid voor nieuwe plant
        int maxidplant = plantDAO.getmaxid();
         iGebruikerID = gebruikerDAO.getIdMetEmail(sEmailadres);
        System.out.println(iGebruikerID);
        String srolGebruiker = gebruikerDAO.getRolMetEmail(sEmailadres);
        this.plantid = maxidplant;
        plantid = maxidplant + 1;
        String sErrorTitel = "Fout toevoegen plant";
        int ix = 0, iy = 0, iStatus = 0;

        //Controle op gebruiker
        try {
            iGebruikerID = gebruikerDAO.getIdMetEmail(sEmailadres);
            srolGebruiker = gebruikerDAO.getRolMetEmail(sEmailadres);
        } catch (Exception ex) {
            ShowError(sErrorTitel, "Er is een fout opgetreden bij het meegeven van gebruiker.");
            System.out.println(ex);
            throw new Exception(ex);
        }
        //Controle op plantType
        try {
            if (cboTypeTv.getValue().length() == 0) {
                ShowError(sErrorTitel, "Type kan niet leeg zijn");
            } else {
                sPlanttype = cboTypeTv.getValue();
            }

        } catch (Exception ex) {
            ShowError(sErrorTitel, "Type kan niet leeg zijn.");
            System.out.println(ex);
            throw new Exception(ex);
        }
        //Controle op familie
        try {
            if (txtFamilieTv.getText().length() == 0) {
                throw new ExceptionInInitializerError();
            } else {
                sFamilie = txtFamilieTv.getText();
            }
        } catch (Exception ex) {
            ShowError(sErrorTitel, "Er is een fout opgetreden bij het meegeven van familie.");
            System.out.println(ex);
            throw new Exception();
        } catch (
                ExceptionInInitializerError exi) {
            ShowError(sErrorTitel, "Familie kan niet leeg zijn");
            System.out.println(exi);
            throw new Exception();
        }
        //Controle op geslacht
        try {
            if (txtGeslachtTv.getText().length() == 0) {

                throw new ExceptionInInitializerError();
            } else {
                sGeslacht = txtGeslachtTv.getText();
            }
        } catch (
                Exception ex) {
            ShowError(sErrorTitel, "Er is een fout opgetreden bij het meegeven van geslacht.");
            System.out.println(ex);
            throw new Exception(ex);
        } catch (
                ExceptionInInitializerError exi) {
            ShowError(sErrorTitel, "Geslacht kan niet leeg zijn");
            System.out.println(exi);
            throw new Exception();
        }
        //Controle op soort
        try {
            if (txtSoortTv.getText().length() > 0) {
                sSoort = txtSoortTv.getText();
            } else {
                sSoort = "";
            }
        } catch (
                Exception ex) {
            ShowError(sErrorTitel, "Er is een fout opgetreden bij het meegeven van soort.");
            System.out.println(ex);
        }
        //Controle op variant
        try {
            if (txtVariantTv.getText().length() > 0) {
                sVariant = txtVariantTv.getText();
            } else {
                sVariant = "";
            }
        } catch (
                Exception ex) {
            ShowError(sErrorTitel, "Er is een fout opgetreden bij het meegeven van variant.");
            System.out.println(ex);
        }
        try {
            sFgsv = sFamilie + " " + sGeslacht + " " + sSoort + " " + sVariant;
        } catch (
                Exception ex) {
            ShowError(sErrorTitel, "Er is een fout opgetreden bij het meegeven van fgsv.");
            System.out.println(ex);
        }

        //Controle op plantdischtheid
        //Controle op minimum plantdichtheid
        try {
            //
            if (txtDichtheidXTv.getText().length() == 0 )
            {ix = 0;}
            else
            {ix = Integer.parseInt(txtDichtheidXTv.getText());}


        } catch (
                NumberFormatException nex) {
            ShowError(sErrorTitel, "Gelieve een getal in te geven bij X.");
            throw new Exception(nex);
        } catch (
                Exception ex) {
            ShowError(sErrorTitel, "Er is een fout opgetreden bij het meegeven X.");
            System.out.println(ex);
            throw new Exception(ex);
        }
        //Controle op maximum plantdichtheid
        try {
            if (txtDichtheidYTv.getText().length() == 0)
            {iy = 0;}
            else
            {iy = Integer.parseInt(txtDichtheidYTv.getText());}

        } catch (
                NumberFormatException nex) {
            ShowError(sErrorTitel, "Gelieve een getal in te geven bij Y.");
            throw new Exception(nex);

        } catch (
                Exception ex) {
            ShowError(sErrorTitel, "Er is een fout opgetreden bij het meegeven van Y.");
            System.out.println(ex);
            throw new Exception(ex);
        }
        //Controle of X < Y
        try {
            if (ix > iy) {
                throw new Exception();
            }
        } catch (Exception ex) {
            ShowError(sErrorTitel, "X moet kleiner zijn dan Y.");
            throw new Exception(ex);
        }

        //Controle of plantnaam al bestaat
        int iDubbeleNaam = naamDAO.ControleDubbeleNaam(plantTest);
        try {
            //als plant nog niet bestaat, plant toevoegen
            if (iDubbeleNaam == 0) {
                System.out.println(iDubbeleNaam + " is iDubbelenaam");
                //Toevoegen plant docent/admin
                if (srolGebruiker.equals("admin") || srolGebruiker.equals("docent")) {
                    System.out.println("plaa,t aangemaakt");
                    iStatus = 2;
                    Plant plant = new Plant(plantid, sPlanttype, sFamilie, sGeslacht, sSoort, sVariant, ix, iy, sFgsv,iStatus,iGebruikerID);
                    plantss.add(plant);
                }
                //Toevoegen plant als leerling/gast
                else {
                    System.out.println("plant aangemaakt");
                    iStatus = 1;
                    Plant plant = new Plant(plantid, sPlanttype, sFamilie, sGeslacht, sSoort, sVariant, ix, iy, sFgsv,iStatus,iGebruikerID);
                    plantss.add(plant);
                }
            }
            //Als plant bestaat waarschuwing geven
            else {
                throw new ExceptionInInitializerError();

            }
        } catch (Exception ex) {
            ShowError(sErrorTitel, "Het toevoegen van plant is niet gelukt.");
            throw new Exception();
        } catch (ExceptionInInitializerError exI)
        {
            ShowError(sErrorTitel, "Deze plant bestaat al.");
            throw new Exception();
        }


    }
    //
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
        if (rbStrategieTopTv.isSelected()) {
            return "C";
        } else if (rbStrategieMMTv.isSelected()) {
            return "C-S-R";
        } else if (rbStrategieLMTv.isSelected()) {
            return "C-R";
        } else if (rbStrategieRMTv.isSelected()) {
            return "C-S";
        } else if (rbStrategieLOTv.isSelected()) {
            return "R";
        } else if (rbStrategieMOTv.isSelected()) {
            return "S-R";
        } else if (rbStrategieROTv.isSelected()) {
            return "S";
        }
        else {
            return "";
        }
    }
    public void createExtra() throws SQLException {
        //kan pas volledig gedaan worden wanneer er de kwestie van de eetbaar/kruidgebruik splitsing opgelost is
        int valueNectarwaarde = Integer.parseInt(NectarwaardeValueTv.getText());
        int valuePollenwaarde = Integer.parseInt(PollenValueTv.getText());
        ExtraDAO extraDAO = new ExtraDAO(dbConnection);
        int maxidextra = extraDAO.getmaxid();
        maxidextra++;
        System.out.println(maxidextra);
        System.out.println(valuePollenwaarde + " " + valueNectarwaarde);
        Extra extra = new Extra(maxidextra, plantid, valueNectarwaarde, valuePollenwaarde, bijvriendelijkCheck(), eetbaarCheck(), kruidgebruikCheck(), geurendCheck(), vorstgevoeligCheck(),vlindervriendelijkCheck());
        //deze fout van createExtra komt uit extraDAO omdat het niet zeker is hoe eetbaar en kruidgebruik uit de databank gehaald moeten worden
        extrass.add(extra);
        //ExtraDAO.createExtra(extra);
    }
    public String vlindervriendelijkCheck() {
        if(rbVlindervriendelijkJaTv.isSelected()) {
            return "ja";
        }
        else if (rbVlindervriendelijkNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "";
        }
    }
    public String vorstgevoeligCheck() {
        if (rbVorstgevoeligJaTv.isSelected()) {
            return "ja";
        } else if (rbVorstgevoeligNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "";
        }
    }
    public String eetbaarCheck() {
        if (rbEetbaarJaTv.isSelected()) {
            return "ja";
        } else if (rbEetbaarNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "";
        }
    }
    public String geurendCheck() {
        if (rbGeurendJaTv.isSelected()) {
            return "ja";
        } else if (rbGeurendNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "";
        }
    }
    public String kruidgebruikCheck() {
        if (rbKruidgebruikJaTv.isSelected()) {
            return "ja";
        } else if (rbKruidgebruikNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "";
        }
    }
    public String bijvriendelijkCheck() {
        if (rbBijvriendelijkJaTv.isSelected()) {
            return "ja";
        } else if (rbBijvriendelijkNeeTv.isSelected()) {
            return "nee";
        }
        else {
            return "";
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
            CommMulti_Eigenschap commensalisme = new CommMulti_Eigenschap("levensduur", lvLevensduurTv.getItems().get(i), plantid);
            commMulti_eigenschapss.add(commensalisme);
            aantalCommMulti++;
        }


        //Toevoegen van sociabiliteit
        if (chkSociabiliteit1Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "1", plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        if (chkSociabiliteit2Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "2", plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        if (chkSociabiliteit3Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "3", plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        if (chkSociabiliteit4Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "4", plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        if (chkSociabiliteit5Tv.isSelected()) {
            CommMulti_Eigenschap sociabiliteit = new CommMulti_Eigenschap("sociabiliteit", "5", plantid);
            System.out.println(sociabiliteit.getNaam());
            commMulti_eigenschapss.add(sociabiliteit);
            aantalCommMulti++;
        }
        AantalPerElCommMulti.add(aantalCommMulti);
    }
    public void createFoto() throws SQLException {
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
        String naam = "bladhoogte";
        System.out.println();
        ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschaps = new ArrayList<>();
        FenoMulti_Eigenschap bladhoogte = new FenoMulti_Eigenschap(maxid, "Bladhoogte", spinMaxBladhJanTv.getValue().toString(), spinMaxBladhFebTv.getValue().toString(), spinMaxBladhMaaTv.getValue().toString(), spinMaxBladhAprTv.getValue().toString(), spinMaxBladhMeiTv.getValue().toString(), spinMaxBladhJunTv.getValue().toString(), spinMaxBladhJulTv.getValue().toString(), spinMaxBladhAugTv.getValue().toString(), spinMaxBladhSeptTv.getValue().toString(), spinMaxBladhOktTv.getValue().toString(), spinMaxBladhNovTv.getValue().toString(), spinMaxBladhDecTv.getValue().toString());
        maxid++;
        FenoMulti_Eigenschap bladkleur = new FenoMulti_Eigenschap(maxid, "Bladkleur", comboboxCheckString(cbBladkleurJanTv.getSelectionModel()), comboboxCheckString(cbBladkleurFebTv.getSelectionModel()), comboboxCheckString(cbBladkleurMaaTv.getSelectionModel()), comboboxCheckString(cbBladkleurAprTv.getSelectionModel()), comboboxCheckString(cbBladkleurMeiTv.getSelectionModel()), comboboxCheckString(cbBladkleurJunTv.getSelectionModel()), comboboxCheckString(cbBladkleurJulTv.getSelectionModel()), comboboxCheckString(cbBladkleurAugTv.getSelectionModel()), comboboxCheckString(cbBladkleurSeptTv.getSelectionModel()), comboboxCheckString(cbBladkleurOktTv.getSelectionModel()), comboboxCheckString(cbBladkleurNovTv.getSelectionModel()), comboboxCheckString(cbBladkleurDecTv.getSelectionModel()));
        maxid++;
        FenoMulti_Eigenschap minbloeihoogte = new FenoMulti_Eigenschap(maxid, "Min Bloeihoogte", spinMinBloeihJanTv.getValue().toString(), spinMinBloeihFebTv.getValue().toString(), spinMinBloeihMaaTv.getValue().toString(), spinMinBloeihAprTv.getValue().toString(), spinMinBloeihMeiTv.getValue().toString(), spinMinBloeihJunTv.getValue().toString(), spinMinBloeihJulTv.getValue().toString(), spinMinBloeihAugTv.getValue().toString(), spinMaxBloeihSeptTv.getValue().toString(), spinMinBloeihOktTv.getValue().toString(), spinMinBloeihNovTv.getValue().toString(), spinMinBloeihDecTv.getValue().toString());
        maxid++;
        FenoMulti_Eigenschap maxbloeihoogte = new FenoMulti_Eigenschap(maxid, "Max Bloeihoogte", spinMaxBloeihJanTv.getValue().toString(), spinMaxBloeihFebTv.getValue().toString(), spinMaxBladhMaaTv.getValue().toString(), spinMaxBloeihAprTv.getValue().toString(), spinMaxBloeihMeiTv.getValue().toString(), spinMaxBloeihJunTv.getValue().toString(), spinMaxBloeihJulTv.getValue().toString(), spinMaxBloeihAugTv.getValue().toString(), spinMaxBloeihSeptTv.getValue().toString(), spinMaxBloeihOktTv.getValue().toString(), spinMaxBloeihNovTv.getValue().toString(), spinMaxBloeihDecTv.getValue().toString());
        maxid++;
        FenoMulti_Eigenschap bloeikleur = new FenoMulti_Eigenschap(maxid, "Bloeikleur", comboboxCheckString(cbBloeikleurJanTv.getSelectionModel()), comboboxCheckString(cbBloeikleurFebTv.getSelectionModel()), comboboxCheckString(cbBloeikleurMaaTv.getSelectionModel()), comboboxCheckString(cbBloeikleurAprTv.getSelectionModel()), comboboxCheckString(cbBloeikleurMeiTv.getSelectionModel()), comboboxCheckString(cbBloeikleurJunTv.getSelectionModel()), comboboxCheckString(cbBloeikleurJulTv.getSelectionModel()), comboboxCheckString(cbBloeikleurAugTv.getSelectionModel()), comboboxCheckString(cbBloeikleurSeptTv.getSelectionModel()), comboboxCheckString(cbBloeikleurOktTv.getSelectionModel()), comboboxCheckString(cbBloeikleurNovTv.getSelectionModel()), comboboxCheckString(cbBloeikleurDecTv.getSelectionModel()));
        fenoMulti_eigenschaps.add(bladhoogte);
        fenoMulti_eigenschaps.add(bladkleur);
        fenoMulti_eigenschaps.add(minbloeihoogte);
        fenoMulti_eigenschaps.add(maxbloeihoogte);
        fenoMulti_eigenschaps.add(bloeikleur);
        for (int i = 0; i < 5; i++) {
            FenoMulti_Eigenschap fenoMulti_eigenschap = new FenoMulti_Eigenschap(fenoMulti_eigenschaps.get(i).getId(), fenoMulti_eigenschaps.get(i).getNaam(), fenoMulti_eigenschaps.get(i).getJan(), fenoMulti_eigenschaps.get(i).getFeb(), fenoMulti_eigenschaps.get(i).getMaa(), fenoMulti_eigenschaps.get(i).getApr(), fenoMulti_eigenschaps.get(i).getMei(), fenoMulti_eigenschaps.get(i).getJun(), fenoMulti_eigenschaps.get(i).getJul(), fenoMulti_eigenschaps.get(i).getAug(), fenoMulti_eigenschaps.get(i).getSep(), fenoMulti_eigenschaps.get(i).getOkt(), fenoMulti_eigenschaps.get(i).getNov(), fenoMulti_eigenschaps.get(i).getDec());
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
        plantDAO.createplant(plant,0,iGebruikerID);
        abiotischeFactorenDAO.CreateAbiostische(abiotischeFactoren);
        fenotypeDAO.createfenotype(fenotype);
        for (int j = 0; j < fenoMulti_eigenschaps.size(); j++) {
            fenotypeDAO.createfenomulti(fenoMulti_eigenschaps.get(j), plant.getId());
        }
        for (int f = 0; f < abiottisschemulti_eigenschaps.size(); f++) {
            abiotischeMultidao.CreateAbiotischeMulti(abiottisschemulti_eigenschaps.get(f), plantid);
        }
        commensalismeDAO.createCommensalisme(commensalisme);
        for (int m = 0; m < commMulti_eigenschaps.size(); m++) {
            commensalismeDAO.createCommensalismeMulti(commMulti_eigenschaps.get(m));
        }
        for (int a = 0; a < beheerdaad_eigenschaps.size(); a++) {
            beheerDAO.createBeheer(beheerdaad_eigenschaps.get(a), plant.getId());
        }
        extraDAO.createExtra(extra);
    }
    public void createNaam() throws SQLException {
        NaamDao naamDAO = new NaamDao(dbConnection);

        Plant plant = new Plant(sPlanttype, sFamilie, sGeslacht, sSoort, sVariant);


        //Controle of plantnaam al bestaat gebeurd al in createplant
        int iDubbeleNaam = naamDAO.ControleDubbeleNaam(plant);
        if (iDubbeleNaam == 0) {
            naamDAO.createNaam(plant);
        } else {
            ShowError("Error bij toevoegen plant", "Deze plant bestaat al.");
        }
    }
    public void ShowError(String sTitel, String sMessage) {
        //tonen van error
        JOptionPane.showMessageDialog(null, sMessage, "InfoBox: " + sTitel, JOptionPane.INFORMATION_MESSAGE);

    }
    public void click_verwijderenHabitat(MouseEvent mouseEvent) {
        final int selectedIndex = lvHabitatTv.getSelectionModel().getSelectedIndex();
        lvHabitatTv.getItems().remove(selectedIndex);
    }
    public void click_verwijderenLevensduur(MouseEvent mouseEvent) {
        final int selectedIndex = lvLevensduurTv.getSelectionModel().getSelectedIndex();
        lvLevensduurTv.getItems().remove(selectedIndex);
    }
}

