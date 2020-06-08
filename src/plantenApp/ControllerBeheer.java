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
    public ArrayList<Beheer> beheerss = new ArrayList<>();
    public ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschapss = new ArrayList<>();
    private ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschaps = new ArrayList<>();
    public ArrayList<Plant> plantss = new ArrayList<>();
    public ArrayList<AbiotischeFactoren> abiotischeFactorenn = new ArrayList<>();
    public ArrayList<AbioMulti_Eigenschap> abiotischmulti = new ArrayList<>();
    public ArrayList<Commensalisme> commensalismes = new ArrayList<>();
    public ArrayList<CommMulti_Eigenschap> commMulti_eigenschapss = new ArrayList<>();
    public ArrayList<Extra> extrass = new ArrayList<>();
    public ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschapss = new ArrayList<>();
    public ArrayList<Fenotype> fenotypess = new ArrayList<>();
    public ArrayList<Foto> fotoss = new ArrayList<>();
    private int planid;

    public ControllerBeheer(ArrayList<Plant> plantss, ArrayList<AbiotischeFactoren> abiotischeFactorenn, ArrayList<AbioMulti_Eigenschap> abiotischmulti, ArrayList<Commensalisme> commensalismes, ArrayList<CommMulti_Eigenschap> commMulti_eigenschapss, ArrayList<Extra> extrass, ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschapss, ArrayList<Fenotype> fenotypess) {
        System.out.println("in controller");
        this.plantss = plantss;
        System.out.println("onderplanten");
        this.abiotischeFactorenn = abiotischeFactorenn;
        System.out.println("onder abio");
        this.abiotischmulti = abiotischmulti;
        System.out.println("onder multie abio");
        this.commensalismes = commensalismes;
        System.out.println("onder comm");
        this.commMulti_eigenschapss = commMulti_eigenschapss;
        System.out.println("onder scom multi");
        this.extrass = extrass;
        System.out.println("extr");
        this.fenoMulti_eigenschapss = fenoMulti_eigenschapss;
        System.out.println("fsdlfk");
        this.fenotypess = fenotypess;
        System.out.println("lkfdsq jfldf ");
    }


    public void initialize() throws SQLException {
        System.out.println("lkfdsq jfldf ");
        dbConnection = Database.getInstance().getConnection();
        PlantDAO plantDAO = new PlantDAO(dbConnection);
        System.out.println("fsdlfk");
        planid = plantDAO.getmaxid();
        System.out.println("onder scom multi");
        FillComboBeheer();

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
            }
            catch (Exception e)
            {
                boodschaptxt.setText("er bestaat al een behandeling met deze naam");
                behandlingnaamtxt.setText("");
            }

        }
        public void Verwijdernbeheer_clicekd(MouseEvent mouseEvent) {
            beheerdaad_eigenschaps.remove(Beheerlistview.getSelectionModel().getSelectedIndex());
            Beheerlistview.getItems().clear();
            for (int j = 0 ; j < beheerdaad_eigenschaps.size(); j++)
            {
                Beheerlistview.getItems().addAll(beheerdaad_eigenschaps.get(j).getNaam() + " " +beheerdaad_eigenschaps.get(j).getMaand()+ " " + beheerdaad_eigenschaps.get(j).getOpmerking() );
            }
        }
        public void teovoegenbeheer_clicked(MouseEvent mouseEvent) throws SQLException {
            try {
                BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
                ArrayList<String> maanden = new ArrayList<>();
                maanden = getmaanden();
                int id = beheerDAO.getmaxid();
                id++;
                for( int j=0; j < maanden.size();j++)
                {
                    Beheerdaad_Eigenschap beheerdaad_eigenschap = new Beheerdaad_Eigenschap(id+j, CmdBehandeling.getValue().toString(), opmerkingtxt.getText(),maanden.get(j), (Integer) frequentieNumericupdown.getValue());
                    beheerdaad_eigenschaps.add(beheerdaad_eigenschap);
                    Beheerlistview.getItems().addAll(beheerdaad_eigenschaps.get(j).getNaam() + " " +beheerdaad_eigenschaps.get(j).getMaand()+ " " + beheerdaad_eigenschaps.get(j).getOpmerking() );
                    System.out.println(beheerDAO.getmaxid()+j);
                    System.out.println(beheerdaad_eigenschaps.get(j).getId());
                }
            }
            catch (Exception e)
            {
                boodschaptxt.setText("Vul alles correct in");
            }

        }
        public ArrayList<String> getmaanden()    {
            ArrayList<String> maanden = new ArrayList<>();
            if(jancheckbox.isSelected())
            {
                maanden.add("Januari");
                jancheckbox.selectedProperty().set(false);
            }
            if(febcheckbox.isSelected())
            {
                maanden.add("Februarie");
                febcheckbox.selectedProperty().set(false);
            }
            if(maacheckbox.isSelected())
            {
                maanden.add("Maart");
                maacheckbox.selectedProperty().set(false);

            }
            if(aprilcheckbox.isSelected())
            {
                maanden.add("April");
                aprilcheckbox.selectedProperty().set(false);

            }
            if(maicheckbox.isSelected())
            {
                maanden.add("Mei");
                maicheckbox.selectedProperty().set(false);

            }
            if(junicheckbox.isSelected())
            {
                maanden.add("Juni");
                junicheckbox.selectedProperty().set(false);

            }
            if(julicheckbox.isSelected())
            {
                maanden.add("Juli");
                julicheckbox.selectedProperty().set(false);

            }
            if(augcheckbox.isSelected())
            {
                maanden.add("Augustus");
                augcheckbox.selectedProperty().set(false);

            }
            if(septembecheclbox.isSelected())
            {
                maanden.add("September");
                septembecheclbox.selectedProperty().set(false);

            }
            if(oktcheckbox.isSelected())
            {
                maanden.add("Oktober");
                oktcheckbox.selectedProperty().set(false);
            }
            if(novcheckbox.isSelected())
            {
                maanden.add("November");
                novcheckbox.selectedProperty().set(false);

            }
            if(deccheckbox.isSelected())
            {
                maanden.add("December");
                deccheckbox.selectedProperty().set(false);

            }
            return maanden;
        }
        public void Opslaanbutton_clicked(MouseEvent mouseEvent) throws SQLException, IOException {
            BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
            for (int m = 0; m < beheerdaad_eigenschaps.size();m++)
            {
                beheerDAO.createBeheer(beheerdaad_eigenschaps.get(m) ,planid);
            }
            openNieuwScherm(mouseEvent );

        }
    public void createBeheer() throws SQLException{
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        int maxIdBeheer = beheerDAO.getmaxid();
        for(int i = 0; i < Beheerlistview.getItems().size();i++)
        {
            maxIdBeheer++;
            Beheerdaad_Eigenschap beheerdaad_eigenschap = new Beheerdaad_Eigenschap(maxIdBeheer+1, "Test", "Test", "Test", 5);
            beheerdaad_eigenschapss.add(beheerdaad_eigenschap);
            Beheer beheer = new Beheer(planid);
            beheerss.add(beheer);
        }
    }

    public void openNieuwScherm(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/GedetailleerdeFiche.fxml"));
        Scene scen = new Scene(root);
        Stage window =(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scen);
        window.show();
        window.setMaximized(true);
        // Hide this current window (if this is what you want)
    }

}

