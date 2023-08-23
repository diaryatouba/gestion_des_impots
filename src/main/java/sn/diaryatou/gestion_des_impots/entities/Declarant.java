package sn.diaryatou.gestion_des_impots.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "declarants")
public class Declarant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String raisonSocial;
    @Column(unique = true)
    private String adresse;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true,nullable = false)
    private String telephone;
    public void updateValues(Declarant declarant) {
        if (declarant == null) {
            throw new IllegalArgumentException("Declarant cannot be null");
        }

        if (declarant.raisonSocial != null) {
            this.raisonSocial = declarant.raisonSocial;
        }

        if (declarant.adresse != null) {
            this.adresse = declarant.adresse;
        }

        if (declarant.email != null) {
            this.email = declarant.email;
        }

        if (declarant.telephone != null) {
            this.telephone = declarant.telephone;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declarant declarant = (Declarant) o;
        return Objects.equals(id, declarant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}