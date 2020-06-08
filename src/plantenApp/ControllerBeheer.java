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
    private int planid;

    public ControllerBeheer() {
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
        ControllerPlantToevoegen.beheerdaad_eigenschapss.remove(Beheerlistview.getSelectionModel().getSelectedIndex());
        Beheerlistview.getItems().clear();
        for (int j = 0; j <  ControllerPlantToevoegen.beheerdaad_eigenschapss.size(); j++) {
            Beheerlistview.getItems().addAll( ControllerPlantToevoegen.beheerdaad_eigenschapss.get(j).getNaam() + " " +  ControllerPlantToevoegen.beheerdaad_eigenschapss.get(j).getMaand() + " " +  ControllerPlantToevoegen.beheerdaad_eigenschapss.get(j).getOpmerking());
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
                ControllerPlantToevoegen.beheerdaad_eigenschapss.add(beheerdaad_eigenschap);
                Beheerlistview.getItems().addAll( ControllerPlantToevoegen.beheerdaad_eigenschapss.get(j).getNaam() + " " +  ControllerPlantToevoegen.beheerdaad_eigenschapss.get(j).getMaand() + " " +  ControllerPlantToevoegen.beheerdaad_eigenschapss.get(j).getOpmerking());
                System.out.println(beheerDAO.getmaxid() + j);
                System.out.println( ControllerPlantToevoegen.beheerdaad_eigenschapss.get(j).getId());
            }
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
        for (int m = 0; m <  ControllerPlantToevoegen.beheerdaad_eigenschapss.size(); m++) {
            beheerDAO.createBeheer( ControllerPlantToevoegen.beheerdaad_eigenschapss.get(m), planid);
        }
        openNieuwScherm(mouseEvent);
        System.out.println(ControllerPlantToevoegen.plantss.get(0).getFgsv());

    }

    public void createBeheer() throws SQLException {
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        int maxIdBeheer = beheerDAO.getmaxid();
        for (int i = 0; i < Beheerlistview.getItems().size(); i++) {
            maxIdBeheer++;
            Beheerdaad_Eigenschap beheerdaad_eigenschap = new Beheerdaad_Eigenschap(maxIdBeheer + 1, "Test", "Test", "Test", 5);
            ControllerPlantToevoegen.beheerdaad_eigenschapss.add(beheerdaad_eigenschap);
            Beheer beheer = new Beheer(planid);
            ControllerPlantToevoegen.beheerss.add(beheer);
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
        System.out.println(ControllerPlantToevoegen.plantss.get(0).getFgsv());
    }

}

