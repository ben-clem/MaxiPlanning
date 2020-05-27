package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * classe ConnectionPanel (panneau connection) test
 */
public class ConnectionPanel extends JPanel {

    // ATTRIBUTS

    Color bg = new Color(0, 113, 121);

    // METHODES

    /**
     * default constructor
     */
    public ConnectionPanel() {

        initPanel();
   
    }
    
    /**
     * initialisation
     */
    public final void initPanel() {
        
        setBackground(bg);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        try {
            Image img = ImageIO.read(getClass().getResource("img/logoECE.jpg"));
            img = img.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
            ImageIcon logo = new ImageIcon(img);
            JLabel logoLabel = new JLabel(logo);
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            add(logoLabel);

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        JLabel titre = new JLabel("MaxiPlanning");
        titre.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
        titre.setForeground(Color.white);
        titre.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titre);

        add(Box.createVerticalGlue());

        // Connection Form

        JPanel connectionForm = new JPanel();
        connectionForm.setLayout(new BoxLayout(connectionForm, BoxLayout.PAGE_AXIS));
        connectionForm.setBorder(BorderFactory.createLineBorder(Color.white, 1));

        JLabel conLabel = new JLabel("Connexion");
        conLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        conLabel.setForeground(bg);
        conLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        conLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        connectionForm.add(conLabel);

        connectionForm.add(Box.createVerticalGlue());

        JPanel email = new JPanel();
        email.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel emailLabel = new JLabel("email :");
        email.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setColumns(10);
        email.add(emailField);

        email.setMaximumSize(new Dimension(500, 40));
        connectionForm.add(email);

        
        JPanel password = new JPanel();
        password.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel passwordLabel = new JLabel("password :");
        password.add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setColumns(10);
        password.add(passwordField);

        password.setMaximumSize(new Dimension(500, 40));
        connectionForm.add(password);

        connectionForm.add(Box.createRigidArea(new Dimension(0,30)));

        JButton connButton = new JButton("Connexion");
        connButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // /* ACTION LISTENER */
        connectionForm.add(connButton);

        connectionForm.add(Box.createVerticalGlue());

        add(connectionForm);

        // Fin Connection Form

        add(Box.createVerticalGlue());
        
    }
   
}
