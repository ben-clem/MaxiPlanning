package view;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Miriam Benallou - Benoît Clemenceau - Kim Zaatar
 */
public final class Grille extends JFrame {
    private JPanel GridContainer ;
    public Grille () {
        //paramétrage fenêtre
        super();
        setTitle("Emploi du temps"); 
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setSize(1600, 1000); // taille fenêtre
        setLocationRelativeTo(null); // centre écran
        JPanel GridContainer = new JPanel();
        GridContainer.setBackground(Color.white);
        GridContainer.add(AfficherGrille(), BorderLayout.CENTER);
        this.setContentPane(GridContainer);
        this.setVisible(true);
       
    }
    
    
    public JPanel AfficherGrille()
    {
        JPanel grille = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        grille.setBorder(BorderFactory.createLineBorder(Color.gray,1));
        constraints.ipadx = 80; // padding en x et y 
        constraints.ipady = 3;
        constraints.gridheight = 1; // hauteur et largeur
        constraints.gridwidth = 1;
        constraints.gridx = 0; // coordonnées x et y 
        constraints.gridy = 0;
        //constraints.weightx=2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 1, 0, 1); // Padding.
        
        for(int h = 0; h < 8; h++) //hour et weekday
        {
            for(int wd = 0; wd < 7; wd++)
            {
                if(h == 0 && wd != 0) // coordonnées 0 et pas dimanche 
                {
                    JLabel day, espace;
                    JPanel course = new JPanel();
                    course.setBackground(Color.cyan);
                    course.setBorder(BorderFactory.createLineBorder(Color.gray,1));
                    
                    
                    if (wd==1){
                          day = new JLabel("Monday");
                          espace = new JLabel(" ");
                    }
                    else if (wd==2){
                        day = new JLabel("Tuesday");
                            espace = new JLabel(" ");
                    }
                    else if (wd==3){
                          day = new JLabel("Wednesday");
                          espace = new JLabel(" ");
                    }
                    else if (wd==4){
                          day = new JLabel("Thursday");
                          espace = new JLabel(" ");
                    }
                    else if (wd==5){
                          day = new JLabel("Friday");
                          espace = new JLabel(" ");
                    }
                    else if (wd==6){
                          day = new JLabel("Saturday");
                          espace = new JLabel(" ");
                    }
                    else {
                        day = new JLabel("");
                        espace = new JLabel(" ");
                           
                    }
                   
                    constraints.gridx = wd;
                    constraints.gridy = h;
                    course.add(day);
                    course.add(espace);
                    grille.add(course, constraints);
                    
                }
                else
                {
                    if( wd == 0)
                    {
                        JLabel heure;
                        JPanel course = new JPanel();
                        
                        if (h==1){
                             heure = new JLabel("08:30-10:00");
                        }
                        else if (h==2){
                            heure = new JLabel("10:15-11:45");
                        }
                        else if (h==3){
                            heure = new JLabel("12:00-13:30");
                        }
                        else if (h==4){
                            heure = new JLabel("13:45-15:15");
                        }
                        else if (h==5){
                            heure = new JLabel("15:30-17:00");
                        }
                        else if (h==6){
                            heure = new JLabel("17:15-18:45");
                        }
                        else if (h==7){
                            heure = new JLabel("19:00-20:30");
                        }
                        else {
                            heure = new JLabel("");
                        }
                        
                     
                        
                        constraints.gridx = wd;
                        constraints.gridy = h;
                        course.add(heure);
                        grille.add(course, constraints);
                    }
                    else
                    {
                        JPanel course = new JPanel(new GridBagLayout());
                        GridBagConstraints coc = new GridBagConstraints(); // coc : constraints on cell, un GBL dans un autre
                        
                        course.setBackground(Color.orange);
                        course.setBorder(BorderFactory.createLineBorder(Color.gray,1));
                        JLabel espaceHaut = new JLabel(" ");
                        JLabel NomCours = new JLabel("Analyse de Fourier");
                        JLabel prof = new JLabel("Mme. Coudray");
                        JLabel salle = new JLabel("EM 010");
                        JLabel type = new JLabel("CI");
                        JLabel grp = new JLabel("Grp 10 - 11");
                        JLabel espaceBas = new JLabel(" ");
                    
                        constraints.gridx = wd;
                        constraints.gridy = h;
                        
                        // coc.insets = new Insets(2, 2, 2, 2); // Padding.
                        
                        coc.gridy = 0;
                        course.add(espaceHaut, coc);
                        coc.gridy = 1;
                        course.add(NomCours, coc);
                        coc.gridy = 2;
                        course.add(salle, coc);
                        coc.gridy = 3;
                        course.add(prof, coc);
                        coc.gridy = 4;
                        course.add(type, coc);
                        coc.gridy = 5;
                        course.add(grp, coc);
                        coc.gridy = 6;
                        course.add(espaceBas, coc);
                        
                       

                        grille.add(course, constraints);
                    }
                }
            }
        }
        return grille; //
    }
}



    