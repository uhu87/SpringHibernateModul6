package pl.coderslab.springhibernatemodul6.dao;

import org.springframework.stereotype.Controller;
import pl.coderslab.springhibernatemodul6.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Controller
@Transactional
public class PersonDao {


    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Person person) {
        entityManager.persist(person);
    }

    public Person merge(Person person) {
        return entityManager.merge(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void remove(Person person) {
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }

}
