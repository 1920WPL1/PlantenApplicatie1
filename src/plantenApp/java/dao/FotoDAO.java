package plantenApp.java.dao;

import plantenApp.java.model.Foto;
import plantenApp.java.model.Foto_Eigenschap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**@author Siebe*/
public class FotoDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectFotoByID;

    //statements voor getmaxid en createFoto in deze klasse
    private PreparedStatement stmtGetMaxId;
    private PreparedStatement stmtInsertFoto;
    private PreparedStatement stmtInsertFotoAangepast;
    private PreparedStatement stmtRemoveFoto;

    public FotoDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;

        stmtSelectFotoByID = dbConnection.prepareStatement(GETFOTOBYPLANTID);

        stmtGetMaxId = dbConnection.prepareStatement(GETMAXIDFOTO);
        stmtInsertFoto = dbConnection.prepareStatement(INSERTFOTO);
        stmtInsertFotoAangepast = dbConnection.prepareStatement(INSERTFOTOAANGEPAST);
        stmtRemoveFoto = dbConnection.prepareStatement(REMOVEFOTO);
    }

    //region GET

    /**
     * @author Siebe
     * @param id -> plant_id
     * @return -> verzameling van de fotos van de specifieke plant
     */
    public Foto getFotoById(int id) throws SQLException {
        //TODO:Afhankelijk van hoe jullie de blobs willen doen moet je dit veranderen, wil je het als image opslaan of als blob
        //Dao

        //Items
        Foto foto = null;

        //SqlCommand
        /*foto = new Foto(
                id,
                getFotos(id)
        );*/

        //Output
        return foto;
    }

    /**
     * @author Siebe
     * @param id -> plant_id
     * @return -> fotos van de specifieke plant
     */
    public ArrayList<Foto_Eigenschap> getFotos(int id) throws SQLException {
        //Dao

        //Items
        //ArrayList<Foto_Eigenschap> fotos = null;
        ArrayList<Foto_Eigenschap> fotos = new ArrayList<>();

        //SqlCommand
        stmtSelectFotoByID.setInt(1, id);
        ResultSet rs = stmtSelectFotoByID.executeQuery();
        while (rs.next()) {
            Foto_Eigenschap foto = new Foto_Eigenschap(
                    rs.getInt("foto_id"),
                    //rs.getInt("plant_id"),
                    rs.getString("eigenschap"),
                    rs.getString("url"),
                    rs.getBlob("figuur")
            );
            fotos.add(foto);
        }

        //Output
        return fotos;
    }

    //functies voor ControllerPlantToevoegen
    public int getmaxid() throws SQLException{
        ResultSet rs =stmtGetMaxId.executeQuery();
        rs.next();
        int maxid =rs.getInt(1) ;
        return maxid;
    }

    //alleen deze wordt gebruikt voor fotos in de databank toe te voegen
    public void insertFoto(int id, int plant_id, String eigenschap, String url, String urlVoorAfbeelding) throws SQLException {
        stmtInsertFotoAangepast.setInt(1,id);
        stmtInsertFotoAangepast.setInt(2,plant_id);
        stmtInsertFotoAangepast.setString(3,eigenschap);
        stmtInsertFotoAangepast.setString(4,url);
        stmtInsertFotoAangepast.setString(5,urlVoorAfbeelding);
        stmtInsertFotoAangepast.executeUpdate();
    }

    public void removeFoto(int plantid, String eigenschap) throws SQLException{
        stmtRemoveFoto.setInt(1, plantid);
        stmtRemoveFoto.setString(2, eigenschap);
        stmtRemoveFoto.executeUpdate();
    }

    public void createFoto(Foto foto) throws SQLException {
        int lengte = foto.getFotos().size();
        for (int i = 0; i < lengte; i++) {
            stmtInsertFoto.setInt(1, foto.getFotos().get(i).getId());
            stmtInsertFoto.setInt(2, foto.getPlant_id());
            stmtInsertFoto.setString(3, foto.getFotos().get(i).getEigenschap());
            stmtInsertFoto.setString(4, foto.getFotos().get(i).getUrl());
            stmtInsertFoto.setBlob(5, foto.getFotos().get(i).getImage());
            stmtInsertFoto.executeUpdate();
        }
        //onderstaande wordt niet meer gebruikt
        /*
        stmtInsertFoto.setInt(1, foto.getId());
        stmtInsertFoto.setInt(2,foto.getPlant_id());
        stmtInsertFoto.setString(3,foto.getEigenschap());
        stmtInsertFoto.setString(4,foto.getUrl());
        stmtInsertFoto.setBlob(5,foto.getImage());
        stmtInsertFoto.executeUpdate();
        System.out.println("foto toegevoegd");
    */

    }//endregion
}
