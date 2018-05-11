package daos;

import entities.BooksEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

//@Repository
public class BooksDaoImpl implements BooksDao
{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BooksEntity> list() {
        Session session = this.sessionFactory.openSession();

        List<BooksEntity> booksList = session.createQuery("from BooksEntity ").list();
        session.close();
        return booksList;
    }

    @Override
    public List<BooksEntity> searchByAuthor(String authorName) {
        Session session = this.sessionFactory.openSession();
        //List<BooksEntity> booksSearch = session.createQuery("from BooksEntity where author='"+authorName+"'").list();
        List<BooksEntity> booksSearch = session.createQuery("from BooksEntity where author=:authorName")
                .setParameter("authorName", authorName)
                .list();
        session.close();
        return booksSearch;
    }
}
