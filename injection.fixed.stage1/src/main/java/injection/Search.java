package injection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "search", urlPatterns = {"/search"})
public class Search extends HttpServlet
{

    /**
     *
     */
    private static final long serialVersionUID = 1465380827389997391L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String author = request.getParameter("authorname");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleshop", "root",
                        "micro");

                Statement st = conn.createStatement();
                String sql = "SELECT author, title, price	 FROM books WHERE author='" + author + "'";
                System.out.println(sql);
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    String rsAuthor = rs.getString("author");
                    String rsTitle = rs.getString("title");
                    String rsPrice = rs.getString("price");
                    out.println(rsAuthor);
                    out.println(rsTitle);
                    out.println(rsPrice);
                    out.println("<br/>");
                }
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            out.close();
        }
    }
}