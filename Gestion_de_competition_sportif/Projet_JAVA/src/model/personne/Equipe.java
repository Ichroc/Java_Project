package model.personne;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nom;
    private final int nombreMaxJoueurs;
    private final List<Joueur> joueurs;

    // Liste statique de toutes les équipes
    private static final List<Equipe> toutesLesEquipes = new ArrayList<>();

    public Equipe(String nom, int nombreMaxJoueurs) {
        this.nom = nom;
        this.nombreMaxJoueurs = nombreMaxJoueurs;
        this.joueurs = new ArrayList<>();
        toutesLesEquipes.add(this); // Ajoute automatiquement l'équipe à la liste globale
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreMaxJoueurs() {
        return nombreMaxJoueurs;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public int getNombreJoueursActuels() {
        return joueurs.size();
    }

    public boolean ajouterJoueur(Joueur joueur) {
        if (joueurs.size() < nombreMaxJoueurs && !joueurs.contains(joueur)) {
            joueurs.add(joueur);
            return true;
        }
        return false;
    }

    public boolean retirerJoueur(Joueur joueur) {
        return joueurs.remove(joueur);
    }

    @Override
    public String toString() {
        return "Équipe: " + nom + " (" + joueurs.size() + "/" + nombreMaxJoueurs + " joueurs)";
    }

    // ✅ Méthode statique pour trouver une équipe et y ajouter un joueur
    public static boolean ajouterJoueurParNomEquipe(String nomEquipe, Joueur joueur) {
        for (Equipe equipe : toutesLesEquipes) {
            if (equipe.getNom().equalsIgnoreCase(nomEquipe)) {
                return equipe.ajouterJoueur(joueur);
            }
        }
        return false; // Aucune équipe trouvée
    }

    public static List<Equipe> getToutesLesEquipes() {
        return toutesLesEquipes;
    }
}
