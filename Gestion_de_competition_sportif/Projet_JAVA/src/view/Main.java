package view;

import model.personne.Equipe;
import model.personne.Joueur;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!");
        Joueur j1 = new Joueur("Lucas", LocalDate.of(1995, 12, 12), "1234", "lucas", "France", 1.75f, "Bernard");
        Joueur j2 = new Joueur("Yassine", LocalDate.of(1995, 12, 12), "1234", "lucas", "France", 1.75f, "Bernard");

        Equipe e1 = new Equipe("Dragons", 3);
        Equipe e2 = new Equipe("Panthers", 4);

        Equipe.ajouterJoueurParNomEquipe("Dragons", j1);
        Equipe.ajouterJoueurParNomEquipe("Dragons", j2);

        System.out.println(e1); // Équipe: Dragons (2/3 joueurs)
        System.out.println(e2); // Équipe: Panthers (0/4 joueurs)


    }
}
