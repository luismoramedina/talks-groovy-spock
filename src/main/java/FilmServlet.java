import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by lmora on 05/02/2015.
 */
public class FilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FilmServiceImpl filmService = new FilmServiceImpl();
        Map<Integer, Film> films = (Map<Integer, Film>) filmService.getFilms();

        ServletOutputStream outputStream = resp.getOutputStream();

        outputStream.println("Listing films...\n");

        Collection<Film> values = films.values();
        for (Iterator iterator = values.iterator(); iterator.hasNext(); ) {
            Film film = (Film) iterator.next();
            outputStream.println(film.toString());
        }
        outputStream.close();

        super.doGet(req, resp);
    }
}
