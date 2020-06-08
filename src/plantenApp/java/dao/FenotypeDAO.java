package plantenApp.java.dao;

import plantenApp.java.model.FenoMulti_Eigenschap;
import plantenApp.java.model.Fenotype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Siebe
 */
public class FenotypeDAO implements Queries {

    private Connection dbConnection;
    private PreparedStatement stmtSelectFenoByID;
    private PreparedStatement stmtSelectFenoMultiByID;
    private PreparedStatement stmtSelectIdsByFeno;
    private PreparedStatement stmtSelectIdsByFenoMulti;
    private PreparedStatement strmgetmacid;
    private PreparedStatement stmtInsert;
    private PreparedStatement strmGetmaxidmulti;
    private PreparedStatement stmtInsertMulti;

    public FenotypeDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectFenoByID = dbConnection.prepareStatement(GETFENOTYPEBYPLANTID);
        stmtSelectFenoMultiByID = dbConnection.prepareStatement(GETFENOTYPEMULTIBYPLANTID);
        stmtSelectIdsByFeno = dbConnection.prepareStatement(GETIDSBYFENO);
        stmtSelectIdsByFenoMulti = dbConnection.prepareStatement(GETIDSBYFENOMULTI);
        strmgetmacid = dbConnection.prepareStatement(GETMAXIDFENOTYPE);
        stmtInsert = dbConnection.prepareStatement(INSERTFENOTYPE);
        strmGetmaxidmulti = dbConnection.prepareStatement(GETMAXIDMULTIFENOTYPE);
        stmtInsertMulti = dbConnection.prepareStatement(INSERTFENOTYPEMULTI);
    }

    /**@author Siebe
     * @param id -> plant_id
     * @return alle fenotipsche factoren van de specifieke plant
     */
    public Fenotype getById(int id) throws SQLException {
        Fenotype feno = null;

        stmtSelectFenoByID.setInt(1, id);
        ResultSet rs = stmtSelectFenoByID.executeQuery();
        if (rs.next()) {
            feno = new Fenotype(
                    rs.getInt("fenotype_id"),
                    rs.getInt("plant_id"),
                    rs.getString("bladvorm"),
                    rs.getInt("levensvorm"),
                    rs.getString("habitus"),
                    rs.getString("bloeiwijze"),
                    rs.getInt("bladgrootte"),
                    rs.getString("ratio_bloei_blad"),
                    rs.getString("spruitfenologie"),
                    getByIdMulti(id)
            );
        }
        return feno;
    }

    /**@author Siebe
     * word alleen gebruikt in getById
     * @param id -> plant_id
     * @return -> alle fenotype_multi van de specifieke plant
     */
    private ArrayList<FenoMulti_Eigenschap> getByIdMulti(int id) throws SQLException {
        ArrayList<FenoMulti_Eigenschap> commMulti = new ArrayList<>();;

        //Items

        //SqlCommand
        stmtSelectFenoMultiByID.setInt(1, id);
        ResultSet rs = stmtSelectFenoMultiByID.executeQuery();
        while (rs.next()) {
            FenoMulti_Eigenschap fenoEigenschap = new FenoMulti_Eigenschap(
                    rs.getInt("fenotype_id"),
                    rs.getString("eigenschap"),
                    rs.getString("jan"),
                    rs.getString("feb"),
                    rs.getString("maa"),
                    rs.getString("apr"),
                    rs.getString("mei"),
                    rs.getString("jun"),
                    rs.getString("jul"),
                    rs.getString("aug"),
                    rs.getString("sep"),
                    rs.getString("okt"),
                    rs.getString("nov"),
                    rs.getString("dec")
            );
            commMulti.add(fenoEigenschap);
        }
        return commMulti;
    }

    /**@author Siebe
     * @param sPlant_ids -> de te filteren ids
     * @param eigenschap -> de naam van de eigenschap om op te filteren
     * @param waarde -> de waarde van de eigenschap
     * @return -> de gefilterde ids
     */
    public ArrayList<Integer> KenmerkenMultiFilter(String sPlant_ids,String eigenschap,String waarde) throws SQLException {
        ArrayList<Integer> ids = new ArrayList<>();;
        stmtSelectIdsByFenoMulti.setString(1,sPlant_ids);
        stmtSelectIdsByFenoMulti.setString(2,eigenschap);

        int iTrue = (waarde.isBlank()) ? 1 : 0;
        stmtSelectIdsByFenoMulti.setString(2, waarde);
        stmtSelectIdsByFenoMulti.setInt(3, iTrue);

        ResultSet rs = stmtSelectIdsByFenoMulti.executeQuery();
        while (rs.next()) {
            ids.add(rs.getInt("plant_id"));
        }
        return ids;
    }

    /**@author Siebe
     * @param sPlant_ids -> de te filteren ids
     * @param bladvorm -> waarde van bladvorm om op te filteren
     * @param levensvorm -> waarde van levensvorm om op te filteren
     * @param habitus -> waarde van habitus om op te filteren
     * @param bloeiwijze -> waarde van bloeiwijze om op te filteren
     * @param bladgrootte -> waarde van bladgrootte om op te filteren
     * @param ratio_bloei_blad -> waarde van ratio_bloei_blad om op te filteren
     * @param spruitfenologie -> waarde van spruitfenologie om op te filteren
     * @return -> de gefilterde ids
     */
    public ArrayList<Integer> KenmerkenFilter(String sPlant_ids, String bladvorm, String levensvorm, String habitus, String bloeiwijze, int bladgrootte, String ratio_bloei_blad, String spruitfenologie) throws SQLException {
        ArrayList<Integer> ids = new ArrayList<>();;

        stmtSelectIdsByFeno.setString(1, sPlant_ids);

        int iTrue = (bladvorm.isBlank()) ? 1 : 0;
        stmtSelectIdsByFeno.setString(2, bladvorm);
        stmtSelectIdsByFeno.setInt(3, iTrue);

        //TODO levensvorm moet in databank een string
        iTrue = (levensvorm.isBlank()) ? 1 : 0;
        stmtSelectIdsByFeno.setString(4, levensvorm);
        stmtSelectIdsByFeno.setInt(5, iTrue);

        iTrue = (habitus.isBlank()) ? 1 : 0;
        stmtSelectIdsByFeno.setString(6, habitus);
        stmtSelectIdsByFeno.setInt(7, iTrue);

        iTrue = (bloeiwijze.isBlank()) ? 1 : 0;
        stmtSelectIdsByFeno.setString(8, bloeiwijze);
        stmtSelectIdsByFeno.setInt(9, iTrue);

        iTrue = (bladgrootte == 0) ? 1 : 0;
        stmtSelectIdsByFeno.setInt(10, bladgrootte);
        stmtSelectIdsByFeno.setInt(11, iTrue);

        iTrue = (ratio_bloei_blad.isBlank()) ? 1 : 0;
        stmtSelectIdsByFeno.setString(12, ratio_bloei_blad);
        stmtSelectIdsByFeno.setInt(13, iTrue);

        iTrue = (spruitfenologie.isBlank()) ? 1 : 0;
        stmtSelectIdsByFeno.setString(14, spruitfenologie);
        stmtSelectIdsByFeno.setInt(15, iTrue);

        ResultSet rs = stmtSelectIdsByFeno.executeQuery();
        while (rs.next()) {
            ids.add(rs.getInt("plant_id"));
        }
        return ids;
    }
    public int getmaxid() throws SQLException {
        ResultSet rs =strmgetmacid.executeQuery();
        rs.next();
        int maxid =rs.getInt(1) ;
        return maxid;
    }
    public int getmaxidmulti() throws SQLException {
        ResultSet rs = strmGetmaxidmulti.executeQuery();
        rs.next();
        int maxidmulti = rs.getInt(1);
        return  maxidmulti;
    }
    public void createfenomulti(FenoMulti_Eigenschap fenoMulti_eigenschap, int plantid) throws SQLException {
        System.out.println(plantid);
        stmtInsertMulti.setInt(1,fenoMulti_eigenschap.getId());
        stmtInsertMulti.setInt(2,plantid);
        stmtInsertMulti.setString(3,fenoMulti_eigenschap.getNaam());
        stmtInsertMulti.setString(4,fenoMulti_eigenschap.getJan());
        stmtInsertMulti.setString(5,fenoMulti_eigenschap.getFeb());
        stmtInsertMulti.setString(6,fenoMulti_eigenschap.getMaa());
        stmtInsertMulti.setString(7,fenoMulti_eigenschap.getApr());
        stmtInsertMulti.setString(8,fenoMulti_eigenschap.getMei());
        stmtInsertMulti.setString(9,fenoMulti_eigenschap.getJun());
        stmtInsertMulti.setString(10,fenoMulti_eigenschap.getJul());
        stmtInsertMulti.setString(11,fenoMulti_eigenschap.getAug());
        stmtInsertMulti.setString(12,fenoMulti_eigenschap.getSep());
        stmtInsertMulti.setString(13,fenoMulti_eigenschap.getOkt());
        stmtInsertMulti.setString(14,fenoMulti_eigenschap.getNov());
        stmtInsertMulti.setString(15,fenoMulti_eigenschap.getDec());
        System.out.println(stmtInsertMulti.toString());
        stmtInsertMulti.executeUpdate();
        System.out.println("gelukt multi feno toegevoegd");
    }
    public void createfenotype(Fenotype fenotype) throws SQLException {
        stmtInsert.setInt(1,fenotype.getId());
        stmtInsert.setInt(2, fenotype.getPlant_id());
        stmtInsert.setString(3,fenotype.getBladvorm());
        stmtInsert.setInt(4,fenotype.getLevensvorm());
        stmtInsert.setString(5,fenotype.getHabitus());
        stmtInsert.setString(6,fenotype.getBloeiwijze());
        stmtInsert.setInt(7,fenotype.getBladgrootte());
        stmtInsert.setString(8,fenotype.getRatio_bloei_blad());
        stmtInsert.setString(9,fenotype.getSpruitfenologie());
        stmtInsert.executeUpdate();
        System.out.println("gelukt fenotyoe toegevoegd");
    }
}

