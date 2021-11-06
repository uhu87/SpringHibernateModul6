package pl.coderslab.springhibernatemodul6.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springhibernatemodul6.dao.PublisherDao;
import pl.coderslab.springhibernatemodul6.entity.Publisher;

import javax.validation.Valid;

@Controller
@RequestMapping("/publisher/form")
public class PublisherFormController {

    private PublisherDao publisherDao;

    public PublisherFormController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("publishers", publisherDao.findAll());
        return "/publisher/publisherListing";
    }
    //________________________________________________________dodawanie

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("publisher", new Publisher());
        return "/publisher/publisherForm";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute("publisher") @Valid  Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "/publisher/publisherForm";
        }

        publisherDao.savePublisher(publisher);
        return "redirect:/publisher/form/all";
    }

    //________________________________________________________ update

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("publisher", publisherDao.findById(idToEdit));
        return "/publisher/publisherForm";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult result) {
        if(result.hasErrors()){
            return "/publisher/publisherForm";
        }

        publisherDao.update(publisher);
        return "redirect:/publisher/form/all";
    }
    //________________________________________________________ delete

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam Long toRemoveId, Model model) {
        model.addAttribute("publisher", publisherDao.findById(toRemoveId));
        return "/publisher/remove";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam Long toRemoveId) {
        if ("yes".equals(confirmed)) {
            publisherDao.delete(publisherDao.findById(toRemoveId));
        }
        return "redirect:/publisher/form/all";
    }


}
