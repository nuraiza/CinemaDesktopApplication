package s19241.mas.project.cinemaapp.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "session")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Session {

    public Session(@NotNull @FutureOrPresent LocalDateTime startingDateTime, @NotNull LocalDateTime endingDateTime) {
        this.startingDateTime = startingDateTime;
        this.endingDateTime = endingDateTime;
    }

    @Id
    @SequenceGenerator(
            name = "session_sequence",
            sequenceName = "session_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "session_sequence"
    )
    private Long id;

    @NotNull
    @FutureOrPresent
    private LocalDateTime startingDateTime;

    @NotNull
    private LocalDateTime endingDateTime;

    @ManyToOne(optional = true)
    @JoinColumn(name = "film_id", nullable = true, updatable = true)
    private Film film;

    @ManyToOne(optional = true)
    @JoinColumn(name = "hall_id", nullable = true, updatable = true)
    private Hall hall;

    @OneToMany(mappedBy = "session", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NotNull Ticket> tickets = new HashSet<>();


    public void setFilm(Film f) {

        if (this.film == f) {
            return;
        }
        if (this.film != null && f == null) {
            reassignFilm();
        } else if (this.film == null && f != null) {
            assignFilm(f);
        } else if (this.film != null && f != null) {
            reassignFilm();
            assignFilm(f);
        }

    }

    public void setHall(Hall h) {

        if (this.hall == h) {
            return;
        }
        if (this.hall != null && h == null) {
            reassignHall();
        } else if (this.hall == null && h != null) {
            assignHall(h);
        } else if (this.hall != null && h != null) {
            reassignHall();
            assignHall(h);
        }

    }

    public void delete() {

        if (this.film == null) {
            return;
        }
        reassignFilm();
        reassignHall();
        for (Ticket t : this.tickets) {
            removeTicket(t);
        }
    }


    public void assignFilm(Film f) {
        this.film = f;
        f.addSession(this);
    }

    public void reassignFilm() {
        Film film = this.film;
        this.film = null;
        film.removeSession(this);
    }

    public void assignHall(Hall h) {
        this.hall = h;
        h.addSession(this);
    }

    public void reassignHall() {
        Hall hall = this.hall;
        this.hall = null;
        hall.removeSession(this);
    }


    public void addTicket(Ticket t) {
        if (t.getSession() != this) {
            throw new ValidationException("You are trying to add ticket, which does not belong to this session!");
        }
        this.tickets.add(t);
    }

    public void removeTicket(Ticket t) {
        if (this.tickets.contains(t)) {
            this.tickets.remove(t);
            t.delete();
        }

    }

}
