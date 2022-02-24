package s19241.mas.project.cinemaapp.repository;

import org.springframework.data.repository.CrudRepository;
import s19241.mas.project.cinemaapp.model.Film;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {
public List<Film> findFilmsByName(String name);
public List<Film> findFilmsByCategoriesLike(String category);

}
