package plantenApp;

import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import plantenApp.java.dao.AbiotischeFactorenDAO;
import plantenApp.java.dao.Database;
import plantenApp.java.model.AbiotischeFactoren;

import java.sql.Connection;
import java.sql.SQLException;

public class ControllerPlantToevoegen {
    public Slider slBezonning;
    private Connection dbConnection;
    private AbiotischeFactorenDAO abiotischeFactorenDAO;

    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
    }

    public void Clicked_PlantToevoegen(MouseEvent mouseEvent) throws SQLException {
        createAbiotischefactoren();
    }
    public void createAbiotischefactoren() throws SQLException {
        int bezonning =  ;
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        /*plant id moet een cijfer zijn dat gekregen wordt als de plant in de database zit.*/
        AbiotischeFactoren abiotischeFactoren = new AbiotischeFactoren(0,2, bezonning,)

    }
}
