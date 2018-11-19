import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

public class Prolog {

    public static void main(String[] args) {
        Query q1 =
                new Query(
                        "consult",
                        new Term[] {new Atom("./src/main/resources/music.pl")}
                );
        System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
        q1.open();
        System.out.println(q1.getSolution());
    }
}
