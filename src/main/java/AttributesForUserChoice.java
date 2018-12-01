import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttributesForUserChoice {

    private List<String> pozytywne = new ArrayList<String>();
    private List<String> negatywne = new ArrayList<String>();
    private List<String> nastroj = new ArrayList<String>();
    private List<String> okres = new ArrayList<String>();
    private List<String> instrument = new ArrayList<String>();

    public AttributesForUserChoice() {
        pozytywne = Arrays.asList("taneczny", "growl", "big_band", "koreanski");
        negatywne = Arrays.asList("wokal");
        nastroj = Arrays.asList("melancholijny", "energiczny");
        okres = Arrays.asList("lata_60", "lata_70", "lata_2000", "lata_30", "wiek_19", "wiek_18", "lata_2010", "lata_80", "lata_90", "lata_40");
        instrument = Arrays.asList("gitara_elektryczna", "gitara_basowa", "perkusja", "gitara_akustyczna", "skrzypce", "banjo", "harmonijka", "saksofon", "trabka", "pianino", "kontrabas", "harfa", "sprzet_elektroniczny", "mellotron");
    }

    public List<String> getPozytywne() {
        return pozytywne;
    }

    public List<String> getNegatywne() {
        return negatywne;
    }

    public List<String> getNastroj() {
        return nastroj;
    }

    public List<String> getOkres() {
        return okres;
    }

    public List<String> getInstrument() {
        return instrument;
    }
}
