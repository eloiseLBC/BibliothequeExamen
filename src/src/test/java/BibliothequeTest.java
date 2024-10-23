import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BibliothequeTest {
    private Bibliotheque bibliotheque;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;  // Restaurer la sortie standard
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void instanceBibliotheque(){
        bibliotheque = new Bibliotheque();
        // Rediriger la sortie standard vers un flux capturable
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setErr(originalErr);
    }

    @Test
    public void getCurrentReaderTest(){
        Lecteur lecteur = new Lecteur(1, "Eloïse");
        bibliotheque.addLecteur(lecteur);
        bibliotheque.setCurrent(1);
        assertEquals(bibliotheque.getCurrentLecteur(), lecteur);
        Bibliotheque.lecteurs.remove(lecteur);
    }

    @Test
    public void getCurrentReaderTestNone(){
        Lecteur lecteur = new Lecteur(1, "Eloïse");
        bibliotheque.addLecteur(lecteur);
        bibliotheque.setCurrent(0);
        assertNull(bibliotheque.getCurrentLecteur());
        Bibliotheque.lecteurs.remove(lecteur);
    }

    @Test
    public void testAddlivreDisponible(){
        Livre livre1 = new Livre("111", "Title", "Descripzzzion", "Elo", 5.0, 1);
        bibliotheque.addLivreDisponible(livre1);
        assertEquals(Bibliotheque.livresDisponibles.size(), 1);
    }

    @Test
    public void testAddlivre(){
        Livre livre1 = new Livre("111", "Title", "Descripzzzion", "Elo", 5.0, 1);
        bibliotheque.addLivre(livre1);
        assertEquals(Bibliotheque.livres.size(), 1);
    }

    @Test
    public void testExport(){
        Livre livre1 = new Livre("123", "Titre", "Description", "Eloïse", 50.0, 2);
        Livre livre2 = new Livre("111", "Title", "Descripzzzion", "Elo", 5.0, 1);
        bibliotheque.addLivreDisponible(livre1);
        bibliotheque.addLivreDisponible(livre2);
        bibliotheque.exportToJson("livres_dispooos.json", "C:/Users/elois/Desktop");
        String expectedOutput = "Fichier JSON créé avec succès";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }
}
