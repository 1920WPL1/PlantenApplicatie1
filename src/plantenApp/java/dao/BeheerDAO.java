package plantenApp.java.dao;

import plantenApp.java.model.Beheer;
import plantenApp.java.model.Beheerdaad_Eigenschap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**@author Siebe*/
public class BeheerDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectBeheerByID;
    private PreparedStatement stmtSelectByBeheer;
    private  PreparedStatement stmGetMaxID;
    private PreparedStatement stmInsertBeheer;
    private  PreparedStatement stmselectall;
    private PreparedStatement stmInsertbeheerdaad;

    public BeheerDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;

        stmtSelectBeheerByID = dbConnection.prepareStatement(GETBEHEERBYPLANTID);
        stmtSelectByBeheer = dbConnection.prepareStatement(GETIDSBYBEHEER);
        stmInsertBeheer = dbConnection.prepareStatement(insertBeheer);
        stmGetMaxID = dbConnection.prepareStatement(getMaxBeheerID);
        stmselectall = dbConnection.prepareStatement(allebheerdaden);
        stmInsertbeheerdaad = dbConnection.prepareStatement(insertbeheerdaden);
    }

    //region GET

    /**
     * @author Siebe
     * @param id -> plant_id
     * @return -> beheer van de specifieke plant
     */
    public Beheer getById(int id) throws SQLException {
        //Dao

        //Items
        Beheer beheer = null;

        //SqlCommand
        beheer = new Beheer(
                id,
                getBeheerdaden(id)
        );

        //Output
        return beheer;
    }

    /**
     * @author Siebe
     * word alleen gebruikt in getById
     * @param id -> plant_id
     * @return -> alle beheerdaden van de specifieke plant
     */
    private ArrayList<Beheerdaad_Eigenschap> getBeheerdaden(int id) throws SQLException {
        //Dao

        //Items
        ArrayList<Beheerdaad_Eigenschap> abioMulti = new ArrayList<>();

        //SqlCommand
        stmtSelectBeheerByID.setInt(1, id);
        ResultSet rs = stmtSelectBeheerByID.executeQuery();
        while (rs.next()) {
            Beheerdaad_Eigenschap beheerdaad = new Beheerdaad_Eigenschap(
                    rs.getInt("beheer_id"),
                    rs.getString("beheerdaad"),
                    rs.getString("opmerking"),
                    rs.getString("maand"),
                    rs.getInt("frequentie_jaar")
            );
            abioMulti.add(beheerdaad);
        }

        //Output
        return abioMulti;
    }
    public ArrayList<String> getalbeheerdaden() throws SQLException {
        //Dao

        //Items
        ArrayList<String> beheerdaaden = new ArrayList<>();

        //SqlCommand

        ResultSet rs = stmselectall.executeQuery();
        while (rs.next()) {
                String test = rs.getString("waarde");

            beheerdaaden.add(test);
        }

        //Output
        return beheerdaaden;
    }

    public void createBeheer(Beheerdaad_Eigenschap beheerdaad, Beheer beheer) throws SQLException {
        stmInsertBeheer.setInt(1, beheerdaad.getId());
        stmInsertBeheer.setInt(2, beheer.getPlant_id());
        stmInsertBeheer.setString(3, beheerdaad.getNaam());
        stmInsertBeheer.setString(4, beheerdaad.getOpmerking());
        stmInsertBeheer.setString(5, beheerdaad.getMaand());
        stmInsertBeheer.setInt(6, beheerdaad.getFrequentie());
        stmInsertBeheer.executeUpdate();
        System.out.println("Beheer toegevoegd");
    }
    public void createbeheerdaad(String waarde) throws SQLException {
        stmInsertbeheerdaad.setString(1, waarde);
        stmInsertbeheerdaad.executeUpdate();
        System.out.println("Beheerdaad toegevoegd");
    }

    public int getmaxid() throws SQLException {
        ResultSet rs =stmGetMaxID.executeQuery();
        rs.next();
        int maxid =rs.getInt(1) ;
        return maxid;
    }

    //endregion
}
