package s19241.mas.project.cinemaapp.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends Person implements Member, NonMember {

    public User(@NotBlank(message = "Name can not be empty!") @Size(min = 3, max = 255) String name, @NotBlank(message = "Telephone number can not be empty!") @Size(min = 6, max = 20) String telephoneNumber, @NotBlank(message = "Email can not be empty!") @Email String email, @NotBlank(message = "Login can not be empty!") @Size(min = 5, max = 255) String login, @NotBlank(message = "Password can not be empty!") @Size(min = 8, max = 255) String password, @NotNull Status status, @NotNull UserType userType, Integer memberPoints) {
        super(name, telephoneNumber, email);
        this.login = login;
        this.password = password;
        this.status = status;
        setUserType(userType);

        if (isMember()) {
            setMemberPoints(memberPoints);
        }

    }

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    @NotBlank(message = "Login can not be empty!")
    @Size(min = 5, max = 255)
    private String login;

    @NotBlank(message = "Password can not be empty!")
    @Size(min = 8, max = 255)
    private String password;

    @Embedded
    @NotNull
    private Status status;

    @Enumerated(EnumType.STRING)
    @NotNull
    private UserType userType;

    private Integer memberPoints;

    @ManyToOne(optional = true)
    @JoinColumn(name = "customer_support_id", nullable = true, updatable = true)
    private CustomerSupport contacts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NotNull Ticket> tickets = new HashSet<>();

    private Boolean isDeleted = false;

    @Override
    public Integer getMemberPoints() {

        return this.memberPoints;
    }

    @Override
    public void setMemberPoints(int points) {
        if (!isMember()) {
            throw new ValidationException("Can not assign member points as this user is not member!");
        }
        this.memberPoints = points;

    }

    public Boolean isMember() {
        return this.userType == UserType.MEMBER;
    }

    private void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void becomeMember(int points) {
        if (isMember()) {
            throw new ValidationException("This user is already a member!");
        }
        setUserType(UserType.MEMBER);
        setMemberPoints(points);

    }

    public void becomeNonMember() {
        if (!isMember()) {
            throw new ValidationException("This user is already a nonmember!");
        }
        setUserType(UserType.NONMEMBER);
        this.memberPoints = null;
    }

    public void setContacts(CustomerSupport c) {

        if (this.contacts == c) {
            return;
        }
        if (this.contacts != null && c == null) {
            reassignContacts();
        } else if (this.contacts == null && c != null) {
            assignContacts(c);
        } else if (this.contacts != null && c != null) {
            reassignContacts();
            assignContacts(c);
        }

    }

    public void assignContacts(CustomerSupport c) {
        this.contacts = c;
        c.addUser(this);
    }

    public void reassignContacts() {
        CustomerSupport cs = this.contacts;
        this.contacts = null;
        cs.removeUser(this);
    }

    public void addTicket(Ticket t) {
        if (t.getUser() != this) {
            throw new ValidationException("You are trying to add ticket, which does not belong to this user!");
        }
        this.tickets.add(t);
    }

    public void removeTicket(Ticket t) {
        if (this.tickets.contains(t)) {
            this.tickets.remove(t);
            t.delete();
        }

    }

    public void delete() {
        if (isDeleted) {
            return;
        }
        this.isDeleted = true;
        reassignContacts();
        for (Ticket t : this.tickets) {
            removeTicket(t);
        }
    }


}
