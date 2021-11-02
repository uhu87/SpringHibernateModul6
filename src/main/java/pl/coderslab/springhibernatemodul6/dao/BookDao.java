package pl.coderslab.springhibernatemodul6.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.springhibernatemodul6.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book){
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book)); }


    public List<Book> findAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    public List<Book> findAllbyRating(int rating){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating=:givenRating");
        query.setParameter("givenRating", rating);
        return query.getResultList();

    }

    public List<Book> findAllWhereAnyPublisher(){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher IS not null");
        return query.getResultList();

    }


    // UZUPELNIJ O SZUKANIE PO AUTORZE (obiekcie)
    public List<Book> findAllWithThisPublisher(Long id){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher.id=:id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Book> findAllWithThisAuthor(String lastName){
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.authors a where a.lastName=:lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }


    public List<Book> findAllWithThisAuthorId(Long authorId){
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.authors a where a.id=:id");
        query.setParameter("id", authorId);
        return query.getResultList();
    }

}
