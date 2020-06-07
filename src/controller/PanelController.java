package controller;

import model.Utilisateur;

/**
 *
 * @author benoitclemenceau
 */
public abstract class PanelController {

    // ATTRIBUTS
    

    protected boolean needRefresh = false;
    protected String refreshType;
    protected Utilisateur currentUser;
    protected Integer semaine;
    
    //Pour recherche : (+ semaine au dessus) - commencer par recherche par groupes
    protected Integer groupe;
   
    

    // GETTERS / SETTERS
    public boolean getNeedRefresh() {
        return this.needRefresh;
    }

    public Utilisateur getCurrentUser() {
        return this.currentUser;
    }

    public String getRefreshType() {
        return this.refreshType;
    }
    
    public Integer getSemaine() {
        return this.semaine;
    }
    
    public Integer getGroupe() {
        return this.groupe;
    }
    
}
