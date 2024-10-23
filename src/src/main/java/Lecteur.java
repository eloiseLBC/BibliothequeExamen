import java.util.ArrayList;
import java.util.List;

public class Lecteur {
    public int id;
    public String name;
    public List<String> livres = new ArrayList<>();

    // Constructeurs
    public Lecteur(){}
    public Lecteur(int id, String name){
        this.id = id;
        this.name = name;
        this.livres = new ArrayList<>();
    }

    // Getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    // Setters
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return ("Lecteur : " + id + ", name : " + name);
    }

    public void rentBook(String isbn){
        livres.add(isbn);
    }
}
