package pl.coderslab.springhibernatemodul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.springhibernatemodul6.dao.AuthorDao;
import pl.coderslab.springhibernatemodul6.dao.BookDao;
import pl.coderslab.springhibernatemodul6.dao.PublisherDao;
import pl.coderslab.springhibernatemodul6.entity.Author;
import pl.coderslab.springhibernatemodul6.entity.Book;
import pl.coderslab.springhibernatemodul6.entity.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao=publisherDao;
        this.authorDao=authorDao;
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String add() {
        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisherDao.savePublisher(publisher);
        Book book = new Book();
        book.setTitle("TEST na zlaczenia");
        book.setDescription("testowy opis");
        book.setRating(23);
        book.setPublisher(publisher);
        bookDao.saveBook(book);
        return book.toString();

    }


    @RequestMapping("/book/addWithExistingPublisher")
    @ResponseBody
    public String addWithExistingPublisher() {
        Publisher publisher = publisherDao.findById(2);
        publisherDao.savePublisher(publisher);
        Book book = new Book();
        book.setTitle("TEST na zlaczenia 22");
        book.setDescription("testowy opis");
        book.setPublisher(publisher);
        book.setRating(23);
        bookDao.saveBook(book);
        return book.toString();

    }

    @RequestMapping("/book/addWithExistingAuthors")
    @ResponseBody
    public String addWithExistingAuthors() {
        Publisher publisher = publisherDao.findById(2);
        publisherDao.savePublisher(publisher);
        Author author1= authorDao.findById(1);
        Author author2= authorDao.findById(2);
        Book book = new Book();
        book.setTitle("TEST na zlaczenia 22");
        book.setDescription("testowy opis");
        book.setPublisher(publisher);
        book.getAuthors().add(author1);
        book.getAuthors().add(author2);
        book.setRating(23);
        bookDao.saveBook(book);
        return book.toString();

    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }

    @RequestMapping("/book/all")
    @ResponseBody
    public String findAll(){
        List<Book>alLBooks = bookDao.findAll();
        return alLBooks.stream()
                .map(book-> book.getId()+": "+ book.getTitle())
                .collect(Collectors.joining("<br />"));
    }


    @RequestMapping("/book/rating/{rating}")
    @ResponseBody
    public String findAllbyRating(@PathVariable int rating) {
        List<Book> allBooksByRating = bookDao.findAllbyRating(rating);
        return allBooksByRating.stream()
                .map(book-> book.getId()+": "+ book.getTitle() + ": " + book.getRating())
                .collect(Collectors.joining("<br />"));

    }

    @RequestMapping("/book/allWithAnyPublisher")
    @ResponseBody
    public String findAllWithAnyPublisher(){
        List<Book>alLBooks = bookDao.findAllWhereAnyPublisher();
        return alLBooks.stream()
                .map(book-> book.getId()+": "+ book.getTitle())
                .collect(Collectors.joining("<br />"));
    }

    @RequestMapping("/book/findByPublisher/{id}")
    @ResponseBody
    public String findAllWithThisPublisher(@PathVariable Long id){
        List<Book>alLBooksByPublisher = bookDao.findAllWithThisPublisher(id);
        return alLBooksByPublisher.stream()
                .map(book-> book.getId()+": "+ book.getTitle()+": "+book.getPublisher())
                .collect(Collectors.joining("<br />"));
    }

    @RequestMapping("/book/findByAuthor/{lastName}")
    @ResponseBody
    public String findAllWithThisAuthor(@PathVariable String lastName){
        List<Book>findAllWithThisAuthor = bookDao.findAllWithThisAuthor(lastName);
        return findAllWithThisAuthor.stream()
                .map(book-> book.getId()+": "+ book.getTitle()+": "+book.getAuthors())
                .collect(Collectors.joining("<br />"));
    }


    @RequestMapping("/book/findByAuthorId/{id}")
    @ResponseBody
    public String findAllWithThisAuthorId(@PathVariable Long id){
        List<Book>findAllWithThisAuthorId = bookDao.findAllWithThisAuthorId(id);
        return findAllWithThisAuthorId.stream()
                .map(book-> book.getId()+": "+ book.getTitle()+": "+book.getAuthors())
                .collect(Collectors.joining("<br />"));
    }



}
