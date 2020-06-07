package view;

import javax.swing.*;
import java.awt.*;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import model.*;

/**
 * classe EDTPanel (panneau emploi du temps)
 */
public final class RecapPanel extends JPanel {

    ///////////////
    // ATTRIBUTS //
    ///////////////
    private Color bg = new Color(0, 113, 121);

    private JButton button1;
    private JButton button2;
    private JButton searchBut;
    private JButton button3;
    private JPanel choiceDisplay;
    private Integer lastIdCours;
    private Integer lastIdType;

    //////////////
    // METHODES //
    //////////////
    /**
     * default constructor
     */
    public RecapPanel() {
    }

    /**
     * constructor
     *
     * @param user
     */
    public RecapPanel(Utilisateur user) {

        // Background et Layout
        setLayout(new BorderLayout());

        // Border Layout Page Start
        JPanel borderLayoutPageStart = new JPanel();
        borderLayoutPageStart.setLayout(new BoxLayout(borderLayoutPageStart, BoxLayout.PAGE_AXIS));

        // Menu Bar
        JPanel menuBar = new JPanel();
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.LINE_AXIS));

        button1 = new JButton("Emploi du Temps");
        button1.setMargin(new Insets(10, 0, 10, 0));
        button1.setMinimumSize(new Dimension(200, 50));
        button1.setPreferredSize(new Dimension(200, 50));
        button1.setMaximumSize(new Dimension(200, 50));
        button1.setBackground(Color.WHITE);
        button1.setForeground(bg);
        menuBar.add(button1);

        button2 = new JButton("Récap Cours");
        button2.setMargin(new Insets(10, 0, 10, 0));
        button1.setMinimumSize(new Dimension(200, 50));
        button2.setPreferredSize(new Dimension(200, 50));
        button2.setMaximumSize(new Dimension(200, 50));
        button2.setBackground(bg);
        button2.setForeground(Color.WHITE);
        menuBar.add(button2);

        searchBut = new JButton("Rechercher");
        searchBut.setMargin(new Insets(10, 0, 10, 0));
        searchBut.setMinimumSize(new Dimension(200, 50));
        searchBut.setPreferredSize(new Dimension(200, 50));
        searchBut.setMaximumSize(new Dimension(200, 50));
        searchBut.setBackground(Color.WHITE);
        searchBut.setForeground(bg);

        if (user.getDroit() == 2) {
            menuBar.add(searchBut);
        }

        menuBar.add(Box.createHorizontalGlue());

        button3 = new JButton("Déconnexion");
        button3.setMargin(new Insets(10, 0, 10, 0));
        button3.setMinimumSize(new Dimension(200, 50));
        button3.setPreferredSize(new Dimension(200, 50));
        button3.setMaximumSize(new Dimension(200, 50));
        button3.setBackground(Color.WHITE);
        button3.setForeground(Color.RED);
        menuBar.add(button3);

        menuBar.setAlignmentX(LEFT_ALIGNMENT);
        borderLayoutPageStart.add(menuBar);

        // Choice Display
        choiceDisplay = new JPanel();
        choiceDisplay.setLayout(new BoxLayout(choiceDisplay, BoxLayout.LINE_AXIS));

        JLabel hello = new JLabel(" Bonjour " + user.getPrenom()
                + " (" + user.getNomDroit() + ") ");
        choiceDisplay.add(hello);

        if (user.getDroit() == 4) { // si c'est un étudiant :
            Etudiant student = user.getEtudiant();

            JLabel promoGroupe = new JLabel(" -  " + student.getGroupe().getPromoName() + " " + student.getGroupe().getNom());

            choiceDisplay.add(promoGroupe);
        }

        choiceDisplay.setAlignmentX(LEFT_ALIGNMENT);
        choiceDisplay.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        borderLayoutPageStart.add(Box.createRigidArea(new Dimension(0, 5)));

        borderLayoutPageStart.add(choiceDisplay);

        // Adding components
        this.add(borderLayoutPageStart, BorderLayout.PAGE_START);
    }

    public void showSeances(List<Seance> seances) {

        JPanel everySeancesPanel = new JPanel();
        everySeancesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        everySeancesPanel.setLayout(new BoxLayout(everySeancesPanel, BoxLayout.PAGE_AXIS));

        seances.forEach((seance) -> { // Pour chaque séance :

            // Panel
            JPanel seancePanel = new JPanel();
            seancePanel.setLayout(new BoxLayout(seancePanel, BoxLayout.PAGE_AXIS));
            seancePanel.setPreferredSize(new Dimension(750, 55));
            seancePanel.setMaximumSize(new Dimension(1500, 55));
            seancePanel.setOpaque(true);
            seancePanel.setBackground(new Color(147, 219, 179));

            if (!Objects.equals(lastIdCours, seance.getIdCours()) || !Objects.equals(lastIdType, seance.getIdType())) {
                seancePanel.setPreferredSize(new Dimension(750, 55));

                System.out.println("-- debug : lastIdCours = " + lastIdCours + " seance.getIdCours() = " + seance.getIdCours());
                System.out.println("-- debug : lastIdType = " + lastIdType + " seance.getIdType() = " + seance.getIdType());

                JLabel dateLabel = new JLabel(" " + seance.getCours().getNom() + " (" + seance.getTypeCours().getNom() + ") ");

                dateLabel.setMinimumSize(new Dimension(1500, 30));
                dateLabel.setPreferredSize(new Dimension(1500, 30));
                dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                seancePanel.add(dateLabel);
            } else {
                seancePanel.setPreferredSize(new Dimension(750, 25));
            }

            // Infos
            JPanel infosSeance = new JPanel();
            infosSeance.setLayout(new BoxLayout(infosSeance, BoxLayout.LINE_AXIS));
            infosSeance.setBackground(new Color(230, 230, 230));
            infosSeance.setMinimumSize(new Dimension(1500, 25));
            infosSeance.setPreferredSize(new Dimension(750, 25));
            infosSeance.setMaximumSize(new Dimension(1500, 25));
            infosSeance.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Gauche
            // Date
            String date = seance.getDate().format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.FRANCE));
            JLabel dateLabel = new JLabel(" " + date + " :");
            infosSeance.add(dateLabel);

            JLabel horaires = new JLabel(seance.getHeureDebut().withSecond(00).toString() + " - " + seance.getHeureFin().withSecond(00).toString());
            horaires.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            infosSeance.add(horaires);

            infosSeance.add(Box.createHorizontalGlue());

            Enseignant ens = seance.getEnseignant();

            String nom = ens.getNom().toUpperCase();

            JLabel enseignant = new JLabel(nom);

            infosSeance.add(enseignant);

            //infosSeance.add(Box.createHorizontalGlue());
            //infosSeance.add(Box.createRigidArea(new Dimension(40, 0)));
            // Fin
            infosSeance.add(Box.createRigidArea(new Dimension(5, 0)));

            seancePanel.add(infosSeance);
            seancePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            everySeancesPanel.add(seancePanel);

            this.lastIdCours = seance.getIdCours();
            this.lastIdType = seance.getIdType();

        });

        everySeancesPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 25));

        JScrollPane scrollPanel = new JScrollPane(everySeancesPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //scrollPanel.setMinimumSize(new Dimension(2000, 2000));
        scrollPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        this.add(scrollPanel, BorderLayout.LINE_START);
    }

    /**
     * adds an ActionListener to the button1
     *
     * @param listenForButton1
     */
    public void addButton1Listener(ActionListener listenForButton1) {

        button1.addActionListener(listenForButton1);

    }

    /**
     * adds an ActionListener to the button2
     *
     * @param listenForButton2
     */
    public void addButton2Listener(ActionListener listenForButton2) {

        button2.addActionListener(listenForButton2);

    }

    /**
     * adds an ActionListener to the searchBut
     *
     * @param listenForSearchBut
     */
    public void addSearchButListener(ActionListener listenForSearchBut) {

        searchBut.addActionListener(listenForSearchBut);

    }
    
    /**
     * adds an ActionListener to the button3
     *
     * @param listenForButton3
     */
    public void addButton3Listener(ActionListener listenForButton3) {

        button3.addActionListener(listenForButton3);

    }

    /**
     * génère un popup simple
     *
     * @param message
     */
    public void popup(String message) {

        JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.PLAIN_MESSAGE);

    }

    /**
     * génère un popup de Warning
     *
     * @param message
     */
    public void popupWarning(String message) {

        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * génère un popup d'Erreur
     *
     * @param message
     */
    public void popupError(String message) {

        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);

    }

}
