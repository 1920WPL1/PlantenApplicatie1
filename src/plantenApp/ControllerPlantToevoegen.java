package plantenApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import plantenApp.java.dao.AbiotischeFactorenDAO;
import plantenApp.java.dao.Database;
import plantenApp.java.model.AbiotischeFactoren;

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
        createAbiotischefactoren();
    }
    public void createAbiotischefactoren() throws SQLException {
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        String bezonning = valuebezonning();

        /*plant id moet een cijfer zijn dat gekregen wordt als de plant in de database zit.*/
        //AbiotischeFactoren abiotischeFactoren = new AbiotischeFactoren(0,2, bezonning,);
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
