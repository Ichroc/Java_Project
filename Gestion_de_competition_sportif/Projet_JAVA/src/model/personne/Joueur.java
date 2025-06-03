package model.personne;

import java.time.LocalDate;
import java.util.Objects;

public class Joueur extends Personne {

    private String nationnality;
    private float taille;
    private String surname;

    public Joueur(String name, LocalDate dateOfBirth, String mdp, String identifiant, String nationnality, float taille, String surname) {
        super(name, dateOfBirth, mdp, identifiant);
        this.nationnality = nationnality;
        this.taille = taille;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationnality() {
        return nationnality;
    }

    public void setNationnality(String nationnality) {
        this.nationnality = nationnality;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) return false;
        Joueur joueur = (Joueur) o;
        return Float.compare(taille, joueur.taille) == 0 && Objects.equals(nationnality, joueur.nationnality) && Objects.equals(surname, joueur.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nationnality, taille, surname);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nSurname : ");
        sb.append(surname.toUpperCase());
        sb.append("\nNationnality : ");
        sb.append(nationnality);
        sb.append("\nTaille : ");
        sb.append(taille);
        sb.append("\nNom complet : ").append(name).append(" ").append(surname.toUpperCase());
        return sb.toString();
    }
}
