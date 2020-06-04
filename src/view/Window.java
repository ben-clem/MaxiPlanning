package view;

import javax.swing.*;

/**
 * classe Window (fenêtre de base de l'application)
 */
public class Window extends JFrame {

    //////////////
    // METHODES //
    //////////////
    /**
     * default constructor
     */
    public Window() {

        initWindow();

    }

    /**
     * initialisation de la fenêtre
     */
    public final void initWindow() {

        setTitle("MaxiPlanning");
        setSize(960, 540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
