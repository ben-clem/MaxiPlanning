package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import model.*;

/**
 * classe EDTPanel (panneau emploi du temps)
 */
public final class EDTPanel extends JPanel {

    ///////////////
    // ATTRIBUTS //
    ///////////////
    private Color bg = new Color(0, 113, 121);
    private String lastDate;
    private JButton button1;
    private JButton button2;
    private JComboBox choice;
    private JComboBox choice2;
    private Integer semaine;
    private JPanel choiceDisplay;

    //////////////
    // METHODES //
    //////////////
    /**
     * default constructor
     */
    public EDTPanel() {
    }

    /**
     * constructor
     *
     * @param user
     * @param semaine
     */
    public EDTPanel(Utilisateur user, Integer semaine) {

        this.semaine = semaine;

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
        button1.setBackground(bg);
        button1.setForeground(Color.WHITE);
        menuBar.add(button1);

        button2 = new JButton("Récap Cours");
        button2.setMargin(new Insets(10, 0, 10, 0));
        button1.setMinimumSize(new Dimension(200, 50));
        button2.setPreferredSize(new Dimension(200, 50));
        button2.setMaximumSize(new Dimension(200, 50));
        button2.setBackground(Color.WHITE);
        button2.setForeground(bg);
        menuBar.add(button2);

        menuBar.setAlignmentX(LEFT_ALIGNMENT);
        borderLayoutPageStart.add(menuBar);

        // Choice Display
        choiceDisplay = new JPanel();
        choiceDisplay.setLayout(new BoxLayout(choiceDisplay, BoxLayout.LINE_AXIS));

        JLabel hello = new JLabel("  Bonjour " + user.getPrenom()
                + " (" + user.getNomDroit() + ") ");
        choiceDisplay.add(hello);

        if (user.getDroit() == 4) { // si c'est un étudiant :
            Etudiant student = user.getEtudiant();

            JLabel promoGroupe = new JLabel(" -  " + student.getGroupe().getPromoName() + " " + student.getGroupe().getNom());

            choiceDisplay.add(promoGroupe);
        }

        JLabel affichage = new JLabel("  -  Affichage : ");
        choiceDisplay.add(affichage);

        String[] choices = {"en liste", "en grille"};
        this.choice = new JComboBox(choices);
        choice.setMaximumSize(choice.getPreferredSize());
        choiceDisplay.add(choice);

        JLabel semaineLabel = new JLabel("  -  Semaine : ");
        choiceDisplay.add(semaineLabel);

        Integer[] choices2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};
        this.choice2 = new JComboBox(choices2);
        choice2.setSelectedItem(semaine);
        choice2.setMaximumSize(choice2.getPreferredSize());
        choiceDisplay.add(choice2);

        choiceDisplay.setAlignmentX(LEFT_ALIGNMENT);

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

            if (Objects.equals(seance.getSemaine(), this.semaine)) {

                // Panel
                JPanel seancePanel = new JPanel();
                seancePanel.setLayout(new BoxLayout(seancePanel, BoxLayout.PAGE_AXIS));
                seancePanel.setPreferredSize(new Dimension(750, 50));
                seancePanel.setMaximumSize(new Dimension(1500, 100));
                seancePanel.setOpaque(true);
                seancePanel.setBackground(new Color(147, 219, 179));

                // Date
                String date = seance.getDate().format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.FRANCE));

                if (lastDate == null ? date != null : !lastDate.equals(date)) {
                    seancePanel.setPreferredSize(new Dimension(750, 80));

                    JLabel dateLabel = new JLabel(" " + date);
//            date.setOpaque(true);
//            date.setBackground(Color.GREEN);
                    dateLabel.setMinimumSize(new Dimension(1500, 30));
                    dateLabel.setPreferredSize(new Dimension(1500, 30));
                    dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    seancePanel.add(dateLabel);
                } else {
                    seancePanel.setMaximumSize(new Dimension(1500, 80));
                }

                // Infos
                JPanel infosSeance = new JPanel();
                infosSeance.setLayout(new BoxLayout(infosSeance, BoxLayout.LINE_AXIS));
                infosSeance.setBackground(new Color(230, 230, 230));
                infosSeance.setMinimumSize(new Dimension(1500, 50));
                infosSeance.setPreferredSize(new Dimension(750, 50));
                infosSeance.setMaximumSize(new Dimension(1500, 100));
                infosSeance.setAlignmentX(Component.LEFT_ALIGNMENT);

                // Gauche
                JLabel horaires = new JLabel(seance.getHeureDebut().withSecond(00).toString() + " - " + seance.getHeureFin().withSecond(00).toString() + "  :");
                horaires.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                infosSeance.add(horaires);

                JLabel nomTypeCours = new JLabel(seance.getCours().getNom() + " (" + seance.getTypeCours().getNom() + ")");
                nomTypeCours.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
                infosSeance.add(nomTypeCours);

                //infosSeance.add(Box.createRigidArea(new Dimension(40, 0)));
                //infosSeance.add(Box.createHorizontalGlue());
                System.out.println("-debug- " + seance.getEnseignant());
                System.out.println("-debug- " + seance.getEnseignant().getNom());

                Enseignant ens = seance.getEnseignant();
                System.out.println("-debug- ens : " + ens);

                String nom = ens.getNom().toUpperCase();
                System.out.println("-debug- nom : " + nom);

                JLabel enseignant = new JLabel("  -  " + nom);

                infosSeance.add(enseignant);

                infosSeance.add(Box.createHorizontalGlue());

                // Droite
                //salles
                JPanel sallesPanel = new JPanel();
                sallesPanel.setLayout(new BoxLayout(sallesPanel, BoxLayout.PAGE_AXIS));

                List<Salle> salles = seance.getSalles();
                salles.forEach((salle) -> {

                    //System.out.println("-debug- " + salle.getNom());
                    //System.out.println("-debug- " + salle.getSite().getNom());
                    JLabel salleLabel = new JLabel(salle.getSite().getNom() + " - " + salle.getNom() + " (" + salle.getCapacite() + ")");
                    sallesPanel.add(salleLabel);

                });

                infosSeance.add(sallesPanel);
                infosSeance.add(Box.createRigidArea(new Dimension(40, 0)));

                //groupes
                JPanel groupesPanel = new JPanel();
                groupesPanel.setLayout(new BoxLayout(groupesPanel, BoxLayout.PAGE_AXIS));

                List<Groupe> groupes = seance.getGroupes();
                groupes.forEach((groupe) -> {

                    JLabel groupeLabel = new JLabel(groupe.getPromoName() + " " + groupe.getNom());
                    groupesPanel.add(groupeLabel);

                });

                infosSeance.add(groupesPanel);

                // Fin
                infosSeance.add(Box.createRigidArea(new Dimension(5, 0)));

                seancePanel.add(infosSeance);
                seancePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

                everySeancesPanel.add(seancePanel);

                this.lastDate = date;
            } else {

            }
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
     * adds an ActionListener to the JComboBox choiche
     *
     * @param listenForChoice
     */
    public void addChoiceListener(ActionListener listenForChoice) {

        choice2.addActionListener(listenForChoice);

    }

    /**
     * adds an ActionListener to the JComboBox choiche2
     *
     * @param listenForChoice2
     */
    public void addChoice2Listener(ActionListener listenForChoice2) {

        choice2.addActionListener(listenForChoice2);

    }

    public void removeChoice2() {

        choiceDisplay.remove(choice2);

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
