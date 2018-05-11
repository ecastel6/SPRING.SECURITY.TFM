package servlets;

import daos.BooksDao;
import entities.BooksEntity;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "search", urlPatterns = {"/search"})
public class Search extends HttpServlet
{
    /**
     *
     */
    private static final long serialVersionUID = 1465380827389997391L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        ClassPathXmlApplicationContext context =
                null;
        try {
            context = new ClassPathXmlApplicationContext("database-security.xml");

            String author = request.getParameter("authorname");

            BooksDao booksDao = context.getBean(BooksDao.class);
            List<BooksEntity> listBooks = booksDao.searchByAuthor(author);
            if (listBooks.size() > 0)
                for (BooksEntity book : listBooks) {
                    response.getWriter().write(String.format("Author: %s<br>Title: %s<br><br>",
                            book.getAuthor(), book.getTitle()));
                }
            else response.getWriter().write("No results found");
        } catch (BeansException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        context.close();
    }
}
