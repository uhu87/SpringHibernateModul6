package pl.coderslab.springhibernatemodul6.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springhibernatemodul6.dao.AuthorDao;
import pl.coderslab.springhibernatemodul6.entity.Author;

import javax.validation.Valid;

@Controller
@RequestMapping("/author/form")
public class AuthorFormController {

    private AuthorDao authorDao;

    public AuthorFormController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("authors", authorDao.findAll());
        return "/author/authorListing";
    }


    @GetMapping("/add")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return "/author/authorForm";
    }

    @PostMapping("/add")
    public String saveAuthor(@ModelAttribute("author") @Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "/author/authorForm";
        }

        authorDao.saveAuthor(author);
        return "redirect:/author/form/all";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam Long idToEdit, Model model) {
        model.addAttribute("author", authorDao.findById(idToEdit));
        return "/author/editAuthor";
    }

    @PostMapping("/edit")
    public String editAuthor (@ModelAttribute("author") Author author){
        authorDao.update(author);
        return "redirect:/author/form/all";
    }

    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam Long idToDelete, Model model) {
        model.addAttribute("author", authorDao.findById(idToDelete));
        return "/author/authorConfirmation";
    }

    @PostMapping("/confirmDeleting")
    public String confirmDeleting(@RequestParam Long id, @RequestParam String confirmed){
        if(confirmed.equals("delete")){
            authorDao.delete(authorDao.findById(id));
            return "redirect:/author/form/all";
        } return "redirect:/author/form/all";
    }


}
