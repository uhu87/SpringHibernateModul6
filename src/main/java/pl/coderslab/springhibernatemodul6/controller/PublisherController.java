package pl.coderslab.springhibernatemodul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.springhibernatemodul6.dao.PublisherDao;
import pl.coderslab.springhibernatemodul6.entity.Book;
import pl.coderslab.springhibernatemodul6.entity.Publisher;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PublisherController {


    private final PublisherDao publisherDao;


    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String add() {
        Publisher publisher = new Publisher();
        publisher.setName("Sowa");
        publisherDao.savePublisher(publisher);
        return publisher.toString();
    }


    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name ) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }

    @RequestMapping("/publisher/all")
    @ResponseBody
    public String findAll(){
        List<Publisher> allPublishers = publisherDao.findAll();
        return allPublishers.stream()
                .map(publisher-> publisher.getId()+": "+ publisher.getName())
                .collect(Collectors.joining("<br />"));
    }

}
