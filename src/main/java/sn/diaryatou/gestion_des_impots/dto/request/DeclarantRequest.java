package sn.diaryatou.gestion_des_impots.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * DTORequest for {@link sn.youdev.model.Declarant}
 */@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclarantRequest {

    @NotNull
    @NotBlank
    @Length(min = 3)
    private String raisonSocial;

    @NotNull
    @NotBlank
    @Length(min = 3)
    private String adresse;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String telephone;
}
