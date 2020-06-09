package plantenApp;

import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class ControllerWijzigen {

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

    public void ToevoegenCommensalismeMulti(MouseEvent mouseEvent) {
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
        cboTypeWz.getItems().add(ControllerPlantToevoegen.plantss.get(0).getPlantType());
        txtFamilieWz.setText(ControllerPlantToevoegen.plantss.get(0).getFamilie());
        txtGeslachtWz.setText(ControllerPlantToevoegen.plantss.get(0).getGeslacht());
        txtSoortWz.setText(ControllerPlantToevoegen.plantss.get(0).getSoort());
        txtVariantWz.setText(ControllerPlantToevoegen.plantss.get(0).getVariatie());
        txtDichtheidXWz.setText(String.valueOf(dichtheidX));
        txtDichtheidYWz.setText(String.valueOf(dichtheidY));
    }

    public void LadenFenotype(RadioButton Hydrofyt1, RadioButton Hydrofyt2, RadioButton Helofyt, RadioButton Cryptophyt1, RadioButton Cryptophyt2, RadioButton Hemik, RadioButton Cham1, RadioButton Cham2, RadioButton Fan, String waarde) {
        //Comboboxes laden
        cbBladgrootteTotWz.getItems().add(ControllerPlantToevoegen.fenotypess.get(0).getBladgrootte());
        cbBladvormWz.getItems().add(ControllerPlantToevoegen.fenotypess.get(0).getBladvorm());
        cbRatioWz.getItems().add(ControllerPlantToevoegen.fenotypess.get(0).getRatio_bloei_blad());
        cbSpruitfenologieWz.getItems().add(ControllerPlantToevoegen.fenotypess.get(0).getSpruitfenologie());

        //Radiobuttons laden
        if (waarde == "1. Hydrofyt") {
            Hydrofyt1.isSelected();
        }
        else if (waarde == "2. Hydrofyt") {
            Hydrofyt2.isSelected();
        }
        else if (waarde == "3. Helofyt") {
            Helofyt.isSelected();
        }
        else if (waarde == "4. Cryptophyt") {
            Cryptophyt1.isSelected();
        }
        else if (waarde == "5. Cryptophyt") {
            Cryptophyt2.isSelected();
        }
        else if (waarde == "6. Hemikryptofyt") {
            Hemik.isSelected();
        }
        else if (waarde == "7. Chamaefyt") {
            Cham1.isSelected();
        }
        else if (waarde == "8. Chamaefyt") {
            Cham2.isSelected();
        }
        else if (waarde == "9. Fanerophyt") {
            Fan.isSelected();
        }
        else {
            System.out.println("Geen waarde voor levensvorm meegegeven");
        }
    }

}
