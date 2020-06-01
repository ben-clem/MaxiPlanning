package controller;

import java.util.Calendar;
import javax.swing.JPanel;
import model.Utilisateur;
import view.*;

/**
 * Classe WindowController (contrôleur de la fenêtre de base) test
 */
public class WindowController {

    // ATTRIBUTS
    private Utilisateur currentUser = null;
    private boolean needRefresh = false;

    // METHODES
    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {

        // On instancie la classe
        WindowController winCon = new WindowController();

        // On crée la fenêtre
        Window win = new Window();

        // La vue
        ConnectionPanel conPan = new ConnectionPanel();
        win.setContentPane(conPan);

        // Le controlleur
        ConnectionPanelController conPanCon = new ConnectionPanelController(conPan);

        // On affiche
        win.setVisible(true);

        // On lance la boucle infinie de mise à jour
        winCon.update(conPanCon);

    }

    /**
     * boucle infinie de mise à jour
     */
    private synchronized void update(PanelController panelController) {

        while (true) { //tourne en permanence

            // delay
            try {
                this.wait(2000);

            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }

            // get info
            needRefresh = panelController.getNeedRefresh();
            System.out.println("needRefresh = " + needRefresh);

            // S'il y a besoin de refresh :
            if (needRefresh == true) {

                System.out.println("Updating at " + Calendar.getInstance().getTime());
                

                // UPDATE
                currentUser = panelController.getCurrentUser();
                System.out.println("currentUser = " + currentUser.getId());

            }
        }

    }

    // GETTERS / SETTERS
    public void setCurrentUser(Utilisateur user) {
        this.currentUser = user;
    }

}
