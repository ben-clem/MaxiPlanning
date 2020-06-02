package controller;

import java.sql.Connection;
import model.DB;
import view.EDTPanel;

/**
 * @generated
 */
public class EDTPanelController extends PanelController {

    ///////////////
    // ATTRIBUTS //
    ///////////////
    protected EDTPanel theView;

    //////////////
    // METHODES //
    //////////////
    /**
     * base constructor
     *
     * @param theView
     */
    public EDTPanelController(EDTPanel theView) {

        this.theView = theView;

        // add buttons listeners
    }

    public void fetchSeances() {
        
        // Connection à la DB
        DB db = new DB();
        Connection conn = db.connect();

        // On va cherche les séances correspondant
        
    }

}
