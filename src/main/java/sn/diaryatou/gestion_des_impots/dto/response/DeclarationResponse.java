package sn.diaryatou.gestion_des_impots.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * DTO for {@link sn.youdev.model.Declaration}
 */
@Data
public class DeclarationResponse{
        private Long id;
        private Date dateDeclaration;
        private Double montantDeclaration;
        private Long declarantId;
        private String raisonSocial;
        private Double paiementEffectue;
}