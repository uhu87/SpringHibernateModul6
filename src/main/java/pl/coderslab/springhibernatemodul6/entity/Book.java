package pl.coderslab.springhibernatemodul6.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5)
    @NotEmpty(message = "ksiazka musi miec tytul tej")
    private String title;

    @Range(min = 1, max =10, message = "zla walidacja range, wartosc miedzy 1 a 10")
    private int rating;

    @Size(max=600)
    private String description;

    @ManyToMany
    @NotEmpty
    private List<Author>authors=new ArrayList<>();

    @ManyToOne
    @NotNull
    private Publisher publisher;

    @Min(1)
    private int pages;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", authors=" + authors +
                ", publisher=" + publisher +
                ", pages=" + pages +
                '}';
    }
}






/*
    id
    title (String)
    rating (int)
    description (String)
*/
