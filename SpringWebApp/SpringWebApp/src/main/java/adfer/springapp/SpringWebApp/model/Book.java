package adfer.springapp.SpringWebApp.model;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Book {
    @Id
    @GeneratedValue(generator = "book_id")
    @SequenceGenerator(name="book_id",sequenceName="book_id_sequence", allocationSize=1)
    private Long id;
    private String title;
    private String isbn;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher;
    public Book() {
    }
    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    //GETTERS AND SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    //TO_STRING
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }

    //EQUALS AND HASH
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}