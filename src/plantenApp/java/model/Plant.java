package plantenApp.java.model;

/**@author Siebe*/
public class Plant {
    private int id;
    private String type;
    private String familie;
    private String geslacht;
    private String soort;
    private String variatie;
    private int minPlantdichtheid;
    private int maxPlantdichtheid;
    private String fgsv;

    public Plant(int id, String type, String familie, String geslacht, String soort, String variatie, int minPlantdichtheid, int maxPlantdichtheid) {
        this.id = id;
        this.type = type;
        this.familie = familie;
        this.geslacht = geslacht;
        this.soort = soort;
        this.variatie = variatie;
        this.minPlantdichtheid = minPlantdichtheid;
        this.maxPlantdichtheid = maxPlantdichtheid;
    }

    public Plant(int id, String type, String familie, String geslacht, String soort, String variatie, int minPlantdichtheid, int maxPlantdichtheid, String fgsv) {
        this.id = id;
        this.type = type;
        this.familie = familie;
        this.geslacht = geslacht;
        this.soort = soort;
        this.variatie = variatie;
        this.minPlantdichtheid = minPlantdichtheid;
        this.maxPlantdichtheid = maxPlantdichtheid;
        this.fgsv = fgsv;
    }

    public String getFgsv() {
        return fgsv;
    }

    public void setFgsv(String fgsv) {
        this.fgsv = fgsv;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getFamilie() {
        return familie;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public String getSoort() {
        return soort;
    }

    public String getVariatie() {
        return variatie;
    }

    public int getMinPlantdichtheid() {
        return minPlantdichtheid;
    }

    public int getMaxPlantdichtheid() {
        return maxPlantdichtheid;
    }
}
