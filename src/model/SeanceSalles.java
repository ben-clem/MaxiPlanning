package model;

import java.util.*;

/**
 * classe SeanceSalles couche métier
 */
public class SeanceSalles {
    
    // ATTRIBUTS
    
    private Integer idSeance;
    private Set<Integer> idSalles;
    
    // GETTERS / SETTERS

    public Integer getIdSeance() {
        return this.idSeance;
    }
    
    public void setIdSeance(Integer idSeance) {
        this.idSeance = idSeance;
    }
    
    public Set<Integer> getIdSalles() {
        if (this.idSalles == null) {
            this.idSalles = new HashSet<Integer>();
        }
        return this.idSalles;
    }
    
    public void setIdSalles(Set<Integer> idSalles) {
        this.idSalles = idSalles;
    }
    
    // METHODES

    /**
     * default constructor
     */
    public SeanceSalles() {
    }

    /**
     * base constructor
     */
    public SeanceSalles(Integer idSeance) {
        // TODO
    }

    /**
     * ajout d'une Salle à la SeanceSalles
     */
    public boolean addSalle(Integer idSalle) {
        // TODO
        return false;
    }
    
}
