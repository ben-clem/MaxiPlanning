package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * class Etudiant couche métier
 */
public class Etudiant {

    // ATTRIBUTS

    private Integer idUtilisateur;
    private Integer numero;
    private Integer idGroupe;

    // GETTERS / SETTERS

    public Integer getIdUtilisateur() {
        return this.idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getIdGroupe() {
        return this.idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    // METHODES

    /**
     * default constructor
     */
    public Etudiant() {}

     /**
     * constructor
     * @param idUtilisateur
     * @param numero
     * @param idGroupe
     */
    public Etudiant(Integer idUtilisateur, Integer numero, Integer idGroupe) {
        this.idUtilisateur = idUtilisateur;
        this.numero = numero;
        this.idGroupe = idGroupe;
    }
    
    public Groupe getGroupe() {
        
        Groupe groupe = new Groupe();

            try {

                // Connection à la DB
                DB db = new DB();
                // On va cherche le cours correspondant
                try (Connection conn = db.connect()) {
                    // On va cherche le cours correspondant
                    DAO<Groupe> groupeDAO = new GroupeDAO(conn);
                    groupe = groupeDAO.find(this.idGroupe);
                }

            } catch (SQLException e) {

                e.printStackTrace(System.err);

            }

            return groupe;
    }
    

}
