package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.DAO;
import model.DB;
import model.Utilisateur;
import model.UtilisateurDAO;
import view.ConnectionPanel;

// The Controller coordinates interactions
// between the View and Model
public class ConnectionPanelController extends PanelController {

    // ATTRIBUTS
    // On implémente l'ActionListener
    class ConnButtonListener implements ActionListener {

        String email, password = "null";

        @Override
        public void actionPerformed(ActionEvent event) {

            try {

                email = theView.getEmail();
                password = theView.getPassword();

                if (email.isEmpty() || password.isEmpty()) {
                    theView.popupWarning("Veuillez remplir l'email et le password.");
                } else {

                    // Connection à la DB
                    DB db = new DB();
                    Connection conn = db.connect();

                    // On va cherche l'utilisateur correspondant
                    DAO<Utilisateur> utilisateurDAO = new UtilisateurDAO(conn);
                    Utilisateur utilisateur = utilisateurDAO.find(email, password);

                    // On affiche dans la console
                    System.out.println("Utilisateur n°" + utilisateur.getId() + " - Droit : " + utilisateur.getDroit() + " - " + utilisateur.getNom() + " " + utilisateur.getPrenom() + " " + utilisateur.getEmail() + " " + utilisateur.getPassword());

                    // Il faut maintenant rediriger vers une page en fonction du type d'utilisateur
                    if (utilisateur.getId() != null) {
                        currentUser = utilisateur;
                        needRefresh = true;
                    }
                }

            } catch (Exception e) {

                e.printStackTrace(System.err);
                theView.popupError("Erreur : " + e);

            }

        }

    }

    // METHODES
    /**
     * base constructor
     *
     * @param theView
     */
    public ConnectionPanelController(ConnectionPanel theView) {

        this.theView = theView;

        // On connecte l'ActionListener à la vue
        this.theView.addConnButtonListener(new ConnButtonListener());

    }

}
