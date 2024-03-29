package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JComboBox;
import model.DAO;
import model.DB;
import model.Seance;
import model.SeanceDAO;
import model.Utilisateur;
import view.EDTPanel;
import view.SearchPanel;

/**
 * @generated
 */
public final class SearchPanelController extends PanelController {

    ///////////////
    // ATTRIBUTS //
    ///////////////
    private SearchPanel theView;

    // On implémente l'ActionListener du button1
    class Button1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            needRefresh = true;
            refreshType = "loadEDTPanel";

        }

    }

    // On implémente l'ActionListener du button2
    class Button2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            needRefresh = true;
            refreshType = "loadRecapPanel";

        }

    }
    
    // On implémente l'ActionListener du SearchBut
    class SearchButListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            needRefresh = true;
            refreshType = "loadSearchPanel";

        }

    }
    
    // On implémente l'ActionListener du AddBut
    class AddButListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            needRefresh = true;
            refreshType = "loadAddPanel";

        }

    }

    // On implémente l'ActionListener du button3
    class Button3Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            needRefresh = true;
            refreshType = "decoReco";

        }

    }
    
    



//////////////
// METHODES //
//////////////
    /**
     * base constructor
     *
     * @param user
     * @param theView
     */
    public SearchPanelController(Utilisateur user, SearchPanel theView) {

        this.theView = theView;
        currentUser = user;

        // add buttons listeners
        // On connecte l'ActionListener à la vue
        this.theView.addButton1Listener(new Button1Listener());
        this.theView.addButton2Listener(new Button2Listener());
        this.theView.addSearchButListener(new SearchButListener());
        this.theView.addAddButListener(new AddButListener());
        this.theView.addButton3Listener(new Button3Listener());
        
    }

    /**
     * récupère les séances de l'utilisateur
     */
    public void fetchSeances() {

        try {

            List<Seance> seances;

            // Connection à la DB
            DB db = new DB();

            // On va cherche l'utilisateur correspondant
            try (Connection conn = db.connect()) {

                // On va cherche l'utilisateur correspondant
                DAO<Seance> seanceDAO = new SeanceDAO(conn);

                if (currentUser.getDroit() == 4) {
                    seances = seanceDAO.findWithStudentId(currentUser.getId());
                } else {
                    seances = seanceDAO.findWithProfId(currentUser.getId());
                }

            }

            // On affiche dans la console
            seances.forEach((seance) -> {
                //System.out.println("Seance : " + seance.getId());
            });

            // Si pas de séances :
            if (seances.isEmpty()) {
                theView.popupWarning("Aucunes séances trouvées");
            } // Si des séances ont été trouvées, il faut maintenant les afficher
            else if (!seances.isEmpty()) {
                // sort
                Collections.sort(seances, Comparator.comparing(Seance::getDate)
                        .thenComparing(Seance::getHeureDebut)
                        .thenComparing(Seance::getHeureFin));

                this.theView.showSeances(seances);

            }

        } catch (SQLException e) {

            e.printStackTrace(System.err);
            theView.popupError("Erreur lors de la connexion à la DB !\nErreur : " + e);

        }

    }

}
