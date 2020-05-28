package controller;

import view.*;

/**
 * Classe WindowController (contrôleur de la fenêtre de base) test
 */

public class WindowController {

    // METHODES

    /**
    * main
     * @param args
    */
    public static void main(String[] args) {
        
        Window win = new Window();

        ConnectionPanel conPan = new ConnectionPanel();
        win.setContentPane(conPan);

        //Model
        
        ConnectionPanelController conPanCon = new ConnectionPanelController(conPan);
        
        win.setVisible(true);
    }

}
