package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * classe ConnectionPanel (panneau connection)
 */
public final class ConnectionPanel extends JPanel {

    // ATTRIBUTS

    private Color bg = new Color(0, 113, 121);
    
    private JLabel logoLabel;
    private JLabel titre;
    
    private JPanel connectionForm;
    private JTextField emailField;
    private JTextField passwordField;
    private JButton connButton;

    // METHODES

    /**
     * default constructor
     */
    public ConnectionPanel() {
       
        // Background et Layout
        
        setBackground(bg);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Logo
        
        try {
            Image img = ImageIO.read(getClass().getResource("img/logoECE.jpg"));
            img = img.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
            ImageIcon logo = new ImageIcon(img);
            logoLabel = new JLabel();
            logoLabel.setIcon(logo);
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        // Titre
        
        titre = new JLabel("MaxiPlanning");
        titre.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
        titre.setForeground(Color.white);
        titre.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Connection Form

        connectionForm = new JPanel();
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

        emailField = new JTextField();
        emailField.setColumns(10);
        email.add(emailField);

        email.setMaximumSize(new Dimension(500, 40));
        connectionForm.add(email);
        
        JPanel password = new JPanel();
        password.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel passwordLabel = new JLabel("password :");
        password.add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setColumns(10);
        password.add(passwordField);

        password.setMaximumSize(new Dimension(500, 40));
        connectionForm.add(password);

        connectionForm.add(Box.createRigidArea(new Dimension(0,30)));

        connButton = new JButton("Connexion");
        connButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        connectionForm.add(connButton);

        connectionForm.add(Box.createVerticalGlue());

        // Adding components
        
        this.add(logoLabel);
        this.add(titre);
        this.add(Box.createVerticalGlue());
        this.add(connectionForm);
        this.add(Box.createVerticalGlue());
   
    }
    
    /**
     * @return the email
     */
    public String getEmail(){
        
        return emailField.getText();
        
    }

    /**
     * @return the password
     */
    public String getPassword(){

        return passwordField.getText();

    }
    
    /**
     * adds an ActionListener to the ConnButton
     * @param listenForConnButton ActionListener added by the controller
     */
    public void addConnButtonListener(ActionListener listenForConnButton){

        connButton.addActionListener(listenForConnButton);
         
    }
    
    /**
     * génère un popup simple
     * @param message
     */
    public void popup(String message){
		
		JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.PLAIN_MESSAGE);
		
	}
    
    /**
     * génère un popup de Warning
     * @param message
     */
    public void popupWarning(String message){
		
		JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
		
	}
    
     /**
     * génère un popup d'Erreur
     * @param message
     */
    public void popupError(String message){
		
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		
	}

}
