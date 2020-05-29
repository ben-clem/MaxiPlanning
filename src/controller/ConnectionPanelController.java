package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import model.DAO;
import model.Utilisateur;
import model.UtilisateurDAO;
import view.ConnectionPanel;

// The Controller coordinates interactions
// between the View and Model
public class ConnectionPanelController {

    // ATTRIBUTS
    private ConnectionPanel theView;
    // model ?

    // METHODES
    // public ConnectionPanelController(ConnectionPanel theView, Model? theModel) {
    public ConnectionPanelController(ConnectionPanel theView) {
        this.theView = theView;
        //this.theModel = theModel;

        // On connecte l'ActionListener à la vue
        this.theView.addConnButtonListener(new ConnButtonListener());
    }

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
                    // Les champs sont remplis, on va chercher dans la DB

                    // test establishing connection
                    Connection conn = null;

                    try {
                        String userName = "root";
                        String password = "root";
                        String url = "jdbc:mysql://localhost:8889/MaxiPlanning?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris";

                        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                        conn = DriverManager.getConnection(url, userName, password);

                        System.out.println("Database connection established");

                    } catch (Exception e) {

                        System.err.println("Cannot connect to database server");
                        e.printStackTrace();

                    }

                    // fin test
                    
                    DAO<Utilisateur> utilisateurDAO = new UtilisateurDAO(conn);

                    Utilisateur utilisateur = utilisateurDAO.find(email, password);
                    System.out.println("Elève N°" + utilisateur.getId()+ "  - " + utilisateur.getNom() + " " + utilisateur.getPrenom() + " " + utilisateur.getEmail() + " " + utilisateur.getPassword());

                }

            } catch (Exception e) {

                e.printStackTrace(System.err);
                theView.popupError("Erreur : " + e);

            }

        }

    }

}
