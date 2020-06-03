package plantenApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import plantenApp.java.dao.*;
import plantenApp.java.model.AbiotischeFactoren;
import plantenApp.java.model.Extra;
import plantenApp.java.model.Fenotype;
import plantenApp.java.model.Plant;

import java.sql.Connection;
import java.sql.SQLException;

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
    public Slider slBezonningTv;
    public Label BezonningvalueTv;
    public Slider slVoedingsbehoefteTv;
    public Label VoedingbehoefteValueTv;
    public Slider slVochtbehoefteTv;
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

    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
        slVoedingsbehoefte.addEventHandler(MouseEvent.MOUSE_DRAGGED , this::Voedingsbehoeftelabelveranderen);
        slVochtbehoefte.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::Vochtbehoeftelabelveranderen);
        slBezonning.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::Bzonninglabelveranderen);
        combovullen();

    }

    public void combovullen()
    {
//Opties voor reactie antagonistische omgeving
        ObservableList<String> cbReactieAntaOptions =
                FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3"
                );
//Opties voor grondsoort
        ObservableList<String> cbGrondsoortOptions =
                FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3"
                );
//Values zetten
        cbGrondsoort.setItems(cbGrondsoortOptions);
        cbReactieAnta.setItems(cbReactieAntaOptions);



    }
    public void Clicked_PlantToevoegen(MouseEvent mouseEvent) throws SQLException {
        createplant();
        createAbiotischefactoren();
        createfenotype();
    }
    public void createfenotype() throws SQLException {
        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        int maxid = fenotypeDAO.getmaxid();
        Fenotype fenotype = new Fenotype(maxid+1,plantid,"bladvorm","levensvorm","habitus","bloeiwijze",8,"ratioBloeiBlad","spruitfenologie");
    }
    public void createplant() throws SQLException {
        PlantDAO plantDAO = new PlantDAO(dbConnection);
        int maxidplant = plantDAO.getmaxid();
        plantid = maxidplant;
            //public Plant(int id, String type, String familie, String geslacht, String soort, String variatie, int minPlantdichtheid, int maxPlantdichtheid, String fgsv) {
            Plant plant = new Plant(maxidplant+1 ,"test", "familie","geslacht","soort","variatie",5,20,"familie geslacht soort van" );
        plantDAO.createplant(plant);
    }

    public void createAbiotischefactoren() throws SQLException {
        AbiotischeFactorenDAO abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        //String bezonning = valuebezonning();
        int maxidabio = abiotischeFactorenDAO.getmaxid();
        AbiotischeFactoren abiotischeFactoren = new AbiotischeFactoren(maxidabio+1,plantid, "tt","ee ", "nat","frietjes","hey kasper");
        abiotischeFactorenDAO.CreateAbiostische(abiotischeFactoren);
    }

    public void createExtra() throws SQLException{
        ExtraDAO extraDAO = new ExtraDAO((dbConnection);
        int maxidextra = extraDAO.getmaxid();
        Extra extra = new Extra(maxidextra+1,plantid,0,0,"a","b","c","d","e");
        //deze fout van createExtra komt uit extraDAO omdat het niet zeker is hoe eetbaar en kruidgebruik uit de databank gehaald moeten worden
        ExtraDAO.createExtra(extra);
    }

    public  String valuebezonning()
    {
        String value="";
        if(slBezonning.getValue() <1)
        {
            value="schaduw Plant";
        }
        else if (slBezonning.getValue() <2 && slBezonning.getValue()>1)
        {
            value ="zonnige plant";
        }
        else if(slBezonning.getValue()>2 )
        {
            value ="Volle zon plant";
        }
        return value;
    }
    private void Voedingsbehoeftelabelveranderen(MouseEvent e) {
        VoedingbehoefteValue.setText(String.valueOf(slVoedingsbehoefte.getValue()));
    }
    private  void Vochtbehoeftelabelveranderen(MouseEvent e)
    {
        VochtbehoefteValue.setText(String.valueOf(slVochtbehoefte.getValue()));
    }
    private  void Bzonninglabelveranderen(MouseEvent e)
    {
        Bezonningvalue.setText(String.valueOf(slBezonning.getValue()));
    }
}
