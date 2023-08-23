package sn.diaryatou.gestion_des_impots.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


@Data
public class DeclarationRequest implements Serializable {
    @NotNull(message = "cette valeur ne peut etre nul")
    private Date dateDeclaration;
    @NotNull
    @Positive
    @Range(min = 1000)
    private Double montantDeclaration;
    @NotNull(message = "Veuillez Choisir un declarant")
    @Positive(message = "Veuillez Choisir un declarant")
    @Min(value = 1,message = "Veuillez Choisir un declarant")
    private Long idDeclarant;
}