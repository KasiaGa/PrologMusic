import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Prolog {

    public static final String POZYTYWNE = "pozytywne";
    public static final String NEGATYWNE = "negatywne";
    public static final String NASTROJ = "nastroj";
    public static final String OKRES = "okres";
    public static final String INSTRUMENT = "instrument";

    public List<String> pozytywne = new ArrayList<String>();
    public List<String> negatywne = new ArrayList<String>();
    public List<String> nastroj = new ArrayList<String>();
    public List<String> okres = new ArrayList<String>();
    public List<String> instrument = new ArrayList<String>();

    public void initialize() {
        Query q1 =
                new Query(
                        "consult",
                        new Term[] {new Atom("./src/main/resources/music.pl")}
                );
        System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
        q1.open();
        q1.close();
    }

    public void retractAll() {
        Query retractQuery = new Query("retractall(instrument(_))");
        retractQuery.hasSolution();
        retractQuery = new Query("retractall(okres(_))");
        retractQuery.hasSolution();
        retractQuery = new Query("retractall(nastroj(_))");
        retractQuery.hasSolution();
        retractQuery = new Query("retractall(pozytywne(_))");
        retractQuery.hasSolution();
        retractQuery = new Query("retractall(negatywne(_))");
        retractQuery.hasSolution();
    }

    public String getResult() {
        retractAll();
        pozytywne.forEach(positive -> new Query("assertz(" + POZYTYWNE + "(" + positive + "))").hasSolution());
        okres.forEach(positive -> new Query("assertz(" + OKRES + "(" + positive + "))").hasSolution());
        instrument.forEach(positive -> new Query("assertz(" + INSTRUMENT + "(" + positive + "))").hasSolution());
        nastroj.forEach(positive -> new Query("assertz(" + NASTROJ + "(" + positive + "))").hasSolution());
        negatywne.forEach(positive -> new Query("assertz(" + NEGATYWNE + "(" + positive + "))").hasSolution());

        Query assertFact = new Query("artysta(X)");

        System.out.println(Arrays.toString(assertFact.allSolutions()));
        String finalResult = "";
        Map<String, Term>[] result = assertFact.allSolutions();
        for (Map<String, Term> map : result) {
            String value = map.get("X").name();
            finalResult += value;
            finalResult += ", ";
        }

        finalResult = finalResult.substring(0, finalResult.length()-2);


        return finalResult;
    }

    public static void main(String[] args) {

        Query q1 =
                new Query(
                        "consult",
                        new Term[] {new Atom("./src/main/resources/music.pl")}
                );
        System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
        q1.open();
        q1.close();


        // przyklad
        AttributesForUserChoice attributesForUserChoice = new AttributesForUserChoice();
        List<String> pozytywne = new ArrayList<String>();
        List<String> negatywne = new ArrayList<String>();
        List<String> nastroj = new ArrayList<String>();
        List<String> okres = new ArrayList<String>();
        List<String> instrument = new ArrayList<String>();

        instrument.add("sprzet_elektroniczny");
        instrument.add("banjo");
        instrument.add("harfa");
        okres.add("lata_70");
        pozytywne.add("taneczny");
        pozytywne.add("wokal");
        nastroj.add("energiczny");

        pozytywne.forEach(positive -> new Query("assertz(" + POZYTYWNE + "(" + positive + "))").hasSolution());
        okres.forEach(positive -> new Query("assertz(" + OKRES + "(" + positive + "))").hasSolution());
        instrument.forEach(positive -> new Query("assertz(" + INSTRUMENT + "(" + positive + "))").hasSolution());
        nastroj.forEach(positive -> new Query("assertz(" + NASTROJ + "(" + positive + "))").hasSolution());
        negatywne.forEach(positive -> new Query("assertz(" + NEGATYWNE + "(" + positive + "))").hasSolution());

//        new Query("assertz(" + "artysta" + "(" + "the_beatles" + "))").hasSolution();
//        new Query("assertz(" + "artysta" + "(" + "pink_floyd" + "))").hasSolution();

//        System.out.println(assertFact.hasSolution() ? "true" : "false");

//        assertFact = new Query("pozytywne(wokal)");
//
//        System.out.println(assertFact.hasSolution() ? "true" : "false");

        Query assertFact = new Query("artysta(X)");

        System.out.println(Arrays.toString(assertFact.allSolutions()));

        assertFact.close();
    }
}
