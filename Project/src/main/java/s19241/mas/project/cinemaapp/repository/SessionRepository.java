package s19241.mas.project.cinemaapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import s19241.mas.project.cinemaapp.model.Session;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Long> {

    @Query("from session as e where e.film.id=:film_id")
    List<Session> findSessionsByFilmId(@Param("film_id") Long filmid);

}
