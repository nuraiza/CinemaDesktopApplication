package s19241.mas.project.cinemaapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket {

    public Ticket(@NotNull Session session, @NotNull User user, @NotNull Seat seat) {
        setSession(session);
        setUser(user);
        setSeat(seat);
        setPurchaseDate();
        setState(TicketState.ACTIVE);
    }

    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ticket_sequence"
    )
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TicketState state;

    @NotNull
    private LocalDate purchaseDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "session_id", nullable = false, updatable = false)
    @NotNull
    private Session session;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    @NotNull
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seat_id", nullable = false, updatable = false)
    @NotNull
    private Seat seat;

    private Boolean isDeleted = false;


    private void setSeat(Seat s) {
        this.seat = s;
        s.addTicket(this);

    }

    private void setSession(Session s) {
        this.session = s;
        s.addTicket(this);
    }

    private void setUser(User u) {
        this.user = u;
        u.addTicket(this);
    }


    public void delete() {
        if (isDeleted) {
            return;
        }
        this.isDeleted = true;
        this.seat.removeTicket(this);
        this.session.removeTicket(this);
        this.user.removeTicket(this);

    }

    private void setPurchaseDate() {
        LocalDateTime d = this.session.getEndingDateTime();
        LocalDate endingDate = LocalDate.of(d.getYear(), d.getMonth(), d.getDayOfMonth());
        if (LocalDate.now().isAfter(endingDate)) {
            throw new ValidationException("Purchase date can not be after than ending date of session!");
        }
        this.purchaseDate = LocalDate.now();
    }

    public double CalculateFinalPrice() {
        double seatPrice = this.seat.getRegularPrice();
        int discount = this.user.getStatus().getDiscount();
        double finalPrice = (seatPrice * discount) / 100;
        return finalPrice;
    }


}
