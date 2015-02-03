import groovy.json.JsonSlurper

/**
 * @author luis mora
 */
class FilmServiceImpl {
    def films = [:]

    FilmServiceImpl() {

//      From url
//        def url = 'https://raw.githubusercontent.com/luismoramedina/talks-groovy-spock/master/src/main/resources/films.json'
//        print url.toURL().text

        def jsonText = this.class.getResourceAsStream("films.json").getText()

        JsonSlurper slurper = new JsonSlurper()
        def jsonData = slurper.parseText(jsonText)

        jsonData.each() {
            film ->
                films.put(film.id, new Film(film))
        }

        films.each { println it.value.toString() }
        println "All films loaded"
    }

    List<Film> getFilmsByDirector(Object director) {
        return films.findAll {
            it.getValue().director == director
        }.collect {
            it.value
        } as List<Film>
    }

    List<Film> getFilmsByStar(Object star) {
        return films.findAll {
            star in it.getValue().stars
        }.collect {
            it.value
        } as List<Film>
    }

    List<Film> getFilmsByRanking(Integer rating, boolean equalOrGreater = false, boolean equalOrLesser = false) {
        if (equalOrGreater && equalOrLesser) {
            throw new IllegalArgumentException()
        }
        def range = equalOrLesser ? 0..rating : rating
        range = equalOrGreater ? rating..10 : range
        return films.findAll {
            it.getValue().rating in range
        }.collect {
            it.value
        } as List<Film>
    }

    Film getFilm(Integer id) {
        return films.get(id)
    }

}
