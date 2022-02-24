package s19241.mas.project.cinemaapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ElementCollection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "film")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Film {

    public Film(@NotBlank(message = "Name can not be empty!") @Size(min = 3, max = 255) String name, @NotNull LocalDate releaseDate, @NotBlank(message = "Description can not be empty!") @Size(min = 3, max = 500) String description, @NotNull @Size(min = 1) List<@NotBlank @Size(min = 3, max = 100) String> categories, @NotNull @Size(min = 1) List<@NotBlank @Size(min = 3, max = 100) String> actors, String director) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.description = description;
        this.categories = categories;
        this.actors = actors;
        this.director = director;
    }

    @Id
    @SequenceGenerator(
            name = "film_sequence",
            sequenceName = "film_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "film_sequence"
    )
    private Long id;

    @NotBlank(message = "Name can not be empty!")
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    private LocalDate releaseDate;

    @NotBlank(message = "Description can not be empty!")
    @Size(min = 3, max = 500)
    private String description;

    @ElementCollection
    @NotNull
    @Size(min = 1)
    private List<@NotBlank @Size(min = 3, max = 100) String> categories = new ArrayList<>();

    @ElementCollection
    @NotNull
    @Size(min = 1)
    private List<@NotBlank @Size(min = 3, max = 100) String> actors = new ArrayList<>();


    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NonNull Session> sessions = new HashSet<>();

    //optional
    private String director;

    public void addCategory(String cat) {
        this.categories.add(cat);
    }

    public void removeCategory(String cat) {
        this.categories.remove(cat);
    }

    public void addActor(String actor) {
        this.actors.add(actor);
    }

    public void removeActor(String actor) {
        this.actors.remove(actor);
    }


    public void addSession(Session s) {
        if (s.getFilm() != this) {
            throw new ValidationException("You are trying to add session, which does not belong to this film!");
        }
        this.sessions.add(s);
    }

    public void removeSession(Session s) {
        if (this.sessions.contains(s)) {
            this.sessions.remove(s);
            s.reassignFilm();
        }

    }


}
