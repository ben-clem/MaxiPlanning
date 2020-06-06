package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * classe Utilisateur couche métier
 */
public class Utilisateur {

    private Integer id;
    private Integer droit;
    private String nom = "?";
    private String prenom;
    private String email;
    private String password;

    // GETTERS / SETTERS
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDroit() {
        return this.droit;
    }

    public String getNomDroit() {

        if (null != this.droit) {
            switch (this.droit) {
                case 1:
                    return "Administrateur";
                case 2:
                    return "Professeur référent";
                case 3:
                    return "Professeur";
                case 4:
                    return "Etudiant";
                default:
                    break;
            }
        }
        return null;
    }

    public void setDroit(Integer droit) {
        this.droit = droit;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // METHODES
    /**
     * default constructor
     */
    public Utilisateur() {
    }

    /**
     * constructor
     *
     * @param id
     * @param droit
     * @param nom
     * @param prenom
     * @param email
     * @param password
     */
    public Utilisateur(Integer id, Integer droit, String nom, String prenom, String email, String password) {
        this.id = id;
        this.droit = droit;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    /**
     * renvoie l'étudiant correspondant à un utilisateur si celui ci est un
     * étudiant
     *
     * @return
     */
    public Etudiant getEtudiant() {

        if (this.droit == 4) {
            Etudiant etudiant = new Etudiant();

            try {

                // Connection à la DB
                DB db = new DB();
                // On va cherche le cours correspondant
                try (Connection conn = db.connect()) {
                    // On va cherche le cours correspondant
                    DAO<Etudiant> etudiantDAO = new EtudiantDAO(conn);
                    etudiant = etudiantDAO.find(this.id);
                }

            } catch (SQLException e) {

                e.printStackTrace(System.err);

            }

            return etudiant;
        } else {
            return null;
        }

    }

}
