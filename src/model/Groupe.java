package model;

/**
 * classe Groupe couche métier
 */
public class Groupe {

    // ATTRIBUTS

    private Integer id;
    private String nom;
    private Integer idPromotion;

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

    public Integer getIdPromotion() {
        return this.idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    // METHODES

    /**
     * default constructor
     */
    public Groupe() {}

    /**
     * constructor
     */
    public Groupe(Integer id, String nom, Integer idPromotion) {
        // TODO
    }

}
