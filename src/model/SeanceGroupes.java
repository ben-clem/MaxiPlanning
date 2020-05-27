package model;

import java.util.*;

/**
 * classe SeanceGroupes couche métier
 */
public class SeanceGroupes {
    
    // ATTRIBUTS
    
    private Integer idSeance;
    private Set<Integer> idGroupes;
    
    // GETTERS / SETTERS

    public Integer getIdSeance() {
        return this.idSeance;
    }
    
    public void setIdSeance(Integer idSeance) {
        this.idSeance = idSeance;
    }
    
    public Set<Integer> getIdGroupes() {
        if (this.idGroupes == null) {
            this.idGroupes = new HashSet<Integer>();
        }
        return this.idGroupes;
    }
    
    public void setIdGroupes(Set<Integer> idGroupes) {
        this.idGroupes = idGroupes;
    }
    
    // METHODES

    /**
     * default constructor
     */
    public SeanceGroupes() {
    }

    /**
     * base constructor
     */
    public SeanceGroupes(Integer idSeance) {
        // TODO
    }

    /**
     * ajout d'un Groupe à la SeanceGroupes
     */
    public boolean addGroupe(Integer idGroupe) {
        // TODO
        return false;
    }
    
}
