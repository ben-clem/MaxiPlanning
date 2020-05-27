package model;

/**
 * classe Utilisateur couche métier
 */
public class Utilisateur {

    private Integer id;
    private Integer droit;
    private String nom;
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
    public Utilisateur() {}

    /**
     * constructor
     */
    public Utilisateur(Integer id, Integer droit, String nom, String prenom, String email, String password) {
        // TODO
    }

}
