import spock.lang.*

/**
 * @author luis mora
 */
class FilmSpecification extends Specification {

    @Issue("http://jira/112")
    def "David Fincher is the director of one film called Fight Club"() {

        given: "a film service"
            def filmService = new FilmServiceImpl()

        when: "we request fincher`s films"
            def filmsByDirector = filmService.getFilmsByDirector("David Fincher")

        then: "we get Fight club"
            filmsByDirector.size() == 1
            filmsByDirector.get(0).name == "Fight club"
    }

    @IgnoreIf( { env.linux })
    def "Blade runner is the #1 film"() {

        expect: "Blade Runner"
            new FilmServiceImpl().getFilm(1).name == "Blade runner"

    }

    @Unroll
    def "All films by Director #description"() {
        expect:
            getFilmNameByDirector(director) == films

        where:
            director             | description     || films
            'David Fincher'      | 'Fincher films' || ["Fight club"]
            'Ridley Scott'       | 'Scott films'   || ["Blade runner"]
            'Christopher Nolan'  | 'Nolan films'   || ["Mujeres al borde de un ataque de nervios"]
    }

    @Unroll
    def "All films by Director with PIPES!! #description"() {
        expect:
            getFilmNameByDirector(director) == films

        where:
            director <<['David Fincher', 'Ridley Scott' ]
            description << ['David films', 'Scott films' ]
            films << [ ["Fight club"], ["Blade runner"] ]
    }

    def String[] getFilmNameByDirector(director) {
        new FilmServiceImpl().getFilmsByDirector(director).collect( { it.name })
    }
}
