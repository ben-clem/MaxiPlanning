package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * classe Enseignant couche métier
 */
public class Enseignant {

    ///////////////
    // ATTRIBUTS //
    ///////////////

    private Integer idUtilisateur;
    private List<Integer> idCours;

    ///////////////////////
    // GETTERS / SETTERS //
    ///////////////////////

    public Integer getIdUtilisateur() {
        return this.idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public List<Integer> getIdCours() {
        if (this.idCours == null) {
            this.idCours = new ArrayList<>();
        }
        return this.idCours;
    }

    public void setIdCours(List<Integer> idCours) {
        this.idCours = idCours;
    }

    //////////////
    // METHODES //
    //////////////

    /**
     * default constructor
     */
    public Enseignant() {
    }

    /**
     * base constructor (avec id et list des id de cours que donne l'enseignant (ex: id(Traitement du signal), id(VHDL))
     * Mieux : faire que Enseignant contienne une List de Cours
     * @param idUtilisateur
     * @param idCours
     */
    public Enseignant(Integer idUtilisateur, List<Integer> idCours) {
       this.idUtilisateur = idUtilisateur;
       this.idCours = idCours;
    }
    
    public Enseignant(Integer idUtilisateur) {
       this.idUtilisateur = idUtilisateur;
    }

    /**
     * ajout d'un id(Cours) à l'Enseignant
     * @param idCours 
     */
    public void addCoursID(Integer idCours) {
        this.idCours.add(idCours);
    }
    
    /**
     * ajout d'un Cours à l'Enseignant
     * @param idCours
     * @return 
     */
    public boolean addCours(Cours idCours) {
        // TODO
        return false;
    }

    public String getNom() {
        Utilisateur user = new Utilisateur();

        try {

            // Connection à la DB
            DB db = new DB();
            // On va cherche le cours correspondant
            try (Connection conn = db.connect()) {
                // On va cherche le cours correspondant
                DAO<Utilisateur> userDAO = new UtilisateurDAO(conn);
                user = userDAO.find(this.idUtilisateur);
            }
            
        } catch (SQLException e) {

            e.printStackTrace(System.err);

        }

        return user.getNom();
    }
}
