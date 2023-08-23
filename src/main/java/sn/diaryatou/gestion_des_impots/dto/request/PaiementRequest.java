package sn.diaryatou.gestion_des_impots.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * DTO for {@link sn.youdev.model.Paiement}
 */
@Data
public class PaiementRequest implements Serializable {
    @NotNull
    private Date datePaiement;
    @Min(1000)
    @PositiveOrZero
    private double montantPaiement;

    private Long declarationId;
}