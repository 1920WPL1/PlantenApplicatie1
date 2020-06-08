package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import plantenApp.java.dao.BeheerDAO;
import plantenApp.java.dao.Database;
import plantenApp.java.dao.PlantDAO;
import plantenApp.java.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerBeheer {
    public ComboBox CmdBehandeling;
    public TextField behandlingnaamtxt;
    public Button behandelingtoevoegenbutton;
    public Button teovoegenbehandlingbtn;
    public Button Verwijderenbeheerbutn;
    public ListView Beheerlistview;
    public TextArea opmerkingtxt;
    public Spinner frequentieNumericupdown;
    public CheckBox jancheckbox;
    public CheckBox febcheckbox;
    public CheckBox maacheckbox;
    public CheckBox aprilcheckbox;
    public CheckBox maicheckbox;
    public CheckBox junicheckbox;
    public CheckBox julicheckbox;
    public CheckBox augcheckbox;
    public CheckBox septembecheclbox;
    public CheckBox oktcheckbox;
    public CheckBox novcheckbox;
    public CheckBox deccheckbox;
    public Button Opslaanbutton;
    public Label boodschaptxt;
    private Connection dbConnection;
    public ArrayList<Beheer> beheers = new ArrayList<>();
    public ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschaps = new ArrayList<>();
    private ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschap = new ArrayList<>();
    public ArrayList<Plant> plants = new ArrayList<>();
    public ArrayList<AbiotischeFactoren> abiotischeFactoren = new ArrayList<>();
    public ArrayList<AbioMulti_Eigenschap> abiotischmultis = new ArrayList<>();
    public ArrayList<Commensalisme> commensalismess = new ArrayList<>();
    public ArrayList<CommMulti_Eigenschap> commMulti_eigenschaps = new ArrayList<>();
    public ArrayList<Extra> extras = new ArrayList<>();
    public ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschaps = new ArrayList<>();
    public ArrayList<Fenotype> fenotypes = new ArrayList<>();
    public ArrayList<Foto> fotos = new ArrayList<>();
    private int planid;

    public ControllerBeheer() {
    }
    public void setBeheerdaad_eigenschaps(ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschaps) {
        this.beheerdaad_eigenschaps = beheerdaad_eigenschaps;
    }
    public void setBeheerdaad_eigenschap(ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschap) {
        this.beheerdaad_eigenschap = beheerdaad_eigenschap;
    }
    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
        System.out.println("in de plant setter");
        System.out.println(plants.get(0));
    }
    public void setAbiotischeFactoren(ArrayList<AbiotischeFactoren> abiotischeFactoren) {
        this.abiotischeFactoren = abiotischeFactoren;
    }
    public void setAbiotischmultis(ArrayList<AbioMulti_Eigenschap> abiotischmultis) {
        this.abiotischmultis = abiotischmultis;
    }
    public void setCommensalismess(ArrayList<Commensalisme> commensalismess) {
        this.commensalismess = commensalismess;
    }
    public void setCommMulti_eigenschaps(ArrayList<CommMulti_Eigenschap> commMulti_eigenschaps) {
        this.commMulti_eigenschaps = commMulti_eigenschaps;
    }
    public void setExtras(ArrayList<Extra> extras) {
        this.extras = extras;
    }
    public void setFenoMulti_eigenschaps(ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschaps) {
        this.fenoMulti_eigenschaps = fenoMulti_eigenschaps;
    }
    public void setFenotypes(ArrayList<Fenotype> fenotypes) {
        this.fenotypes = fenotypes;
    }
    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }
    public ControllerBeheer(ArrayList<Plant> plantss, ArrayList<AbiotischeFactoren> abiotischeFactorenn, ArrayList<AbioMulti_Eigenschap> abiotischmulti, ArrayList<Commensalisme> commensalismes, ArrayList<CommMulti_Eigenschap> commMulti_eigenschapss, ArrayList<Extra> extrass, ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschapss, ArrayList<Fenotype> fenotypess) {
        this.plants = plantss;
        this.abiotischeFactoren = abiotischeFactorenn;
        this.abiotischmultis = abiotischmulti;
        this.commensalismess = commensalismes;
        this.commMulti_eigenschaps = commMulti_eigenschapss;
        this.extras = extrass;
        this.fenoMulti_eigenschaps = fenoMulti_eigenschapss;
        this.fenotypes = fenotypess;
        System.out.println(plants.get(0).getFgsv());
        System.out.println(abiotischeFactoren.size());
        System.out.println(abiotischmultis.size());
        System.out.println(commensalismess.size());
        System.out.println(fenoMulti_eigenschaps.size());
    }

    public void lijstenvullen(ArrayList<Plant> plantss, ArrayList<AbiotischeFactoren> abiotischeFactorenn, ArrayList<AbioMulti_Eigenschap> abiotischmulti, ArrayList<Commensalisme> commensalismes, ArrayList<CommMulti_Eigenschap> commMulti_eigenschapss, ArrayList<Extra> extrass, ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschapss, ArrayList<Fenotype> fenotypess) {
        plants.addAll(plantss);
        abiotischeFactoren.addAll(abiotischeFactorenn);
        commensalismess.addAll(commensalismes);
        abiotischmultis.addAll(abiotischmulti);
        commMulti_eigenschaps.addAll(commMulti_eigenschapss);
        extras.addAll(extrass);
        fenoMulti_eigenschaps.addAll(fenoMulti_eigenschapss);
        fenotypes.addAll(fenotypess);
        System.out.println(plants.get(0).getFgsv());
        System.out.println(abiotischeFactoren.size());
        System.out.println(abiotischmultis.size());
        System.out.println(commensalismess.size());
        System.out.println(fenoMulti_eigenschaps.size());
    }

    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
        PlantDAO plantDAO = new PlantDAO(dbConnection);
        planid = plantDAO.getmaxid();
        FillComboBeheer();
        System.out.println("intizialize");
    }


    public void FillComboBeheer() throws SQLException {
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        CmdBehandeling.getItems().clear();
        CmdBehandeling.getItems().addAll(beheerDAO.getalbeheerdaden());
    }

    public void behandelingtoevoegenbtn_clicked(MouseEvent mouseEvent) throws SQLException {
        try {
            BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
            beheerDAO.createbeheerdaad(behandlingnaamtxt.getText());
            FillComboBeheer();
            behandlingnaamtxt.setText("");
        } catch (Exception e) {
            boodschaptxt.setText("er bestaat al een behandeling met deze naam");
            behandlingnaamtxt.setText("");
        }

    }

    public void Verwijdernbeheer_clicekd(MouseEvent mouseEvent) {
        beheerdaad_eigenschaps.remove(Beheerlistview.getSelectionModel().getSelectedIndex());
        Beheerlistview.getItems().clear();
        for (int j = 0; j < beheerdaad_eigenschaps.size(); j++) {
            Beheerlistview.getItems().addAll(beheerdaad_eigenschaps.get(j).getNaam() + " " + beheerdaad_eigenschaps.get(j).getMaand() + " " + beheerdaad_eigenschaps.get(j).getOpmerking());
        }
    }

    public void teovoegenbeheer_clicked(MouseEvent mouseEvent) throws SQLException {
        try {
            BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
            ArrayList<String> maanden = new ArrayList<>();
            maanden = getmaanden();
            int id = beheerDAO.getmaxid();
            id++;
            for (int j = 0; j < maanden.size(); j++) {
                Beheerdaad_Eigenschap beheerdaad_eigenschap = new Beheerdaad_Eigenschap(id + j, CmdBehandeling.getValue().toString(), opmerkingtxt.getText(), maanden.get(j), (Integer) frequentieNumericupdown.getValue());
                beheerdaad_eigenschaps.add(beheerdaad_eigenschap);
                Beheerlistview.getItems().addAll(beheerdaad_eigenschaps.get(j).getNaam() + " " + beheerdaad_eigenschaps.get(j).getMaand() + " " + beheerdaad_eigenschaps.get(j).getOpmerking());
                System.out.println(beheerDAO.getmaxid() + j);
                System.out.println(beheerdaad_eigenschaps.get(j).getId());
            }
            System.out.println(plants.get(0).getFgsv());
        } catch (Exception e) {
            boodschaptxt.setText("Vul alles correct in");
        }

    }

    public ArrayList<String> getmaanden() {
        ArrayList<String> maanden = new ArrayList<>();
        if (jancheckbox.isSelected()) {
            maanden.add("Januari");
            jancheckbox.selectedProperty().set(false);
        }
        if (febcheckbox.isSelected()) {
            maanden.add("Februarie");
            febcheckbox.selectedProperty().set(false);
        }
        if (maacheckbox.isSelected()) {
            maanden.add("Maart");
            maacheckbox.selectedProperty().set(false);

        }
        if (aprilcheckbox.isSelected()) {
            maanden.add("April");
            aprilcheckbox.selectedProperty().set(false);

        }
        if (maicheckbox.isSelected()) {
            maanden.add("Mei");
            maicheckbox.selectedProperty().set(false);

        }
        if (junicheckbox.isSelected()) {
            maanden.add("Juni");
            junicheckbox.selectedProperty().set(false);

        }
        if (julicheckbox.isSelected()) {
            maanden.add("Juli");
            julicheckbox.selectedProperty().set(false);

        }
        if (augcheckbox.isSelected()) {
            maanden.add("Augustus");
            augcheckbox.selectedProperty().set(false);

        }
        if (septembecheclbox.isSelected()) {
            maanden.add("September");
            septembecheclbox.selectedProperty().set(false);

        }
        if (oktcheckbox.isSelected()) {
            maanden.add("Oktober");
            oktcheckbox.selectedProperty().set(false);
        }
        if (novcheckbox.isSelected()) {
            maanden.add("November");
            novcheckbox.selectedProperty().set(false);

        }
        if (deccheckbox.isSelected()) {
            maanden.add("December");
            deccheckbox.selectedProperty().set(false);

        }
        return maanden;
    }

    public void Opslaanbutton_clicked(MouseEvent mouseEvent) throws SQLException, IOException {
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        for (int m = 0; m < beheerdaad_eigenschaps.size(); m++) {
            beheerDAO.createBeheer(beheerdaad_eigenschaps.get(m), planid);
        }
        openNieuwScherm(mouseEvent);

    }

    public void createBeheer() throws SQLException {
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        int maxIdBeheer = beheerDAO.getmaxid();
        for (int i = 0; i < Beheerlistview.getItems().size(); i++) {
            maxIdBeheer++;
            Beheerdaad_Eigenschap beheerdaad_eigenschap = new Beheerdaad_Eigenschap(maxIdBeheer + 1, "Test", "Test", "Test", 5);
            beheerdaad_eigenschaps.add(beheerdaad_eigenschap);
            Beheer beheer = new Beheer(planid);
            beheers.add(beheer);
        }
    }

    public void openNieuwScherm(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/GedetailleerdeFiche.fxml"));
        Scene scen = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scen);
        window.show();
        window.setMaximized(true);
        System.out.println("controlleroverzicht");
        ControllerOverzicht controllerOverzicht = new ControllerOverzicht();
        //controllerOverzicht.lijstenvullen(plants, abiotischeFactoren, abiotischmultis, commensalismess, commMulti_eigenschaps, extras, fenoMulti_eigenschaps, fenotypes, beheerdaad_eigenschaps);
        System.out.println(ControllerPlantToevoegen.plantss.size());
        System.out.println(ControllerPlantToevoegen.beheerdaad_eigenschapss.size());

    }

}

