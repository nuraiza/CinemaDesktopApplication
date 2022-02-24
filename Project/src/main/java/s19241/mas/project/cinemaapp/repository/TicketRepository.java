package s19241.mas.project.cinemaapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import s19241.mas.project.cinemaapp.model.Seat;
import s19241.mas.project.cinemaapp.model.Ticket;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket,Long> {

}
