package model;

import java.util.*;

/**
 * classe Enseignant couche métier
 */
public class Enseignant {

    // ATTRIBUTS

    private Integer idUtilisateur;
    private Set<Integer> idCours;

    // GETTERS / SETTERS

    public Integer getIdUtilisateur() {
        return this.idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Set<Integer> getIdCours() {
        if (this.idCours == null) {
            this.idCours = new HashSet<Integer>();
        }
        return this.idCours;
    }

    public void setIdCours(Set <Integer> idCours) {
        this.idCours = idCours;
    }

    // METHODES

    /**
     * default constructor
     */
    public Enseignant() {
    }

    /**
     * base constructor
     */
    public Enseignant(Integer idUtilisateur) {
        // TODO
    }

    /**
     * ajout d'un Cours à l'Enseignant
     */
    public boolean addCours(Integer idCours) {
        // TODO
        return false;
    }

}
