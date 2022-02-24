package s19241.mas.project.cinemaapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Person {

    @NotBlank(message = "Name can not be empty!")
    @Size(min = 3, max = 255)
    private String name;

    @NotBlank(message = "Telephone number can not be empty!")
    @Size(min = 6, max = 20)
    private String telephoneNumber;

    @NotBlank(message = "Email can not be empty!")
    @Email
    private String email;
}
