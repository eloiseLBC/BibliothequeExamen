
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("livres.json");
            Bibliotheque bibliotheque = Bibliotheque.getInstance();
            // Lire le JSON en tant que Map
            List<Livre> livres = objectMapper.readValue(inputStream, new TypeReference<>() {});
            // Ajouter tous les livres à la Bibliothèqe
            for (Livre livre : livres){
                bibliotheque.addLivre(livre);
                bibliotheque.addLivreDisponible(livre);
            }
            Lecteur lecteur1 = new Lecteur(1, "Eloïse");
            Lecteur lecteur2 = new Lecteur(2, "Lou");
            Lecteur lecteur3 = new Lecteur(3, "Saaziley");
            bibliotheque.addLecteur(lecteur1);
            bibliotheque.addLecteur(lecteur2);
            bibliotheque.addLecteur(lecteur3);
            System.out.println("Bonjour, bienvenue dans la bibliothèque ! ");
            String choice = "1";
            do{
                System.out.println("1 - Se connecter");
                System.out.println("2 - Voir tous les livres");
                System.out.println("3 - Voir les livres disponibles");
                System.out.println("4 - Voir les détails d'un livre (ISBN)");
                System.out.println("5 - Voir les détails d'un livre (Recherche intelligente)");
                System.out.println("6 - Louer un livre");
                System.out.println("7 - Rendre un livre");
                System.out.println("8 - Exporter le catalogue des livres disponibles");
                System.out.println("9 - Voir profil");
                System.out.println("10 - Créer  un compte et se connecter");
                System.out.println("0 - Déconnexion");
                Scanner sc = new Scanner(System.in);
                System.out.println("Que désirez-vous faire ? ");
                choice = sc.nextLine();
                switch (choice){
                    case "0":
                        break;
                    case "1":
                        Scanner scid = new Scanner(System.in);
                        if (bibliotheque.lecteurCourant != null){
                            System.out.println("Attention : En choisissant un autre profil, vous serez déconnecté de celui-ci.");
                        }
                        System.out.println("Quel est votre identifiant ? ");
                        int id = scid.nextInt();
                        bibliotheque.setCurrent(id);
                        break;
                    case "2":
                        bibliotheque.afficherLivres();
                        break;
                    case "3":
                        bibliotheque.afficherLivresDisponibles();
                        break;
                    case "4":
                        Scanner scISBN = new Scanner(System.in);
                        System.out.println("Quel est l'identifiant du livre ? ");
                        String isbn = scISBN.nextLine();
                        bibliotheque.seeDetails(isbn);
                        break;
                    case "5":
                        Scanner scSmartResearch = new Scanner(System.in);
                        System.out.println("Faîtes votre recherche : ");
                        String smartResearch = scSmartResearch.nextLine();
                        bibliotheque.smartBookResearch(smartResearch);
                        break;
                    case "6":
                        Scanner scISBNRent = new Scanner(System.in);
                        System.out.println("Quel livre voulez-vous louer (ISBN) ?");
                        String isbnRent = scISBNRent.nextLine();
                        bibliotheque.rentBook(isbnRent);
                        break;
                    case "7":
                        Scanner scReturnBook = new Scanner(System.in);
                        System.out.println("Quel livre souhaitez-vous retourner (ISBN) ?");
                        String isbnReturn = scReturnBook.nextLine();
                        bibliotheque.returnBook(isbnReturn);
                        break;
                    case "8":
                        Scanner scFileName = new Scanner(System.in);
                        Scanner scFilePath = new Scanner(System.in);
                        System.out.println("Sous quel nom de fichier souhaitez-vous exporter les données ? ");
                        String fileName = scFileName.nextLine();
                        System.out.println("Où souhaitez-vous exporter les données (path) ? ");
                        String filePath = scFilePath.nextLine();
                        bibliotheque.exportToJson(fileName, filePath);
                    case "9":
                        if (bibliotheque.lecteurCourant == null){
                            System.out.println("Aucun utilisateur connecté");
                        } else {
                            System.out.println("Utilisateur connecté : " + bibliotheque.lecteurCourant.getName() + ", id : "
                                    + bibliotheque.lecteurCourant.getId() + ", liste des livres loués : " + bibliotheque.lecteurCourant.livres);
                        }
                        break;
                    case "10":
                        System.out.println("Création de compte lecteur");
                        Scanner scRegister = new Scanner(System.in);
                        System.out.println("Quel est votre prénom ? ");
                        String name = scRegister.nextLine();
                        Lecteur lecteur4 = new Lecteur(4, name);
                        bibliotheque.addLecteur(lecteur4);
                        bibliotheque.setCurrent(lecteur4.getId());
                        break;
                    default:
                        System.out.println("L'option n'est pas reconnue.");
                }
            } while(!choice.equals("0"));
            System.out.println("Au revoir !");
        } catch (IOException e){
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
