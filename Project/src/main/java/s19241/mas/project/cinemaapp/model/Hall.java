package s19241.mas.project.cinemaapp.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "hall")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hall {

    public Hall(@NotBlank(message = "Name can not be empty!") @Size(min = 3, max = 500) String name, @Min(1) int numberOfSeats, Cinema cinema) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        setCinema(cinema);
    }

    @Id
    @SequenceGenerator(
            name = "hall_sequence",
            sequenceName = "hall_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "hall_sequence"
    )
    private Long id;

    @NotBlank(message = "Name can not be empty!")
    @Size(min = 3, max = 500)
    private String name;

    @Min(1)
    private int numberOfSeats;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cinema_id", nullable = false, updatable = false)
    private Cinema cinema;

    private Boolean isDeleted = false;


    @OneToMany(orphanRemoval = true, mappedBy = "hall", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NonNull Seat> seats = new HashSet<>();

    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NonNull Session> sessions = new HashSet<>();

    public void addSeat(Seat s) {
        if (s.getHall() != this) {
            throw new ValidationException("You are trying to add seat, which does not belong to this hall!");
        }
        this.seats.add(s);
    }

    public void removeSeat(Seat s) {
        if (this.seats.contains(s)) {
            this.seats.remove(s);
            s.delete();
        }

    }

    private void setCinema(Cinema cinema) {
        this.cinema = cinema;
        cinema.addHall(this);
    }

    public void delete() {
        if (this.isDeleted = true) {
            return;
        }
        this.isDeleted = true;
        this.cinema.removeHall(this);
        for (Seat s : this.seats) {
            removeSeat(s);
        }
        for (Session s : this.sessions) {
            removeSession(s);
        }
    }


    public void addSession(Session s) {
        if (s.getHall() != this) {
            throw new ValidationException("You are trying to add session, which does not belong to this hall!");
        }
        this.sessions.add(s);
    }

    public void removeSession(Session s) {
        if (this.sessions.contains(s)) {
            this.sessions.remove(s);
            s.reassignHall();
        }

    }


}
