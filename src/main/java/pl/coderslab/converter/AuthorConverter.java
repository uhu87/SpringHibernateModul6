package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.springhibernatemodul6.dao.AuthorDao;
import pl.coderslab.springhibernatemodul6.dao.PublisherDao;
import pl.coderslab.springhibernatemodul6.entity.Author;


@Component
public class AuthorConverter implements Converter<String, Author> {

    private AuthorDao authorDao;

    public AuthorConverter(AuthorDao authorDao){
        this.authorDao=authorDao;
    }

    @Override
    public Author convert(String source) {
        return authorDao.findById(Integer.parseInt(source));
    }
}
