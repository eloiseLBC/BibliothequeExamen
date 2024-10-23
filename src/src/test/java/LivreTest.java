import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LivreTest {
    @Test
    public void testEmptyConstructor(){
        Livre livre = new Livre();
        Assertions.assertNull(livre.isbn);
    }

    @Test
    public void testFullyConstructor(){
        Livre livre = new Livre("123", "Titre", "Description longue", "Eloïse LE BLANC", 56.99, 1);
        Assertions.assertEquals(livre.toString(), "Livre : " +
                "isbn=" + livre.isbn +
                ", title=" + livre.title +
                ", description=" + livre.description +
                ", author=" + livre.author +
                ", price=" + livre.price +
                ", quantity=" + livre.quantity);
    }

    @Test
    public void testSetISBN(){
        Livre livre = new Livre();
        livre.setIsbn("123");
        Assertions.assertEquals(livre.isbn, "123");
    }

    @Test
    public void testSetTitle(){
        Livre livre = new Livre();
        livre.setTitre("Titre");
        Assertions.assertEquals(livre.title, "Titre");
    }

    @Test
    public void testSetDescription(){
        Livre livre = new Livre();
        livre.setDescription("Une description bien longue");
        Assertions.assertEquals(livre.description, "Une description bien longue");
    }

    @Test
    public void testSetAuthor(){
        Livre livre = new Livre();
        livre.setAuteur("Eloïse");
        Assertions.assertEquals(livre.author, "Eloïse");
    }

    @Test
    public void testSetPrice(){
        Livre livre = new Livre();
        livre.setPrix(1000.0);
        Assertions.assertEquals(livre.price, 1000.0);
    }


}
