package s19241.mas.project.cinemaapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import s19241.mas.project.cinemaapp.model.Seat;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat, Long> {

    @Query("from seat as s where not exists (select t.id from ticket as t where s.id=t.seat.id and t.session.id=:session_id ) and s.hall.id=:hall_id")
    List<Seat> findAvailableSeatsBySessionId(@Param("session_id") Long session_id, @Param("hall_id") Long hall_id);

}
