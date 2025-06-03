package model.personne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipe extends Participant {

    private List<Joueur> membres;

    public Equipe(String name, LocalDate dateOfBirth, String mdp, String identifiant, List<Joueur> membres) {
        super(name, dateOfBirth, mdp, identifiant);
        // Sécurise la liste contre les nulls
        this.membres = (membres != null) ? membres : new ArrayList<>();
    }

    public List<Joueur> getMembres() {
        return membres;
    }

    public void setMembres(List<Joueur> membres) {
        this.membres = (membres != null) ? membres : new ArrayList<>();
    }

    public void addMember(Joueur joueur) {
        if (joueur != null) {
            this.membres.add(joueur);
        }
    }

    public void removeMember(Joueur joueur) {
        this.membres.remove(joueur);
    }

    public int getNbJoueurs() {
        return membres.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nMembres : ");
        for (Joueur joueur : membres) {
            sb.append("\n - ").append(joueur.getName()).append(" (").append(joueur.getSurname()).append(")");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;
        Equipe equipe = (Equipe) o;
        return Objects.equals(membres, equipe.membres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), membres);
    }
}
