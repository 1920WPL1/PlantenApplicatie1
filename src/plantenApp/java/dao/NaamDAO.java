package plantenApp.java.dao;
import plantenApp.java.model.Plant;
import plantenApp.java.utils.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NaamDAO implements Queries {

    private Connection dbConnection;
    private PreparedStatement stmtSelectTypeId;
    private PreparedStatement stmtSelectDubbeleNaam;
    private PreparedStatement stmtInsertInFamilie;
    private PreparedStatement stmtSelectFamilieId;
    private PreparedStatement stmtInsertInGeslacht;
    private PreparedStatement stmtSelectGeslachtId;
    private PreparedStatement stmtInsertInSoort;
    private PreparedStatement stmtSelectSoortId;
    private PreparedStatement stmtInsertInVariatie;


    public NaamDAO(Connection dbConnection) throws SQLException {

        this.dbConnection = dbConnection;
        stmtSelectDubbeleNaam = dbConnection.prepareStatement(SelectDubbeleNaam);;
        stmtSelectTypeId = dbConnection.prepareStatement(SelectTypeID);
        stmtInsertInFamilie= dbConnection.prepareStatement(InsertFamilie);
        stmtSelectFamilieId = dbConnection.prepareStatement(SelectFamilieID);
        stmtInsertInGeslacht= dbConnection.prepareStatement(InsertGeslacht);
        stmtSelectGeslachtId = dbConnection.prepareStatement(SelectGeslachtID);
        stmtInsertInSoort = dbConnection.prepareStatement(InsertSoort);
        stmtSelectSoortId = dbConnection.prepareStatement(SelectSoortID);
        stmtInsertInVariatie = dbConnection.prepareStatement(InsertVariatie);

    }
    public Integer ControleDubbeleNaam(Plant plant) throws SQLException {

        stmtSelectDubbeleNaam.setString(1,plant.getType());
        stmtSelectDubbeleNaam.setString(2,plant.getFamilie());
        stmtSelectDubbeleNaam.setString(3,plant.getGeslacht());
        stmtSelectDubbeleNaam.setString(4,plant.getSoort());
        stmtSelectDubbeleNaam.setString(5,plant.getVariatie());
        ResultSet rsControleNaam = stmtSelectDubbeleNaam.executeQuery();
        rsControleNaam.next();
       int iDubbeleNaam = rsControleNaam.getInt(1) ;

        System.out.println("iDubbeleNaam = " + iDubbeleNaam);
        return iDubbeleNaam;

    }

    public void createNaam(Plant plant) throws SQLException {
            int typeID, familieID, geslachtID, soortID;

        //Ophalen typeID
        stmtSelectTypeId.setString(1,plant.getType() );
        ResultSet rsTypeID =stmtSelectTypeId.executeQuery();
        rsTypeID.next();
        typeID = rsTypeID.getInt(1) ;

        System.out.println(typeID);

        //Invoegen in familie
        stmtInsertInFamilie.setString(1,plant.getFamilie());
        stmtInsertInFamilie.setInt(2, typeID);
        stmtInsertInFamilie.executeUpdate();
        System.out.println("Toevoegen familie geslaagd");

        //Ophalen familieID
        stmtSelectFamilieId.setString(1,plant.getFamilie() );
        ResultSet rsFamilieID =stmtSelectFamilieId.executeQuery();
        rsFamilieID.next();
        familieID = rsFamilieID.getInt(1) ;
        System.out.println(familieID);

        //Invoegen in geslacht
        stmtInsertInGeslacht.setString(1,plant.getGeslacht());
        stmtInsertInGeslacht.setInt(2, familieID);
        stmtInsertInGeslacht.executeUpdate();
        System.out.println("Toevoegen geslacht geslaagd");

        //Ophalen geslachtID
        stmtSelectGeslachtId.setString(1,plant.getGeslacht());
        ResultSet rsGeslachtID =stmtSelectFamilieId.executeQuery();
        rsGeslachtID.next();
        geslachtID = rsGeslachtID.getInt(1) ;
        System.out.println(geslachtID);

        //Invoegen in soort
        stmtInsertInSoort.setString(1,plant.getSoort());
        stmtInsertInSoort.setInt(2, geslachtID);
        stmtInsertInSoort.executeUpdate();
        System.out.println("Toevoegen soort geslaagd");

        //Ophalen soortID
        stmtSelectSoortId.setString(1,plant.getSoort() );
        ResultSet rsSoortID =stmtSelectSoortId.executeQuery();
        rsSoortID.next();
        soortID = rsSoortID.getInt(1);
        System.out.println(soortID);


        //Invoegen in variatie
        stmtInsertInVariatie.setString(1,plant.getVariatie());
        stmtInsertInVariatie.setInt(2, soortID);
        stmtInsertInVariatie.executeUpdate();
        System.out.println("Toevoegen variatie geslaagd");

    }
}

