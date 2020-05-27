package view;

import javax.swing.*;

/**
 * classe Window (fenêtre de base de l'application)
 */
public class Window extends JFrame {

    // ATTRIBUTS

    private JMenuBar menuBar;
    private JPanel panel;

    // METHODES

    /**
     * default constructor
     */
    public Window() {
        
        initWindow();
        
    }

    /**
     * constructor
     * @param menuBar
     * @param panel
     */
    public Window(JMenuBar menuBar, JPanel panel) {
        this.menuBar = menuBar;
        this.panel = panel;
    }
    
    /**
     * initialisation de la fenêtre
     */
    public final void initWindow() {
        
        setTitle("MaxiPlanning");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}
