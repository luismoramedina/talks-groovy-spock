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
}