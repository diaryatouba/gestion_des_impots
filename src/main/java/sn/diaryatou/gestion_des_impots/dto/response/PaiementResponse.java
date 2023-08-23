package sn.diaryatou.gestion_des_impots.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * DTO for {@link sn.youdev.model.Paiement}
 */
@Data
public class PaiementResponse{
    private Long id;
    private Date datePaiement;
    private double montantPaiement;

    private Long declarationId;
    private String raisonSocialDeclarant;
}