package controller;

import java.time.ZonedDateTime;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Utilisateur;
import view.*;

/**
 * Classe WindowController (contrôleur de la fenêtre de base) test
 */
public class WindowController {

    ///////////////
    // ATTRIBUTS //
    ///////////////
    private Window win;

    private boolean needRefresh = false;
    private String refreshType;

    private Utilisateur currentUser = null;

    //////////////
    // METHODES //
    //////////////
    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {

        // Making the look and feel universal
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace(System.err);
        }

        // On instancie la classe
        WindowController winCon = new WindowController();

        // On crée la fenêtre
        winCon.win = new Window();

        // La vue
        ConnectionPanel conPan = new ConnectionPanel();
        winCon.win.setContentPane(conPan);

        // Le controlleur
        ConnectionPanelController conPanCon = new ConnectionPanelController(conPan);

        // On affiche
        winCon.win.setVisible(true);

        // On lance la boucle infinie de mise à jour
        winCon.updateLoop(winCon, conPanCon);

    }

    /**
     * boucle infinie de mise à jour
     */
    private synchronized void updateLoop(WindowController winCon, PanelController panelController) {

        while (true) { //tourne en permanence

            // delay
            try {
                this.wait(1000);

            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }

            // get info
            needRefresh = panelController.getNeedRefresh();
            //System.out.println("needRefresh = " + needRefresh);
            System.out.println(".");
            
            // S'il y a besoin de refresh :
            if (needRefresh == true) {

                System.out.println("-- needRefresh = " + needRefresh + " --");
                System.out.println("-- Updating at " + ZonedDateTime.now() + " --");
                // On va cherche quel est le type de refresh needed
                refreshType = panelController.getRefreshType();
                System.out.println("-- refreshType = " + refreshType + " --");

                if (refreshType.equals("loadEDTPanel")) {

                    currentUser = panelController.getCurrentUser();
                    System.out.println("Loading EDT Panel for");
                    System.out.println("currentUser = " + currentUser.getId());

                    // On crée la vue et le controlleur
                    EDTPanel edtPanel = new EDTPanel(currentUser);
                    EDTPanelController edtPanelController = new EDTPanelController(currentUser, edtPanel);
                    
                    
                    // On affiche
                    winCon.win.setContentPane(edtPanel);
                    winCon.win.setVisible(true);

                    // On dit à l'updateLoop de se réferer au nouveau panel (fixe needRefresh à false au passage) 
                    panelController = edtPanelController;

                }
                if (refreshType.equals("loadSearchPanel")) {

                    currentUser = panelController.getCurrentUser();
                    System.out.println("Loading Search Panel for");
                    System.out.println("currentUser = " + currentUser.getId());

                }

                // UPDATE
                currentUser = panelController.getCurrentUser();

            }
        }

    }

    // GETTERS / SETTERS
    public void setCurrentUser(Utilisateur user) {
        this.currentUser = user;
    }

}
