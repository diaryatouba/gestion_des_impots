package sn.diaryatou.gestion_des_impots.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "declarations")
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDeclaration;
    private Double montantDeclaration;
    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Declarant declarant;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "declaration")
    private List<Paiement> paiements = new ArrayList<>();
    //Declaration(id long, dateDeclaration date, montantDeclaration  double, idDeclarant long)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declaration declaration = (Declaration) o;
        return Objects.equals(id, declaration.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}