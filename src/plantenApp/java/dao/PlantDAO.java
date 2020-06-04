package plantenApp.java.dao;

import plantenApp.java.model.Plant;
import plantenApp.java.utils.DaoUtils;

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
    private PreparedStatement stmtInsert;
    private PreparedStatement stmgetmaxid;
    private PreparedStatement stmtSelectIdsByPlant;
    private PreparedStatement stmtSelectByIds;


    public PlantDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;

        stmtSelectById = dbConnection.prepareStatement(GETPLANTBYID);
        stmtSelectByPlant = dbConnection.prepareStatement(GETIDSBYPLANT);
        stmtInsert = dbConnection.prepareStatement(Insertplant);
        stmgetmaxid = dbConnection.prepareStatement(getmaxplantid);
        stmtSelectByIds = dbConnection.prepareStatement(GETPLANTSBYIDS);
        stmtSelectIdsByPlant = dbConnection.prepareStatement(GETIDSBYPLANT);
    }

    //region GET

    /**
     * @param plantIds -> plant_ids
     * @return -> alleen de basis gegevens van een plant
     * @author Siebe
     */
    public ArrayList<Plant> GetPlantList(ArrayList<Integer> plantIds) throws SQLException {
        //Dao

        //Items
        String sPlantIds = DaoUtils.sqlFormatedList(plantIds);
        ArrayList<Plant> plants = new ArrayList<>();

        //SqlCommand
        stmtSelectByIds.setString(1, sPlantIds);
        ResultSet rs = stmtSelectByIds.executeQuery();
        while (rs.next()) {
            plants.add(new Plant(
                    rs.getInt("plant_id"),
                    rs.getString("type"),
                    rs.getString("familie"),
                    rs.getString("geslacht"),
                    rs.getString("soort"),
                    rs.getString("variatie"),
                    rs.getInt("plantdichtheid_min"),
                    rs.getInt("plantdichtheid_max"),
                    rs.getInt("status")
            ));
        }

        //Output
        return plants;
    }

    /**
     * @param id -> plant_id
     * @return -> alleen de basis gegevens van een plant
     * @author Siebe
     */
    public Plant getPlantById(int id) throws SQLException {
        //Dao

        //Items
        Plant plant = null;

        //SqlCommand
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
                    rs.getInt("plantdichtheid_max"),
                    rs.getString("fgsv"),
                    rs.getInt("status")
            );
        }

        //Output
        return plant;
    }

    /**
     * @param id -> plant_id
     * @return -> alles van een Plant
     * @author Siebe
     */
    public Plant getFullPlantById(int id) throws SQLException {
        //Dao
        AbiotischeFactorenDAO abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        CommensalismeDAO commensalismeDAO = new CommensalismeDAO(dbConnection);
        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        ExtraDAO extraDAO = new ExtraDAO(dbConnection);
        FotoDAO fotoDAO = new FotoDAO(dbConnection);

        //Items
        Plant plant = null;

        //SqlCommand
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
                    rs.getInt("plantdichtheid_max"),
                    fotoDAO.getFotoById(id),
                    beheerDAO.getById(id),
                    abiotischeFactorenDAO.getById(id),
                    commensalismeDAO.getById(id),
                    fenotypeDAO.getById(id),
                    extraDAO.getExtraById(id)
            );
        }

        //Output
        return plant;
    }
    public void createplant(Plant plant) throws SQLException {
        stmtInsert.setInt(1,plant.getId());
        stmtInsert.setString(2, plant.getType());
        stmtInsert.setString(3,plant.getFamilie());
        stmtInsert.setString(4,plant.getGeslacht());
        stmtInsert.setString(5,plant.getSoort());
        stmtInsert.setString(6,plant.getVariatie());
        stmtInsert.setInt(7,plant.getMinPlantdichtheid());
        stmtInsert.setInt(8,plant.getMaxPlantdichtheid());
        stmtInsert.setString(9,plant.getFgsv());
        stmtInsert.setInt(10,plant.getStatus());

        stmtInsert.executeUpdate();
        System.out.println("gelukt plant toegevoegd");
    }
    public int getmaxid() throws SQLException {
        ResultSet rs =stmgetmaxid.executeQuery();
        rs.next();
        int maxid =rs.getInt(1) ;
        return maxid;
    }

}
