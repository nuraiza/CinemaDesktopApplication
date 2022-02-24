package s19241.mas.project.cinemaapp.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "seat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Seat {

    public Seat(Hall hall, @Positive int seatNumber, @Positive double regularPrice) {
        this.seatNumber = seatNumber;
        this.regularPrice = regularPrice;
        setHall(hall);
    }

    @Id
    @SequenceGenerator(
            name = "seat_sequence",
            sequenceName = "seat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "seat_sequence"
    )
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hall_id", nullable = false, updatable = false)
    private Hall hall;

    @Positive
    private int seatNumber;

    @Positive
    private double regularPrice;

    @OneToMany(mappedBy = "seat", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NotNull Ticket> tickets = new HashSet<>();

    private Boolean isDeleted = false;

    private void setHall(Hall h) {
        this.hall = h;
        h.addSeat(this);
    }

    public void delete() {

        if (isDeleted) {
            return;
        }
        this.isDeleted = true;
        this.hall.removeSeat(this);
        for (Ticket t : this.tickets) {
            removeTicket(t);
        }
    }

    public void addTicket(Ticket t) {
        if (t.getSeat() != this) {
            throw new ValidationException("You are trying to add ticket, which does not belong to this seat!");
        }
        this.tickets.add(t);

    }

    public void removeTicket(Ticket t) {
        if (this.tickets.contains(t)) {
            this.tickets.remove(t);
            t.delete();
        }

    }

    public Boolean isAvailable(Session s) {
        for (Ticket t : this.tickets) {
            if (t.getSession().getId() == s.getId()) {
                return false;
            }
        }
        return true;
    }

}
