package controller;

import model.Utilisateur;
import view.ConnectionPanel;

/**
 *
 * @author benoitclemenceau
 */
public abstract class PanelController {

    // ATTRIBUTS
    protected ConnectionPanel theView;
    protected Utilisateur currentUser = null;
    protected boolean needRefresh = false;

    // GETTERS / SETTERS
    public boolean getNeedRefresh() {
        return this.needRefresh;
    }

    public Utilisateur getCurrentUser() {
        return this.currentUser;
    }
}
