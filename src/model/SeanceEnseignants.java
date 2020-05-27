package model;

import java.util.*;

/**
 * classe SeanceEnseignants couche métier
 */
public class SeanceEnseignants {
    
    // ATTRIBUTS
    
    private Integer idSeance;
    private Set<Integer> idEnseignants;
    
    // GETTERS / SETTERS

    public Integer getIdSeance() {
        return this.idSeance;
    }
    
    public void setIdSeance(Integer idSeance) {
        this.idSeance = idSeance;
    }
    
    public Set<Integer> getIdEnseignants() {
        if (this.idEnseignants == null) {
            this.idEnseignants = new HashSet<Integer>();
        }
        return this.idEnseignants;
    }
    
    public void setIdEnseignants(Set<Integer> idEnseignants) {
        this.idEnseignants = idEnseignants;
    }
    
    // METHODES

    /**
     * default constructor
     */
    public SeanceEnseignants() {
    }

    /**
     * base constructor
     */
    public SeanceEnseignants(Integer idSeance) {
        // TODO
    }

    /**
     * ajout d'un Enseignant à la SeanceEnseignants
     */
    public boolean addEnseignant(Integer idEnseignant) {
        // TODO
        return false;
    }
    
}
