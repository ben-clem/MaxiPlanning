package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.DAO;
import model.DB;
import model.Seance;
import model.SeanceDAO;
import model.Utilisateur;
import view.AddPanel;
import view.EDTPanel;
import view.SearchPanel;

/**
 * 
 */
public final class AddPanelController extends PanelController {

    ///////////////
    // ATTRIBUTS //
    ///////////////
    private AddPanel theView;
    private static String recapQuery = "";
    private static Integer insertID = 0;

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

    // On implémente l'ActionListener du ajouterSeance
    class AjouterSeanceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            //date
            JTextField dateField = theView.getDatePicker().getJFormattedTextField();
            String date = dateField.getText();

            //heure début
            String heureDebut = theView.getHeureDebut2().getText();

            //heure fin
            String heureFin = theView.getHeureFin2().getText();

            //cours
            String cours = theView.getCours2().getSelectedItem().toString();
            Integer coursInt = theView.getCours2().getSelectedIndex() + 1;

            //typeCours
            Integer typeCoursInt = theView.getTypeCours2().getSelectedIndex() + 1;
            String typeCours = theView.getTypeCours2().getSelectedItem().toString();

            //Groupes
            List<Integer> listeGroupes = new ArrayList<>();

            if (theView.getC1().isSelected()) {
                listeGroupes.add(1);
            }
            if (theView.getC2().isSelected()) {
                listeGroupes.add(2);
            }
            if (theView.getC3().isSelected()) {
                listeGroupes.add(3);
            }
            if (theView.getC4().isSelected()) {
                listeGroupes.add(4);
            }
            if (theView.getC5().isSelected()) {
                listeGroupes.add(5);
            }
            if (theView.getC6().isSelected()) {
                listeGroupes.add(6);
            }
            if (theView.getC7().isSelected()) {
                listeGroupes.add(7);
            }
            if (theView.getC8().isSelected()) {
                listeGroupes.add(8);
            }
            if (theView.getC9().isSelected()) {
                listeGroupes.add(9);
            }

            //enseignant (nom => idUtilisateur en dur car flemme)
            String enseignant = theView.getEnseignants2().getSelectedItem().toString();
            Integer ensIdUtil = 0;
            switch (enseignant) {
                case "Coudray":
                    ensIdUtil = 3;
                    break;
                case "Crambes":
                    ensIdUtil = 4;
                    break;
                case "Mouhali":
                    ensIdUtil = 5;
                    break;
                case "Maupile":
                    ensIdUtil = 35;
                    break;
                case "Bennani":
                    ensIdUtil = 36;
                    break;
                case "Rendler":
                    ensIdUtil = 37;
                    break;
                case "Falih":
                    ensIdUtil = 38;
                    break;
                case "Mokhber":
                    ensIdUtil = 39;
                    break;
                case "Professeur":
                    ensIdUtil = 41;
                    break;
                case "Test":
                    ensIdUtil = 44;
                    break;
                case "Ferdeghini":
                    ensIdUtil = 45;
                    break;
                case "Girinsky":
                    ensIdUtil = 46;
                    break;
                case "Reese":
                    ensIdUtil = 47;
                    break;
                case "Luxereau":
                    ensIdUtil = 48;
                    break;

            }

            //Salles
            List<Integer> listeSalles = new ArrayList<>();

            if (theView.getS1().isSelected()) {
                listeSalles.add(1);
            }
            if (theView.getS2().isSelected()) {
                listeSalles.add(2);
            }
            if (theView.getS3().isSelected()) {
                listeSalles.add(3);
            }
            if (theView.getS4().isSelected()) {
                listeSalles.add(4);
            }
            if (theView.getS5().isSelected()) {
                listeSalles.add(7);
            }
            if (theView.getS6().isSelected()) {
                listeSalles.add(8);
            }
            if (theView.getS7().isSelected()) {
                listeSalles.add(5);
            }
            if (theView.getS8().isSelected()) {
                listeSalles.add(6);
            }

            //etat
            Integer etatInt = 0;
            String etat = theView.getEtat2().getSelectedItem().toString();
            if ("Validée".equals(etat)) {
                etatInt = 1;
            }

            //vérifier que tous les champs nécessaires sont remplis et envoyer popup sinon
            if (date.isEmpty() || heureDebut.isEmpty() || heureFin.isEmpty() || cours.isEmpty() || typeCours.isEmpty()) {
                theView.popupWarning("Veuillez renseigner tous les champs marqués d'une étoile");
            } else {
                // générer la commande SQL

                //générer semaine
                ZonedDateTime zoDaTi = ZonedDateTime.parse(date + "T10:15:30+01:00[Europe/Paris]");
                semaine = zoDaTi.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);

                String query1 = "INSERT INTO seance (Semaine, Date, Heure_debut, Heure_fin, Etat, ID_cours, Id_type)\n"
                        + "VALUES ("
                        + semaine + ", "
                        + "'" + date + "', "
                        + "'" + heureDebut + "', "
                        + "'" + heureFin + "', "
                        + etatInt + ", "
                        + coursInt + ", "
                        + typeCoursInt + ")";

                recapQuery = recapQuery + query1;

                //Envoyer query et récupérer idSeance
                try {

                    // Connection à la DB
                    DB db = new DB();

                    try (Connection conn = db.connect()) {

                        Statement st = conn.createStatement();
                        Integer inserted = st.executeUpdate(query1, Statement.RETURN_GENERATED_KEYS);

                        if (inserted == 1) {
                            try (ResultSet rs = st.getGeneratedKeys()) {
                                if (rs.next()) {
                                    insertID = rs.getInt(1);
                                }
                            }
                            System.out.println("-- Séance insérée dans la DB");
                            System.out.println("insertID = " + insertID);
                        }
                    }
                } catch (SQLException e) {

                    e.printStackTrace(System.err);
                    theView.popupError("Erreur lors de la connexion à la DB !\nErreur : " + e);

                }

                //Récupérer idUtilisateur à partir de id enseignant
                String query2 = "INSERT INTO seance_enseignants (ID_seance, ID_utilisateur)\n"
                        + "VALUES ("
                        + insertID + ", "
                        + ensIdUtil + ")";

                //Envoyer
                try {
                    DB db = new DB();
                    try (Connection conn = db.connect()) {

                        Statement st = conn.createStatement();
                        st.executeUpdate(query2);

                        System.out.println("-- Séance_enseignants inséré dans la DB");
                        System.out.println("insertID = " + insertID);

                    }
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                    theView.popupError("Erreur lors de la connexion à la DB !\nErreur : " + e);
                }

                recapQuery = recapQuery + "\n\nlast inserted ID = " + insertID + "\n\n" + query2;

                // Pour chaque groupe
                listeGroupes.forEach(groupe -> {

                    String query3 = "INSERT INTO seance_groupes (ID_seance, ID_groupe)\n"
                            + "VALUES ("
                            + insertID + ", "
                            + groupe + ")";

                    //Envoyer
                    try {
                        DB db = new DB();
                        try (Connection conn = db.connect()) {

                            Statement st = conn.createStatement();
                            st.executeUpdate(query3);

                            System.out.println("-- Séance_groupes inséré dans la DB");
                            System.out.println("insertID = " + insertID);

                        }
                    } catch (SQLException e) {
                        e.printStackTrace(System.err);
                        theView.popupError("Erreur lors de la connexion à la DB !\nErreur : " + e);
                    }

                    recapQuery = recapQuery + "\n\n" + query3;

                });

                listeSalles.forEach(salle -> {

                    String query4 = "INSERT INTO seance_salles (ID_seance, ID_salle)\n"
                            + "VALUES ("
                            + insertID + ", "
                            + salle + ")";

                    //Envoyer
                    try {
                        DB db = new DB();
                        try (Connection conn = db.connect()) {

                            Statement st = conn.createStatement();
                            st.executeUpdate(query4);

                            System.out.println("-- seance_salles insérée dans la DB");
                            System.out.println("insertID = " + insertID);

                        }
                    } catch (SQLException e) {
                        e.printStackTrace(System.err);
                        theView.popupError("Erreur lors de la connexion à la DB !\nErreur : " + e);
                    }

                    recapQuery = recapQuery + "\n\n" + query4;
                });

                //theView.popup("Séance ajoutée correctement !\n\nRequêtes SQL :\n\n" + recapQuery);
                theView.popup("Séance ajoutée correctement !");
            }

            needRefresh = true;
            refreshType = "loadAddPanel";

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
    public AddPanelController(Utilisateur user, AddPanel theView) {

        this.theView = theView;
        currentUser = user;

        // add buttons listeners
        // On connecte l'ActionListener à la vue
        this.theView.addSearchButListener(new SearchButListener());
        this.theView.addAddButListener(new AddButListener());
        this.theView.addButton3Listener(new Button3Listener());
        this.theView.addAjouterSeanceListener(new AjouterSeanceListener());
    }

}
