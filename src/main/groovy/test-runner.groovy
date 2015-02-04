filmService = new FilmServiceImpl()
println "[DEBUG] Test carga fichero OK"

//THE FILM
theFilm = filmService.getFilm(1)
assert theFilm.name.equalsIgnoreCase("Blade runner")
println "[DEBUG] Test getFilm OK"

//Director -> Fincher
filmsByFincher = filmService.getFilmsByDirector("David Fincher")
assert filmsByFincher.size() == 1
assert filmsByFincher.get(0).name == "Fight club"
println "[DEBUG] Test getFilmsByDirector OK"

//Actor -> Bale (AKA The Batman before Ben Affleck)
baleFilms = filmService.getFilmsByStar("Christian Bale")
assert baleFilms.size() == 2
println "[DEBUG] Test getFilmsByStar OK"

//Top films
nineStarsFilms = filmService.getFilmsByRanking(9)
assert nineStarsFilms.size() == 3
println "[DEBUG] Test getFilmsByRanking equals OK"
nineOrMoreStarsFilms = filmService.getFilmsByRanking(9, true)
assert nineOrMoreStarsFilms.size() == 4
println "[DEBUG] Test getFilmsByRanking equalsOrMore OK"
nineOrLessStarsFilms = filmService.getFilmsByRanking(8, false, true)
assert nineOrLessStarsFilms.size() == 1
println "[DEBUG] Test getFilmsByRanking equalsOrLess OK"

//All films in database
allFilms = filmService.getFilms()
assert allFilms.size() == 5
println "[DEBUG] Test getFilms OK"

println "[DEBUG] All Tests OK!!!!!"