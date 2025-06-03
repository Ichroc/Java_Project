package model.personne;

import java.time.LocalDate;

public abstract class Participant extends Personne{
    public Participant(String name, LocalDate dateOfBirth, String mdp, String identifiant) {
        super(name, dateOfBirth, mdp, identifiant);
    }
}
