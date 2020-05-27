package controller;


import model.*;
import view.*;
import javax.swing.JFrame;


/**
 * Classe WindowController (contrôleur de la fenêtre de base) test
 */

public class WindowController {

    // METHODES

    /**
    * main
    */
    public static void main(String[] args) {
        
        Window win = new Window();

        ConnectionPanel conPan = new ConnectionPanel();
        
        win.setContentPane(conPan);

        win.setVisible(true);
    }

}
