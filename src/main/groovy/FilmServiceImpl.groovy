/**
 * @author luis mora
 */
class FilmServiceImpl {
    def films = [:]

    FilmServiceImpl() {
        //TODO load data...
        println "All films loaded"
    }

    List<Film> getFilmsByDirector(String director) {
        //TODO return films by director
    }

    List<Film> getFilmsByStar(Object star) {
        //TODO return films by star
    }

    List<Film> getFilmsByRanking(Integer rating,
                                 boolean equalOrGreater = false,
                                 boolean equalOrLesser = false) {

        //TODO return films by rank

    }

    Film getFilm(Integer id) {
        //TODO return a film by id
    }

}