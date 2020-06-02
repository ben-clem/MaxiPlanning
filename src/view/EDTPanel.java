package view;

import javax.swing.*;
import java.awt.*;
import java.time.ZonedDateTime;
import java.time.temporal.IsoFields;
import model.Seance;
import model.Utilisateur;

/**
 * classe EDTPanel (panneau emploi du temps)
 */
public final class EDTPanel extends JPanel {

    ///////////////
    // ATTRIBUTS //
    ///////////////
    private Color bg = new Color(0, 113, 121);

    //////////////
    // METHODES //
    //////////////
    /**
     * default constructor
     */
    public EDTPanel() {}
    
    /**
     * constructor
     * @param user
     */
    public EDTPanel(Utilisateur user) {
        // Background et Layout
        setLayout(new BorderLayout());

        // Border Layout Page Start
        JPanel borderLayoutPageStart = new JPanel();
        borderLayoutPageStart.setLayout(new BoxLayout(borderLayoutPageStart, BoxLayout.PAGE_AXIS));

        // Menu Bar
        JPanel menuBar = new JPanel();
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.LINE_AXIS));

        JButton button1 = new JButton("Emploi du Temps");
        button1.setMargin(new Insets(10, 0, 10, 0));
        button1.setMinimumSize(new Dimension(200, 50));
        button1.setPreferredSize(new Dimension(200, 50));
        button1.setMaximumSize(new Dimension(200, 50));
        button1.setBackground(bg);
        button1.setForeground(Color.WHITE);
        menuBar.add(button1);

        JButton button2 = new JButton("Récap Cours");
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
        JPanel choiceDisplay = new JPanel();
        choiceDisplay.setLayout(new BoxLayout(choiceDisplay, BoxLayout.LINE_AXIS));

        JLabel hello = new JLabel("  Bonjour " + user.getPrenom());
        choiceDisplay.add(hello);

        JLabel affichage = new JLabel("  -  Affichage : ");
        choiceDisplay.add(affichage);

        String[] choices = {"en liste", "en grille"};
        JComboBox choice = new JComboBox(choices);
        choice.setMaximumSize(choice.getPreferredSize());
        choiceDisplay.add(choice);

        JLabel semaine = new JLabel("  -  Semaine : ");
        choiceDisplay.add(semaine);
        
        Integer[] choices2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};
        JComboBox choice2 = new JComboBox(choices2);
        choice2.setSelectedItem(ZonedDateTime.now().get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        choice2.setMaximumSize(choice2.getPreferredSize());
        choiceDisplay.add(choice2);

        
        choiceDisplay.setAlignmentX(LEFT_ALIGNMENT);
        
        borderLayoutPageStart.add(Box.createRigidArea(new Dimension(0, 5)));
        
        borderLayoutPageStart.add(choiceDisplay);

        // Adding components
        this.add(borderLayoutPageStart, BorderLayout.PAGE_START);
    }

    
    public void showSeances(Seance[] seances) {
        
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
