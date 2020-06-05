package plantenApp.java.dao;

public interface Queries {
    //region GETBYID
    String GETPLANTBYID = "SELECT * FROM plant WHERE plant_id = ?";
    String GETPLANTSBYIDS = "SELECT * FROM plant WHERE plant_id IN ?";

    String GETFENOTYPEBYPLANTID = "SELECT * FROM fenotype WHERE plant_id = ?";
    String GETFENOTYPEMULTIBYPLANTID = "SELECT * FROM fenotype_multi WHERE plant_id = ?";

    String GETABIOTISCHBYPLANTID = "SELECT * FROM abiotische_factoren WHERE plant_id = ?";
    String GETABIOTISCHBMULTIYPLANTID = "SELECT * FROM abiotisch_multi WHERE plant_id = ?";

    String GETCOMMENSALISMEBYPLANTID = "SELECT * FROM commensialisme WHERE plant_id = ?";
    String GETCOMMENSALISMEMULTIBYPLANTID = "SELECT * FROM commensialisme_multi WHERE plant_id = ?";

    String GETBEHEERBYPLANTID = "SELECT * FROM beheer WHERE plant_id = ?";

    String GETEXTRABYPLANTID = "SELECT * FROM extra WHERE plant_id = ?";

    String GETFOTOBYPLANTID = "SELECT * FROM foto WHERE plant_id = ?";
    //endregion

    //region GETIDSBYKENMERKEN
    String GETIDSBYPLANT =
            "SELECT plant_id FROM plant WHERE " +
                    "type = ? OR  1=? " +
                    "AND " +
                    "familie = ? OR 1=?" +
                    "AND " +
                    "fgsv LIKE ? OR 1=?";

    String GETIDSBYEXTRA =
            "SELECT plant_id FROM extra WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "nectarwaarde = ? OR 1=?" +
                    "AND " +
                    "pollenwaarde = ? OR 1=?" +
                    "AND " +
                    "bijvriendelijk = ? OR 1=?" +
                    "AND " +
                    "eetbaar = ? OR 1=?" +
                    "AND " +
                    "kruidgebruik = ? OR 1=?" +
                    "AND " +
                    "geurend = ? OR 1=?" +
                    "AND " +
                    "vorstgevoelig = ? OR 1=?";

    String GETIDSBYABIO =
            "SELECT plant_id FROM abiotische_factoren " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "bezonning = ? OR 1=?" +
                    "AND " +
                    "grondsoort = ? OR 1=?" +
                    "AND " +
                    "vochtbehoefte = ? OR 1=?" +
                    "AND " +
                    "voedingsbehoefte = ? OR 1=?" +
                    "AND " +
                    "reactie_antagonistische_omg = ? OR 1=?";
    String GETIDSBYABIOMULTI =
            "SELECT plant_id FROM abiotische_factoren " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "eigenschap = ? " +
                    "AND " +
                    "waarde = ? OR 1=?";

    String GETIDSBYCOMM =
            "SELECT plant_id FROM commensalisme " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "strategie = ? OR 1=?" +
                    "AND " +
                    "ontwikkelingssnelheid = ? OR 1=?";
    String GETIDSBYCOMMMULTI =
            "SELECT plant_id FROM commensalisme_multi " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "eigenschap = ? " +
                    "AND " +
                    "waarde = ? OR 1=?";

    String GETIDSBYFENO =
            "SELECT plant_id FROM commensalisme " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "bladvorm = ? OR 1=?" +
                    "AND " +
                    "levensvorm = ? OR 1=?" +
                    "AND " +
                    "habitus = ? OR 1=?" +
                    "AND " +
                    "bloeiwijze = ? OR 1=?" +
                    "AND " +
                    "bladgrootte = ? OR 1=?" +
                    "AND " +
                    "ratio_bloei_blad = ? OR 1=?" +
                    "AND " +
                    "spruitfenologie = ? OR 1=?";
    String GETIDSBYFENOMULTI =
            "SELECT plant_id FROM commensalisme_multi " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "eigenschap = ? " +
                    "AND " +
                    "jan = ? OR 1=?" +
                    "AND " +
                    "feb = ? OR 1=?" +
                    "AND " +
                    "maa = ? OR 1=?" +
                    "AND " +
                    "apr = ? OR 1=?" +
                    "AND " +
                    "mei = ? OR 1=?" +
                    "AND " +
                    "jun = ? OR 1=?" +
                    "AND " +
                    "jul = ? OR 1=?" +
                    "AND " +
                    "aug = ? OR 1=?" +
                    "AND " +
                    "sep = ? OR 1=?" +
                    "AND " +
                    "okt = ? OR 1=?" +
                    "AND " +
                    "nov = ? OR 1=?" +
                    "AND " +
                    "dec = ? OR 1=?";
    String GETIDSBYBEHEER =
            "SELECT plant_id FROM Beheer " +
                    "WHERE " +
                    "plant_id IN ? " +
                    "AND " +
                    "beheerdaad = ? OR 1=? " +
                    "AND " +
                    "maand = ? OR 1=?" +
                    "AND " +
                    "frequentie_jaar = ? OR 1=?";
//endregion

    //region NAAKTETABELLEN

    String NTTYPE =
            "SELECT type_naam FROM type";

    String NTFAMILIE =
            "SELECT familie_naam FROM familie";

    String NTLEVENSDUURCONCURRENTIEKRACHT =
            "SELECT waarde FROM levensduur_concurrentiekracht";

    String NTSTRATEGIE =
            "SELECT waarde FROM strategie";

    String NTONTWIKKELINGSSNELHEID =
            "SELECT waarde FROM ontwikkelingssnelheid";

    String NTVOEDINGSBEHOEFTE =
            "SELECT waarde FROM voedingsbehoefte";

    String NTVOCHTBEHOEFTE =
            "SELECT waarde FROM vochtbehoefte";

    String NTHABITAT =
            "SELECT waarde FROM habitat";

    String NTREACTIEOMGEVING =
            "SELECT waarde FROM reactieomgeving";

    String NTGRONDSOORT =
            "SELECT waarde FROM grondsoort";

    String NTBEZONNING =
            "SELECT waarde FROM bezonning";

    String NTHABITUS =
            "SELECT waarde FROM habitus";

    String NTKLEUREN =
            "SELECT kleur FROM kleuren";

    String NTBLADVORM =
            "SELECT waarde FROM bladvorm";

    String NTRATIOBLOEIBLAD =
            "SELECT waarde FROM ratio_bloeiblad";

    String NTSPRUITFENOLOGIE =
            "SELECT waarde FROM spruitfenologie";

    String NTBLOEIWIJZE =
            "SELECT waarde FROM bloeiwijze";

    String NTSOCIABILITEIT =
            "SELECT waarde FROM sociabiliteit";

    String NTBEHEERDAAD =
            "SELECT waarde FROM beheerdaad";

    String NTNECTARWAARDE =
            "SELECT waarde FROM nectarwaarde";

    String NTPOLLENWAARDE =
            "SELECT waarde FROM pollenwaarde";

    String NTBLADGROOTTE =
            "SELECT waarde FROM maxbladgrootte";

    String NTLEVENSVORM =
            "SELECT waarde FROM levensvorm";

    String NTFOTOHABITUS =
            "SELECT afbeelding FROM habitus";

    String NTFOTOBlOEIWIJZE =
            "SELECT afbeelding FROM bloeiwijze";
    String INSERTABIOTISCHEFACTOREN = "Insert into " +
            "abiotische_factoren(abiotische_id, plant_id , bezonning , grondsoort, vochtbehoefte,voedingsbehoefte,reactie_antagonistische_omg)" +
            " VALUES (?,?, ?, ?, ?, ?, ?)";

    String GetMaxId = "select Max(abiotische_id) from abiotische_factoren ";
    String GetMaxIdAbioMulti = "select Max(abiotische_id) from abiotisch_multi ";
    String Insertplant = "INSERT INTO plant" +
            " (plant_id,type, familie,geslacht,soort,variatie,plantdichtheid_min,plantdichtheid_max,fgsv,status)" +
            " VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?)";
    String getmaxplantid = "select Max(plant_id) from plant ";
    String getmaxfenotypeid = "select Max(fenotype_id) from fenotype";
    String getMaxCommensalismeID = "select Max(commensalisme_id) from commensalisme";
    ;
    String insertfenotype = "insert into fenotype(fenotype_id , plant_id,bladvorm , levensvorm,habitus,bloeiwijze,bladgrootte,ratio_bloei_blad,spruitfenologie) values(?,?,?,?,?,?,?,?,?)";
    String InsertCommensalisme = "Insert into " +
            "commensalisme(commensalisme_id, plant_id , strategie , ontwikkelingssnelheid)" +
            " VALUES (?,?,?,?)";
    String getmaxextraid = "select Max(extra_id) from extra";
    String getMaxBeheerID = "select Max(beheer_id) from beheer";
    String insertextra = "insert into " + "extra(extra_id, plant_id, nectarwaarde, pollenwaarde, bijvriendelijk, eetbaar_kruidgebruik, geurend, vorstgevoelig)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    String getmaxfotoid = "select Max(foto_id) from foto";
    String insertfoto = "insert into " + "foto(foto_id, plant_id, eigenschap, url, figuur)" + " VALUES (?, ?, ?, ?, ?)";
    String inserfenomulti = "insert into fenotype_multi(fenotype_id , plant_id,eigenschap , jan,feb,maa,apr,mei,jun,jul,aug,sep,okt,nov,dec) values(? , ?,? , ?,?,?,?,?,?,?,?,?,?,?,?)";
    String Getmaxidmulti = "select Max(fenotype_id) from fenotype_multi";
    String insertBeheer = "insert into " + "beheer(beheer_id, plant_id, beheerdaad, opmerking, maand, frequentie_jaar)" +
            " VALUES (?, ?, ?, ?, ?, ?)";

    String InsertCommensalismeMulti = "insert into commensalisme_multi(plant_id, eigenschap, waarde)" +
            " VALUES (?, ?, ?)";
    String INSERTABIOTISCHEFACTORENMULTI = "Insert into " +
            "abiotisch_multi(plant_id , eigenschap, waarde) " +
            " VALUES (?, ?, ?) ";

    //Queries voor toevoegen naam
    String SelectDubbeleNaam = "select COUNT(*) from familie f,geslacht g,soort s,variatie v, type t " +
            "where t.type_naam = ? and f.familie_naam = ? and g.geslacht_naam = ? and s.soort_naam = ? and v.variatie_naam = ? "+
    "and f.familie_id = g.familie_id and g.geslacht_id = s.geslacht_id and s.soort_id = v.variatie_id";
    String SelectTypeID = "select type_id from type where type_naam = ?";
    String InsertFamilie = "insert into familie(familie_naam,type_id) values(?,?)";
    String SelectFamilieID = "select familie_id from familie where familie_naam = ?";
    String InsertGeslacht = "insert into geslacht(geslacht_naam,familie_id) values(?,?)";
    String SelectGeslachtID = "select geslacht_id from geslacht where geslacht_naam = ?";
    String InsertSoort = "insert into soort(soort_naam,geslacht_id) values(?,?)";
    String SelectSoortID = "select soort_id from soort where soort_naam = ?";
    String InsertVariatie = "insert into variatie(variatie_naam,soort_id) values(?,?)";
    //endregion
}

