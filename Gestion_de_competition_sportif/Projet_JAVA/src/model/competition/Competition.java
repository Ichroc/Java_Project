package model.competition;

import model.personne.Participant;

import java.time.LocalDate;
import java.util.List;

public class Competition {
    private String nom;                            // Nom de la compétition
    private String lieu;                           // Lieu de la compétition
    private LocalDate dateDebut;                   // Date de début
    private LocalDate dateFin;                     // Date de fin
    private String sport;                          // Type de sport
    private List<Match> matchs;                    // Liste des matchs prévus
    private List<Participant> participants;        // Équipes ou joueurs inscrit
}
