package model.personne;

import java.time.LocalDate;
import java.util.List;

public class Equipe extends Participant{

    private List<Joueur> membres;
    public Equipe(String name, LocalDate dateOfBirth, String mdp, String identifiant, List<Joueur> membres) {
        super(name, dateOfBirth, mdp, identifiant);
        this.membres = membres;
    }
    public List<Joueur> getMembres() {
        return membres;
    }

    public void setMembres(List<Joueur> membres) {
        this.membres = membres;
    }
    public void addMember(Joueur joueur){
        this.membres.add(joueur);
    }
    public void removeMember(Joueur joueur){
        this.membres.remove(joueur);
    }
    @Override
    public String toString() {
        return super.toString() + "\nMembres : " + membres;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        if (!super.equals(o)) return false;
        Equipe equipe = (Equipe) o;
        return membres.equals(equipe.membres);
    }
    @Override
    public int hashCode() {
        return super.hashCode() + membres.hashCode();
    }
}