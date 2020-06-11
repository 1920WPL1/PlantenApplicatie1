package plantenApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import plantenApp.java.dao.*;
import plantenApp.java.model.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerOverzicht {
    public ImageView ivHabitusDetailO;
    public ImageView ivBladDetailO;
    public ImageView ivBloeiDetailO;
    public ListView lvFrequentieO;
    public ListView lvBeheerbehandelingO;
    public Label lblTypeO;
    public Label lblFamilieO;
    public Label lblGeslachtO;
    public Label lblSoortO;
    public Label lblVariantO;
    public Label lblOntwikkelingssnelheidO;
    public CheckBox rbSociabiliteit1O;
    public CheckBox rbSociabiliteit2O;
    public CheckBox rbSociabiliteit3O;
    public CheckBox rbSociabiliteit5O;
    public CheckBox rbSociabiliteit4O;
    public Label lblStrategieO;
    public Label lblLevensduurO;
    public Label lblXO;
    public Label lblYO;
    public Label lblBezonningO;
    public Label lblVochtbehoefteO;
    public Label lblVoedingsbehoefteO;
    public Label lblReactieO;
    public Label lblGrondsoortO;
    public ListView lvHabitatO;
    public Label lblNectarwaardeO;
    public Label lblPollenwaardeO;
    public Label lblBijvriendelijkO;
    public Label lblVlindervriendelijkO;
    public Label lblEetbaarO;
    public Label lblKruidgebruikO;
    public Label lblGeurendO;
    public Label lblVorstgevoeligO;
    public Label lblHabitusO;
    public ImageView ivHabitusO;
    public Label lblBladgrootteO;
    public Label lblBladvormO;
    public Label lblRatioO;
    public Label lblSpruitfenologieO;
    public Label lblLevensvormO;
    public Label lblBloeiwijzeO;
    public ImageView ivBloeiwijzeO;
    public Label bladhoogteMaxJanO;
    public Label bladkleurJanO;
    public Label bladkleurFebO;
    public Label bladkleurMaaO;
    public Label bladkleurAprO;
    public Label bladkleurMeiO;
    public Label bladkleurJunO;
    public Label bladkleurJulO;
    public Label bladkleurAugO;
    public Label bladkleurSeptO;
    public Label bladkleurOktO;
    public Label bladkleurNovO;
    public Label bladkleurDecO;
    public Label bloeihoogteMinJanO;
    public Label bloeihoogteMinFebO;
    public Label bloeihoogteMinMaartO;
    public Label bloeihoogteMinAprilO;
    public Label bloeihoogteMinMeiO;
    public Label bloeihoogteMinJunO;
    public Label bloeihoogteMinJulO;
    public Label bloeihoogteMinAugO;
    public Label bloeihoogteMinSeptO;
    public Label bloeihoogteMinOktO;
    public Label bloeihoogteMinNovO;
    public Label bloeihoogteMinDecO;
    public Label bloeihoogteMaxJanO;
    public Label bloeihoogteMaxFebO;
    public Label bloeihoogteMaxMaartO;
    public Label bloeihoogteMaxAprO;
    public Label bloeihoogteMaxMeiO;
    public Label bloeihoogteMaxJunO;
    public Label bloeihoogteMaxJulO;
    public Label bloeihoogteMaxAugO;
    public Label bloeihoogteMaxSeptO;
    public Label bloeihoogteMaxOktO;
    public Label bloeihoogteMaxNovO;
    public Label bloeihoogteMaxDecO;
    public Label bloeikleurJanO;
    public Label bloeikleurFebO;
    public Label bloeikleurMaartO;
    public Label bloeikleurAprilO;
    public Label bloeikleurMeiO;
    public Label bloeikleurJunO;
    public Label bloeikleurJuliO;
    public Label bloeikleurAugO;
    public Label bloeikleurSeptO;
    public Label bloeikleurOktO;
    public Label bloeikleurNovO;
    public Label bloeikleurDecO;
    public Label bladhoogteMaxFebO;
    public Label bladhoogteMaxMaaO;
    public Label bladhoogteMaxAprO;
    public Label bladhoogteMaxMeiO;
    public Label bladhoogteMaxJunO;
    public Label bladhoogteMaxJulO;
    public Label bladhoogteMaxAugO;
    public Label bladhoogteMaxSeptO;
    public Label bladhoogteMaxOktO;
    public Label bladhoogteMaxNovO;
    public Label bladhoogteMaxDecO;
    public ComboBox cbMaandBeheerO;
    public ListView lvLevensduurO;
    public Button Opslaanbtno;
    public Button WijzigenbtnWz;
    private Connection dbConnection;

    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();

        comboaanvullen();
        tonenPlantOpFiche(0);
    }
    public ControllerOverzicht() {
    }
    //indexArrays zegt van welke plaats in de arrays dat de functie een plant moet ophalen, nu is het hardcoded voor de eerste plaats in de arrayLists
    public void tonenPlantOpFiche(int indexArrays){
        Plant p = ControllerPlantToevoegen.plantss.get(indexArrays);
        lblTypeO.setText(p.getPlantType());
        lblFamilieO.setText(p.getFamilie());
        lblGeslachtO.setText(p.getGeslacht());
        lblSoortO.setText(p.getSoort());
        lblVariantO.setText(p.getVariatie());
        lblXO.setText(String.valueOf(p.getMinPlantdichtheid()));
        lblYO.setText(String.valueOf(p.getMaxPlantdichtheid()));

        Fenotype f = ControllerPlantToevoegen.fenotypess.get(indexArrays);
        lblBladgrootteO.setText(String.valueOf(f.getBladgrootte()));
        lblBladvormO.setText(f.getBladvorm());
        lblRatioO.setText(f.getRatio_bloei_blad());
        lblSpruitfenologieO.setText(f.getSpruitfenologie());
        lblLevensvormO.setText(String.valueOf(f.getLevensvorm()));
        lblHabitusO.setText(f.getHabitus());
        lblBloeiwijzeO.setText(f.getBloeiwijze());
        int a = 5*indexArrays;//beginplaats in de arraylist
        int b = a + 5;//eindplaats in de arraylist
        //Bladhoogte Bladkleur Min Bloeihoogte Max Bloeihoogte Bloeikleur
        for(int i = a; i<b;i++){
            FenoMulti_Eigenschap fme = ControllerPlantToevoegen.fenoMulti_eigenschapss.get(i);
            if(fme.getNaam().matches("Bladhoogte")){
                bladhoogteMaxJanO.setText(fme.getJan());
                bladhoogteMaxFebO.setText(fme.getFeb());
                bladhoogteMaxMaaO.setText(fme.getMaa());
                bladhoogteMaxAprO.setText(fme.getApr());
                bladhoogteMaxMeiO.setText(fme.getMei());
                bladhoogteMaxJunO.setText(fme.getJun());
                bladhoogteMaxJulO.setText(fme.getJul());
                bladhoogteMaxAugO.setText(fme.getAug());
                bladhoogteMaxSeptO.setText(fme.getSep());
                bladhoogteMaxOktO.setText(fme.getOkt());
                bladhoogteMaxNovO.setText(fme.getNov());
                bladhoogteMaxDecO.setText(fme.getDec());
            }
            if(fme.getNaam().matches("Bladkleur")){
                bladkleurJanO.setText(fme.getJan());
                bladkleurFebO.setText(fme.getFeb());
                bladkleurMaaO.setText(fme.getMaa());
                bladkleurAprO.setText(fme.getApr());
                bladkleurMeiO.setText(fme.getMei());
                bladkleurJunO.setText(fme.getJun());
                bladkleurJulO.setText(fme.getJul());
                bladkleurAugO.setText(fme.getAug());
                bladkleurSeptO.setText(fme.getSep());
                bladkleurOktO.setText(fme.getOkt());
                bladkleurNovO.setText(fme.getNov());
                bladkleurDecO.setText(fme.getDec());
            }
            if(fme.getNaam().matches("Bloeikleur")){
                bloeikleurJanO.setText(fme.getJan());
                bloeikleurFebO.setText(fme.getFeb());
                bloeikleurMaartO.setText(fme.getMaa());
                bloeikleurAprilO.setText(fme.getApr());
                bloeikleurMeiO.setText(fme.getMei());
                bloeikleurJunO.setText(fme.getJun());
                bloeikleurJuliO.setText(fme.getJul());
                bloeikleurAugO.setText(fme.getAug());
                bloeikleurSeptO.setText(fme.getSep());
                bloeikleurOktO.setText(fme.getOkt());
                bloeikleurNovO.setText(fme.getNov());
                bloeikleurDecO.setText(fme.getDec());
            }
            if(fme.getNaam().matches("Min Bloeihoogte")){
                bloeihoogteMinJanO.setText(fme.getJan());
                bloeihoogteMinFebO.setText(fme.getFeb());
                bloeihoogteMinMaartO.setText(fme.getMaa());
                bloeihoogteMinAprilO.setText(fme.getApr());
                bloeihoogteMinMeiO.setText(fme.getMei());
                bloeihoogteMinJunO.setText(fme.getJun());
                bloeihoogteMinJulO.setText(fme.getJul());
                bloeihoogteMinAugO.setText(fme.getAug());
                bloeihoogteMinSeptO.setText(fme.getSep());
                bloeihoogteMinOktO.setText(fme.getOkt());
                bloeihoogteMinNovO.setText(fme.getNov());
                bloeihoogteMinDecO.setText(fme.getDec());
            }
            if(fme.getNaam().matches("Max Bloeihoogte")){
                bloeihoogteMaxJanO.setText(fme.getJan());
                bloeihoogteMaxFebO.setText(fme.getFeb());
                bloeihoogteMaxMaartO.setText(fme.getMaa());
                bloeihoogteMaxAprO.setText(fme.getApr());
                bloeihoogteMaxMeiO.setText(fme.getMei());
                bloeihoogteMaxJunO.setText(fme.getJun());
                bloeihoogteMaxJulO.setText(fme.getJul());
                bloeihoogteMaxAugO.setText(fme.getAug());
                bloeihoogteMaxSeptO.setText(fme.getSep());
                bloeihoogteMaxOktO.setText(fme.getOkt());
                bloeihoogteMaxNovO.setText(fme.getNov());
                bloeihoogteMaxDecO.setText(fme.getDec());
            }
        }


        Extra e = ControllerPlantToevoegen.extrass.get(indexArrays);
        lblNectarwaardeO.setText(String.valueOf(e.getNectarwaarde()));
        lblPollenwaardeO.setText(String.valueOf(e.getPollenwaarde()));
        lblBijvriendelijkO.setText(e.getBijvriendelijk());
        lblVlindervriendelijkO.setText(e.getVlindervriendelijk());
        lblEetbaarO.setText(e.getEetbaar());
        lblKruidgebruikO.setText(e.getKruidgebruik());
        lblGeurendO.setText(e.getGeurend());
        lblVorstgevoeligO.setText(e.getVorstgevoelig());

        AbiotischeFactoren af = ControllerPlantToevoegen.abiotischeFactorenn.get(indexArrays);
        lblBezonningO.setText(af.getBezonning());
        lblVochtbehoefteO.setText(af.getVochtbehoefte());
        lblVoedingsbehoefteO.setText(af.getVoedingsbehoefte());
        lblReactieO.setText(af.getReactieAntagonistischeOmgeving());
        lblGrondsoortO.setText(af.getGrondsoort());
        int teller = 0;
        for(int i = 0; i<indexArrays;i++){
            teller +=ControllerPlantToevoegen.AantalPerElAbMulti.get(i);
        }
        int eindplaats = teller + ControllerPlantToevoegen.AantalPerElAbMulti.get(indexArrays);
        for(int j = teller; j<eindplaats;j++){
            lvHabitatO.getItems().add(ControllerPlantToevoegen.abiotischmulti.get(j).getValue());
        }

        Commensalisme c = ControllerPlantToevoegen.commensalismes.get(indexArrays);
        lblOntwikkelingssnelheidO.setText(c.getOntwikkelingssnelheid());
        lblStrategieO.setText(c.getStrategie());
        int tellerc = 0;
        for(int i = 0; i<indexArrays;i++){
            tellerc +=ControllerPlantToevoegen.AantalPerElCommMulti.get(i);
        }
        int eindplaatsc = tellerc + ControllerPlantToevoegen.AantalPerElCommMulti.get(indexArrays);
        for(int j = tellerc; j<eindplaatsc;j++){
            if(ControllerPlantToevoegen.commMulti_eigenschapss.get(j).getNaam().matches("sociabiliteit")){
                if(ControllerPlantToevoegen.commMulti_eigenschapss.get(j).getValue().matches("1")){rbSociabiliteit1O.setSelected(true);}
                if(ControllerPlantToevoegen.commMulti_eigenschapss.get(j).getValue().matches("2")){rbSociabiliteit2O.setSelected(true);}
                if(ControllerPlantToevoegen.commMulti_eigenschapss.get(j).getValue().matches("3")){rbSociabiliteit3O.setSelected(true);}
                if(ControllerPlantToevoegen.commMulti_eigenschapss.get(j).getValue().matches("4")){rbSociabiliteit4O.setSelected(true);}
                if(ControllerPlantToevoegen.commMulti_eigenschapss.get(j).getValue().matches("5")){rbSociabiliteit5O.setSelected(true);}
            }
            if(ControllerPlantToevoegen.commMulti_eigenschapss.get(j).getNaam().matches("levensduur")){
                lvLevensduurO.getItems().add(ControllerPlantToevoegen.commMulti_eigenschapss.get(j).getValue());
            }
        }

        //dit wordt waarschijnlijk gebruikt voor die details bovenaan het scherm van gedetailleerdefiche
        //Foto fo = ControllerPlantToevoegen.fotoss.get(indexArrays);

        //
        int tellerb = 0;
        for(int i = 0; i<indexArrays;i++){
            tellerb +=ControllerPlantToevoegen.AantalPerElBehMulti.get(i);
        }
        int eindplaatsb = tellerb + ControllerPlantToevoegen.AantalPerElBehMulti.get(indexArrays);
        for(int j = tellerb; j<eindplaatsb;j++){
            Beheerdaad_Eigenschap beheerdaad_e = ControllerPlantToevoegen.beheerdaad_eigenschapss.get(j);
            switch((String)cbMaandBeheerO.getValue()){
                case "januari":
                    if(beheerdaad_e.getMaand().matches("januari")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "februari":
                    if(beheerdaad_e.getMaand().matches("febuari")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "maart":
                    if(beheerdaad_e.getMaand().matches("maart")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "april":
                    if(beheerdaad_e.getMaand().matches("april")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "mei":
                    if(beheerdaad_e.getMaand().matches("mei")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "juni":
                    if(beheerdaad_e.getMaand().matches("juni")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "juli":
                    if(beheerdaad_e.getMaand().matches("juli")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "augustus":
                    if(beheerdaad_e.getMaand().matches("augustus")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "september":
                    if(beheerdaad_e.getMaand().matches("september")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "oktober":
                    if(beheerdaad_e.getMaand().matches("oktober")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "november":
                    if(beheerdaad_e.getMaand().matches("november")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
                case "december":
                    if(beheerdaad_e.getMaand().matches("december")){
                        lvBeheerbehandelingO.getItems().add(beheerdaad_e.getNaam());
                        lvFrequentieO.getItems().add(beheerdaad_e.getFrequentie());
                    } break;
            }
        }
    }
    public void comboaanvullen()  {
        cbMaandBeheerO.getItems().add(0,"Januari");
        cbMaandBeheerO.getItems().add(1,"Februari");
        cbMaandBeheerO.getItems().add(2,"Maart");
        cbMaandBeheerO.getItems().add(3,"April");
        cbMaandBeheerO.getItems().add(4,"Mei");
        cbMaandBeheerO.getItems().add(5,"Juni");
        cbMaandBeheerO.getItems().add(6,"Juli");
        cbMaandBeheerO.getItems().add(7,"Augustus");
        cbMaandBeheerO.getItems().add(8,"September");
        cbMaandBeheerO.getItems().add(9, "Oktober");
        cbMaandBeheerO.getItems().add(10, "November");
        cbMaandBeheerO.getItems().add(11, "December");
        cbMaandBeheerO.getSelectionModel().select(0);
    }



    public void test(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("test");
        lvFrequentieO.getItems().clear();
        lvBeheerbehandelingO.getItems().clear();
        for (int i = 0 ; i < ControllerPlantToevoegen.beheerdaad_eigenschapss.size(); i++)
        {
            if(ControllerPlantToevoegen.beheerdaad_eigenschapss.get(i).getMaand() ==  cbMaandBeheerO.getValue())
            {
                lvFrequentieO.getItems().add(ControllerPlantToevoegen.beheerdaad_eigenschapss.get(i).getFrequentie());
                lvBeheerbehandelingO.getItems().add(ControllerPlantToevoegen.beheerdaad_eigenschapss.get(i).getNaam());
            }
        }
    }

    public void opslaanbtn_clicked(MouseEvent mouseEvent) throws Exception {
        createdatabase(ControllerPlantToevoegen.plantss.get(0),ControllerPlantToevoegen.abiotischeFactorenn.get(0),ControllerPlantToevoegen.fenotypess.get(0),ControllerPlantToevoegen.fenoMulti_eigenschapss,ControllerPlantToevoegen.abiotischmulti,ControllerPlantToevoegen.commensalismes.get(0),ControllerPlantToevoegen.commMulti_eigenschapss,ControllerPlantToevoegen.beheerdaad_eigenschapss,ControllerPlantToevoegen.extrass.get(0));
    }
    public  void createdatabase(Plant plant , AbiotischeFactoren abiotischeFactoren , Fenotype fenotype , ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschaps , ArrayList<AbioMulti_Eigenschap> abiottisschemulti_eigenschaps,Commensalisme commensalisme, ArrayList<CommMulti_Eigenschap> commMulti_eigenschaps,ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschaps, Extra extra) throws Exception {
    try {
        PlantDAO plantDAO = new PlantDAO(dbConnection);
        AbiotischeFactorenDAO abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        FenotypeDAO fenotypeDAO = new FenotypeDAO(dbConnection);
        AbiotischeFactorenDAO abiotischeMultidao = new AbiotischeFactorenDAO(dbConnection);
        CommensalismeDAO commensalismeDAO = new CommensalismeDAO(dbConnection);
        BeheerDAO beheerDAO = new BeheerDAO(dbConnection);
        ExtraDAO extraDAO = new ExtraDAO(dbConnection);
        createNaam();
        System.out.println(plant.getLaatste_update_door());
        plantDAO.createplant(plant,plant.getStatus(),plant.getLaatste_update_door());
        abiotischeFactorenDAO.CreateAbiostische(abiotischeFactoren);
        fenotypeDAO.createfenotype(fenotype);
        for (int j = 0; j < fenoMulti_eigenschaps.size(); j++) {
            fenotypeDAO.createfenomulti(fenoMulti_eigenschaps.get(j), plant.getId());
        }
        for (int f = 0; f < abiottisschemulti_eigenschaps.size(); f++) {
            abiotischeMultidao.CreateAbiotischeMulti(abiottisschemulti_eigenschaps.get(f), plant.getId());
        }
        commensalismeDAO.createCommensalisme(commensalisme);
        for (int m = 0; m < commMulti_eigenschaps.size(); m++) {
            commensalismeDAO.createCommensalismeMulti(commMulti_eigenschaps.get(m));
        }
        for (int a = 0; a < beheerdaad_eigenschaps.size(); a++) {
            beheerDAO.createBeheer(beheerdaad_eigenschaps.get(a), plant.getId());
        }
        //lorem ipsumetcetera hablahabla wout komaan zingen gast
        extraDAO.createExtra(extra);
    }
        catch (Exception ex)
    {
        ShowError("doorsturen data naar volgend scherm", "Er is een fout opgetreden bij het doorsturen van de data naar het volgend scherm.");
        System.out.println(ex);
        throw new Exception();
    }
    }
    public void createNaam() throws SQLException {
        NaamDao naamDAO = new NaamDao(dbConnection);

        Plant plant = new Plant(ControllerPlantToevoegen.plantss.get(0).getPlantType(), ControllerPlantToevoegen.plantss.get(0).getFamilie(), ControllerPlantToevoegen.plantss.get(0).getGeslacht(), ControllerPlantToevoegen.plantss.get(0).getSoort(), ControllerPlantToevoegen.plantss.get(0).getVariatie());


        //Controle of plantnaam al bestaat gebeurd al in createplant
        int iDubbeleNaam = naamDAO.ControleDubbeleNaam(plant);
        if (iDubbeleNaam == 0) {
            naamDAO.createNaam(plant);
        } else {
            ShowError("Error bij toevoegen plant", "Deze plant bestaat al.");
        }
    }
    public void ShowError(String sTitel, String sMessage) {
        //tonen van error
        JOptionPane.showMessageDialog(null, sMessage, "InfoBox: " + sTitel, JOptionPane.INFORMATION_MESSAGE);

    }

    public void WijzigenbtnWz_clicked(MouseEvent mouseEvent) throws IOException {
        openNieuwScherm(mouseEvent);
    }
    public void openNieuwScherm(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/PlantWijzigen.fxml"));
        Scene scen = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scen);
        window.show();
        window.setMaximized(true);
        System.out.println("controlleroverzicht");
    }
}

