package plantenApp;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import plantenApp.java.dao.InfoTablesDAO;
import plantenApp.java.model.InfoTables;

import java.sql.Connection;
import java.sql.SQLException;

public class ControllerWijzigen {
    public Slider slNectarwaardeWz;
    public Label NectarwaardeValueTv;
    public Slider slPollenwaardeWz;
    public Label PollenValueTv;
    public RadioButton rbBijvriendelijkNullWz;
    public ToggleGroup BijvriendelijkGroepTv;
    public RadioButton rbBijvriendelijkJaWz;
    public RadioButton rbBijvriendelijkNeeWz;
    public RadioButton rbVlindervriendelijkNullWz;
    public RadioButton rbVlindervriendelijkJaWz;
    public RadioButton rbVlindervriendelijkNeeWz;
    public ToggleGroup VlindervriendelijkGroepTv;
    public RadioButton rbEetbaarNullWz;
    public ToggleGroup EetbaarGroepTv;
    public RadioButton rbEetbaarJaWz;
    public RadioButton rbEetbaarNeeWz;
    public RadioButton rbKruidgebruikNullWz;
    public ToggleGroup KruidgebruikGroepTv;
    public RadioButton rbKruidgebruikJaWz;
    public RadioButton rbKruidgebruikNeeWz;
    public RadioButton rbGeurendNullWz;
    public RadioButton rbGeurendJaWz;
    public RadioButton rbGeurendNeeWz;
    public RadioButton rbVorstgevoeligNullWz;
    public ToggleGroup VorstgevoeligGroepTv;
    public RadioButton rbVorstgevoeligJaWz;
    public RadioButton rbVorstgevoeligNeeWz;
    public ListView lvLevensduurTv;
    public ComboBox cbLevensduurTv;
    private InfoTables infoTables;
    private Connection dbConnection;
    public ComboBox cboTypeWz;
    public TextField txtFamilieWz;
    public TextField txtGeslachtWz;
    public TextField txtSoortWz;
    public TextField txtVariantWz;
    public TextField txtDichtheidXWz;
    public TextField txtDichtheidYWz;
    public ComboBox cbBladgrootteTotWz;
    public ComboBox cbBladvormWz;
    public ComboBox cbRatioWz;
    public ComboBox cbSpruitfenologieWz;
    public RadioButton rbHydro1Wz;
    public RadioButton rbHydro2Wz;
    public RadioButton rbHeloWz;
    public RadioButton rbCrypto1Wz;
    public ToggleGroup LevensvormGroepTv;
    public RadioButton rbCrypto2Wz;
    public RadioButton rbHemikryptoWz;
    public RadioButton rbChamae1Wz;
    public RadioButton rbChamae2Wz;
    public RadioButton rbFaneroWz;

    public void initialize() throws SQLException {
        LadenPlant();
        LadenFenotype();
        LadenExtra();
        Pollenwaarde();
        //infotabel object aanmaken*/
       // InfoTablesDAO infotablesDAO = new InfoTablesDAO(dbConnection);
       // infoTables = infotablesDAO.getInfoTables();
        /*comboboxes vullen*/
        //FillComboboxes(infoTables);
    }

    public void Pollenwaarde()    {
        slNectarwaardeWz.setMax(5);
        slPollenwaardeWz.setMax(5);
        //Change value
        PollenValueTv.textProperty().bind(
                Bindings.format(
                        "%.0f",
                        slPollenwaardeWz.valueProperty()
                )
        );
        NectarwaardeValueTv.textProperty().bind(
                Bindings.format(
                        "%.0f",
                        slNectarwaardeWz.valueProperty()
                )
        );
    }

    public void LadenExtra()    {
        slNectarwaardeWz.setValue( ControllerPlantToevoegen.extrass.get(0).getNectarwaarde());
        slPollenwaardeWz.setValue(ControllerPlantToevoegen.extrass.get(0).getPollenwaarde());
        Selecteerjuisteradiobutton(rbBijvriendelijkJaWz,rbBijvriendelijkNeeWz,rbBijvriendelijkNullWz, ControllerPlantToevoegen.extrass.get(0).getBijvriendelijk());
        Selecteerjuisteradiobutton(rbVlindervriendelijkJaWz,rbVlindervriendelijkNeeWz,rbVlindervriendelijkNullWz, ControllerPlantToevoegen.extrass.get(0).getVlindervriendelijk());
        Selecteerjuisteradiobutton(rbEetbaarJaWz,rbEetbaarNeeWz,rbEetbaarNullWz,ControllerPlantToevoegen.extrass.get(0).getEetbaar());
        Selecteerjuisteradiobutton(rbKruidgebruikJaWz,rbKruidgebruikNeeWz,rbKruidgebruikNullWz,ControllerPlantToevoegen.extrass.get(0).getKruidgebruik());
        Selecteerjuisteradiobutton(rbGeurendJaWz,rbGeurendNeeWz,rbGeurendNullWz,ControllerPlantToevoegen.extrass.get(0).getGeurend());
        Selecteerjuisteradiobutton(rbVorstgevoeligJaWz,rbVorstgevoeligNeeWz,rbVorstgevoeligNullWz,ControllerPlantToevoegen.extrass.get(0).getVorstgevoelig());
    }
    public void Selecteerjuisteradiobutton(RadioButton buttonja , RadioButton buttonnee , RadioButton buttonnull, String waarde)    {
        if(waarde =="ja")
        {
            buttonja.setSelected(true);
        }
        if(waarde == "nee")
        {
            buttonnee.setSelected(true);
        }
        if(waarde == "null")
        {
            buttonnull.setSelected(true);
        }
    }
    public void ToevoegenCommensalismeMulti(MouseEvent mouseEvent) {
        if (!lvLevensduurTv.getItems().contains(cbLevensduurTv.getValue())) {
            lvLevensduurTv.getItems().add((String) cbLevensduurTv.getValue());
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
    public void FillComboboxes(InfoTables infotables) {
        //type
        /*System.out.println(infotables.getPlantTypes().toString());
        cboTypeTv.getItems().addAll(infotables.getPlantTypes());

        //Bezonning
        cbBezonningTv.getItems().addAll(infotables.getBezonningsMogelijkheden());

        //Voedingsbehoefte
        cbVoedingsbehoefteTv.getItems().addAll(infotables.getVoedingsbehoeftes());

        //Vochtbehoefte
        cbVochtbehoefteTv.getItems().addAll(infotables.getVochtbehoeftes());

        //bladgrootte
        cbBladgrootteTotTv.getItems().addAll(infotables.getBladgroottes());
        //bladvorm
        cbBladvormTv.getItems().addAll(infotables.getBladvormen());
        //Grondsoort
        cbGrondsoortTv.getItems().addAll(infotables.getGrondsoorten());

        //BehandelingMaand
        //cboMaand.getItems().addAll("Januari", "februari", "maart", "april", "mei", "juni", "juli","augustus","september", "oktober", "november", "december");
        //ratio
        cbRatioTv.getItems().addAll(infotables.getBloeiBladRatios());
        //spruitfenologie
        cbSpruitfenologieTv.getItems().addAll(infotables.getSpruitfenologieen());
        //reactie antagonistische omgeving
        cbReactieAntaTv.getItems().addAll(infotables.getAntagonistischeOmgevingsReacties());
        //behandeling

        //Kleuren
        //Jan
        cbBladkleurJanTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurJanTv.getItems().addAll(infotables.getKleuren());
        //Feb
        cbBladkleurFebTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurFebTv.getItems().addAll(infotables.getKleuren());
        //Maart
        cbBladkleurMaaTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurMaaTv.getItems().addAll(infotables.getKleuren());
        //April
        cbBladkleurAprTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurAprTv.getItems().addAll(infotables.getKleuren());
        //Mei
        cbBladkleurMeiTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurMeiTv.getItems().addAll(infotables.getKleuren());
        //Juni
        cbBladkleurJunTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurJunTv.getItems().addAll(infotables.getKleuren());
        //Juli
        cbBladkleurJulTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurJulTv.getItems().addAll(infotables.getKleuren());
        //Augustus
        cbBladkleurAugTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurAugTv.getItems().addAll(infotables.getKleuren());
        //September
        cbBladkleurSeptTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurSeptTv.getItems().addAll(infotables.getKleuren());
        //Oktober
        cbBladkleurOktTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurOktTv.getItems().addAll(infotables.getKleuren());
        //November
        cbBladkleurNovTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurNovTv.getItems().addAll(infotables.getKleuren());
        //November
        cbBladkleurDecTv.getItems().addAll(infotables.getKleuren());
        cbBloeikleurDecTv.getItems().addAll(infotables.getKleuren());

        //Habitat
        cbHabitatTv.getItems().addAll(infotables.getHabitats());

        //Ontwikkelingssnelheid
        cbOntwikkelingssnelheidTv.getItems().addAll(infotables.getOnstwikkelingssnelheden());*/

        //Levensduur
        cbLevensduurTv.getItems().addAll(infotables.getConcurentiekrachten());
    }
    public void ToevoegenAbiotischeMulti(MouseEvent mouseEvent) {
    }
    public void Clicked_PlantToevoegen(MouseEvent mouseEvent) {
    }
    public void LadenPlant() {
        //Omzetten integer naar string
        int dichtheidX = ControllerPlantToevoegen.plantss.get(0).getMinPlantdichtheid();
        int dichtheidY = ControllerPlantToevoegen.plantss.get(0).getMaxPlantdichtheid();

        //Values instellen
        cboTypeWz.getSelectionModel().select(ControllerPlantToevoegen.plantss.get(0).getPlantType());;
        txtFamilieWz.setText(ControllerPlantToevoegen.plantss.get(0).getFamilie());
        txtGeslachtWz.setText(ControllerPlantToevoegen.plantss.get(0).getGeslacht());
        txtSoortWz.setText(ControllerPlantToevoegen.plantss.get(0).getSoort());
        txtVariantWz.setText(ControllerPlantToevoegen.plantss.get(0).getVariatie());
        txtDichtheidXWz.setText(String.valueOf(dichtheidX));
        txtDichtheidYWz.setText(String.valueOf(dichtheidY));
    }
    public void LadenFenotype() {
        //Comboboxes laden
        cbBladgrootteTotWz.getSelectionModel().select(ControllerPlantToevoegen.fenotypess.get(0).getBladgrootte());
        cbBladvormWz.getSelectionModel().select(ControllerPlantToevoegen.fenotypess.get(0).getBladvorm());
        cbRatioWz.getSelectionModel().select(ControllerPlantToevoegen.fenotypess.get(0).getRatio_bloei_blad());
        cbSpruitfenologieWz.getSelectionModel().select(ControllerPlantToevoegen.fenotypess.get(0).getSpruitfenologie());
        String waarde = ControllerPlantToevoegen.fenotypess.get(0).getLevensvorm();
        //Radiobuttons laden
        if (waarde == "1. Hydrofyt") {
            rbHydro1Wz.setSelected(true);
        }
        else if (waarde == "2. Hydrofyt") {
            rbHydro2Wz.setSelected(true);
        }
        else if (waarde == "3. Helofyt") {
            rbHeloWz.setSelected(true);
        }
        else if (waarde == "4. Cryptophyt") {
            rbCrypto1Wz.setSelected(true);
        }
        else if (waarde == "5. Cryptophyt") {
            rbCrypto2Wz.setSelected(true);
        }
        else if (waarde == "6. Hemikryptofyt") {
            rbHemikryptoWz.setSelected(true);
        }
        else if (waarde == "7. Chamaefyt") {
            rbChamae1Wz.setSelected(true);
        }
        else if (waarde == "8. Chamaefyt") {
            rbChamae2Wz.setSelected(true);
        }
        else if (waarde == "9. Fanerophyt") {
            rbFaneroWz.setSelected(true);
        }
        else {
            System.out.println("Geen waarde voor levensvorm meegegeven");
        }
    }

}
