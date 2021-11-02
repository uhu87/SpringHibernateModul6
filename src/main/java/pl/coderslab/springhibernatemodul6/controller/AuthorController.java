package pl.coderslab.springhibernatemodul6.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.springhibernatemodul6.dao.AuthorDao;
import pl.coderslab.springhibernatemodul6.entity.Author;
import pl.coderslab.springhibernatemodul6.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthorController {


    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @RequestMapping("/author/add")
    @ResponseBody
    public String add() {
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Mickiewicz");
        authorDao.saveAuthor(author);
        return author.toString();

    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName, @PathVariable String lastName) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "deleted";
    }

    @RequestMapping("/author/all")
    @ResponseBody
    public String findAll(){
        List<Author> alLAuthors = authorDao.findAll();
        return alLAuthors.stream()
                .map(author-> author.getId()+": "+ author.getFirstName() +" "+ author.getLastName())
                .collect(Collectors.joining("<br />"));
    }

}
