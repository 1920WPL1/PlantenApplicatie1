package plantenApp;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import plantenApp.java.model.*;

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
    public ArrayList<Plant> plants = new ArrayList<>();
    public ArrayList<AbiotischeFactoren> abiotischeFactoren = new ArrayList<>();
    public  ArrayList<AbioMulti_Eigenschap> abiotischmultis = new ArrayList<>();
    public ArrayList<Commensalisme> commensalisme = new ArrayList<>();
    public  ArrayList<CommMulti_Eigenschap> commMulti_eigenschaps = new ArrayList<>();
    public ArrayList<Extra> extras = new ArrayList<>();
    public  ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschaps = new ArrayList<>();
    public ArrayList<Fenotype> fenotypes = new ArrayList<>();
    public ArrayList<Foto> fotos = new ArrayList<>();
    public  ArrayList<Beheer> beheers = new ArrayList<>();
    public  ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschaps = new ArrayList<>();

    public ControllerOverzicht( ArrayList<Plant> plantss, ArrayList<AbiotischeFactoren> abiotischeFactorenn, ArrayList<AbioMulti_Eigenschap> abiotischmulti, ArrayList<Commensalisme> commensalismes, ArrayList<CommMulti_Eigenschap> commMulti_eigenschapss, ArrayList<Extra> extrass, ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschapss, ArrayList<Fenotype> fenotypess,  ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschapss) {
        this.plants = plantss;
        this.abiotischeFactoren = abiotischeFactorenn;
        this.abiotischmultis = abiotischmulti;
        this.commensalisme = commensalismes;
        this.commMulti_eigenschaps = commMulti_eigenschapss;
        this.extras = extrass;
        this.fenoMulti_eigenschaps = fenoMulti_eigenschapss;
        this.fenotypes = fenotypess;
        this.beheerdaad_eigenschaps = beheerdaad_eigenschapss;
        System.out.println(plants.get(0).getFgsv());
        System.out.println(abiotischeFactoren.size());
        System.out.println(abiotischmultis.size());
        System.out.println(fenotypes.size());
        System.out.println(fenoMulti_eigenschaps.size());
    }
    public void lijstenvullen(ArrayList<Plant> plantss, ArrayList<AbiotischeFactoren> abiotischeFactorenn, ArrayList<AbioMulti_Eigenschap> abiotischmulti, ArrayList<Commensalisme> commensalismes, ArrayList<CommMulti_Eigenschap> commMulti_eigenschapss, ArrayList<Extra> extrass, ArrayList<FenoMulti_Eigenschap> fenoMulti_eigenschapss, ArrayList<Fenotype> fenotypess,  ArrayList<Beheerdaad_Eigenschap> beheerdaad_eigenschapss)
    {
        plants.addAll(plantss);
        abiotischeFactoren.addAll( abiotischeFactorenn);
        commensalisme.addAll(commensalismes);
        abiotischmultis.addAll(abiotischmulti);
        commMulti_eigenschaps.addAll(commMulti_eigenschapss);
        extras.addAll(extrass);
        fenoMulti_eigenschaps.addAll(fenoMulti_eigenschapss);
        fenotypes.addAll(fenotypess);
        beheerdaad_eigenschaps.addAll(beheerdaad_eigenschapss);
        System.out.println(plantss.size());
        System.out.println(abiotischeFactoren.size());
        System.out.println(abiotischmultis.size());
        System.out.println(commensalisme.size());
        System.out.println(fenoMulti_eigenschaps.size());
    }

    public ControllerOverzicht() {
    }

    public void tonenPlantOpFiche(int indexArrays){
        Plant p = plants.get(indexArrays);
        lblTypeO.setText(p.getType());
        lblFamilieO.setText(p.getFamilie());
        lblGeslachtO.setText(p.getGeslacht());
        lblSoortO.setText(p.getSoort());
        lblVariantO.setText(p.getVariatie());
        lblXO.setText(String.valueOf(p.getMinPlantdichtheid()));
        lblYO.setText(String.valueOf(p.getMaxPlantdichtheid()));

        Fenotype f = fenotypes.get(indexArrays);
        lblBladgrootteO.setText(String.valueOf(f.getBladgrootte()));
        lblBladvormO.setText(f.getBladvorm());
        lblRatioO.setText(f.getRatio_bloei_blad());
        lblSpruitfenologieO.setText(f.getSpruitfenologie());
        lblLevensvormO.setText(String.valueOf(f.getLevensvorm()));
        lblHabitusO.setText(f.getHabitus());
        lblBloeiwijzeO.setText(f.getBloeiwijze());
        int a = f.getMultiEigenschappen().size();
        //Bladhoogte Bladkleur Min Bloeihoogte Max Bloeihoogte Bloeikleur
        for(int i = 0; i<a;i++){
            FenoMulti_Eigenschap fme = f.getMultiEigenschappen().get(i);
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


        Extra e = extras.get(indexArrays);
        lblNectarwaardeO.setText(String.valueOf(e.getNectarwaarde()));
        lblPollenwaardeO.setText(String.valueOf(e.getPollenwaarde()));
        lblBijvriendelijkO.setText(e.getBijvriendelijk());
        lblVlindervriendelijkO.setText("Nergens in de databank of in de klasse Extra zitten er waarden voor vlindervriendelijk dus geeft ik dit label een belachelijk lange zin mee.");
        lblEetbaarO.setText(e.getEetbaar());
        lblKruidgebruikO.setText(e.getKruidgebruik());
        lblGeurendO.setText(e.getGeurend());
        lblVorstgevoeligO.setText(e.getVorstgevoelig());

        AbiotischeFactoren af = abiotischeFactoren.get(indexArrays);
        lblBezonningO.setText(af.getBezonning());
        lblVochtbehoefteO.setText(af.getVochtbehoefte());
        lblVoedingsbehoefteO.setText(af.getVoedingsbehoefte());
        lblReactieO.setText(af.getReactieAntagonistischeOmgeving());
        lblGrondsoortO.setText(af.getGrondsoort());
        int b = af.getMultiEigenschappen().size();

        Commensalisme c = commensalisme.get(indexArrays);
        lblOntwikkelingssnelheidO.setText(c.getOntwikkelingssnelheid());
        lblStrategieO.setText(c.getStrategie());

        CommMulti_Eigenschap cm = commMulti_eigenschaps.get(indexArrays);

        Foto fo = fotos.get(indexArrays);

        Beheer be = beheers.get(indexArrays);

        Beheerdaad_Eigenschap bd = beheerdaad_eigenschaps.get(indexArrays);
    }


}
