package sn.diaryatou.gestion_des_impots.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "paiements")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date datePaiement;
    private double montantPaiement;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_declaration")
    private Declaration declaration;
    // Paiement(id long, datePaiement Date, montantPaiement double, idDeclaration long)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paiement paiement = (Paiement) o;
        return Objects.equals(id, paiement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}