package plantenApp.java.model;

import java.sql.Blob;
import java.util.ArrayList;

/**@author Siebe*/
public class Foto {
    private int id;
    private int plant_id;
    private String eigenschap;
    private String url;
    private Blob image;

    public Foto(int plant_id, ArrayList<Foto_Eigenschap> fotos) {
        this.plant_id = plant_id;
        this.fotos = fotos;
    }

    private ArrayList<Foto_Eigenschap> fotos;

    public Foto(int id, int plant_id, String eigenschap, String url, Blob image) {
        this.id = id;
        this.plant_id = plant_id;
        this.eigenschap = eigenschap;
        this.url = url;
        this.image = image;
    }

    public int getPlant_id() {
        return plant_id;
    }

    public int getId() {
        return id;
    }

    public String getEigenschap(){return eigenschap;}

    public String getUrl(){return url;}

    public Blob getImage(){return image;}

}
