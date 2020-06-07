package view;

import javax.swing.*;
import java.awt.*;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.event.ActionListener;
import java.util.Properties;
import model.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 * classe EDTPanel (panneau emploi du temps)
 */
public final class AddPanel extends JPanel {

    ///////////////
    // ATTRIBUTS //
    ///////////////
    private Color bg = new Color(0, 113, 121);

    private JButton searchBut;
    private JButton addBut;
    private JButton button3;

    private JPanel choiceDisplay;

    private JDatePickerImpl datePicker;
    private JTextField heureDebut2;
    private JTextField heureFin2;
    private JComboBox cours2;
    private JComboBox typeCours2;
    
    private JCheckBox c1;
    private JCheckBox c2;
    private JCheckBox c3;
    private JCheckBox c4;
    private JCheckBox c5;
    private JCheckBox c6;
    private JCheckBox c7;
    private JCheckBox c8;
    private JCheckBox c9;
    
    private JComboBox enseignants2;
    
    private JCheckBox s1;
    private JCheckBox s2;
    private JCheckBox s3;
    private JCheckBox s4;
    private JCheckBox s5;
    private JCheckBox s6;
    private JCheckBox s7;
    private JCheckBox s8;
    
    private JComboBox etat2;
    
    private JButton ajouterSeance;

    ///////////////////////
    // GETTERS / SETTERS //
    ///////////////////////
    
    public JDatePickerImpl getDatePicker() {
        return this.datePicker;
    }
    public JTextField getHeureDebut2() {
        return this.heureDebut2;
    }
    public JTextField getHeureFin2() {
        return this.heureFin2;
    }
    public JComboBox getCours2() {
        return this.cours2;
    }
    public JComboBox getTypeCours2() {
        return this.typeCours2;
    }
    
    public JCheckBox getC1() {
        return this.c1;
    }
    public JCheckBox getC2() {
        return this.c2;
    }
    public JCheckBox getC3() {
        return this.c3;
    }
    public JCheckBox getC4() {
        return this.c4;
    }
    public JCheckBox getC5() {
        return this.c5;
    }
    public JCheckBox getC6() {
        return this.c6;
    }
    public JCheckBox getC7() {
        return this.c7;
    }
    public JCheckBox getC8() {
        return this.c8;
    }
    public JCheckBox getC9() {
        return this.c9;
    }
    
    public JComboBox getEnseignants2() {
        return this.enseignants2;
    }
    
    public JCheckBox getS1() {
        return this.s1;
    }
    public JCheckBox getS2() {
        return this.s2;
    }
    public JCheckBox getS3() {
        return this.s3;
    }
    public JCheckBox getS4() {
        return this.s4;
    }
    public JCheckBox getS5() {
        return this.s5;
    }
    public JCheckBox getS6() {
        return this.s6;
    }
    public JCheckBox getS7() {
        return this.s7;
    }
    public JCheckBox getS8() {
        return this.s8;
    }
    
    public JComboBox getEtat2() {
        return this.etat2;
    }
    
    //////////////
    // METHODES //
    //////////////
    /**
     * default constructor
     */
    public AddPanel() {
    }

    /**
     * constructor
     *
     * @param user
     */
    public AddPanel(Utilisateur user) {

        // Background et Layout
        setLayout(new BorderLayout());

        // Border Layout Page Start
        JPanel borderLayoutPageStart = new JPanel();
        borderLayoutPageStart.setLayout(new BoxLayout(borderLayoutPageStart, BoxLayout.PAGE_AXIS));

        // Menu Bar
        JPanel menuBar = new JPanel();
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.LINE_AXIS));

        searchBut = new JButton("Rechercher");
        searchBut.setMargin(new Insets(10, 0, 10, 0));
        searchBut.setMinimumSize(new Dimension(200, 50));
        searchBut.setPreferredSize(new Dimension(200, 50));
        searchBut.setMaximumSize(new Dimension(200, 50));
        searchBut.setBackground(Color.WHITE);
        searchBut.setForeground(bg);

        menuBar.add(searchBut);

        addBut = new JButton("Ajouter");
        addBut.setMargin(new Insets(10, 0, 10, 0));
        addBut.setMinimumSize(new Dimension(200, 50));
        addBut.setPreferredSize(new Dimension(200, 50));
        addBut.setMaximumSize(new Dimension(200, 50));
        addBut.setBackground(bg);
        addBut.setForeground(Color.WHITE);

        if (user.getDroit() == 1) {
            menuBar.add(addBut);
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

        choiceDisplay.setAlignmentX(LEFT_ALIGNMENT);
        choiceDisplay.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        borderLayoutPageStart.add(Box.createRigidArea(new Dimension(0, 5)));

        borderLayoutPageStart.add(choiceDisplay);

        // Panel container
        JPanel lineStart = new JPanel();
        lineStart.setLayout(new BoxLayout(lineStart, BoxLayout.PAGE_AXIS));
        lineStart.setAlignmentX(LEFT_ALIGNMENT);
        lineStart.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Add séance
        JPanel addSeance = new JPanel();
        addSeance.setLayout(new BoxLayout(addSeance, BoxLayout.PAGE_AXIS));
        addSeance.setAlignmentX(LEFT_ALIGNMENT);
        addSeance.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addSeance.setBackground(Color.LIGHT_GRAY);

        JLabel addLabel = new JLabel("• Ajouter une séance :");
        addLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addSeance.add(addLabel);

        
        
        JPanel infosSeance = new JPanel();
        infosSeance.setLayout(new BoxLayout(infosSeance, BoxLayout.LINE_AXIS));
        infosSeance.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        infosSeance.setAlignmentX(LEFT_ALIGNMENT);
        infosSeance.setAlignmentY(TOP_ALIGNMENT);

        JPanel date = new JPanel();
        date.setLayout(new BoxLayout(date, BoxLayout.PAGE_AXIS));

        date.setAlignmentY(TOP_ALIGNMENT);
        date.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel date1 = new JLabel("Date*");
        date1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        date.add(date1);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        date.add(datePicker);

        infosSeance.add(date);

        //
        JPanel heureDebut = new JPanel();
        heureDebut.setLayout(new BoxLayout(heureDebut, BoxLayout.PAGE_AXIS));

        heureDebut.setAlignmentY(TOP_ALIGNMENT);
        heureDebut.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel heureDebut1 = new JLabel("Heure début* (hh:mm)");
        heureDebut1.setAlignmentX(CENTER_ALIGNMENT);
        heureDebut1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        heureDebut.add(heureDebut1);

        this.heureDebut2 = new JTextField();
        heureDebut2.setAlignmentX(CENTER_ALIGNMENT);
        heureDebut2.setMaximumSize(new Dimension(100, 15));

        heureDebut.add(heureDebut2);
        infosSeance.add(heureDebut);
        //

        //
        JPanel heureFin = new JPanel();
        heureFin.setLayout(new BoxLayout(heureFin, BoxLayout.PAGE_AXIS));

        heureFin.setAlignmentY(TOP_ALIGNMENT);
        heureFin.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel heureFin1 = new JLabel("Heure Fin* (hh:mm)");
        heureFin1.setAlignmentX(CENTER_ALIGNMENT);
        heureFin1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        heureFin.add(heureFin1);

        this.heureFin2 = new JTextField();
        heureFin2.setAlignmentX(CENTER_ALIGNMENT);
        heureFin2.setMaximumSize(new Dimension(100, 15));

        heureFin.add(heureFin2);
        infosSeance.add(heureFin);
        //

        //
        JPanel cours = new JPanel();
        cours.setLayout(new BoxLayout(cours, BoxLayout.PAGE_AXIS));

        cours.setAlignmentY(TOP_ALIGNMENT);
        cours.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel cours1 = new JLabel("Cours*");
        cours1.setAlignmentX(CENTER_ALIGNMENT);
        cours1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        cours.add(cours1);

        String[] listeCours = {"Analyse de Fourier", "Anglais", "Anthropologie", "Arabe", "Bases de données", "Droit du travail", "Electronique", "Electrostatique", "Ethique de l'ingénieur", "Ondes", "POO Java", "Probabilités et Statistiques", "Théorie des graphes", "Thermodynamique", "Traitement du Signal", "VHDL", "Web Dynamique"};
        this.cours2 = new JComboBox(listeCours);
        cours2.setMaximumSize(cours2.getPreferredSize());
        cours.add(cours2);

        infosSeance.add(cours);
        //

        //
        JPanel typeCours = new JPanel();
        typeCours.setLayout(new BoxLayout(typeCours, BoxLayout.PAGE_AXIS));

        typeCours.setAlignmentY(TOP_ALIGNMENT);
        typeCours.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel typeCours1 = new JLabel("Etat*");
        typeCours1.setAlignmentX(CENTER_ALIGNMENT);
        typeCours1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        typeCours.add(typeCours1);

        String[] listeTypeCours = {"Interactif", "Magistral", "TD", "TP", "Soutien", "Projet"};
        this.typeCours2 = new JComboBox(listeTypeCours);
        typeCours2.setMaximumSize(typeCours2.getPreferredSize());
        typeCours.add(typeCours2);

        infosSeance.add(typeCours);
        //

        //groupes
        JPanel groupes = new JPanel();
        groupes.setLayout(new BoxLayout(groupes, BoxLayout.PAGE_AXIS));

        groupes.setAlignmentY(TOP_ALIGNMENT);
        groupes.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel groupes1 = new JLabel("Groupe(s)");
        groupes1.setAlignmentX(CENTER_ALIGNMENT);
        groupes1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        groupes.add(groupes1);

        String[] listeGroupes = {"Ing1 Gr01", "Ing1 Gr02", "Ing1 Gr03", "Ing2 Gr01", "Ing2 Gr02", "Ing2 Gr03", "Ing3 Gr01", "Ing3 Gr02", "Ing3 Gr03"};

        JPanel groupes2Panel = new JPanel();
        groupes2Panel.setLayout(new BoxLayout(groupes2Panel, BoxLayout.PAGE_AXIS));

        // Chaque checkbox (c1)
        JPanel c1Pan = new JPanel();
        c1Pan.setLayout(new BoxLayout(c1Pan, BoxLayout.LINE_AXIS));

        this.c1 = new JCheckBox();
        c1Pan.add(c1);
        JLabel c1Lab = new JLabel(listeGroupes[0]);
        c1Pan.add(c1Lab);
        
        groupes2Panel.add(c1Pan);
        //fin checkbox
        // Chaque checkbox (c2)
        JPanel c2Pan = new JPanel();
        c2Pan.setLayout(new BoxLayout(c2Pan, BoxLayout.LINE_AXIS));

        this.c2 = new JCheckBox();
        c2Pan.add(c2);
        JLabel c2Lab = new JLabel(listeGroupes[1]);
        c2Pan.add(c2Lab);
        
        groupes2Panel.add(c2Pan);
        //fin checkbox
        // Chaque checkbox (c3)
        JPanel c3Pan = new JPanel();
        c3Pan.setLayout(new BoxLayout(c3Pan, BoxLayout.LINE_AXIS));

        this.c3 = new JCheckBox();
        c3Pan.add(c3);
        JLabel c3Lab = new JLabel(listeGroupes[2]);
        c3Pan.add(c3Lab);
        
        groupes2Panel.add(c3Pan);
        //fin checkbox
        // Chaque checkbox (c4)
        JPanel c4Pan = new JPanel();
        c4Pan.setLayout(new BoxLayout(c4Pan, BoxLayout.LINE_AXIS));

        this.c4 = new JCheckBox();
        c4Pan.add(c4);
        JLabel c4Lab = new JLabel(listeGroupes[3]);
        c4Pan.add(c4Lab);
        
        groupes2Panel.add(c4Pan);
        //fin checkbox
        // Chaque checkbox (c5)
        JPanel c5Pan = new JPanel();
        c5Pan.setLayout(new BoxLayout(c5Pan, BoxLayout.LINE_AXIS));

        this.c5 = new JCheckBox();
        c5Pan.add(c5);
        JLabel c5Lab = new JLabel(listeGroupes[4]);
        c5Pan.add(c5Lab);
        
        groupes2Panel.add(c5Pan);
        //fin checkbox
        // Chaque checkbox (c6)
        JPanel c6Pan = new JPanel();
        c6Pan.setLayout(new BoxLayout(c6Pan, BoxLayout.LINE_AXIS));

        this.c6 = new JCheckBox();
        c6Pan.add(c6);
        JLabel c6Lab = new JLabel(listeGroupes[5]);
        c6Pan.add(c6Lab);
        
        groupes2Panel.add(c6Pan);
        //fin checkbox
        // Chaque checkbox (c7)
        JPanel c7Pan = new JPanel();
        c7Pan.setLayout(new BoxLayout(c7Pan, BoxLayout.LINE_AXIS));

        this.c7 = new JCheckBox();
        c7Pan.add(c7);
        JLabel c7Lab = new JLabel(listeGroupes[6]);
        c7Pan.add(c7Lab);
        
        groupes2Panel.add(c7Pan);
        //fin checkbox
        // Chaque checkbox (c8)
        JPanel c8Pan = new JPanel();
        c8Pan.setLayout(new BoxLayout(c8Pan, BoxLayout.LINE_AXIS));

        this.c8 = new JCheckBox();
        c8Pan.add(c8);
        JLabel c8Lab = new JLabel(listeGroupes[7]);
        c8Pan.add(c8Lab);
        
        groupes2Panel.add(c8Pan);
        //fin checkbox
        // Chaque checkbox (c9)
        JPanel c9Pan = new JPanel();
        c9Pan.setLayout(new BoxLayout(c9Pan, BoxLayout.LINE_AXIS));

        this.c9 = new JCheckBox();
        c9Pan.add(c9);
        JLabel c9Lab = new JLabel(listeGroupes[8]);
        c9Pan.add(c9Lab);
        
        groupes2Panel.add(c9Pan);
        //fin checkbox
        
        groupes.add(groupes2Panel);
        
        infosSeance.add(groupes);
        //

        // Enseignants
        JPanel enseignants = new JPanel();
        enseignants.setLayout(new BoxLayout(enseignants, BoxLayout.PAGE_AXIS));

        enseignants.setAlignmentY(TOP_ALIGNMENT);
        enseignants.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel enseignants1 = new JLabel("Enseignant");
        enseignants1.setAlignmentX(CENTER_ALIGNMENT);
        enseignants1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        enseignants.add(enseignants1);

        String[] listeEnseignants = {"Coudray", "Crambes", "Mouhali", "Maupile", "Bennani", "Rendler", "Falih", "Mokhber", "Professeur", "Test", "Ferdeghini", "Girinsky", "Reese", "Luxereau"};
        this.enseignants2 = new JComboBox(listeEnseignants);
        enseignants2.setMaximumSize(enseignants2.getPreferredSize());
        enseignants.add(enseignants2);

        infosSeance.add(enseignants);
        //
        
        //salles
        JPanel salles = new JPanel();
        salles.setLayout(new BoxLayout(salles, BoxLayout.PAGE_AXIS));

        salles.setAlignmentY(TOP_ALIGNMENT);
        salles.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel salles1 = new JLabel("Salle(s)");
        salles1.setAlignmentX(CENTER_ALIGNMENT);
        salles1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        salles.add(salles1);

        String[] listeSalles = {"E1 - EM010", "E1 - EM011", "E1 - SC001", "E1 - SC002", "E2 - P304", "E2 - P305", "E3 - C201", "E3 - C202"};

        JPanel salles2Panel = new JPanel();
        salles2Panel.setLayout(new BoxLayout(salles2Panel, BoxLayout.PAGE_AXIS));

        // Chaque sheskbox (s1)
        JPanel s1Pan = new JPanel();
        s1Pan.setLayout(new BoxLayout(s1Pan, BoxLayout.LINE_AXIS));

        this.s1 = new JCheckBox();
        s1Pan.add(s1);
        JLabel s1Lab = new JLabel(listeSalles[0]);
        s1Pan.add(s1Lab);
        
        salles2Panel.add(s1Pan);
        //fin sheskbox
        // Chaque sheskbox (s2)
        JPanel s2Pan = new JPanel();
        s2Pan.setLayout(new BoxLayout(s2Pan, BoxLayout.LINE_AXIS));

        this.s2 = new JCheckBox();
        s2Pan.add(s2);
        JLabel s2Lab = new JLabel(listeSalles[1]);
        s2Pan.add(s2Lab);
        
        salles2Panel.add(s2Pan);
        //fin sheskbox
        // Chaque sheskbox (s3)
        JPanel s3Pan = new JPanel();
        s3Pan.setLayout(new BoxLayout(s3Pan, BoxLayout.LINE_AXIS));

        this.s3 = new JCheckBox();
        s3Pan.add(s3);
        JLabel s3Lab = new JLabel(listeSalles[2]);
        s3Pan.add(s3Lab);
        
        salles2Panel.add(s3Pan);
        //fin sheskbox
        // Chaque sheskbox (s4)
        JPanel s4Pan = new JPanel();
        s4Pan.setLayout(new BoxLayout(s4Pan, BoxLayout.LINE_AXIS));

        this.s4 = new JCheckBox();
        s4Pan.add(s4);
        JLabel s4Lab = new JLabel(listeSalles[3]);
        s4Pan.add(s4Lab);
        
        salles2Panel.add(s4Pan);
        //fin sheskbox
        // Chaque sheskbox (s5)
        JPanel s5Pan = new JPanel();
        s5Pan.setLayout(new BoxLayout(s5Pan, BoxLayout.LINE_AXIS));

        this.s5 = new JCheckBox();
        s5Pan.add(s5);
        JLabel s5Lab = new JLabel(listeSalles[4]);
        s5Pan.add(s5Lab);
        
        salles2Panel.add(s5Pan);
        //fin sheskbox
        // Chaque sheskbox (s6)
        JPanel s6Pan = new JPanel();
        s6Pan.setLayout(new BoxLayout(s6Pan, BoxLayout.LINE_AXIS));

        this.s6 = new JCheckBox();
        s6Pan.add(s6);
        JLabel s6Lab = new JLabel(listeSalles[5]);
        s6Pan.add(s6Lab);
        
        salles2Panel.add(s6Pan);
        //fin sheskbox
        // Chaque sheskbox (s7)
        JPanel s7Pan = new JPanel();
        s7Pan.setLayout(new BoxLayout(s7Pan, BoxLayout.LINE_AXIS));

        this.s7 = new JCheckBox();
        s7Pan.add(s7);
        JLabel s7Lab = new JLabel(listeSalles[6]);
        s7Pan.add(s7Lab);
        
        salles2Panel.add(s7Pan);
        //fin sheskbox
        // Chaque sheskbox (s8)
        JPanel s8Pan = new JPanel();
        s8Pan.setLayout(new BoxLayout(s8Pan, BoxLayout.LINE_AXIS));

        this.s8 = new JCheckBox();
        s8Pan.add(s8);
        JLabel s8Lab = new JLabel(listeSalles[7]);
        s8Pan.add(s8Lab);
        
        salles2Panel.add(s8Pan);
        //fin sheskbox
        
        
        salles.add(salles2Panel);
        
        infosSeance.add(salles);
        //
        
        //état
        JPanel etat = new JPanel();
        etat.setLayout(new BoxLayout(etat, BoxLayout.PAGE_AXIS));

        etat.setAlignmentY(TOP_ALIGNMENT);
        etat.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel etat1 = new JLabel("Type*");
        etat1.setAlignmentX(CENTER_ALIGNMENT);
        etat1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        etat.add(etat1);

        String[] listeEtat = {"Validée", "En cours de validation"};
        this.etat2 = new JComboBox(listeEtat);
        etat2.setMaximumSize(etat2.getPreferredSize());
        etat.add(etat2);

        infosSeance.add(etat);
        //
        
        addSeance.add(infosSeance);
        
        
        
        ajouterSeance = new JButton("Ajouter la séance");
        ajouterSeance.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        addSeance.add(ajouterSeance);

        lineStart.add(addSeance);
        
        // Adding components
        this.add(borderLayoutPageStart, BorderLayout.PAGE_START);
        this.add(lineStart, BorderLayout.LINE_START);
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
     * adds an ActionListener to the addBut
     *
     * @param listenForAddBut
     */
    public void addAddButListener(ActionListener listenForAddBut) {

        addBut.addActionListener(listenForAddBut);

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
     * adds an ActionListener to ajouterSeance
     *
     * @param listenForAjouterSeance
     */
    public void addAjouterSeanceListener(ActionListener listenForAjouterSeance) {

        ajouterSeance.addActionListener(listenForAjouterSeance);

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
