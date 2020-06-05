package plantenApp.java.dao;

import plantenApp.java.model.CommMulti_Eigenschap;
import plantenApp.java.model.Commensalisme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**@author Siebe*/
public class CommensalismeDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectCommeByID;
    private PreparedStatement stmtSelectCommeMultiByID;
    private PreparedStatement stmtSelectIdsByComm;
    private PreparedStatement stmtSelectIdsByCommMulti;
    private  PreparedStatement stmGetMaxID;
    private PreparedStatement stmInsertCommensalisme;
    private PreparedStatement stmInsertCommensalismeMulti;

    public CommensalismeDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;

        stmtSelectCommeByID = dbConnection.prepareStatement(GETCOMMENSALISMEBYPLANTID);
        stmtSelectCommeMultiByID = dbConnection.prepareStatement(GETCOMMENSALISMEMULTIBYPLANTID);
        stmtSelectIdsByComm = dbConnection.prepareStatement(GETIDSBYCOMM);
        stmtSelectIdsByCommMulti = dbConnection.prepareStatement(GETIDSBYCOMMMULTI);
        stmInsertCommensalisme = dbConnection.prepareStatement(InsertCommensalisme);
        stmInsertCommensalismeMulti = dbConnection.prepareStatement(InsertCommensalismeMulti);
        stmGetMaxID = dbConnection.prepareStatement(getMaxCommensalismeID);
    }

    //region GET

    /**
     * @author Siebe
     * @param id -> plant_id
     * @return alle abiotische factoren van de specifieke plant
     */
    public Commensalisme getById(int id) throws SQLException {
        //Dao

        //Items
        Commensalisme comm = null;

        //SqlCommand
        stmtSelectCommeByID.setInt(1, id);
        ResultSet rs = stmtSelectCommeByID.executeQuery();
        if (rs.next()) {
            comm = new Commensalisme(
                    rs.getInt("commensialisme_id"),
                    rs.getInt("plant_id"),
                    rs.getString("strategie"),
                    rs.getString("ontwikkelingssnelheid"),
                    getByIdMulti(id)
            );
        }

        //Output
        return comm;
    }

    /**
     * @author Siebe
     * word alleen gebruikt in getById
     * @param id -> plant_id
     * @return -> alle commensalisme_multi van de specifieke plant
     */
    private ArrayList<CommMulti_Eigenschap> getByIdMulti(int id) throws SQLException {
        //Dao

        //Items
        ArrayList<CommMulti_Eigenschap> commMulti = new ArrayList<>();

        //SqlCommand
        stmtSelectCommeMultiByID.setInt(1, id);
        ResultSet rs = stmtSelectCommeMultiByID.executeQuery();
        while (rs.next()) {
            CommMulti_Eigenschap commEigenschap = new CommMulti_Eigenschap(
                    //rs.getInt("commensialisme_id"),
                    rs.getString("eigenschap"),
                    rs.getString("waarde")
            );
            commMulti.add(commEigenschap);
        }

        //Output
        return commMulti;
    }

    public void createCommensalisme(Commensalisme commensalisme) throws SQLException {
        System.out.println("test");
        stmInsertCommensalisme.setInt(1, commensalisme.getId());
        stmInsertCommensalisme.setInt(2, commensalisme.getPlant_id());
        stmInsertCommensalisme.setString(3, commensalisme.getStrategie());
        stmInsertCommensalisme.setString(4, commensalisme.getOntwikkelingssnelheid());
        stmInsertCommensalisme.executeUpdate();
        System.out.println("testttt");
        System.out.println("Commensalisme toegevoegd");
    }
    public void createCommensalismeMulti(CommMulti_Eigenschap commensalismeMulti,int plantID) throws SQLException {
        stmInsertCommensalismeMulti.setInt(1, plantID);
        stmInsertCommensalismeMulti.setString(2,commensalismeMulti.getNaam());
        stmInsertCommensalismeMulti.setString(3, commensalismeMulti.getValue());
        stmInsertCommensalismeMulti.executeUpdate();
        System.out.println("Commensalisme Multi toegevoegd");
    }

    public int getmaxid() throws SQLException {
        ResultSet rs =stmGetMaxID.executeQuery();
        rs.next();
        int maxid =rs.getInt(1) ;
        return maxid;
    }



    //endregion
}

