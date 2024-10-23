import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LecteurTest {
    private Lecteur lecteur;

    @Test
    void setEmptyReader(){
        lecteur = new Lecteur();
        Assertions.assertEquals(lecteur.getId(), 0);
    }

    @Test
    void setFullyReader(){
        lecteur = new Lecteur(6, "Damien");
        Assertions.assertEquals(lecteur.toString(), "Lecteur : " + lecteur.id + ", name : " + lecteur.name);
    }

    @Test
    void getNameReader(){
        lecteur = new Lecteur(6, "Damien");
        Assertions.assertEquals(lecteur.getName(), "Damien");
    }

    @Test
    void setNameIdReader(){
        lecteur = new Lecteur(6, "Damien");
        lecteur.setId(1);
        lecteur.setName("Chrystelle");
        Assertions.assertEquals(lecteur.getName(), "Chrystelle");
        Assertions.assertEquals(lecteur.getId(), 1);
    }
}
