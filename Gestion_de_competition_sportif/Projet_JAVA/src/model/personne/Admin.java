package model.personne;

import java.time.LocalDate;
import java.util.Objects;

public class Admin extends Personne{
    String surname;

    public Admin(String name, LocalDate dateOfBirth, String mdp, String identifiant, String surname) {
        super(name, dateOfBirth, mdp, identifiant);
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String nom) {
        this.surname = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(surname, admin.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), surname);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nSurname : ");
        sb.append(surname.toUpperCase());
        return sb.toString();
    }
}
