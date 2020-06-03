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
    public Slider slBezonningTv;
    public Slider slVoedingsbehoefteTv;
    public Slider slVochtbehoefteTv;
    public ComboBox cbReactieAntaTv;
    public ComboBox cbGrondsoortTv;
    public ComboBox cbHabitatTv;
    public Button btnHabitatTv;
    public ListView lvHabitatTv;
    public Label VoedingbehoefteValueTv;
    public Label VochtbehoefteValueTv;
    public Label BezonningvalueTv;
    private Connection dbConnection;
    private AbiotischeFactorenDAO abiotischeFactorenDAO;
    private int plantid;

    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
        slVoedingsbehoefteTv.addEventHandler(MouseEvent.MOUSE_DRAGGED , this::Voedingsbehoeftelabelveranderen);
        slVochtbehoefteTv.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::Vochtbehoeftelabelveranderen);
        slBezonningTv.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::Bzonninglabelveranderen);
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
        cbGrondsoortTv.setItems(cbGrondsoortOptions);
        cbReactieAntaTv.setItems(cbReactieAntaOptions);



    }
    public void Clicked_PlantToevoegen(MouseEvent mouseEvent) throws SQLException {
        createplant();
        createAbiotischefactoren();
        createfenotype();
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
        if(slBezonningTv.getValue() <1)
        {
            value="schaduw Plant";
        }
        else if (slBezonningTv.getValue() <2 && slBezonningTv.getValue()>1)
        {
            value ="zonnige plant";
        }
        else if(slBezonningTv.getValue()>2 )
        {
            value ="Volle zon plant";
        }
        return value;
    }
    private void Voedingsbehoeftelabelveranderen(MouseEvent e) {
        VoedingbehoefteValueTv.setText(String.valueOf(slVoedingsbehoefteTv.getValue()));
    }
    private  void Vochtbehoeftelabelveranderen(MouseEvent e)
    {
        VochtbehoefteValueTv.setText(String.valueOf(slVochtbehoefteTv.getValue()));
    }
    private  void Bzonninglabelveranderen(MouseEvent e)
    {
        BezonningvalueTv.setText(String.valueOf(slBezonningTv.getValue()));
    }
}
