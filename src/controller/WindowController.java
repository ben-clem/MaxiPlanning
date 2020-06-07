package controller;

import java.time.ZonedDateTime;
import java.time.temporal.IsoFields;
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
                this.wait(100);

            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }

            // get info
            needRefresh = panelController.getNeedRefresh();

            //System.out.println("needRefresh = " + needRefresh);
            //System.out.println(".");

            // S'il y a besoin de refresh :
            if (needRefresh == true) {

                System.out.println("-- needRefresh = " + needRefresh + " --");
                System.out.println("-- Updating at " + ZonedDateTime.now() + " --");

                // On va cherche quel est le type de refresh needed
                refreshType = panelController.getRefreshType();

                System.out.println("-- refreshType = " + refreshType + " --");

                switch (refreshType) {

                    case "loadEDTPanel":

                        currentUser = panelController.getCurrentUser();
                        System.out.println("Loading EDT Panel for");
                        System.out.println("currentUser = " + currentUser.getId());

                        Integer semaine = panelController.getSemaine();
                        if (semaine == null) {
                            semaine = ZonedDateTime.now().get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
                        }

                        // On crée la vue et le controlleur
                        EDTPanel edtPanel = new EDTPanel(currentUser, semaine);
                        EDTPanelController edtPanelController = new EDTPanelController(currentUser, edtPanel);

                        // On affiche
                        winCon.win.setContentPane(edtPanel);
                        winCon.win.setVisible(true);

                        // On dit à l'updateLoop de se réferer au nouveau panel (fixe needRefresh à false au passage) 
                        panelController = edtPanelController;

                        break;

                    case "loadRecapPanel":

                        currentUser = panelController.getCurrentUser();
                        System.out.println("Loading Recap Panel for");
                        System.out.println("currentUser = " + currentUser.getId());

                        // On crée la vue et le controlleur
                        RecapPanel recapPanel = new RecapPanel(currentUser);
                        RecapPanelController recapPanelController = new RecapPanelController(currentUser, recapPanel);

                        // On affiche
                        winCon.win.setContentPane(recapPanel);
                        winCon.win.setVisible(true);

                        // On dit à l'updateLoop de se réferer au nouveau panel (fixe needRefresh à false au passage) 
                        panelController = recapPanelController;

                        break;

                    case "loadSearchPanel":

                        currentUser = panelController.getCurrentUser();
                        System.out.println("Loading Search Panel for");
                        System.out.println("currentUser = " + currentUser.getId());

                        // On crée la vue et le controlleur
                        SearchPanel searchPanel = new SearchPanel(currentUser);
                        SearchPanelController searchPanelController = new SearchPanelController(currentUser, searchPanel);

                        // On affiche
                        winCon.win.setContentPane(searchPanel);
                        winCon.win.setVisible(true);

                        // On dit à l'updateLoop de se réferer au nouveau panel (fixe needRefresh à false au passage) 
                        panelController = searchPanelController;

                        break;

                    case "loadAddPanel":

                        currentUser = panelController.getCurrentUser();
                        System.out.println("Loading Add Panel for");
                        System.out.println("currentUser = " + currentUser.getId());

                        // On crée la vue et le controlleur
                        AddPanel addPanel = new AddPanel(currentUser);
                        AddPanelController addPanelController = new AddPanelController(currentUser, addPanel);

                        // On affiche
                        winCon.win.setContentPane(addPanel);
                        winCon.win.setVisible(true);

                        // On dit à l'updateLoop de se réferer au nouveau panel (fixe needRefresh à false au passage) 
                        panelController = addPanelController;

                        break;

                    case "decoReco":

                        System.out.println("DecoReco");

                        // On crée la vue et le controlleur
                        ConnectionPanel connPanel = new ConnectionPanel();
                        ConnectionPanelController connPanelController = new ConnectionPanelController(connPanel);

                        // On affiche
                        winCon.win.setContentPane(connPanel);
                        winCon.win.setVisible(true);

                        // On dit à l'updateLoop de se réferer au nouveau panel (fixe needRefresh à false au passage) 
                        panelController = connPanelController;

                        break;
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
