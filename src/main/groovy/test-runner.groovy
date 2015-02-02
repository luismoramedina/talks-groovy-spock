filmService = new FilmServiceImpl()

//THE FILM
theFilm = filmService.getFilm(1)
assert theFilm.name.equalsIgnoreCase("Blade runner")

//Director -> Fincher
filmsByFincher = filmService.getFilmsByDirector("David Fincher")
assert filmsByFincher.size() == 1
assert filmsByFincher.get(0).name == "Fight club"

//Actor -> Bale (AKA The Batman before Ben Affleck)
baleFilms = filmService.getFilmsByStar("Christian Bale")
assert baleFilms.size() == 2

//Top films
nineStarsFilms = filmService.getFilmsByRanking(9)
assert nineStarsFilms.size() == 3
nineOrMoreStarsFilms = filmService.getFilmsByRanking(9, true)
assert nineOrMoreStarsFilms.size() == 4
nineOrLessStarsFilms = filmService.getFilmsByRanking(8, false, true)
assert nineOrLessStarsFilms.size() == 1

//All films in database
allFilms = filmService.getFilms()
assert allFilms.size() == 5