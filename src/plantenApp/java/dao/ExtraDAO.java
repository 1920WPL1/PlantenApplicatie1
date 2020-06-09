package plantenApp.java.dao;

import plantenApp.java.model.Extra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Siebe
 */
public class ExtraDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectExtraByID;
    private PreparedStatement stmtSelectByExtra;
    private PreparedStatement stmtInsertExtra;
    private  PreparedStatement stmtGetmaxid;

    public ExtraDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;

        stmtSelectExtraByID = dbConnection.prepareStatement(GETEXTRABYPLANTID);
        stmtSelectByExtra = dbConnection.prepareStatement(GETIDSBYEXTRA);
        stmtInsertExtra = dbConnection.prepareStatement(INSERTEXTRA);
        stmtGetmaxid = dbConnection.prepareStatement(GETMAXIDEXTRA);
    }

    //region GET

    /**
     * @author Siebe
     * @param id -> plant_id
     * @return -> alle extra kenmerken van de specifieke plant
     */
    public Extra getExtraById(int id) throws SQLException {
        //Dao

        //Items
        Extra extra = null;

        //SqlCommand
        stmtSelectExtraByID.setInt(1, id);
        ResultSet rs = stmtSelectExtraByID.executeQuery();
        if (rs.next()) {
            extra = new Extra(
                    rs.getInt("extra_id"),
                    rs.getInt("plant_id"),
                    rs.getInt("nectarwaarde"),
                    rs.getInt("pollenwaarde"),
                    rs.getString("bijvriendelijk"),
                    rs.getString("eetbaar_kruidgebruik"),
                    rs.getString("eetbaar_kruidgebruik"),
                    rs.getString("geurend"),
                    rs.getString("vorstgevoelig")
            );
        }

        //Output
        return extra;
    }

    public void createExtra(Extra extra) throws SQLException{
        stmtInsertExtra.setInt(1,extra.getId());
        stmtInsertExtra.setInt(2,extra.getPlant_id());
        stmtInsertExtra.setInt(3,extra.getNectarwaarde());
        stmtInsertExtra.setInt(4,extra.getPollenwaarde());
        stmtInsertExtra.setString(5,extra.getBijvriendelijk());
        stmtInsertExtra.setString(6,extra.getVlindervriendelijk());
        stmtInsertExtra.setString(7,extra.getEetbaar());
        stmtInsertExtra.setString(8,extra.getKruidgebruik());
        stmtInsertExtra.setString(9,extra.getGeurend());
        stmtInsertExtra.setString(10,extra.getVorstgevoelig());
        stmtInsertExtra.executeUpdate();
        System.out.println("extra toegevoegd");
    }
    public int getmaxid() throws SQLException{
        ResultSet rs = stmtGetmaxid.executeQuery();
        rs.next();
        int maxId = rs.getInt(1);
        return maxId;
    }

    //endregion
}
