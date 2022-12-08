package com.test.test_back_hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "arbres")
public class Tree {
    @Id
    @Column(name = "idBase", nullable = false)
    private Long idBase;
    @Column(name = "typeEmplacement")
    private String typeEmplacement;
    @Column(name = "domanialite")
    private String domanialite;
    @Column(name = "arrondissement")
    private String arrondissement;
    @Column(name = "complementAdresse")
    private String complementAdresse;
    @Column(name = "numero")
    private Long numero;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "idEmplacement")
    private String idEmplacement;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "genre")
    private String genre;
    @Column(name = "espece")
    private String espece;
    @Column(name = "variete")
    private String variete;
    @Column(name = "circonference")
    private int circonference;
    @Column(name = "hauteur")
    private int hauteur;
    @Column(name = "developpement")
    private String developpement;
    @Column(name = "remarquable")
    private String remarquable;

    public Tree() {
    }

    @Override
    public String toString() {
        return "Tree{" +
                "idBase=" + idBase +
                ", typeEmplacement='" + typeEmplacement + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", idEmplacement='" + idEmplacement + '\'' +
                ", libelle='" + libelle + '\'' +
                ", genre='" + genre + '\'' +
                ", espece='" + espece + '\'' +
                ", variete='" + variete + '\'' +
                ", circonference=" + circonference +
                ", hauteur=" + hauteur +
                ", developpement='" + developpement + '\'' +
                ", remarquable='" + remarquable + '\'' +
                '}';
    }
}
