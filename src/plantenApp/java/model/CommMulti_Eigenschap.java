package plantenApp.java.model;

/**@author Siebe*/
public class CommMulti_Eigenschap {
    private int id;
    private String naam;
    private String value;
    private int plantid;

    public CommMulti_Eigenschap(String naam, String value, int plantid) {
        this.naam = naam;
        this.value = value;
        this.plantid = plantid;
    }

    public int getPlantid() {
        return plantid;
    }

    public void setPlantid(int plantid) {
        this.plantid = plantid;
    }

    /*
    public CommMulti_Eigenschap(int id, String naam, String value) {
        this.id = id;
        this.naam = naam;
        this.value = value;
    }*/

    public CommMulti_Eigenschap(String naam, String value) {
        this.naam = naam;
        this.value = value;
    }


    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getValue() {
        return value;
    }
}
