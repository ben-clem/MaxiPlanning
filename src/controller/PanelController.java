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
    
}
