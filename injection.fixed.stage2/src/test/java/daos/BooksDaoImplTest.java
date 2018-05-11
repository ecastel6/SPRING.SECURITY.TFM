package daos;

import entities.BooksEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BooksDaoImplTest
{
    FileSystemXmlApplicationContext context;

    @Before
    public void setUp() {
        context =
                new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/database-security.xml");
    }

    @Test
    public void list() {
        BooksDao booksDao = context.getBean(BooksDao.class);

        //Person person = new Person();
        //person.setName("Emilio"); person.setCountry("Spain");
        //personDAO.save(person);

        //System.out.println("Person::"+person);

        List<BooksEntity> list = booksDao.list();

        for (BooksEntity book : list) {
            System.out.println("Book::" + book);
        }
        assertTrue(list.size() > 0);

    }
}