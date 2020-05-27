package model;

/**
 * classe Salle couche métier
 */
public class Salle {

    // ATTRIBUTS

    private Integer id;
    private String nom;
    private Integer capacite;
    private Integer idSite;

    // GETTERS / SETTERS

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapacite() {
        return this.capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Integer getIdSite() {
        return this.idSite;
    }

    public void setIdSite(Integer idSite) {
        this.idSite = idSite;
    }

    // METHODES

    /**
     * default constructor
     */
    public Salle() {}

    /**
     * constructor
     */
    public Salle(Integer id, String nom, Integer capacite, Integer idSite) {
        // TODO
    }

}
