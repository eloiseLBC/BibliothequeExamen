import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Bibliotheque {
    private static Bibliotheque instance;
    static final Set<Lecteur> lecteurs = new HashSet<>();
    static final List<Livre> livres = new ArrayList<>();
    static final List<Livre> livresDisponibles = new ArrayList<>();
    public Lecteur lecteurCourant;

    // Constructeur
    Bibliotheque(){}

    // Singleton
    public static Bibliotheque getInstance(){
        if (instance == null){
            instance = new Bibliotheque();
        }
        return instance;
    }

    public void setCurrent(int id){
        for(Lecteur lecteur : lecteurs){
            if (lecteur.getId() == id){
                lecteurCourant = lecteur;
                System.out.println("Utilisateur : " + lecteurCourant.getName() + " connecté");
                return;
            }
        }
        System.out.println("Aucun lecteur avec cet ID n'a été trouvé");
    }

    public Lecteur getCurrentLecteur(){
        return lecteurCourant;
    }

    public void addLecteur(Lecteur lecteur){
        lecteurs.add(lecteur);
    }

    public void afficherLecteurs(){
        for(Lecteur lecteur: lecteurs){
            System.out.println(lecteur.toString());
        }
    }

    public void afficherLivres(){
        System.out.println("Liste de tous les livres :");
        for(Livre livre: livres){
            System.out.println(livre.toString());
        }
    }

    public void afficherLivresDisponibles(){
        System.out.println("Liste des livres disponibles :");
        for(Livre livre: livresDisponibles){
            System.out.println(livre.toString());
        }
    }

    public void addLivre(Livre livre){
        livres.add(livre);
    }

    public void addLivreDisponible(Livre livre){
        livresDisponibles.add(livre);
    }

    public void rentBook(String isbn){
        if (lecteurCourant == null){
            System.out.println("Aucun utilisateur connecté, impossible de louer un livre");
            return;
        }
        if (lecteurCourant.livres.size() >= 3){
            System.out.println("Impossible de louer plus de 3 livres en même temps");
            return;
        }
        if (!lecteurCourant.livres.isEmpty()){
            for(String isbnn : lecteurCourant.livres){
                if (Objects.equals(isbnn, isbn)){
                    System.out.println("Ne peut pas louer plus d'un seul exemplaire du même livre");
                    return;
                }
            }

        }
        for (Livre livre: livresDisponibles){
            if (Objects.equals(livre.getIsbn(), isbn)) {
                lecteurCourant.rentBook(isbn);
                livre.quantity -= 1;
                if (Objects.equals(livre.quantity, 0)) {
                    livresDisponibles.remove(livre);
                }
                System.out.println("Livre loué avec succès");
                return;
            }
        }
        System.out.println("Le livre n'est pas disponible");
    }

    public void seeDetails(String isbn){
        for(Livre livre: livres){
            if (Objects.equals(livre.isbn, isbn)){
                System.out.println("Détail du " + livre);
                return;
            }
        }
        System.out.println("Livre non trouvé");
    }

    public void returnBook(String isbn){
        if (lecteurCourant.livres.isEmpty()){
            System.out.println("Vous n'avez aucun livre à rendre.");
        }
        for(String isbnBook: lecteurCourant.livres){
            if (Objects.equals(isbnBook, isbn)){
                lecteurCourant.livres.remove(isbn);
                for (Livre livre: livres){
                    if (Objects.equals(isbnBook, livre.isbn)){
                        livre.quantity += 1;
                        if (Objects.equals(livre.quantity, 0)) {
                            livresDisponibles.add(livre);
                        }
                        System.out.println("Livre rendu ! Merci.");
                        return;
                    }
                }
            }
        }
        System.out.println("Le livre n'a pas été trouvé, vérifiez l'ISBN.");
    }

    public void exportToJson(String fileName, String filePath){
        try{
            // Création de l'object mapper
            ObjectMapper objectMapper = new ObjectMapper();
            // Ecrire la liste dans un fichier
            objectMapper.writeValue(new File(filePath + "/" + fileName + ".json"), livresDisponibles);
            System.out.println("Fichier JSON créé avec succès");
        } catch (IOException e){
            System.err.println("Erreur lors de l'export : " + e.getMessage());
        }
    }
}
