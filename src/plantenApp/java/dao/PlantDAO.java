package plantenApp.java.dao;

import plantenApp.java.model.Plant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**@author Siebe*/
public class PlantDAO implements Queries {

    private Connection dbConnection;
    private PreparedStatement stmtSelectById;
    private PreparedStatement stmtSelectByPlant;

    public PlantDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectById = dbConnection.prepareStatement(GETPLANTBYID);
        stmtSelectByPlant = dbConnection.prepareStatement(GETIDSBYPLANT);
    }

    /**@author Siebe
     * @param id -> plant_id
     * @return -> alle basis factoren van de specifieke plant
     */
    public Plant getPlantById(int id) throws SQLException {
        Plant plant = null;

        stmtSelectById.setInt(1, id);
        ResultSet rs = stmtSelectById.executeQuery();
        if (rs.next()) {
            plant = new Plant(
                    rs.getInt("plant_id"),
                    rs.getString("type"),
                    rs.getString("familie"),
                    rs.getString("geslacht"),
                    rs.getString("soort"),
                    rs.getString("variatie"),
                    rs.getInt("plantdichtheid_min"),
                    rs.getInt("plantdichtheid_max")
            );
        }
        return plant;
    }



}
