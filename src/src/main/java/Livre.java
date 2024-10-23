import com.fasterxml.jackson.annotation.JsonProperty;

public class Livre {
    public String isbn;
    public String title;
    public String description;
    public String author;
    public double price;
    public int quantity;

    // Constructors
    public Livre(){}
    public Livre(String isbn, String title, String description, String author, double price, int quantity){
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getIsbn(){
        return isbn;
    }
    @JsonProperty("title")
    public String getTitre(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    @JsonProperty("author")
    public String getAuteur(){
        return author;
    }
    @JsonProperty("price")
    public double getPrix(){
        return price;
    }
    @JsonProperty
    public int getQuantity(){ return quantity; }

    // Setters
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public void setTitre(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setAuteur(String author){
        this.author = author;
    }
    public <T extends Number> void setPrix(T price){
        this.price = (double) price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Livre : " +
                "isbn=" + isbn +
                ", title=" + title +
                ", description=" + description +
                ", author=" + author +
                ", price=" + price +
                ", quantity=" + quantity;
    }
}
