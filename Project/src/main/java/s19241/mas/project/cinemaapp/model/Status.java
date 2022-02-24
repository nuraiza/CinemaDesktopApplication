package s19241.mas.project.cinemaapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Status {

    @NotBlank(message = "Status name can not be empty!")
    @Size(min = 5, max = 255)
    private String statusName;

    @Min(0)
    private int discount;

}
