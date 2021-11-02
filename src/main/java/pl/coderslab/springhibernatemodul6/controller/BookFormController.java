package pl.coderslab.springhibernatemodul6.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springhibernatemodul6.dao.AuthorDao;
import pl.coderslab.springhibernatemodul6.dao.BookDao;
import pl.coderslab.springhibernatemodul6.dao.PublisherDao;
import pl.coderslab.springhibernatemodul6.entity.Author;
import pl.coderslab.springhibernatemodul6.entity.Book;
import pl.coderslab.springhibernatemodul6.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping("/book/form")
public class BookFormController {

    private PublisherDao publisherDao;
    private AuthorDao authorDao;
    private BookDao bookDao;


    public BookFormController(PublisherDao publisherDao, BookDao bookDao, AuthorDao authorDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao=authorDao;
    }

    @GetMapping("/show")
    public String showBookForm(Model model){
        model.addAttribute("book", new Book());
        return "/book/bookForm";
    }


    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book){
         bookDao.saveBook(book);
         return "redirect:/book/form/all";
    }

    @GetMapping("/all")
    public String showAllBooks(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "/book/bookListing";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("id", id);
        return "/book/editBook";
    }

    @PostMapping("/saveChange")
    public String saveBookChanges(@ModelAttribute("book") Book book, @ModelAttribute("id") Long id){

        Book bookToUpdate = bookDao.findById(id);
        bookToUpdate=book;
        bookDao.update(bookToUpdate);

        return "redirect:/book/form/all";
    }


    @GetMapping("/deleteConfirmation/{id}")
    public String deleteBook(@PathVariable Long id, Model model){
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "/book/deleteConfirmation";
    }



    @PostMapping("/deleteConfirmation")
    public String deleteBook(@RequestParam String confirmed, @RequestParam Long id){

        if(confirmed.equals("delete")){
            bookDao.delete(bookDao.findById(id));
            return "redirect:/book/form/all";
        }
        return "redirect:/book/form/all";
    }



    @ModelAttribute("publishers")
    public List<Publisher>publishers(){
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author>authors(){
        return authorDao.findAll();
    }

    @GetMapping("/testWidoku")
    public String testWidoku(Model model){

        model.addAttribute("books", bookDao.findAll());

        return "/book/index2";
    }




}
