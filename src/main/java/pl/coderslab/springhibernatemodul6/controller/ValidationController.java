package pl.coderslab.springhibernatemodul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springhibernatemodul6.dao.AuthorDao;
import pl.coderslab.springhibernatemodul6.dao.PublisherDao;
import pl.coderslab.springhibernatemodul6.entity.Author;
import pl.coderslab.springhibernatemodul6.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {
    private final Validator validator;
    private final AuthorDao authorDao;
    private final PublisherDao publisherDao;

    public ValidationController(Validator validator, AuthorDao authorDao, PublisherDao publisherDao) {
        this.validator = validator;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/validate")
    //@ResponseBody
    public String validate(Model model){
        Book book = new Book();
        book.setTitle("asdsdsd");
        book.setRating(5);
        book.setPages(3);
        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.findById(1));
        book.setPublisher(publisherDao.findById(1));
        book.setAuthors(authors);
        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);

        if(!validationResult.isEmpty()){
            for(ConstraintViolation<Book> singleError : validationResult) {
                System.out.println("ERROR!!!" + singleError.getPropertyPath() + " : " + singleError.getMessage());
            }
            model.addAttribute("errors", validationResult);
            return "validation1";
        } else {
            model.addAttribute("success", "Nie ma bledow");
            return "validation1";
        }
    }


}
