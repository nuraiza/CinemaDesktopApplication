package s19241.mas.project.cinemaapp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s19241.mas.project.cinemaapp.model.Seat;
import s19241.mas.project.cinemaapp.model.Session;
import s19241.mas.project.cinemaapp.model.Ticket;
import s19241.mas.project.cinemaapp.model.User;
import s19241.mas.project.cinemaapp.repository.TicketRepository;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;


    public Ticket CreateTicket(User user, Session session, Seat seat) {
        Ticket t = new Ticket(session, user, seat);
        ticketRepository.save(t);
        return t;
    }

}
