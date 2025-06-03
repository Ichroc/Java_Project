package model.competition;

import model.personne.Equipe;
import model.personne.Personne;

import java.time.LocalDate;
import java.time.LocalTime;

public class Match {
    private String nom;                 // Nom du match : "Tour 1", "Finale", etc.
    private LocalDate date;            // Date du match
    private LocalTime heureDebut;      // Heure de début
    private LocalTime heureFin;        // Heure de fin
    private Equipe participant1;  // Joueur ou équipe 1
    private Equipe participant2;  // Joueur ou équipe 2

    public Match(String nom, LocalDate date, LocalTime heureDebut, LocalTime heureFin, Equipe participant1, Equipe participant2) {
        this.nom = nom;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public Equipe getEquipe1() {
        return participant1;
    }

    public void setEquipe1(Equipe participant1) {
        this.participant1 = participant1;
    }

    public Equipe getEquipe2() {
        return participant2;
    }

    public void setEquipe2(Equipe participant2) {
        this.participant2 = participant2;
    }

    @Override
    public String toString() {
        return nom + " : " + participant1.getNom() + " vs " + participant2.getNom() +
                " - " + date + " à " + heureDebut + " (" + heureFin + ")";
    }
}
