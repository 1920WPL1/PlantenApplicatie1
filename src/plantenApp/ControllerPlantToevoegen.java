package plantenApp;

import javafx.scene.control.ComboBox;
import plantenApp.java.dao.Database;
import plantenApp.java.dao.InfoTablesDAO;
import plantenApp.java.model.InfoTables;

import java.sql.Connection;
import java.sql.SQLException;


public class ControllerPlantToevoegen {
    private InfoTables infoTables;
    private Connection dbConnection;
    public ComboBox<String> cboType;
    public ComboBox cboFamilie;

    public void initialize() throws SQLException {

        dbConnection = Database.getInstance().getConnection();



        /*infotabel object aanmaken*/
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        infoTables = infotablesDAO.getInfoTables();

        /*comboboxes vullen*/
        //FillComboboxes(infoTables);
    }

    /*
    private void FillComboboxes(InfoTables infotables) {

        //type
        System.out.println(infotables.getTypes().toString());
        cboType.getItems().addAll(infotables.getTypes());

    }
    */

}
