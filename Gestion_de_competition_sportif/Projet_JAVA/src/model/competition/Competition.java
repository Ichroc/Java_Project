package model.competition;

import model.personne.Equipe;
import model.personne.Personne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Competition {
    private String nom;                            // Nom de la compétition
    private String lieu;                           // Lieu de la compétition
    private LocalDate dateDebut;                   // Date de début
    private LocalDate dateFin;                     // Date de fin
    private String sport;                          // Type de sport
    private List<Match> matchs;                    // Liste des matchs prévus
    private List<Equipe> participants;        // Équipes ou joueurs inscrit
    private String status;                         // Statut de la compétition
    private String level;                          // Niveau de la compétition
    private String isPlayedBy;                    // Indique ceux qui sont concernés par la compétition

    public Competition(String nom, String lieu, LocalDate dateDebut, LocalDate dateFin, String sport, List<Match> matchs, List<Equipe> participants, String status, String level, String isPlayedBy) {
        this.nom = nom;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.sport = sport;
        this.matchs = matchs;
        this.participants = participants;
        this.status = status;
        this.level = level;
        this.isPlayedBy = isPlayedBy;
    }
    // Getters & Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

    public List<Equipe> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Equipe> participants) {
        this.participants = participants;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String isPlayedBy() {
        return isPlayedBy;
    }

    public void setPlayedBy(String playedBy) {
        isPlayedBy = playedBy;
    }

    public void addEquipe(Equipe participant) {
        this.participants.add(participant);
    }

    public void removePersonne(Personne participant) {
        this.participants.remove(participant);
    }

    public void addMatch(Match match) {
        this.matchs.add(match);
    }

    public void removeMatch(Match match) {
        this.matchs.remove(match);
    }

    public void genererMatchsEliminatoires() {
        if (participants == null || participants.size() < 2) return;

        // Liste des matchs générés
        List<Match> generatedMatchs = new ArrayList<>();
        List<Equipe> tourActuel = new ArrayList<>(participants);
        Collections.shuffle(tourActuel); // Mélange aléatoire

        LocalDateTime dateMatch = LocalDateTime.now().plusWeeks(1).withHour(17).withMinute(0).withSecond(0).withNano(0);

        int round = 1;

        while (tourActuel.size() >= 2) {
            List<Equipe> prochainTour = new ArrayList<>();

            for (int i = 0; i < tourActuel.size() - 1; i += 2) {
                Equipe p1 = tourActuel.get(i);
                Equipe p2 = tourActuel.get(i + 1);

                LocalDate dateJour = dateMatch.toLocalDate();

                // Création du match selon le type de sport
                int dureeMinutes = switch (sport.toLowerCase()) {
                    case "football" -> 90;
                    case "basketball" -> 48;
                    default -> 60; // Valeur par défaut
                };

                LocalDateTime fin = dateMatch.plusMinutes(dureeMinutes);
                Match match = new Match("Tour " + round, dateJour, dateMatch.toLocalTime(), fin.toLocalTime(), p1, p2);

                generatedMatchs.add(match);
                prochainTour.add(p1); // Simulation : on fait avancer p1
                dateMatch = dateMatch.plusDays(1); // Un match par jour
            }

            tourActuel = prochainTour;
            round++;
        }

        this.matchs = generatedMatchs;
    }


}
