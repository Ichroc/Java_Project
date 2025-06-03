package model.personne;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Personne {
    protected String name;
    protected LocalDate dateOfBirth;
    protected String mdp;
    protected String identifiant;

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Personne(String name, LocalDate dateOfBirth, String mdp, String identifiant) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.mdp = mdp;
        this.identifiant = identifiant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Personne personne = (Personne) o;
        return Objects.equals(name, personne.name) && Objects.equals(dateOfBirth, personne.dateOfBirth) && Objects.equals(mdp, personne.mdp) && Objects.equals(identifiant, personne.identifiant);
        // Si on n'a pas besoin de l'identifiant, on peut éviter de le comparer ici.
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, mdp, identifiant);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append("\nName: ");
        sb.append(name);
        sb.append("\nDate de naissance: ");
        sb.append(dateOfBirth);
        return sb.toString();
    }
}
