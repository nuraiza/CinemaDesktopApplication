package s19241.mas.project.cinemaapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "cinema")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cinema {

    public Cinema(@NotBlank(message = "Name can not be empty!") @Size(min = 3, max = 500) String name, @NotBlank(message = "Address can not be empty!") @Size(min = 3, max = 500) String address) {
        this.name = name;
        this.address = address;
    }

    @Id
    @SequenceGenerator(
            name = "cinema_sequence",
            sequenceName = "cinema_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "cinema_sequence"
    )
    private Long id;

    @NotBlank(message = "Name can not be empty!")
    @Size(min = 3, max = 500)
    private String name;

    @NotBlank(message = "Address can not be empty!")
    @Size(min = 3, max = 500)
    private String address;

    @OneToMany(orphanRemoval = true, mappedBy = "cinema", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NonNull Hall> halls = new HashSet<>();

    public void addHall(Hall h) {
        if (h.getCinema() != this) {
            throw new ValidationException("You are trying to add hall, which does not belong to this cinema!");
        }
        this.halls.add(h);

    }

    public void removeHall(Hall h) {
        if (this.halls.contains(h)) {
            this.halls.remove(h);
            h.delete();
        }

    }

    public void delete() {
        for (Hall h : this.halls) {
            removeHall(h);
        }
    }
}
