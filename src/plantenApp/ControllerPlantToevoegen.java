package plantenApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import plantenApp.java.dao.AbiotischeFactorenDAO;
import plantenApp.java.dao.Database;
import plantenApp.java.dao.FenotypeDAO;
import plantenApp.java.dao.PlantDAO;
import plantenApp.java.model.AbiotischeFactoren;
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
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        //String bezonning = valuebezonning();
        int maxidabio = abiotischeFactorenDAO.getmaxid();
        AbiotischeFactoren abiotischeFactoren = new AbiotischeFactoren(maxidabio+1,plantid, "tt","ee ", "nat","frietjes","hey kasper");
        abiotischeFactorenDAO.CreateAbiostische(abiotischeFactoren);
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
