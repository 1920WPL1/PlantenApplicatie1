package plantenApp;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import plantenApp.java.dao.Database;
import plantenApp.java.dao.InfoTablesDAO;
import plantenApp.java.model.Commensalisme;
import plantenApp.java.model.InfoTables;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerWijzigen {

    public Spinner spinMaxBladhJanWz;
    public Spinner spinMaxBladhFebWz;
    public Spinner spinMaxBladhMaaWz;
    public Spinner spinMaxBladhAprWz;
    public Spinner spinMaxBladhMeiWz;
    public Spinner spinMaxBladhJunWz;
    public Spinner spinMaxBladhJulWz;
    public Spinner spinMaxBladhAugWz;
    public Spinner spinMaxBladhSeptWz;
    public Spinner spinMaxBladhOktWz;
    public Spinner spinMaxBladhNovWz;
    public Spinner spinMaxBladhDecWz;
    public ComboBox cbBladkleurJanWz;
    public ComboBox cbBladkleurFebWz;
    public ComboBox cbBladkleurMaaWz;
    public ComboBox cbBladkleurAprWz;
    public ComboBox cbBladkleurMeiWz;
    public ComboBox cbBladkleurJunWz;
    public ComboBox cbBladkleurJulWz;
    public ComboBox cbBladkleurAugWz;
    public ComboBox cbBladkleurSeptWz;
    public ComboBox cbBladkleurOktWz;
    public ComboBox cbBladkleurNovWz;
    public ComboBox cbBladkleurDecWz;
    public Spinner spinMinBloeihJanWz;
    public Spinner spinMinBloeihFebWz;
    public Spinner spinMinBloeihMaaWz;
    public Spinner spinMinBloeihAprWz;
    public Spinner spinMinBloeihMeiWz;
    public Spinner spinMinBloeihJunWz;
    public Spinner spinMinBloeihJulWz;
    public Spinner spinMinBloeihAugWz;
    public Spinner spinMinBloeihSeptWz;
    public Spinner spinMinBloeihOktWz;
    public Spinner spinMinBloeihNovWz;
    public Spinner spinMinBloeihDecWz;
    public Spinner spinMaxBloeihJanWz;
    public Spinner spinMaxBloeihFebWz;
    public Spinner spinMaxBloeihMaaWz;
    public Spinner spinMaxBloeihAprWz;
    public Spinner spinMaxBloeihMeiWz;
    public Spinner spinMaxBloeihJunWz;
    public Spinner spinMaxBloeihJulWz;
    public Spinner spinMaxBloeihAugWz;
    public Spinner spinMaxBloeihSeptWz;
    public Spinner spinMaxBloeihOktWz;
    public Spinner spinMaxBloeihNovWz;
    public Spinner spinMaxBloeihDecWz;
    public ComboBox cbBloeikleurJanWz;
    public ComboBox cbBloeikleurFebWz;
    public ComboBox cbBloeikleurMaaWz;
    public ComboBox cbBloeikleurAprWz;
    public ComboBox cbBloeikleurMeiWz;
    public ComboBox cbBloeikleurJunWz;
    public ComboBox cbBloeikleurJulWz;
    public ComboBox cbBloeikleurAugWz;
    public ComboBox cbBloeikleurSeptWz;
    public ComboBox cbBloeikleurOktWz;
    public ComboBox cbBloeikleurNovWz;
    public ComboBox cbBloeikleurDecWz;
    public ComboBox cbOntwikkelingssnelheidWz;
    public CheckBox chkSociabiliteit1Wz;
    public CheckBox chkSociabiliteit2Wz;
    public CheckBox chkSociabiliteit3Wz;
    public CheckBox chkSociabiliteit4Wz;
    public CheckBox chkSociabiliteit5Wz;
    public RadioButton rbStrategieUnknownWz;
    public RadioButton rbStrategieTopWz;
    public RadioButton rbStrategieLMWz;
    public RadioButton rbStrategieMMWz;
    public RadioButton rbStrategieRMWz;
    public RadioButton rbStrategieLOWz;
    public RadioButton rbStrategieMOWz;
    public RadioButton rbStrategieROWz;
    public ToggleGroup StrategieGroepWz;
    public ComboBox cbLevensduurWz;
    public Button btnLevensduurWz;
    public ListView lvLevensduurWz;
    private InfoTables infoTables;
    private Connection dbConnection;

    public void LadenCommensalisme(){
        //sociabiliteit
        for(int i = 0; i<ControllerPlantToevoegen.commMulti_eigenschapss.size(); i++){
            if(ControllerPlantToevoegen.commMulti_eigenschapss.get(i).getNaam().matches("sociabiliteit")){
                switch(ControllerPlantToevoegen.commMulti_eigenschapss.get(i).getValue()){
                    case "1": chkSociabiliteit1Wz.setSelected(true); break;
                    case "2": chkSociabiliteit2Wz.setSelected(true); break;
                    case "3": chkSociabiliteit3Wz.setSelected(true); break;
                    case "4": chkSociabiliteit4Wz.setSelected(true); break;
                    case "5": chkSociabiliteit5Wz.setSelected(true); break;
                }
            }
        }
        Commensalisme hulpc = ControllerPlantToevoegen.commensalismes.get(0);
        //strategie
        switch(hulpc.getStrategie()){
            case "": StrategieGroepWz.selectToggle(rbStrategieUnknownWz); break;
            case "C": StrategieGroepWz.selectToggle(rbStrategieTopWz); break;
            case "C-S-R": StrategieGroepWz.selectToggle(rbStrategieMMWz); break;
            case "C-R": StrategieGroepWz.selectToggle(rbStrategieLMWz); break;
            case "C-S": StrategieGroepWz.selectToggle(rbStrategieRMWz); break;
            case "R": StrategieGroepWz.selectToggle(rbStrategieLOWz); break;
            case "S-R": StrategieGroepWz.selectToggle(rbStrategieMOWz); break;
            case "S": StrategieGroepWz.selectToggle(rbStrategieROWz); break;
        }
        //ontwikkelingssnelheid
        //voegt keuzes in
        //cbOntwikkelingssnelheidWz.getItems().addAll(infoTables.getOnstwikkelingssnelheden()); blijkbaar hoeft dit niet aangezien
        cbOntwikkelingssnelheidWz.getSelectionModel().select(hulpc.getOntwikkelingssnelheid());

        //Listview opvullen
        for(int i = 0; i < ControllerPlantToevoegen.commMulti_eigenschapss.size();i++)
        {
            lvLevensduurWz.getItems().add(i,ControllerPlantToevoegen.commMulti_eigenschapss.get(i).getValue());
        }
    }

    //toevoegen items in levensduur/concurrentiekracht listview
    public void click_toevoegenLevensduurWz(MouseEvent mouseEvent) {
        if (!lvLevensduurWz.getItems().contains(cbLevensduurWz.getValue())) {
            lvLevensduurWz.getItems().add((String) cbLevensduurWz.getValue());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Je kan niet 2 keer hetzelfde item toevoegen");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
    }

    //verwijderen items in levensduur/concurrentiekracht listview
    public void click_verwijderenLevensduurWz(MouseEvent mouseEvent) {
        final int selectedIndex = lvLevensduurWz.getSelectionModel().getSelectedIndex();
        lvLevensduurWz.getItems().remove(selectedIndex);
    }

    public void MonthlyInvullenWz() throws SQLException{
        //mogelijke selectie van kleuren is toegevoegd
        KleurenCBToevoegen();

        //selectie van max bladhoogte
        for(int i=0;i<5;i++){
            if(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNaam().matches("Bladhoogte")){
                spinMaxBladhJanWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJan());
                spinMaxBladhFebWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getFeb());
                spinMaxBladhMaaWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMaa());
                spinMaxBladhAprWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getApr());
                spinMaxBladhMeiWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMei());
                spinMaxBladhJunWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJun());
                spinMaxBladhJulWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJul());
                spinMaxBladhAugWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getAug());
                spinMaxBladhSeptWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getSep());
                spinMaxBladhOktWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getOkt());
                spinMaxBladhNovWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNov());
                spinMaxBladhDecWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getDec());
            }
        }

        //selectie van max bloeihoogte
        for(int i=0;i<5;i++){
            if(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNaam().matches("Max Bloeihoogte")){
                spinMaxBloeihJanWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJan());
                spinMaxBloeihFebWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getFeb());
                spinMaxBloeihMaaWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMaa());
                spinMaxBloeihAprWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getApr());
                spinMaxBloeihMeiWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMei());
                spinMaxBloeihJunWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJun());
                spinMaxBloeihJulWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJul());
                spinMaxBloeihAugWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getAug());
                spinMaxBloeihSeptWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getSep());
                spinMaxBloeihOktWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getOkt());
                spinMaxBloeihNovWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNov());
                spinMaxBloeihDecWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getDec());
            }
        }

        //selectie van min bloeihoogte
        for(int i=0;i<5;i++){
            if(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNaam().matches("Min Bloeihoogte")){
                spinMinBloeihJanWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJan());
                spinMinBloeihFebWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getFeb());
                spinMinBloeihMaaWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMaa());
                spinMinBloeihAprWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getApr());
                spinMinBloeihMeiWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMei());
                spinMinBloeihJunWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJun());
                spinMinBloeihJulWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJul());
                spinMinBloeihAugWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getAug());
                spinMinBloeihSeptWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getSep());
                spinMinBloeihOktWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getOkt());
                spinMinBloeihNovWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNov());
                spinMinBloeihDecWz.getValueFactory().setValue(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getDec());
            }
        }

        //selectie van bloeikleur en bladkleur insteken
        //selectie insteken van bladkleur, overlopen van lijst voor eigenschap met bladkleur te vinden, dan de waarden daarvan in deze comboboxen steken
        for(int i=0;i<5;i++){
            if(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNaam().matches("Bladkleur")){
                cbBladkleurJanWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJan());
                cbBladkleurFebWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getFeb());
                cbBladkleurMaaWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMaa());
                cbBladkleurAprWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getApr());
                cbBladkleurMeiWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMei());
                cbBladkleurJunWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJun());
                cbBladkleurJulWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJul());
                cbBladkleurAugWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getAug());
                cbBladkleurSeptWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getSep());
                cbBladkleurOktWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getOkt());
                cbBladkleurNovWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNov());
                cbBladkleurDecWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getDec());
            }
        }

        //selectie insteken van bladkleur, overlopen van lijst voor eigenschap met bloeikleur te vinden, dan de waarden daarvan in deze comboboxen steken
        for(int i=0;i<5;i++){
            if(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNaam().matches("Bloeikleur")){
                cbBloeikleurJanWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJan());
                cbBloeikleurFebWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getFeb());
                cbBloeikleurMaaWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMaa());
                cbBloeikleurAprWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getApr());
                cbBloeikleurMeiWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getMei());
                cbBloeikleurJunWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJun());
                cbBloeikleurJulWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getJul());
                cbBloeikleurAugWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getAug());
                cbBloeikleurSeptWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getSep());
                cbBloeikleurOktWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getOkt());
                cbBloeikleurNovWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getNov());
                cbBloeikleurDecWz.getSelectionModel().select(ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i).getDec());
            }
        }
    }

    public void KleurenCBToevoegen() throws SQLException{
        //verbinding maken voor het vinden van kleuren
        dbConnection = Database.getInstance().getConnection();
        InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
        infoTables = infotablesDAO.getInfoTables();
        ArrayList<String> kleuren = infoTables.getKleuren();

        //kleuren toevoegen aan comboboxen
        cbBladkleurJanWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurJanWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurFebWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurFebWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurMaaWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurMaaWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurAprWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurAprWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurMeiWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurMeiWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurJunWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurJunWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurJulWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurJulWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurAugWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurAugWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurSeptWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurSeptWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurOktWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurOktWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurNovWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurNovWz.getItems().addAll(infoTables.getKleuren());

        cbBladkleurDecWz.getItems().addAll(infoTables.getKleuren());
        cbBloeikleurDecWz.getItems().addAll(infoTables.getKleuren());
    }

    public void ToevoegenCommensalismeMulti(MouseEvent mouseEvent) {
    }

    public void ToevoegenAbiotischeMulti(MouseEvent mouseEvent) {
    }

    public void Clicked_PlantToevoegen(MouseEvent mouseEvent) {
    }
}
